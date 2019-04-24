package yhao.micro.service.surety.business.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.RestfulBaseController;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.complex.*;
import yhao.micro.service.surety.business.apilist.model.DiscountApplicationInfoModel;
import yhao.micro.service.surety.business.apilist.model.DiscountApplicationModel;
import yhao.micro.service.surety.business.apilist.model.WindControllerGuaranteeModel;
import yhao.micro.service.surety.business.service.DiscountApplicationService;

import javax.validation.Valid;

/**
 * @Description 打折申请api
 *
 * @Author leice
 * @Date 2018/12/19 19:50
 * @Version 1.0
 */

@RestController
@RequestMapping(value = "/discountapplication")
public class DiscountApplicationApi extends RestfulBaseController {

    @Autowired
    private DiscountApplicationService discountApplicationService;

    /**
     * 功能描述: 打折申请信息查看
     */
    @PostMapping("/queryDiscountApplicationById")
    public RequestResult<DiscountApplicationInfoModel> queryDiscountApplicationById(@RequestBody QuerySingleGuaranteeInfoForm form) throws Exception{
        return new RequestResult<>(discountApplicationService.queryDiscountApplicationById(form));
    }

    /**
     * 功能描述: 新增打折申请
     */
    @PostMapping("/discountApplicationSave")
    public RequestResult<DiscountApplicationSaveForm> discountApplicationSave(@Valid @RequestBody DiscountApplicationSaveForm form) throws Exception {
        return new RequestResult<>(discountApplicationService.discountApplicationSave(form));
    }

    /**
     * 功能描述: 重新发起打折申请/撤销打折申请
     */
    @PostMapping("/restartDiscountApplication")
    public RequestResult<RestartDiscountSaveForm> restartDiscountApplication(@Valid @RequestBody RestartDiscountSaveForm form) throws Exception {
        return new RequestResult<>(discountApplicationService.restartDiscountApplication(form));
    }

    /**
     * 功能描述: 驳回后修改打折申请并且重新启动流程
     */
    @PostMapping("/updateDiscountApplication")
    public RequestResult<RestartDiscountSaveForm> updateDiscountApplication(@Valid @RequestBody RestartDiscountSaveForm form) throws Exception {
        return new RequestResult<>(discountApplicationService.updateDiscountApplication(form));
    }

    /**
     * 功能描述: 打折申请列表查询
     */
    @PostMapping("/pageQueryDiscountApplication")
    public RequestResult<Pagination<DiscountApplicationModel>> pageQueryDiscountApplication(@RequestBody ApplicationQueryForm form) throws Exception {
        return new RequestResult<>(discountApplicationService.pageQueryDiscountApplication(form));
    }
}
