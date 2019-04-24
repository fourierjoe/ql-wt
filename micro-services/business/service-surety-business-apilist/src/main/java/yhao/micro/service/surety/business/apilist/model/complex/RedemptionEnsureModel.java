package yhao.micro.service.surety.business.apilist.model.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.constants.enums.YNEnum;
import yhao.micro.service.surety.business.apilist.model.enums.complex.RedemptionEnsureStatus;

import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/5 16:09
 * @Description:
 */
public class RedemptionEnsureModel extends Entity<String> {
    @ApiModelProperty("担保单id")
    private String guaranteePid;
    @ApiModelProperty("是否寄出")
    private YNEnum isSend;
    @ApiModelProperty("寄出日期")
    private Date sendDate;
    @ApiModelProperty("寄出备注")
    private String sendRemark;
    @ApiModelProperty("保函单状态")
    private RedemptionEnsureStatus status;
    @ApiModelProperty("是否再次寄出")
    private YNEnum isRenew;
    @ApiModelProperty("收件人")
    private String recipientOperatorId;
    @ApiModelProperty("退回日期")
    private Date rebackDate;
    @ApiModelProperty("退回备注")
    private  String rebackRemark;
    @ApiModelProperty("再次寄出日期")
    private Date renewDate;
    @ApiModelProperty("再次寄出备注")
    private String renewRemark;

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getSendRemark() {
        return sendRemark;
    }

    public void setSendRemark(String sendRemark) {
        this.sendRemark = sendRemark;
    }

    public String getGuaranteePid() {
        return guaranteePid;
    }

    public void setGuaranteePid(String guaranteePid) {
        this.guaranteePid = guaranteePid;
    }

    public YNEnum getIsSend() {
        return isSend;
    }

    public void setIsSend(YNEnum isSend) {
        this.isSend = isSend;
    }

    public RedemptionEnsureStatus getStatus() {
        return status;
    }

    public void setStatus(RedemptionEnsureStatus status) {
        this.status = status;
    }

    public YNEnum getIsRenew() {
        return isRenew;
    }

    public void setIsRenew(YNEnum isRenew) {
        this.isRenew = isRenew;
    }

    public String getRecipientOperatorId() {
        return recipientOperatorId;
    }

    public void setRecipientOperatorId(String recipientOperatorId) {
        this.recipientOperatorId = recipientOperatorId;
    }

    public Date getRebackDate() {
        return rebackDate;
    }

    public void setRebackDate(Date rebackDate) {
        this.rebackDate = rebackDate;
    }

    public String getRebackRemark() {
        return rebackRemark;
    }

    public void setRebackRemark(String rebackRemark) {
        this.rebackRemark = rebackRemark;
    }

    public Date getRenewDate() {
        return renewDate;
    }

    public void setRenewDate(Date renewDate) {
        this.renewDate = renewDate;
    }

    public String getRenewRemark() {
        return renewRemark;
    }

    public void setRenewRemark(String renewRemark) {
        this.renewRemark = renewRemark;
    }
}
