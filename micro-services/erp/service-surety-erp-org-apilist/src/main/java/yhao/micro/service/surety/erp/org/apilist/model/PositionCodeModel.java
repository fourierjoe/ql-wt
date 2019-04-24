package yhao.micro.service.surety.erp.org.apilist.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2018-12-29
 * Time: 11:23
 */
public class PositionCodeModel {
    @ApiModelProperty(value = "岗位类型，FOLLOWER=跟单员，DECLARER=报单员，CREDIT_CLERK=征信专员，MANAGER=客户经理，OBTAINER=取证专员，FORECLOSER=赎楼员，RESIDENT=驻点专员，EXAMINER=审查员")
    private String positionType;
    @ApiModelProperty(value = "岗位编码")
    private String positionCode;

    public String getPositionType() {
        return positionType;
    }

    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }
}
