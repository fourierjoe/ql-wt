package yhao.micro.service.workflow.apilist.restful;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.workflow.apilist.form.task.*;
import yhao.micro.service.workflow.apilist.model.task.ItemInfoModel;
import yhao.micro.service.workflow.apilist.model.task.RefuseTaskItemModel;
import yhao.micro.service.workflow.apilist.model.task.TaskModel;
import yhao.micro.service.workflow.apilist.model.task.TaskNodeModel;

import java.util.Map;

@FeignClient(ZoneConstants.FEIGN_URL)
public interface TaskFeign {
    @RequestMapping(value = "/task/startNewTask",method = RequestMethod.POST)
    RequestResult<TaskStartForm> startNewTask(TaskStartForm form);

    @PostMapping("/task/stopTask")
    RequestResult<IdForm> stopTask(IdForm form);

    @PostMapping("/task/pickTask")
    RequestResult<TaskModel> pickTask(IdForm form);

    @PostMapping("/task/dealTask")
    RequestResult<Boolean> dealTask(TaskDealForm form);

    @PostMapping("/task/passTask")
    RequestResult<Boolean> passTask(TaskDealPassForm form);

    @PostMapping("/task/refuseTask")
    RequestResult<Boolean> refuseTask(TaskDealRefuseForm form);

    @PostMapping("/task/queryTask")
    RequestResult<Pagination<TaskModel>> queryTask(TaskQueryForm form);

    @PostMapping("/task/passTaskAuto")
    RequestResult<Boolean> passTaskAuto(TaskDealPassForm form);

    @PostMapping("/task/pickTaskState")
    RequestResult<TaskModel> pickTaskState(IdForm form);

    /**
     * 根据事项编码筛选任务
     * @param form
     * @return
     */
    @PostMapping("/task/pickTaskItemByItemCode")
    RequestResult<ItemInfoModel> pickTaskItemByItemCode(ItemByItemCodeQueryForm form);

    @PostMapping("/task/pickTaskSchedule")
    RequestResult<Map<Integer, TaskNodeModel>> pickTaskSchedule(IdForm form);

    @PostMapping("/task/pickRefuseForm")
    RequestResult<RefuseTaskItemModel> pickRefuseForm(IdForm form);

    @PostMapping("/task/cancelTask")
    RequestResult<Boolean> cancelTask(IdForm form);
}
