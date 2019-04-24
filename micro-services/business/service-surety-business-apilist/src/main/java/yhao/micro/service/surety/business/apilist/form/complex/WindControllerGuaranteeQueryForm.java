package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.PageForm;

import java.util.List;

/**
 * @Description 审查员审查和执行岗备注查询form
 *
 * @Author leice
 * @Date 2018/12/8 16:26
 * @Version 1.0
 */
public class WindControllerGuaranteeQueryForm extends PageForm {

    @ApiModelProperty("城市id")
    private String cityId;

    @ApiModelProperty("事项编码")
    private String thingCode;

    @ApiModelProperty("组织id")
    private String orgId;

    @ApiModelProperty("业务类型ids")
    private List<String> businessTypeIds;

    @ApiModelProperty("单据号/物业/买卖双方")
    private String otherConditions;

    @ApiModelProperty("资金类型 额度=AMOUNT;现金=CASH")
    private String moneyType;//额度=AMOUNT;现金=CASH

    @ApiModelProperty("客户经理名称")
    private String accountManagerName;

    @ApiModelProperty("审查员id")
    private String reviewPeopleId;

    @ApiModelProperty("是否备注 1:未备注 2：已备注")
    private Integer isRemarks;

    @ApiModelProperty("是否审查 1:未审查 2：已审查")
    private Integer isReview;

    @ApiModelProperty("是否接收 1:未接收 2：已接收")
    private Integer isReveice;

    @ApiModelProperty("接收开始时间 yyyy-MM-dd")
    private String reveiceStartTime;

    @ApiModelProperty("接收结束时间 yyyy-MM-dd")
    private String reveiceEndTime;

    public String getReviewPeopleId() {
        return reviewPeopleId;
    }

    public void setReviewPeopleId(String reviewPeopleId) {
        this.reviewPeopleId = reviewPeopleId;
    }

    public String getThingCode() {
        return thingCode;
    }

    public void setThingCode(String thingCode) {
        this.thingCode = thingCode;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public Integer getIsRemarks() {
        return isRemarks;
    }

    public void setIsRemarks(Integer isRemarks) {
        this.isRemarks = isRemarks;
    }

    public Integer getIsReview() {
        return isReview;
    }

    public void setIsReview(Integer isReview) {
        this.isReview = isReview;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOtherConditions() {
        return otherConditions;
    }

    public void setOtherConditions(String otherConditions) {
        this.otherConditions = otherConditions;
    }

    public String getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType;
    }

    public String getAccountManagerName() {
        return accountManagerName;
    }

    public void setAccountManagerName(String accountManagerName) {
        this.accountManagerName = accountManagerName;
    }

    public List<String> getBusinessTypeIds() {
        return businessTypeIds;
    }

    public void setBusinessTypeIds(List<String> businessTypeIds) {
        this.businessTypeIds = businessTypeIds;
    }

    public Integer getIsReveice() {
        return isReveice;
    }

    public void setIsReveice(Integer isReveice) {
        this.isReveice = isReveice;
    }

    public String getReveiceStartTime() {
        return reveiceStartTime;
    }

    public void setReveiceStartTime(String reveiceStartTime) {
        this.reveiceStartTime = reveiceStartTime;
    }

    public String getReveiceEndTime() {
        return reveiceEndTime;
    }

    public void setReveiceEndTime(String reveiceEndTime) {
        this.reveiceEndTime = reveiceEndTime;
    }

}
