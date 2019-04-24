package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
import yhao.infra.apilist.ValidationForm;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/28 17:20
 * @Description:
 */
public class UnProtectedSaveForm implements ValidationForm {
    @NotNull(message = "担保单id不能为空")
    @ApiModelProperty(value = "担保单id",required = true)
    private String guaranteeId;
    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty("解保日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date unprotectedDate;
    @ApiModelProperty(value = "创建者id",hidden = true)
    private String createrId;

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
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

    public Date getUnprotectedDate() {
        return unprotectedDate;
    }

    public void setUnprotectedDate(Date unprotectedDate) {
        this.unprotectedDate = unprotectedDate;
    }
}
