package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;

import java.util.List;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/24 11:16
 * @Description:
 */
public class EstateOfSellerQueryForm implements ValidationForm {
    @ApiModelProperty("业主物业信息")
    private List<EstateOfSellerBizForm>estateOfSellerList;
    @ApiModelProperty(value = "反担保人信息")
    private List<AntiGuaranteeQueryForm>antiGuarantorList;

    public List<EstateOfSellerBizForm> getEstateOfSellerList() {
        return estateOfSellerList;
    }

    public void setEstateOfSellerList(List<EstateOfSellerBizForm> estateOfSellerList) {
        this.estateOfSellerList = estateOfSellerList;
    }

    public List<AntiGuaranteeQueryForm> getAntiGuarantorList() {
        return antiGuarantorList;
    }

    public void setAntiGuarantorList(List<AntiGuaranteeQueryForm> antiGuarantorList) {
        this.antiGuarantorList = antiGuarantorList;
    }
}
