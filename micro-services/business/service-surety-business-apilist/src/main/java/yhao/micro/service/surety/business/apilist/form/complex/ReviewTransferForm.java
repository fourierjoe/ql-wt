package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.validate.IdUnForm;

/**
 * @Description
 * @Author leice
 * @Date 2018/12/10 17:45
 * @Version 1.0
 */
public class ReviewTransferForm extends IdUnForm {

    @ApiModelProperty(value = "接收人id", required = true)
    private String receiveId;

    @ApiModelProperty(value = "担保单id", required = true)
    private String guaranteeId;

    @ApiModelProperty("接收时间")
    private String receiveTime;

    public String getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(String receiveTime) {
        this.receiveTime = receiveTime;
    }

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public String getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(String receiveId) {
        this.receiveId = receiveId;
    }
}
