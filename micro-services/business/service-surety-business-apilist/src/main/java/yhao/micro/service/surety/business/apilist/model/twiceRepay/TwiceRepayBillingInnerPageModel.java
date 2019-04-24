package yhao.micro.service.surety.business.apilist.model.twiceRepay;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description:
 * @Created by ql on 2019/3/2 14:26
 * @Version: v1.0
 */
public class TwiceRepayBillingInnerPageModel {
	@ApiModelProperty(value = "申请金额")
	private BigDecimal applyingAmount;

	@ApiModelProperty(value = "申请人")
	private String applyer;

	@ApiModelProperty(value = "还款时间")
	private Date repayDate;

	@ApiModelProperty(value = "已出账金额")
	private BigDecimal billedAmount = new BigDecimal(0);

	@ApiModelProperty(value = "出账申请表id")
	private String applicationId;

	public BigDecimal getApplyingAmount() {
		return applyingAmount;
	}

	public void setApplyingAmount(BigDecimal applyingAmount) {
		this.applyingAmount = applyingAmount;
	}

	public String getApplyer() {
		return applyer;
	}

	public void setApplyer(String applyer) {
		this.applyer = applyer;
	}

	public Date getRepayDate() {
		return repayDate;
	}

	public void setRepayDate(Date repayDate) {
		this.repayDate = repayDate;
	}

	public BigDecimal getBilledAmount() {
		return billedAmount;
	}

	public void setBilledAmount(BigDecimal billedAmount) {
		this.billedAmount = billedAmount;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
}
