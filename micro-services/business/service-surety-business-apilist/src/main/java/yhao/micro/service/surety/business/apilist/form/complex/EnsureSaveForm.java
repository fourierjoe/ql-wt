package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
import yhao.infra.apilist.ValidationForm;

import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/6 19:26
 * @Description:
 */
public class EnsureSaveForm implements ValidationForm {
    @ApiModelProperty(value = "担保单id", required = true)
    private String guaranteePid;
    @ApiModelProperty("寄出日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date sendDate;
    @ApiModelProperty("寄出备注")
    private String sendRemark;
    @ApiModelProperty("收件人")
    private String recipientOperatorId;
    @ApiModelProperty("退回日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date rebackDate;
    @ApiModelProperty("退回备注")
    private String rebackRemark;
    @ApiModelProperty("再次寄出日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date renewDate;
    @ApiModelProperty("再次寄出备注")
    private String renewRemark;
    @ApiModelProperty(value = "请求类型 SEND 寄出 FOLLOW 跟进 REBACK 退回",required = true)
    private String positionType;
    @ApiModelProperty(hidden = true)
    private String createOperatorId;

    public String getGuaranteePid() {
        return guaranteePid;
    }

    public void setGuaranteePid(String guaranteePid) {
        this.guaranteePid = guaranteePid;
    }

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

    public String getPositionType() {
        return positionType;
    }

    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }

    public String getCreateOperatorId() {
        return createOperatorId;
    }

    public void setCreateOperatorId(String createOperatorId) {
        this.createOperatorId = createOperatorId;
    }


}
