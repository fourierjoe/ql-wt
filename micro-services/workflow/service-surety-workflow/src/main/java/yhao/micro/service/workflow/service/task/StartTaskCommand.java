package yhao.micro.service.workflow.service.task;

import org.apache.commons.lang.StringUtils;
import yhao.micro.service.workflow.apilist.form.task.TaskStartForm;
import yhao.micro.service.workflow.apilist.model.flow.FlowNodeModel;
import yhao.micro.service.workflow.dao.TaskDao;
import yhao.micro.service.workflow.service.pvm.ProcessSearcher;

import java.util.UUID;

public class StartTaskCommand extends TaskCommand {
    private TaskStartForm form;
    public StartTaskCommand(TaskDao taskDao, ProcessSearcher processSearcher,TaskStartForm form) {
        super(taskDao, processSearcher);
        this.form = form;
    }

    @Override
    protected void initContext() {
        if(StringUtils.isEmpty(form.getBizCodeStr())&&form.getBizCode()==null){
            throw new RuntimeException("必须设置业务编码");
        }
        if(form.getBizCode()!=null){        //优先使用预定义的业务编码
            form.setBizCodeStr(form.getBizCode().toString());
        }
        FlowNodeModel nextNode = processSearcher.findStartNode(form.getBizCodeStr());
        this.context.setNextNode(nextNode);
    }

    @Override
    protected TaskStartForm command() {
        startTask(form,this.context.getNextNode());
        return form;
    }
}
