package yhao.micro.service.surety.business.apilist.form.guarantee.validateForm.cash;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.ValidationForm;
import yhao.micro.service.surety.business.apilist.model.enums.guarantee.ReceivePaymentSourceEnum;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @Description:
 * @Created by ql on 2019/1/21 15:16
 * @Version: v1.0
 */
public class ValidateTransactionTypeReceivePaymentPlanSaveForm implements ValidationForm {

	@ApiModelProperty(value = "回款来源",example = "SUPERVISION")
	@NotNull(message = "回款来源不得为空")
	private ReceivePaymentSourceEnum receivePaymentSource;

	@ApiModelProperty(value = "回款预计金额",example = "50.0")
	@NotNull(message = "回款预计金额不得为空")
	private BigDecimal receivePaymentExpectAmount;

	@ApiModelProperty(value = "回款客户账户名",example = "回款客户账户名")
	@NotBlank(message = "回款客户账户名不得为空")
	private String receivePaymentAccount;

	@ApiModelProperty(value = "回款客户账号",example = "回款客户账号")
	@NotBlank(message = "回款客户账号不得为空")
	private String receivePaymentAccountNum;

	@ApiModelProperty(value = "回款客户开户行",example = "回款客户开户行")
	@NotBlank(message = "回款客户开户行不得为空")
	private String receivePaymentBank;

	public ReceivePaymentSourceEnum getReceivePaymentSource() {
		return receivePaymentSource;
	}

	public void setReceivePaymentSource(ReceivePaymentSourceEnum receivePaymentSource) {
		this.receivePaymentSource = receivePaymentSource;
	}

	public BigDecimal getReceivePaymentExpectAmount() {
		return receivePaymentExpectAmount;
	}

	public void setReceivePaymentExpectAmount(BigDecimal receivePaymentExpectAmount) {
		this.receivePaymentExpectAmount = receivePaymentExpectAmount;
	}

	public String getReceivePaymentAccount() {
		return receivePaymentAccount;
	}

	public void setReceivePaymentAccount(String receivePaymentAccount) {
		this.receivePaymentAccount = receivePaymentAccount;
	}

	public String getReceivePaymentAccountNum() {
		return receivePaymentAccountNum;
	}

	public void setReceivePaymentAccountNum(String receivePaymentAccountNum) {
		this.receivePaymentAccountNum = receivePaymentAccountNum;
	}

	public String getReceivePaymentBank() {
		return receivePaymentBank;
	}

	public void setReceivePaymentBank(String receivePaymentBank) {
		this.receivePaymentBank = receivePaymentBank;
	}
}
