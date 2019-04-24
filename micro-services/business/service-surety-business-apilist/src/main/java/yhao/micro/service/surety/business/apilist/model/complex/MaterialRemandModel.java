package yhao.micro.service.surety.business.apilist.model.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.surety.business.apilist.model.enums.complex.MaterialType;

import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/7 16:58
 * @Description:
 */
public class MaterialRemandModel extends Entity<String> {
    @ApiModelProperty("担保单id")
    private String guaranteePid;
    @ApiModelProperty("业务类型")
    private MaterialType materialType;
    @ApiModelProperty("归还日期")
    private Date remandDate;
    @ApiModelProperty("签收人")
    private String signOperatorId;
    @ApiModelProperty("归还内容")
    private String remandContent;
    @ApiModelProperty("备注")
    private String remark;

    public String getGuaranteePid() {
        return guaranteePid;
    }

    public void setGuaranteePid(String guaranteePid) {
        this.guaranteePid = guaranteePid;
    }

    public MaterialType getMaterialType() {
        return materialType;
    }

    public void setMaterialType(MaterialType materialType) {
        this.materialType = materialType;
    }

    public Date getRemandDate() {
        return remandDate;
    }

    public void setRemandDate(Date remandDate) {
        this.remandDate = remandDate;
    }

    public String getSignOperatorId() {
        return signOperatorId;
    }

    public void setSignOperatorId(String signOperatorId) {
        this.signOperatorId = signOperatorId;
    }

    public String getRemandContent() {
        return remandContent;
    }

    public void setRemandContent(String remandContent) {
        this.remandContent = remandContent;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
