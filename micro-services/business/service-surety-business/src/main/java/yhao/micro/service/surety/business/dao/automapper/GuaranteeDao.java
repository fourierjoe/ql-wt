package yhao.micro.service.surety.business.dao.automapper;

import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.guarantee.*;
import yhao.micro.service.surety.business.apilist.form.intention.CreditClerkSaveForm;
import yhao.micro.service.surety.business.apilist.form.intention.FollowerAttachmentForm;
import yhao.micro.service.surety.business.apilist.form.intention.FollowerBuyerAndSellerForm;
import yhao.micro.service.surety.business.apilist.model.guarantee.*;
import yhao.micro.service.surety.business.apilist.model.guarantee.output.LoanDetailsModel;
import yhao.micro.service.surety.business.apilist.model.guarantee.output.TransactionTypeReceivePaymentPlanModel;
import yhao.micro.service.surety.business.apilist.model.guarantee.page.GuaranteePageModel;
import yhao.micro.service.workflow.apilist.model.task.TaskNodeItemModel;

import java.util.List;

/**
 * @Description:
 * @Created by ql on 2019/1/2 20:09
 * @Version: v1.0
 */
public interface GuaranteeDao {
    void saveGuarantee(GuaranteeSaveForm form);

    void saveAntiGuarantor(AntiGuarantorSaveForm form);

    void batchSaveAntiGuarantorEstate(List<AntiEstateSaveForm> form);

    void saveAttachment(AttachmentSaveForm form);

    void batchSaveAttachment(List<AttachmentSaveForm> list);

    void batchUpdateAttachment(List<AttachmentSaveForm> list);

    void batchDeleteAttachment(List<String> list);

    List<String> queryAttachment(String id);

    void saveCreditRecord(CreditRecordSaveForm form);

    void saveEstateSeller(EstateSellerSaveForm form);

    void saveGuaranteeSituation(GuaranteeSituationSaveForm form);

    void saveTransactionGuaranteeInfo(TransactionGuaranteeInfoSaveForm form);

    void saveLoanBuyer(LoanBuyerSaveForm form);

    void batchSaveLoanDetails(List<LoanDetailsSaveForm> list);

    void saveLoanGeneral(LoanGeneralSaveForm form);

    void saveLoanSeller(LoanSellerSaveForm form);

    void batchSavePartner(List<GuaranteePartnerSaveForm> list);

    void batchSaveLoanPayment(List<LoanPaymentSaveForm> list);

    List<String> queryLoanPayment(String id);

    void batchUpdateLoanPayment(List<LoanPaymentSaveForm> list);

    void batchDeleteLoanPayment(List<String> list);

    void batchSavePersonInfoTrades(List<PersonInfoTradesSaveForm> persons);

    void saveRepay(RepaySaveForm form);

    int updateRepay(RepaySaveForm form);

    void saveTransactionTypeReceivePaymentPlanSaveFormList(List<TransactionTypeReceivePaymentPlanSaveForm> list);

    List<String> queryPartner(String id);

    void batchUpdatePartner(List<GuaranteePartnerSaveForm> list);

    void batchDeletePartner(List<String> list);

    List<EstateSellerModel> queryEstateSellerPersonInfo(String id);

    void batchUpdateEstateSeller(List<EstateSellerSaveForm> list);

    void batchDeleteEstateSeller(List<String> list);

    void batchDeletePersonInfoTradesByEstateId(List<String> list);

    void batchUpdatePersonInfoTrades(List<PersonInfoTradesSaveForm> list);

    void batchDeletePersonInfoTrades(List<String> list);

    void batchSaveEstateSeller(List<EstateSellerSaveForm> list);

    // 原贷款情况
    void updateLoanSeller(LoanSellerSaveForm form);

    // 成交情况
    void updateTransactionGuaranteeInfo(TransactionGuaranteeInfoSaveForm form);

    // 新贷款信息
    void updateLoanBuyer(LoanBuyerSaveForm form);

    // 担保情况
    void updateGuaranteeSituation(GuaranteeSituationSaveForm form);

    void updateLoanGeneral(LoanGeneralSaveForm form);

    List<String> queryloanDetails(String id);

    void batchUpdateLoanDetails(List<LoanDetailsSaveForm> list);

    void batchDeleteLoanDetails(List<String> list);

    void updateTransactionTypeReceivePaymentPlan(TransactionTypeReceivePaymentPlanSaveForm form);

    List<String> queryTransactionTypeReceivePaymentPlan(String id);

    int batchUpdateTransactionTypeReceivePaymentPlan(List<TransactionTypeReceivePaymentPlanSaveForm> list);

    int batchDeleteTransactionTypeReceivePaymentPlan(List<String> list);

    void updateGuarantee(GuaranteeSaveForm form);

    List<AntiModel> queryAnti(String id);

    void batchUpdateAntiPerson(List<AntiGuarantorSaveForm> list);

    void batchDeleteAntiPerson(List<String> list);

    void batchDeleteAntiEstateByAntiPersonId(List<String> list);

    void batchSaveAntiPerson(List<AntiGuarantorSaveForm> list);

    void batchUpdateAntiEstate(List<AntiEstateSaveForm> list);

    void batchDeleteAntiEstate(List<String> list);

    List<String> queryPerson(String id);

    void updateGuaranteeDealmanRemark(GuaranteeSaveForm form);

    void batchUpdateFollowerPersonInfoTrades(List<FollowerBuyerAndSellerForm> list);

    void batchUpdateFollowerAttachment(List<FollowerAttachmentForm> list);

    void updateFollowerGuarantee(GuaranteeSaveForm form);

    void updateIsCreditReport(CreditClerkSaveForm form);

    GuaranteeModel pickGuarantee(String id);

    void saveMainContractNum(MainContractNumSaveForm form);

    MainContractNumModel pickMainContractNum(String id);

    void queryGuaranteePage(Pagination<GuaranteePageModel> page, GuaranteeQueryPageForm form);

    //更新单个借款明细
    void updateLoanDetail(LoanDetailsModel model);

    void deleteMainTask(String id);

    void deleteSubTask(String id);

    void deleteMainTaskItem(String id);

    void deleteSubTaskItem(String id);

    void deleteTaskVariable(String id);

    void deleteSubTaskWarn(String id);

    void deleteMainTaskWarn(String id);

    LoanDetailsModel pickLoanDetails(String loanId);

    List<String> queryBuyer(String id);

    void associateGuarantee(Pagination<AssociateGuaranteeModel> page, AssociateGuaranteeForm form);

    void saveEstateFile(EstateFileSaveForm form);

    List<EstateFileModel> queryEstateFile(String id);

    int updateRecallState(String id);

    TaskNodeItemModel selectIsFirstTask(String id);

    /**
     * 查询交易类现金回款计划
     */
    List<TransactionTypeReceivePaymentPlanModel> queryRepayAccount(String guaranteeId);
}
