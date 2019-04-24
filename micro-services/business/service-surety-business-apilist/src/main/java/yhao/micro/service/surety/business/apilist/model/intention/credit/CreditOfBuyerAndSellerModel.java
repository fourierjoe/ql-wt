package yhao.micro.service.surety.business.apilist.model.intention.credit;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.surety.business.apilist.model.enums.guarantee.CreditTypeEnum;

import java.util.Date;

/**
 * @Description:
 * @Created by ql on 2018/12/10 16:01
 * @Version: v1.0
 */
public class CreditOfBuyerAndSellerModel extends Entity<String> {

    @ApiModelProperty(value = "用户类型", example = "BUYER/SELLER")
    private String cltTyp;

    @ApiModelProperty("姓名")
    private String cltName;

    @ApiModelProperty("电话")
    private String contactTele;

    @ApiModelProperty("征信查询类型")
    private CreditTypeEnum creditType;

    @ApiModelProperty("征信预计查询时间")
    private Date creditExpectedDate;

    @ApiModelProperty("征信安排查询时间")
    private Date creditArrangeDate;

    public CreditTypeEnum getCreditType() {
        return creditType;
    }

    public void setCreditType(CreditTypeEnum creditType) {
        this.creditType = creditType;
    }

    public Date getCreditExpectedDate() {
        return creditExpectedDate;
    }

    public void setCreditExpectedDate(Date creditExpectedDate) {
        this.creditExpectedDate = creditExpectedDate;
    }

    public Date getCreditArrangeDate() {
        return creditArrangeDate;
    }

    public void setCreditArrangeDate(Date creditArrangeDate) {
        this.creditArrangeDate = creditArrangeDate;
    }

    public String getCltTyp() {
        return cltTyp;
    }

    public void setCltTyp(String cltTyp) {
        this.cltTyp = cltTyp;
    }

    public String getCltName() {
        return cltName;
    }

    public void setCltName(String cltName) {
        this.cltName = cltName;
    }

    public String getContactTele() {
        return contactTele;
    }

    public void setContactTele(String contactTele) {
        this.contactTele = contactTele;
    }
}
