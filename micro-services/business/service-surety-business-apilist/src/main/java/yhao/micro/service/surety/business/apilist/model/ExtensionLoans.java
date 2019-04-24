package yhao.micro.service.surety.business.apilist.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Description
 * @Author leice
 * @Date 2019/2/27 15:59
 * @Version 1.0
 */
public class ExtensionLoans implements Serializable {

    @ApiModelProperty("借款id")
    private String loanId;

    @ApiModelProperty("借款金额")
    private Double loanAmount;

    @ApiModelProperty("剩余借款")
    private Double residualLoan;

    @ApiModelProperty("应还款日")
    private String repaymentDate;

    @ApiModelProperty("展期次数")
    private Integer extensionsNumber;

    @ApiModelProperty("是否存在未收费的展期申请 1:是 2:否")
    private Integer NoFee;

    @ApiModelProperty("业务类型 额度=AMOUNT,现金=CASH")
    private String types;

    public Integer getNoFee() {
        return NoFee;
    }

    public void setNoFee(Integer noFee) {
        NoFee = noFee;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Double getResidualLoan() {
        return residualLoan;
    }

    public void setResidualLoan(Double residualLoan) {
        this.residualLoan = residualLoan;
    }

    public String getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(String repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public Integer getExtensionsNumber() {
        return extensionsNumber;
    }

    public void setExtensionsNumber(Integer extensionsNumber) {
        this.extensionsNumber = extensionsNumber;
    }
}
