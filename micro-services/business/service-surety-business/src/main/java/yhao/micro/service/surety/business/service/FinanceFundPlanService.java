package yhao.micro.service.surety.business.service;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.finance.*;
import yhao.micro.service.surety.business.apilist.model.enums.finance.FundTypeEnum;
import yhao.micro.service.surety.business.apilist.model.enums.finance.PlanStatusEnum;
import yhao.micro.service.surety.business.apilist.model.enums.finance.PositionTypeEnum;
import yhao.micro.service.surety.business.apilist.model.finance.FundPlanModel;
import yhao.micro.service.surety.business.apilist.model.finance.FundPlanRecordModel;
import yhao.micro.service.surety.business.dao.automapper.FinanceFundPlanDao;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

/**
 * @Auther: yuanxy
 * @Date: 2019/1/4 16:44
 * @Description: 用款计划逻辑实现
 */
@Service
public class FinanceFundPlanService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private FinanceFundPlanDao fundPlanDao;

    private DozerBeanMapper dozerMapper = new DozerBeanMapper();

    /**
     * 新增用款计划
     *
     * @param: FinanceFundPlanSaveForm
     * @return: Boolean
     * @auther: yuanxy
     * @date: 2019/1/4 16:57
     */
    public Boolean fundPlanSave(FinanceFundPlanSaveForm form) {
        FundPlanModel planModel = new FundPlanModel();
        dozerMapper.map(form,planModel);
        planModel.setId(UUID.randomUUID().toString());
        planModel.setCreateTime(new Date());
        planModel.setPlanStatus(PlanStatusEnum.WAITING_PICK);
        Integer result = fundPlanDao.insertFundPlan(planModel);
        if (result < 1) {
            logger.error("用款计划创建失败,担保单id" + form.getGuaranteeId());
            throw new RuntimeException("要件借出申请失败,请稍后再试");
        }
        return true;

    }

    /**
     * 功能描述:查询用款计划列表
     *
     * @param:
     * @return:
     * @auther: yuanxy
     * @date: 2019/1/4 17:00
     */
    public Pagination<FundPlanQueryResultForm> queryFundPlan(FundPlanQueryForm form) {
        Pagination<FundPlanQueryResultForm> page = new Pagination<FundPlanQueryResultForm>();
        fundPlanDao.queryFundPlan(page, form);
        return page;

    }

    /**
     * 功能描述:查询用款计划操作记录列表
     *
     * @param:
     * @return:
     * @auther: yuanxy
     * @date: 2019/1/4 17:00
     */
    public Pagination<FundPlanRecordModel> queryFundPlanRecord(IdForm form) {
        Pagination<FundPlanRecordModel> page = new Pagination<FundPlanRecordModel>();
        fundPlanDao.queryFundPlanRecord(page, form);
        return page;

    }


    /**
     * 功能描述:用款计划选择资方
     *
     * @param:
     * @return:
     * @auther: yuanxy
     * @date: 2019/1/4 17:00
     */
    @Transactional
    public Boolean fundPick(FinancePickFundForm form) {

        Integer result = fundPlanDao.fundPick(form);
        if (result < 1) {
            logger.error("用款计划选择资金方失败,担保单id" + form.getGuaranteeId());
            throw new RuntimeException("用款计划选择资金方失败,请稍后再试");
        }
        //新增操作记录
        FundPlanRecordModel recordModel = new FundPlanRecordModel();
        recordModel.setFundPlanId(form.getId());
        recordModel.setCreateOperatorId(form.getCreateOperatorId());
        if (FundTypeEnum.OWN_FUND.toString().equals(form.getFundType().name())) {
            recordModel.setPositionContent(PositionTypeEnum.CHOOSE_FUNDS.toString());
        } else {
            recordModel.setPositionContent(form.getPlatformName());
        }

        return createPlanRecord(recordModel, PositionTypeEnum.CHOOSE_FUNDS);
    }


    /**
     * 用款计划更新进度
     *
     * @param:
     * @return:
     * @auther: yuanxy
     * @date: 2019/1/7 10:51
     */
    public Boolean fundPlanUpdRate(FinanceFundPlanForm form) {
        //是否已确认到账
        Integer checkResult = fundPlanDao.pickIsConfirmArrival(form.getGuaranteeId());
        if (checkResult >=1) {
            throw new RuntimeException("财务已确认到账,不允许修改用款计划");
        }
        Integer result = fundPlanDao.fundPlanUpdRate(form);
        if (result < 1) {
            logger.error("用款计划更新进度失败,担保单id" + form.getGuaranteeId());
            throw new RuntimeException("用款计划更新进度失败,请稍后再试");
        }
        //新增操作记录
        FundPlanRecordModel recordModel = new FundPlanRecordModel();
        recordModel.setCreateOperatorId(form.getOperatorId());
        recordModel.setFundPlanId(form.getId());
        recordModel.setPositionContent(form.getPlanStatus().toString());
        return createPlanRecord(recordModel, PositionTypeEnum.PLAN_FUNDS);

    }


    /**
     * 新增用款计划操作记录
     */
    private Boolean createPlanRecord(FundPlanRecordModel recordModel, PositionTypeEnum positionType) {
        recordModel.setId(UUID.randomUUID().toString());
        recordModel.setCreateTime(new Date());
        recordModel.setPositionType(positionType);
        Integer result = fundPlanDao.insertFundPlanRecord(recordModel);
        if (result < 1) {
            logger.error("用款计划新增操作记录失败,用款计划id" + recordModel.getFundPlanId());
            throw new RuntimeException("用款计划选择资金方失败,请稍后再试");
        }
        return true;
    }


}
