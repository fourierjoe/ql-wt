package yhao.micro.service.surety.business.apilist.form.finance;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import yhao.infra.apilist.ValidationForm;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.infra.apilist.validate.PageForm;
import yhao.micro.service.surety.business.apilist.model.enums.finance.ChargeStatusEnum;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/14 11:27
 * @Description:
 */
public class FinanceTollQueryForm extends PageForm {
    @ApiModelProperty(value = "团队id")
    private String orgId;
    @ApiModelProperty(value = "业务部门id")
    private String positionOrgId;
    @ApiModelProperty(value = "客户经理id")
    private String personId;
    @ApiModelProperty(value = "单据编号/物业名称/买卖双方")
    private String keyWord;
    @ApiModelProperty(value = "业务类别id")
    private String bizId;
    @ApiModelProperty(value = "确认收费开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String confirmTollStartTime;
    @ApiModelProperty(value = "确认收费结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String confirmTollEndTime;
    @ApiModelProperty(value = "收费状态 NO_CHARGE未收费, NO_CONFIRM 收费未确认, CONFIRM已确认")
    private ChargeStatusEnum chargeStatus;
    @ApiModelProperty(value = "操作类型 WARRANTY 担保费 DELAY 展期费 OVERDUE 逾期 ",required = true)
    @NotBlank(message = "操作类型不能为空")
    private String positionType;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getPositionOrgId() {
        return positionOrgId;
    }

    public void setPositionOrgId(String positionOrgId) {
        this.positionOrgId = positionOrgId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getConfirmTollStartTime() {
        return confirmTollStartTime;
    }

    public void setConfirmTollStartTime(String confirmTollStartTime) {
        this.confirmTollStartTime = confirmTollStartTime;
    }

    public String getConfirmTollEndTime() {
        return confirmTollEndTime;
    }

    public void setConfirmTollEndTime(String confirmTollEndTime) {
        this.confirmTollEndTime = confirmTollEndTime;
    }

    public ChargeStatusEnum getChargeStatus() {
        return chargeStatus;
    }

    public void setChargeStatus(ChargeStatusEnum chargeStatus) {
        this.chargeStatus = chargeStatus;
    }

    public String getPositionType() {
        return positionType;
    }

    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }
}
