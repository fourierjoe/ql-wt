package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.micro.service.constants.enums.YNEnum;
import yhao.micro.service.surety.business.apilist.model.complex.BillingCaseSituationModel;
import yhao.micro.service.surety.business.apilist.model.complex.MaterialPictureModel;

import java.util.Date;
import java.util.List;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/8 15:43
 * @Description:
 */
public class BilingCheckDetailForm {
    @ApiModelProperty("担保单id")
    private String guaranteePid;
    @ApiModelProperty("查档时间")
    private Date checkFileDate;
    @ApiModelProperty("审查结果")
    private YNEnum approvalResult;
    @ApiModelProperty("审查结果说明")
    private String remark;
    @ApiModelProperty(value = "查档状态",required = true)
    private List<BillingCaseSituationModel> caseSituationModelList;
    @ApiModelProperty(value = "附件集合",required = true)
    private List<MaterialPictureModel> pictures;

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

    public List<BillingCaseSituationModel> getCaseSituationModelList() {
        return caseSituationModelList;
    }

    public void setCaseSituationModelList(List<BillingCaseSituationModel> caseSituationModelList) {
        this.caseSituationModelList = caseSituationModelList;
    }

    public List<MaterialPictureModel> getPictures() {
        return pictures;
    }

    public void setPictures(List<MaterialPictureModel> pictures) {
        this.pictures = pictures;
    }
}
