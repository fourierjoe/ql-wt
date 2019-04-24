package yhao.micro.service.surety.baseconfig.apilist.form;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.PageForm;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2019-01-14
 * Time: 9:38
 */
public class RepositoryQueryForm extends PageForm {
    @ApiModelProperty(value = "仓库id", example = "string",hidden = true)
    private String id;
    @ApiModelProperty(value = "仓库名称，模糊查询", example = "string")
    private String name;
    @ApiModelProperty(value = "仓库地址，模糊查询", example = "string")
    private String address;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
