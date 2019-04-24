package yhao.micro.service.surety.business.apilist.form.finance;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import org.springframework.format.annotation.DateTimeFormat;
import yhao.infra.apilist.ValidationForm;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.micro.service.surety.business.apilist.model.enums.finance.PayBackTypeEnum;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/11 20:45
 * @Description:
 */
public class FundPayBackSaveForm extends IdUnForm {
    @ApiModelProperty(value = "担保单id", required = true)
    private String guaranteeId;
    @ApiModelProperty(value = "回款账号", required = true)
    private String repayAccountId;
    @ApiModelProperty(value = "公司账号", required = true)
    private String companyAccountId;
    @ApiModelProperty(value = "回款金额", required = true)
    private BigDecimal repayAmount;
    @ApiModelProperty(value = "回款日期", required = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date paybackDate;
    @ApiModelProperty(value = "类型", required = true)
    private PayBackTypeEnum repayType;
    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty(value = "借款总金额", required = true)
    private BigDecimal loanTotalAmount;
    @ApiModelProperty(value = "借款金额", required = true)
    private BigDecimal loanAmount;
    @ApiModelProperty(value = "借款id", required = true)
    private String loanId;
    @ApiModelProperty(value = "回款概况id", hidden = true)
    private String paybackGeneralId;
    @ApiModelProperty(value = "应还款日期", example = "2019-03-03", required = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date arrangedRepay;


    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public String getCompanyAccountId() {
        return companyAccountId;
    }

    public void setCompanyAccountId(String companyAccountId) {
        this.companyAccountId = companyAccountId;
    }

    public BigDecimal getRepayAmount() {
        return repayAmount;
    }

    public void setRepayAmount(BigDecimal repayAmount) {
        this.repayAmount = repayAmount;
    }

    public Date getPaybackDate() {
        return paybackDate;
    }

    public void setPaybackDate(Date paybackDate) {
        this.paybackDate = paybackDate;
    }

    public PayBackTypeEnum getRepayType() {
        return repayType;
    }

    public void setRepayType(PayBackTypeEnum repayType) {
        this.repayType = repayType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public String getPaybackGeneralId() {
        return paybackGeneralId;
    }

    public void setPaybackGeneralId(String paybackGeneralId) {
        this.paybackGeneralId = paybackGeneralId;
    }


    public Date getArrangedRepay() {
        return arrangedRepay;
    }

    public void setArrangedRepay(Date arrangedRepay) {
        this.arrangedRepay = arrangedRepay;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public BigDecimal getLoanTotalAmount() {
        return loanTotalAmount;
    }

    public void setLoanTotalAmount(BigDecimal loanTotalAmount) {
        this.loanTotalAmount = loanTotalAmount;
    }

    public String getRepayAccountId() {
        return repayAccountId;
    }

    public void setRepayAccountId(String repayAccountId) {
        this.repayAccountId = repayAccountId;
    }
}
