package yhao.micro.service.surety.erp.org.apilist.restful;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.erp.org.apilist.form.StatusUpdateForm;
import yhao.micro.service.surety.erp.org.apilist.form.person.PersonPropertiesSaveForm;
import yhao.micro.service.surety.erp.org.apilist.form.person.PersonQueryForm;
import yhao.micro.service.surety.erp.org.apilist.form.person.PersonUpdatePswForm;
import yhao.micro.service.surety.erp.org.apilist.form.position.AddPositionLinkSaveForm;
import yhao.micro.service.surety.erp.org.apilist.model.PersonModel;
import yhao.micro.service.surety.erp.org.apilist.model.PositionLinkModel;
import yhao.micro.service.surety.erp.org.apilist.model.PositionListModel;

import java.util.List;

/**
 * Created by yoara on 2017/11/27.
 */
@FeignClient(ZoneConstants.FEIGN_URL)
public interface PersonFeign {
    @RequestMapping(value = "/person/queryPersonPage",method = RequestMethod.POST)
    RequestResult<Pagination<PersonModel>> queryPersonPage(PersonQueryForm form);

    @RequestMapping(value = "/person/queryCreditClerkByCityOrg",method = RequestMethod.POST)
    RequestResult<List<PersonModel>> queryCreditClerkByCityOrg(IdForm idForm);

    @RequestMapping(value = "/person/savePerson",method = RequestMethod.POST)
    RequestResult savePerson(PersonModel person);

    @RequestMapping(value = "/person/personStatusChange",method = RequestMethod.POST)
    RequestResult personStatusChange(StatusUpdateForm form);

    @RequestMapping(value = "/person/updatePassword",method = RequestMethod.POST)
    RequestResult<Boolean> updatePassword(PersonUpdatePswForm form);

    @RequestMapping(value = "/person/pickPersonById",method = RequestMethod.POST)
    RequestResult<PersonModel> pickPersonById(IdForm form);

    @RequestMapping(value = "/person/pickPersonByPhone",method = RequestMethod.POST)
    RequestResult<PersonModel> pickPersonByPhone(@RequestParam("phone") String phone);

    @RequestMapping(value = "/person/saveAddPosition",method = RequestMethod.POST)
    RequestResult saveAddPosition(AddPositionLinkSaveForm form);

    @RequestMapping(value = "/person/queryAddPosition",method = RequestMethod.POST)
    RequestResult<List<PositionLinkModel>> queryAddPosition(@RequestParam("personId") String personId);

    @RequestMapping(value = "/person/deleteAddPosition",method = RequestMethod.POST)
    RequestResult deleteAddPosition(AddPositionLinkSaveForm form);

    @RequestMapping(value = "/person/queryPersonPositionList",method = RequestMethod.POST)
    RequestResult<List<PositionListModel>> queryPersonPositionList(@RequestParam("personId") String personId);

    @RequestMapping(value = "/person/suretyPersonStatusChange",method = RequestMethod.POST)
    RequestResult suretyPersonStatusChange(StatusUpdateForm form);

    @RequestMapping(value = "/person/bindWxOpenId",method = RequestMethod.POST)
    RequestResult bindWxOpenId(PersonPropertiesSaveForm personPropertiesSaveForm);
}
