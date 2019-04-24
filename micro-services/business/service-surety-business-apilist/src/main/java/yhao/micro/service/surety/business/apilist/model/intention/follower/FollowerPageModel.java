package yhao.micro.service.surety.business.apilist.model.intention.follower;

import io.swagger.annotations.ApiModelProperty;
import yhao.micro.service.surety.business.apilist.model.intention.IntentionBasePageModel;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Created by ql on 2019/1/8 19:36
 * @Version: v1.0
 */
public class FollowerPageModel extends IntentionBasePageModel {
	@ApiModelProperty("买卖双方名字")
	private List<FollowerCreditModel> followerCreditModelList;

	@ApiModelProperty("单据类型")
	private String guaranteeType;

	@ApiModelProperty("单据编号")
	private String guaranteeNum;

	@ApiModelProperty("客户经理姓名")
	private String managerName;

	@ApiModelProperty(value = "业务类型")
	private String businessName;

	@ApiModelProperty("跟单员接收状态")
	private String receiveState;

	@ApiModelProperty("跟单员转单状态")
	private String transferState;

	@ApiModelProperty("创建日期")
	private Date createTime;

	@Override
	public Date getCreateTime() {
		return createTime;
	}

	@Override
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getGuaranteeType() {
		return guaranteeType;
	}

	public void setGuaranteeType(String guaranteeType) {
		this.guaranteeType = guaranteeType;
	}

	public String getGuaranteeNum() {
		return guaranteeNum;
	}

	public void setGuaranteeNum(String guaranteeNum) {
		this.guaranteeNum = guaranteeNum;
	}

	public List<FollowerCreditModel> getFollowerCreditModelList() {
		return followerCreditModelList;
	}

	public void setFollowerCreditModelList(List<FollowerCreditModel> followerCreditModelList) {
		this.followerCreditModelList = followerCreditModelList;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getReceiveState() {
		return receiveState;
	}

	public void setReceiveState(String receiveState) {
		this.receiveState = receiveState;
	}

	public String getTransferState() {
		return transferState;
	}

	public void setTransferState(String transferState) {
		this.transferState = transferState;
	}
}
