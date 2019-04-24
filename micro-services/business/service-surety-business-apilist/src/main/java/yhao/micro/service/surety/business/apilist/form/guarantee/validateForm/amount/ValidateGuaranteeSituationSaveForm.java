package yhao.micro.service.surety.business.apilist.form.guarantee.validateForm.amount;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.ValidationForm;
import yhao.micro.service.constants.enums.YNEnum;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @Description:
 * @Created by ql on 2019/1/21 17:11
 * @Version: v1.0
 */
public class ValidateGuaranteeSituationSaveForm implements ValidationForm {

	@ApiModelProperty(value = "申请人IDS,业主/买家多选", example = "申请人IDS")
	@NotBlank(message = "申请人IDS必传")
	private String guaranteeApplicantIds;

	@ApiModelProperty(value = "出赎楼歀银行ID，这里关联的是资方管理里面的具体支行ID", example = "出赎楼歀银行ID")
	@NotBlank(message = "出赎楼歀银行ID必传")
	private String redeemBankId;

	@ApiModelProperty(value = "赎楼比例",example = "5.2")
	@NotNull(message = "出赎楼歀银行ID必传")
	private BigDecimal redeemBankRate;

	@ApiModelProperty(value = "银行联系人", example = "银行联系人")
	@NotBlank(message = "银行联系人必传")
	private String redeemBankContact;

	@ApiModelProperty(value = "银行联系电话", example = "银行联系电话")
	@NotBlank(message = "银行联系电话必传")
	private String redeemBankContactTele;

	@ApiModelProperty(value = "担保金额",example = "100")
	@NotNull(message = "担保金额必传")
	private BigDecimal guaranteeAmount;

	@ApiModelProperty(value = "赎楼金额",example = "100")
	@NotNull(message = "赎楼金额必传")
	private BigDecimal redeemHouseAmount;

	@ApiModelProperty(value = "担保天数",example = "10")
	@NotNull(message = "担保天数必传")
	private Integer guaranteeDays;

	@ApiModelProperty(value = "是否有反担保人",example = "YES")
	@NotNull(message = "是否有反担保人必传")
	private YNEnum isAntiGuarantor;

	public String getGuaranteeApplicantIds() {
		return guaranteeApplicantIds;
	}

	public void setGuaranteeApplicantIds(String guaranteeApplicantIds) {
		this.guaranteeApplicantIds = guaranteeApplicantIds;
	}

	public String getRedeemBankId() {
		return redeemBankId;
	}

	public void setRedeemBankId(String redeemBankId) {
		this.redeemBankId = redeemBankId;
	}

	public BigDecimal getRedeemBankRate() {
		return redeemBankRate;
	}

	public void setRedeemBankRate(BigDecimal redeemBankRate) {
		this.redeemBankRate = redeemBankRate;
	}

	public String getRedeemBankContact() {
		return redeemBankContact;
	}

	public void setRedeemBankContact(String redeemBankContact) {
		this.redeemBankContact = redeemBankContact;
	}

	public String getRedeemBankContactTele() {
		return redeemBankContactTele;
	}

	public void setRedeemBankContactTele(String redeemBankContactTele) {
		this.redeemBankContactTele = redeemBankContactTele;
	}

	public BigDecimal getGuaranteeAmount() {
		return guaranteeAmount;
	}

	public void setGuaranteeAmount(BigDecimal guaranteeAmount) {
		this.guaranteeAmount = guaranteeAmount;
	}

	public BigDecimal getRedeemHouseAmount() {
		return redeemHouseAmount;
	}

	public void setRedeemHouseAmount(BigDecimal redeemHouseAmount) {
		this.redeemHouseAmount = redeemHouseAmount;
	}

	public Integer getGuaranteeDays() {
		return guaranteeDays;
	}

	public void setGuaranteeDays(Integer guaranteeDays) {
		this.guaranteeDays = guaranteeDays;
	}

	public YNEnum getIsAntiGuarantor() {
		return isAntiGuarantor;
	}

	public void setIsAntiGuarantor(YNEnum isAntiGuarantor) {
		this.isAntiGuarantor = isAntiGuarantor;
	}
}
