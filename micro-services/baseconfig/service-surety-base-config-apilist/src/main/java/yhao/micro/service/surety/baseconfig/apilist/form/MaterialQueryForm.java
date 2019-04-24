package yhao.micro.service.surety.baseconfig.apilist.form;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.PageForm;
import yhao.infra.common.CommonStatusEnum;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:资料设置查询 Form
 * User: GUO.MAO.LIN
 * Date: 2018-12-04
 * Time: 9:31
 */
public class MaterialQueryForm extends PageForm {
    @ApiModelProperty(value = "资料名称，模糊查询", example = "资料名称")
    private String name;
    @ApiModelProperty(value = "状态，ENABLED=启用，DISABLED=禁用", example = "ENABLED")
    private CommonStatusEnum status;
    @ApiModelProperty(value = "资料id", example = "string")
    private String id;
    @ApiModelProperty(value = "资料id串,用逗号分隔", example = "string")
    private String ids;
    @ApiModelProperty(value = "资料id列表", example = "string",hidden = true)
    private List<String> idList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public List<String> getIdList() {
        return idList;
    }

    public void setIdList(List<String> idList) {
        this.idList = idList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CommonStatusEnum getStatus() {
        return status;
    }

    public void setStatus(CommonStatusEnum status) {
        this.status = status;
    }
}
