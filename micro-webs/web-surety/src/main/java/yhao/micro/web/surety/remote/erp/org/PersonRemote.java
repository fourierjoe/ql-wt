package yhao.micro.web.surety.remote.erp.org;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.infra.common.util.MD5Util;
import yhao.micro.service.surety.erp.auth.login.apilist.form.AuthLoginForm;
import yhao.micro.service.surety.erp.auth.login.apilist.model.LoginPersonResponse;
import yhao.micro.service.surety.erp.auth.login.apilist.restful.LoginFeign;
import yhao.micro.service.surety.erp.org.apilist.form.person.PersonPropertiesSaveForm;
import yhao.micro.service.surety.erp.org.apilist.form.person.PersonQueryForm;
import yhao.micro.service.surety.erp.org.apilist.form.person.PersonUpdatePswForm;
import yhao.micro.service.surety.erp.org.apilist.model.PersonModel;
import yhao.micro.service.surety.erp.org.apilist.restful.PersonFeign;

import javax.annotation.Resource;


/**
 * Created by yoara on 2017/11/16.
 */
@Service
public class PersonRemote {
    private Logger logger = LoggerFactory.getLogger(PersonRemote.class);
    @Resource
    private PersonFeign personFeign;
    @Resource
    private LoginFeign loginFeign;

    public LoginPersonResponse authenticatePerson(AuthLoginForm form) {
        if (StringUtils.isNotEmpty(form.getPassword())) {
            form.setPassword(MD5Util.getMD5(form.getPassword().getBytes()));
        }
        RequestResult<LoginPersonResponse> result =
                loginFeign.authenticatePerson(form);
        if (result.isSuccess()) {
            boolean loginFromWx = StringUtils.isNotBlank(form.getWxOpenId());
            if (loginFromWx) {//从微信登陆时绑定微信OpenId
                PersonPropertiesSaveForm personPropertiesSaveForm = new PersonPropertiesSaveForm();
                personPropertiesSaveForm.setPersonId(result.getBody().getModel().getId());
                personPropertiesSaveForm.setWxOpenId(form.getWxOpenId());
                personFeign.bindWxOpenId(personPropertiesSaveForm).pickBody();
            }
            return result.getBody();
        }
        return null;
    }

    public LoginPersonResponse authenticatePersonNoPsw(AuthLoginForm form) {
        form.setNeedPsw(false);
        return loginFeign.authenticatePerson(form).pickBody();
    }

    @HystrixCommand(fallbackMethod = "queryPersonPageDown")
    public Pagination<PersonModel> queryPersonPage(PersonQueryForm form) {
        return personFeign.queryPersonPage(form).pickBody();
    }

    @HystrixCommand(fallbackMethod = "pickPersonByIdDown")
    public PersonModel pickPersonById(IdForm form) {
        return personFeign.pickPersonById(form).pickBody();
    }

    public void updatePassword(PersonUpdatePswForm form) {
        personFeign.updatePassword(form).pickBody();
    }

    public Pagination<PersonModel> queryPersonPageDown(PersonQueryForm form) {
        logger.error("Service Down:[PersonService.queryPersonPageDown]");
        return new Pagination<>();
    }

    public PersonModel pickPersonByIdDown(IdForm form) {
        logger.error("Service Down:[PersonService.pickPersonByIdDown]");
        return null;
    }


}
