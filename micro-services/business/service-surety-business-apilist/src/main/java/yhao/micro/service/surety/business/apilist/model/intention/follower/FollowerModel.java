package yhao.micro.service.surety.business.apilist.model.intention.follower;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.surety.business.apilist.form.intention.FollowerAttachmentForm;
import yhao.micro.service.surety.business.apilist.form.intention.FollowerRedeemForm;
import yhao.micro.service.surety.business.apilist.model.intention.repay.FollowerRedeemModel;

import java.util.List;

/**
 * @Description: 跟单员查看model
 * @Created by ql on 2019/1/8 17:30
 * @Version: v1.0
 */
public class FollowerModel extends Entity<String> {

	@ApiModelProperty(value = "城市组织id")
	private String orgId;

	@ApiModelProperty(value = "担保单编号")
	private String guaranteeNum;

	@ApiModelProperty(value = "单据类型")
	private String guaranteeType;

	@ApiModelProperty(value = "业务类型")
	private String businessName;

	@ApiModelProperty("客户经理姓名")
	private String managerName;

	@ApiModelProperty(value = "客户经理电话")
	private String phone;

	@ApiModelProperty(value = "资料转交时间")
	private String dataTransferDate;

	@ApiModelProperty("买卖双方征信信息")
	private List<FollowerCreditModel> followerCreditModelList;

	@ApiModelProperty("还款申请信息")
	private FollowerRedeemModel followerRedeemModel;

	@ApiModelProperty("意向单附件信息")
	private List<FollowerAttachmentModel> followerAttachmentModelList;

	@ApiModelProperty(value = "跟单员意见")
	private String dealmanRemark;

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getDealmanRemark() {
		return dealmanRemark;
	}

	public void setDealmanRemark(String dealmanRemark) {
		this.dealmanRemark = dealmanRemark;
	}

	public String getDataTransferDate() {
		return dataTransferDate;
	}

	public void setDataTransferDate(String dataTransferDate) {
		this.dataTransferDate = dataTransferDate;
	}

	public FollowerRedeemModel getFollowerRedeemModel() {
		return followerRedeemModel;
	}

	public void setFollowerRedeemModel(FollowerRedeemModel followerRedeemModel) {
		this.followerRedeemModel = followerRedeemModel;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getGuaranteeNum() {
		return guaranteeNum;
	}

	public void setGuaranteeNum(String guaranteeNum) {
		this.guaranteeNum = guaranteeNum;
	}

	public String getGuaranteeType() {
		return guaranteeType;
	}

	public void setGuaranteeType(String guaranteeType) {
		this.guaranteeType = guaranteeType;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<FollowerCreditModel> getFollowerCreditModelList() {
		return followerCreditModelList;
	}

	public void setFollowerCreditModelList(List<FollowerCreditModel> followerCreditModelList) {
		this.followerCreditModelList = followerCreditModelList;
	}

	public List<FollowerAttachmentModel> getFollowerAttachmentModelList() {
		return followerAttachmentModelList;
	}

	public void setFollowerAttachmentModelList(List<FollowerAttachmentModel> followerAttachmentModelList) {
		this.followerAttachmentModelList = followerAttachmentModelList;
	}
}
