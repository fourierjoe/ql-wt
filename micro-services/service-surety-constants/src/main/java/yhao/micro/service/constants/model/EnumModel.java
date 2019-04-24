package yhao.micro.service.constants.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2018-12-05
 * Time: 17:58
 */
public class EnumModel {
    @ApiModelProperty(value = "中文描述")
    private String name;
    @ApiModelProperty(value = "枚举值")
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
