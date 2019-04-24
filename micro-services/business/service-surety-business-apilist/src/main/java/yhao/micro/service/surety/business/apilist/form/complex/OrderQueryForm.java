package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/10 10:31
 * @Description:
 */
public class OrderQueryForm extends ComplexRedemptionBaseQueryForm {
    @ApiModelProperty("指令状态 YES 已发送 NO 未发送")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
