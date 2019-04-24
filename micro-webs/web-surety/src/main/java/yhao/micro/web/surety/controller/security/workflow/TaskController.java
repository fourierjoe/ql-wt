package yhao.micro.web.surety.controller.security.workflow;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Lazy;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yhao.micro.service.workflow.apilist.form.task.TaskDealPassForm;
import yhao.micro.service.workflow.apilist.form.task.TaskDealRefuseForm;
import yhao.micro.service.workflow.apilist.form.task.TaskStartForm;
import yhao.micro.service.workflow.apilist.form.task.validatedGroup.RefuseTask;
import yhao.micro.web.surety.controller.WebBaseController;
import yhao.micro.web.surety.remote.workflow.TaskRemote;

import javax.annotation.Resource;

/**
 * @Description:
 * @Created by ql on 2018/12/10 21:36
 * @Version: v1.0
 */
@Lazy
@RestController
@RequestMapping(value = "/security/workflow/task", produces = {"application/json;charset=UTF-8"})
@Api(value = "TaskController", tags = "流程中心-任务流转")
public class TaskController extends WebBaseController {

    @Resource
    private TaskRemote taskRemote;


    @PostMapping("/startNewTask")
    @ApiOperation(value = "启动任务")
    public String startNewTask(@RequestBody TaskStartForm form){
        taskRemote.startNewTask(form);
        return returnSuccessInfo();
    }

    @PostMapping("/passTaskAuto")
    @ApiOperation(value = "自动处理事项通过节点")
    public String passTaskAuto(@RequestBody TaskDealPassForm form){
        form.getTaskNodeItem().setItemFinishPerson(getCurrentPerson().getId());
        form.getTaskNodeItem().setItemFinishPersonOrgId(getCurrentPerson().getOrgId());
        taskRemote.passTaskAuto(form);
        return returnSuccessInfo();
    }

    @PostMapping("/refuseTask")
    @ApiOperation(value = "子流程审批驳回节点")
    public String refuseTask(@RequestBody @Validated(value = RefuseTask.class) TaskDealRefuseForm form){
        form.getTaskNodeItem().setItemFinishPerson(getCurrentPerson().getId());
        form.getTaskNodeItem().setItemFinishPersonOrgId(getCurrentPerson().getOrgId());
        taskRemote.refuseTask(form);
        return returnSuccessInfo();
    }
}
