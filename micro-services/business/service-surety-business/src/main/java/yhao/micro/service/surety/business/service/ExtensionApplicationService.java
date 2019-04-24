package yhao.micro.service.surety.business.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.complex.*;
import yhao.micro.service.surety.business.apilist.form.finance.OverdueRecordResultForm;
import yhao.micro.service.surety.business.apilist.model.*;
import yhao.micro.service.surety.business.apilist.model.finance.FundPayBackDetailModel;
import yhao.micro.service.surety.business.dao.automapper.ExaminerReviewDao;
import yhao.micro.service.surety.business.dao.automapper.ExtensionApplicationDao;
import yhao.micro.service.workflow.apilist.enums.task.TaskStatus;
import yhao.micro.service.workflow.apilist.form.task.TaskDealPassForm;
import yhao.micro.service.workflow.apilist.form.task.TaskDealRefuseForm;
import yhao.micro.service.workflow.apilist.form.task.TaskNodeItemForm;
import yhao.micro.service.workflow.apilist.form.task.TaskStartForm;
import yhao.micro.service.workflow.apilist.restful.TaskFeign;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Description
 * @Author leice
 * @Date 2019/1/3 15:58
 * @Version 1.0
 */

@Service
public class ExtensionApplicationService {

    @Autowired
    private ExaminerReviewDao examinerReviewDao;

    @Autowired
    private ExtensionApplicationDao extensionApplicationDao;

    @Resource
    private TaskFeign taskFeign;

    public ExtensionApplicationSaveForm extensionApplicationSave(ExtensionApplicationSaveForm form) throws Exception{
        if (null == form.getLoanId()){
            throw new Exception("借款id不能为空");
        }
        List<ExtensionApplicationModel> extensionApplicationModel = extensionApplicationDao.findExtensionByLoanId(form.getLoanId());
        if (null != extensionApplicationModel && extensionApplicationModel.size() == 1){
            throw new Exception("存在未收费的展期申请,不能新建展期");
        }
        if (null == form.getTypes()){
            throw new Exception("业务类型不能为空");
        }
        form.setId(UUID.randomUUID().toString());
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(date);
        form.setCreateDate(format);
        extensionApplicationDao.extensionApplicationSave(form);
        return form;
    }

    public ExtensionApplicationSaveForm extensionApplicationUpdate(ExtensionApplicationSaveForm form) throws Exception{
        if (null == form.getId() || "".equals(form.getId())){
            throw new Exception("展期id不能为空");
        }
        if (null == form.getTypes()){
            throw new Exception("业务类型不能为空");
        }
        QueryExtensionByIdForm queryExtensionByIdForm = new QueryExtensionByIdForm();
        queryExtensionByIdForm.setId(form.getId());
        ExtensionApplicationModel extensionApplicationModel = extensionApplicationDao.queryExtensionApplicationById(queryExtensionByIdForm);
        if (extensionApplicationModel.getStatusFee() != 1){
            throw new Exception("展期财务已经收费，不允许修改展期了");
        }
        extensionApplicationDao.extensionApplicationUpdate(form);
        return form;
    }


    /**
     * 功能描述: 修改展期收费状态
     *
     * @auther: leice
     * @date: 2019/1/3 18:00
     */
    public ExtensionApplicationFeeStatus extensionApplicationFeeStatusUpdate(ExtensionApplicationFeeStatus form) throws Exception{
        if (null == form.getId() || "".equals(form.getId())){
            throw new Exception("展期id不能为空");
        }
        extensionApplicationDao.extensionApplicationFeeStatusUpdate(form);
        return form;
    }

    public ExtensionApplicationModel queryExtensionApplicationById(QueryExtensionByIdForm form) throws Exception{
        if (null == form.getId() || "".equals(form.getId())){
            throw new Exception("展期id不能为空");
        }
        ExtensionApplicationModel extensionApplicationModel = extensionApplicationDao.queryExtensionApplicationById(form);
        return extensionApplicationModel;
    }

    public Pagination<ExtensionApplicationModel> queryExtensionListById(QueryExtensionByIdForm form) throws Exception{
        if (StringUtils.isBlank(form.getId()) ){
            throw new Exception("借款id不能为空");
        }
        Pagination<ExtensionApplicationModel> page = new Pagination(form.getPageSize(),form.getCurrentPage());
        Pagination<ExtensionApplicationModel> extensionApplicationModelPagination = extensionApplicationDao.queryExtensionListById(page, form);

        return extensionApplicationModelPagination;
    }

    public Pagination<ExtensionApplicationListModel> extensionApplicationList(ApplicationQueryForm form) {
        Pagination<ExtensionApplicationListModel> page = new Pagination(form.getPageSize(),form.getCurrentPage());
        Pagination<ExtensionApplicationListModel> extensionApplicationListModel = extensionApplicationDao.extensionApplicationList(page, form);
        List<ExtensionApplicationListModel> items = extensionApplicationListModel.getItems();
        if (null != items && items.size() > 0){
            int i = 0;
            for (ExtensionApplicationListModel item : items) {
                i++;
                item.setOrderNumber(i);
                String s = examinerReviewDao.queryManageName(item.getAccountManagerId());
                item.setAccountManagerOrg(s);
                if (null != item.getTypes() && item.getTypes() == 1 ){
                    item.setRate(item.getDailyRate());
                }else {
                    item.setRate(item.getRateOfCharge());
                }
            }
        }
        return extensionApplicationListModel;
    }


    /**
     * 功能描述: 定时修改展期状态为失效（当前日期 大于 应还日期，且财务未收费确认）
     *
     * @auther: leice
     * @date: 2019/1/8 10:08
     */
    @Scheduled(cron="0 0 1 * * ?")//每天凌晨一点执行
    public void updateExtensionNoUse(){
        List<ExtensionNoUseModel> extensionNoUseModels = extensionApplicationDao.queryExtensionId();
        if (null != extensionNoUseModels){
            for (ExtensionNoUseModel extensionNoUseModel : extensionNoUseModels) {
                extensionApplicationDao.updateExtensionNoUse(extensionNoUseModel.getExtensionId());
            }
        }
    }

    public ExtensionApplicationModel cancelExtension(CancleExtensionForm form) throws Exception{
        if (StringUtils.isBlank(form.getExtensionId()) ){
            throw new Exception("展期id不能为空");
        }
        QueryExtensionByIdForm queryExtensionByIdForm = new QueryExtensionByIdForm();
        queryExtensionByIdForm.setId(form.getExtensionId());
        ExtensionApplicationModel extensionApplicationModel = extensionApplicationDao.queryExtensionApplicationById(queryExtensionByIdForm);
        if (null != extensionApplicationModel){
            extensionApplicationDao.cancelExtension(form.getExtensionId());
        }else {
            throw new Exception("展期记录不存在");
        }
        return extensionApplicationModel;
    }

    @Transactional
    public OverdueToExtensionListForm overdueToExtensionSave(OverdueToExtensionListForm form) throws Exception{
        if (null != form.getOverdueToExtensionForms() && form.getOverdueToExtensionForms().size() > 0){
            List<OverdueToExtensionForm> overdueToExtensionForms = form.getOverdueToExtensionForms();
            List<OverdueToExtensionForm> overdueToExtensionForms2 = new ArrayList<OverdueToExtensionForm>();
            if (null != overdueToExtensionForms && overdueToExtensionForms.size()>0){
                for (OverdueToExtensionForm overdueToExtensionForm : overdueToExtensionForms) {
                    if (null == overdueToExtensionForm.getWarrantyId()){
                        throw new Exception("担保单id不能为空");
                    }
                    if (null == overdueToExtensionForm.getLoanId()){
                        throw new Exception("借款id不能为空");
                    }
                    if (null == overdueToExtensionForm.getPaybackId()){
                        throw new Exception("回款id不能为空");
                    }
                    if (null == overdueToExtensionForm.getOverDueRate()){
                        throw new Exception("逾期费率不能为空");
                    }
                    if (null == overdueToExtensionForm.getRate()){
                        throw new Exception("申请费率不能为空");
                    }
                    // 查询某担保单借款每日费率
                    LoanDailyRateModel loanDailyRateByGuaranteeId = extensionApplicationDao.findLoanDailyRateByGuaranteeId(overdueToExtensionForm.getLoanId());
                    // 申请费率条件过滤
                    if (null != loanDailyRateByGuaranteeId) {
                            if (overdueToExtensionForm.getRate() < loanDailyRateByGuaranteeId.getLoanDailyRate()){
                                throw new Exception("费率不能小于首次借款的费率"+loanDailyRateByGuaranteeId.getLoanDailyRate()+"%");
                            }
                    }
                    // 担保单对应业务配置的逾期费率
                    if(overdueToExtensionForm.getRate() > overdueToExtensionForm.getOverDueRate()){
                        throw new Exception("申请逾期费率不能大于"+overdueToExtensionForm.getOverDueRate()+"%");
                    }
                    overdueToExtensionForms2.add(overdueToExtensionForm);
                }
                int i= 0;
                String warrantyId = null;
                for (OverdueToExtensionForm overdueToExtensionForm : overdueToExtensionForms2) {
                    overdueToExtensionForm.setId(UUID.randomUUID().toString());
                    extensionApplicationDao.overdueToExtension(overdueToExtensionForm);
                    i++;
                    if (overdueToExtensionForms2.size() == i){
                        warrantyId=overdueToExtensionForm.getWarrantyId();
                    }
                }
                OverdueExtensionTaskForm overdueExtensionTaskForm = new OverdueExtensionTaskForm();
                overdueExtensionTaskForm.setWarrantyId(warrantyId);
                overdueExtensionTaskForm.setId(UUID.randomUUID().toString());
                extensionApplicationDao.overdueExtensionTask(overdueExtensionTaskForm);
                //启动费用减免申请任务
                TaskStartForm taskStartForm = new TaskStartForm();
                taskStartForm.setTaskHead("费用减免申请子流程");
                taskStartForm.setBizCodeStr("56");
                taskStartForm.setBizEntityId(overdueExtensionTaskForm.getId());
                RequestResult<TaskStartForm> taskStartFormRequestResult = taskFeign.startNewTask(taskStartForm);
                if(!taskStartFormRequestResult.isSuccess()){
                    extensionApplicationDao.delete2(overdueExtensionTaskForm.getId());
                    for (OverdueToExtensionForm overdueToExtensionForm : overdueToExtensionForms2) {
                        extensionApplicationDao.delete(overdueToExtensionForm.getId());
                    }
                    throw new Exception("启动费用减免申请子流程失败");
                }
            }
        }
        return form;
    }

    @Transactional
    public OverdueToExtCancelForm OverdueToExtCancel(OverdueToExtCancelForm form) throws Exception {
        //查询业务id
        String id = extensionApplicationDao.selectOverdueTaskById(form.getGuaranteeId());
        //修改逾期业务字段表状态
        extensionApplicationDao.OverdueTaskExtCancel(id);
        //修改逾期表状态
        extensionApplicationDao.OverdueToExtCancel(form.getGuaranteeId());
        //撤销减免费用申请任务
        IdForm idForm = new IdForm();
        idForm.setId(id);
        RequestResult<Boolean> booleanRequestResult = taskFeign.cancelTask(idForm);
        if(!booleanRequestResult.isSuccess()){
            extensionApplicationDao.OverdueToExtNoCancel(form.getGuaranteeId());
            extensionApplicationDao.OverdueTaskNoCancel(id);
            throw new Exception("撤销失败");
        }
        return form;
    }

    public Pagination<OverDueListModel> overDueList(OverDueQueryForm form) {
        form.setProcessCode("30");
        Pagination<OverDueListModel> page = new Pagination(form.getPageSize(),form.getCurrentPage());
        Pagination<OverDueListModel> overDueListModelPagination = extensionApplicationDao.overDueList(page, form);
        List<OverDueListModel> items = overDueListModelPagination.getItems();
        if (null != items && items.size() > 0){
            for (OverDueListModel item : items) {
                //查询实际应收
                Double aDouble = extensionApplicationDao.queryActualReceivable(item.getGuaranteeId());
                if (null != aDouble){
                    item.setActualReceivable(aDouble);
                    //剩余应交
                    item.setRemainingDue(aDouble - item.getCumulativeCharge());
                }
                //查询逾期费
                Double aDouble1 = extensionApplicationDao.queryOverdueFee(item.getGuaranteeId());
                if (null != aDouble) {
                    item.setOverdueFee(aDouble1);
                }
            }
        }
        return overDueListModelPagination;
    }

    public Pagination<CreateExtensionListModel> createExtensionApplicationList(CreateExtensionListForm form) {
        Pagination<CreateExtensionListModel> page = new Pagination(form.getPageSize(),form.getCurrentPage());
        Pagination<CreateExtensionListModel> createExtensionModelPagination = extensionApplicationDao.createExtensionApplicationList(page, form);
        List<CreateExtensionListModel> items = createExtensionModelPagination.getItems();
        if (null != items && items.size() > 0){
            for (CreateExtensionListModel item : items) {
                List<ExtensionLoans> extensionLoans = item.getExtensionLoans();
                if (null != extensionLoans && extensionLoans.size() > 0){
                    for (ExtensionLoans extensionLoan : extensionLoans) {
                        List<String> noFee = extensionApplicationDao.findNoFee(extensionLoan.getLoanId());
                            extensionLoan.setNoFee(noFee.size() == 0 ? 2:1);
                    }
                }
            }
        }
        return createExtensionModelPagination;
    }

    public ExtensionSomeFiledModel querySomeField(ExtensionSomeFiledForm form) {
        ExtensionSomeFiledModel extensionSomeFiledModel = null;
        if (form.getTypes() == 1){
            extensionSomeFiledModel = extensionApplicationDao.queryLoanSomeField(form);
        }else{
            extensionSomeFiledModel = extensionApplicationDao.querySomeField(form);
        }
        return extensionSomeFiledModel;
    }

    public List<OverdueRecordResultForm> queryLookOverdueRecord(IdForm form) {
        List<OverdueRecordResultForm> overdueRecordResultForms = extensionApplicationDao.queryLookOverdueRecord(form);
        if (null !=overdueRecordResultForms && overdueRecordResultForms.size()>0 ){
            for (OverdueRecordResultForm overdueRecordResultForm : overdueRecordResultForms) {
                List<FundPayBackDetailModel> payBackDetailList = overdueRecordResultForm.getPayBackDetailList();
                if (null !=payBackDetailList && payBackDetailList.size()>0) {
                    for (FundPayBackDetailModel fundPayBackDetailModel : payBackDetailList) {
                        if (null == fundPayBackDetailModel.getOverdueRate()){
                            fundPayBackDetailModel.setIsHave(2);
                            fundPayBackDetailModel.setOverdueRate(fundPayBackDetailModel.getStartRate());
                        }
                        fundPayBackDetailModel.setIsHave(1);
                    }
                }
            }
        }
        return overdueRecordResultForms;
    }

    @Transactional
    public OverdueToExtensionListForm OverdueToExtUpdate(OverdueToExtensionListForm form) throws Exception{
        List<OverdueToExtensionForm> overdueToExtensionForms = form.getOverdueToExtensionForms();
        for (OverdueToExtensionForm overdueToExtensionForm : overdueToExtensionForms) {
            //根据回款id查询逾期表
            OverDueModel overDueModel = extensionApplicationDao.selectOverdueByPackId(overdueToExtensionForm.getPaybackId());
            if (null == overDueModel){
                //新增逾期表记录
                overdueToExtensionForm.setId(UUID.randomUUID().toString());
                extensionApplicationDao.overdueToExtension(overdueToExtensionForm);
            }else{
                //修改费率
                extensionApplicationDao.UpdateOverdueByPackId(overdueToExtensionForm);
            }
        }
        //驳回后重新启动流程
        // 通过任务id和事项编码查询组装接口所需参数
        RefuseWarrantyReviewForm refuseWarrantyReviewForm = form.getRefuseWarrantyReviewForm();

        RefuseWarrantyReviewModel refuseWarrantyReviewModel = examinerReviewDao.refuseWarrantyReview(refuseWarrantyReviewForm);
        TaskDealPassForm taskDealPassForm = TaskDealPassForm.newTaskDealPassForm();
        TaskNodeItemForm taskNodeItemForm = TaskNodeItemForm.newTaskNodeItemForm();
        taskNodeItemForm.setTaskId(refuseWarrantyReviewForm.getTaskId());
        taskNodeItemForm.setNodeId(refuseWarrantyReviewModel.getNodeId());
        taskNodeItemForm.setItemId(refuseWarrantyReviewModel.getItemId());
        taskNodeItemForm.setItemCode(refuseWarrantyReviewForm.getItemCode());//事项编码后面为固定值
        taskNodeItemForm.setItemResultCode(refuseWarrantyReviewModel.getItemResultCode());
        taskNodeItemForm.setItemFinishPerson(refuseWarrantyReviewForm.getItemFinishPerson());
        taskNodeItemForm.setItemFinishPersonOrgId(refuseWarrantyReviewForm.getItemFinishPersonOrgId());
        taskNodeItemForm.setItemNecessary(refuseWarrantyReviewModel.getItemNecessary());
        taskNodeItemForm.setItemCore(refuseWarrantyReviewModel.getItemCore());
        taskDealPassForm.setStatus(TaskStatus.RUNNING);
        taskDealPassForm.setTaskNodeItem(taskNodeItemForm);
        RequestResult<Boolean> booleanRequestResult = taskFeign.passTaskAuto(taskDealPassForm);
        if(!booleanRequestResult.isSuccess()){
            throw new Exception("驳回后启动流程失败");
        }
        return form;
    }
}
