package yhao.micro.service.surety.business.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.RestfulBaseController;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.complex.*;
import yhao.micro.service.surety.business.apilist.form.finance.OverdueRecordResultForm;
import yhao.micro.service.surety.business.apilist.model.*;
import yhao.micro.service.surety.business.service.ExtensionApplicationService;

import javax.validation.Valid;
import java.util.List;

/**
 * @Description 展期申请Api
 *
 * @Author leice
 * @Date 2019/1/3 15:57
 * @Version 1.0
 */

@RestController
@RequestMapping(value = "/extensionApplication")
public class ExtensionApplicationApi extends RestfulBaseController {

    @Autowired
    private ExtensionApplicationService extensionApplicationService;

    /**
     * 功能描述: 查找展期申请列表
     */
    @PostMapping("/extensionApplicationList")
    public RequestResult<Pagination<ExtensionApplicationListModel>> extensionApplicationList(@RequestBody ApplicationQueryForm form) throws Exception {
        return new RequestResult<>(extensionApplicationService.extensionApplicationList(form));
    }

    /**
     * 功能描述: 创建展期申请时的列表查询
     */
    @PostMapping("/createExtensionApplicationList")
    public RequestResult<Pagination<CreateExtensionListModel>> createExtensionApplicationList(@RequestBody CreateExtensionListForm form) throws Exception {
        return new RequestResult<>(extensionApplicationService.createExtensionApplicationList(form));
    }

    /**
     * 功能描述: 新增展期申请
     */
    @PostMapping("/extensionApplicationSave")
    public RequestResult<ExtensionApplicationSaveForm> extensionApplicationSave(@RequestBody ExtensionApplicationSaveForm form) throws Exception {
        return new RequestResult<>(extensionApplicationService.extensionApplicationSave(form));
    }

    /**
     * 功能描述: 修改展期申请
     */
    @PostMapping("/extensionApplicationUpdate")
    public RequestResult<ExtensionApplicationSaveForm> extensionApplicationUpdate(@RequestBody ExtensionApplicationSaveForm form) throws Exception {
        return new RequestResult<>(extensionApplicationService.extensionApplicationUpdate(form));
    }

    /**
     * 功能描述: 撤销展期申请
     */
    @PostMapping("/cancelExtension")
    public RequestResult<ExtensionApplicationModel> cancelExtension(@RequestBody CancleExtensionForm form) throws Exception {
        return new RequestResult<>(extensionApplicationService.cancelExtension(form));
    }

    /**
     * 功能描述: 根据展期id查找展期申请
     */
    @PostMapping("/queryExtensionApplicationById")
    public RequestResult<ExtensionApplicationModel> queryExtensionApplicationById(@RequestBody QueryExtensionByIdForm form) throws Exception {
        return new RequestResult<>(extensionApplicationService.queryExtensionApplicationById(form));
    }


    /**
     * 功能描述: 根据借款id查找展期申请记录
     */
    @PostMapping("/queryExtensionListById")
    public RequestResult<Pagination<ExtensionApplicationModel>> queryExtensionListById(@RequestBody QueryExtensionByIdForm form) throws Exception {
        return new RequestResult<>(extensionApplicationService.queryExtensionListById(form));
    }


    /**
     * 功能描述: 逾转展保存
     */
    @PostMapping("/overdueToExtensionSave")
    public RequestResult<OverdueToExtensionListForm> overdueToExtensionSave(@Valid @RequestBody OverdueToExtensionListForm form) throws Exception {
        return new RequestResult<>(extensionApplicationService.overdueToExtensionSave(form));
    }

    /**
     * 功能描述: 撤销逾转展申请
     */
    @PostMapping("/OverdueToExtCancel")
    public RequestResult<OverdueToExtCancelForm> OverdueToExtCancel(@Valid @RequestBody OverdueToExtCancelForm form) throws Exception {
        return new RequestResult<>(extensionApplicationService.OverdueToExtCancel(form));
    }

    /**
     * 功能描述: 逾期列表
     */
    @PostMapping("/overDueList")
    public RequestResult<Pagination<OverDueListModel>> overDueList(@RequestBody OverDueQueryForm form) throws Exception {
        return new RequestResult<>(extensionApplicationService.overDueList(form));
    }

    /**
     * 功能描述: 查询修改展期是的首行表单字段
     */
    @PostMapping("/querySomeField")
    public RequestResult<ExtensionSomeFiledModel> querySomeField(@Valid @RequestBody ExtensionSomeFiledForm form) throws Exception {
        return new RequestResult<>(extensionApplicationService.querySomeField(form));
    }

    /**
     * 功能描述: 逾期查看
     */
    @PostMapping("/queryLookOverdueRecord")
    public RequestResult<List<OverdueRecordResultForm>> queryLookOverdueRecord(@RequestBody IdForm form) throws Exception {
        return new RequestResult<>(extensionApplicationService.queryLookOverdueRecord(form));
    }

    /**
     * 功能描述: 逾转展申请修改
     */
    @PostMapping("/OverdueToExtUpdate")
    public RequestResult<OverdueToExtensionListForm> OverdueToExtUpdate(@Valid @RequestBody OverdueToExtensionListForm form) throws Exception {
        return new RequestResult<>(extensionApplicationService.OverdueToExtUpdate(form));
    }

}
