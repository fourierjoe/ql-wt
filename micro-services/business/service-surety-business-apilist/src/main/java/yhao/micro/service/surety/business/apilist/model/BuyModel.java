package yhao.micro.service.surety.business.apilist.model;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

/**
 * @Description
 * @Author leice
 * @Date 2018/12/20 19:51
 * @Version 1.0
 */
public class BuyModel extends Entity<String> {

    @ApiModelProperty("买家")
    private String buyer;

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }
}
