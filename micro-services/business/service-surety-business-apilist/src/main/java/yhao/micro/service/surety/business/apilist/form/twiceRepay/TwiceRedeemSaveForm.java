package yhao.micro.service.surety.business.apilist.form.twiceRepay;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.micro.service.constants.enums.YNEnum;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description:
 * @Created by ql on 2019/2/20 15:53
 * @Version: v1.0
 */
public class TwiceRedeemSaveForm extends IdUnForm {
	@ApiModelProperty(value = "担保单Id")
	@NotBlank(message = "担保单Id不能为空")
	private String guaranteeId;

	// 还款分页会查出来
	@ApiModelProperty(value = "出账id")
	@NotBlank(message = "出账id不能为空")
	private String financeBillingId;

	@ApiModelProperty(value = "第二次赎楼日期")
	@NotNull(message = "第二次赎楼日期不能为空")
	private Date twiceRedeemDate;

	@ApiModelProperty(value = "第二次客户补差额")
	@NotNull(message = "第二次客户补差额不能为空")
	private BigDecimal twiceCustomerReplenishment;

	@ApiModelProperty(value = "第二次实际还贷本金")
	@NotNull(message = "第二次实际还贷本金不能为空")
	private BigDecimal twiceRealRepaymentFund;

	@ApiModelProperty(value = "第二次利息")
	@NotNull(message = "第二次利息不能为空")
	private BigDecimal twiceInterest;

	@ApiModelProperty(value = "第二次罚息")
	@NotNull(message = "第二次罚息不能为空")
	private BigDecimal twicePenaltyInterest;

	@ApiModelProperty(value = "赎楼凭证")
	@NotBlank(message = "赎楼凭证不能为空")
	private String certificate;

	@ApiModelProperty(value = "第二次赎楼公司账户")
	@NotBlank(message = "第二次赎楼公司账户不能为空")
	private String twiceCompanyAccount;

	@ApiModelProperty(value = "第二次退还日期")
	@NotNull(message = "第二次退还日期不能为空")
	private Date twiceRebackDate;

	@ApiModelProperty(value = "第二次赎楼备注")
	private String twiceRemark;

	@ApiModelProperty(value = "每笔还款状态", hidden = true)
	private YNEnum perRedeemState = YNEnum.YES;

	public YNEnum getPerRedeemState() {
		return perRedeemState;
	}

	public void setPerRedeemState(YNEnum perRedeemState) {
		this.perRedeemState = perRedeemState;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public String getGuaranteeId() {
		return guaranteeId;
	}

	public void setGuaranteeId(String guaranteeId) {
		this.guaranteeId = guaranteeId;
	}

	public Date getTwiceRedeemDate() {
		return twiceRedeemDate;
	}

	public void setTwiceRedeemDate(Date twiceRedeemDate) {
		this.twiceRedeemDate = twiceRedeemDate;
	}

	public BigDecimal getTwiceCustomerReplenishment() {
		return twiceCustomerReplenishment;
	}

	public void setTwiceCustomerReplenishment(BigDecimal twiceCustomerReplenishment) {
		this.twiceCustomerReplenishment = twiceCustomerReplenishment;
	}

	public BigDecimal getTwiceRealRepaymentFund() {
		return twiceRealRepaymentFund;
	}

	public void setTwiceRealRepaymentFund(BigDecimal twiceRealRepaymentFund) {
		this.twiceRealRepaymentFund = twiceRealRepaymentFund;
	}

	public BigDecimal getTwiceInterest() {
		return twiceInterest;
	}

	public void setTwiceInterest(BigDecimal twiceInterest) {
		this.twiceInterest = twiceInterest;
	}

	public BigDecimal getTwicePenaltyInterest() {
		return twicePenaltyInterest;
	}

	public void setTwicePenaltyInterest(BigDecimal twicePenaltyInterest) {
		this.twicePenaltyInterest = twicePenaltyInterest;
	}

	public String getTwiceCompanyAccount() {
		return twiceCompanyAccount;
	}

	public void setTwiceCompanyAccount(String twiceCompanyAccount) {
		this.twiceCompanyAccount = twiceCompanyAccount;
	}

	public Date getTwiceRebackDate() {
		return twiceRebackDate;
	}

	public void setTwiceRebackDate(Date twiceRebackDate) {
		this.twiceRebackDate = twiceRebackDate;
	}

	public String getTwiceRemark() {
		return twiceRemark;
	}

	public void setTwiceRemark(String twiceRemark) {
		this.twiceRemark = twiceRemark;
	}

	public String getFinanceBillingId() {
		return financeBillingId;
	}

	public void setFinanceBillingId(String financeBillingId) {
		this.financeBillingId = financeBillingId;
	}
}
