package yhao.micro.service.surety.business.apilist.model.twiceRepay;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Description:
 * @Created by ql on 2019/2/28 16:55
 * @Version: v1.0
 */
public class TwiceRepayRedeemPageModel extends TwiceRepayBasePageModel {

	@ApiModelProperty("还款状态")
	private String repayState;

	@ApiModelProperty("还款状态")
	private List<TwiceRepayRedeemInnerPageModel> twiceRepayRedeemInnerPageModelList;

	public String getRepayState() {
		if (getTwiceRepayState() == 5 && getTwiceRepayState() != 6) {
			repayState = "未确认还款";
		} else if (getTwiceRepayState() >= 6) {
			repayState = "已确认还款";
		} else {}
		return repayState;
	}

	public void setRepayState(String repayState) {
		this.repayState = repayState;
	}

	public List<TwiceRepayRedeemInnerPageModel> getTwiceRepayRedeemInnerPageModelList() {
		return twiceRepayRedeemInnerPageModelList;
	}

	public void setTwiceRepayRedeemInnerPageModelList(List<TwiceRepayRedeemInnerPageModel> twiceRepayRedeemInnerPageModelList) {
		this.twiceRepayRedeemInnerPageModelList = twiceRepayRedeemInnerPageModelList;
	}
}
