package yhao.micro.service.workflow.apilist.restful;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import yhao.infra.apilist.RequestResult;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.workflow.apilist.form.approve.QueryTaskOfCurrentPersonApprovedPageForm;
import yhao.micro.service.workflow.apilist.form.approve.QueryTaskOfCurrentPersonApprovingPageForm;
import yhao.micro.service.workflow.apilist.model.approve.TaskPageOfCurrentPersonModel;

/**
 * @Description:
 * @Created by ql on 2018/12/14 17:05
 * @Version: v1.0
 */
@FeignClient(ZoneConstants.FEIGN_URL)
public interface WorkFlowApproveFeign {

    @PostMapping("/approve/queryTaskOfCurrentPerson")
    RequestResult<Pagination<TaskPageOfCurrentPersonModel>> queryTaskOfCurrentPerson(QueryTaskOfCurrentPersonApprovingPageForm form);

    @PostMapping("/approve/queryTaskOfCurrentPersonApproved")
    RequestResult<Pagination<TaskPageOfCurrentPersonModel>> queryTaskOfCurrentPersonApproved(QueryTaskOfCurrentPersonApprovedPageForm form);
}
