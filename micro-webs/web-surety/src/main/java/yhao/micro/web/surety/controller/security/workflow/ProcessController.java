package yhao.micro.web.surety.controller.security.workflow;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.constants.annotations.AuthorityAnnotation;
import yhao.micro.service.constants.enums.AuthorityAnnotationEnums;
import yhao.micro.service.surety.erp.auth.login.apilist.model.LoginPersonModel;
import yhao.micro.service.workflow.apilist.form.flow.BizCodeForm;
import yhao.micro.service.workflow.apilist.form.flow.FlowProcessBizCodeChangeForm;
import yhao.micro.service.workflow.apilist.form.flow.FlowProcessQueryForm;
import yhao.micro.service.workflow.apilist.form.flow.SubProcessNameQueryForm;
import yhao.micro.service.workflow.apilist.form.flow.processBussiness.BizFlowProcessDefinitionForm;
import yhao.micro.service.workflow.apilist.form.flow.processCenter.FlowProcessDefinitionForm;
import yhao.micro.service.workflow.apilist.model.flow.FlowProcessDefinitionModel;
import yhao.micro.service.workflow.apilist.model.flow.SubProcessNameModel;
import yhao.micro.web.surety.controller.WebBaseController;
import yhao.micro.web.surety.remote.workflow.ProcessRemote;

import javax.annotation.Resource;
import java.util.List;

@Lazy
@RestController
@RequestMapping(value = "/security/workflow/process", produces = {"application/json;charset=UTF-8"})
@Api(value = "ProcessController", tags = "流程中心-流程配置")
public class ProcessController extends WebBaseController {

    @Resource
    private ProcessRemote processRemote;

    /******************************流程定义********************************/
	/**
	 * 测试通过
	 * @param form
	 * @return
	 */
	@PostMapping("/bizProcessDefinition")
	@ApiOperation(value = "业务配置-保存或更新流程定义信息")
	public String saveBizProcessDefinition(@RequestBody BizFlowProcessDefinitionForm form) {
        LoginPersonModel currentPerson = getCurrentPerson();
        form.setOperatorId(currentPerson.getId());
		processRemote.saveBizProcessDefinition(form);
		return returnSuccessInfo();
	}


    /**
     * 测试通过
     * @param form
     * @return
     */
    @PostMapping("/processDefinition")
    @ApiOperation(value = "流程中心-保存或更新流程定义信息")
    @AuthorityAnnotation(AuthorityAnnotationEnums.PROCESS_ADD_EDIT)
    public String saveProcessDefinition(@RequestBody FlowProcessDefinitionForm form) {
        LoginPersonModel currentPerson = getCurrentPerson();
        form.setOperatorId(currentPerson.getId());
        processRemote.saveProcessDefinition(form);
        return returnSuccessInfo();
    }

    @Deprecated
    @PostMapping("/updateBizCode")
    @ApiOperation(value = "更新流程业务码")
    public String updateBizCode(@RequestBody FlowProcessBizCodeChangeForm form) {
        processRemote.updateBizCode(form);
        return returnSuccessInfo();
    }


    /**
     * 测试通过
     * @param form
     * @return
     */
    @GetMapping("/processPage")
    @ApiOperation(value = "分页查询所有生效的流程定义")
    @ApiResponses(
            @ApiResponse(code = 200, response = FlowProcessDefinitionModel.class, message = "所有流程信息")
    )
    @AuthorityAnnotation(AuthorityAnnotationEnums.PROCESS_SELECT)
    public String queryProcessDefinition(FlowProcessQueryForm form) {
        var page = new Pagination<FlowProcessDefinitionModel>(form.getPageSize(),form.getCurrentPage());
        page = processRemote.queryProcessPage(form);
        return returnSuccessInfo(toPageListData(page, FlowProcessDefinitionModel.class));
    }

    @GetMapping("/searchNewestProcessDefinitionByCode")
    @ApiOperation(value = "根据流程bizCod查询流程定义")
    @ApiResponses(
            @ApiResponse(code = 200, response = FlowProcessDefinitionModel.class, message = "流程信息")
    )
    public String searchNewestProcessDefinitionByCode(BizCodeForm form) {
        FlowProcessDefinitionModel model = processRemote.searchNewestProcessDefinitionByCode(form);
        Object object = JSON.toJSON(model);
        return returnSuccessInfo(object);
    }


    /**
     * 通过流程名称查询子流程ID
     * @param form
     * @return
     */
    @GetMapping("/pickSubProcessId")
    @ApiOperation(value = "根据流程名称模糊查询子流程ID")
    @ApiResponses(
            @ApiResponse(code = 200, response = SubProcessNameModel.class, message = "流程信息")
    )
    public String pickSubProcessId(SubProcessNameQueryForm form) {
        List<SubProcessNameModel> model = processRemote.pickSubProcessId(form);
        return returnSuccessInfo(model);
    }

}
