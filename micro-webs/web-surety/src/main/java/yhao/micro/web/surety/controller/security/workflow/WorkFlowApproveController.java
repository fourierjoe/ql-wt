package yhao.micro.web.surety.controller.security.workflow;

import com.alibaba.fastjson.JSON;
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
import yhao.micro.service.constants.annotations.AuthorityAnnotation;
import yhao.micro.service.constants.enums.AuthorityAnnotationEnums;
import yhao.micro.service.workflow.apilist.form.approve.QueryTaskOfCurrentPersonApprovedPageForm;
import yhao.micro.service.workflow.apilist.form.approve.QueryTaskOfCurrentPersonApprovingPageForm;
import yhao.micro.service.workflow.apilist.model.approve.TaskPageOfCurrentPersonModel;
import yhao.micro.service.workflow.apilist.model.task.TaskNodeModel;
import yhao.micro.web.surety.controller.WebBaseController;
import yhao.micro.web.surety.remote.workflow.WorkFlowApproveRemote;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Description: 流程审批table页
 * @Created by ql on 2018/12/14 17:00
 * @Version: v1.0
 */
@Lazy
@RestController
@RequestMapping(value = "/security/workflow/workflowapprove", produces = {"application/json;charset=UTF-8"})
@Api(value = "WorkFlowApproveController", tags = "流程中心-流程审批接口")
public class WorkFlowApproveController extends WebBaseController {

    @Resource
    private WorkFlowApproveRemote workFlowApproveRemote;

    /**
     * 待审批
     * @param form
     * @return
     */
    @GetMapping("/queryTaskOfCurrentPerson")
    @ApiOperation(value = "查询当前登录人的待审批")
    @ApiResponses(
            @ApiResponse(code = 200, response = TaskPageOfCurrentPersonModel.class, message = "任务分页信息")
    )
    @AuthorityAnnotation(AuthorityAnnotationEnums.APPROVE_SELECT)
    public String queryTaskOfCurrentPerson(QueryTaskOfCurrentPersonApprovingPageForm form){
        var page = new Pagination<TaskPageOfCurrentPersonModel>(form.getPageSize(),form.getCurrentPage());

        page =  workFlowApproveRemote.queryTaskOfCurrentPerson(form);

        return returnSuccessInfo(toPageListData(page, TaskPageOfCurrentPersonModel.class));
    }

    @GetMapping("/queryTaskOfCurrentPersonApproved")
    @ApiOperation(value = "查询当前登录人已审批")
    @ApiResponses(
            @ApiResponse(code = 200, response = TaskPageOfCurrentPersonModel.class, message = "任务分页信息")
    )
    @AuthorityAnnotation(AuthorityAnnotationEnums.APPROVE_SELECT)
    public String queryTaskOfCurrentPersonApproved(QueryTaskOfCurrentPersonApprovedPageForm form){
        var page = new Pagination<TaskPageOfCurrentPersonModel>(form.getPageSize(),form.getCurrentPage());

        page =  workFlowApproveRemote.queryTaskOfCurrentPersonApproved(form);

        return returnSuccessInfo(toPageListData(page, TaskPageOfCurrentPersonModel.class));
    }

    /**
     * 测试通过
     * @param form
     * @return
     */
    @GetMapping("/pickTaskScheduleById")
    @ApiOperation(value = "根据任务id(流水号)查询任务进度信息")
    @ApiResponses(
            @ApiResponse(code = 200, response = TaskNodeModel.class, message = "任务进度信息")
    )
    @AuthorityAnnotation(AuthorityAnnotationEnums.APPROVE_DEAL)
    public String pickTaskScheduleById(IdForm form){
		Map<Integer, TaskNodeModel> map = workFlowApproveRemote.pickTaskSchedule(form);
        return returnSuccessInfo(JSON.toJSON(map));
	}
}
