package yhao.micro.service.surety.business.apilist.form.intention;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import yhao.infra.apilist.validate.IdUnForm;

import java.util.List;

public class IntentionSaveForm extends IdUnForm {

    @ApiModelProperty("业务类型ID")
    @NotBlank(message = "业务类型ID不得为空")
    private String bizId;

    @ApiModelProperty("借款人姓名")
    @NotBlank(message = "借款人姓名不得为空")
    private String loanerName;

    @ApiModelProperty("买卖双方信息")
    @NotEmpty(message = "买卖双方信息不得为空")
    private List<IntentionBuyerAndSellerSaveForm> buyerAndSellerList;

    @ApiModelProperty("意向单附件信息")
    private List<IntentionAttachmentSaveForm> attachmentList;

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getLoanerName() {
        return loanerName;
    }

    public void setLoanerName(String loanerName) {
        this.loanerName = loanerName;
    }

    public List<IntentionBuyerAndSellerSaveForm> getBuyerAndSellerList() {
        return buyerAndSellerList;
    }

    public void setBuyerAndSellerList(List<IntentionBuyerAndSellerSaveForm> buyerAndSellerList) {
        this.buyerAndSellerList = buyerAndSellerList;
    }

    public List<IntentionAttachmentSaveForm> getAttachmentList() {
        return attachmentList;
    }

    public void setAttachmentList(List<IntentionAttachmentSaveForm> attachmentList) {
        this.attachmentList = attachmentList;
    }
}
