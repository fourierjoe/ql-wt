package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;
import yhao.micro.service.surety.business.apilist.model.complex.MaterialLendModel;

import java.util.List;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/8 18:13
 * @Description:
 */
public class MeterialSecondmentForm implements ValidationForm {
    @ApiModelProperty("借出记录")
    private List<MaterialLendModel> lendModelList;

    public List<MaterialLendModel> getLendModelList() {
        return lendModelList;
    }

    public void setLendModelList(List<MaterialLendModel> lendModelList) {
        this.lendModelList = lendModelList;
    }
}
