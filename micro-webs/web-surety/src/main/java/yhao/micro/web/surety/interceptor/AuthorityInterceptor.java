package yhao.micro.web.surety.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import yhao.infra.common.cache.RedisCache;
import yhao.infra.web.bean.JsonCommonCodeEnum;
import yhao.infra.web.interceptor.ZBaseInterceptorAdapter;
import yhao.micro.service.constants.annotations.AuthorityAnnotation;
import yhao.micro.service.constants.enums.AuthorityAnnotationEnums;
import yhao.micro.service.constants.enums.ConstantsCacheKey;
import yhao.micro.service.surety.erp.auth.login.apilist.form.AuthLoginForm;
import yhao.micro.service.surety.erp.auth.login.apilist.model.LoginPersonModel;
import yhao.micro.service.surety.erp.auth.login.apilist.model.LoginPersonResponse;
import yhao.micro.service.surety.erp.auth.apilist.constants.ErpAuthConstants;
import yhao.micro.web.surety.remote.erp.org.PersonRemote;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

/**
 * @author yoara
 */
public class AuthorityInterceptor extends ZBaseInterceptorAdapter {
    private Logger visitLog = LoggerFactory.getLogger(this.getClass());
    private RedisCache redisCache;
    private PersonRemote personRemote;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        try {
            //仅校验方法级别的Handler
            if (!(handler instanceof HandlerMethod)) {
                return super.preHandle(request, response, handler);
            }
            AuthorityAnnotation auth = getAnnotation((HandlerMethod) handler);

            ResponseBody body = new ResponseBody();
            body.setLoginUrl(getLoginUrl(request));
            switch (checkHasAuth(request, auth)) {
                case SUCCESS:
                    return super.preHandle(request, response, handler);
                case NO_AUTH:
                    body.setCode(JsonCommonCodeEnum.E0007);
                    printJsonMsg(response, body);
                    return false;
                default:
                    body.setCode(JsonCommonCodeEnum.E0008);
                    printJsonMsg(response, body);
                    return false;
            }
        } catch (Exception e) {
            visitLog.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage());
        }
    }


    private String getLoginUrl(HttpServletRequest request) {
        return "/login.html";
    }

    /**
     * 设置注解值
     **/
    private AuthorityAnnotation getAnnotation(HandlerMethod handler) {
        AuthorityAnnotation annotation =
                handler.getClass().getAnnotation(AuthorityAnnotation.class);
        AuthorityAnnotation methodAnnotation =
                handler.getMethod().getAnnotation(AuthorityAnnotation.class);
        return methodAnnotation == null ? annotation : methodAnnotation;
    }

    /**
     * 验证当前用户是否有权限
     *
     * @return
     */
    private AuthCheckResult checkHasAuth(HttpServletRequest request, AuthorityAnnotation auth) {
        LoginPersonModel object = (LoginPersonModel) request.getSession().getAttribute(ErpAuthConstants.CURRENT_LOGIN_PERSON);
        if (object == null) {//用户未登录
            return AuthCheckResult.NO_LOGIN;
        }
        if (personInfoUpdate(request, object)) {//用户信息更新，需要重新登陆
            return AuthCheckResult.INVALID;
        }
        if (object.isAdmin()) {//超级管理员，直接拥有权限
            return AuthCheckResult.SUCCESS;
        }
        if (hasAuth(object, auth)) {//用户拥有权限
            return AuthCheckResult.SUCCESS;
        }
        return AuthCheckResult.NO_AUTH;
    }

    private boolean hasAuth(LoginPersonModel object, AuthorityAnnotation auth) {
        Set<String> authSet = object.getCurrentAuthMap();
        if (authSet != null) {
            for (AuthorityAnnotationEnums authEnum : auth.value()) {
                if (authSet.contains(authEnum.name())) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean personInfoUpdate(HttpServletRequest request, LoginPersonModel object) {
        initSessionResource(request);

        if (redisCache.getHash(ConstantsCacheKey.MGR_SESSION_REFRESH,
                object.getId(), request.getSession().getId()) != null) {//用户信息没有更新
            return false;
        }

        //用户信息更新了
        AuthLoginForm form = new AuthLoginForm();
        form.setUserName(object.getPhone());
        LoginPersonResponse response = personRemote.authenticatePersonNoPsw(form);
        if (!response.isSuccess()) {//登陆失败，说明用户信息更新了
            return true;
        }

        LoginPersonModel personModel = response.getModel();
        if (personModel.getUpdateTime() != null && object.getUpdateTime() != null &&
                personModel.getUpdateTime().after(object.getUpdateTime())) {//更新时间修改了，说明用户信息更新了
            return true;
        }

        redisCache.putHash(ConstantsCacheKey.MGR_SESSION_REFRESH,
                object.getId(), request.getSession().getId(), true, 30 * 60);

        return false;
    }

    private enum AuthCheckResult {
        SUCCESS,
        NO_LOGIN,
        NO_AUTH,
        INVALID
    }

    private void initSessionResource(HttpServletRequest request) {
        if (redisCache == null) {
            ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
            redisCache = ctx.getBean(RedisCache.class);
        }
        if (personRemote == null) {
            ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
            personRemote = ctx.getBean(PersonRemote.class);
        }
    }
}
