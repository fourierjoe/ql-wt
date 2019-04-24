package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.PageForm;

/**
 * @Description 逾期列表查询form
 * @Author leice
 * @Date 2019/2/15 15:33
 * @Version 1.0
 */
public class OverDueQueryForm extends PageForm {

    @ApiModelProperty("组织id")
    private String orgId;

    @ApiModelProperty("流程编码")
    private String processCode;

    @ApiModelProperty("客户经理名称")
    private String accountManagerName;

    @ApiModelProperty("单据号/物业/买卖双方/打折申请单号")
    private String otherConditions;

    @ApiModelProperty("申请状态 NULL:未发起 RUNNING:审批中 END:审批通过 REJECT:驳回 ALL:查询所有")//NULL:未发起 RUNNING:审批中 END:审批通过 REJECT:驳回 ALL:查询所有
    private String requisitionStatus;

    public String getProcessCode() {
        return processCode;
    }

    public void setProcessCode(String processCode) {
        this.processCode = processCode;
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

    public String getRequisitionStatus() {
        return requisitionStatus;
    }

    public void setRequisitionStatus(String requisitionStatus) {
        this.requisitionStatus = requisitionStatus;
    }

    @Override
    public String toString() {
        return "OverDueQueryForm{" +
                "orgId='" + orgId + '\'' +
                ", accountManagerName='" + accountManagerName + '\'' +
                ", otherConditions='" + otherConditions + '\'' +
                ", requisitionStatus='" + requisitionStatus + '\'' +
                '}';
    }
}
