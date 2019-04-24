package yhao.micro.service.surety.business.apilist.model.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.surety.business.apilist.model.enums.complex.MaterialType;

import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/7 16:07
 * @Description:
 */
public class MaterialLendModel extends Entity<String> {
    @ApiModelProperty("担保单id")
    private String guaranteePid;
    @ApiModelProperty("业务类型")
    private MaterialType materialType;
    @ApiModelProperty("借出日期")
    private Date lendDate;
    @ApiModelProperty("归还日期")
    private Date remandDate;
    @ApiModelProperty("借出人")
    private String lendOperatorId;
    @ApiModelProperty("借出内容")
    private String lendContent;
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

    public Date getLendDate() {
        return lendDate;
    }

    public void setLendDate(Date lendDate) {
        this.lendDate = lendDate;
    }

    public Date getRemandDate() {
        return remandDate;
    }

    public void setRemandDate(Date remandDate) {
        this.remandDate = remandDate;
    }

    public String getLendOperatorId() {
        return lendOperatorId;
    }

    public void setLendOperatorId(String lendOperatorId) {
        this.lendOperatorId = lendOperatorId;
    }

    public String getLendContent() {
        return lendContent;
    }

    public void setLendContent(String lendContent) {
        this.lendContent = lendContent;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
