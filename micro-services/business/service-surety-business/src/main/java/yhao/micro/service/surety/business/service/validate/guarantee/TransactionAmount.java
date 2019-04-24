package yhao.micro.service.surety.business.service.validate.guarantee;

import org.springframework.stereotype.Component;
import yhao.micro.service.constants.util.WrapDozerUtil;
import yhao.micro.service.surety.business.apilist.form.guarantee.GuaranteeForm;
import yhao.micro.service.surety.business.apilist.form.guarantee.validateForm.amount.ValidateGuaranteeSituationSaveForm;

import javax.annotation.Resource;
import javax.validation.Validator;

/**
 * @Description:
 * @Created by ql on 2019/1/23 18:51
 * @Version: v1.0
 */
public class TransactionAmount extends InterfaceValidate{
	@Override
	public void validate(GuaranteeForm form, Validator validate) {
		// 校验担保情况
		ValidateGuaranteeSituationSaveForm map = WrapDozerUtil.map(form.getGuaranteeSituationSaveForm(), ValidateGuaranteeSituationSaveForm.class);
		validate(map, validate);
	}
}
