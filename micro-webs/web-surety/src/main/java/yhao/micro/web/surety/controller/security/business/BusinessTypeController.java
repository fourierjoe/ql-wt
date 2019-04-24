package yhao.micro.web.surety.controller.security.business;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.businessType.BusinessTypeQueryForm;
import yhao.micro.service.surety.business.apilist.form.businessType.BusinessTypeSaveForm;
import yhao.micro.service.surety.business.apilist.model.businessType.BusinessTypeModel;
import yhao.micro.service.surety.erp.auth.login.apilist.model.LoginPersonModel;
import yhao.micro.service.workflow.apilist.enums.task.RuleItemType;
import yhao.micro.service.workflow.apilist.form.flow.processBussiness.ItemCodeForm;
import yhao.micro.service.workflow.apilist.model.flow.ItemConfigModel;
import yhao.micro.web.surety.controller.WebBaseController;
import yhao.micro.web.surety.remote.business.BusinessTypeRemote;
import yhao.micro.web.surety.remote.workflow.ProcessRemote;

import javax.annotation.Resource;

/**
 * @Description:
 * @Created by ql on 2018/12/9 15:04
 * @Version: v1.0
 */
@Lazy
@RestController
@RequestMapping(value = "/security/business/businessType", produces = {"application/json;charset=UTF-8"})
@Api(value = "BusinessTypeController", tags = "担保业务-业务类型设置")
public class BusinessTypeController extends WebBaseController {

    @Resource
    private BusinessTypeRemote businessTypeRemote;
    @Resource
    private ProcessRemote processRemote;

    @PostMapping("/businessType")
    @ApiOperation(value = "业务类型保存/编辑接口")
    public String saveBusinessType(@RequestBody BusinessTypeSaveForm form) {
        LoginPersonModel currentPerson = getCurrentPerson();
        form.setOperatorId(currentPerson.getId());
        businessTypeRemote.saveBusinessType(form);
        return returnSuccessInfo();
    }

    @GetMapping("/businessType")
    @ApiOperation(value = "业务类型设置分页查询")
    @ApiResponses(
            @ApiResponse(code = 200, response = BusinessTypeModel.class, message = "业务类型设置信息")
    )
    public String queryBusinessTypePage(BusinessTypeQueryForm form) {
        var page = new Pagination<BusinessTypeModel>(form.getPageSize(),form.getCurrentPage());

        page = businessTypeRemote.queryBusinessTypePage(form);
        JSONObject json = toPageListData(page, BusinessTypeModel.class);
        
        return returnSuccessInfo(json);
    }

    @GetMapping("/pickBusinessTypeById")
    @ApiOperation(value = "通过id查询业务类型")
    @ApiResponses(
            @ApiResponse(code = 200, response = BusinessTypeModel.class, message = "业务类型设置信息")
    )
    public String pickBusinessTypeById(IdForm form) {
        BusinessTypeModel model = businessTypeRemote.pickBusinessTypeById(form);
        return returnSuccessInfo(model);
    }

    @GetMapping("/ruleItemType")
    @ApiOperation(value = "事项期望类型枚举")
    @ApiResponses({
            @ApiResponse(code = 200, response = RuleItemType.class, message = "事项期望类型枚举")
    })
    public String ruleItemType() {
        return returnSuccessInfo(RuleItemType.toEnumModelList());
    }

    @GetMapping("/itemResult")
    @ApiOperation(value = "流程配置-基础信息table-查询事项结果")
    @ApiResponses({
            @ApiResponse(code = 200, response = ItemConfigModel.class, message = "查询事项结果")
    })
    public String itemResult(ItemCodeForm form) {
//        String itemConfigJsonStr = processRemote.queryItemConfig(form);
        Pagination<ItemConfigModel> page = processRemote.queryItemConfig(form);
//        return returnSuccessInfo(JSONObject.parseObject(itemConfigJsonStr));
        return returnSuccessInfo(page);
    }

}
