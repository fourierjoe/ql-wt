package yhao.micro.service.surety.business.apilist.model;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

/**
 * @Description
 * @Author leice
 * @Date 2018/12/18 19:28
 * @Version 1.0
 */
public class ReveiceNameModel extends Entity<String> {

    @ApiModelProperty("当前处理人")
    private String reveiceName;

    public String getReveiceName() {
        return reveiceName;
    }

    public void setReveiceName(String reveiceName) {
        this.reveiceName = reveiceName;
    }
}
