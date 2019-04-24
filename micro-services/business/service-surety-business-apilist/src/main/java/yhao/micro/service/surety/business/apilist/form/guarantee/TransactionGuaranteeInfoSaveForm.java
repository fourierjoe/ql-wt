package yhao.micro.service.surety.business.apilist.form.guarantee;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.micro.service.surety.business.apilist.model.enums.guarantee.GuaranteePayTypeEnum;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * @Description: 交易类单据成交信息表
 * @Created by ql on 2019/1/2 18:04
 * @Version: v1.0
 */
public class TransactionGuaranteeInfoSaveForm extends IdUnForm {
	@ApiModelProperty(value = "担保单ID", hidden = true)
	private String guaranteeId;

	@ApiModelProperty(value = "成交总价", example = "3214")
	@NotNull(message = "成交总价不得为空")
	private BigDecimal transactionPrice;

	@ApiModelProperty(value = "付款方式：按揭贷款，组合贷款，公积金贷款，一次性付款", example = "MORTGAGE_LOAN")
	@NotNull(message = "付款方式不得为空")
	private GuaranteePayTypeEnum payType;

	@ApiModelProperty(value = "定金", example = "1000")
	@NotNull(message = "定金不得为空")
	private BigDecimal deposit;

	@ApiModelProperty(value = "公正日期",example = "2018-12-25")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message = "公正日期不得为空")
	private Date notarizationData;

	public String getGuaranteeId() {
		return guaranteeId;
	}

	public void setGuaranteeId(String guaranteeId) {
		this.guaranteeId = guaranteeId;
	}


	public BigDecimal getTransactionPrice() {
		return transactionPrice;
	}

	public void setTransactionPrice(BigDecimal transactionPrice) {
		this.transactionPrice = transactionPrice;
	}

	public GuaranteePayTypeEnum getPayType() {
		return payType;
	}

	public void setPayType(GuaranteePayTypeEnum payType) {
		this.payType = payType;
	}

	public BigDecimal getDeposit() {
		return deposit;
	}

	public void setDeposit(BigDecimal deposit) {
		this.deposit = deposit;
	}

	public Date getNotarizationData() {
		return notarizationData;
	}

	public void setNotarizationData(Date notarizationData) {
		this.notarizationData = notarizationData;
	}
}
