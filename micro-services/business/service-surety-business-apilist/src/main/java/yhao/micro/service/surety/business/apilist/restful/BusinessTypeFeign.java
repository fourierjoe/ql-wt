package yhao.micro.service.surety.business.apilist.restful;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.businessType.BusinessTypeQueryForm;
import yhao.micro.service.surety.business.apilist.form.businessType.BusinessTypeSaveForm;
import yhao.micro.service.surety.business.apilist.form.businessType.OrgIdForm;
import yhao.micro.service.surety.business.apilist.model.businessType.BusinessTypeModel;
import yhao.micro.service.surety.business.apilist.model.businessType.BusinessTypeNameModel;

import java.util.List;

/**
 * @Description:
 *
 * @Created by ql on 2018/12/8 19:24
 * @Version: v1.0
 */

@FeignClient(ZoneConstants.FEIGN_URL)
public interface BusinessTypeFeign {

    @PostMapping("/business/businessType/saveBusinessType")
    RequestResult<BusinessTypeSaveForm> saveBusinessType(BusinessTypeSaveForm form);

    @PostMapping("/business/businessType/queryBusinessTypePage")
    RequestResult<Pagination<BusinessTypeModel>> queryBusinessTypePage(BusinessTypeQueryForm form);

    @PostMapping("/business/businessType/pickBusinessTypeById")
    RequestResult<BusinessTypeModel> pickBusinessTypeById(IdForm form);

    @PostMapping("/business/businessType/queryBusinessTypeAllName")
    RequestResult<List<BusinessTypeNameModel>> queryBusinessTypeAllName(OrgIdForm form);
}
