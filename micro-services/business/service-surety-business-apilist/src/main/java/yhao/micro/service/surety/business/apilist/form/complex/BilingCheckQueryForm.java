package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/10 10:27
 * @Description:
 */
public class BilingCheckQueryForm extends ComplexRedemptionBaseQueryForm {
    @ApiModelProperty("银行到账状态,ARRIVAL=到账,ONE_ARRIVAL 已一次到账 ")
    private String fundStatus;

    public String getFundStatus() {
        return fundStatus;
    }

    public void setFundStatus(String fundStatus) {
        this.fundStatus = fundStatus;
    }
}
