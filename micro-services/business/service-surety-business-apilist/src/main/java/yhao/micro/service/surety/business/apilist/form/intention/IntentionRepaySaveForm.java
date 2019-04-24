package yhao.micro.service.surety.business.apilist.form.intention;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import yhao.infra.apilist.validate.IdForm;
import yhao.micro.service.constants.enums.YNEnum;
import yhao.micro.service.surety.business.apilist.model.enums.intention.CreditAndRepayScheduleEnum;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class IntentionRepaySaveForm extends IdForm {

    @ApiModelProperty(value = "担保单id",required = true)
    private String guaranteeId;

    @ApiModelProperty(value = "还款申请办理状态", hidden = true)
    @NotNull(message = "还款申请办理状态不得为空")
    private CreditAndRepayScheduleEnum repayState = CreditAndRepayScheduleEnum.DEALED;

    @ApiModelProperty(value = "还款申请实际办理日期", required = true)
    @NotNull(message = "还款申请实际办理日期不得为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date repayRealDate;

    @ApiModelProperty(value = "可赎楼时间",required = true)
    @NotNull(message = "可赎楼时间不得为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date redemDate;

    @ApiModelProperty(value = "是否有信用贷款", example = "YES/NO", required = true)
    @NotNull(message = "是否有信用贷款不得为空")
    private YNEnum isLoan;

    @ApiModelProperty(value = "是否要罚息", example = "YES/NO", required = true)
    @NotNull(message = "是否要罚息不得为空")
    private YNEnum isPenalty;

    @ApiModelProperty(value = "是否预存", example = "YES/NO", required = true)
    @NotNull(message = "是否预存不得为空")
    private YNEnum isPrestore;

    @ApiModelProperty(value = "预存天数", example = "3")
    private int prestoreDays;

    @ApiModelProperty(value = "供楼清单URL")
    private String floorListUrls;

    @ApiModelProperty(value = "申请回执URL")
    private String applicationReceiptUrls;

    @ApiModelProperty(value = "贷款合同URL")
    private String loanAgreementUrls;

    @ApiModelProperty(value = "处理意见")
    private String remarks;

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public int getPrestoreDays() {
        return prestoreDays;
    }

    public void setPrestoreDays(int prestoreDays) {
        this.prestoreDays = prestoreDays;
    }

    public CreditAndRepayScheduleEnum getRepayState() {
        return repayState;
    }

    public void setRepayState(CreditAndRepayScheduleEnum repayState) {
        this.repayState = repayState;
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

    public YNEnum getIsLoan() {
        return isLoan;
    }

    public void setIsLoan(YNEnum isLoan) {
        this.isLoan = isLoan;
    }

    public YNEnum getIsPenalty() {
        return isPenalty;
    }

    public void setIsPenalty(YNEnum isPenalty) {
        this.isPenalty = isPenalty;
    }

    public YNEnum getIsPrestore() {
        return isPrestore;
    }

    public void setIsPrestore(YNEnum isPrestore) {
        this.isPrestore = isPrestore;
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
