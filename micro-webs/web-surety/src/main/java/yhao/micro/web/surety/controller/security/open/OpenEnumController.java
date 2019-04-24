package yhao.micro.web.surety.controller.security.open;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yhao.infra.common.CommonStatusEnum;
import yhao.micro.service.constants.model.EnumModel;
import yhao.micro.service.surety.baseconfig.apilist.enums.*;
import yhao.micro.service.surety.business.apilist.model.enums.businessType.FundSourceEnum;
import yhao.micro.service.surety.business.apilist.model.enums.businessType.TransactionTypeEnum;
import yhao.micro.service.surety.business.apilist.model.enums.guarantee.*;
import yhao.micro.service.surety.business.apilist.model.enums.intention.CreditAndRepayScheduleEnum;
import yhao.micro.service.surety.business.apilist.model.enums.twiceRepay.FundStateEnum;
import yhao.micro.service.surety.business.apilist.model.enums.twiceRepay.TwiceRepayDateTypeEnum;
import yhao.micro.service.workflow.apilist.enums.flow.ProcessDefinitionType;
import yhao.micro.service.workflow.apilist.enums.task.TaskStatus;
import yhao.micro.web.surety.controller.WebBaseController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2018-12-05
 * Time: 17:48
 */
@Lazy
@RestController
@RequestMapping(value = "/security/open/enum", produces = {"application/json;charset=UTF-8"})
@Api(value = "OpenEnumController", tags = "开放-枚举查询")
public class OpenEnumController extends WebBaseController {

    @GetMapping("/statusEnum")
    @ApiOperation(value = "启用/禁用状态枚举")
    @ApiResponses({
            @ApiResponse(code = 200, response = CommonStatusEnum.class, message = "启用/禁用状态")
    })
    public String statusEnum() {
       return returnSuccessInfo(toStatusEnumModelList());
    }

    @GetMapping("/companyTypeEnum")
    @ApiOperation(value = "公司类型枚举")
    @ApiResponses({
            @ApiResponse(code = 200, response = CompanyTypeEnum.class, message = "公司类型枚举")
    })
    public String companyTypeEnum() {
       return returnSuccessInfo(CompanyTypeEnum.toEnumModelList());
    }

    @GetMapping("/accountTypeEnum")
    @ApiOperation(value = "账号类型枚举")
    @ApiResponses({
            @ApiResponse(code = 200, response = AccountTypeEnum.class, message = "账号类型枚举")
    })
    public String accountTypeEnum() {
       return returnSuccessInfo(AccountTypeEnum.toEnumModelList());
    }

    @GetMapping("/insuranceTypeEnum")
    @ApiOperation(value = "保险费类型枚举")
    @ApiResponses({
            @ApiResponse(code = 200, response = InsuranceTypeEnum.class, message = "保险费类型枚举")
    })
    public String insuranceTypeEnum() {
       return returnSuccessInfo(InsuranceTypeEnum.toEnumModelList());
    }

    @GetMapping("/intentionPositionTypeEnum")
    @ApiOperation(value = "单据分配中岗位类型枚举")
    @ApiResponses({
            @ApiResponse(code = 200, response = IntentionPositionTypeEnum.class, message = "单据分配中岗位类型枚举")
    })
    public String intentionPositionTypeEnum() {
       return returnSuccessInfo(IntentionPositionTypeEnum.toEnumModelList());
    }

    @GetMapping("/fundTypeEnum")
    @ApiOperation(value = "资金类型枚举")
    @ApiResponses({
            @ApiResponse(code = 200, response = FundTypeEnum.class, message = "资金类型枚举")
    })
    public String fundTypeEnum() {
       return returnSuccessInfo(FundTypeEnum.toEnumModelList());
    }

    @GetMapping("/fundProviderTypeEnum")
    @ApiOperation(value = "资方类型枚举")
    @ApiResponses({
            @ApiResponse(code = 200, response = FundProviderTypeEnum.class, message = "资方类型枚举")
    })
    public String fundProviderTypeEnum() {
       return returnSuccessInfo(FundProviderTypeEnum.toEnumModelList());
    }

    @GetMapping("/commandScopeEnum")
    @ApiOperation(value = "需要指令的业务范围枚举")
    @ApiResponses({
            @ApiResponse(code = 200, response = CommandScopeEnum.class, message = "需要指令的业务范围枚举")
    })
    public String commandScopeEnum() {
       return returnSuccessInfo(CommandScopeEnum.toEnumModelList());
    }

    private List<EnumModel> toStatusEnumModelList(){
        List<EnumModel> enumModelList = new ArrayList<>();
        for (CommonStatusEnum statusEnum : CommonStatusEnum.values()) {
            EnumModel enumModel = new EnumModel();
            enumModel.setName(statusEnum.getDesc());
            enumModel.setValue(statusEnum.name());
            enumModelList.add(enumModel);
        }
        return enumModelList;
    }

    @GetMapping("/fundSourceEnum")
    @ApiOperation(value = "资金来源枚举")
    @ApiResponses({
            @ApiResponse(code = 200, response = FundSourceEnum.class, message = "资金来源枚举")
    })
    public String fundSourceEnum() {
        return returnSuccessInfo(FundSourceEnum.toEnumModelList());
    }

    @GetMapping("/transactionTypeEnum")
    @ApiOperation(value = "交易类型枚举")
    @ApiResponses({
            @ApiResponse(code = 200, response = TransactionTypeEnum.class, message = "交易类型枚举")
    })
    public String transactionTypeEnum() {
        return returnSuccessInfo(TransactionTypeEnum.toEnumModelList());
    }

    @GetMapping("/guaranteeBankTypeEnum")
    @ApiOperation(value = "担保导航菜单搜索栏的银行查询条件枚举")
    @ApiResponses({
            @ApiResponse(code = 200, response = GuaranteeBankTypeEnum.class, message = "担保导航菜单搜索栏的银行查询条件枚举")
    })
    public String guaranteeBankTypeEnum() {
        return returnSuccessInfo(GuaranteeBankTypeEnum.toEnumModelList());
    }

    @GetMapping("/guaranteeDateTypeEnum")
    @ApiOperation(value = "担保导航菜单搜索栏的按日期查询条件枚举")
    @ApiResponses({
            @ApiResponse(code = 200, response = GuaranteeDateTypeEnum.class, message = "担保导航菜单搜索栏的按日期查询条件枚举")
    })
    public String guaranteeDateTypeEnum() {
        return returnSuccessInfo(GuaranteeDateTypeEnum.toEnumModelList());
    }

    @GetMapping("/guaranteetSourceEnum")
    @ApiOperation(value = "担保导航菜单搜索栏的来源条件枚举")
    @ApiResponses({
            @ApiResponse(code = 200, response = GuaranteetSourceEnum.class, message = "来源条件枚举")
    })
    public String guaranteetSourceEnum() {
        return returnSuccessInfo(GuaranteetSourceEnum.toEnumModelList());
    }

    @GetMapping("/guaranteeTypeEnum")
    @ApiOperation(value = "担保导航单据类型枚举")
    @ApiResponses({
            @ApiResponse(code = 200, response = GuaranteeTypeEnum.class, message = "担保导航单据类型枚举")
    })
    public String guaranteeTypeEnum() {
        return returnSuccessInfo(GuaranteeTypeEnum.toEnumModelList());
    }

    @GetMapping("/guaranteeChargeStateEnum")
    @ApiOperation(value = "担保导航搜索菜单收费状态枚举")
    @ApiResponses({
            @ApiResponse(code = 200, response = GuaranteeChargeStateEnum.class, message = "担保导航搜索菜单收费状态枚举")
    })
    public String guaranteeChargeStateEnum() {
        return returnSuccessInfo(GuaranteeChargeStateEnum.toEnumModelList());
    }

    @GetMapping("/creditAndRepayScheduleEnum")
    @ApiOperation(value = "意向单管理菜单查征信和还款申请进度枚举")
    @ApiResponses({
            @ApiResponse(code = 200, response = CreditAndRepayScheduleEnum.class, message = "意向单管理菜单查征信和还款申请进度枚举")
    })
    public String creditAndRepayScheduleEnum() {
        return returnSuccessInfo(CreditAndRepayScheduleEnum.toEnumModelList());
    }

    @GetMapping("/fundStateEnum")
    @ApiOperation(value = "二次还款菜单资金状态枚举")
    @ApiResponses({
            @ApiResponse(code = 200, response = FundStateEnum.class, message = "二次还款菜单资金状态枚举")
    })
    public String fundStateEnum() {
        return returnSuccessInfo(FundStateEnum.toEnumModelList());
    }

    @GetMapping("/twiceRepayDateTypeEnum")
    @ApiOperation(value = "二次还款菜单日期搜索枚举")
    @ApiResponses({
            @ApiResponse(code = 200, response = TwiceRepayDateTypeEnum.class, message = "二次还款菜单日期搜索枚举")
    })
    public String twiceRepayDateTypeEnum() {
        return returnSuccessInfo(TwiceRepayDateTypeEnum.toEnumModelList());
    }

    @GetMapping("/guaranteePayTypeEnum")
    @ApiOperation(value = "担保单付款方式枚举")
    @ApiResponses({
            @ApiResponse(code = 200, response = GuaranteePayTypeEnum.class, message = "担保单付款方式枚举")
    })
    public String guaranteePayTypeEnum() {
        return returnSuccessInfo(GuaranteePayTypeEnum.toEnumModelList());
    }

    @GetMapping("/processDefinitionType")
    @ApiOperation(value = "流程分组枚举")
    @ApiResponses({
            @ApiResponse(code = 200, response = ProcessDefinitionType.class, message = "流程中心-流程分组枚举")
    })
    public String processDefinitionType() {
        return returnSuccessInfo(ProcessDefinitionType.toEnumModelList());
    }

    @GetMapping("/taskStatus")
    @ApiOperation(value = "流程状态枚举")
    @ApiResponses({
            @ApiResponse(code = 200, response = TaskStatus.class, message = "流程中心-流程状态枚举")
    })
    public String taskStatus() {
        return returnSuccessInfo(TaskStatus.toEnumModelList());
    }
}
