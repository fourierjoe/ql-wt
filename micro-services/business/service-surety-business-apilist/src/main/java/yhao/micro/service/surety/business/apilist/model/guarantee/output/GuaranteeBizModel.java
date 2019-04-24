package yhao.micro.service.surety.business.apilist.model.guarantee.output;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.surety.business.apilist.model.enums.guarantee.GuaranteeTypeEnum;
import yhao.micro.service.surety.business.apilist.model.enums.guarantee.GuaranteetSourceEnum;

/**
 * @Description:
 * @Created by ql on 2019/1/11 11:05
 * @Version: v1.0
 */
public class GuaranteeBizModel extends Entity<String> {
	@ApiModelProperty(value = "担保单编号")
	private String guaranteeNum;

	@ApiModelProperty(value = "城市组织ID", example = "orgId")
	private String orgId;

	@ApiModelProperty(value = "交易编码(关联的交易编号【内单需要】)")
	private String internalId;

	@ApiModelProperty(value = "关联担保单号")
	private String guaranteeId;

	@ApiModelProperty(value = "业务类型ID", example = "b20a5d06-6813-48aa-8599-24ffeba4c950")
	private String bizId;

	@ApiModelProperty(value = "担保单状态", example = "")
	private String guaranteeState;

	@ApiModelProperty(value = "单据类型", example = "EXTERNAL")
	private GuaranteeTypeEnum guaranteeType;

	@ApiModelProperty(value = "银行主合同编号")
	private String bankContractNum;

	@ApiModelProperty(value = "来源：银行，中介，朋友", example = "BANK")
	private GuaranteetSourceEnum guaranteetSource;

	@ApiModelProperty(value = "中介公司名称", example = "中介公司名称")
	private String agencyName;

	public String getGuaranteeNum() {
		return guaranteeNum;
	}

	public void setGuaranteeNum(String guaranteeNum) {
		this.guaranteeNum = guaranteeNum;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getInternalId() {
		return internalId;
	}

	public void setInternalId(String internalId) {
		this.internalId = internalId;
	}

	public String getGuaranteeId() {
		return guaranteeId;
	}

	public void setGuaranteeId(String guaranteeId) {
		this.guaranteeId = guaranteeId;
	}

	public String getBizId() {
		return bizId;
	}

	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

	public String getGuaranteeState() {
		return guaranteeState;
	}

	public void setGuaranteeState(String guaranteeState) {
		this.guaranteeState = guaranteeState;
	}

	public GuaranteeTypeEnum getGuaranteeType() {
		return guaranteeType;
	}

	public void setGuaranteeType(GuaranteeTypeEnum guaranteeType) {
		this.guaranteeType = guaranteeType;
	}

	public String getBankContractNum() {
		return bankContractNum;
	}

	public void setBankContractNum(String bankContractNum) {
		this.bankContractNum = bankContractNum;
	}

	public GuaranteetSourceEnum getGuaranteetSource() {
		return guaranteetSource;
	}

	public void setGuaranteetSource(GuaranteetSourceEnum guaranteetSource) {
		this.guaranteetSource = guaranteetSource;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}
}
