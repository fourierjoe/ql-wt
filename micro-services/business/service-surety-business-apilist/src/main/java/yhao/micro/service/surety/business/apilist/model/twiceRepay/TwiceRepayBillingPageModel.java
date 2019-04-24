package yhao.micro.service.surety.business.apilist.model.twiceRepay;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description:
 * @Created by ql on 2019/2/28 16:05
 * @Version: v1.0
 */
public class TwiceRepayBillingPageModel extends TwiceRepayBasePageModel {

	@ApiModelProperty(value = "业务状态=当前节点名称")
	private String currentNodeName;

	@ApiModelProperty(value = "总到账金额")
	private BigDecimal totalArrivalAmount;

	@ApiModelProperty(value = "剩余可出金额")
	private BigDecimal balanceBillingAmount;

	@ApiModelProperty(value = "剩余可出金额")
	private List<TwiceRepayBillingInnerPageModel> twiceRepayBillingInnerPageModelList;

	@ApiModelProperty("二次出账状态")
	private String twiceRepayStateDesc;

	public String getTwiceRepayStateDesc() {
		if (getTwiceRepayState() == 4 && getTwiceRepayState() != 5) {
			twiceRepayStateDesc = "未确认到账";
		} else if (getTwiceRepayState() >= 5) {
			twiceRepayStateDesc = "已确认到账";
		} else {}
		return twiceRepayStateDesc;
	}

	public void setTwiceRepayStateDesc(String twiceRepayStateDesc) {
		this.twiceRepayStateDesc = twiceRepayStateDesc;
	}

	public String getCurrentNodeName() {
		return currentNodeName;
	}

	public void setCurrentNodeName(String currentNodeName) {
		this.currentNodeName = currentNodeName;
	}

	public BigDecimal getTotalArrivalAmount() {
		return totalArrivalAmount;
	}

	public void setTotalArrivalAmount(BigDecimal totalArrivalAmount) {
		this.totalArrivalAmount = totalArrivalAmount;
	}

	public BigDecimal getBalanceBillingAmount() {
		// 总到账- 各个出账之和
		BigDecimal balanceBillingAmount = new BigDecimal(0);
		BigDecimal totalBbilledAmount = this.twiceRepayBillingInnerPageModelList.stream().map(TwiceRepayBillingInnerPageModel::getBilledAmount)
				.reduce(BigDecimal::add).get();
		balanceBillingAmount = balanceBillingAmount.add(totalArrivalAmount).subtract(totalBbilledAmount);
		return balanceBillingAmount;
	}

	public void setBalanceBillingAmount(BigDecimal balanceBillingAmount) {
		this.balanceBillingAmount = balanceBillingAmount;
	}

	public List<TwiceRepayBillingInnerPageModel> getTwiceRepayBillingInnerPageModelList() {
		return twiceRepayBillingInnerPageModelList;
	}

	public void setTwiceRepayBillingInnerPageModelList(List<TwiceRepayBillingInnerPageModel> twiceRepayBillingInnerPageModelList) {
		this.twiceRepayBillingInnerPageModelList = twiceRepayBillingInnerPageModelList;
	}
}
