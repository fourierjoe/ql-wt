package yhao.micro.service.surety.business.service.validate.guarantee;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import yhao.micro.service.surety.business.apilist.form.guarantee.GuaranteeForm;

import javax.annotation.Resource;
import javax.validation.Validator;

/**
 * @Description: 交易类信用垫资
 * @Created by ql on 2019/1/23 18:27
 * @Version: v1.0
 */
public class TtransactionCredit extends InterfaceValidate {
	@Override
	public void validate(GuaranteeForm form, Validator validate) {
		if (form.getLoanSellerSaveForm() != null) {
			throw new RuntimeException("交易类信用垫资不得传入原贷款信息...");
		}

		// 无退尾款信息
		if (StringUtils.isNotEmpty(form.getLoanBuyerSaveForm().getRefundAccountNam())
				|| StringUtils.isNotEmpty(form.getLoanBuyerSaveForm().getRefundAccountNum())
				|| StringUtils.isNotEmpty(form.getLoanBuyerSaveForm().getRefundAccountBank())) {
			throw new RuntimeException("交易类信用垫资退尾款信息...");
		}
	}
}
