package yhao.micro.service.surety.business.service.validate.guarantee.factory;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import yhao.micro.service.surety.business.apilist.model.enums.businessType.FundTypeEnum;
import yhao.micro.service.surety.business.apilist.model.enums.businessType.TransactionTypeEnum;
import yhao.micro.service.surety.business.apilist.model.guarantee.BizFundTypeAndTransactionTypeModel;
import yhao.micro.service.surety.business.service.validate.guarantee.*;

/**
 * @Description: 校验工厂
 * @Created by ql on 2019/1/23 11:43
 * @Version: v1.0
 */
@Component
public class ValidateFactory {

	public InterfaceValidate getInterfaceValidate(BizFundTypeAndTransactionTypeModel model) {
		if (model.getTransactionType().equals(TransactionTypeEnum.TRANSACTION.toString())
				&& model.getFundType().equals(FundTypeEnum.AMOUNT.toString())) { //交易类额度

			return new TransactionAmount();

		} else if (model.getTransactionType().equals(TransactionTypeEnum.NOT_TRANSACTION.toString())
				&& model.getFundType().equals(FundTypeEnum.AMOUNT.toString())) { // 非交易类额度赎楼

			return new NotTransactionAmount();

		} else if (model.getTransactionType().equals(TransactionTypeEnum.TRANSACTION.toString())
				&& model.getFundType().equals(FundTypeEnum.CASH.toString())) { // 交易类现金赎楼

			return new TransactionCash();

		} else if (model.getTransactionType().equals(TransactionTypeEnum.NOT_TRANSACTION.toString())
				&& model.getFundType().equals(FundTypeEnum.CASH.toString())) { // 非交易现金赎楼

			return new NotTransactionCash();

		} else if (model.getTransactionType().equals(TransactionTypeEnum.TRANSACTION.toString())
				&& model.getFundType().equals(FundTypeEnum.CREDIT.toString())) { // 交易类信用垫资

			return new TtransactionCredit();

		} else {}

		return null;
	}

}
