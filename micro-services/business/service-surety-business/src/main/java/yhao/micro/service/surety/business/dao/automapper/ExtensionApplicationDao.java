package yhao.micro.service.surety.business.dao.automapper;

import org.springframework.stereotype.Repository;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.complex.*;
import yhao.micro.service.surety.business.apilist.form.finance.OverdueRecordResultForm;
import yhao.micro.service.surety.business.apilist.model.*;

import java.util.List;

/**
 * @Description
 * @Author leice
 * @Date 2019/1/3 15:59
 * @Version 1.0
 */
@Repository
public interface ExtensionApplicationDao {
    void extensionApplicationSave(ExtensionApplicationSaveForm form);

    void overdueToExtension(OverdueToExtensionForm form);

    void extensionApplicationUpdate(ExtensionApplicationSaveForm form);

    void cancelExtension(String id);

    void extensionApplicationFeeStatusUpdate(ExtensionApplicationFeeStatus form);

    ExtensionApplicationModel queryExtensionApplicationById(QueryExtensionByIdForm form);

    void updateExtensionNoUse(String id);

    List<ExtensionNoUseModel> queryExtensionId();

    Pagination<ExtensionApplicationModel> queryExtensionListById(Pagination<ExtensionApplicationModel> page, QueryExtensionByIdForm form);

    Pagination<ExtensionApplicationListModel> extensionApplicationList(Pagination<ExtensionApplicationListModel> page, ApplicationQueryForm form);

    List<ExtensionApplicationModel> findExtensionByLoanId(String loanId);

    void OverdueToExtCancel(String id);

    LoanDailyRateModel findLoanDailyRateByGuaranteeId(String id);

    Pagination<OverDueListModel> overDueList(Pagination<OverDueListModel> page, OverDueQueryForm form);

    // 查询实际应收
    Double queryActualReceivable(String id);

    // 查询逾期费
    Double queryOverdueFee(String id);

    Pagination<CreateExtensionListModel> createExtensionApplicationList(Pagination<CreateExtensionListModel> page, CreateExtensionListForm form);

    ExtensionSomeFiledModel queryLoanSomeField(ExtensionSomeFiledForm form);

    ExtensionSomeFiledModel querySomeField(ExtensionSomeFiledForm form);

    List<String> findNoFee(String loanId);

    //逾期查看
    List<OverdueRecordResultForm> queryLookOverdueRecord(IdForm form);

    void OverdueToExtNoCancel(String id);

    void OverdueTaskExtCancel(String id);

    void OverdueTaskNoCancel(String id);

    String selectOverdueTaskById(String id);

    void delete(String id);

    void delete2(String id);

    void overdueExtensionTask(OverdueExtensionTaskForm form);

    OverDueModel selectOverdueByPackId(String paybackId);

    void UpdateOverdueByPackId(OverdueToExtensionForm overdueToExtensionForm);
}
