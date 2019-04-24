package yhao.micro.web.surety.remote.workflow;

import com.google.common.collect.Maps;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.workflow.apilist.form.approve.QueryTaskOfCurrentPersonApprovedPageForm;
import yhao.micro.service.workflow.apilist.form.approve.QueryTaskOfCurrentPersonApprovingPageForm;
import yhao.micro.service.workflow.apilist.model.approve.TaskPageOfCurrentPersonModel;
import yhao.micro.service.workflow.apilist.model.task.TaskNodeModel;
import yhao.micro.service.workflow.apilist.restful.TaskFeign;
import yhao.micro.service.workflow.apilist.restful.WorkFlowApproveFeign;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Description:
 * @Created by ql on 2018/12/14 17:04
 * @Version: v1.0
 */
@Service
public class WorkFlowApproveRemote {

    private Logger logger = LoggerFactory.getLogger(ProcessRemote.class);

    @Resource
    private WorkFlowApproveFeign workFlowApproveFeign;

    @Resource
    private TaskFeign taskFeign;

    @HystrixCommand(fallbackMethod = "queryTaskOfCurrentPersonDown")
    public Pagination<TaskPageOfCurrentPersonModel> queryTaskOfCurrentPerson(QueryTaskOfCurrentPersonApprovingPageForm form) {
        return workFlowApproveFeign.queryTaskOfCurrentPerson(form).pickBody();
    }
    public Pagination<TaskPageOfCurrentPersonModel> queryTaskOfCurrentPersonDown(QueryTaskOfCurrentPersonApprovingPageForm form, Throwable e) {
        logger.error("Service Down:[WorkFlowApproveService.queryTaskOfCurrentPerson]");
        logger.error(e.getMessage(), e.getCause());
        return new Pagination<>();
    }

    @HystrixCommand(fallbackMethod = "queryTaskOfCurrentPersonApprovedDown")
    public Pagination<TaskPageOfCurrentPersonModel> queryTaskOfCurrentPersonApproved(QueryTaskOfCurrentPersonApprovedPageForm form) {
        return workFlowApproveFeign.queryTaskOfCurrentPersonApproved(form).pickBody();
    }
    public Pagination<TaskPageOfCurrentPersonModel> queryTaskOfCurrentPersonApprovedDown(QueryTaskOfCurrentPersonApprovedPageForm form, Throwable e) {
        logger.error("Service Down:[WorkFlowApproveService.queryTaskOfCurrentPersonApproved]");
        logger.error(e.getMessage(), e.getCause());
        return new Pagination<>();
    }

    @HystrixCommand(fallbackMethod = "pickTaskScheduleDown")
    public Map<Integer, TaskNodeModel> pickTaskSchedule(IdForm form) {
        return taskFeign.pickTaskSchedule(form).pickBody();
    }
    public Map<Integer, TaskNodeModel> pickTaskScheduleDown(IdForm form, Throwable e) {
        logger.error("Service Down:[WorkFlowApproveService.pickTaskSchedule]");
        logger.error(e.getMessage(), e.getCause());
        return Maps.newHashMap();
    }

}
