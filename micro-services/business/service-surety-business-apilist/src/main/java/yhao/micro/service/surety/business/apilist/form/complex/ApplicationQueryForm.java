package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
import yhao.infra.apilist.validate.PageForm;

import java.util.Date;

/**
 * @Description 打折申请/展期申请列表查询form
 *
 * @Author leice
 * @Date 2018/12/10 10:05
 * @Version 1.0
 */
public class ApplicationQueryForm extends PageForm {

    @ApiModelProperty("组织id")
    private String orgId;

    @ApiModelProperty("流程编码")
    private String processCode;

    @ApiModelProperty("客户经理名称")
    private String accountManagerName;

    @ApiModelProperty("单据号/物业/买卖双方/打折申请单号")
    private String otherConditions;

    @ApiModelProperty("申请单状态")
    private String requisitionStatus;

    @ApiModelProperty("申请开始时间")
    private String startDate;

    @ApiModelProperty("申请结束时间")
    private String endDate;

    @ApiModelProperty("展期状态 1:正常 2：撤销 3：失效")
    private Integer status;

    @ApiModelProperty("展期收费状态1：未收费2：已收费未确认3：已收费已确认")
    private Integer statusFee;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatusFee() {
        return statusFee;
    }

    public void setStatusFee(Integer statusFee) {
        this.statusFee = statusFee;
    }

    public String getProcessCode() {
        return processCode;
    }

    public void setProcessCode(String processCode) {
        this.processCode = processCode;
    }

    public String getRequisitionStatus() {
        return requisitionStatus;
    }

    public void setRequisitionStatus(String requisitionStatus) {
        this.requisitionStatus = requisitionStatus;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getAccountManagerName() {
        return accountManagerName;
    }

    public void setAccountManagerName(String accountManagerName) {
        this.accountManagerName = accountManagerName;
    }

    public String getOtherConditions() {
        return otherConditions;
    }

    public void setOtherConditions(String otherConditions) {
        this.otherConditions = otherConditions;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "ApplicationQueryForm{" +
                "orgId='" + orgId + '\'' +
                ", otherConditions='" + otherConditions + '\'' +
                ", requisitionStatus='" + requisitionStatus + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
