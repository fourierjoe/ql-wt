package yhao.micro.service.surety.business.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.infra.common.util.CommonDateUtil;
import yhao.infra.common.util.CommonListUtil;
import yhao.micro.service.surety.business.apilist.form.businessType.OverdueRateParseForm;
import yhao.micro.service.surety.business.apilist.form.finance.*;
import yhao.micro.service.surety.business.apilist.model.ExtensionApplicationModel;
import yhao.micro.service.surety.business.apilist.model.finance.FundPayBackDetailModel;
import yhao.micro.service.surety.business.apilist.model.finance.FundPayBackGeneralModel;
import yhao.micro.service.surety.business.apilist.model.guarantee.output.LoanDetailsModel;
import yhao.micro.service.surety.business.apilist.model.guarantee.output.TransactionTypeReceivePaymentPlanModel;
import yhao.micro.service.surety.business.dao.automapper.ExtensionApplicationDao;
import yhao.micro.service.surety.business.dao.automapper.FinanceFundBackDao;
import yhao.micro.service.surety.business.dao.automapper.GuaranteeDao;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * @Auther: yuanxy
 * @Date: 2019/1/25 15:27
 * @Description: 资金回款逻辑相关
 */
@Service
public class FinancePayBackService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private DozerBeanMapper dozerMapper = new DozerBeanMapper();

    @Resource
    private FinanceFundBackDao fundBackDao;
    @Resource
    private ExtensionApplicationDao extensionApplicationDao;
    @Resource
    private GuaranteeDao guaranteeDao;


    /**
     * 资金回款列表查询
     *
     * @param:
     * @return:
     * @auther: yuanxy
     * @date: 2019/1/25 15:37
     */
    public Pagination<FundPayBackQueryResultForm> queryFundPayBack(FundPaybackQueryForm form) {
        Pagination<FundPayBackQueryResultForm> page = new Pagination<FundPayBackQueryResultForm>();
        fundBackDao.queryFundPayBack(page, form);
        List<LoanDetailsModel> noSetTotalLoans = new ArrayList<LoanDetailsModel>();
        if (!CommonListUtil.isEmpty(page.getItems())) {
            List<String> guaranteeIds = new ArrayList<String>();
            page.getItems().forEach(resultForm -> {
                guaranteeIds.add(resultForm.getId());
                noSetTotalLoans.addAll(resultForm.getLoanDetails());
            });
            //查询每笔借款回款总金额
            List<LoanPayBackTotalQueryForm> payBackTotalList = fundBackDao.queryFundPayBackLoanTotal(guaranteeIds);
            if (!CommonListUtil.isEmpty(payBackTotalList)) {
                for (LoanPayBackTotalQueryForm totalResult : payBackTotalList) {
                    page.getItems().forEach(resultForm -> {
                        resultForm.getLoanDetails().forEach(details -> {
                            if (totalResult.getLoanId().equals(details.getId())) {
                                details.setRepayTotalAmount(totalResult.getPayBackTotalAmount());
                            }
                        });
                    });
                }
            }

        }
        return page;
    }

    /**
     * 回款查询（弹窗）
     *
     * @param: IdForm id为借款id
     * @return:
     * @auther: yuanxy
     * @date: 2019/1/25 15:44
     */
    public FinancePaybackPickResultForm fundPayBackPick(FundPayBackRecordQueryForm form) {
        FinancePaybackPickResultForm resultForm = new FinancePaybackPickResultForm();
        List<FundPayBackDetailModel> payBackDetailList = fundBackDao.queryFundPayBackRecord(form);
        BigDecimal totalPayBackAmount = new BigDecimal(0);
        if (payBackDetailList != null && !payBackDetailList.isEmpty()) {
            resultForm.setPayBackModelList(payBackDetailList);
            for (FundPayBackDetailModel model : payBackDetailList) {
                totalPayBackAmount = totalPayBackAmount.add(model.getRepayAmount());
            }
        }
        resultForm.setPayBackTotalAmount(totalPayBackAmount);
        resultForm.setPayBackBalanceAmount(form.getLoanAmount().subtract(totalPayBackAmount));

        return resultForm;

    }


    /**
     * 新增回款
     *
     * @param:
     * @return:
     * @auther: yuanxy
     * @date: 2019/1/25 17:10
     */
    @Transactional
    public Boolean fundPayBackSave(FundPayBackSaveForm form) {
        FundPayBackGeneralModel payBackGeneral = fundBackDao.pickPayBackGeneral(form.getGuaranteeId());
        FundPayBackDetailModel detailModel = new FundPayBackDetailModel();
        dozerMapper.map(form, detailModel);
        Date date = new Date();
        if (payBackGeneral == null) {
            payBackGeneral = new FundPayBackGeneralModel();
            payBackGeneral.setId(UUID.randomUUID().toString());
            payBackGeneral.setCreateTime(date);
            payBackGeneral.setGuaranteeId(form.getGuaranteeId());
            payBackGeneral.setCreateOperatorId(form.getOperatorId());
            payBackGeneral.setRepayTotalAmount(form.getRepayAmount());
            payBackGeneral.setRepayBalance(form.getLoanTotalAmount().subtract(form.getRepayAmount()));
            fundBackDao.insertFundPayBackGeneral(payBackGeneral);
        } else {
            //编辑回款
            if (form.getId() != null) {
                detailModel = fundBackDao.pickPayBackDetail(form.getId());
                payBackGeneral.setRepayTotalAmount(payBackGeneral.getRepayTotalAmount().subtract(detailModel.getRepayAmount()).add(form.getRepayAmount()));
                payBackGeneral.setRepayBalance(form.getLoanTotalAmount().add(detailModel.getRepayAmount()).subtract(form.getRepayAmount()));
                fundBackDao.updatePayBackGeneral(payBackGeneral);
                //设置回款收费情况
                setPayBackDetailModel(detailModel, form, date);
                detailModel.setRepayDate(form.getPaybackDate());
                detailModel.setUpdateOperatorId(form.getOperatorId());
                detailModel.setCreateTime(date);
                fundBackDao.updateFundPayBackDetail(detailModel);
                updateLoanSituation(form, "subtract", detailModel.getRepayAmount());
                return true;
            } else {
                payBackGeneral.setRepayTotalAmount(payBackGeneral.getRepayTotalAmount().add(form.getRepayAmount()));
                payBackGeneral.setRepayBalance(form.getLoanTotalAmount().subtract(form.getRepayAmount()));
                fundBackDao.updatePayBackGeneral(payBackGeneral);
            }

        }
        //设置回款收费情况
        setPayBackDetailModel(detailModel, form, date);

        detailModel.setId(UUID.randomUUID().toString());
        detailModel.setCreateTime(new Date());
        detailModel.setRepayDate(form.getPaybackDate());
        detailModel.setCreateOperatorId(form.getOperatorId());
        detailModel.setUseDays(CommonDateUtil.daysBetween(form.getArrangedRepay(),form.getPaybackDate()));
        fundBackDao.insertFundPayBackDetail(detailModel);

        //更新借款明细
        updateLoanSituation(form, "subtract", null);

        return true;

    }

    /**
     * 设置回款收费情况
     *
     * @param:
     * @return:
     * @auther: yuanxy
     * @date: 2019/2/21 20:31
     */
    private FundPayBackDetailModel setPayBackDetailModel(FundPayBackDetailModel detailModel, FundPayBackSaveForm form, Date date) {
        detailModel.setWarranty(new BigDecimal(0));
        detailModel.setOverdue(new BigDecimal(0));
        detailModel.setDelay(new BigDecimal(0));
        //查询借款费率和逾期费率
        FinanceFeeRateResultForm feeRate = fundBackDao.pickFeeRate(form.getLoanId());
        Long useDays = CommonDateUtil.secondBetween(feeRate.getFirstBillingDate(), date);
        try {
            detailModel.setWarranty(form.getRepayAmount().multiply(new BigDecimal(useDays))
                    .multiply(new BigDecimal(feeRate.getLoanFeeRate()))
                    .divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP));
            detailModel.setWarrantyRate(feeRate.getLoanFeeRate());
        } catch (Exception e) {
            logger.error("计算担保费时出错,担保单id" + form.getGuaranteeId());
            throw new RuntimeException("新增回款失败,请稍后再试");
        }
        //设置逾期天数
        int overdueDays;
        //设置展期费
        List<ExtensionApplicationModel> delayApplyList = extensionApplicationDao.findExtensionByLoanId(form.getLoanId());
        if (delayApplyList != null && !delayApplyList.isEmpty()) {
            ExtensionApplicationModel applyModel = delayApplyList.get(0);
            try {
                detailModel.setDelay(form.getRepayAmount().multiply(new BigDecimal(useDays))
                        .multiply(new BigDecimal(applyModel.getDailyRate()))
                        .divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP));
                detailModel.setDelayRate(applyModel.getDailyRate());
            } catch (Exception e) {
                logger.error("计算展期费时出错,担保单id" + form.getGuaranteeId());
                throw new RuntimeException("新增回款失败,请稍后再试");
            }

            overdueDays = CommonDateUtil.daysBetween(CommonDateUtil.formatStringToDate(applyModel.getPostShowDueDate(), "yyyyMMdd HH:mm:ss"), date);
        } else {
            overdueDays = CommonDateUtil.daysBetween(date, form.getArrangedRepay());
        }
        //设置逾期费
        if (overdueDays > 0) {
            //按照时间间隔设置利率
            Double overdueRate = overdueRate(feeRate.getOverdueRateJson(), overdueDays);
            detailModel.setOverdue(form.getRepayAmount().multiply(new BigDecimal(overdueDays))
                    .multiply(new BigDecimal(overdueRate))
                    .divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP));
            detailModel.setOverdueRate(overdueRate);
            detailModel.setOverdueDays(overdueDays);
        }
        detailModel.setRealNomalAmount(detailModel.getWarranty().add(detailModel.getDelay()).add(detailModel.getOverdue()));
        return detailModel;
    }


    /**
     * 确认回款弹窗查询
     *
     * @param:
     * @return:
     * @auther: yuanxy
     * @date: 2019/2/19 14:25
     */
    public FundPayBackConfirmResultForm fundPayBackConfirmQuery(IdForm form) {
        return fundBackDao.fundPayBackConfirmQuery(form);
    }


    /**
     * 确认回款
     *
     * @param:
     * @return:
     * @auther: yuanxy
     * @date: 2019/1/25 17:10
     */
    public Boolean fundPayBackConfirm(IdForm form) {
        FundPayBackGeneralModel payBackGeneral = fundBackDao.pickPayBackGeneral(form.getId());
        if (payBackGeneral != null && payBackGeneral.getRepayBalance().doubleValue() > 0) {
            throw new RuntimeException("还有借款未回款,不能进行确认回款操作");
        }
        Integer result = fundBackDao.fundPayBackConfirm(form.getId());
        return true;
    }


    /**
     * 计算对应的逾期费率
     *
     * @param:
     * @return:
     * @auther: yuanxy
     * @date: 2019/2/19 14:15
     */
    private static Double overdueRate(String overdueJson, Integer overDays) {
        try {
            JSONArray jsonArray = JSONObject.parseArray(overdueJson);
            List<OverdueRateParseForm> overdueRateList = jsonArray.toJavaList(OverdueRateParseForm.class);
            if (!CommonListUtil.isEmpty(overdueRateList) && !overdueJson.isEmpty()) {
                for (OverdueRateParseForm form : overdueRateList) {
                    if (form.getMin() <= overDays && overDays <= form.getMax()) {
                        return Double.valueOf(form.getRate());
                    }else {

                        return Double.valueOf(form.getRate());
                    }

                }

            }
        } catch (Exception e) {
           // logger.error("计算逾期费时出错,json: " + overdueJson);
            throw new RuntimeException("新增回款失败,请稍后再试");
        }

        return 0.00;
    }


    /**
     * 更新借款情况
     *
     * @param:
     * @return:
     * @auther: yuanxy
     * @date: 2019/1/25 17:10
     */
    protected void updateLoanSituation(FundPayBackSaveForm form, String operateType, BigDecimal addAmount) {
        LoanDetailsModel detailsModel = guaranteeDao.pickLoanDetails(form.getLoanId());
        detailsModel.setUpdateOperatorId(form.getOperatorId());
        detailsModel.setUpdateTime(new Date());
        if ("add".equals(operateType)) {
            detailsModel.setLoanRemain(detailsModel.getLoanAmount().add(form.getRepayAmount()));
        } else if ("subtract".equals(operateType)) {
            if (addAmount == null) {
                detailsModel.setLoanRemain(detailsModel.getLoanAmount().subtract(form.getRepayAmount()));
            } else {
                detailsModel.setLoanRemain(detailsModel.getLoanAmount().add(addAmount).subtract(form.getRepayAmount()));
            }
        }
        guaranteeDao.updateLoanDetail(detailsModel);


    }


    /**
     * 删除回款
     *
     * @param:
     * @return:
     * @auther: yuanxy
     * @date: 2019/2/19 14:39
     */
    @Transactional
    public Boolean deletePayBack(IdForm form) {
        FundPayBackDetailModel detailModel = fundBackDao.pickPayBackDetail(form.getId());
        if (detailModel == null) {
            throw new RuntimeException("此回款不存在,请稍后再试");
        }
        FundPayBackGeneralModel payBackGeneral = fundBackDao.pickPayBackGeneral(detailModel.getGuaranteeId());
        payBackGeneral.setRepayBalance(payBackGeneral.getRepayBalance().add(detailModel.getRepayAmount()));
        payBackGeneral.setRepayTotalAmount(payBackGeneral.getRepayTotalAmount().subtract(detailModel.getRepayAmount()));
        payBackGeneral.setUpdateTime(new Date());
        payBackGeneral.setUpdateOperatorId(form.getOperatorId());
        Integer result = fundBackDao.updatePayBackGeneral(payBackGeneral);
        Integer delResult = fundBackDao.deletePayBack(form);
        if (result < 1 || delResult < 1) {
            logger.error("删除回款时出错,担保单id: " + payBackGeneral.getGuaranteeId());
            throw new RuntimeException("删除回款失败,请稍后再试");
        }
        FundPayBackSaveForm payBackForm = new FundPayBackSaveForm();
        payBackForm.setRepayAmount(detailModel.getRepayAmount());
        payBackForm.setLoanId(detailModel.getLoanId());
        updateLoanSituation(payBackForm, "add", null);
        return true;
    }


    /**
     * 查询逾期回款记录
     * @param:
     * @return:
     * @auther: yuanxy
     * @date: 2019/3/4 16:26
     */
    public List<OverdueRecordResultForm> queryOverdueRecord(IdForm form) {
        List<OverdueRecordResultForm> overdueRecordResultList =fundBackDao.queryOverdueRecord(form);
        if(!CommonListUtil.isEmpty(overdueRecordResultList)){
           overdueRecordResultList.forEach(overdueRecord -> {
               if(!CommonListUtil.isEmpty(overdueRecord.getPayBackDetailList())){
                   List<FundPayBackDetailModel>detailModelList =overdueRecord.getPayBackDetailList();
                       overdueRecord.setOverdueDates(detailModelList.get(0).getOverdueDays());
               }
           });
        }

        return overdueRecordResultList;
    }

    /**
     *担保单财务台账
     * @param:
     * @return:
     * @auther: yuanxy
     * @date: 2019/3/5 10:48
     */
    public AccountGeneralForm pickAccountGeneral(IdForm form) {
        AccountGeneralForm generalForm = fundBackDao.pickAccountGeneral(form);
        generalForm.setLoanBalanceAmount(generalForm.getBillingTotalAmount().subtract(generalForm.getRepayTotalAmount()));
        if(generalForm.getBillingDate() !=null){
            if(generalForm.getRepayConfirmDate()!=null){
                generalForm.setUseDays(CommonDateUtil.daysBetween(generalForm.getBillingDate(),generalForm.getRepayConfirmDate()));
            }else {
                generalForm.setUseDays(CommonDateUtil.daysBetween(generalForm.getBillingDate(),new Date()));
            }
        }
        //查询借款费率和逾期费率
        //FinanceFeeRateResultForm feeRate = fundBackDao.pickFeeRate(form.getLoanId());


        return generalForm;
    }


    public List<TransactionTypeReceivePaymentPlanModel> queryRepayAccount(IdForm form) {
        return guaranteeDao.queryRepayAccount(form.getId());

    }
}
