package yhao.micro.service.surety.erp.auth.apilist.form.auth;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;
import yhao.infra.apilist.ValidationForm;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2018-12-14
 * Time: 9:37
 */
public class PositionChangeForm implements ValidationForm {
    @ApiModelProperty(value = "挂职岗位ID",example = "string")
    @NotEmpty(message = "挂职岗位ID不能为空")
    private String positionLinkId;

    public String getPositionLinkId() {
        return positionLinkId;
    }

    public void setPositionLinkId(String positionLinkId) {
        this.positionLinkId = positionLinkId;
    }
}
