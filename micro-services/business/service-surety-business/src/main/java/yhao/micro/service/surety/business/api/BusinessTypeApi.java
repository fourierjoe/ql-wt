package yhao.micro.service.surety.business.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.RestfulBaseController;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.businessType.BusinessTypeQueryForm;
import yhao.micro.service.surety.business.apilist.form.businessType.BusinessTypeSaveForm;
import yhao.micro.service.surety.business.apilist.form.businessType.OrgIdForm;
import yhao.micro.service.surety.business.apilist.model.businessType.BusinessTypeModel;
import yhao.micro.service.surety.business.apilist.model.businessType.BusinessTypeNameModel;
import yhao.micro.service.surety.business.service.BusinessTypeService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Created by ql on 2018/12/19 10:56
 * @Version: v1.0
 */
@RestController
@RequestMapping(value = "/business/businessType")
public class BusinessTypeApi extends RestfulBaseController {

    @Resource
    private BusinessTypeService businessTypeService;

    @PostMapping("/saveBusinessType")
    public RequestResult<BusinessTypeSaveForm> saveBusinessType(@RequestBody BusinessTypeSaveForm form) {
        return new RequestResult(businessTypeService.saveBusinessType(form));
    }

    @PostMapping("/queryBusinessTypePage")
    public RequestResult<Pagination<BusinessTypeModel>> queryBusinessTypePage(@RequestBody BusinessTypeQueryForm form) {
        return new RequestResult<>(businessTypeService.queryBusinessTypePage(form));
    }


    @PostMapping("/pickBusinessTypeById")
    public RequestResult<BusinessTypeModel> pickBusinessTypeById(@RequestBody IdForm form) {
        return new RequestResult<>(businessTypeService.pickBusinessTypeById(form));
    }

    @PostMapping("/queryBusinessTypeAllName")
    RequestResult<List<BusinessTypeNameModel>> queryBusinessTypeAllName(@RequestBody OrgIdForm form) {
        return new RequestResult<>(businessTypeService.queryBusinessTypeAllName(form));
    }

}
