package yhao.micro.service.surety.business.apilist.model.twiceRepay;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @Description:
 * @Created by ql on 2019/2/28 16:42
 * @Version: v1.0
 */
public class TwiceRepayArrivalPageModel extends TwiceRepayBasePageModel {

	@ApiModelProperty("到账金额")
	private BigDecimal arrivalAmount;

	@ApiModelProperty("到账状态")
	private String arrivalState;

	@ApiModelProperty("赎楼金额")
	private BigDecimal redeemHouseAmount;

	@ApiModelProperty("客户经理所在组织")
	private String managerOrg;

	@ApiModelProperty("客户经理姓名")
	private String managerName;

	@ApiModelProperty(value = "业务状态=当前节点名称")
	private String currentNodeName;

	public BigDecimal getArrivalAmount() {
		return arrivalAmount;
	}

	public void setArrivalAmount(BigDecimal arrivalAmount) {
		this.arrivalAmount = arrivalAmount;
	}

	public String getArrivalState() {
		if (getTwiceRepayState() == 2 && getTwiceRepayState() != 3) {
			arrivalState = "未确认到账";
		} else if (getTwiceRepayState() >= 3) {
			arrivalState = "已确认到账";
		} else {}
		return arrivalState;
	}

	public void setArrivalState(String arrivalState) {
		this.arrivalState = arrivalState;
	}

	public BigDecimal getRedeemHouseAmount() {
		return redeemHouseAmount;
	}

	public void setRedeemHouseAmount(BigDecimal redeemHouseAmount) {
		this.redeemHouseAmount = redeemHouseAmount;
	}

	public String getManagerOrg() {
		return managerOrg;
	}

	public void setManagerOrg(String managerOrg) {
		this.managerOrg = managerOrg;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getCurrentNodeName() {
		return currentNodeName;
	}

	public void setCurrentNodeName(String currentNodeName) {
		this.currentNodeName = currentNodeName;
	}
}
