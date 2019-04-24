package yhao.micro.service.surety.business.apilist.form.guarantee;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.micro.service.constants.enums.YNEnum;

import java.sql.Date;

/**
 * @Description:
 * @Created by ql on 2019/1/2 18:41
 * @Version: v1.0
 */
public class RepaySaveForm extends IdUnForm {
	@ApiModelProperty(value = "担保单ID", hidden = true)
	private String guaranteeId;

	@ApiModelProperty(value = "还款申请类型")
	private String repayType;

	@ApiModelProperty(value = "还款申请安排时间")
	private Date repayExpectedDate;

	@ApiModelProperty(value = "还款申请实际填写时间")
	private Date repayRealDate;

	@ApiModelProperty(value = "可赎楼时间")
	private Date redemDate;

	@ApiModelProperty(value = "是否有信用贷款")
	private YNEnum isLoan;

	@ApiModelProperty(value = "是否罚息")
	private YNEnum isPenalty;

	@ApiModelProperty(value = "是否要预存")
	private YNEnum isPrestore;

	@ApiModelProperty(value = "预存天数")
	private Integer prestoreDays;

	@ApiModelProperty(value = "供楼清单URLS")
	private String floorListUrls;

	@ApiModelProperty(value = "申请回执URLS")
	private String applicationReceiptUrls;

	@ApiModelProperty(value = "贷款合同URLS")
	private String loanAgreementUrls;

	@ApiModelProperty(value = "还款申请处理意见")
	private String remarks;

	public String getGuaranteeId() {
		return guaranteeId;
	}

	public void setGuaranteeId(String guaranteeId) {
		this.guaranteeId = guaranteeId;
	}

	public String getRepayType() {
		return repayType;
	}

	public void setRepayType(String repayType) {
		this.repayType = repayType;
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

	public Integer getPrestoreDays() {
		return prestoreDays;
	}

	public void setPrestoreDays(Integer prestoreDays) {
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
