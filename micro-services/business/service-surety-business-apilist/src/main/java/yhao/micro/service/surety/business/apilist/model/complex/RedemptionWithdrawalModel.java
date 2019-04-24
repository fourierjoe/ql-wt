package yhao.micro.service.surety.business.apilist.model.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.constants.enums.YNEnum;
import yhao.micro.service.surety.business.apilist.model.enums.complex.RedemptionVerifyType;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/8 16:32
 * @Description:
 */
public class RedemptionWithdrawalModel extends Entity<String> {
    @ApiModelProperty("担保单id")
    private String guaranteePid;
    @ApiModelProperty("核实类型")
    private RedemptionVerifyType verifyType;
    @ApiModelProperty("状态")
    private String status;
    @ApiModelProperty("是否相符")
    private YNEnum isMatchCommission;
    @ApiModelProperty("备注")
    private String remark;

    public String getGuaranteePid() {
        return guaranteePid;
    }

    public void setGuaranteePid(String guaranteePid) {
        this.guaranteePid = guaranteePid;
    }

    public RedemptionVerifyType getVerifyType() {
        return verifyType;
    }

    public void setVerifyType(RedemptionVerifyType verifyType) {
        this.verifyType = verifyType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public YNEnum getIsMatchCommission() {
        return isMatchCommission;
    }

    public void setIsMatchCommission(YNEnum isMatchCommission) {
        this.isMatchCommission = isMatchCommission;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
