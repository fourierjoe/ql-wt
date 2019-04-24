package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Description
 * @Author leice
 * @Date 2019/1/9 11:13
 * @Version 1.0
 */
public class OverdueToExtCancelForm {

    @ApiModelProperty("担保单id")
    @NotNull
    private String guaranteeId;

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }
}
