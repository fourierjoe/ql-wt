package yhao.micro.service.surety.erp.auth.api.restful;

import yhao.micro.service.surety.erp.auth.login.apilist.form.AuthLoginForm;
import yhao.micro.service.surety.erp.auth.login.apilist.model.LoginPersonResponse;
import yhao.micro.service.surety.erp.auth.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.RestfulBaseController;

import javax.annotation.Resource;

/**
 * Created by yoara on 2017/11/27.
 */
@RestController
@RequestMapping(value = "/login")
public class LoginApi extends RestfulBaseController {
    @Resource
    private LoginService loginService;

    @PostMapping("/authenticatePerson")
    public RequestResult<LoginPersonResponse> authenticatePerson(@RequestBody AuthLoginForm form){
        return new RequestResult<>(loginService.authenticatePerson(form));
    }
}
