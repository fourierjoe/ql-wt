package yhao.micro.web.surety.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import yhao.infra.web.interceptor.ZBaseInterceptorAdapter;
import yhao.micro.service.surety.erp.auth.login.apilist.form.AuthLoginForm;
import yhao.micro.service.surety.erp.auth.login.apilist.model.LoginPersonModel;
import yhao.micro.service.surety.erp.auth.login.apilist.model.LoginPersonResponse;
import yhao.micro.service.surety.erp.auth.apilist.constants.ErpAuthConstants;
import yhao.micro.web.surety.remote.erp.org.PersonRemote;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Swagger 拦截器
 */
public class SwaggerLoginInterceptor extends ZBaseInterceptorAdapter {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public boolean preHandle(HttpServletRequest request,
							 HttpServletResponse response, Object handler) throws Exception {
		String referer = request.getHeader("Referer");
		if(referer!=null && referer.contains("192.168.0.131")){
			try {
				ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
				PersonRemote personRemote = (PersonRemote)ctx.getBean("personRemote");
				AuthLoginForm form = new AuthLoginForm();
				String userName = referer.substring(referer.lastIndexOf("=")+1);
				form.setUserName(userName.trim());
				form.setPassword("1");
				LoginPersonResponse loginResponse = personRemote.authenticatePerson(form);
				if(loginResponse.isSuccess()){
					LoginPersonModel manager = loginResponse.getModel();
					request.getSession().setAttribute(ErpAuthConstants.CURRENT_LOGIN_PERSON, manager);
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}
		return super.preHandle(request, response, handler);
	}
}
