package yhao.micro.service.surety.business.apilist.model.guarantee;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

import java.math.BigDecimal;

/**
 * @Description:
 * @Created by ql on 2018/12/10 20:35
 * @Version: v1.0
 */
public class SellerLoanModel extends Entity<String> {

    @ApiModelProperty("原贷款形式")
    private String loanType;

    @ApiModelProperty("原贷款金额")
    private BigDecimal loanAmount;

    @ApiModelProperty("原贷款余额")
    private BigDecimal loanBalance;

    @ApiModelProperty("原商贷银行名称")
    private String loanMbName;

    @ApiModelProperty("原商贷银行支行名称")
    private String loanMbBranchName;

    @ApiModelProperty("原商贷金额")
    private BigDecimal loanMbAmount;

    @ApiModelProperty("原商贷银行联系人")
    private String loanMbContantName;

    @ApiModelProperty("原商贷银行联系电话")
    private String loanMbContantTele;

    @ApiModelProperty("原公贷银行名称")
    private String loanPbName;

    @ApiModelProperty("原公贷银行支行名称")
    private String loanPbBranchName;

    @ApiModelProperty("原公贷金额")
    private BigDecimal loanPbAmount;

    @ApiModelProperty("原公贷银行联系人")
    private String loanPbContantName;

    @ApiModelProperty("原公贷银行联系电话")
    private String loanPbContantTele;

    @ApiModelProperty("主借款人")
    private String loanMajorPerson;

    @ApiModelProperty("共借人")
    private String loanOtherPerson;

    @ApiModelProperty("贷款情况备注")
    private String loanRemark;

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public BigDecimal getLoanBalance() {
        return loanBalance;
    }

    public void setLoanBalance(BigDecimal loanBalance) {
        this.loanBalance = loanBalance;
    }

    public String getLoanMbName() {
        return loanMbName;
    }

    public void setLoanMbName(String loanMbName) {
        this.loanMbName = loanMbName;
    }

    public String getLoanMbBranchName() {
        return loanMbBranchName;
    }

    public void setLoanMbBranchName(String loanMbBranchName) {
        this.loanMbBranchName = loanMbBranchName;
    }

    public BigDecimal getLoanMbAmount() {
        return loanMbAmount;
    }

    public void setLoanMbAmount(BigDecimal loanMbAmount) {
        this.loanMbAmount = loanMbAmount;
    }

    public String getLoanMbContantName() {
        return loanMbContantName;
    }

    public void setLoanMbContantName(String loanMbContantName) {
        this.loanMbContantName = loanMbContantName;
    }

    public String getLoanMbContantTele() {
        return loanMbContantTele;
    }

    public void setLoanMbContantTele(String loanMbContantTele) {
        this.loanMbContantTele = loanMbContantTele;
    }

    public String getLoanPbName() {
        return loanPbName;
    }

    public void setLoanPbName(String loanPbName) {
        this.loanPbName = loanPbName;
    }

    public String getLoanPbBranchName() {
        return loanPbBranchName;
    }

    public void setLoanPbBranchName(String loanPbBranchName) {
        this.loanPbBranchName = loanPbBranchName;
    }

    public BigDecimal getLoanPbAmount() {
        return loanPbAmount;
    }

    public void setLoanPbAmount(BigDecimal loanPbAmount) {
        this.loanPbAmount = loanPbAmount;
    }

    public String getLoanPbContantName() {
        return loanPbContantName;
    }

    public void setLoanPbContantName(String loanPbContantName) {
        this.loanPbContantName = loanPbContantName;
    }

    public String getLoanPbContantTele() {
        return loanPbContantTele;
    }

    public void setLoanPbContantTele(String loanPbContantTele) {
        this.loanPbContantTele = loanPbContantTele;
    }

    public String getLoanMajorPerson() {
        return loanMajorPerson;
    }

    public void setLoanMajorPerson(String loanMajorPerson) {
        this.loanMajorPerson = loanMajorPerson;
    }

    public String getLoanOtherPerson() {
        return loanOtherPerson;
    }

    public void setLoanOtherPerson(String loanOtherPerson) {
        this.loanOtherPerson = loanOtherPerson;
    }

    public String getLoanRemark() {
        return loanRemark;
    }

    public void setLoanRemark(String loanRemark) {
        this.loanRemark = loanRemark;
    }
}
