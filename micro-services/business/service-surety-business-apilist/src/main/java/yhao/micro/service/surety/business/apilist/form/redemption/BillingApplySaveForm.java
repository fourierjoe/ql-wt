package yhao.micro.service.surety.business.apilist.form.redemption;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
import yhao.infra.apilist.ValidationForm;
import yhao.micro.service.surety.business.apilist.model.enums.redeem.ReceiptPersonTypeEnum;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2019/1/2 18:26
 * @Description:
 */
public class BillingApplySaveForm implements ValidationForm {
    @ApiModelProperty(value = "担保单id", required = true)
    private String guaranteeId;
    @ApiModelProperty(value = "收款人类型", required = true)
    private ReceiptPersonTypeEnum personType;
    @ApiModelProperty(value = "收款人账户", required = true)
    private String receiptAccountId;
    @ApiModelProperty(value = "收款人开户行", required = true)
    private String receiptAccountBank;
    @ApiModelProperty(value = "收款人账号", required = true)
    private String receiptAccountNum;
    @ApiModelProperty(value = "赎楼日期", required = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date redeemDate;
    @ApiModelProperty(value = "申请金额", required = true)
    private BigDecimal applyAmount;
    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty(value = "创建者",hidden = true)
    private String createrId;

    public String getCreaterId() {
        return createrId;
    }

    public void setCreaterId(String createrId) {
        this.createrId = createrId;
    }

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public ReceiptPersonTypeEnum getPersonType() {
        return personType;
    }

    public void setPersonType(ReceiptPersonTypeEnum personType) {
        this.personType = personType;
    }

    public String getReceiptAccountId() {
        return receiptAccountId;
    }

    public void setReceiptAccountId(String receiptAccountId) {
        this.receiptAccountId = receiptAccountId;
    }

    public String getReceiptAccountBank() {
        return receiptAccountBank;
    }

    public void setReceiptAccountBank(String receiptAccountBank) {
        this.receiptAccountBank = receiptAccountBank;
    }

    public String getReceiptAccountNum() {
        return receiptAccountNum;
    }

    public void setReceiptAccountNum(String receiptAccountNum) {
        this.receiptAccountNum = receiptAccountNum;
    }

    public Date getRedeemDate() {
        return redeemDate;
    }

    public void setRedeemDate(Date redeemDate) {
        this.redeemDate = redeemDate;
    }

    public BigDecimal getApplyAmount() {
        return applyAmount;
    }

    public void setApplyAmount(BigDecimal applyAmount) {
        this.applyAmount = applyAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
