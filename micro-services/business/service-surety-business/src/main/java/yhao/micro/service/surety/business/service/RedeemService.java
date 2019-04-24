package yhao.micro.service.surety.business.service;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.infra.common.util.CommonListUtil;
import yhao.micro.service.surety.business.apilist.form.redemption.BillingApplySaveForm;
import yhao.micro.service.surety.business.apilist.form.redemption.RedeemSaveForm;
import yhao.micro.service.surety.business.apilist.form.redemption.RedemptionQueryForm;
import yhao.micro.service.surety.business.apilist.form.redemption.RedemptionQueryResultForm;
import yhao.micro.service.surety.business.apilist.model.redemption.BillingApplyModel;
import yhao.micro.service.surety.business.apilist.model.redemption.RedeemModel;
import yhao.micro.service.surety.business.dao.automapper.RedeemDao;
import yhao.micro.service.workflow.apilist.enums.task.TaskStatus;
import yhao.micro.service.workflow.apilist.form.task.TaskStartForm;
import yhao.micro.service.workflow.apilist.restful.TaskFeign;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * @Auther: yuanxy
 * @Date: 2019/1/2 11:12
 * @Description:赎楼管理逻辑实现相关
 */
@Service
public class RedeemService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private RedeemDao redeemDao;
    private DozerBeanMapper dozerMapper = new DozerBeanMapper();
    @Resource
    private TaskFeign taskFeign;


    /**
     * 赎楼管理查询
     */
    public Pagination<RedemptionQueryResultForm> queryRedemptionManager(RedemptionQueryForm form) {
        Pagination<RedemptionQueryResultForm> page = new Pagination<RedemptionQueryResultForm>();
        if (form.getPositionType().equals("no_billing")) { //未出账
            return redeemDao.queryNoBilling(page, form);
        } else if (form.getPositionType().equals("no_redeem")) { //未赎楼
            return redeemDao.queryNoRedeem(page, form);
        } else if (form.getPositionType().equals("redeem")) { //已赎楼
            return redeemDao.queryRedeem(page, form);
        }
        return page;

    }


    /**
     * 出账申请
     */
    @Transactional
    public Boolean billingApply(BillingApplySaveForm form) {
        BillingApplyModel applyModel =new BillingApplyModel();
        dozerMapper.map(form,applyModel);
        applyModel.setCreateOperatorId(form.getCreaterId());
        applyModel.setCreateTime(new Date());
        String id =UUID.randomUUID().toString();
        TaskStartForm taskStartForm = new TaskStartForm();
        taskStartForm.setBizCodeStr("45");
        taskStartForm.setBizEntityId(id);
        RequestResult<TaskStartForm> startResult = taskFeign.startNewTask(taskStartForm);
        if (!startResult.isSuccess()) {
            logger.error("出账申请失败,开启任务失败担保单id:" + form.getGuaranteeId());
            throw new RuntimeException("出账申请失败,请稍后再试");
        }
        applyModel.setId(id);
        applyModel.setTaskId(startResult.pickBody().getId());
        applyModel.setTaskProsess(TaskStatus.RUNNING.toString());
        Integer result =redeemDao.inertInsertApply(applyModel);
        if (result < 1) {
            logger.error("出账申请失败,担保单id" + form.getGuaranteeId());
            throw new RuntimeException("出账申请失败,请稍后再试");
        }
        return true;
    }


    /**
     * 出账申请撤销
     * @param:
     * @return:
     * @auther: yuanxy
     * @date: 2019/3/4 17:00
     */
    public Boolean billingApplyRefund(IdForm form){
        BillingApplyModel applyModel = redeemDao.pickBillingApplyDetail(form);
        if(applyModel!=null && applyModel.getTaskStatus().equals(TaskStatus.END.toString())){
            throw new RuntimeException("出账申请已审批通过,不允许撤销");
        }
        IdForm idForm =new IdForm();
        idForm.setOperatorId(form.getOperatorId());
        idForm.setId(applyModel.getTaskId());
        RequestResult<IdForm> result =taskFeign.stopTask(idForm);
        if(!result.isSuccess()){
            logger.error("出账申请撤销失败,任务id:" + form.getId());
            throw new RuntimeException("出账申请撤销失败,请稍后再试");
        }
        return true;
    }




    /**
     * 担保单全部出账申请记录
     */
    public List<BillingApplyModel> queryApplyRecord(IdForm form) {
        return redeemDao.queryApplyRecord(form);
    }



    /**
     * 赎楼
     */
    public Boolean redemptionSave(RedeemSaveForm form){
        RedeemModel redeemModel =new RedeemModel();
        dozerMapper.map(form,redeemModel);
        Integer result= redeemDao.inertInsertRedeem(redeemModel);
        if (result < 1) {
            logger.error("出账申请失败,担保单id" + form.getGuaranteePid());
            throw new RuntimeException("出账申请失败,请稍后再试");
        }
        return true;

    }

    /**
     * 赎楼详情
     */
    public RedeemModel pickRedeem(IdForm form){
        return redeemDao.pickRedeem(form);
    }

    /**
     * 赎楼记录
     */
    public List<RedeemModel>queryRedeemRecord(IdForm form){
        return redeemDao.queryRedeemRecord(form);
    }

    /**
     *出账申请详情
     * @param:
     * @return:
     * @auther: yuanxy
     * @date: 2019/2/14 17:37
     */
   public BillingApplyModel pickBillingApplyDetail(IdForm form){
        return redeemDao.pickBillingApplyDetail(form);
   }




}
