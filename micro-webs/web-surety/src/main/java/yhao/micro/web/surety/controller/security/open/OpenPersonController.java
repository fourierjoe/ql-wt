package yhao.micro.web.surety.controller.security.open;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.erp.org.apilist.form.person.PersonQueryForm;
import yhao.micro.service.surety.erp.org.apilist.model.PersonModel;
import yhao.micro.web.surety.controller.WebBaseController;
import yhao.micro.web.surety.remote.erp.org.PersonRemote;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2018-12-12
 * Time: 14:06
 */
@Lazy
@RestController
@RequestMapping(value = "/security/open/person", produces = {"application/json;charset=UTF-8"})
@Api(value = "OpenPersonController", tags = "开放-人员查询")
public class OpenPersonController extends WebBaseController {
    @Resource
    private PersonRemote personRemote;

    @GetMapping("/pageQueryPerson")
    @ApiOperation(value = "查询分页人员信息")
    @ApiResponses({
            @ApiResponse(code = 200, response = PersonModel.class, message = "人员数据")
    })
    public String queryPersonPage(PersonQueryForm form) {
        Pagination<PersonModel> page = personRemote.queryPersonPage(form);
        return returnSuccessInfo(toPageListData(page, PersonModel.class));
    }

    @GetMapping("/pickPersonById")
    @ApiOperation(value = "根据id查询人员")
    @ApiResponses({
            @ApiResponse(code = 200, response = PersonModel.class, message = "人员数据")
    })
    public String pickPersonById(IdForm form) {
        PersonModel personModel = personRemote.pickPersonById(form);
        return returnSuccessInfo(personModel);
    }
}
