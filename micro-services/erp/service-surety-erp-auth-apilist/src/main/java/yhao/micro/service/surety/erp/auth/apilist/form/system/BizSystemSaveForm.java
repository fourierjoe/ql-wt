package yhao.micro.service.surety.erp.auth.apilist.form.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 业务系统配置Model类
 * Created by null on 2017-09-05
 */
@ApiModel
public class BizSystemSaveForm{
    private String id;
    // 系统标识
    @ApiModelProperty(value = "系统标识")
    private String systemKey;
    // 系统名
    @ApiModelProperty(value = "系统名")
    private String systemName;
    // 数据类型
    @ApiModelProperty(value = "数据类型")
    private String[] dataType;
    // 数据类型描述
    @ApiModelProperty(value = "数据类型描述")
    private String[] dataTypeDesc;

    public void setSystemKey(String systemKey){
        this.systemKey = systemKey;
    }

    public String getSystemKey(){
        return systemKey;
    }

    public void setSystemName(String systemName){
        this.systemName = systemName;
    }

    public String getSystemName(){
        return systemName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getDataType() {
        return dataType;
    }

    public void setDataType(String[] dataType) {
        this.dataType = dataType;
    }

    public String[] getDataTypeDesc() {
        return dataTypeDesc;
    }

    public void setDataTypeDesc(String[] dataTypeDesc) {
        this.dataTypeDesc = dataTypeDesc;
    }
}
