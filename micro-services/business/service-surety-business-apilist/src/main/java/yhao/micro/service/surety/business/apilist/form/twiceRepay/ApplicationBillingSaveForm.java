package yhao.micro.service.surety.business.apilist.form.twiceRepay;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.micro.service.surety.business.apilist.model.enums.twiceRepay.ReceipterTypeEnum;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description:
 * @Created by ql on 2019/2/21 11:23
 * @Version: v1.0
 */
public class ApplicationBillingSaveForm extends IdUnForm {
	@ApiModelProperty(value = "出账申请表主键ID", hidden = true)
	private String applicationBillingId;

	@ApiModelProperty(value = "担保单id")
	@NotBlank(message = "担保单id不能为空")
	private String guaranteeId;

	@ApiModelProperty(value = "二次还款状态(1=客户经理发起,2=要件员确认,3=二次到账确认,4=申请出账,5=二次到账确认,6=二次赎楼)", hidden = true)
	private int twiceRepayState;

	@ApiModelProperty(value = "收款人类型", required = true)
	@NotNull(message = "收款人类型不能为空")
	private ReceipterTypeEnum receipterType;

	@ApiModelProperty(value = "收款账户名", required = true)
	@NotBlank(message = "收款账户名不能为空")
	private String receipterAccount;

	@ApiModelProperty(value = "卡号", required = true)
	@NotBlank(message = "卡号不能为空")
	private String cardNumber;

	@ApiModelProperty(value = "开户行", required = true)
	@NotBlank(message = "到账日期不能为空")
	private String bank;

	@ApiModelProperty(value = "还款日期", required = true)
	@NotNull(message = "还款日期不能为空")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date repayDate;

	@ApiModelProperty(value = "申请金额", required = true)
	@NotNull(message = "申请金额不能为空")
	private BigDecimal applicationAmount;

	@ApiModelProperty(value = "还款申请备注", required = true)
	@NotBlank(message = "还款申请备注不能为空")
	private String applicationRemark;

	public String getApplicationBillingId() {
		return applicationBillingId;
	}

	public void setApplicationBillingId(String applicationBillingId) {
		this.applicationBillingId = applicationBillingId;
	}

	public int getTwiceRepayState() {
		return twiceRepayState;
	}

	public void setTwiceRepayState(int twiceRepayState) {
		this.twiceRepayState = twiceRepayState;
	}

	public String getGuaranteeId() {
		return guaranteeId;
	}

	public void setGuaranteeId(String guaranteeId) {
		this.guaranteeId = guaranteeId;
	}

	public ReceipterTypeEnum getReceipterType() {
		return receipterType;
	}

	public void setReceipterType(ReceipterTypeEnum receipterType) {
		this.receipterType = receipterType;
	}

	public String getReceipterAccount() {
		return receipterAccount;
	}

	public void setReceipterAccount(String receipterAccount) {
		this.receipterAccount = receipterAccount;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public Date getRepayDate() {
		return repayDate;
	}

	public void setRepayDate(Date repayDate) {
		this.repayDate = repayDate;
	}

	public BigDecimal getApplicationAmount() {
		return applicationAmount;
	}

	public void setApplicationAmount(BigDecimal applicationAmount) {
		this.applicationAmount = applicationAmount;
	}

	public String getApplicationRemark() {
		return applicationRemark;
	}

	public void setApplicationRemark(String applicationRemark) {
		this.applicationRemark = applicationRemark;
	}
}
