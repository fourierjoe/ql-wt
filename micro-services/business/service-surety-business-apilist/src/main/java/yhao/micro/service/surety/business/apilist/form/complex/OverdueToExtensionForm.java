package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Description
 * @Author leice
 * @Date 2019/1/8 19:22
 * @Version 1.0
 */
public class OverdueToExtensionForm extends Entity<String> {

    @ApiModelProperty("担保单id")
    private String warrantyId;

    @ApiModelProperty("借款id")
    private String loanId;

    @ApiModelProperty("回款id")
    private String paybackId;

    @ApiModelProperty("逾期费率")
    private Double overDueRate;

    @ApiModelProperty("申请费率")
    @NotNull(message = "申请费率不能为空")
    @Min(0)
    @Max(100)
    private Double rate;

    public Double getOverDueRate() {
        return overDueRate;
    }

    public void setOverDueRate(Double overDueRate) {
        this.overDueRate = overDueRate;
    }

    public String getWarrantyId() {
        return warrantyId;
    }

    public void setWarrantyId(String warrantyId) {
        this.warrantyId = warrantyId;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public String getPaybackId() {
        return paybackId;
    }

    public void setPaybackId(String paybackId) {
        this.paybackId = paybackId;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "OverdueToExtensionForm{" +
                "warrantyId='" + warrantyId + '\'' +
                ", loanId='" + loanId + '\'' +
                ", paybackId='" + paybackId + '\'' +
                ", overDueRate=" + overDueRate +
                ", rate=" + rate +
                '}';
    }
}
