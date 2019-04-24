package yhao.micro.service.surety.baseconfig.apilist.model;

import io.swagger.annotations.ApiModelProperty;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import yhao.infra.common.CommonStatusEnum;
import yhao.infra.common.model.Entity;
import yhao.micro.service.surety.baseconfig.apilist.form.MaterialSaveForm;

/**
 * Created with IntelliJ IDEA.
 * Description:资料设置 Model
 * User: GUO.MAO.LIN
 * Date: 2018-12-04
 * Time: 9:34
 */
public class MaterialModel extends Entity<String> {
    private Mapper mapper = new DozerBeanMapper();

    @ApiModelProperty(value = "资料名称", example = "资料名称")
    private String name;
    @ApiModelProperty(value = "状态，ENABLED=启用，DISABLED=禁用", example = "ENABLED")
    private CommonStatusEnum status;

    /*以下是非数据库字段，是关联表的冗余字段，查询时可关联带出值*/
    @ApiModelProperty(value = "状态中文描述", example = "启用")
    public String getStatusDesc(){
        if(status==null){
            return "";
        }
        if(status==CommonStatusEnum.ENABLED){
            return "启用";
        }
        if(status==CommonStatusEnum.DISABLED){
            return "禁用";
        }
        return "";
    }

    public MaterialSaveForm toSaveForm() {
        return mapper.map(this, MaterialSaveForm.class);
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
