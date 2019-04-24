package yhao.micro.service.workflow.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.RestfulBaseController;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.workflow.apilist.form.approve.QueryTaskOfCurrentPersonApprovedPageForm;
import yhao.micro.service.workflow.apilist.form.approve.QueryTaskOfCurrentPersonApprovingPageForm;
import yhao.micro.service.workflow.apilist.model.approve.TaskPageOfCurrentPersonModel;
import yhao.micro.service.workflow.service.WorkFlowApproveService;

import javax.annotation.Resource;

/**
 * @Description: 流程中心流程审批
 * @Created by ql on 2018/12/16 18:01
 * @Version: v1.0
 */
@RestController
@RequestMapping(value = "/approve")
public class WorkFlowApproveApi extends RestfulBaseController {

    @Resource
    private WorkFlowApproveService workFlowApproveService;

    /**
     * 待审批
     * @param form
     * @return
     */
    @PostMapping("/queryTaskOfCurrentPerson")
    public RequestResult<Pagination<TaskPageOfCurrentPersonModel>> queryTaskOfCurrentPerson(@RequestBody QueryTaskOfCurrentPersonApprovingPageForm form){
        return new RequestResult(workFlowApproveService.queryTaskOfCurrentPerson(form));
    }

    /**
     * 已审批
     * @param form
     * @return
     */
    @PostMapping("/queryTaskOfCurrentPersonApproved")
    public RequestResult<Pagination<TaskPageOfCurrentPersonModel>> queryTaskOfCurrentPersonApproved(@RequestBody QueryTaskOfCurrentPersonApprovedPageForm form){
        return new RequestResult(workFlowApproveService.queryTaskOfCurrentPersonApproved(form));
    }

}
