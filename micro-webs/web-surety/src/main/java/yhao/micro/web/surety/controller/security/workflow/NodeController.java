package yhao.micro.web.surety.controller.security.workflow;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.context.annotation.Lazy;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.constants.annotations.AuthorityAnnotation;
import yhao.micro.service.constants.enums.AuthorityAnnotationEnums;
import yhao.micro.service.surety.erp.auth.login.apilist.model.LoginPersonModel;
import yhao.micro.service.workflow.apilist.form.flow.*;
import yhao.micro.service.workflow.apilist.form.flow.validatedGroup.SaveNodeTemplate;
import yhao.micro.service.workflow.apilist.model.flow.FlowNodeTemplateModel;
import yhao.micro.web.surety.controller.WebBaseController;
import yhao.micro.web.surety.remote.workflow.ProcessRemote;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Created by ql on 2019/1/8 09:56
 * @Version: v1.0
 */
@Lazy
@RestController
@RequestMapping(value = "/security/workflow/node", produces = {"application/json;charset=UTF-8"})
@Api(value = "NodeController", tags = "流程中心-节点管理")
public class NodeController extends WebBaseController {
	@Resource
	private ProcessRemote processRemote;

	/******************************节点********************************/
	/**
	 * 已测试
	 * @param form
	 * @return
	 */
	@PostMapping("/nodeTemplate")
	@ApiOperation(value = "节点管理-保存或更新节点模板信息")
	@AuthorityAnnotation(AuthorityAnnotationEnums.NODE_ADD_EDIT)
	public String saveNodeTemplate(@RequestBody @Validated(value = {SaveNodeTemplate.class}) FlowNodeTemplateForm form) {
		LoginPersonModel currentPerson = getCurrentPerson();
		form.setOperatorId(currentPerson.getId());
		processRemote.saveNodeTemplate(form);
		return returnSuccessInfo();
	}

	@PostMapping("/mainNodeTemplate")
	@ApiOperation(value = "业务配置-保存主流程节点模板信息")
	public String saveMainNodeTemplate(@RequestBody FlowMainNodeTemplateForm form) {
		LoginPersonModel currentPerson = getCurrentPerson();
		form.setOperatorId(currentPerson.getId());
		processRemote.saveMainNodeTemplate(form);
		return returnSuccessInfo();
	}

	@PostMapping("/subNodeTemplate")
	@ApiOperation(value = "流程配置-保存子流程节点模板信息")
	public String saveSubNodeTemplate(@RequestBody FlowSubNodeTemplateForm form) {
		LoginPersonModel currentPerson = getCurrentPerson();
		form.setOperatorId(currentPerson.getId());
		processRemote.saveSubNodeTemplate(form);
		return returnSuccessInfo();
	}

	// 测试通过
	@GetMapping("/nodeTemplate")
	@ApiOperation(value = "流程配置-分页查询节点模板信息")
	@ApiResponses(
			@ApiResponse(code = 200, response = FlowNodeTemplateModel.class, message = "模板节点信息")
	)
	@AuthorityAnnotation(AuthorityAnnotationEnums.NODE_SELECT)
	public String queryNodeTemplatePage(FlowNodeTemplateQueryForm form) {
		var page = new Pagination<FlowNodeTemplateModel>(form.getPageSize(),form.getCurrentPage());
		page = processRemote.queryNodeTemplatePage(form);
		return returnSuccessInfo(toPageListData(page, FlowNodeTemplateModel.class));
	}

	@PostMapping("/deleteNodeTemplate")
	@ApiOperation(value = "根据节点ID删除模板节点")
	@AuthorityAnnotation(AuthorityAnnotationEnums.NODE_DELETE)
	public String deleteNodeTemplate(@RequestBody IdForm form) {
		processRemote.deleteNodeTemplate(form);
		return returnSuccessInfo();
	}

	@GetMapping("/pickFlowCenterNodeByName")
	@ApiOperation(value = "流程配置-输入节点名称模糊查询节点中所有信息")
	@ApiResponses(
			@ApiResponse(code = 200, response = FlowNodeTemplateModel.class, message = "符合查询条件的子节点模板信息集合")
	)
	public String pickFlowCenterNodeByName(FlowNodeNameForm form) {
		List<FlowNodeTemplateModel> list = processRemote.pickFlowCenterNodeByName(form);
		return returnSuccessInfo(list);
	}

	@GetMapping("/pickBizNodeByName")
	@ApiOperation(value = "业务配置-输入节点名称模糊查询节点中所有信息")
	@ApiResponses(
			@ApiResponse(code = 200, response = FlowNodeTemplateModel.class, message = "符合查询条件的主节点模板信息集合")
	)
	public String pickBizNodeByName(BizNodeNameForm form) {
		List<FlowNodeTemplateModel> list = processRemote.pickBizNodeByName(form);
		return returnSuccessInfo(list);
	}

	@GetMapping("/pickFlowCenterAllNode")
	@ApiOperation(value = "流程中心-查出所有子节点信息")
	@ApiResponses(
			@ApiResponse(code = 200, response = FlowNodeTemplateModel.class, message = "子节点模板信息集合")
	)
	public String pickFlowCenterAllNode(FlowNodeTempleteForm form) {
		List<FlowNodeTemplateModel> list = processRemote.pickFlowCenterAllNode(form);
		return returnSuccessInfo(list);
	}

	@GetMapping("/pickBizAllNode")
	@ApiOperation(value = "业务配置-查出所有主节点信息")
	@ApiResponses(
			@ApiResponse(code = 200, response = FlowNodeTemplateModel.class, message = "主节点模板信息集合")
	)
	public String pickBizAllNode(FlowNodeTempleteForm form) {
		List<FlowNodeTemplateModel> list = processRemote.pickBizAllNode(form);
		return returnSuccessInfo(list);
	}

	@PostMapping("/pickProcessNodeIsDelete")
	@ApiOperation(value = "流程编辑时的节点删除按钮")
	public String pickProcessNodeIsDelete(@RequestBody IdForm form) {
		return returnSuccessInfo(processRemote.pickProcessNodeIsDelete(form));
	}

}
