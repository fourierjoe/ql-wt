package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;
import yhao.micro.service.surety.business.apilist.model.enums.complex.MaterialType;

import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/19 20:05
 * @Description:
 */
public class EssentialsLendApplySaveForm implements ValidationForm {
    @ApiModelProperty(value = "担保单id",required = true)
    private String guaranteePid;
    @ApiModelProperty(value = "业务类型",required = true)
    private MaterialType materialType;
    @ApiModelProperty("借出日期")
    private Date lendDate;
    @ApiModelProperty("归还日期")
    private Date remandDate;
    @ApiModelProperty("借出人")
    private String lendOperatorId;
    @ApiModelProperty("借出内容")
    private String lendContent;

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
}
