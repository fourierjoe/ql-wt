package yhao.micro.service.surety.business.apilist.model.guarantee;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description:
 * @Created by ql on 2018/12/10 20:32
 * @Version: v1.0
 */
public class BuyerLoanModel extends Entity<String> {

    @ApiModelProperty("商贷银行名称")
    private String loanMbName;

    @ApiModelProperty("商贷金额")
    private BigDecimal loanMbAmount;

    @ApiModelProperty("商贷联系人姓名")
    private String loanMbContantName;

    @ApiModelProperty("商贷联系人电话")
    private String loanMbContantTele;

    @ApiModelProperty("退尾款账户名")
    private String refundAccountNam;

    @ApiModelProperty("退尾款账号")
    private String refundAccountNum;

    @ApiModelProperty("退尾款开户行")
    private String refundAccountBank;

    @ApiModelProperty("监管账户名")
    private String supervisionAccountNam;

    @ApiModelProperty("监管账号")
    private String supervisionAccountNum;

    @ApiModelProperty("监管开户行")
    private String supervisionAccountBank;

/*********************************************************/
    @ApiModelProperty("监管银行1名称")
    private String supervisionBankNameOne;

    @ApiModelProperty("监管金额1")
    private BigDecimal supervisionAmountOne;

    @ApiModelProperty("监管联系人1")
    private String supervisionContantOne;

    @ApiModelProperty("监管电话1")
    private Date supervisionContantTeleOne;

    @ApiModelProperty("监管银行2名称")
    private String supervisionBankNameTwo;

    @ApiModelProperty("监管金额2")
    private BigDecimal supervisionAmountTwo;

    @ApiModelProperty("监管联系人2")
    private String supervisionContantTwo;

    @ApiModelProperty("监管电话2")
    private Date supervisionContantTeleTwo;

    public String getLoanMbName() {
        return loanMbName;
    }

    public void setLoanMbName(String loanMbName) {
        this.loanMbName = loanMbName;
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

    public String getRefundAccountNam() {
        return refundAccountNam;
    }

    public void setRefundAccountNam(String refundAccountNam) {
        this.refundAccountNam = refundAccountNam;
    }

    public String getRefundAccountNum() {
        return refundAccountNum;
    }

    public void setRefundAccountNum(String refundAccountNum) {
        this.refundAccountNum = refundAccountNum;
    }

    public String getRefundAccountBank() {
        return refundAccountBank;
    }

    public void setRefundAccountBank(String refundAccountBank) {
        this.refundAccountBank = refundAccountBank;
    }

    public String getSupervisionAccountNam() {
        return supervisionAccountNam;
    }

    public void setSupervisionAccountNam(String supervisionAccountNam) {
        this.supervisionAccountNam = supervisionAccountNam;
    }

    public String getSupervisionAccountNum() {
        return supervisionAccountNum;
    }

    public void setSupervisionAccountNum(String supervisionAccountNum) {
        this.supervisionAccountNum = supervisionAccountNum;
    }

    public String getSupervisionAccountBank() {
        return supervisionAccountBank;
    }

    public void setSupervisionAccountBank(String supervisionAccountBank) {
        this.supervisionAccountBank = supervisionAccountBank;
    }

    public String getSupervisionBankNameOne() {
        return supervisionBankNameOne;
    }

    public void setSupervisionBankNameOne(String supervisionBankNameOne) {
        this.supervisionBankNameOne = supervisionBankNameOne;
    }

    public BigDecimal getSupervisionAmountOne() {
        return supervisionAmountOne;
    }

    public void setSupervisionAmountOne(BigDecimal supervisionAmountOne) {
        this.supervisionAmountOne = supervisionAmountOne;
    }

    public String getSupervisionContantOne() {
        return supervisionContantOne;
    }

    public void setSupervisionContantOne(String supervisionContantOne) {
        this.supervisionContantOne = supervisionContantOne;
    }

    public Date getSupervisionContantTeleOne() {
        return supervisionContantTeleOne;
    }

    public void setSupervisionContantTeleOne(Date supervisionContantTeleOne) {
        this.supervisionContantTeleOne = supervisionContantTeleOne;
    }

    public String getSupervisionBankNameTwo() {
        return supervisionBankNameTwo;
    }

    public void setSupervisionBankNameTwo(String supervisionBankNameTwo) {
        this.supervisionBankNameTwo = supervisionBankNameTwo;
    }

    public BigDecimal getSupervisionAmountTwo() {
        return supervisionAmountTwo;
    }

    public void setSupervisionAmountTwo(BigDecimal supervisionAmountTwo) {
        this.supervisionAmountTwo = supervisionAmountTwo;
    }

    public String getSupervisionContantTwo() {
        return supervisionContantTwo;
    }

    public void setSupervisionContantTwo(String supervisionContantTwo) {
        this.supervisionContantTwo = supervisionContantTwo;
    }

    public Date getSupervisionContantTeleTwo() {
        return supervisionContantTeleTwo;
    }

    public void setSupervisionContantTeleTwo(Date supervisionContantTeleTwo) {
        this.supervisionContantTeleTwo = supervisionContantTeleTwo;
    }
}
