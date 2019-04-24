package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;
import yhao.micro.service.surety.business.apilist.model.enums.complex.MaterialType;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/28 11:32
 * @Description:
 */
public class SecondmentDetailQueryForm implements ValidationForm {
    @ApiModelProperty(value = "担保单id",required = true)
    private String guaranteeId;
    @ApiModelProperty(value = "业务类型 ESSENTIALS 要件,MATERIAL 材料",required = true)
    private MaterialType materialType;
    @ApiModelProperty(value = "请求人id",hidden = true)
    private String createId;

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public MaterialType getMaterialType() {
        return materialType;
    }

    public void setMaterialType(MaterialType materialType) {
        this.materialType = materialType;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }
}
