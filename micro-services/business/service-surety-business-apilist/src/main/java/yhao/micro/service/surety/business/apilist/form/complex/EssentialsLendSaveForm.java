package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;

import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/7 15:53
 * @Description:
 */
public class EssentialsLendSaveForm implements ValidationForm {
    @ApiModelProperty(value = "要件借出主键id",required = true)
    private String id;
    @ApiModelProperty(value = "备注",required = true)
    private String remark;
    @ApiModelProperty(value = "请求类型 LEND 借出 REMAND 归还 ",required = true)
    private String positionType;
    @ApiModelProperty(hidden = true)
    private Date createTime;
    @ApiModelProperty(hidden = true)
    private String createOperatorId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateOperatorId() {
        return createOperatorId;
    }

    public void setCreateOperatorId(String createOperatorId) {
        this.createOperatorId = createOperatorId;
    }

    public String getPositionType() {
        return positionType;
    }

    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }
}
