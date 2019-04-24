package yhao.micro.service.workflow.service.task;

import yhao.infra.apilist.validate.IdForm;
import yhao.micro.service.workflow.apilist.enums.task.TaskStatus;
import yhao.micro.service.workflow.apilist.model.task.TaskModel;
import yhao.micro.service.workflow.dao.TaskDao;
import yhao.micro.service.workflow.service.pvm.ProcessSearcher;

public class StopTaskCommand extends TaskCommand {
    private IdForm form;
    public StopTaskCommand(TaskDao taskDao, ProcessSearcher processSearcher, IdForm form) {
        super(taskDao, processSearcher);
        this.form = form;
    }

    @Override
    protected void initContext() {
        initDealTask(form);
    }

    @Override
    protected IdForm command() {
        TaskModel task = context.getTask();
        task.setStatus(TaskStatus.STOP);
        task.setUpdateOperatorId(form.getOperatorId());
        taskDao.taskGoToEnd(task);
        return form;
    }
}
