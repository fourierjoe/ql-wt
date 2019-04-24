package yhao.micro.service.surety.business.apilist.model.intention.repay;

import io.swagger.annotations.ApiModelProperty;
import yhao.micro.service.surety.business.apilist.model.intention.IntentionBasePageModel;
import yhao.micro.service.surety.business.apilist.model.intention.follower.FollowerCreditModel;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Created by ql on 2019/1/9 20:15
 * @Version: v1.0
 */
public class RepayPageModel extends IntentionBasePageModel {
	@ApiModelProperty("单据类型")
	private String guaranteeType;

	@ApiModelProperty("单据编号")
	private String guaranteeNum;

	@ApiModelProperty(value = "担保单id")
	private String guaranteeId;

	@ApiModelProperty("买卖双方名字")
	private List<FollowerCreditModel> followerCreditModelList;

	@ApiModelProperty("客户经理姓名")
	private String managerName;

	@ApiModelProperty(value = "业务类型")
	private String businessName;

	@ApiModelProperty("资料转交时间")
	private Date dataTransferDate;

	@ApiModelProperty("计划日期")
	private Date repayExpectedDate;

	@ApiModelProperty("实际办理日期")
	private Date repayRealDate;

	public String getGuaranteeId() {
		return guaranteeId;
	}

	public void setGuaranteeId(String guaranteeId) {
		this.guaranteeId = guaranteeId;
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

	public Date getDataTransferDate() {
		return dataTransferDate;
	}

	public void setDataTransferDate(Date dataTransferDate) {
		this.dataTransferDate = dataTransferDate;
	}

	public Date getRepayExpectedDate() {
		return repayExpectedDate;
	}

	public void setRepayExpectedDate(Date repayExpectedDate) {
		this.repayExpectedDate = repayExpectedDate;
	}

	public Date getRepayRealDate() {
		return repayRealDate;
	}

	public void setRepayRealDate(Date repayRealDate) {
		this.repayRealDate = repayRealDate;
	}
}
