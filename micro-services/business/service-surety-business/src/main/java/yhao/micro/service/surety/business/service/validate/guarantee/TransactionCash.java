package yhao.micro.service.surety.business.service.validate.guarantee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import yhao.micro.service.constants.util.WrapDozerUtil;
import yhao.micro.service.surety.business.apilist.form.guarantee.GuaranteeForm;
import yhao.micro.service.surety.business.apilist.form.guarantee.TransactionTypeReceivePaymentPlanSaveForm;
import yhao.micro.service.surety.business.apilist.form.guarantee.validateForm.cash.ValidateTransactionTypeReceivePaymentPlanSaveForm;

import javax.annotation.Resource;
import javax.validation.Validator;
import java.util.Optional;

/**
 * @Description: 交易类现金赎楼校验
 * @Created by ql on 2019/1/23 18:25
 * @Version: v1.0
 */
public class TransactionCash extends InterfaceValidate {

	@Override
	public void validate(GuaranteeForm form, Validator validate) {


		// 校验回款记录
		for (TransactionTypeReceivePaymentPlanSaveForm transactionTypeReceivePaymentPlanSaveForm :
				Optional.ofNullable(form.getTransactionTypeReceivePaymentPlanSaveFormList()).orElseThrow(() -> new RuntimeException("交易类现金回款计划信息不得为空"))) {
			ValidateTransactionTypeReceivePaymentPlanSaveForm map = WrapDozerUtil.map(transactionTypeReceivePaymentPlanSaveForm, ValidateTransactionTypeReceivePaymentPlanSaveForm.class);
			validate(map, validate);
		}
	}
}
