package yhao.micro.service.surety.business.apilist.model.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/8 15:45
 * @Description:
 */
public class MaterialPictureModel extends Entity<String> {
    @ApiModelProperty("业务表id")
    private String positionId;
    @ApiModelProperty("业务类型")
    private String postitionType;
    @ApiModelProperty("url地址")
    private String url;
    @ApiModelProperty("图片名称")
    private String name;

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public String getPostitionType() {
        return postitionType;
    }

    public void setPostitionType(String postitionType) {
        this.postitionType = postitionType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
