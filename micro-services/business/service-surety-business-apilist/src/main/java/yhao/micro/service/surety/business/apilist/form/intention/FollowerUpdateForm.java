package yhao.micro.service.surety.business.apilist.form.intention;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import yhao.infra.apilist.validate.IdForm;
import yhao.micro.service.constants.enums.YNEnum;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;

public class FollowerUpdateForm extends IdForm {

    @ApiModelProperty(value = "跟单员接受状态, YES/NO", hidden = true, example = "YES")
    @NotNull(message = "跟单员接受状态不得为空")
    private YNEnum receiveState = YNEnum.YES;

    @ApiModelProperty(value = "跟单员转单状态", required = true, example = "NO")
    @NotNull(message = "跟单员转单状态不得为空")
    private YNEnum transferState = YNEnum.NO;

    @ApiModelProperty(value = "跟单员业主/买家征信信息", required = true)
    @Valid
    @NotEmpty(message = "跟单员业主/买家征信信息不得为空")
    private List<FollowerBuyerAndSellerForm> followerBuyerAndSellerFormList;

    @ApiModelProperty(value = "档案资料清单")
    private List<FollowerAttachmentForm> followerAttachmentFormList;

    @ApiModelProperty(value = "跟单员table还款申请")
    private FollowerRedeemForm followerRedeem;

    @ApiModelProperty(value = "资料转交赎楼员时间",example = "2018-12-25")
    @NotNull(message = "资料转交赎楼员时间不得为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dataTransferDate;

    @ApiModelProperty(value = "跟单员意见", example = "跟单员意见")
    private String dealmanRemark;

    public Date getDataTransferDate() {
        return dataTransferDate;
    }

    public void setDataTransferDate(Date dataTransferDate) {
        this.dataTransferDate = dataTransferDate;
    }

    public String getDealmanRemark() {
        return dealmanRemark;
    }

    public void setDealmanRemark(String dealmanRemark) {
        this.dealmanRemark = dealmanRemark;
    }

    public YNEnum getReceiveState() {
        return receiveState;
    }

    public void setReceiveState(YNEnum receiveState) {
        this.receiveState = receiveState;
    }

    public YNEnum getTransferState() {
        return transferState;
    }

    public void setTransferState(YNEnum transferState) {
        this.transferState = transferState;
    }

    public List<FollowerBuyerAndSellerForm> getFollowerBuyerAndSellerFormList() {
        return followerBuyerAndSellerFormList;
    }

    public void setFollowerBuyerAndSellerFormList(List<FollowerBuyerAndSellerForm> followerBuyerAndSellerFormList) {
        this.followerBuyerAndSellerFormList = followerBuyerAndSellerFormList;
    }

    public List<FollowerAttachmentForm> getFollowerAttachmentFormList() {
        return followerAttachmentFormList;
    }

    public void setFollowerAttachmentFormList(List<FollowerAttachmentForm> followerAttachmentFormList) {
        this.followerAttachmentFormList = followerAttachmentFormList;
    }

    public FollowerRedeemForm getFollowerRedeem() {
        return followerRedeem;
    }

    public void setFollowerRedeem(FollowerRedeemForm followerRedeem) {
        this.followerRedeem = followerRedeem;
    }
}
