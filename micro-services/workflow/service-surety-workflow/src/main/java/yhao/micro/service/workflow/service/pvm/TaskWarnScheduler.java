package yhao.micro.service.workflow.service.pvm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import yhao.infra.common.model.Pagination;
import yhao.infra.common.util.CommonDateUtil;
import yhao.infra.common.util.CommonListUtil;
import yhao.infra.common.util.RandomUtil;
import yhao.micro.service.workflow.apilist.form.task.TaskNodeWarnCheckTimeUpdateForm;
import yhao.micro.service.workflow.apilist.model.task.TaskNodeWarnModel;
import yhao.micro.service.workflow.dao.TaskDao;

import java.util.Date;
import java.util.stream.Collectors;

@Component
public class TaskWarnScheduler {
    @Autowired
    private TaskDao taskDao;

    /**
     * 如果任务数量变大，需要考虑分页查询
     */
    @Scheduled(fixedDelay = 300000) //5分钟
    public void checkTask(){
        try {
            //让其他节点有时间处理
            Thread.sleep(RandomUtil.makeRandomNumber(4));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //查询检查时间在5分钟之前且endTime不为空的数据
        while(true){
            Pagination<TaskNodeWarnModel> page = new Pagination<>(50,1,false);
            Date now = new Date();
            taskDao.queryUnFlowTask(page, CommonDateUtil.addMinute(now,-5));
            if(CommonListUtil.isEmpty(page.getItems())){
                break;
            }
            //先一步更新检查时间，避免重复读取
            TaskNodeWarnCheckTimeUpdateForm form = new TaskNodeWarnCheckTimeUpdateForm();
            form.setCheckTime(now);
            form.setWarnId(page.getItems().stream().map(o->o.getId()).collect(Collectors.toList()));
            taskDao.updateTaskNodeWarnCheckTime(form);

            for(TaskNodeWarnModel warn:page.getItems()){
                int flag = warn.getWarnFlag();
                if(warn.getLimitWarnTime()!=null && now.after(warn.getLimitWarnTime())){
                    flag = flag | 0b0001;
                    doWarn(0);
                }
                if(warn.getLevelOneTime()!=null && now.after(warn.getLevelOneTime())){
                    flag = flag | 0b0010;
                    doWarn(1);
                }
                if(warn.getLevelTwoTime()!=null && now.after(warn.getLevelTwoTime())){
                    flag = flag | 0b0100;
                    doWarn(2);
                }
                if(warn.getLevelThreeTime()!=null && now.after(warn.getLevelThreeTime())){
                    flag = flag | 0b1000;
                    doWarn(3);
                }
                warn.setCheckTime(now);
                warn.setWarnFlag(flag);
                taskDao.checkTaskNodeWarn(warn);
            }
        }
    }

    //TODO 做具体的预警动作
    private void doWarn(int level){
        switch (level){
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }
}
