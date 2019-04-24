package yhao.micro.service.surety.business.apilist.model.twiceRepay;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.infra.common.model.Pagination;

import java.math.BigDecimal;

/**
 * @Description:
 * @Created by ql on 2019/2/25 10:51
 * @Version: v1.0
 */
public class TwiceApplicationRecordModel extends Entity<String> {

	@ApiModelProperty(value = "每次到账金额", hidden = true)
	private BigDecimal arrivalAmount;

	@ApiModelProperty(value = "到账金额")
	private BigDecimal totalArrivalAmount;

	@ApiModelProperty(value = "每次申请金额", hidden = true)
	private BigDecimal applicationAmount;

	@ApiModelProperty(value = "累计申请")
	private BigDecimal totalApplicationAmount;

	@ApiModelProperty(value = "每次出账金额", hidden = true)
	private BigDecimal twiceBillingAmount;

	@ApiModelProperty(value = "剩余可申请")
	private BigDecimal surplusApplicationAmount;

	@ApiModelProperty(value = "申请记录分页")
	private Pagination<TwiceApplicationModel> model;

	public BigDecimal getTwiceBillingAmount() {
		return twiceBillingAmount;
	}

	public void setTwiceBillingAmount(BigDecimal twiceBillingAmount) {
		this.twiceBillingAmount = twiceBillingAmount;
	}

	public BigDecimal getTotalArrivalAmount() {
		return totalArrivalAmount;
	}

	public void setTotalArrivalAmount(BigDecimal totalArrivalAmount) {
		this.totalArrivalAmount = totalArrivalAmount;
	}

	public BigDecimal getApplicationAmount() {
		return applicationAmount;
	}

	public void setApplicationAmount(BigDecimal applicationAmount) {
		this.applicationAmount = applicationAmount;
	}

	public BigDecimal getArrivalAmount() {
		return arrivalAmount;
	}

	public void setArrivalAmount(BigDecimal arrivalAmount) {
		this.arrivalAmount = arrivalAmount;
	}

	public BigDecimal getTotalApplicationAmount() {
		return totalApplicationAmount;
	}

	public void setTotalApplicationAmount(BigDecimal totalApplicationAmount) {
		this.totalApplicationAmount = totalApplicationAmount;
	}

	public BigDecimal getSurplusApplicationAmount() {
		return surplusApplicationAmount;
	}

	public void setSurplusApplicationAmount(BigDecimal surplusApplicationAmount) {
		this.surplusApplicationAmount = surplusApplicationAmount;
	}

	public Pagination<TwiceApplicationModel> getModel() {
		return model;
	}

	public void setModel(Pagination<TwiceApplicationModel> model) {
		this.model = model;
	}

	public static TwiceApplicationRecordModel newTwiceApplicationRecordModel() {
		return new TwiceApplicationRecordModel();
	}
}
