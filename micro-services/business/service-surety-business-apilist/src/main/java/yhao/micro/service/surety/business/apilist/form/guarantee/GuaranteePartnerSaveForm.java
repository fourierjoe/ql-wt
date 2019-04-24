package yhao.micro.service.surety.business.apilist.form.guarantee;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.micro.service.constants.enums.YNEnum;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @Description:
 * @Created by ql on 2019/1/2 18:27
 * @Version: v1.0
 */
public class GuaranteePartnerSaveForm extends IdUnForm {
	@ApiModelProperty(value = "担保单ID", hidden = true)
	private String guaranteeId;

	@ApiModelProperty(value = "经办人ERP表ID", example = "123456", required = true)
	@NotBlank(message = "经办人ERP表ID必传")
	private String managerId;

	@ApiModelProperty(value = "组织ID", example = "orgId", required = true)
	@NotBlank(message = "组织ID必传")
	private String orgId;

	@ApiModelProperty(value = "经办人姓名", example = "张三", required = true)
	@NotBlank(message = "经办人姓名必传")
	private String managerName;

	@ApiModelProperty(value = "是否主要经办人(客户经理)YES/NO", example = "YES", required = true)
	@NotNull(message = "是否主要经办人必传")
	private YNEnum isMajorManager;

	@ApiModelProperty(value = "单据占用比例,暂不启用", example = "5.1", hidden = true)
	private BigDecimal managerRate;

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
