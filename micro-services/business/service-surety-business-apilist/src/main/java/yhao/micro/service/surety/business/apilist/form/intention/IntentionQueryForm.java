package yhao.micro.service.surety.business.apilist.form.intention;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import yhao.infra.apilist.validate.PageForm;
import yhao.micro.service.constants.enums.YNEnum;
import yhao.micro.service.surety.business.apilist.model.enums.intention.CreditAndRepayScheduleEnum;

import java.util.Date;

public class IntentionQueryForm extends PageForm {

    @ApiModelProperty(value = "组织ID", required = true)
    @NotBlank(message = "orgId不得为空")
    private String orgId;

    @ApiModelProperty(value = "客户经理ID")
    private String managerId;

    @ApiModelProperty("跟单员ID")
    private String followerId;

    @ApiModelProperty("征信专员ID")
    private String creditClerkId;

    @ApiModelProperty("还款申请办理人ID")
    private String redeemId;

    @ApiModelProperty("业务类型ID")
    private String bizId;

    @ApiModelProperty("跟单员接受状态")
    private YNEnum receiveState;

    @ApiModelProperty("查征信进度")
    private CreditAndRepayScheduleEnum creditState;

    @ApiModelProperty("还款申请进度")
    private CreditAndRepayScheduleEnum repayState;

    @ApiModelProperty("创建日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    @ApiModelProperty("结束日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    @ApiModelProperty("买卖双方姓名")
    private String cltName;

    @ApiModelProperty("单据编号")
    private String guaranteeNum;

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getFollowerId() {
        return followerId;
    }

    public void setFollowerId(String followerId) {
        this.followerId = followerId;
    }

    public String getCreditClerkId() {
        return creditClerkId;
    }

    public void setCreditClerkId(String creditClerkId) {
        this.creditClerkId = creditClerkId;
    }

    public String getRedeemId() {
        return redeemId;
    }

    public void setRedeemId(String redeemId) {
        this.redeemId = redeemId;
    }

    public YNEnum getReceiveState() {
        return receiveState;
    }

    public void setReceiveState(YNEnum receiveState) {
        this.receiveState = receiveState;
    }

    public CreditAndRepayScheduleEnum getCreditState() {
        return creditState;
    }

    public void setCreditState(CreditAndRepayScheduleEnum creditState) {
        this.creditState = creditState;
    }

    public CreditAndRepayScheduleEnum getRepayState() {
        return repayState;
    }

    public void setRepayState(CreditAndRepayScheduleEnum repayState) {
        this.repayState = repayState;
    }

    public String getGuaranteeNum() {
        return guaranteeNum;
    }

    public void setGuaranteeNum(String guaranteeNum) {
        this.guaranteeNum = guaranteeNum;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCltName() {
        return cltName;
    }

    public void setCltName(String cltName) {
        this.cltName = cltName;
    }
}
