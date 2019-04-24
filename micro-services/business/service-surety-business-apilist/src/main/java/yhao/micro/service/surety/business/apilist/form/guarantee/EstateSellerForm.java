package yhao.micro.service.surety.business.apilist.form.guarantee;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @Description:
 * @Created by ql on 2019/1/2 19:18
 * @Version: v1.0
 */
public class EstateSellerForm implements ValidationForm {
	@ApiModelProperty(value = "物业信息")
	@NotNull(message = "物业信息不得为空")
	@Valid
	private EstateSellerSaveForm estateSellerSaveForm;

	public EstateSellerSaveForm getEstateSellerSaveForm() {
		return estateSellerSaveForm;
	}

	public void setEstateSellerSaveForm(EstateSellerSaveForm estateSellerSaveForm) {
		this.estateSellerSaveForm = estateSellerSaveForm;
	}
}
