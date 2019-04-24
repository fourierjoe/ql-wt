package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.micro.service.surety.business.apilist.model.enums.complex.EssentialsStatus;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/10 14:38
 * @Description:
 */
public class EssentialsQueryResultForm extends RedemptionBaseResultForm {
    @ApiModelProperty("要件状态")
    private EssentialsStatus status;
    @ApiModelProperty("操作天数")
    private String operatDays;
    @ApiModelProperty("差异")
    private String diff;

    public EssentialsStatus getStatus() {
        return status;
    }

    public void setStatus(EssentialsStatus status) {
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
