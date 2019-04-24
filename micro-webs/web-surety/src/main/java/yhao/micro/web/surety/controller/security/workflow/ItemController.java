package yhao.micro.web.surety.controller.security.workflow;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.constants.annotations.AuthorityAnnotation;
import yhao.micro.service.constants.enums.AuthorityAnnotationEnums;
import yhao.micro.service.surety.erp.auth.login.apilist.model.LoginPersonModel;
import yhao.micro.service.workflow.apilist.form.flow.FlowNodeItemTemplateQueryForm;
import yhao.micro.service.workflow.apilist.form.flow.FlowNodeItemTemplateSaveForm;
import yhao.micro.service.workflow.apilist.model.flow.FlowItemTemplateModel;
import yhao.micro.web.surety.controller.WebBaseController;
import yhao.micro.web.surety.remote.workflow.ProcessRemote;

import javax.annotation.Resource;

/**
 * @Description:
 * @Created by ql on 2019/1/8 09:59
 * @Version: v1.0
 */
@Lazy
@RestController
@RequestMapping(value = "/security/workflow/item", produces = {"application/json;charset=UTF-8"})
@Api(value = "ItemController", tags = "流程中心-事项管理")
public class ItemController extends WebBaseController {
	@Resource
	private ProcessRemote processRemote;

	/******************************事项********************************/
	@PostMapping("/itemTemplate")
	@ApiOperation(value = "保存或编辑节点事项模板信息")
	@AuthorityAnnotation(AuthorityAnnotationEnums.ITEM_ADD_EDIT)
	public String saveNodeItemTemplate(@RequestBody FlowNodeItemTemplateSaveForm form) {
		LoginPersonModel currentPerson = getCurrentPerson();
		form.setOperatorId(currentPerson.getId());
		processRemote.saveNodeItemTemplate(form);
		return returnSuccessInfo();
	}

	@GetMapping("/itemTemplate")
	@ApiOperation(value = "分页查询事项模板")
	@ApiResponses(
			@ApiResponse(code = 200, response = FlowItemTemplateModel.class, message = "模板事项信息")
	)
	@AuthorityAnnotation(AuthorityAnnotationEnums.ITEM_SELECT)
	public String queryItemTemplatePage(FlowNodeItemTemplateQueryForm form) {
		var page = new Pagination<FlowItemTemplateModel>(form.getPageSize(),form.getCurrentPage());
		page = processRemote.queryItemTemplatePage(form);
		return returnSuccessInfo(toPageListData(page, FlowItemTemplateModel.class));
	}

	@PostMapping("/deleteItemTemplate")
	@ApiOperation(value = "根据事项ID删除事项")
	@AuthorityAnnotation(AuthorityAnnotationEnums.ITEM_DELETE)
	public String deleteItemTemplate(@RequestBody IdForm form) {
		processRemote.deleteItemTemplate(form);
		return returnSuccessInfo();
	}
}
