package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;

import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/28 11:43
 * @Description:
 */
public class SecondmentDetailResultForm implements ValidationForm {
    @ApiModelProperty(value = "担保单id")
    private String guaranteeId;
    @ApiModelProperty("借出日期")
    private Date lendDate;
    @ApiModelProperty("归还日期")
    private Date remandDate;
    @ApiModelProperty("借出人")
    private String name;
    @ApiModelProperty("状态")
    private String status;

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
