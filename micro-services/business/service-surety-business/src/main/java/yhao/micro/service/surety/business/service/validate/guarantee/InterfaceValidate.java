package yhao.micro.service.surety.business.service.validate.guarantee;

import yhao.micro.service.constants.util.WrapDozerUtil;
import yhao.micro.service.surety.business.apilist.form.guarantee.EstateSellerForm;
import yhao.micro.service.surety.business.apilist.form.guarantee.GuaranteeForm;
import yhao.micro.service.surety.business.apilist.form.guarantee.PersonInfoTradesSaveForm;
import yhao.micro.service.surety.business.apilist.form.guarantee.validateForm.ValidateEstateSellerSaveForm;
import yhao.micro.service.surety.business.apilist.model.enums.guarantee.CltTypEnum;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

/**
 * @Description:
 * @Created by ql on 2019/1/23 11:46
 * @Version: v1.0
 */
public abstract class InterfaceValidate {

	public abstract void validate(GuaranteeForm form, Validator validate);

	public boolean checkEstateSellerForm(List<EstateSellerForm> list, Validator validate) {
		for (EstateSellerForm estateSellerForm : list) {
			// 校验评估价,来源联系人,电话字段
			ValidateEstateSellerSaveForm map = WrapDozerUtil.map(estateSellerForm.getEstateSellerSaveForm(), ValidateEstateSellerSaveForm.class);
			validate(map, validate);

			for (PersonInfoTradesSaveForm personInfoTradesSaveForm : estateSellerForm.getEstateSellerSaveForm().getPersonInfoTradesSaveFormList()) {
				if (personInfoTradesSaveForm.getCltTyp() == (CltTypEnum.BUYER)) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * 手动校验
	 * @param t
	 * @param <T>
	 */
	public <T> void validate(T t, Validator validate) {
		Set<ConstraintViolation<T>> validate1 = validate.validate(t);
		for (ConstraintViolation<T> constraintViolation : validate1) {
			throw new RuntimeException(constraintViolation.getMessage());
		}
	}

}
