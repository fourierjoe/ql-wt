package yhao.micro.service.surety.business.apilist.model.guarantee.output;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.surety.business.apilist.model.enums.guarantee.DeedTypeEnum;

import java.math.BigDecimal;

/**
 * @Description:
 * @Created by ql on 2019/1/11 11:25
 * @Version: v1.0
 */
public class AntiEstateModel extends Entity<String> {
	@ApiModelProperty(value = "担保单ID", hidden = true)
	private String guaranteeId;

	@ApiModelProperty(value = "反担保人个人信息ID", hidden = true)
	private String antiGuarantorId;

	@ApiModelProperty(value = "房产名称",example = "房产名称")
	private String estateName;

	@ApiModelProperty(value = "产证类型", example = "FCZ")
	private DeedTypeEnum deedType;

	@ApiModelProperty(value = "产证编号", example = "1111")
	private String deedNum;

	@ApiModelProperty(value = "份额", dataType = "BigDecimal", example = "5.3")
	private BigDecimal propertyPortion;

	public String getGuaranteeId() {
		return guaranteeId;
	}

	public void setGuaranteeId(String guaranteeId) {
		this.guaranteeId = guaranteeId;
	}

	public String getAntiGuarantorId() {
		return antiGuarantorId;
	}

	public void setAntiGuarantorId(String antiGuarantorId) {
		this.antiGuarantorId = antiGuarantorId;
	}

	public String getEstateName() {
		return estateName;
	}

	public void setEstateName(String estateName) {
		this.estateName = estateName;
	}

	public DeedTypeEnum getDeedType() {
		return deedType;
	}

	public void setDeedType(DeedTypeEnum deedType) {
		this.deedType = deedType;
	}

	public String getDeedNum() {
		return deedNum;
	}

	public void setDeedNum(String deedNum) {
		this.deedNum = deedNum;
	}

	public BigDecimal getPropertyPortion() {
		return propertyPortion;
	}

	public void setPropertyPortion(BigDecimal propertyPortion) {
		this.propertyPortion = propertyPortion;
	}
}
