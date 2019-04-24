package yhao.micro.service.surety.business.apilist.model.guarantee;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

import java.math.BigDecimal;

/**
 * @Description:
 * @Created by ql on 2018/12/10 20:00
 * @Version: v1.0
 */
public class GuaranteeManagerModel extends Entity<String> {

    @ApiModelProperty("担保单单据编号")
    private String guaranteeId;

    @ApiModelProperty("经办人ERP表ID")
    private String managerId;

    @ApiModelProperty("组织ID")
    private String orgId;

    @ApiModelProperty("经办人姓名")
    private String managerName;

    @ApiModelProperty("单据占用比例")
    private BigDecimal managerRate;

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public BigDecimal getManagerRate() {
        return managerRate;
    }

    public void setManagerRate(BigDecimal managerRate) {
        this.managerRate = managerRate;
    }
}
