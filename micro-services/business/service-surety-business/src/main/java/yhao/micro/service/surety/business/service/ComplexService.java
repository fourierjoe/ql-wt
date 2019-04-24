package yhao.micro.service.surety.business.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.infra.common.util.CommonDateUtil;
import yhao.infra.common.util.CommonListUtil;
import yhao.infra.common.util.CommonMapUtil;
import yhao.infra.common.util.RandomUtil;
import yhao.infra.web.common.util.HttpClientUtil;
import yhao.micro.service.constants.enums.YNEnum;
import yhao.micro.service.surety.business.apilist.form.complex.*;
import yhao.micro.service.surety.business.apilist.model.complex.*;
import yhao.micro.service.surety.business.apilist.model.enums.complex.MaterialType;
import yhao.micro.service.surety.business.apilist.model.enums.complex.RedemptionEnsureStatus;
import yhao.micro.service.surety.business.dao.automapper.ComplexDao;
import yhao.micro.service.workflow.apilist.enums.task.TaskStatus;
import yhao.micro.service.workflow.apilist.form.task.TaskStartForm;
import yhao.micro.service.workflow.apilist.model.task.TaskModel;
import yhao.micro.service.workflow.apilist.restful.TaskFeign;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.*;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/6 14:42
 * @Description:综合管理逻辑实现相关
 */
@Service
public class ComplexService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private ComplexDao complexDao;
    @Resource
    private TaskFeign taskFeign;
    @Resource
    private Environment env;
    private DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();

    /**
     * 分页查询所有保函
     */
    public Pagination<EnsureQueryResultForm> queryRedemptionEnsure(EnsureQueryForm form) {
        Pagination<EnsureQueryResultForm> page = new Pagination<EnsureQueryResultForm>();
        //已风控已审批且财务已确认收取担保费的担保单
        complexDao.queryRedemptionEnsure(page, form);
        return page;
    }

    /**
     * 更新保函状态
     */
    public Boolean redemptionEnsureSave(EnsureSaveForm form) {
        RedemptionEnsureModel ensureModel = complexDao.selectByGuaranteePid(form.getGuaranteePid());
        if (ensureModel == null) {
            ensureModel = new RedemptionEnsureModel();
            dozerBeanMapper.map(form, ensureModel);
            ensureModel.setId(UUID.randomUUID().toString());
            ensureModel.setIsSend(YNEnum.YES);
            ensureModel.setSendDate(new Date());
            if (StringUtils.isNotBlank(form.getSendRemark())) {
                ensureModel.setSendRemark(form.getSendRemark());
            }
            ensureModel.setStatus(RedemptionEnsureStatus.SEND);
            ensureModel.setCreateOperatorId(form.getCreateOperatorId());
            ensureModel.setCreateTime(new Date());
            Integer result = complexDao.insertRedemptionEnsure(ensureModel);
            if (result < 1) {
                logger.error("更新保函单寄出状态失败,担保单id" + form.getGuaranteePid());
                throw new RuntimeException("保函单寄出失败,请稍后再试");
            }
        } else {
            dozerBeanMapper.map(form, ensureModel);
            if (form.getPositionType().equals(RedemptionEnsureStatus.REBACK.toString())) {
                ensureModel.setStatus(RedemptionEnsureStatus.REBACK);
                ensureModel.setRebackRemark(StringUtils.isNotBlank(form.getRebackRemark()) ? form.getRebackRemark() : "");
            } else if (form.getPositionType().equals(RedemptionEnsureStatus.FOLLOW.toString())) {
                ensureModel.setIsRenew(YNEnum.YES);
                ensureModel.setStatus(RedemptionEnsureStatus.FOLLOW);
                ensureModel.setRebackRemark(StringUtils.isNotBlank(form.getRenewRemark()) ? form.getRenewRemark() : "");
            }

            ensureModel.setUpdateOperatorId(form.getCreateOperatorId());
            ensureModel.setUpdateTime(new Date());
            Integer result = complexDao.updateRedemptionEnsure(ensureModel);
            if (result < 1) {
                logger.error("更新保函单" + ensureModel.getStatus().getDesc() + "状态失败,担保单id" + form.getGuaranteePid());
                throw new RuntimeException("保函单" + ensureModel.getStatus().getDesc() + "失败，请稍后再试");
            }
        }
        return true;

    }

    /**
     * 分页查询所有要件
     */
    public Pagination<RedemptionEssentialsTakeModel> queryEssentials(ComplexRedemptionBaseQueryForm form) {
        Pagination<RedemptionEssentialsTakeModel> page = new Pagination<RedemptionEssentialsTakeModel>();
        complexDao.queryEssentials(page, form);
        return page;
    }

    /**
     * 要件收取
     */
    public Boolean essentialsSave(EssentialsSaveForm form) {
        RedemptionEssentialsTakeModel takeModel = complexDao.pickEssentialsByGuaranteePid(form.getGuaranteePid());
        if (takeModel != null) {
            logger.error("要件收取失败,已收取，担保单id" + form.getGuaranteePid());
            throw new RuntimeException("要件已收取");
        }
        dozerBeanMapper.map(form, takeModel);
        Integer result = complexDao.insertEssentials(takeModel);
        if (result < 1) {
            logger.error("要件收取失败,担保单id" + form.getGuaranteePid());
            throw new RuntimeException("要件收取失败,请稍后再试");
        }
        return true;
    }


    /**
     * 要件申请借出
     *
     * @return: java.lang.Boolean
     * @auther: yuanxy
     * @date: 2018/12/19 19:56
     */
    @Transactional
    public Boolean essentialsLendApply(EssentialsLendApplySaveForm form) {
        MaterialLendModel model = new MaterialLendModel();
        dozerBeanMapper.map(form, model);
        String id = UUID.randomUUID().toString();
        model.setId(id);
        Integer result = complexDao.insertEssentialsLend(model);
        if (result < 1) {
            logger.error("要件借出申请失败,担保单id" + form.getGuaranteePid());
            throw new RuntimeException("要件借出申请失败,请稍后再试");
        }
        if (form.getMaterialType().equals(MaterialType.ESSENTIALS.toString())) {
            TaskStartForm taskStartForm = new TaskStartForm();
            taskStartForm.setBizCodeStr("");
            taskStartForm.setBizEntityId(id);
            RequestResult<TaskStartForm> startResult = taskFeign.startNewTask(taskStartForm);
            if (!startResult.isSuccess()) {
                logger.error("要件借出申请失败,开启任务失败担保单id" + form.getGuaranteePid());
                throw new RuntimeException("要件借出申请失败,请稍后再试");
            }
        }

        return true;
    }

    /**
     * 要件申请归还
     *
     * @return: java.lang.Boolean
     * @auther: yuanxy
     * @date: 2018/12/19 19:56
     */
    public Boolean essentialsRemandApply(EssentialsRemandApplySaveForm form) {
        MaterialRemandModel model = new MaterialRemandModel();
        dozerBeanMapper.map(form, model);
        model.setId(UUID.randomUUID().toString());
        model.setCreateOperatorId(form.getCreaterId());
        model.setCreateTime(new Date());
        Integer result = complexDao.insertEssentialsRemand(model);
        if (result < 1) {
            logger.error("要件归还申请失败,担保单id" + form.getGuaranteePid());
            throw new RuntimeException("要件归还申请失败,请稍后再试");
        }

        return true;
    }


    /**
     * 要件借出详情
     */
    public MaterialLendModel essentialsLendDetail(IdForm form) {
        return complexDao.pickEssentialsLend(form.getId());
    }

    /**
     * 要件借出详情
     */
    public MaterialRemandModel essentialsRemandDetail(IdForm form) {
        return complexDao.pickEssentialsRemand(form.getId());
    }


    /**
     * 要件确认借出
     */
    @Transactional
    public Boolean confirmLendOrRemand(EssentialsLendSaveForm form) {
        IdForm idForm = new IdForm();
        idForm.setId(form.getId());
        RequestResult<TaskModel> taskModelResult = taskFeign.pickTaskState(idForm);
        if (!taskModelResult.isSuccess() || taskModelResult.pickBody() == null ||
                (taskModelResult.pickBody().getStatus().equals(TaskStatus.END.toString()) ||
                        taskModelResult.pickBody().getStatus().equals(TaskStatus.AHEAD_END.toString()))) {
            throw new RuntimeException("要件申请暂未通过");
        }

        if (form.getPositionType().equals("LEND")) {
            MaterialLendModel lendModel = complexDao.pickEssentialsLend(form.getId());
            lendModel.setRemark(form.getRemark());
            lendModel.setUpdateOperatorId(form.getCreateOperatorId());
            lendModel.setUpdateTime(new Date());
            Integer result = complexDao.updateEssentialsLend(lendModel);
            if (result < 1) {
                logger.error("要件借出失败,担保单id" + form.getId());
                throw new RuntimeException("要件借出失败,请稍后再试");
            }
            RedemptionEssentialsTakeModel model = new RedemptionEssentialsTakeModel();
            model.setGuaranteePid(lendModel.getGuaranteePid());
            model.setLendContent(lendModel.getLendContent());
            result = complexDao.updateEssentials(model);
            if (result < 1) {
                logger.error("要件借出内容更新失败,担保单id" + form.getId());
                throw new RuntimeException("要件借出失败,请稍后再试");
            }
        } else if (form.getPositionType().equals("REMAND")) {
            MaterialRemandModel remandModel = complexDao.pickEssentialsRemand(form.getId());
            remandModel.setRemark(form.getRemark());
            remandModel.setUpdateOperatorId(form.getCreateOperatorId());
            remandModel.setUpdateTime(new Date());
            Integer result = complexDao.updateEssentialsRemand(remandModel);
            if (result < 1) {
                logger.error("要件借出失败,担保单id" + form.getId());
                throw new RuntimeException("要件借出失败,请稍后再试");
            }

        }
        return true;
    }

    /**
     * 保存出账前核查信息
     */
    @Transactional
    public Boolean billingCheckSave(BilingCheckSaveForm form) {
        BillingCheckModel checkModel = complexDao.pickBillingCheck(form.getGuaranteePid());
        dozerBeanMapper.map(form, checkModel);
        if (checkModel == null) {
            checkModel = new BillingCheckModel();

            String id = UUID.randomUUID().toString();
            checkModel.setId(id);
            checkModel.setCreateOperatorId(form.getCreaterId());
            checkModel.setCreateTime(new Date());
            Integer result = complexDao.insertBillingCheck(checkModel);
            if (result < 1) {
                logger.error("保存出账前核查失败,担保单id" + form.getGuaranteePid());
                throw new RuntimeException("保存出账前核查失败,请稍后再试");
            }
            List<BillingCaseSituationModel> situationModelList = form.getCaseSituationModelList();
            for (BillingCaseSituationModel model : situationModelList) {
                model.setId(UUID.randomUUID().toString());
                model.setBillingCheckId(id);
                model.setCreateOperatorId(form.getCreaterId());
                model.setCreateTime(new Date());
            }
            result = complexDao.insertBillingSituation(situationModelList);
            if (result < 1) {
                logger.error("保存出账前查档信息失败,担保单id" + form.getGuaranteePid());
                throw new RuntimeException("保存出账前核查失败,请稍后再试");
            }
        } else {
            checkModel.setUpdateOperatorId(form.getCreaterId());
            checkModel.setUpdateTime(new Date());
            Integer result = complexDao.updateBillingCheck(checkModel);
            if (result < 1) {
                logger.error("保存出账前核查失败,担保单id" + form.getGuaranteePid());
                throw new RuntimeException("保存出账前核查失败,请稍后再试");
            }
            List<BillingCaseSituationModel> situationModelList = form.getCaseSituationModelList();
            for (BillingCaseSituationModel model : situationModelList) {
                model.setUpdateOperatorId(form.getCreaterId());
                model.setUpdateTime(new Date());
                Integer updResult = complexDao.updateBillingCaseSituation(model);
                if (updResult < 1) {
                    logger.error("保存出账前查档信息失败,担保单id" + form.getGuaranteePid());
                    throw new RuntimeException("保存出账前核查失败,请稍后再试");
                }
            }

        }

        return true;
    }

    /**
     * 出账核查记录
     *
     * @param: [form]
     * @return: yhao.micro.service.surety.business.apilist.form.complex.BillingCheckDetailForm
     * @auther: yuanxy
     * @date: 2018/12/26 17:05
     */
    public BillingCheckDetailForm billingCheckDetail(IdForm form) {
        return complexDao.queryBillingCheckQueryResult(form);
    }

    /**
     * 查档记录
     */
    public List<BillingQueryFileRecordModel> queryFileRecord(IdForm form) {
        return complexDao.queryFileRecord(form);
    }

    /**
     * 查档接口返回结果
     *
     * @param: []
     * @return: java.lang.Boolean
     * @auther: yuanxy
     * @date: 2018/12/24 17:52
     */
    public Boolean billingCheckQueryResultSave(BillingQueryFileSaveForm form) {

        String url = env.getProperty("billing.query.file.url");
        url = url + "?&queryType=1" + "&personInfo=" + form.getPersonInfo().trim() + "&ownerType=1";
        if (form.getDeedType().trim().equals("FCZ")) {
            url = url + "&certType=1&year=" + form.getDeedNum().trim().substring(0, 4) +
                    "&certNo=" + form.getDeedNum().trim().substring(4, form.getDeedNum().length());
        } else {
            url = url + "&certType=2" + "&certNo=" + form.getDeedNum().trim();
        }
        BillingQueryFileRecordModel model = new BillingQueryFileRecordModel();

        String resultStr = HttpClientUtil.get(url);
        JSONObject resJson = JSON.parseObject(resultStr);
        model.setId(UUID.randomUUID().toString());
        model.setCreateOperatorId(form.getCreaterId());
        model.setQueryPersonId(form.getCreaterId());
        model.setCreateTime(new Date());
        model.setQueryContent(url);
        model.setResult("FAILURE");
        dozerBeanMapper.map(form, model);
        if (resJson.get("code").equals("ok") && StringUtils.isNotBlank(resJson.get("data") + "")) {
            JSONObject resultJson = resJson.getJSONObject("data").getJSONObject("result");
            model.setArea(resultJson.getString("area"));
            model.setStatus(resultJson.getString("status"));
            model.setMortgageDate(CommonDateUtil.formatStringToDate(resultJson.getString("mortgageDate"), "yyyy-MM-dd"));
            model.setMortgagePerson(resultJson.getString("mortgagePerson"));
            model.setResult("SUCCESS");
        }

        Integer result = complexDao.insertBillingQueryRecord(model);
        if (result < 1) {
            logger.error("新增查档失败,担保单id" + form.getGuaranteePid());
            throw new RuntimeException("查档繁忙,请稍后再试");
        }
        return true;
    }



    /**
     * 指令查询
     */
    public Pagination<OrderQueryResultForm>  queryRedemptionOrder(OrderQueryForm form){
        Pagination<OrderQueryResultForm> page =new Pagination<OrderQueryResultForm>();
        complexDao.queryRedemptionOrder(page,form);
        return page;
    }




    /**
     * 新增指令
     */
    public Boolean redeemOrderSave(IdForm form) {
        RedeemOrderConfigForm orderConfig = complexDao.pickOrderConfig(form);
        Integer days = orderConfig.getDayCount();
        RedemptionOrderModel model = new RedemptionOrderModel();
        dozerBeanMapper.map(form, model);
        model.setOrderEndDate(CommonDateUtil.addDay(new Date(), days));
        Integer result = complexDao.insertRedeemOrder(model);
        if (result < 1) {
            logger.error("指令申请失败,担保单id" + form.getId());
            throw new RuntimeException("指令申请失败,请稍后再试");
        }
        return true;
    }

    /**
     * 更新指令
     */
    public Boolean redeemOrderUpdate(OrderSaveForm form) {
        RedemptionOrderModel model = new RedemptionOrderModel();
        dozerBeanMapper.map(form, model);
        Integer result = complexDao.updateRedeemOrder(model);
        if (result < 1) {
            logger.error("指令申请失败,担保单id" + form.getId());
            throw new RuntimeException("指令申请失败,请稍后再试");
        }
        return true;
    }

    /**
     * 查询归档信息
     */
    public Pagination<RedemptionBaseResultForm> queryMaterialArchive(ComplexRedemptionBaseQueryForm form) {
        Pagination<RedemptionBaseResultForm> page = new Pagination<RedemptionBaseResultForm>();
        complexDao.queryMaterialArchive(page, form);
        return page;
    }

    /**
     * 归档信息保存
     */
    public Boolean materialArchiveSave(MaterialArchiveSaveForm form) {
        MaterialArchiveModel model = new MaterialArchiveModel();
        dozerBeanMapper.map(form, model);
        model.setArchivePid(createNumber("XJ"));
        model.setCreateOperatorId(form.getCreaterId());
        model.setCreateTime(new Date());
        Integer result = complexDao.materialArchiveSave(model);
        if (result < 1) {
            logger.error("材料" + form.getArchiveType() + "归档失败,担保单id" + form.getGuaranteePid());
            throw new RuntimeException("指令申请失败,请稍后再试");
        }
        return true;
    }

    public List<SecondmentDetailResultForm>secondmentDetail(SecondmentDetailQueryForm form){
        return  complexDao.querySecondmentDetail(form);
    }

    /**解保列表查询*/
    public Pagination<UnProtectedQueryResultForm>queryUnProtected(UnprotectedQueryForm form){
        Pagination<UnProtectedQueryResultForm> page =new Pagination<UnProtectedQueryResultForm>();
        complexDao.queryUnProtected(page,form);
        return page;
    }
    /**解保*/
    public Boolean unProtectedSave(UnProtectedSaveForm form){
        Integer result = complexDao.unProtectedSave(form);
        if (result < 1) {
            logger.error("解保失败,担保单id" + form.getGuaranteeId());
            throw new RuntimeException("解保失败,请稍后再试");
        }
        return true;
    }



    private String createNumber(String fix) {
        //生成归档编号
        StringBuffer archiveNo = new StringBuffer(fix);
        String currentTime = CommonDateUtil.formatDateToyyyyMMdd(new Date());
        archiveNo.append(currentTime);
        archiveNo.append(RandomUtil.makeRandomNumberString(3));
        return archiveNo.toString();
    }





}
