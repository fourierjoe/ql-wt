package yhao.micro.service.surety.erp.auth.apilist.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;
import yhao.infra.common.model.Entity;

/**
 * 业务系统配置Model类
 * Created by null on 2017-09-05
 */
@ApiModel
public class BizSystemModel extends Entity<String> {
    // 系统标识
    @ApiModelProperty(value = "系统标识")
    private String systemKey;
    // 系统名
    @ApiModelProperty(value = "系统名")
    private String systemName;
    // 数据类型，多个用,分割
    @ApiModelProperty(value = "数据类型，多个用,分割")
    private String dataType;

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

    public void setDataType(String dataType){
        this.dataType = dataType;
    }

    public String getDataType(){
        return dataType;
    }

    public String getDataTypeDesc(){
        if(StringUtils.isNotEmpty(dataType)){
            StringBuffer result = new StringBuffer();
            String[] types = dataType.split(",");
            for(String type:types){
                String[] info = type.split("=");
                result.append(info[1]).append("(").append(info[0]).append(")").append(" ");
            }
            return result.toString();
        }
        return dataType;
    }
}
