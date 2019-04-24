package yhao.micro.service.surety.business.apilist.model.businessType;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;


/**
 * @Description:
 * @Created by ql on 2018/12/9 17:24
 * @Version: v1.0
 */
public class BusinessTypeNameModel extends Entity<String> {

    @ApiModelProperty(value = "业务类型名称")
    private String businessName;

    @ApiModelProperty(value = "资金分类")
    private String fundType;

    @ApiModelProperty(value = "交易类型")
    private String transactionType;

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getFundType() {
        return fundType;
    }

    public void setFundType(String fundType) {
        this.fundType = fundType;
    }
}
