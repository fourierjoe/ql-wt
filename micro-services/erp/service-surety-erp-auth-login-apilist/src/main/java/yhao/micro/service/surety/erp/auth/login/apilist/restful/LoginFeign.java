package yhao.micro.service.surety.erp.auth.login.apilist.restful;

import yhao.micro.service.surety.erp.auth.login.apilist.form.AuthLoginForm;
import yhao.micro.service.surety.erp.auth.login.apilist.model.LoginPersonResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yhao.infra.apilist.RequestResult;

/**
 * Created by yoara on 2017/12/11.
 */
@FeignClient(ZoneConstants.FEIGN_URL)
public interface LoginFeign {
    @RequestMapping(value = "/login/authenticatePerson",method = RequestMethod.POST)
    RequestResult<LoginPersonResponse> authenticatePerson(AuthLoginForm form);
}
