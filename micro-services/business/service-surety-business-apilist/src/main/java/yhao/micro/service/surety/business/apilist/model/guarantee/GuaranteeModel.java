package yhao.micro.service.surety.business.apilist.model.guarantee;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.surety.business.apilist.form.guarantee.LoanPaymentSaveForm;
import yhao.micro.service.surety.business.apilist.model.guarantee.output.*;

import java.util.List;

/**
 * @Description:
 * @Created by ql on 2018/12/10 19:56
 * @Version: v1.0
 */
public class GuaranteeModel extends Entity<String> {
    @ApiModelProperty(value = "经办人信息")
    private List<GuaranteePartnerModel> guaranteePartnerModelList;

    @ApiModelProperty(value = "业务信息")
    private GuaranteeBizModel guaranteeBizModel;

    @ApiModelProperty(value = "物业信息")
    private List<EstateOutModel> estateOutModelList;

    @ApiModelProperty(value = "买家个人信息")
    private List<PersonInfoTradesModel> buyerModelList;

    @ApiModelProperty(value = "原贷款情况")
    private LoanSellerModel loanSellerModel;

    @ApiModelProperty(value = "成交情况")
    private TransactionGuaranteeInfoModel transactionGuaranteeInfoModel;

    @ApiModelProperty(value = "新贷款信息")
    private LoanBuyerModel loanBuyerModel;

    @ApiModelProperty(value = "担保情况")
    private GuaranteeSituationModel guaranteeSituationModel;

    @ApiModelProperty(value = "反担保人信息")
    private List<AntiGuarantorModel> antiGuarantorModelList;

    @ApiModelProperty(value = "借款概况信息")
    private LoanGeneralModel loanGeneralModel;

    @ApiModelProperty(value = "借款明细信息")
    private List<LoanDetailsModel> loanDetailsModelList;

    @ApiModelProperty(value = "交易类现金回款计划信息")
    private List<TransactionTypeReceivePaymentPlanModel> transactionTypeReceivePaymentPlanModel;

    @ApiModelProperty(value = "(非交易现金赎楼中)新贷款情况贷款发放账户")//T_SURETY_G_LOAN_PAYMENT
    private List<LoanPaymentModel> loanPaymentModelList;

    public List<LoanPaymentModel> getLoanPaymentModelList() {
        return loanPaymentModelList;
    }

    public void setLoanPaymentModelList(List<LoanPaymentModel> loanPaymentModelList) {
        this.loanPaymentModelList = loanPaymentModelList;
    }

    public List<EstateOutModel> getEstateOutModelList() {
        return estateOutModelList;
    }

    public void setEstateOutModelList(List<EstateOutModel> estateOutModelList) {
        this.estateOutModelList = estateOutModelList;
    }

    public List<AntiGuarantorModel> getAntiGuarantorModelList() {
        return antiGuarantorModelList;
    }

    public void setAntiGuarantorModelList(List<AntiGuarantorModel> antiGuarantorModelList) {
        this.antiGuarantorModelList = antiGuarantorModelList;
    }

    public List<GuaranteePartnerModel> getGuaranteePartnerModelList() {
        return guaranteePartnerModelList;
    }

    public void setGuaranteePartnerModelList(List<GuaranteePartnerModel> guaranteePartnerModelList) {
        this.guaranteePartnerModelList = guaranteePartnerModelList;
    }

    public GuaranteeBizModel getGuaranteeBizModel() {
        return guaranteeBizModel;
    }

    public void setGuaranteeBizModel(GuaranteeBizModel guaranteeBizModel) {
        this.guaranteeBizModel = guaranteeBizModel;
    }

    public LoanSellerModel getLoanSellerModel() {
        return loanSellerModel;
    }

    public void setLoanSellerModel(LoanSellerModel loanSellerModel) {
        this.loanSellerModel = loanSellerModel;
    }

    public TransactionGuaranteeInfoModel getTransactionGuaranteeInfoModel() {
        return transactionGuaranteeInfoModel;
    }

    public void setTransactionGuaranteeInfoModel(TransactionGuaranteeInfoModel transactionGuaranteeInfoModel) {
        this.transactionGuaranteeInfoModel = transactionGuaranteeInfoModel;
    }

    public LoanBuyerModel getLoanBuyerModel() {
        return loanBuyerModel;
    }

    public void setLoanBuyerModel(LoanBuyerModel loanBuyerModel) {
        this.loanBuyerModel = loanBuyerModel;
    }

    public GuaranteeSituationModel getGuaranteeSituationModel() {
        return guaranteeSituationModel;
    }

    public void setGuaranteeSituationModel(GuaranteeSituationModel guaranteeSituationModel) {
        this.guaranteeSituationModel = guaranteeSituationModel;
    }

    public LoanGeneralModel getLoanGeneralModel() {
        return loanGeneralModel;
    }

    public void setLoanGeneralModel(LoanGeneralModel loanGeneralModel) {
        this.loanGeneralModel = loanGeneralModel;
    }

    public List<LoanDetailsModel> getLoanDetailsModelList() {
        return loanDetailsModelList;
    }

    public void setLoanDetailsModelList(List<LoanDetailsModel> loanDetailsModelList) {
        this.loanDetailsModelList = loanDetailsModelList;
    }

    public List<TransactionTypeReceivePaymentPlanModel> getTransactionTypeReceivePaymentPlanModel() {
        return transactionTypeReceivePaymentPlanModel;
    }

    public void setTransactionTypeReceivePaymentPlanModel(List<TransactionTypeReceivePaymentPlanModel> transactionTypeReceivePaymentPlanModel) {
        this.transactionTypeReceivePaymentPlanModel = transactionTypeReceivePaymentPlanModel;
    }

    public List<PersonInfoTradesModel> getBuyerModelList() {
        return buyerModelList;
    }

    public void setBuyerModelList(List<PersonInfoTradesModel> buyerModelList) {
        this.buyerModelList = buyerModelList;
    }
}
