package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;
import yhao.infra.apilist.validate.IdForm;

import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/7 18:53
 * @Description:
 */
public class EssentialsRemandApplySaveForm implements ValidationForm {
    @ApiModelProperty("担保单id")
    private String guaranteePid;
    @ApiModelProperty("归还日期")
    private Date remandDate;
    @ApiModelProperty("签收人")
    private String signOperatorId;
    @ApiModelProperty("归还内容")
    private String remandContent;
    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty(value = "创建者id",hidden = true)
    private String createrId;

    public String getGuaranteePid() {
        return guaranteePid;
    }

    public void setGuaranteePid(String guaranteePid) {
        this.guaranteePid = guaranteePid;
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

    public String getCreaterId() {
        return createrId;
    }

    public void setCreaterId(String createrId) {
        this.createrId = createrId;
    }
}
