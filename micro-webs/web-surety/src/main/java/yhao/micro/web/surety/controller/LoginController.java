package yhao.micro.web.surety.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import yhao.micro.service.surety.erp.auth.login.apilist.form.AuthLoginForm;
import yhao.micro.service.surety.erp.auth.login.apilist.model.LoginPersonModel;
import yhao.micro.web.surety.remote.erp.org.PersonRemote;
import yhao.micro.service.surety.erp.auth.apilist.constants.ErpAuthConstants;
import yhao.micro.service.surety.erp.auth.apilist.enums.ErpReturnCodeEnum;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yhao.micro.service.surety.erp.auth.login.apilist.model.LoginPersonResponse;

import javax.annotation.Resource;

/**
 * Created by yoara on 2016/3/3.
 */
@Lazy
@RestController
@RequestMapping(value = "/login",produces = {"application/json;charset=UTF-8"})
@Api(value = "LoginController", tags = "系统设置-登录登出")
public class LoginController extends WebBaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private PersonRemote personRemote;

    @GetMapping(value = "login")
    @ApiOperation(value = "登录")
    @ApiResponses({
            @ApiResponse(code = 200, response = LoginPersonModel.class, message = "登录人员的信息")
    })
    public String loginIn(AuthLoginForm form) {
        LoginPersonResponse response = personRemote.authenticatePerson(form);
        if(!response.isSuccess()){
            return returnWithCustomMessage(response.getErrMessage(),ErpReturnCodeEnum.F1000);
        }

        logger.info("[LOGIN]用户登录:"+form.getUserName());
        getRequest().getSession().setAttribute(ErpAuthConstants.CURRENT_LOGIN_PERSON, response.getModel());

        return returnSuccessInfo(response.getModel());
    }

    @GetMapping(value = "logOut")
    @ApiOperation(value = "登出")
    public String logOut() {
        logger.info("[LOGIN]用户登出:"+getCurrentPerson().getName());
        getRequest().getSession().removeAttribute(ErpAuthConstants.CURRENT_LOGIN_PERSON);
        return returnSuccessInfo();
    }
}
