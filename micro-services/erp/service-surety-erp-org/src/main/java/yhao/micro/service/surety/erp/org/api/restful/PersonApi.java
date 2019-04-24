package yhao.micro.service.surety.erp.org.api.restful;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.RestfulBaseController;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.erp.org.apilist.form.StatusUpdateForm;
import yhao.micro.service.surety.erp.org.apilist.form.person.PersonPropertiesSaveForm;
import yhao.micro.service.surety.erp.org.apilist.form.person.PersonQueryForm;
import yhao.micro.service.surety.erp.org.apilist.form.person.PersonUpdatePswForm;
import yhao.micro.service.surety.erp.org.apilist.form.position.AddPositionLinkSaveForm;
import yhao.micro.service.surety.erp.org.apilist.model.PersonModel;
import yhao.micro.service.surety.erp.org.service.PersonService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yoara on 2017/2/15.
 */
@RestController
@RequestMapping(value = "/person")
public class PersonApi extends RestfulBaseController {
    @Resource
    private PersonService personService;

    @PostMapping("/queryPersonPage")
    public RequestResult<Pagination<PersonModel>> queryPersonPage(@RequestBody PersonQueryForm form) {
        return new RequestResult<>(personService.queryPersonPage(form));
    }

    @PostMapping("/queryCreditClerkByCityOrg")
    public RequestResult<List<PersonModel>> queryCreditClerkByCityOrg(@RequestBody IdForm idForm) {
        return new RequestResult<>(personService.queryCreditClerkByCityOrg(idForm));
    }

    @PostMapping("/savePerson")
    public RequestResult savePerson(@RequestBody PersonModel person) {
        return new RequestResult<>(personService.savePerson(person));
    }

    @PostMapping("/personStatusChange")
    public RequestResult personStatusChange(@RequestBody StatusUpdateForm form) {
        return new RequestResult<>(personService.personStatusChange(form));
    }

    @PostMapping("/updatePassword")
    public RequestResult updatePassword(@RequestBody PersonUpdatePswForm form) {
        return new RequestResult<>(personService.updatePassword(form));
    }

    @PostMapping("/pickPersonById")
    public RequestResult pickPersonById(@RequestBody IdForm form) {
        return new RequestResult<>(personService.pickPersonById(form.getId()));
    }

    @PostMapping("/pickPersonByPhone")
    public RequestResult pickPersonByPhone(String phone) {
        return new RequestResult<>(personService.pickPersonByPhone(phone));
    }

    @PostMapping("/saveAddPosition")
    public RequestResult saveAddPosition(@RequestBody AddPositionLinkSaveForm form) {
        return new RequestResult<>(personService.saveAddPosition(form));
    }

    /**
     * 查询兼职信息，不包括主职
     *
     * @param personId
     * @return
     */
    @PostMapping("/queryAddPosition")
    public RequestResult queryAddPosition(String personId) {
        return new RequestResult<>(personService.queryAddPosition(personId));
    }

    @PostMapping("/deleteAddPosition")
    public RequestResult deleteAddPosition(@RequestBody AddPositionLinkSaveForm form) {
        return new RequestResult<>(personService.deleteAddPosition(form));
    }

    /**
     * 查询人员履职记录
     *
     * @param personId
     * @return
     */
    @PostMapping("/queryPersonPositionList")
    public RequestResult queryPersonPositionList(String personId) {
        return new RequestResult<>(personService.queryPersonPositionList(personId));
    }

    @PostMapping("/suretyPersonStatusChange")
    public RequestResult suretyPersonStatusChange(@RequestBody StatusUpdateForm form) {
        return new RequestResult<>(personService.suretyPersonStatusChange(form));
    }

    @PostMapping("/bindWxOpenId")
    public RequestResult bindWxOpenId(@RequestBody PersonPropertiesSaveForm form) {
        return new RequestResult<>(personService.bindWxOpenId(form));
    }

}
