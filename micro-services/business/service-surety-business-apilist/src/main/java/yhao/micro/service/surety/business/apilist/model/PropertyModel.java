package yhao.micro.service.surety.business.apilist.model;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

/**
 * @Description
 * @Author leice
 * @Date 2018/12/20 19:58
 * @Version 1.0
 */
public class PropertyModel extends Entity<String> {

    @ApiModelProperty("物业名称")
    private String propertyName;

    @ApiModelProperty("房产名称")
    private String roomName;

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }
}
