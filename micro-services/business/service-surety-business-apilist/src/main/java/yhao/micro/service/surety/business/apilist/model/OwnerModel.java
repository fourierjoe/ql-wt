package yhao.micro.service.surety.business.apilist.model;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

import java.util.List;

/**
 * @Description
 * @Author leice
 * @Date 2018/12/20 17:00
 * @Version 1.0
 */
public class OwnerModel extends Entity<String> {

    @ApiModelProperty("业主")
    private String owner;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
