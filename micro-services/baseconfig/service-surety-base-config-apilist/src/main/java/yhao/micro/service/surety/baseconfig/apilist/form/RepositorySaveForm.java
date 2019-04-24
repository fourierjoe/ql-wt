package yhao.micro.service.surety.baseconfig.apilist.form;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.IdUnForm;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2019-01-14
 * Time: 9:38
 */
public class RepositorySaveForm extends IdUnForm {
    @ApiModelProperty(value = "仓库名称", example = "string")
    private String name;
    @ApiModelProperty(value = "仓库地址", example = "string")
    private String address;
    @ApiModelProperty(value = "顺序", example = "string")
    private Integer order;
    @ApiModelProperty(value = "备注", example = "string")
    private String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
