package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/10 10:42
 * @Description:
 */
public class WithdrawalQueryForm extends  ComplexRedemptionBaseQueryForm {
    @ApiModelProperty("退余款状态 SEND 已提交;NO_SEND 未提交;REBACK 已退款")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
