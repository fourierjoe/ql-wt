package yhao.micro.service.surety.business.apilist.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Description
 * @Author leice
 * @Date 2019/3/8 11:36
 * @Version 1.0
 */
public class OverDueModel {

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("担保单id")
    private String warrantyId;

    @ApiModelProperty("借款id")
    private String loanId;

    @ApiModelProperty("回款id")
    private String paybackId;

    @ApiModelProperty("逾期费率")
    private Double overDueRate;

    @ApiModelProperty("状态：1：正常 2：撤销")
    private Integer state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWarrantyId() {
        return warrantyId;
    }

    public void setWarrantyId(String warrantyId) {
        this.warrantyId = warrantyId;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public String getPaybackId() {
        return paybackId;
    }

    public void setPaybackId(String paybackId) {
        this.paybackId = paybackId;
    }

    public Double getOverDueRate() {
        return overDueRate;
    }

    public void setOverDueRate(Double overDueRate) {
        this.overDueRate = overDueRate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
