package yhao.micro.service.surety.business.apilist.model.intention.intention;

import io.swagger.annotations.ApiModelProperty;
import yhao.micro.service.surety.business.apilist.model.intention.IntentionBasePageModel;
import yhao.micro.service.surety.business.apilist.model.intention.follower.FollowerCreditModel;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Created by ql on 2019/1/10 09:10
 * @Version: v1.0
 */
public class IntentionPageModel extends IntentionBasePageModel {
	@ApiModelProperty(value = "城市组织id")
	private String orgId;

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

	@ApiModelProperty(value = "跟单员姓名")
	private String followerName;

	@ApiModelProperty(value = "征信专员姓名")
	private String creditName;

	@ApiModelProperty(value = "赎楼员姓名")
	private String repayName;

	@ApiModelProperty("创建日期")
	private Date createTime;

	@ApiModelProperty("是否已提交,此字段用来判断是否可删除,YES=隐藏删除")
	private String isSubmit;

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getIsSubmit() {
		return isSubmit;
	}

	public void setIsSubmit(String isSubmit) {
		this.isSubmit = isSubmit;
	}

	@Override
	public Date getCreateTime() {
		return createTime;
	}

	@Override
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public List<FollowerCreditModel> getFollowerCreditModelList() {
		return followerCreditModelList;
	}

	public void setFollowerCreditModelList(List<FollowerCreditModel> followerCreditModelList) {
		this.followerCreditModelList = followerCreditModelList;
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

	public String getFollowerName() {
		return followerName;
	}

	public void setFollowerName(String followerName) {
		this.followerName = followerName;
	}

	public String getCreditName() {
		return creditName;
	}

	public void setCreditName(String creditName) {
		this.creditName = creditName;
	}

	public String getRepayName() {
		return repayName;
	}

	public void setRepayName(String repayName) {
		this.repayName = repayName;
	}

}
