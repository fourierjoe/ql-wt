package yhao.micro.service.surety.business.apilist.model.guarantee.page;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

/**
 * @Description:
 * @Created by ql on 2018/12/10 14:37
 * @Version: v1.0
 */
public class ApplicationPersonModel extends Entity<String> {

    @ApiModelProperty(value = "用户类型", example = "BUYER/SELLER")
    private String cltTyp;

    @ApiModelProperty("用户姓名")
    private String cltName;

    public String getCltTyp() {
        return cltTyp;
    }

    public void setCltTyp(String cltTyp) {
        this.cltTyp = cltTyp;
    }

    public String getCltName() {
        return cltName;
    }

    public void setCltName(String cltName) {
        this.cltName = cltName;
    }

}
