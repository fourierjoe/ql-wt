package yhao.micro.service.surety.business.apilist.model.intention.intention;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.surety.business.apilist.model.intention.IntentionAttachmentModel;
import yhao.micro.service.surety.business.apilist.model.intention.credit.CreditOfBuyerAndSellerModel;

import java.util.List;

@ApiModel
public class IntentionModel extends Entity<String> {

    @ApiModelProperty("业务类型ID")
    private String businessId;

    @ApiModelProperty("业务类型名称")
    private String businessName;

    @ApiModelProperty("资金分类")
    private String fundType;

    @ApiModelProperty("交易类型")
    private String transactionType;

    @ApiModelProperty("买卖双方征信信息")
    private List<CreditOfBuyerAndSellerModel> creditList;

    @ApiModelProperty("意向单附件信息")
    private List<IntentionAttachmentModel> intentionAttachmentModelList;

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public List<CreditOfBuyerAndSellerModel> getCreditList() {
        return creditList;
    }

    public void setCreditList(List<CreditOfBuyerAndSellerModel> creditList) {
        this.creditList = creditList;
    }

    public List<IntentionAttachmentModel> getIntentionAttachmentModelList() {
        return intentionAttachmentModelList;
    }

    public void setIntentionAttachmentModelList(List<IntentionAttachmentModel> intentionAttachmentModelList) {
        this.intentionAttachmentModelList = intentionAttachmentModelList;
    }

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

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }
}
