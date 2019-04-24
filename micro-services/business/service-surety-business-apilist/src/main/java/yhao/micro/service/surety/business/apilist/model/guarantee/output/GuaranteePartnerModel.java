package yhao.micro.service.surety.business.apilist.model.guarantee.output;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.constants.enums.YNEnum;

import java.math.BigDecimal;

/**
 * @Description:
 * @Created by ql on 2019/1/11 11:02
 * @Version: v1.0
 */
public class GuaranteePartnerModel extends Entity<String> {
	@ApiModelProperty(value = "担保单ID",hidden = true)
	private String guaranteeId;

	@ApiModelProperty(value = "经办人ERP表ID")
	private String managerId;

	@ApiModelProperty(value = "组织ID")
	private String orgId;

	@ApiModelProperty(value = "经办人姓名")
	private String managerName;

	@ApiModelProperty(value = "经办电话")
	private String phone;

	@ApiModelProperty(value = "经办人部门")
	private String orgName;

	@ApiModelProperty(value = "是否主要经办人(客户经理)YES/NO")
	private YNEnum isMajorManager;

	@ApiModelProperty(value = "单据占用比例")
	private BigDecimal managerRate;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getGuaranteeId() {
		return guaranteeId;
	}

	public void setGuaranteeId(String guaranteeId) {
		this.guaranteeId = guaranteeId;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public YNEnum getIsMajorManager() {
		return isMajorManager;
	}

	public void setIsMajorManager(YNEnum isMajorManager) {
		this.isMajorManager = isMajorManager;
	}

	public BigDecimal getManagerRate() {
		return managerRate;
	}

	public void setManagerRate(BigDecimal managerRate) {
		this.managerRate = managerRate;
	}
}
