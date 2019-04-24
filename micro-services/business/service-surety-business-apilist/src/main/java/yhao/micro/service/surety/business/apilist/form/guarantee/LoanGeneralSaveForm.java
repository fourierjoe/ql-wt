package yhao.micro.service.surety.business.apilist.form.guarantee;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.micro.service.constants.enums.YNEnum;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * @Description:
 * @Created by ql on 2019/1/2 18:20
 * @Version: v1.0
 */
public class LoanGeneralSaveForm extends IdUnForm {
	@ApiModelProperty(value = "担保单ID", hidden = true)
	private String guaranteeId;

	@ApiModelProperty(value = "总额(对应明细表loanAmount)",example = "133.3")
	private BigDecimal loanTotalAmount;

	@ApiModelProperty(value = "总天数(对应明细表loanDays)",example = "100")
	private Integer totalDays;

	@ApiModelProperty(value = "总对外费率(对应明细表marketFeeRate)",example = "5.0")
	private BigDecimal totalMarketFeeRate ;

	@ApiModelProperty(value = "总手续费(对应明细表chargeGuaranteeFee)",example = "200")
	private BigDecimal charges;

	@ApiModelProperty(value = "打折申请说明",example = "打折申请说明")
	private String discountExplain;

	@ApiModelProperty(value = "预计用款日期",example = "2019-02-02")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date planUseDate;

	@ApiModelProperty(value = "是否开票",example = "YES")
	private YNEnum isBilling;

	@ApiModelProperty(value = "开票人ID",example = "1234")
	private String billingId;

	@ApiModelProperty(value = "应收合计",example = "789.3")
	private BigDecimal chargeTotal;

	@ApiModelProperty(value = "实收合计",example = "789.3")
	private BigDecimal chargeRealTotal;

	@ApiModelProperty(value = "应收咨询费",example = "10.0")
	private BigDecimal adviceFee;

	@ApiModelProperty(value = "应收小计",example = "8888")
	private BigDecimal chargeLittle;

	public BigDecimal getChargeLittle() {
		return chargeLittle;
	}

	public void setChargeLittle(BigDecimal chargeLittle) {
		this.chargeLittle = chargeLittle;
	}

	public void setIsBilling(YNEnum isBilling) {
		this.isBilling = isBilling;
	}

	public BigDecimal getChargeTotal() {
		return chargeTotal;
	}

	public void setChargeTotal(BigDecimal chargeTotal) {
		this.chargeTotal = chargeTotal;
	}

	public BigDecimal getChargeRealTotal() {
		return chargeRealTotal;
	}

	public void setChargeRealTotal(BigDecimal chargeRealTotal) {
		this.chargeRealTotal = chargeRealTotal;
	}

	public BigDecimal getAdviceFee() {
		return adviceFee;
	}

	public void setAdviceFee(BigDecimal adviceFee) {
		this.adviceFee = adviceFee;
	}

	public String getGuaranteeId() {
		return guaranteeId;
	}

	public void setGuaranteeId(String guaranteeId) {
		this.guaranteeId = guaranteeId;
	}

	public BigDecimal getLoanTotalAmount() {
		return loanTotalAmount;
	}

	public void setLoanTotalAmount(BigDecimal loanTotalAmount) {
		this.loanTotalAmount = loanTotalAmount;
	}

	public Integer getTotalDays() {
		return totalDays;
	}

	public void setTotalDays(Integer totalDays) {
		this.totalDays = totalDays;
	}

	public BigDecimal getTotalMarketFeeRate() {
		return totalMarketFeeRate;
	}

	public void setTotalMarketFeeRate(BigDecimal totalMarketFeeRate) {
		this.totalMarketFeeRate = totalMarketFeeRate;
	}

	public BigDecimal getCharges() {
		return charges;
	}

	public void setCharges(BigDecimal charges) {
		this.charges = charges;
	}

	public String getDiscountExplain() {
		return discountExplain;
	}

	public void setDiscountExplain(String discountExplain) {
		this.discountExplain = discountExplain;
	}

	public Date getPlanUseDate() {
		return planUseDate;
	}

	public void setPlanUseDate(Date planUseDate) {
		this.planUseDate = planUseDate;
	}

	public YNEnum getIsBilling() {
		return isBilling;
	}

	public String getBillingId() {
		return billingId;
	}

	public void setBillingId(String billingId) {
		this.billingId = billingId;
	}
}
