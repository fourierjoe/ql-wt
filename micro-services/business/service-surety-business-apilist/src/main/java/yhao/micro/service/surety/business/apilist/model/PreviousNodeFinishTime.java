package yhao.micro.service.surety.business.apilist.model;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

/**
 * @Description
 * @Author leice
 * @Date 2018/12/26 11:36
 * @Version 1.0
 */
public class PreviousNodeFinishTime extends Entity<String> {

    @ApiModelProperty("上一节点完成时间")
    private String previousNodeFinishTime;

    public String getPreviousNodeFinishTime() {
        return previousNodeFinishTime;
    }

    public void setPreviousNodeFinishTime(String previousNodeFinishTime) {
        this.previousNodeFinishTime = previousNodeFinishTime;
    }
}
