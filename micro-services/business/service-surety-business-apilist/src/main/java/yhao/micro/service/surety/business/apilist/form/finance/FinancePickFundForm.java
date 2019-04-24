package yhao.micro.service.surety.business.apilist.form.finance;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;
import yhao.micro.service.surety.business.apilist.model.enums.finance.FundTypeEnum;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/11 19:48
 * @Description:
 */
public class FinancePickFundForm implements ValidationForm {

    @ApiModelProperty(value = "用款计划id")
    private String id;
    @ApiModelProperty(value = "担保单id",required = true)
    private String guaranteeId;
    @ApiModelProperty(value = "资金方",required = true)
    private FundTypeEnum fundType;
    @ApiModelProperty(value = "平台id 选择平台资金时，必填")
    private String platformId;
    @ApiModelProperty(value = "平台id 选择平台资金时，必填")
    private String platformName;
    @ApiModelProperty(value = "创建人id",hidden = true)
    private String createOperatorId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getCreateOperatorId() {
        return createOperatorId;
    }

    public void setCreateOperatorId(String createOperatorId) {
        this.createOperatorId = createOperatorId;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }
}
