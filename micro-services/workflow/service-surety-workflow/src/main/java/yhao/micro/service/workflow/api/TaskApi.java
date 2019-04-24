package yhao.micro.service.workflow.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.RestfulBaseController;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.workflow.apilist.form.task.*;
import yhao.micro.service.workflow.apilist.form.task.validatedGroup.RefuseTask;
import yhao.micro.service.workflow.apilist.model.task.ItemInfoModel;
import yhao.micro.service.workflow.apilist.model.task.RefuseTaskItemModel;
import yhao.micro.service.workflow.apilist.model.task.TaskModel;
import yhao.micro.service.workflow.apilist.model.task.TaskNodeModel;
import yhao.micro.service.workflow.service.TaskService;

import java.util.Map;

/**
 * 任务管理Api
 */
@RestController
@RequestMapping(value = "/task")
public class TaskApi extends RestfulBaseController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/startNewTask")
    public RequestResult<TaskStartForm> startNewTask(@RequestBody TaskStartForm form){
        return new RequestResult(taskService.startNewTask(form));
    }

    @Deprecated
    @PostMapping("/stopTask")
    public RequestResult<IdForm> stopTask(@RequestBody IdForm form){
        return new RequestResult(taskService.stopTask(form));
    }

    @Deprecated
    @PostMapping("/pickTask")
    public RequestResult<TaskModel> pickTask(@RequestBody IdForm form){
        return new RequestResult(taskService.pickTask(form));
    }


    /**
     * 只用于passTaskAuto方法
     * @param form
     * @return
     */
    @Deprecated
    @PostMapping("/dealTask")
    public RequestResult<Boolean> dealTask(@RequestBody TaskDealForm form){
        return new RequestResult(taskService.dealTask(form));
    }

    /**
     * 只用于passTaskAuto方法
     * @param form
     * @return
     */
    @Deprecated
    @PostMapping("/passTask")
    public RequestResult<Boolean> passTask(@RequestBody TaskDealPassForm form){
        return new RequestResult(taskService.passTask(form));
    }

    @PostMapping("/refuseTask")
    public RequestResult<Boolean> refuseTask(@RequestBody @Validated(value = RefuseTask.class) TaskDealRefuseForm form){
        return new RequestResult(taskService.refuseTask(form));
    }

    @Deprecated
    @PostMapping("/queryTask")
    public RequestResult<Pagination<TaskModel>> queryTask(@RequestBody TaskQueryForm form){
        return new RequestResult(taskService.queryTask(form));
    }

    /**
     * 结合dealTask和passTask方法
     * @param form
     * @return
     */
    @PostMapping("/passTaskAuto")
    public RequestResult<Boolean> passTaskAuto(@RequestBody TaskDealPassForm form){
        return new RequestResult(taskService.passTaskAuto(form));
    }

    /**
     * 查询任务状态
     * @param form
     * @return
     */
    @PostMapping("/pickTaskState")
    public RequestResult<TaskModel> pickTaskState(@RequestBody IdForm form){
        return new RequestResult(taskService.pickTaskState(form));
    }

    /**
     * 根据任务ID查询任务进度
     * @param form 传入业务主键
     * @return
     */
    @PostMapping("/pickTaskSchedule")
    public RequestResult<Map<Integer, TaskNodeModel>> pickTaskSchedule(@RequestBody IdForm form){
        return new RequestResult(taskService.pickTaskSchedule(form));
    }

    /**
     * 根据事项编码筛选任务
     * @param form
     * @return
     */
    @Deprecated
    @PostMapping("/pickTaskItemByItemCode")
    public RequestResult<ItemInfoModel> pickTaskItemByItemCode(@RequestBody ItemByItemCodeQueryForm form){
        return new RequestResult(taskService.pickTaskItemByItemCode(form));
    }

    /**
     * 传入业务主键
     * @param form
     * @return
     */
    @PostMapping("/pickRefuseForm")
    public RequestResult<RefuseTaskItemModel> pickRefuseForm(@RequestBody IdForm form){
        return new RequestResult(taskService.pickRefuseForm(form));
    }

    @PostMapping("/cancelTask")
    public RequestResult<Boolean> cancelTask(@RequestBody IdForm form){
        return new RequestResult(taskService.cancelTask(form));
    }
}
