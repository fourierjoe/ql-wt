package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Description
 * @Author leice
 * @Date 2019/1/8 19:27
 * @Version 1.0
 */
public class OverdueToExtensionListForm {

    @ApiModelProperty(value = "逾期转展期申请集合",required = true)
    private List<OverdueToExtensionForm> OverdueToExtensionForms;

    @ApiModelProperty("修改费用减免时必填,新增费用减免时不用次参数")
    private RefuseWarrantyReviewForm refuseWarrantyReviewForm;

    public RefuseWarrantyReviewForm getRefuseWarrantyReviewForm() {
        return refuseWarrantyReviewForm;
    }

    public void setRefuseWarrantyReviewForm(RefuseWarrantyReviewForm refuseWarrantyReviewForm) {
        this.refuseWarrantyReviewForm = refuseWarrantyReviewForm;
    }

    public List<OverdueToExtensionForm> getOverdueToExtensionForms() {
        return OverdueToExtensionForms;
    }

    public void setOverdueToExtensionForms(List<OverdueToExtensionForm> overdueToExtensionForms) {
        OverdueToExtensionForms = overdueToExtensionForms;
    }
}
