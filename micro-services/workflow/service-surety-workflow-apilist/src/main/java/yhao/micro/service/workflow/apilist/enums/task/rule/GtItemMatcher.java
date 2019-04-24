package yhao.micro.service.workflow.apilist.enums.task.rule;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

public class GtItemMatcher implements ItemMatcher {
    @Override
    public boolean match(String expect, String result) {
        if(StringUtils.isEmpty(expect)||StringUtils.isEmpty(result)){
            return false;
        }
        BigDecimal expectBg = new BigDecimal(expect);
        BigDecimal resultBg = new BigDecimal(result);
        return resultBg.compareTo(expectBg)==1;
    }
}
