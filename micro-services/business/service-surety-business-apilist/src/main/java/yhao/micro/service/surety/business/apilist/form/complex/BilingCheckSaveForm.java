package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
import yhao.infra.apilist.ValidationForm;
import yhao.micro.service.constants.enums.YNEnum;
import yhao.micro.service.surety.business.apilist.model.complex.BillingCaseSituationModel;

import java.util.Date;
import java.util.List;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/8 12:18
 * @Description:
 */
public class BilingCheckSaveForm implements ValidationForm {
    @ApiModelProperty(value = "担保单id",required = true)
    private String guaranteePid;
    @ApiModelProperty(value = "查档时间",required = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date checkFileDate;
    @ApiModelProperty(value = "查档状态",required = true)
    private List<BillingCaseSituationModel> caseSituationModelList;
    @ApiModelProperty(value = "审查结果",required = true)
    private YNEnum approvalResult;
    @ApiModelProperty(value = "审查结果说明",required = true)
    private String remark;
    @ApiModelProperty(value = "创建人id",hidden = true)
    private String createrId;

    public String getGuaranteePid() {
        return guaranteePid;
    }

    public void setGuaranteePid(String guaranteePid) {
        this.guaranteePid = guaranteePid;
    }

    public Date getCheckFileDate() {
        return checkFileDate;
    }

    public void setCheckFileDate(Date checkFileDate) {
        this.checkFileDate = checkFileDate;
    }

    public List<BillingCaseSituationModel> getCaseSituationModelList() {
        return caseSituationModelList;
    }

    public void setCaseSituationModelList(List<BillingCaseSituationModel> caseSituationModelList) {
        this.caseSituationModelList = caseSituationModelList;
    }

    public YNEnum getApprovalResult() {
        return approvalResult;
    }

    public void setApprovalResult(YNEnum approvalResult) {
        this.approvalResult = approvalResult;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreaterId() {
        return createrId;
    }

    public void setCreaterId(String createrId) {
        this.createrId = createrId;
    }
}
