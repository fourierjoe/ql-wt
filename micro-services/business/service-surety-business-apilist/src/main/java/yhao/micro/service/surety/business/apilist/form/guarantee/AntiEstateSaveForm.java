package yhao.micro.service.surety.business.apilist.form.guarantee;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.micro.service.surety.business.apilist.model.enums.guarantee.DeedTypeEnum;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @Description:
 * @Created by ql on 2019/1/3 17:58
 * @Version: v1.0
 */
public class AntiEstateSaveForm extends IdUnForm {
	@ApiModelProperty(value = "担保单ID", hidden = true)
	private String guaranteeId;

	@ApiModelProperty(value = "反担保人个人信息ID", hidden = true)
	private String antiGuarantorId;

	@ApiModelProperty(value = "房产名称",example = "房产名称")
	@NotBlank(message = "房产名称不得为空")
	private String estateName;

	@ApiModelProperty(value = "产证类型", example = "FCZ")
	@NotNull(message = "产证类型不得为空")
	private DeedTypeEnum deedType;

	@ApiModelProperty(value = "产证编号", example = "1111")
	@NotBlank(message = "产证编号不得为空")
	private String deedNum;

	@ApiModelProperty(value = "份额", dataType = "BigDecimal", example = "5.3")
	@NotNull(message = "份额不得为空")
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
