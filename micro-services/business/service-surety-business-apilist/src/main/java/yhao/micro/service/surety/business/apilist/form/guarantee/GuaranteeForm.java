package yhao.micro.service.surety.business.apilist.form.guarantee;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.micro.service.constants.enums.YNEnum;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Description:
 * @Created by ql on 2019/1/2 19:14
 * @Version: v1.0
 */
public class GuaranteeForm extends IdUnForm {
	@ApiModelProperty(value = "保存/提交, 保存(不提交)=NO, 提交=YES", required = true)
	@NotNull(message = "请明确保存/提交")
	private YNEnum save;

	@ApiModelProperty(value = "经办人信息", required = true)
	@NotEmpty(message = "经办人信息不得为空")
	@Valid
	private List<GuaranteePartnerSaveForm> guaranteePartnerSaveFormList;

	@ApiModelProperty(value = "业务信息")
	@NotNull(message = "业务信息不得为空")
	@Valid
	private GuaranteeSaveForm guaranteeSaveForm;

	@ApiModelProperty(value = "物业+业主信息")
	@NotEmpty(message = "物业+业主信息不得为空")
	@Valid
	private List<EstateSellerForm> estateSellerFormList;

	@ApiModelProperty(value = "买家个人信息")
	@NotNull(message = "买家个人信息不得为空")
	@Valid
	private List<PersonInfoTradesSaveForm> buyerPersonInfoTradesSaveFormList;

	@ApiModelProperty(value = "原贷款情况")
	@NotNull(message = "原贷款情况不得为空")
	@Valid
	private LoanSellerSaveForm loanSellerSaveForm;

	@ApiModelProperty(value = "成交情况") //代码中校验
	private TransactionGuaranteeInfoSaveForm transactionGuaranteeInfoSaveForm;

	@ApiModelProperty(value = "新贷款信息")
	private LoanBuyerSaveForm loanBuyerSaveForm;

	@ApiModelProperty(value = "担保情况")
	@NotNull(message = "担保情况不得为空")
	@Valid
	private GuaranteeSituationSaveForm guaranteeSituationSaveForm;

	@ApiModelProperty(value = "反担保栏信息信息")
	private List<AntiForm> antiFormList;

	@ApiModelProperty(value = "借款概况信息")
	private LoanGeneralSaveForm loanGeneralSaveForm;

	@ApiModelProperty(value = "借款明细信息")
	private List<LoanDetailsSaveForm> loanDetailsSaveFormList;

	@ApiModelProperty(value = "(非交易现金赎楼中)新贷款情况贷款发放账户")//T_SURETY_G_LOAN_PAYMENT
	private List<LoanPaymentSaveForm> loanPaymentSaveFormList;

	@ApiModelProperty(value = "交易类现金回款计划信息")
	private List<TransactionTypeReceivePaymentPlanSaveForm> transactionTypeReceivePaymentPlanSaveFormList;

	public List<LoanPaymentSaveForm> getLoanPaymentSaveFormList() {
		return loanPaymentSaveFormList;
	}

	public void setLoanPaymentSaveFormList(List<LoanPaymentSaveForm> loanPaymentSaveFormList) {
		this.loanPaymentSaveFormList = loanPaymentSaveFormList;
	}

	public List<GuaranteePartnerSaveForm> getGuaranteePartnerSaveFormList() {
		return guaranteePartnerSaveFormList;
	}

	public YNEnum getSave() {
		return save;
	}

	public void setSave(YNEnum save) {
		this.save = save;
	}

	public void setGuaranteePartnerSaveFormList(List<GuaranteePartnerSaveForm> guaranteePartnerSaveFormList) {
		this.guaranteePartnerSaveFormList = guaranteePartnerSaveFormList;
	}

	public GuaranteeSaveForm getGuaranteeSaveForm() {
		return guaranteeSaveForm;
	}

	public void setGuaranteeSaveForm(GuaranteeSaveForm guaranteeSaveForm) {
		this.guaranteeSaveForm = guaranteeSaveForm;
	}

	public List<EstateSellerForm> getEstateSellerFormList() {
		return estateSellerFormList;
	}

	public void setEstateSellerFormList(List<EstateSellerForm> estateSellerFormList) {
		this.estateSellerFormList = estateSellerFormList;
	}

	public LoanSellerSaveForm getLoanSellerSaveForm() {
		return loanSellerSaveForm;
	}

	public void setLoanSellerSaveForm(LoanSellerSaveForm loanSellerSaveForm) {
		this.loanSellerSaveForm = loanSellerSaveForm;
	}

	public TransactionGuaranteeInfoSaveForm getTransactionGuaranteeInfoSaveForm() {
		return transactionGuaranteeInfoSaveForm;
	}

	public void setTransactionGuaranteeInfoSaveForm(TransactionGuaranteeInfoSaveForm transactionGuaranteeInfoSaveForm) {
		this.transactionGuaranteeInfoSaveForm = transactionGuaranteeInfoSaveForm;
	}

	public LoanBuyerSaveForm getLoanBuyerSaveForm() {
		return loanBuyerSaveForm;
	}

	public void setLoanBuyerSaveForm(LoanBuyerSaveForm loanBuyerSaveForm) {
		this.loanBuyerSaveForm = loanBuyerSaveForm;
	}

	public GuaranteeSituationSaveForm getGuaranteeSituationSaveForm() {
		return guaranteeSituationSaveForm;
	}

	public void setGuaranteeSituationSaveForm(GuaranteeSituationSaveForm guaranteeSituationSaveForm) {
		this.guaranteeSituationSaveForm = guaranteeSituationSaveForm;
	}

	public List<AntiForm> getAntiFormList() {
		return antiFormList;
	}

	public void setAntiFormList(List<AntiForm> antiFormList) {
		this.antiFormList = antiFormList;
	}

	public LoanGeneralSaveForm getLoanGeneralSaveForm() {
		return loanGeneralSaveForm;
	}

	public void setLoanGeneralSaveForm(LoanGeneralSaveForm loanGeneralSaveForm) {
		this.loanGeneralSaveForm = loanGeneralSaveForm;
	}

	public List<LoanDetailsSaveForm> getLoanDetailsSaveFormList() {
		return loanDetailsSaveFormList;
	}

	public void setLoanDetailsSaveFormList(List<LoanDetailsSaveForm> loanDetailsSaveFormList) {
		this.loanDetailsSaveFormList = loanDetailsSaveFormList;
	}

	public List<TransactionTypeReceivePaymentPlanSaveForm> getTransactionTypeReceivePaymentPlanSaveFormList() {
		return transactionTypeReceivePaymentPlanSaveFormList;
	}

	public void setTransactionTypeReceivePaymentPlanSaveFormList(List<TransactionTypeReceivePaymentPlanSaveForm> transactionTypeReceivePaymentPlanSaveFormList) {
		this.transactionTypeReceivePaymentPlanSaveFormList = transactionTypeReceivePaymentPlanSaveFormList;
	}

	public List<PersonInfoTradesSaveForm> getBuyerPersonInfoTradesSaveFormList() {
		return buyerPersonInfoTradesSaveFormList;
	}

	public void setBuyerPersonInfoTradesSaveFormList(List<PersonInfoTradesSaveForm> buyerPersonInfoTradesSaveFormList) {
		this.buyerPersonInfoTradesSaveFormList = buyerPersonInfoTradesSaveFormList;
	}
}
