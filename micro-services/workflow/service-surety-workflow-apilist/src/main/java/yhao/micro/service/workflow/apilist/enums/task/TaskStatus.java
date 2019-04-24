package yhao.micro.service.workflow.apilist.enums.task;

import yhao.micro.service.constants.model.EnumModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 任务状态定义
 */
public enum TaskStatus {
    SUB_TASK("子任务执行中"),
    RUNNING("任务执行中"),
    STOP("任务终止"),
    END("任务正常完成"),
    REJECT("任务驳回"),
    AHEAD_END("任务提前完成"),
    CANCEL("撤单"),
    UNVALID("未定义"),
    ;

    public static List<EnumModel> toEnumModelList(){
        List<EnumModel> enumModelList = new ArrayList<>();
        for (TaskStatus taskStatus : TaskStatus.values()) {
            EnumModel enumModel = new EnumModel();
            enumModel.setName(taskStatus.getDesc());
            enumModel.setValue(taskStatus.name());
            enumModelList.add(enumModel);
        }
        return enumModelList;
    }

    private String desc;

    TaskStatus(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
