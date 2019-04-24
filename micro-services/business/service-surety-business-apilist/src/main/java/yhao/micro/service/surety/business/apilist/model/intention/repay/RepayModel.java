package yhao.micro.service.surety.business.apilist.model.intention.repay;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
import yhao.infra.common.model.Entity;

import java.util.Date;

/**
 * @Description:
 * @Created by ql on 2018/12/10 17:56
 * @Version: v1.0
 */
@ApiModel
public class RepayModel extends Entity<String> {

    @ApiModelProperty(value = "担保单编号")
    private String guaranteeNum;

    @ApiModelProperty(value = "单据类型")
    private String guaranteeType;

    @ApiModelProperty(value = "业务类型")
    private String businessName;

    @ApiModelProperty("客户经理姓名")
    private String managerName;

    @ApiModelProperty(value = "客户经理电话")
    private String phone;

    @ApiModelProperty("还款申请安排办理日期")
    private Date repayExpectedDate;

    @ApiModelProperty("还款申请实际办理日期")
    private Date repayRealDate;

    @ApiModelProperty("可赎楼时间")
    private Date redemDate;

    @ApiModelProperty(value = "是否有信用贷款")
    private String isLoan;

    @ApiModelProperty(value = "是否要罚息")
    private String isPenalty;

    @ApiModelProperty(value = "是否预存")
    private String isPrestore;

    @ApiModelProperty(value = "预存天数")
    private int prestoreDays;

    @ApiModelProperty(value = "供楼清单URL")
    private String floorListUrls;

    @ApiModelProperty(value = "申请回执URL")
    private String applicationReceiptUrls;

    @ApiModelProperty(value = "贷款合同URL")
    private String loanAgreementUrls;

    @ApiModelProperty(value = "处理意见")
    private String remarks;

    @ApiModelProperty(value = "创建日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getGuaranteeNum() {
        return guaranteeNum;
    }

    public void setGuaranteeNum(String guaranteeNum) {
        this.guaranteeNum = guaranteeNum;
    }

    public String getGuaranteeType() {
        return guaranteeType;
    }

    public void setGuaranteeType(String guaranteeType) {
        this.guaranteeType = guaranteeType;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getRepayExpectedDate() {
        return repayExpectedDate;
    }

    public void setRepayExpectedDate(Date repayExpectedDate) {
        this.repayExpectedDate = repayExpectedDate;
    }

    public Date getRepayRealDate() {
        return repayRealDate;
    }

    public void setRepayRealDate(Date repayRealDate) {
        this.repayRealDate = repayRealDate;
    }

    public Date getRedemDate() {
        return redemDate;
    }

    public void setRedemDate(Date redemDate) {
        this.redemDate = redemDate;
    }

    public String getIsLoan() {
        return isLoan;
    }

    public void setIsLoan(String isLoan) {
        this.isLoan = isLoan;
    }

    public String getIsPenalty() {
        return isPenalty;
    }

    public void setIsPenalty(String isPenalty) {
        this.isPenalty = isPenalty;
    }

    public String getIsPrestore() {
        return isPrestore;
    }

    public void setIsPrestore(String isPrestore) {
        this.isPrestore = isPrestore;
    }

    public int getPrestoreDays() {
        return prestoreDays;
    }

    public void setPrestoreDays(int prestoreDays) {
        this.prestoreDays = prestoreDays;
    }

    public String getFloorListUrls() {
        return floorListUrls;
    }

    public void setFloorListUrls(String floorListUrls) {
        this.floorListUrls = floorListUrls;
    }

    public String getApplicationReceiptUrls() {
        return applicationReceiptUrls;
    }

    public void setApplicationReceiptUrls(String applicationReceiptUrls) {
        this.applicationReceiptUrls = applicationReceiptUrls;
    }

    public String getLoanAgreementUrls() {
        return loanAgreementUrls;
    }

    public void setLoanAgreementUrls(String loanAgreementUrls) {
        this.loanAgreementUrls = loanAgreementUrls;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
