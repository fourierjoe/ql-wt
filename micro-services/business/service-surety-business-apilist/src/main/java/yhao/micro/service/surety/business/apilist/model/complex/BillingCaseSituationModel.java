package yhao.micro.service.surety.business.apilist.model.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.surety.business.apilist.model.enums.complex.BilingCaseSituationStatus;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/5 17:39
 * @Description:
 */
public class BillingCaseSituationModel extends Entity<String> {
    @ApiModelProperty("出账前核查id")
    private String billingCheckId;
    @ApiModelProperty("业务类型 case 诉讼；checkFile 查档")
    private String positionType;
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("状态")
    private BilingCaseSituationStatus status;
    @ApiModelProperty("结果说明")
    private String remark;

    public String getBillingCheckId() {
        return billingCheckId;
    }

    public void setBillingCheckId(String billingCheckId) {
        this.billingCheckId = billingCheckId;
    }

    public String getPositionType() {
        return positionType;
    }

    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BilingCaseSituationStatus getStatus() {
        return status;
    }

    public void setStatus(BilingCaseSituationStatus status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
