package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/21 17:12
 * @Description:
 */
public class RedeemOrderConfigForm implements ValidationForm {
    @ApiModelProperty(value = "担保单id")
    private String guaranteePid;
    @ApiModelProperty(value = "出赎楼歀银行ID",example = "string")
    private String redeemFundProviderId;
    @ApiModelProperty(value = "原贷款银行ID",example = "string")
    private String previousFundProviderId;
    @ApiModelProperty(value = "指令有效期类型，如：WORK_DAY",example = "WORK_DAY")
    private String validityType;
    @ApiModelProperty(value = "天数",example = "5")
    private Integer dayCount;

    public String getGuaranteePid() {
        return guaranteePid;
    }

    public void setGuaranteePid(String guaranteePid) {
        this.guaranteePid = guaranteePid;
    }

    public String getRedeemFundProviderId() {
        return redeemFundProviderId;
    }

    public void setRedeemFundProviderId(String redeemFundProviderId) {
        this.redeemFundProviderId = redeemFundProviderId;
    }

    public String getPreviousFundProviderId() {
        return previousFundProviderId;
    }

    public void setPreviousFundProviderId(String previousFundProviderId) {
        this.previousFundProviderId = previousFundProviderId;
    }

    public String getValidityType() {
        return validityType;
    }

    public void setValidityType(String validityType) {
        this.validityType = validityType;
    }

    public Integer getDayCount() {
        return dayCount;
    }

    public void setDayCount(Integer dayCount) {
        this.dayCount = dayCount;
    }
}
