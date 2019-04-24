package yhao.micro.service.workflow.apilist.enums.task.rule;

import org.apache.commons.lang3.StringUtils;

public class NeqItemMatcher implements ItemMatcher {
    @Override
    public boolean match(String expect, String result) {
        if(StringUtils.isEmpty(expect)||StringUtils.isEmpty(result)){
            return false;
        }
        return !expect.equals(result);
    }
}
