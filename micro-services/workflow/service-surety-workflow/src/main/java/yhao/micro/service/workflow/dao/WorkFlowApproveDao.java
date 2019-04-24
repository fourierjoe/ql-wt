package yhao.micro.service.workflow.dao;

import yhao.infra.common.model.Pagination;
import yhao.micro.service.workflow.apilist.form.approve.QueryTaskOfCurrentPersonApprovedPageForm;
import yhao.micro.service.workflow.apilist.form.approve.QueryTaskOfCurrentPersonApprovingPageForm;
import yhao.micro.service.workflow.apilist.model.approve.TaskPageOfCurrentPersonModel;

import java.util.List;

/**
 * @Description:
 * @Created by ql on 2018/12/16 18:13
 * @Version: v1.0
 */
public interface WorkFlowApproveDao {

    List<TaskPageOfCurrentPersonModel> queryTaskOfCurrentPerson(Pagination<TaskPageOfCurrentPersonModel> page, QueryTaskOfCurrentPersonApprovingPageForm form);

    List<TaskPageOfCurrentPersonModel> queryTaskOfCurrentPersonApproved(Pagination<TaskPageOfCurrentPersonModel> page, QueryTaskOfCurrentPersonApprovedPageForm form);
}
