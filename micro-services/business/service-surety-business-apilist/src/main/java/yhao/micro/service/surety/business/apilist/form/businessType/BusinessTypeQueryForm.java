package yhao.micro.service.surety.business.apilist.form.businessType;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.validate.PageForm;
import yhao.micro.service.surety.business.apilist.model.enums.businessType.FundTypeEnum;
import yhao.micro.service.surety.business.apilist.model.enums.businessType.TransactionTypeEnum;

/**
 * @Description: 业务类型设置所有条件检索
 *
 * @Auther: ql
 * @Date: 2018/12/8 18:29
 */
public class BusinessTypeQueryForm extends PageForm {

    @ApiModelProperty(value = "城市组织ID")
    @NotBlank(message = "城市组织ID不得为空")
    private String orgId;

    @ApiModelProperty(value = "业务类型名称, 支持模糊查询")
    private String bizName;

    @ApiModelProperty(value = "交易类型,TRANSACTION=交易类/NOT_TRANSACTION=非交易类", example = "TRANSACTION")
    private TransactionTypeEnum transactionType;

    @ApiModelProperty(value = "资金分类,AMOUNT=额度/CASH=现金", example = "AMOUNT")
    private FundTypeEnum fundType;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getBizName() {
        return bizName;
    }

    public void setBizName(String bizName) {
        this.bizName = bizName;
    }

    public TransactionTypeEnum getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionTypeEnum transactionType) {
        this.transactionType = transactionType;
    }

    public FundTypeEnum getFundType() {
        return fundType;
    }

    public void setFundType(FundTypeEnum fundType) {
        this.fundType = fundType;
    }
}
