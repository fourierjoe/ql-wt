package yhao.micro.service.workflow.apilist.enums.task;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 业务类型定义
 */
public enum TaskBizCode {
    CODE1("业务一"),
    CODE2("业务二"),
    ;

    private String desc;
    private static Map<String,TaskBizCode> codeMap = new HashMap<>();
    TaskBizCode(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    static{
        for(TaskBizCode code:TaskBizCode.values()){
            codeMap.put(code.name(),code);
        }
    }

    /**
     * 判断给定业务编码是否是已定义的业务编码
     * @param bizCode
     * @return
     */
    public boolean containCode(String bizCode){
        return codeMap.containsKey(bizCode);
    }

    /**
     * 返回定义的业务编码
     * @param bizCode
     * @return 若不存在定义编码，则返回null
     */
    public TaskBizCode pickBizCode(String bizCode){
        return codeMap.get(bizCode);
    }
}
