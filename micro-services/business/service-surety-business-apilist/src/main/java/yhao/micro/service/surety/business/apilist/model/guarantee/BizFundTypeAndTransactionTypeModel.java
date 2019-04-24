package yhao.micro.service.surety.business.apilist.model.guarantee;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

/**
 * @Description:
 * @Created by ql on 2019/1/21 14:30
 * @Version: v1.0
 */
public class BizFundTypeAndTransactionTypeModel extends Entity<String> {
	@ApiModelProperty(value = "资金分类 ,额度=AMOUNT,现金=CASH")
	private String fundType;

	@ApiModelProperty(value = "交易类型 TRANSACTION=交易类, NOT_TRANSACTION =非交易类")
	private String transactionType;

	public String getFundType() {
		return fundType;
	}

	public void setFundType(String fundType) {
		this.fundType = fundType;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
}
