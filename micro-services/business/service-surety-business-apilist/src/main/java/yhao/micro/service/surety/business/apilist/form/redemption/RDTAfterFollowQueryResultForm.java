package yhao.micro.service.surety.business.apilist.form.redemption;

import io.swagger.annotations.ApiModelProperty;
import yhao.micro.service.surety.business.apilist.form.complex.RedemptionBaseResultForm;
import yhao.micro.service.surety.business.apilist.model.guarantee.page.GuaranteePageModel;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/11 14:51
 * @Description: 赎楼后管理查询返回
 */
public class RDTAfterFollowQueryResultForm extends GuaranteePageModel {
    @ApiModelProperty("操作天数")
    private String operateDays;
    @ApiModelProperty("差异")
    private String diff;

    public String getOperateDays() {
        return operateDays;
    }

    public void setOperateDays(String operateDays) {
        this.operateDays = operateDays;
    }

    public String getDiff() {
        return diff;
    }

    public void setDiff(String diff) {
        this.diff = diff;
    }
}
