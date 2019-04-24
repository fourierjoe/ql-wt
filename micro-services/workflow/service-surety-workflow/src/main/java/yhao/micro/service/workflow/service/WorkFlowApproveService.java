package yhao.micro.service.workflow.service;

import org.springframework.stereotype.Service;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.workflow.apilist.form.approve.QueryTaskOfCurrentPersonApprovedPageForm;
import yhao.micro.service.workflow.apilist.form.approve.QueryTaskOfCurrentPersonApprovingPageForm;
import yhao.micro.service.workflow.apilist.model.approve.TaskPageOfCurrentPersonModel;
import yhao.micro.service.workflow.dao.WorkFlowApproveDao;

import javax.annotation.Resource;

/**
 * @Description:
 * @Created by ql on 2018/12/16 18:07
 * @Version: v1.0
 */
@Service
public class WorkFlowApproveService {

    @Resource
    private WorkFlowApproveDao workFlowApproveDao;

    public Pagination<TaskPageOfCurrentPersonModel> queryTaskOfCurrentPerson(QueryTaskOfCurrentPersonApprovingPageForm form) {
        Pagination<TaskPageOfCurrentPersonModel> page = new Pagination<>(form.getPageSize(), form.getCurrentPage());
        workFlowApproveDao.queryTaskOfCurrentPerson(page, form);
        return page;
    }

    public Pagination<TaskPageOfCurrentPersonModel> queryTaskOfCurrentPersonApproved(QueryTaskOfCurrentPersonApprovedPageForm form) {
        Pagination<TaskPageOfCurrentPersonModel> page = new Pagination<>(form.getPageSize(), form.getCurrentPage());
        workFlowApproveDao.queryTaskOfCurrentPersonApproved(page, form);
        return page;
    }
}
