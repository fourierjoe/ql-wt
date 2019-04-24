package yhao.micro.service.surety.business.apilist.form.guarantee.validateForm;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.ValidationForm;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @Description:
 * @Created by ql on 2019/1/21 10:20
 * @Version: v1.0
 */
public class ValidateEstateSellerSaveForm implements ValidationForm {
	@ApiModelProperty(value = "评估价", example = "13000001")
	@NotNull(message = "评估价不得为空")
	private BigDecimal evaluatePrice;

	@ApiModelProperty(value = "来源联系人", example = "李四")
	@NotBlank(message = "来源联系人不得为空")
	private String sourceContactName;

	@ApiModelProperty(value = "来源电话", example = "131")
	@NotBlank(message = "来源电话不得为空")
	private String sourceContactTele;

	public BigDecimal getEvaluatePrice() {
		return evaluatePrice;
	}

	public void setEvaluatePrice(BigDecimal evaluatePrice) {
		this.evaluatePrice = evaluatePrice;
	}

	public String getSourceContactName() {
		return sourceContactName;
	}

	public void setSourceContactName(String sourceContactName) {
		this.sourceContactName = sourceContactName;
	}

	public String getSourceContactTele() {
		return sourceContactTele;
	}

	public void setSourceContactTele(String sourceContactTele) {
		this.sourceContactTele = sourceContactTele;
	}
}
