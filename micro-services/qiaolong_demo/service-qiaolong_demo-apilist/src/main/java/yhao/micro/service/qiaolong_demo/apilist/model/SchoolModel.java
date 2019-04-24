package yhao.micro.service.qiaolong_demo.apilist.model;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

public class SchoolModel extends Entity {

    @ApiModelProperty("学校类型")
    private String ftype;
    @ApiModelProperty("学校名称")
    private String fname;

    @ApiModelProperty("学校属性")
    private String fproperty;

    @ApiModelProperty("学校城市id")
    private String fkcityid;

    public String getFtype() {
        return ftype;
    }

    public void setFtype(String ftype) {
        this.ftype = ftype;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFproperty() {
        return fproperty;
    }

    public void setFproperty(String fproperty) {
        this.fproperty = fproperty;
    }

    public String getFkcityid() {
        return fkcityid;
    }

    public void setFkcityid(String fkcityid) {
        this.fkcityid = fkcityid;
    }
}
