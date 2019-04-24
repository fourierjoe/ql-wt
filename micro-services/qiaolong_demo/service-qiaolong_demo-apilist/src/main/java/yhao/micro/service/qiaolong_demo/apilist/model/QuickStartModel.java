package yhao.micro.service.qiaolong_demo.apilist.model;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

public class QuickStartModel extends Entity<String> {
    @ApiModelProperty("显示的名字")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
