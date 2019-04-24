package yhao.micro.service.surety.business.apilist.model.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.constants.enums.YNEnum;

import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/5 17:36
 * @Description:
 */
public class BillingCheckModel extends Entity<String> {
    @ApiModelProperty("担保单id")
    private String guaranteePid;
    @ApiModelProperty("查档时间")
    private Date checkFileDate;
    @ApiModelProperty("审查结果")
    private YNEnum approvalResult;
    @ApiModelProperty("审查结果说明")
    private String remark;


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
}
