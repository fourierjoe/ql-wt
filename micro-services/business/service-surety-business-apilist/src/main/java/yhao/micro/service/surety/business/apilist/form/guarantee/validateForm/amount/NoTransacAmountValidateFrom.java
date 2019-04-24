package yhao.micro.service.surety.business.apilist.form.guarantee.validateForm.amount;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;
import yhao.micro.service.surety.business.apilist.form.guarantee.validateForm.ValidateEstateSellerSaveForm;
import yhao.micro.service.surety.business.apilist.form.guarantee.validateForm.ValidateLoanBuyerSaveForm;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @Description:
 * @Created by ql on 2019/1/21 10:17
 * @Version: v1.0
 */
public class NoTransacAmountValidateFrom implements ValidationForm {
	@ApiModelProperty(value = "物业信息")
	@NotNull(message = "物业信息不得为空")
	@Valid
	private ValidateEstateSellerSaveForm validateEstateSellerSaveForm;

	@ApiModelProperty(value = "新贷款信息")
	@NotNull(message = "新贷款信息不得为空")
	@Valid
	private ValidateLoanBuyerSaveForm validateLoanBuyerSaveForm;
}
