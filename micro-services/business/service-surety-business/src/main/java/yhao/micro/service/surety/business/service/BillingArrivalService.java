package yhao.micro.service.surety.business.service;

import org.apache.commons.lang.StringUtils;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.infra.common.util.CommonDateUtil;
import yhao.micro.service.constants.enums.YNEnum;
import yhao.micro.service.surety.business.apilist.form.finance.*;
import yhao.micro.service.surety.business.apilist.model.finance.FinanceArrivalDetailModel;
import yhao.micro.service.surety.business.apilist.model.finance.FinanceArrivalGeneralModel;
import yhao.micro.service.surety.business.apilist.model.finance.FinanceBillingDetailModel;
import yhao.micro.service.surety.business.apilist.model.finance.FinanceBillingGeneralModel;
import yhao.micro.service.surety.business.apilist.model.redemption.RedeemModel;
import yhao.micro.service.surety.business.dao.automapper.FinanceBillingArrivalDao;
import yhao.micro.service.surety.business.dao.automapper.FinanceFundPlanDao;
import yhao.micro.service.surety.business.dao.automapper.RedeemDao;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * @Auther: yuanxy
 * @Date: 2019/1/8 15:58
 * @Description:到账出账逻辑实现
 */
@Service
public class BillingArrivalService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private FinanceBillingArrivalDao billingArrivalDao;
    @Resource
    private FinanceFundPlanDao fundPlanDao;
    @Resource
    private RedeemDao redeemDao;

    private DozerBeanMapper dozerMapper = new DozerBeanMapper();


    /**
     * 到账出账列表分页查询
     *
     * @param:
     * @return:
     * @auther: yuanxy
     * @date: 2019/2/26 11:41
     */

    public Pagination<FinanceArrivalBillingQueryResultForm> queryFundArrivalBilling(FinanceArrivalBillingQueryForm form) {
        Pagination<FinanceArrivalBillingQueryResultForm> page = new Pagination<FinanceArrivalBillingQueryResultForm>();
        //到账查询
        if ("arrival".equals(form.getPositionType())) {
            billingArrivalDao.queryArrival(page, form);
        } else if ("billing".equals(form.getPositionType())) { //出账查询
            billingArrivalDao.queryBilling(page, form);
        }
        return page;
    }


    /**
     * 新增到账
     *
     * @param:
     * @return:
     * @auther: yuanxy
     * @date: 2019/1/8 16:57
     */
    @Transactional
    public Boolean fundArrivalSave(FinanceArrivalSaveForm form) {
        FinanceArrivalGeneralModel arrivalGeneralModel = billingArrivalDao.pickArrivalGeneral(form.getGuaranteeId());
        if (arrivalGeneralModel != null) {
            updArrivalGeneral(form, "add");
            if (StringUtils.isNotBlank(form.getId())) {
                FinanceArrivalDetailModel arrivalDetailModel = billingArrivalDao.pickArrivalDetail(form.getId());
                arrivalDetailModel.setUpdateOperatorId(form.getOperatorId());
                arrivalDetailModel.setUpdateTime(new Date());
                Integer result = billingArrivalDao.updateArrivalDetail(arrivalDetailModel);
                if (result < 1) {
                    logger.error("修改到账失败,担保单id" + form.getGuaranteeId());
                    throw new RuntimeException("修改到账失败,请稍后再试");
                }

            } else {
                FinanceArrivalDetailModel arrivalDetailModel = new FinanceArrivalDetailModel();
                dozerMapper.map(form, arrivalDetailModel);
                arrivalDetailModel.setArrivalGeneralId(arrivalGeneralModel.getId());
                arrivalDetailModel.setCreateTime(new Date());
                arrivalDetailModel.setId(UUID.randomUUID().toString());
                arrivalDetailModel.setCreateOperatorId(form.getOperatorId());
                arrivalDetailModel.setIsDelete(YNEnum.NO);
                Integer result = billingArrivalDao.insertArrivalDetail(arrivalDetailModel);
                if (result < 1) {
                    logger.error("新增到账失败,担保单id" + form.getGuaranteeId());
                    throw new RuntimeException("新增到账失败,请稍后再试");
                }
            }
            return true;

        }
        arrivalGeneralModel = new FinanceArrivalGeneralModel();
        dozerMapper.map(form, arrivalGeneralModel);
        arrivalGeneralModel.setId(UUID.randomUUID().toString());
        arrivalGeneralModel.setCreateTime(new Date());
        arrivalGeneralModel.setCreateOperatorId(form.getOperatorId());
        arrivalGeneralModel.setArrivalTotalAmount(form.getArrivalAmount());
        Integer generalResult = billingArrivalDao.insertArrivalGeneral(arrivalGeneralModel);

        FinanceArrivalDetailModel arrivalDetailModel = new FinanceArrivalDetailModel();
        dozerMapper.map(form, arrivalDetailModel);
        arrivalDetailModel.setArrivalGeneralId(arrivalGeneralModel.getId());
        arrivalDetailModel.setCreateTime(new Date());
        arrivalDetailModel.setId(UUID.randomUUID().toString());
        arrivalDetailModel.setCreateOperatorId(form.getOperatorId());
        arrivalDetailModel.setIsDelete(YNEnum.NO);
        Integer result = billingArrivalDao.insertArrivalDetail(arrivalDetailModel);


        if (result < 1 || generalResult < 1) {
            logger.error("新增到账失败,担保单id" + form.getGuaranteeId());
            throw new RuntimeException("新增到账失败,请稍后再试");
        }
        return true;

    }


    /**
     * 到账详情
     *
     * @param:
     * @return:
     * @auther: yuanxy
     * @date: 2019/1/8 17:20
     */
    public FinanceArrivalDetailModel pickFundArrival(IdForm form) {
        return billingArrivalDao.pickArrivalDetail(form.getId());
    }




    /**
     * 删除到账
     *
     * @param:
     * @return:
     * @auther: yuanxy
     * @date: 2019/1/11 15:53
     */
    public Boolean fundArrivalDel(IdForm form) {
        FinanceArrivalDetailModel arrivalDetailModel = billingArrivalDao.pickArrivalDetail(form.getId());
        if(arrivalDetailModel ==null || arrivalDetailModel.getGuaranteeId() ==null){
            throw new RuntimeException("到账不存在,请检查数据");
        }
        FinanceArrivalSaveForm saveForm = new FinanceArrivalSaveForm();
        saveForm.setArrivalAmount(arrivalDetailModel.getArrivalAmount());
        saveForm.setGuaranteeId(arrivalDetailModel.getGuaranteeId());
        //更新到账概况
        updArrivalGeneral(saveForm, "subtract");
        arrivalDetailModel.setIsDelete(YNEnum.YES);
        arrivalDetailModel.setUpdateTime(new Date());
        arrivalDetailModel.setUpdateOperatorId(form.getOperatorId());
        Integer result = billingArrivalDao.updateArrivalDetail(arrivalDetailModel);
        if (result < 1) {
            logger.error("更新到账概况失败,请稍后再试,担保单id:" + saveForm.getGuaranteeId());
            throw new RuntimeException("更新到账概况失败,请稍后再试");
        }
        return true;

    }

    /**
     * 更新到账概况
     *
     * @param:
     * @return:
     * @auther: yuanxy
     * @date: 2019/1/11 16:15
     */
    private void updArrivalGeneral(FinanceArrivalSaveForm saveForm, String operationType) {
        FinanceArrivalGeneralModel arrivalGeneralModel = billingArrivalDao.pickArrivalGeneral(saveForm.getGuaranteeId());
        BigDecimal arrivalAmount = operationType.equals("add") ? arrivalGeneralModel.getArrivalTotalAmount().add(saveForm.getArrivalAmount()) :
                arrivalGeneralModel.getArrivalTotalAmount().subtract(saveForm.getArrivalAmount());
        arrivalGeneralModel.setArrivalTotalAmount(arrivalAmount);
        arrivalGeneralModel.setUpdateTime(new Date());
        arrivalGeneralModel.setUpdateOperatorId(saveForm.getOperatorId());
        Integer result = billingArrivalDao.updateArrivalGeneral(arrivalGeneralModel);
        if (result < 1) {
            logger.error("更新到账概况失败,请稍后再试,担保单id:" + saveForm.getGuaranteeId());
            throw new RuntimeException("更新到账概况失败,请稍后再试");
        }
    }


    /**
     * 确认到账
     *
     * @param:
     * @return:
     * @auther: yuanxy
     * @date: 2019/1/11 10:21
     */
    public Boolean confirmArrival(IdForm form) {
        form.setOperatorTime(new Date());
        Integer result = billingArrivalDao.confirmArrival(form);
        if (result < 1) {
            logger.error("确认到账失败,请稍后再试,担保单id:" + form.getId());
            throw new RuntimeException("确认到账失败,请稍后再试");
        }
        return true;
    }

    /**
     * 到账查询
     * @param:
     * @return:
     * @auther: yuanxy
     * @date: 2019/3/8 9:48
     */
    public List<FinanceArrivalQueryResultForm> queryFundArrival(IdForm form) {
        return billingArrivalDao.queryFundArrival(form);
    }




    /************************************************出账开始********************************************************************/

    /**
     * 出账保存
     *
     * @param:
     * @return:
     * @auther: yuanxy
     * @date: 2019/1/14 15:25
     */
    @Transactional
    public Boolean fundBillingSave(FinanceBillingSaveForm form) {
        FinanceBillingGeneralModel billingModel = billingArrivalDao.pickBillingGeneral(form.getGuaranteeId());
        if (billingModel != null) {
            updBillingGeneral(form, "add");
            if (form.getId() != null) {
                FinanceBillingDetailModel detailModel = billingArrivalDao.pickBillingDetail(form.getId());
                dozerMapper.map(form, detailModel);
                detailModel.setUpdateOperatorId(form.getOperatorId());
                detailModel.setUpdateTime(new Date());
                Integer result = billingArrivalDao.updateBillingDetail(detailModel);
                if (result < 1) {
                    logger.error("更新出账详情失败,请稍后再试,担保单id:" + form.getGuaranteeId());
                    throw new RuntimeException("更新出账详情失败,请稍后再试");
                }
            } else {
                Integer detailResult = billingArrivalDao.insertBillingDetail(form);
                if (detailResult < 1) {
                    logger.error("新增出账详情失败,请稍后再试,担保单id:" + form.getGuaranteeId());
                    throw new RuntimeException("新增出账详情失败,请稍后再试");
                }
            }
            return true;

        }

        billingModel.setFirstBillingDate(new Date());
        billingModel.setCreateOperatorId(form.getOperatorId());
        billingModel.setCreateTime(new Date());
        Integer result = billingArrivalDao.insertBillingGeneral(billingModel);
        Integer detailResult = billingArrivalDao.insertBillingDetail(form);
        if (result < 1 || detailResult < 1) {
            logger.error("新增出账详情失败,请稍后再试,担保单id:" + form.getGuaranteeId());
            throw new RuntimeException("新增出账详情失败,请稍后再试");
        }
        return true;
    }


    /**
     * 修改出账概况
     *
     * @param:
     * @return:
     * @auther: yuanxy
     * @date: 2019/1/14 15:38
     */
    private void updBillingGeneral(FinanceBillingSaveForm form, String operationType) {
        FinanceBillingGeneralModel billingModel = billingArrivalDao.pickBillingGeneral(form.getGuaranteeId());

        BigDecimal totalAmount = "add".equals(operationType) ? billingModel.getTotalBillingAmount().add(form.getBilLingAmount()) :
                billingModel.getTotalBillingAmount().subtract(form.getBilLingAmount());
        //修改出账的时候，减去原来的金额
        if (form.getId() != null) {
            FinanceBillingDetailModel detailModel = billingArrivalDao.pickBillingDetail(form.getId());
            totalAmount = totalAmount.subtract(detailModel.getBilLingAmount());
        }
        billingModel.setTotalBillingAmount(totalAmount);
        billingModel.setUpdateOperatorId(form.getOperatorId());
        billingModel.setUpdateTime(new Date());
        Integer result = billingArrivalDao.updateBillingGeneral(billingModel);
        if (result < 1) {
            logger.error("更新出账概况失败,请稍后再试,担保单id:" + form.getGuaranteeId());
            throw new RuntimeException("更新出账概况失败,请稍后再试");
        }
    }

    /**
     * 出账详情
     *
     * @param:
     * @return:
     * @auther: yuanxy
     * @date: 2019/1/14 16:33
     */
    public FinanceBillingDetailModel pickBillingDetail(IdForm form) {
        return billingArrivalDao.pickBillingDetail(form.getId());
    }

    /**
     * 确认出账
     *
     * @return:
     * @auther: yuanxy
     * @date: 2019/1/14 16:34
     */
    public Boolean confirmBilling(IdForm form) {
        Integer result = billingArrivalDao.confirmBilling(form.getId());
        if (result < 1) {
            logger.error("更新确认出账失败,请稍后再试,担保单id:" + form.getId());
            throw new RuntimeException("更新确认出账失败,请稍后再试");
        }

        return true;
    }

    /**
     * 出账概况
     *
     * @param:
     * @return:
     * @auther: yuanxy
     * @date: 2019/1/14 17:51
     */
    public FinanceBillingGeneralResultForm pickBillingGeneral(IdForm form) {
        FinanceBillingGeneralResultForm result = new FinanceBillingGeneralResultForm();
        result.setBillingTotalAmount(new BigDecimal(0));
        result.setBillingBalance(new BigDecimal(0));
        FinanceArrivalGeneralModel arrivalGeneralModel = billingArrivalDao.pickArrivalGeneral(form.getId());
        result.setArrivalTotalAmount(arrivalGeneralModel.getArrivalTotalAmount());
        FinanceBillingGeneralModel billingGeneralModel = billingArrivalDao.pickBillingGeneral(form.getId());
        if (billingGeneralModel != null) {
            result.setBillingTotalAmount(billingGeneralModel.getTotalBillingAmount());
            result.setBillingBalance(billingGeneralModel.getBalance());
        }

        return result;
    }


    /**
     * 转回出账查询
     *
     * @param:
     * @return:
     * @auther: yuanxy
     * @date: 2019/3/7 19:30
     */
    public List<FinanceBillingQueryResultBizForm> queryFundBilling(IdForm form) {
        return billingArrivalDao.queryFundBilling(form);
    }


    /**
     * 出账转回金额
     *
     * @param:
     * @return:
     * @auther: yuanxy
     * @date: 2019/1/25 11:01
     */
    @Transactional
    public Boolean rewind(RewindSaveForm form) {
        FinanceBillingGeneralModel billingGeneralModel = billingArrivalDao.pickBillingGeneral(form.getGuaranteeId());
        if (billingGeneralModel == null) {
            logger.error("出账概况不存在，保单id" + form.getGuaranteeId());
            throw new RuntimeException("暂不能转回，请稍后再试");
        }

        List<String>ids =Arrays.asList(form.getBillingIds().split(","));
        billingGeneralModel.setUpdateTime(new Date());
        billingGeneralModel.setUpdateOperatorId(form.getOperatorId());
        billingGeneralModel.setTotalBillingAmount(billingGeneralModel.getTotalBillingAmount().subtract(form.getRewindAmount()));
        if(CommonDateUtil.daysBetween(billingGeneralModel.getFirstBillingDate(),form.getRewindDate()) ==0){
            billingGeneralModel.setFirstBillingDate(null);
            billingArrivalDao.updateFirstBillingDate(billingGeneralModel);
        }else {
            billingArrivalDao.updateBillingGeneral(billingGeneralModel);
        }

        billingArrivalDao.batchBillingDel(ids);

        return true;
    }



}
