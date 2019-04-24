package yhao.micro.service.surety.business.service.validate.guarantee;

import org.springframework.stereotype.Component;
import yhao.micro.service.constants.util.WrapDozerUtil;
import yhao.micro.service.surety.business.apilist.form.guarantee.GuaranteeForm;
import yhao.micro.service.surety.business.apilist.form.guarantee.validateForm.cash.ValidateLoanPaymentSaveForm;
import yhao.micro.service.surety.business.apilist.form.guarantee.validateForm.cash.ValidateNoTranAndCashLoanBuyerSaveForm;

import javax.annotation.Resource;
import javax.validation.Validator;
import java.util.List;

/**
 * @Description: 非交易现金赎楼
 * @Created by ql on 2019/1/23 18:26
 * @Version: v1.0
 */
public class NotTransactionCash extends InterfaceValidate {
	@Override
	public void validate(GuaranteeForm form, Validator validate) {

		// 校验借款人,贷款发放方式字段
		ValidateNoTranAndCashLoanBuyerSaveForm map = WrapDozerUtil.map(form.getLoanBuyerSaveForm().getLoanerName(), ValidateNoTranAndCashLoanBuyerSaveForm.class);
		validate(map, validate);

		// 校验新贷款情况贷款发放账号
		List<ValidateLoanPaymentSaveForm> validateLoanPaymentSaveForms = WrapDozerUtil.mapList(form.getLoanPaymentSaveFormList(), ValidateLoanPaymentSaveForm.class);
		validate(validateLoanPaymentSaveForms, validate);

		if (!checkEstateSellerForm(form.getEstateSellerFormList(), validate)) {
			throw new RuntimeException("非交易现金赎楼页面不得传入买家信息...");
		}
	}
}
