package yhao.micro.service.surety.business.service.validate.guarantee;

import org.springframework.stereotype.Component;
import yhao.micro.service.constants.util.WrapDozerUtil;
import yhao.micro.service.surety.business.apilist.form.guarantee.GuaranteeForm;
import yhao.micro.service.surety.business.apilist.form.guarantee.validateForm.ValidateLoanBuyerSaveForm;

import javax.annotation.Resource;
import javax.validation.Validator;

/**
 * @Description: 非交易类额度校验
 * @Created by ql on 2019/1/23 11:49
 * @Version: v1.0
 */
public class NotTransactionAmount extends InterfaceValidate {
	@Override
	public void validate(GuaranteeForm form, Validator validate) {

		// 校验借款人字段
		ValidateLoanBuyerSaveForm map = WrapDozerUtil.map(form.getLoanBuyerSaveForm().getLoanerName(), ValidateLoanBuyerSaveForm.class);
		validate(map, validate);

		if(form.getTransactionGuaranteeInfoSaveForm() != null) {
			throw new RuntimeException("非交易类额度赎楼页面不得传入成交情况信息...");
		}

		if (!checkEstateSellerForm(form.getEstateSellerFormList(), validate)) {
			throw new RuntimeException("非交易类额度赎楼页面不得传入买家信息...");
		}
	}
}
