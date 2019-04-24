package yhao.micro.service.workflow.apilist.model.flow;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.common.model.Entity;

/**
 * @Description:
 * @Created by ql on 2018/12/13 10:50
 * @Version: v1.0
 */
public class SubProcessNameModel extends Entity<String> {

    @ApiModelProperty(value = "子流程名称")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
