package yhao.micro.service.surety.business.apilist.form.twiceRepay;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.IdForm;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description:
 * @Created by ql on 2019/2/21 10:04
 * @Version: v1.0
 */
public class TwiceRepayStateForm extends IdForm {
	@ApiModelProperty(value = "二次还款状态(1=客户经理发起,2=要件员确认,3=二次到账确认,4=申请出账,5=二次到账确认,6=二次赎楼)")
	private int twiceRepayState;

	@ApiModelProperty(value = "第二次到账合计")
	private BigDecimal twiceArrivalTotal;

	@ApiModelProperty(value = "第二次出账合计")
	private BigDecimal twiceBillingTotal;

	@ApiModelProperty(value = "财务确认出账日期")
	private Date twiceBillingDate;

	public Date getTwiceBillingDate() {
		return twiceBillingDate;
	}

	public void setTwiceBillingDate(Date twiceBillingDate) {
		this.twiceBillingDate = twiceBillingDate;
	}

	public int getTwiceRepayState() {
		return twiceRepayState;
	}

	public void setTwiceRepayState(int twiceRepayState) {
		this.twiceRepayState = twiceRepayState;
	}

	public BigDecimal getTwiceArrivalTotal() {
		return twiceArrivalTotal;
	}

	public void setTwiceArrivalTotal(BigDecimal twiceArrivalTotal) {
		this.twiceArrivalTotal = twiceArrivalTotal;
	}

	public BigDecimal getTwiceBillingTotal() {
		return twiceBillingTotal;
	}

	public void setTwiceBillingTotal(BigDecimal twiceBillingTotal) {
		this.twiceBillingTotal = twiceBillingTotal;
	}

	public static TwiceRepayStateForm newTwiceRepayStateForm() {
		return new TwiceRepayStateForm();
	}
}
