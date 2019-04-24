package yhao.micro.service.workflow.apilist.enums.task;

import yhao.micro.service.constants.model.EnumModel;
import yhao.micro.service.workflow.apilist.enums.task.rule.*;

import java.util.ArrayList;
import java.util.List;

public enum  RuleItemType {
    EQ("==","等于",new EqItemMatcher()),
    NEQ("≠","不等于",new NeqItemMatcher()),
    GT("＞","大于",new GtItemMatcher()),
    EGT("≥","大于等于",new EgtItemMatcher()),
    LT("＜","小于",new LtItemMatcher()),
    ELT("≤","小于等于",new EltItemMatcher())
    ;

    private String show;
    private String desc;
    private ItemMatcher matcher;

    RuleItemType(String show, String desc,ItemMatcher matcher) {
        this.show = show;
        this.desc = desc;
        this.matcher = matcher;
    }

    public String getShow() {
        return show;
    }

    public String getDesc() {
        return desc;
    }

    public static List<EnumModel> toEnumModelList(){
        List<EnumModel> enumModelList = new ArrayList<>();
        for (RuleItemType ruleItemType : RuleItemType.values()) {
            EnumModel enumModel = new EnumModel();
            enumModel.setName(ruleItemType.getDesc());
            enumModel.setValue(ruleItemType.name());
            enumModelList.add(enumModel);
        }
        return enumModelList;
    }

    /**
     * @param expect 期望结果
     * @param result 给定结果
     * @return
     */
    public boolean match(String expect,String result){
        return this.matcher.match(expect,result);
    }
}
