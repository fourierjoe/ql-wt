package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.infra.apilist.validate.PageForm;

import javax.validation.constraints.NotNull;

/**
 * @Description 审查信息保存form
 *
 * @Author leice
 * @Date 2018/12/8 18:25
 * @Version 1.0
 */
public class ReviewInfoSaveForm extends IdUnForm {

    @ApiModelProperty(value = "担保单id", required = true)
    private String guaranteeId;

    @ApiModelProperty(value = "审查表id", required = true)
    private String reviewId;

    @ApiModelProperty(value = "按钮类型 1：保存 2：审核通过",required = true)
    private Integer type;


    @ApiModelProperty("原贷款情况")
    private String oldLoanSituation;

    @ApiModelProperty("征信情况")
    private String creditSituation;

    @ApiModelProperty("成交价核查 正常：normal 偏高：high 偏低：low")
    private String finalPriceInspect;

    @ApiModelProperty("赎楼比")
    private Double redemptionRatio;

    @ApiModelProperty("负债比")
    private Double debtRatio;

    @ApiModelProperty("民间查询")
    private String folkInquiry;

    @ApiModelProperty("诉讼")
    private String lawsuit;

    @ApiModelProperty("担保人情况")
    private String guarantorSituation;

    @ApiModelProperty("购房资格")
    private String purchaseQualification;

    @ApiModelProperty("回款来源")
    private String returnSource;

    @ApiModelProperty(value = "受理意见", required = true)
    private String acceptanceOfOpinions;

    @ApiModelProperty("物业价值认定 正常：normal 异常：unusual")
    private String propertyValueDetermination;

    @ApiModelProperty("出款比")
    private Double paymentRatio;

    @ApiModelProperty("额度复核批复")
    private String approvalReview;

    @ApiModelProperty("本单借款金额")
    private Double thisLoanAmount;

    @ApiModelProperty("本单借款天数")
    private Integer thisLoanDays;

    @ApiModelProperty("合并借款金额")
    private Double consolidatedLoanAmount;

    @ApiModelProperty("拍卖成交价")
    private Double auctionPrice;

    @ApiModelProperty("已付保证金")
    private Double paidDeposit;

    @ApiModelProperty("首期款")
    private Double firstInstallment;

    @ApiModelProperty("贷款金额")
    private Double loanAmount;

    @ApiModelProperty("贷款比例")
    private Double loanRatio;

    @ApiModelProperty("公证书开始")
    private String theCertificateBegins;

    @ApiModelProperty("公证书结束")
    private String theCertificateEnds;

    @ApiModelProperty(value = "审查业务类型 1:普通业务;2:特殊业务", required = true)
    private Integer reviewBusinessType;

    @ApiModelProperty(value = "保单业务类型  1:交易类额度赎楼/交易类现金赎楼;2:非交易类额度赎楼/非交易类现金赎楼;3:非交易额度内循环过桥;4:赎楼衍生贷;5:拍卖房担保", required = true)
    private Integer policyBusinessType;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getGuaranteeId() throws Exception{
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public String getPropertyValueDetermination() {
        return propertyValueDetermination;
    }

    public void setPropertyValueDetermination(String propertyValueDetermination) {
        this.propertyValueDetermination = propertyValueDetermination;
    }

    public Double getPaymentRatio() {
        return paymentRatio;
    }

    public void setPaymentRatio(Double paymentRatio) {
        this.paymentRatio = paymentRatio;
    }

    public Integer getThisLoanDays() {
        return thisLoanDays;
    }

    public void setThisLoanDays(Integer thisLoanDays) {
        this.thisLoanDays = thisLoanDays;
    }

    public Double getLoanRatio() {
        return loanRatio;
    }

    public void setLoanRatio(Double loanRatio) {
        this.loanRatio = loanRatio;
    }

    public String getTheCertificateBegins() {
        return theCertificateBegins;
    }

    public void setTheCertificateBegins(String theCertificateBegins) {
        this.theCertificateBegins = theCertificateBegins;
    }

    public String getTheCertificateEnds() {
        return theCertificateEnds;
    }

    public void setTheCertificateEnds(String theCertificateEnds) {
        this.theCertificateEnds = theCertificateEnds;
    }

    public Integer getReviewBusinessType() {
        return reviewBusinessType;
    }

    public void setReviewBusinessType(Integer reviewBusinessType) {
        this.reviewBusinessType = reviewBusinessType;
    }

    public Integer getPolicyBusinessType() {
        return policyBusinessType;
    }

    public void setPolicyBusinessType(Integer policyBusinessType) {
        this.policyBusinessType = policyBusinessType;
    }

    public String getOldLoanSituation() {
        return oldLoanSituation;
    }

    public void setOldLoanSituation(String oldLoanSituation) {
        this.oldLoanSituation = oldLoanSituation;
    }

    public String getCreditSituation() {
        return creditSituation;
    }

    public void setCreditSituation(String creditSituation) {
        this.creditSituation = creditSituation;
    }

    public String getFinalPriceInspect() {
        return finalPriceInspect;
    }

    public void setFinalPriceInspect(String finalPriceInspect) {
        this.finalPriceInspect = finalPriceInspect;
    }

    public Double getRedemptionRatio() {
        return redemptionRatio;
    }

    public void setRedemptionRatio(Double redemptionRatio) {
        this.redemptionRatio = redemptionRatio;
    }

    public Double getDebtRatio() {
        return debtRatio;
    }

    public void setDebtRatio(Double debtRatio) {
        this.debtRatio = debtRatio;
    }

    public String getFolkInquiry() {
        return folkInquiry;
    }

    public void setFolkInquiry(String folkInquiry) {
        this.folkInquiry = folkInquiry;
    }

    public String getLawsuit() {
        return lawsuit;
    }

    public void setLawsuit(String lawsuit) {
        this.lawsuit = lawsuit;
    }

    public String getGuarantorSituation() {
        return guarantorSituation;
    }

    public void setGuarantorSituation(String guarantorSituation) {
        this.guarantorSituation = guarantorSituation;
    }

    public String getPurchaseQualification() {
        return purchaseQualification;
    }

    public void setPurchaseQualification(String purchaseQualification) {
        this.purchaseQualification = purchaseQualification;
    }

    public String getReturnSource() {
        return returnSource;
    }

    public void setReturnSource(String returnSource) {
        this.returnSource = returnSource;
    }

    public String getAcceptanceOfOpinions() {
        return acceptanceOfOpinions;
    }

    public void setAcceptanceOfOpinions(String acceptanceOfOpinions) {
        this.acceptanceOfOpinions = acceptanceOfOpinions;
    }

    public String getApprovalReview() {
        return approvalReview;
    }

    public void setApprovalReview(String approvalReview) {
        this.approvalReview = approvalReview;
    }

    public Double getThisLoanAmount() {
        return thisLoanAmount;
    }

    public void setThisLoanAmount(Double thisLoanAmount) {
        this.thisLoanAmount = thisLoanAmount;
    }

    public Double getConsolidatedLoanAmount() {
        return consolidatedLoanAmount;
    }

    public void setConsolidatedLoanAmount(Double consolidatedLoanAmount) {
        this.consolidatedLoanAmount = consolidatedLoanAmount;
    }

    public Double getAuctionPrice() {
        return auctionPrice;
    }

    public void setAuctionPrice(Double auctionPrice) {
        this.auctionPrice = auctionPrice;
    }

    public Double getPaidDeposit() {
        return paidDeposit;
    }

    public void setPaidDeposit(Double paidDeposit) {
        this.paidDeposit = paidDeposit;
    }

    public Double getFirstInstallment() {
        return firstInstallment;
    }

    public void setFirstInstallment(Double firstInstallment) {
        this.firstInstallment = firstInstallment;
    }

    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }

    @Override
    public String toString() {
        return "ReviewInfoSaveForm{" +
                "oldLoanSituation='" + oldLoanSituation + '\'' +
                ", creditSituation='" + creditSituation + '\'' +
                ", finalPriceInspect='" + finalPriceInspect + '\'' +
                ", redemptionRatio=" + redemptionRatio +
                ", debtRatio=" + debtRatio +
                ", folkInquiry='" + folkInquiry + '\'' +
                ", lawsuit='" + lawsuit + '\'' +
                ", guarantorSituation='" + guarantorSituation + '\'' +
                ", purchaseQualification='" + purchaseQualification + '\'' +
                ", returnSource='" + returnSource + '\'' +
                ", acceptanceOfOpinions='" + acceptanceOfOpinions + '\'' +
                ", propertyValueDetermination='" + propertyValueDetermination + '\'' +
                ", paymentRatio=" + paymentRatio +
                ", approvalReview='" + approvalReview + '\'' +
                ", thisLoanAmount=" + thisLoanAmount +
                ", thisLoanDays='" + thisLoanDays + '\'' +
                ", consolidatedLoanAmount=" + consolidatedLoanAmount +
                ", auctionPrice=" + auctionPrice +
                ", paidDeposit=" + paidDeposit +
                ", firstInstallment=" + firstInstallment +
                ", loanAmount=" + loanAmount +
                ", loanRatio=" + loanRatio +
                ", theCertificateBegins='" + theCertificateBegins + '\'' +
                ", theCertificateEnds='" + theCertificateEnds + '\'' +
                ", reviewBusinessType=" + reviewBusinessType +
                ", policyBusinessType=" + policyBusinessType +
                '}';
    }
}
