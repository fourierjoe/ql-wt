package yhao.micro.service.surety.business.apilist.form.finance;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import yhao.infra.apilist.ValidationForm;
import yhao.micro.service.surety.business.apilist.model.enums.finance.PlanStatusEnum;

import javax.validation.constraints.Max;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/11 19:55
 * @Description:
 */
public class FinanceFundPlanForm implements ValidationForm {
    @ApiModelProperty(value = "担保单id",required = true)
    private String guaranteeId;
    @ApiModelProperty(value = "用款计划id",required = true)
    private String id;
    @ApiModelProperty("进度")
    private PlanStatusEnum planStatus;
    @ApiModelProperty("产品类型")
    @Length(min=0,max = 50,message = "产品类型必须在50个字符内")
    private String productType;
    @ApiModelProperty(value = "创建人id",hidden = true)
    private String operatorId;

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PlanStatusEnum getPlanStatus() {
        return planStatus;
    }

    public void setPlanStatus(PlanStatusEnum planStatus) {
        this.planStatus = planStatus;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }
}
