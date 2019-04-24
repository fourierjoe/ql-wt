package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.micro.service.surety.business.apilist.model.enums.complex.RedemptionEnsureStatus;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/10 14:36
 * @Description:
 */
public class BilingCheckQueryResultForm extends RedemptionBaseResultForm {
    @ApiModelProperty("银行到账状态,ARRIVAL=到账,ONE_ARRIVAL 已一次到账 ")
    private String fundStatus;
    private RedemptionEnsureStatus status;
    @ApiModelProperty("操作天数")
    private String operatDays;
    @ApiModelProperty("差异")
    private String diff;

    public String getFundStatus() {
        return fundStatus;
    }

    public void setFundStatus(String fundStatus) {
        this.fundStatus = fundStatus;
    }

    public RedemptionEnsureStatus getStatus() {
        return status;
    }

    public void setStatus(RedemptionEnsureStatus status) {
        this.status = status;
    }

    public String getOperatDays() {
        return operatDays;
    }

    public void setOperatDays(String operatDays) {
        this.operatDays = operatDays;
    }

    public String getDiff() {
        return diff;
    }

    public void setDiff(String diff) {
        this.diff = diff;
    }
}
