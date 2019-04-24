package yhao.micro.service.surety.erp.org.apilist.form.org;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.IdForm;

/**
 * Created by yoara on 2018/7/31.
 */
public class OrgPropertyChangeForm extends IdForm {
    @ApiModelProperty(value = "设置城市公司状态")
    private int cityOrg = -1;

    public int getCityOrg() {
        return cityOrg;
    }

    public void setCityOrg(int cityOrg) {
        this.cityOrg = cityOrg;
    }
}
