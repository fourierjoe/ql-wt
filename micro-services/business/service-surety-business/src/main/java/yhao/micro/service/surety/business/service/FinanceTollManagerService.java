package yhao.micro.service.surety.business.service;

import org.apache.commons.lang.StringUtils;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.infra.common.util.CommonListUtil;
import yhao.micro.service.surety.business.apilist.form.finance.*;
import yhao.micro.service.surety.business.apilist.model.enums.finance.ChargeStatusEnum;
import yhao.micro.service.surety.business.apilist.model.enums.finance.ChargeType;
import yhao.micro.service.surety.business.apilist.model.finance.FinanceTollDetailModel;
import yhao.micro.service.surety.business.apilist.model.finance.FinanceTollGeneralModel;
import yhao.micro.service.surety.business.apilist.model.guarantee.output.LoanDetailsModel;
import yhao.micro.service.surety.business.dao.automapper.FinanceFundBackDao;
import yhao.micro.service.surety.business.dao.automapper.FinanceTollManagerDao;
import yhao.micro.service.workflow.apilist.enums.task.TaskStatus;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Auther: yuanxy
 * @Date: 2019/1/8 20:34
 * @Description:
 */
@Service
public class FinanceTollManagerService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private FinanceTollManagerDao tollManagerDao;
    @Resource
    private FinanceFundBackDao fundBackDao;


    private DozerBeanMapper dozerMapper = new DozerBeanMapper();




    /**
     * 收费管理查询
     * @param:
     * @return:
     * @auther: yuanxy
     * @date: 2019/2/28 16:56
     */
    public Pagination<FinanceTollQueryResultForm> queryCharge(FinanceTollQueryForm form){
        Pagination<FinanceTollQueryResultForm> page =new Pagination<FinanceTollQueryResultForm>();
        if("WARRANTY".equals(form.getPositionType())){
            tollManagerDao.queryWarranty(page,form);
        }else if("DELAY".equals(form.getPositionType())){
            tollManagerDao.queryDelay(page,form);
        }else if("OVERDUE".equals(form.getPositionType())){
            tollManagerDao.queryOverdue(page,form);
            if(page!=null &&page.getItems()!=null &&CommonListUtil.isEmpty(page.getItems())){
                page.getItems().forEach(resultForm -> {
                    resultForm.setBalanceAmount(resultForm.getRealNomalAmount().subtract(resultForm.getTollTatalAmount()));
                });

            }
        }
        return page;

    }












    /**
     * 收费保存
     *
     * @param:
     * @return:
     * @auther: yuanxy
     * @date: 2019/1/8 20:36
     */
    @Transactional
    public Boolean tollSave(FinanceTollSaveForm form) {
        FinanceTollGeneralModel tollGeneralModel = tollManagerDao.pickTollGeneral(form.getGuaranteeId());
        if (tollGeneralModel != null) {
            updateToll(form, "add");
            if (form.getId() != null) {
                FinanceTollDetailModel detailModel = tollManagerDao.pickTollDetail(form.getId());
                dozerMapper.map(form, detailModel);
                detailModel.setUpdateOperatorId(form.getOperatorId());
                detailModel.setUpdateTime(new Date());
                Integer detailResult = tollManagerDao.updateTollDetail(detailModel);
                if (detailResult < 1) {
                    logger.error("修改" + form.getChargeType().name() + "失败,请稍后再试");
                    throw new RuntimeException("修改" + form.getChargeType().name() + "失败,请稍后再试");
                }
            } else {
                form.setId(UUID.randomUUID().toString());
                form.setOperatorTime(new Date());
                Integer detailResult = tollManagerDao.insertTollDetail(form);
                if (detailResult < 1) {
                    logger.error("新增" + form.getChargeType().name() + "失败,请稍后再试");
                    throw new RuntimeException("新增" + form.getChargeType().name() + "失败,请稍后再试");
                }
            }

            return true;
        }
        tollGeneralModel = new FinanceTollGeneralModel();
        dozerMapper.map(form, tollGeneralModel);
        if (ChargeType.DELAY.toString().equals(form.getChargeType().name())) {
            tollGeneralModel.setWarrantyStatus(ChargeStatusEnum.NO_CONFIRM);
            tollGeneralModel.setDelayTotalAmount(form.getTollAmount());
        } else if (ChargeType.OVERDUE.toString().equals(form.getChargeType().name())) {
            tollGeneralModel.setOverdueTotalAmount(form.getTollAmount());
            tollGeneralModel.setOverdueStatus(ChargeStatusEnum.NO_CONFIRM);
        } else if (ChargeType.WARRANTY.toString().equals(form.getChargeType().name())) {
            tollGeneralModel.setWarrantyTotalAmount(form.getTollAmount());
            tollGeneralModel.setWarrantyStatus(ChargeStatusEnum.NO_CONFIRM);
        }
        tollGeneralModel.setCreateTime(new Date());
        tollGeneralModel.setId(UUID.randomUUID().toString());
        tollGeneralModel.setCreateOperatorId(form.getOperatorId());
        Integer result = tollManagerDao.insertTollGeneral(tollGeneralModel);

        form.setId(UUID.randomUUID().toString());
        form.setOperatorTime(new Date());
        Integer detailResult = tollManagerDao.insertTollDetail(form);
        if (result < 1 || detailResult < 1) {
            logger.error("新增" + form.getChargeType().name() + "失败,请稍后再试");
            throw new RuntimeException("新增" + form.getChargeType().name() + "失败,请稍后再试");
        }

        return true;
    }


    /**
     * 收费记录
     *
     * @param: [form]
     * @return: java.util.List<yhao.micro.service.surety.business.apilist.model.finance.FinanceTollDetailModel>
     * @auther: yuanxy
     * @date: 2019/1/9 14:27
     */
    public List<FinanceTollDetailModel> queryTollRecord(IdForm form) {
        return tollManagerDao.queryTollDetail(form.getId());
    }

    /**
     * 借款明细
     *
     * @param:
     * @return:
     * @auther: yuanxy
     * @date: 2019/1/9 16:42
     */
    public GeneralLoanDetailQueryResultForm queryLoanDetail(IdForm form) {
        GeneralLoanDetailQueryResultForm resultForm = tollManagerDao.pickLoanGeneral(form.getId());
        resultForm.setBalanceAmount(resultForm.getTotalReceivable().subtract(resultForm.getRealTotalCharges()));
        return resultForm;
    }


    /**
     * 担保费确认收费
     *
     * @param: [form]
     * @return: java.lang.Boolean
     * @auther: yuanxy
     * @date: 2019/1/9 17:22
     */
    public Boolean confirmToll(FinanceTollConfirmSaveForm form) {
        //检查收费情况 1 是否有未结束打折申请 2 实收金额>担保费应收合计 TODO
        checkTollSituation(form);

        form.setOperatorTime(new Date());
        Integer result = tollManagerDao.confirmToll(form);
        if (result < 1) {
            logger.error("确认收费失败,请稍后再试");
            throw new RuntimeException("确认收费失败,请稍后再试");
        }
        return true;
    }


    //检查收费情况
    private void checkTollSituation(FinanceTollConfirmSaveForm form) {
        GeneralLoanDetailQueryResultForm resultForm = tollManagerDao.pickLoanGeneral(form.getGuaranteeId());
        FinanceTollGeneralModel tollGeneralModel = tollManagerDao.pickTollGeneral(form.getGuaranteeId());
        if (tollGeneralModel != null && resultForm != null && (tollGeneralModel.getWarrantyTotalAmount().compareTo(resultForm.getTotalReceivable()) < 0)) {
            logger.error("实收金额小于应收金额,不可确认收费" + form.getGuaranteeId());
            throw new RuntimeException("实收金额小于应收金额,不可确认收费！！！");
        }
        //是否有未结束打折申请
       String taskStatus = tollManagerDao.pickDiscountApplication(form.getGuaranteeId());
       if(StringUtils.isNotBlank(taskStatus) && !TaskStatus.END.toString().equals(taskStatus)){
           logger.error("担保单的打折申请审批中,不可确认收费" + form.getGuaranteeId());
           throw new RuntimeException("担保单的打折申请审批中,不可确认收费！！！");
       }

    }


    /**
     * 删除收费
     *
     * @param:
     * @return:
     * @auther: yuanxy
     * @date: 2019/1/9 17:33
     */
    @Transactional
    public Boolean tollDel(FinanceTollDelForm form) {
        FinanceTollSaveForm saveForm = new FinanceTollSaveForm();
        dozerMapper.map(form, saveForm);
        Boolean result = updateToll(saveForm, "subtract");
        Integer delResult = tollManagerDao.delTollDetail(form.getId());
        if (result == null || !result || delResult < 1) {
            logger.error("删除收费失败,请稍后再试,担保单id:" + saveForm.getGuaranteeId());
            throw new RuntimeException("删除收费失败,请稍后再试");
        }
        return true;
    }

    /**
     * 更新收费概况
     */
    private Boolean updateToll(FinanceTollSaveForm form, String operationType) {
        FinanceTollGeneralModel generalModel = tollManagerDao.pickTollGeneral(form.getGuaranteeId());
        BigDecimal subtractAmount = null;
        if (form.getId() != null) {
            FinanceTollDetailModel detailModel = tollManagerDao.pickTollDetail(form.getId());
            subtractAmount = detailModel.getHandlingFee() != null ? detailModel.getTollAmount().add(detailModel.getHandlingFee()) : detailModel.getTollAmount();
        }

        generalModel.setUpdateOperatorId(form.getOperatorId());
        generalModel.setUpdateTime(new Date());
        if (ChargeType.DELAY.toString().equals(form.getChargeType().name())) {
            BigDecimal totalAmount = operationType.equals("add") ? generalModel.getDelayTotalAmount().add(form.getTollAmount()) :
                    generalModel.getDelayTotalAmount().subtract(form.getTollAmount());
            if (subtractAmount != null) {
                totalAmount = totalAmount.subtract(subtractAmount);
            }
            generalModel.setDelayTotalAmount(totalAmount);

        } else if (ChargeType.OVERDUE.toString().equals(form.getChargeType().name())) {
            BigDecimal totalAmount = operationType.equals("add") ? generalModel.getOverdueTotalAmount().add(form.getTollAmount()) :
                    generalModel.getOverdueTotalAmount().subtract(form.getTollAmount());
            if (subtractAmount != null) {
                totalAmount = totalAmount.subtract(subtractAmount);
            }
            generalModel.setOverdueTotalAmount(totalAmount);
        } else if (ChargeType.WARRANTY.toString().equals(form.getChargeType().name())) {
            if (form.getHandlingFee() != null) {
                form.getTollAmount().add(form.getHandlingFee());
            }
            BigDecimal totalAmount = operationType.equals("add") ? generalModel.getWarrantyTotalAmount().add(form.getTollAmount()) :
                    generalModel.getWarrantyTotalAmount().subtract(form.getTollAmount());

            if (subtractAmount != null) {
                totalAmount = totalAmount.subtract(subtractAmount);
            }
            generalModel.setWarrantyTotalAmount(totalAmount);
        }

        Integer result = tollManagerDao.updateTollGeneral(generalModel);
        if (result < 1) {
            logger.error("修改" + form.getChargeType().name() + "失败,请稍后再试");
            throw new RuntimeException("修改" + form.getChargeType().name() + "失败,请稍后再试");
        }
        return true;
    }


    /**
     * 收费详情
     *
     * @param: [form]
     * @return: yhao.micro.service.surety.business.apilist.model.finance.FinanceTollDetailModel
     * @auther: yuanxy
     * @date: 2019/1/10 11:13
     */
    public FinanceTollDetailModel pickTollDetail(IdForm form) {
        return tollManagerDao.pickTollDetail(form.getId());

    }


    /**
     *
     * @param: 展期申请消费记录
     * @return:
     * @auther: yuanxy
     * @date: 2019/2/21 15:12
     */
    public List<ConsumeRecordResultForm> queryConsumeRecord(IdForm form){

        List<ConsumeRecordResultForm> consumeList = tollManagerDao.queryConsumeRecord(form);
        if(!CommonListUtil.isEmpty(consumeList)){
            consumeList.forEach(consume ->{
                if(!CommonListUtil.isEmpty(consume.getConsumeDetailList())){
                    List<ConsumeRecordDetailForm> detailFormList =consume.getConsumeDetailList();
                    detailFormList.forEach(detail ->{
                        consume.setTotalFees(consume.getTotalFees().add(detail.getFee()));
                    });
                }

            });
        }

        return consumeList;
    }



    /**
     *
     * @param:
     * @return:
     * @auther: yuanxy
     * @date: 2019/3/1 16:43
     */
   public CostGeneralResultForm costGeneral(IdForm form){
       CostGeneralResultForm resultForm = new CostGeneralResultForm();
       BigDecimal totalFee =fundBackDao.pickTotalFee(form.getId());
       FinanceTollGeneralModel generalModel =tollManagerDao.pickTollGeneral(form.getId());
       if(generalModel !=null && StringUtils.isNotBlank(generalModel.getId())){
           resultForm.setTotalToll(generalModel.getDelayTotalAmount().add(generalModel.getOverdueTotalAmount()).add(generalModel.getWarrantyTotalAmount()));
       }

       if(resultForm.getTotalToll().compareTo(totalFee) >=0){
           resultForm.setRefundAmount(resultForm.getTotalToll().subtract(totalFee));
       }else {
           resultForm.setBalance(totalFee.subtract(resultForm.getTotalToll()));
       }

       return resultForm;

   }










}
