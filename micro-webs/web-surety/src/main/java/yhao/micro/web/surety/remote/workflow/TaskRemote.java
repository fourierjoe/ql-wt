package yhao.micro.web.surety.remote.workflow;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import yhao.micro.service.workflow.apilist.form.task.TaskDealPassForm;
import yhao.micro.service.workflow.apilist.form.task.TaskDealRefuseForm;
import yhao.micro.service.workflow.apilist.form.task.TaskStartForm;
import yhao.micro.service.workflow.apilist.restful.TaskFeign;

import javax.annotation.Resource;

/**
 * @Description:
 * @Created by ql on 2018/12/13 18:06
 * @Version: v1.0
 */
@Service
public class TaskRemote {

    private Logger logger = LoggerFactory.getLogger(ProcessRemote.class);

    @Resource
    private TaskFeign taskFeign;

    @HystrixCommand
    public void startNewTask(TaskStartForm form) {
        taskFeign.startNewTask(form);
    }

    @HystrixCommand
    public boolean passTaskAuto(TaskDealPassForm form) {
        return taskFeign.passTaskAuto(form).pickBody();
    }

    @HystrixCommand
    public boolean refuseTask(TaskDealRefuseForm form) {
        return taskFeign.refuseTask(form).pickBody();
    }
}
