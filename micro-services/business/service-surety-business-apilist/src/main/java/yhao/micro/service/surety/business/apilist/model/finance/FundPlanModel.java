package yhao.micro.service.surety.business.apilist.model.finance;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.constants.enums.YNEnum;
import yhao.micro.service.surety.business.apilist.model.enums.finance.FundTypeEnum;
import yhao.micro.service.surety.business.apilist.model.enums.finance.PlanStatusEnum;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/11 20:29
 * @Description:
 */
public class FundPlanModel extends Entity<String> {
    @ApiModelProperty("担保单id")
    private String guaranteeId;
    @ApiModelProperty("资金类型")
    private FundTypeEnum fundType;
    @ApiModelProperty("平台id")
    private String platformId;
    @ApiModelProperty("是否安排")
    private YNEnum isPlan;
    @ApiModelProperty("更新进度")
    private PlanStatusEnum planStatus;
    @ApiModelProperty("产品类型")
    private String productType;

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public FundTypeEnum getFundType() {
        return fundType;
    }

    public void setFundType(FundTypeEnum fundType) {
        this.fundType = fundType;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public YNEnum getIsPlan() {
        return isPlan;
    }

    public void setIsPlan(YNEnum isPlan) {
        this.isPlan = isPlan;
    }

    public PlanStatusEnum getPlanStatus() {
        return planStatus;
    }

    public void setPlanStatus(PlanStatusEnum planStatus) {

        this.planStatus = planStatus;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}
