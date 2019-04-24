package yhao.micro.service.surety.business.apilist.model.twiceRepay;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @Description:
 * @Created by ql on 2019/2/28 16:40
 * @Version: v1.0
 */
public class TwiceRepayConfirmPageModel extends TwiceRepayBasePageModel {
	@ApiModelProperty("赎楼金额")
	private BigDecimal redeemHouseAmount;

	@ApiModelProperty("出赎楼款银行")
	private String redeemBankName;

	@ApiModelProperty("客户经理所在组织")
	private String managerOrg;

	@ApiModelProperty("客户经理姓名")
	private String managerName;

	@ApiModelProperty(value = "业务状态=当前节点名称")
	private String currentNodeName;

	@ApiModelProperty("要件员确认状态")
	private String twiceRepayStateDesc;

	public BigDecimal getRedeemHouseAmount() {
		return redeemHouseAmount;
	}

	public void setRedeemHouseAmount(BigDecimal redeemHouseAmount) {
		this.redeemHouseAmount = redeemHouseAmount;
	}

	public String getRedeemBankName() {
		return redeemBankName;
	}

	public void setRedeemBankName(String redeemBankName) {
		this.redeemBankName = redeemBankName;
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

	public String getTwiceRepayStateDesc() {
		if (getTwiceRepayState() == 1 && getTwiceRepayState() != 2) {
			twiceRepayStateDesc = "未确认";
		} else if (getTwiceRepayState() >= 1) {
			twiceRepayStateDesc = "已确认";
		} else {}
		return twiceRepayStateDesc;
	}

	public void setTwiceRepayStateDesc(String twiceRepayStateDesc) {
		this.twiceRepayStateDesc = twiceRepayStateDesc;
	}
}
