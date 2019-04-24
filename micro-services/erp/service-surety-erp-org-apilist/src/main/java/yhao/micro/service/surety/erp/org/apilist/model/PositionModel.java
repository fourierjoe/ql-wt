package yhao.micro.service.surety.erp.org.apilist.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

/**
 * Created by yoara on 2017/8/23.
 */
@ApiModel
public class PositionModel extends Entity<String> {
    @ApiModelProperty(value = "从属组织id")
    // 从属组织id
    private String orgId;
    @ApiModelProperty(value = "岗位名称")
    // 岗位名称
    private String name;
    @ApiModelProperty(value = "岗位编码")
    // 岗位编码
    private String number;

    public void setOrgId(String orgId){
        this.orgId = orgId;
    }

    public String getOrgId(){
        return orgId;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setNumber(String number){
        this.number = number;
    }

    public String getNumber(){
        return number;
    }
}
