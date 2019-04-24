package yhao.micro.service.workflow.apilist.enums.flow;

import yhao.micro.service.constants.model.EnumModel;

import java.util.ArrayList;
import java.util.List;

public enum ProcessDefinitionType {
    FXGK("风险管控"),
    DBYW("担保业务"),
    DBCW("担保财务"),
    UNVALID("未定义"),
    ;

    ProcessDefinitionType(String desc) {
        this.desc = desc;
    }

    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static List<EnumModel> toEnumModelList(){
        List<EnumModel> enumModelList = new ArrayList<>();
        for (ProcessDefinitionType processDefinitionType : ProcessDefinitionType.values()) {
            EnumModel enumModel = new EnumModel();
            enumModel.setName(processDefinitionType.getDesc());
            enumModel.setValue(processDefinitionType.name());
            enumModelList.add(enumModel);
        }
        return enumModelList;
    }
}
