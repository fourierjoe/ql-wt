package yhao.micro.service.surety.business.service;

import org.apache.commons.lang3.StringUtils;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yhao.infra.apilist.RequestResult;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.complex.*;
import yhao.micro.service.surety.business.apilist.model.*;
import yhao.micro.service.surety.business.dao.automapper.DiscountApplicationDao;
import yhao.micro.service.surety.business.dao.automapper.ExaminerReviewDao;
import yhao.micro.service.surety.business.dao.automapper.ExecutiveNoteDao;
import yhao.micro.service.workflow.apilist.form.task.TaskDealForm;
import yhao.micro.service.workflow.apilist.form.task.TaskDealRefuseForm;
import yhao.micro.service.workflow.apilist.form.task.TaskNodeItemForm;
import yhao.micro.service.workflow.apilist.form.task.TaskStartForm;
import yhao.micro.service.workflow.apilist.model.task.TaskNodeItemModel;
import yhao.micro.service.workflow.apilist.restful.TaskFeign;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Description 审查员审查Service
 *
 * @Author leice
 * @Date 2018/12/18 11:48
 * @Version 1.0
 */
@Service
public class ExaminerReviewService {

    @Autowired
    private ExaminerReviewDao examinerReviewDao;

    @Autowired
    private DiscountApplicationDao discountApplicationDao;

    @Autowired
    private ExecutiveNoteDao executiveNoteDao;

    @Resource
    private TaskFeign taskFeign;


    private DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();


    public FollowUpSaveForm warrantyFollowUpRecordingSave(FollowUpSaveForm form) throws Exception{
        form.setId(UUID.randomUUID().toString());
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(date);
        form.setCreateTime(format);
        examinerReviewDao.warrantyFollowUpRecordingSave(form);
        return form;
    }

    public Pagination<FollowUpListQueryModel> pageQueryFollowUpRecordingById(FollowUpListForm form) throws Exception{
        Pagination<FollowUpListQueryModel> page = new Pagination(form.getPageSize(),form.getCurrentPage());
        Pagination<FollowUpListQueryModel> followUpListQueryModelPagination = examinerReviewDao.pageQueryFollowUpRecordingById(page, form);
        return followUpListQueryModelPagination;
    }

    @Transactional
    public ReviewTransferForm reviewReceive(ReviewTransferForm form) throws Exception {
        ReviewTransferForm reviewTransferForm = selectReviewByGuaranteeId(form.getGuaranteeId());
        if (null == reviewTransferForm){
            form.setId(UUID.randomUUID().toString());
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String format = simpleDateFormat.format(date);
            form.setReceiveTime(format);
            examinerReviewDao.reviewReceive(form);
            //修改接收状态
            examinerReviewDao.updateReviewStatus(form.getGuaranteeId());
        }else {
            throw new Exception("担保单已经被接收");
        }
        return form;
    }

    public ReviewTransferForm reviewTransfer(ReviewTransferForm form) throws Exception {
        ReviewTransferForm reviewTransferForm = selectReviewById(form.getGuaranteeId());
        if (null != reviewTransferForm){
            examinerReviewDao.reviewTransfer(form);
        }else {
            throw new Exception("担保单未被接收,不能转交");
        }
        return form;
    }

    /**
     * 功能描述: 转交前确认是否已经接收
     *
     * @auther: leice
     * @date: 2018/12/18 17:47
     */
    private ReviewTransferForm selectReviewById(String id) throws Exception{
        ReviewTransferForm form = examinerReviewDao.selectReviewById(id);
        return form;
    }

    /**
     * 功能描述: 接收前确认担保单是否已经被接收
     *
     * @auther: leice
     * @date: 2018/12/18 17:47
     */
    private ReviewTransferForm selectReviewByGuaranteeId(String id) throws Exception{
        ReviewTransferForm form = examinerReviewDao.selectReviewByGuaranteeId(id);
        return form;
    }

    public ReveiceNameModel queryReveiceNameById(QuerySingleGuaranteeInfoForm form) throws Exception{
        ReveiceNameModel reveiceNameModel = examinerReviewDao.queryReveiceNameById(form.getGuaranteeId());
        return reveiceNameModel;
    }

    public ReviewInfoSaveForm warrantyReviewSave(ReviewInfoSaveForm form) throws Exception{
        if (null == form.getAcceptanceOfOpinions()){
            throw new Exception("审查意见不能为空");
        }
        if (form.getType() == 1){
            ReviewInfoSaveForm reviewInfoSaveForm = examinerReviewDao.selectReviewInfoByGuaranteeId(form.getGuaranteeId());
            if (null != reviewInfoSaveForm){
                examinerReviewDao.updateReviewInfoByGuaranteeId(form);
            }else{
                throw new Exception("担保单未被接受,审查失败");
            }
        }else {
            ReviewInfoSaveForm reviewInfoSaveForm = examinerReviewDao.selectReviewInfoByGuaranteeId(form.getGuaranteeId());
            if (null != reviewInfoSaveForm){
                examinerReviewDao.updateReviewInfoByGuaranteeId(form);
                //启动风控审批
                TaskStartForm taskStartForm = new TaskStartForm();
                taskStartForm.setTaskHead("风控审批子流程");
                taskStartForm.setBizCodeStr("43");
                taskStartForm.setBizEntityId(form.getReviewId());
                RequestResult<TaskStartForm> taskStartFormRequestResult = taskFeign.startNewTask(taskStartForm);
                if(!taskStartFormRequestResult.isSuccess()){
                    throw new Exception("启动风控审批子流程失败");
                }
            }else{
                throw new Exception("担保单未被接受,审查失败");
            }
        }

        return form;
    }

    public ReviewInfoSaveForm queryWarrantyReviewInfoById(QuerySingleGuaranteeInfoForm form) throws Exception {
        if (null == form.getGuaranteeId()){
            throw new Exception("查看担保单审查信息,保单id不能为空");
        }
        ReviewInfoSaveForm reviewInfoSaveForm = examinerReviewDao.selectReviewInfoByGuaranteeId(form.getGuaranteeId());
        return reviewInfoSaveForm;
    }

    public Pagination<WindControllerGuaranteeModel> pageQueryWarrantyReview(WindControllerGuaranteeQueryForm form) throws Exception{
        if (null == form.getIsReview()){
            throw new Exception("是否审查不能为空");
        }
        form.setThingCode("SCLB");
        Pagination<WindControllerGuaranteeModel> page = new Pagination(form.getPageSize(),form.getCurrentPage());
        Pagination<WindControllerGuaranteeModel> windControllerGuaranteeModelPagination = examinerReviewDao.pageQueryWarrantyReview(page, form);
        List<WindControllerGuaranteeModel> items = windControllerGuaranteeModelPagination.getItems();
        if (null != items && items.size() > 0){
            for (WindControllerGuaranteeModel item : items) {
                PreviousNodeFinishTimeForm previousNodeFinishTimeForm = new PreviousNodeFinishTimeForm(item.getTaskId(), item.getNodeOrder() - 1);
                PreviousNodeFinishTime previousNodeFinishTime = executiveNoteDao.queryPreviousNodeFinishTime(previousNodeFinishTimeForm);
                String s = examinerReviewDao.queryManageName(item.getAccountManagerId());
                item.setAccountManagerOrg(s);
                if (null != previousNodeFinishTime){
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date parse = sdf.parse(previousNodeFinishTime.getPreviousNodeFinishTime());
                    long time = parse.getTime();
                    Date date = new Date();
                    long time1 = date.getTime();
                    long l = time1 - time;
                    item.setDays(Integer.parseInt(l/(24*60*60*1000)+""));
                }
            }
        }
        return windControllerGuaranteeModelPagination;
    }

    public RefuseWarrantyReviewForm refuseWarrantyReview(RefuseWarrantyReviewForm form) throws Exception{
        // 通过任务id和事项编码查询组装接口所需参数
        RefuseWarrantyReviewModel refuseWarrantyReviewModel = examinerReviewDao.refuseWarrantyReview(form);
        TaskDealRefuseForm taskDealRefuseForm = new TaskDealRefuseForm();
        TaskNodeItemForm taskNodeItemForm = TaskNodeItemForm.newTaskNodeItemForm();
        taskNodeItemForm.setTaskId(form.getTaskId());
        taskNodeItemForm.setNodeId(refuseWarrantyReviewModel.getNodeId());
        taskNodeItemForm.setItemId(refuseWarrantyReviewModel.getItemId());
        taskNodeItemForm.setItemCode(form.getItemCode());
        taskNodeItemForm.setItemResultCode(refuseWarrantyReviewModel.getItemResultCode());
        taskNodeItemForm.setItemFinishPerson(form.getItemFinishPerson());
        taskNodeItemForm.setItemFinishPersonOrgId(form.getItemFinishPersonOrgId());
        taskNodeItemForm.setItemNecessary(refuseWarrantyReviewModel.getItemNecessary());
        taskNodeItemForm.setItemCore(refuseWarrantyReviewModel.getItemCore());
        taskDealRefuseForm.setTaskNodeItem(taskNodeItemForm);
        RequestResult<Boolean> booleanRequestResult = taskFeign.refuseTask(taskDealRefuseForm);
        if(!booleanRequestResult.isSuccess()){
            throw new Exception("驳回流程失败");
        }
        return form;
    }
}
