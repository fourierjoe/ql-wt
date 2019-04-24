package yhao.micro.service.surety.business.apilist.model.finance;


import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.surety.business.apilist.model.enums.finance.PositionTypeEnum;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/11 20:20
 * @Description:
 */
public class FundPlanRecordModel extends Entity<String> {
    @ApiModelProperty("资金计划id")
    private String fundPlanId;
    @ApiModelProperty("操作类型")
    private PositionTypeEnum positionType;
    @ApiModelProperty("操作内容")
    private  String positionContent;

    public String getFundPlanId() {
        return fundPlanId;
    }

    public void setFundPlanId(String fundPlanId) {
        this.fundPlanId = fundPlanId;
    }

    public PositionTypeEnum getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionTypeEnum positionType) {
        this.positionType = positionType;
    }

    public String getPositionContent() {
        return positionContent;
    }

    public void setPositionContent(String positionContent) {
        this.positionContent = positionContent;
    }
}
