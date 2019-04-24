package yhao.micro.service.surety.business.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.complex.*;
import yhao.micro.service.surety.business.apilist.model.*;
import yhao.micro.service.surety.business.apilist.model.businessType.BusinessTypeModel;
import yhao.micro.service.surety.business.apilist.model.enums.businessType.FundTypeEnum;
import yhao.micro.service.surety.business.dao.automapper.BusinessTypeDao;
import yhao.micro.service.surety.business.dao.automapper.DiscountApplicationDao;
import yhao.micro.service.surety.business.dao.automapper.ExaminerReviewDao;
import yhao.micro.service.workflow.apilist.enums.task.TaskStatus;
import yhao.micro.service.workflow.apilist.form.task.TaskDealPassForm;
import yhao.micro.service.workflow.apilist.form.task.TaskNodeItemForm;
import yhao.micro.service.workflow.apilist.form.task.TaskStartForm;
import yhao.micro.service.workflow.apilist.restful.TaskFeign;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Description 打折申请Service
 *
 * @Author leice
 * @Date 2018/12/19 19:53
 * @Version 1.0
 */
@Service
public class DiscountApplicationService {

    @Autowired
    private DiscountApplicationDao discountApplicationDao;

    @Autowired
    private ExaminerReviewDao examinerReviewDao;

    @Resource
    private TaskFeign taskFeign;

    public DiscountApplicationInfoModel queryDiscountApplicationById(QuerySingleGuaranteeInfoForm form) throws Exception {
        DiscountApplicationInfoModel discountApplicationInfoModel = null;
        if (null != form.getGuaranteeId()){

            BusinessTypeModel businessTypeModel = discountApplicationDao.pickBusinessTypeByGuaranteeId(form.getGuaranteeId());
            if (null != businessTypeModel){
                FundTypeEnum fundType = businessTypeModel.getFundType();
                if (null != fundType){
                    //额度业务
                    if (FundTypeEnum.AMOUNT == fundType){
                        discountApplicationInfoModel = discountApplicationDao.queryGuaranteeInfoById(form.getGuaranteeId());
                        discountApplicationInfoModel.setTypes("AMOUNT");
                        String s = examinerReviewDao.queryManageName(discountApplicationInfoModel.getAccountManagerId());
                        discountApplicationInfoModel.setAccountManagerOrg(s);
                        if (null != discountApplicationInfoModel){
                            Double actualRate = discountApplicationInfoModel.getActualRate();
                            Double lowestActualRate = discountApplicationInfoModel.getLowestActualRate();
                            if (0 != lowestActualRate){
                                BigDecimal bigDecimal = new BigDecimal(Double.toString(actualRate));
                                BigDecimal bigDecima2 = new BigDecimal(Double.toString(lowestActualRate));
                                BigDecimal divide = bigDecimal.divide(bigDecima2, 1, RoundingMode.HALF_UP);
                                discountApplicationInfoModel.setDiscount(divide.toString());
                            }else {
                                throw new Exception("最低实收费率不能为0");
                            }
                        }
                        //现金业务
                    }else {
                        discountApplicationInfoModel = discountApplicationDao.queryDiscountSomeInfoById(form.getGuaranteeId());
                        discountApplicationInfoModel.setTypes("CASH");
                        String s = examinerReviewDao.queryManageName(discountApplicationInfoModel.getAccountManagerId());
                        discountApplicationInfoModel.setAccountManagerOrg(s);
                        if (null != discountApplicationInfoModel && null != discountApplicationInfoModel.getLoanDetailsInfoList() && discountApplicationInfoModel.getLoanDetailsInfoList().size() > 0){
                            List<LoanDetailsInfoModel> loanDetailsInfoList = discountApplicationInfoModel.getLoanDetailsInfoList();
                            for (LoanDetailsInfoModel loanDetailsInfoModel : loanDetailsInfoList) {
                                Double marketFeeRate = loanDetailsInfoModel.getMarketFeeRate();
                                Double lowestActualRate = discountApplicationInfoModel.getLowestActualRate();
                                if (0 != lowestActualRate){
                                    if (marketFeeRate >= lowestActualRate){
                                        loanDetailsInfoModel.setDiscount("无折");
                                    }else {
                                        BigDecimal bigDecimal = new BigDecimal(Double.toString(marketFeeRate));
                                        BigDecimal bigDecima2 = new BigDecimal(Double.toString(lowestActualRate));
                                        BigDecimal divide = bigDecimal.divide(bigDecima2, 1, RoundingMode.HALF_UP);
                                        loanDetailsInfoModel.setDiscount(divide.toString());
                                    }
                                }else {
                                    throw new Exception("最低实收费率不能为0");
                                }
                            }
                        }
                    }
                }
            }
        }else{
            throw new Exception("担保单id不能为空");
        }
        return discountApplicationInfoModel;
    }

    @Transactional
    public DiscountApplicationSaveForm discountApplicationSave(DiscountApplicationSaveForm form) throws Exception {
        if (null == form.getDiscountReason() || "".equals(form.getDiscountReason())){
            throw new Exception("打折原因不能为空");
        }
        form.setId(UUID.randomUUID().toString());
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(date);
        form.setCreateTime(format);
        discountApplicationDao.discountApplicationSave(form);
        discountApplicationDao.updateDiscountStatusHave(form.getGuaranteeId());
        //启动任务
        TaskStartForm taskStartForm = new TaskStartForm();
        taskStartForm.setTaskHead("打折申请子流程");
        taskStartForm.setBizCodeStr("224");
        taskStartForm.setBizEntityId(form.getId());
        RequestResult<TaskStartForm> taskStartFormRequestResult = taskFeign.startNewTask(taskStartForm);
        if(!taskStartFormRequestResult.isSuccess()){
            discountApplicationDao.delect(form.getId());
            discountApplicationDao.updateDiscountStatus(form.getGuaranteeId());
            throw new Exception("启动打折申请失败");
        }
        return form;
    }

    @Transactional
    public RestartDiscountSaveForm restartDiscountApplication(RestartDiscountSaveForm form) throws Exception {
        if (null == form.getDiscountId()){
            throw new Exception("打折申请记录id不能为空");
        }
        if (null == form.getDiscountReason()){
            throw new Exception("打折申请理由不能为空");
        }
        DiscountApplicationByIdModel discountApplicationByIdModel = discountApplicationDao.queryDiscountInfoById(form.getDiscountId());
        if (null != discountApplicationByIdModel ) {
            if (!form.getDiscountReason().equals(discountApplicationByIdModel.getDiscountReason())) {
                discountApplicationDao.updateDiscountReasonById(form);
            }
        }
        DiscountApplicationSaveForm discountApplicationSaveForm1 = null;
        if (null != form.getRequestType() && form.getRequestType() == 1){
            BusinessTypeModel businessTypeModel = discountApplicationDao.pickBusinessTypeByGuaranteeId(form.getGuaranteeId());
            if (null != businessTypeModel){
                FundTypeEnum fundType = businessTypeModel.getFundType();
                if (null != fundType){
                    if (FundTypeEnum.AMOUNT == fundType){
                        //额度业务
                        if (null == form.getGuaranteeDays()){
                            throw new Exception("担保天数不能为空");
                        }
                        if (null == form.getHandlingFee()){
                            throw new Exception("手续费不能为空");
                        }
                        if (null == form.getExternalRate()){
                            throw new Exception("对外费率不能为空");
                        }
                        if (null == form.getSecurityFeeReceivable()){
                            throw new Exception("应收担保费不能为空");
                        }
                        if (null == form.getActualRate()){
                            throw new Exception("实收费率不能为空");
                        }
                        if (null == form.getPaidGuaranteeFee()){
                            throw new Exception("实收担保费不能为空");
                        }
                        if (form.getActualRate() > form.getExternalRate()){
                            throw new Exception("实收费率不能大于对外费率");
                        }
                        if (form.getPaidGuaranteeFee() > form.getSecurityFeeReceivable()){
                            throw new Exception("实收担保费不能大于应收担保费");
                        }
                        if ((form.getActualRate() > businessTypeModel.getMinRealRate().doubleValue())&&(form.getPaidGuaranteeFee() > businessTypeModel.getMinRealFee().doubleValue())){
                            throw new Exception("您填写的信息无需打折申请,请撤销打折申请");
                        }
                        //修改担保费，实收费率
                        discountApplicationDao.updateGuaranteeInfoOne(form);
                        //修改担保天数，手续费
                        discountApplicationDao.updateGuaranteeInfoTwo(form);
                        //修改对外费率,应收合计，实收合计
                        double v = form.getSecurityFeeReceivable() + form.getHandlingFee();
                        form.setShouldFee(v);
                        double v1 = form.getPaidGuaranteeFee() + form.getHandlingFee();
                        form.setActualFee(v1);
                        discountApplicationDao.updateGuaranteeInfoThree(form);
                        //新增打折申请
                        DiscountApplicationSaveForm discountApplicationSaveForm = new DiscountApplicationSaveForm();
                        discountApplicationSaveForm.setGuaranteeId(form.getGuaranteeId());
                        discountApplicationSaveForm.setDiscountReason(form.getDiscountReason());
                        discountApplicationSaveForm1 = this.discountApplicationSave(discountApplicationSaveForm);
//                        // 修改状态
//                        discountApplicationDao.restartDiscountStatusById(form);
                    }else{
                        //现金业务
                        List<LoanDetailsInfoForm> loanRateInfoList = form.getLoanRateInfoList();
                        //咨询费小计
                        Double consultingFeeTotal = 0d;
                        //应收合计
                        Double receivableTotal = 0d;
                        if (null !=loanRateInfoList && loanRateInfoList.size()>0){
                            for (LoanDetailsInfoForm loanDetailsInfoForm : loanRateInfoList) {
                                if (null==loanDetailsInfoForm.getDailyRate()){
                                    throw new Exception("每日费率不能为空");
                                }
                                if (loanDetailsInfoForm.getDailyRate()<=0 || loanDetailsInfoForm.getDailyRate()>=100){
                                    throw new Exception("每日费率只能为>0且< 100的数字");
                                }
                                if (loanDetailsInfoForm.getDailyRate() >= businessTypeModel.getMinRealRate().doubleValue()){
                                    throw new Exception("每日费率不能大于等于业务配置的最低实收费率");
                                }
                                //修改每日费率 ,咨询费
                                double v = loanDetailsInfoForm.getLoanAmount() * loanDetailsInfoForm.getLoanDays() * loanDetailsInfoForm.getDailyRate()/100;
                                loanDetailsInfoForm.setChargeGuaranteeFee(v);
                                consultingFeeTotal = consultingFeeTotal + v;
                                discountApplicationDao.updateLoanInfo(loanDetailsInfoForm);
                            }
                            //修改咨询费，总费率，应收合计
                            receivableTotal = consultingFeeTotal + form.getCharges();
                            //总费率
                            BigDecimal bigDecimal = new BigDecimal(Double.toString(consultingFeeTotal));
                            BigDecimal bigDecima2 = new BigDecimal(Double.toString(form.getLoanTotalAmount()));
                            BigDecimal bigDecima3 = new BigDecimal(Double.toString(form.getTotalDays()));
                            BigDecimal divide = bigDecimal.divide(bigDecima2, 2, RoundingMode.HALF_UP);
                            BigDecimal divide1 = divide.divide(bigDecima3, 2, RoundingMode.HALF_UP);
                            form.setMarketFeeRate(divide1.doubleValue());
                            form.setAdviceFee(consultingFeeTotal);
                            form.setActualFee(receivableTotal);
                            discountApplicationDao.updateLoanGeneralInfo(form);
                            //新增打折申请
                            DiscountApplicationSaveForm discountApplicationSaveForm = new DiscountApplicationSaveForm();
                            discountApplicationSaveForm.setGuaranteeId(form.getGuaranteeId());
                            discountApplicationSaveForm.setDiscountReason(form.getDiscountReason());
                            discountApplicationSaveForm1 = this.discountApplicationSave(discountApplicationSaveForm);
//                            // 修改状态
//                            discountApplicationDao.restartDiscountStatusById(form);
                        }
                    }
                }
            }
        }else{
            BusinessTypeModel businessTypeModel = discountApplicationDao.pickBusinessTypeByGuaranteeId(form.getGuaranteeId());
            if (null != businessTypeModel){
                FundTypeEnum fundType = businessTypeModel.getFundType();
                if (null != fundType){
                    if (FundTypeEnum.AMOUNT == fundType){
                        //额度业务
                        if (null == form.getGuaranteeDays()){
                            throw new Exception("担保天数不能为空");
                        }
                        if (null == form.getHandlingFee()){
                            throw new Exception("手续费不能为空");
                        }
                        if (null == form.getExternalRate()){
                            throw new Exception("对外费率不能为空");
                        }
                        if (null == form.getSecurityFeeReceivable()){
                            throw new Exception("应收担保费不能为空");
                        }
                        if (null == form.getActualRate()){
                            throw new Exception("实收费率不能为空");
                        }
                        if (null == form.getPaidGuaranteeFee()){
                            throw new Exception("实收担保费不能为空");
                        }
                        if (form.getActualRate() > form.getExternalRate()){
                            throw new Exception("实收费率不能超过对外费率");
                        }
                        if (form.getPaidGuaranteeFee() > form.getSecurityFeeReceivable()){
                            throw new Exception("实收费用不能超过应收费用");
                        }
                        if (form.getActualRate() < businessTypeModel.getMinRealRate().doubleValue()){
                            throw new Exception(businessTypeModel.getBusinessName()+"的最低实收费率"+businessTypeModel.getMinRealRate().doubleValue()+"%,大于"+businessTypeModel.getMinRealRate().doubleValue()+"才能撤销");
                        }
                        if (form.getPaidGuaranteeFee() < businessTypeModel.getMinRealFee().doubleValue()){
                            throw new Exception(businessTypeModel.getBusinessName()+"的最低实收费用为"+businessTypeModel.getMinRealFee().doubleValue()+"元,大于"+businessTypeModel.getMinRealFee().doubleValue()+"元才能撤销");
                        }
                        //修改担保费，实收费率
                        discountApplicationDao.updateGuaranteeInfoOne(form);
                        //修改担保天数，手续费
                        discountApplicationDao.updateGuaranteeInfoTwo(form);
                        //修改对外费率,应收合计，实收合计
                        double v = form.getSecurityFeeReceivable() + form.getHandlingFee();
                        form.setShouldFee(v);
                        double v1 = form.getPaidGuaranteeFee() + form.getHandlingFee();
                        form.setActualFee(v1);
                        discountApplicationDao.updateGuaranteeInfoThree(form);
                        // 修改状态
                        discountApplicationDao.updateDiscountStatusById(form);
                        //保单中是否有打折申请修改状态
                        discountApplicationDao.updateDiscountStatus(form.getGuaranteeId());
                    }else{
                        //现金业务
                        List<LoanDetailsInfoForm> loanRateInfoList = form.getLoanRateInfoList();
                        //咨询费小计
                        Double consultingFeeTotal = 0d;
                        //应收合计
                        Double receivableTotal = 0d;
                        if (null !=loanRateInfoList && loanRateInfoList.size()>0){
                            for (LoanDetailsInfoForm loanDetailsInfoForm : loanRateInfoList) {
                                if (null==loanDetailsInfoForm.getDailyRate()){
                                    throw new Exception("每日费率不能为空");
                                }
                                if (loanDetailsInfoForm.getDailyRate()<=0 || loanDetailsInfoForm.getDailyRate()>=100){
                                    throw new Exception("每日费率只能为>0且< 100的数字");
                                }
                                if (loanDetailsInfoForm.getDailyRate()<businessTypeModel.getMinRealRate().doubleValue()){
                                    throw new Exception("每日费率不能小于业务配置的最低实收费率");
                                }
                                //修改每日费率 ,咨询费
                                double v = loanDetailsInfoForm.getLoanAmount() * loanDetailsInfoForm.getLoanDays() * loanDetailsInfoForm.getDailyRate()/100;
                                loanDetailsInfoForm.setChargeGuaranteeFee(v);
                                consultingFeeTotal = consultingFeeTotal + v;
                                discountApplicationDao.updateLoanInfo(loanDetailsInfoForm);
                            }
                            //修改咨询费，总费率，应收合计
                            receivableTotal = consultingFeeTotal + form.getCharges();
                            //总费率
                            BigDecimal bigDecimal = new BigDecimal(Double.toString(consultingFeeTotal));
                            BigDecimal bigDecima2 = new BigDecimal(Double.toString(form.getLoanTotalAmount()));
                            BigDecimal bigDecima3 = new BigDecimal(Double.toString(form.getTotalDays()));
                            BigDecimal divide = bigDecimal.divide(bigDecima2, 2, RoundingMode.HALF_UP);
                            BigDecimal divide1 = divide.divide(bigDecima3, 2, RoundingMode.HALF_UP);
                            form.setMarketFeeRate(divide1.doubleValue());
                            form.setAdviceFee(consultingFeeTotal);
                            form.setActualFee(receivableTotal);
                            discountApplicationDao.updateLoanGeneralInfo(form);
                            // 修改状态
                            discountApplicationDao.updateDiscountStatusById(form);
                            //保单中是否有打折申请修改状态
                            discountApplicationDao.updateDiscountStatus(form.getGuaranteeId());
                        }
                    }
                }
            }
            //撤销任务
            IdForm idForm = new IdForm();
            idForm.setId(form.getDiscountId());
            RequestResult<Boolean> booleanRequestResult = taskFeign.cancelTask(idForm);
            if(!booleanRequestResult.isSuccess()){
                discountApplicationDao.restartDiscountStatusById(form);
                throw new Exception("撤销失败");
            }
        }
        return form;
    }

    public Pagination<DiscountApplicationModel> pageQueryDiscountApplication(ApplicationQueryForm form) throws Exception{
//        if (StringUtils.isBlank(form.getProcessCode()) || StringUtils.isBlank(form.getOrgId()) ){
//            throw new Exception("流程编码/组织id不能为空");
//        }
        Pagination<WindControllerGuaranteeModel> page = new Pagination(form.getPageSize(),form.getCurrentPage());
        Pagination<DiscountApplicationModel> discountApplicationModelPagination = discountApplicationDao.pageQueryDiscountApplication(page, form);
        List<DiscountApplicationModel> items = discountApplicationModelPagination.getItems();
        int i = 0;
        if (null != items && items.size() > 0){
            for (DiscountApplicationModel item : items) {
                i++;
                item.setOrderNumber(i);
                DiscountApplicationInfoModel discountApplicationInfoModel = discountApplicationDao.queryGuaranteeInfoById(item.getGuaranteeId());
                String s = examinerReviewDao.queryManageName(item.getAccountManagerId());
                item.setAccountManagerOrg(s);
                if (null != discountApplicationInfoModel) {
                    Double actualRate = discountApplicationInfoModel.getActualRate();
                    Double lowestActualRate = discountApplicationInfoModel.getLowestActualRate();
                    if (0 != lowestActualRate) {
                        BigDecimal bigDecimal = new BigDecimal(Double.toString(actualRate));
                        BigDecimal bigDecima2 = new BigDecimal(Double.toString(lowestActualRate));
                        BigDecimal divide = bigDecimal.divide(bigDecima2, 2, RoundingMode.HALF_UP);
                        item.setDiscount(divide.toString());
                    } else {
                        throw new Exception("最低实收费率不能为0");
                    }
                }
            }
        }
        return discountApplicationModelPagination;
    }

    public RestartDiscountSaveForm updateDiscountApplication(RestartDiscountSaveForm form) throws Exception{
        if (null == form.getDiscountId()){
            throw new Exception("打折申请记录id不能为空");
        }
        if (null == form.getDiscountReason()){
            throw new Exception("打折申请理由不能为空");
        }
        DiscountApplicationByIdModel discountApplicationByIdModel = discountApplicationDao.queryDiscountInfoById(form.getDiscountId());
        if (null != discountApplicationByIdModel ) {
            if (!form.getDiscountReason().equals(discountApplicationByIdModel.getDiscountReason())) {
                discountApplicationDao.updateDiscountReasonById(form);
            }
        }
        DiscountApplicationSaveForm discountApplicationSaveForm1 = null;
            BusinessTypeModel businessTypeModel = discountApplicationDao.pickBusinessTypeByGuaranteeId(form.getGuaranteeId());
            if (null != businessTypeModel){
                FundTypeEnum fundType = businessTypeModel.getFundType();
                if (null != fundType){
                    if (FundTypeEnum.AMOUNT == fundType){
                        //额度业务
                        if (null == form.getGuaranteeDays()){
                            throw new Exception("担保天数不能为空");
                        }
                        if (null == form.getHandlingFee()){
                            throw new Exception("手续费不能为空");
                        }
                        if (null == form.getExternalRate()){
                            throw new Exception("对外费率不能为空");
                        }
                        if (null == form.getSecurityFeeReceivable()){
                            throw new Exception("应收担保费不能为空");
                        }
                        if (null == form.getActualRate()){
                            throw new Exception("实收费率不能为空");
                        }
                        if (null == form.getPaidGuaranteeFee()){
                            throw new Exception("实收担保费不能为空");
                        }
                        if (form.getActualRate() > form.getExternalRate()){
                            throw new Exception("实收费率不能大于对外费率");
                        }
                        if (form.getPaidGuaranteeFee() > form.getSecurityFeeReceivable()){
                            throw new Exception("实收担保费不能大于应收担保费");
                        }
                        if ((form.getActualRate() > businessTypeModel.getMinRealRate().doubleValue())&&(form.getPaidGuaranteeFee() > businessTypeModel.getMinRealFee().doubleValue())){
                            throw new Exception("您填写的信息无需打折申请,请撤销打折申请");
                        }
                        //修改担保费，实收费率
                        discountApplicationDao.updateGuaranteeInfoOne(form);
                        //修改担保天数，手续费
                        discountApplicationDao.updateGuaranteeInfoTwo(form);
                        //修改对外费率,应收合计，实收合计
                        double v = form.getSecurityFeeReceivable() + form.getHandlingFee();
                        form.setShouldFee(v);
                        double v1 = form.getPaidGuaranteeFee() + form.getHandlingFee();
                        form.setActualFee(v1);
                        discountApplicationDao.updateGuaranteeInfoThree(form);
                        //驳回后重新启动流程
                        startProAfterUpdate(form);
                    }else{
                        //现金业务
                        List<LoanDetailsInfoForm> loanRateInfoList = form.getLoanRateInfoList();
                        //咨询费小计
                        Double consultingFeeTotal = 0d;
                        //应收合计
                        Double receivableTotal = 0d;
                        if (null !=loanRateInfoList && loanRateInfoList.size()>0){
                            for (LoanDetailsInfoForm loanDetailsInfoForm : loanRateInfoList) {
                                if (null==loanDetailsInfoForm.getDailyRate()){
                                    throw new Exception("每日费率不能为空");
                                }
                                if (loanDetailsInfoForm.getDailyRate()<=0 || loanDetailsInfoForm.getDailyRate()>=100){
                                    throw new Exception("每日费率只能为>0且< 100的数字");
                                }
                                if (loanDetailsInfoForm.getDailyRate() >= businessTypeModel.getMinRealRate().doubleValue()){
                                    throw new Exception("每日费率不能大于等于业务配置的最低实收费率");
                                }
                                //修改每日费率 ,咨询费
                                double v = loanDetailsInfoForm.getLoanAmount() * loanDetailsInfoForm.getLoanDays() * loanDetailsInfoForm.getDailyRate()/100;
                                loanDetailsInfoForm.setChargeGuaranteeFee(v);
                                consultingFeeTotal = consultingFeeTotal + v;
                                discountApplicationDao.updateLoanInfo(loanDetailsInfoForm);
                            }
                            //修改咨询费，总费率，应收合计
                            receivableTotal = consultingFeeTotal + form.getCharges();
                            //总费率
                            BigDecimal bigDecimal = new BigDecimal(Double.toString(consultingFeeTotal));
                            BigDecimal bigDecima2 = new BigDecimal(Double.toString(form.getLoanTotalAmount()));
                            BigDecimal bigDecima3 = new BigDecimal(Double.toString(form.getTotalDays()));
                            BigDecimal divide = bigDecimal.divide(bigDecima2, 2, RoundingMode.HALF_UP);
                            BigDecimal divide1 = divide.divide(bigDecima3, 2, RoundingMode.HALF_UP);
                            form.setMarketFeeRate(divide1.doubleValue());
                            form.setAdviceFee(consultingFeeTotal);
                            form.setActualFee(receivableTotal);
                            discountApplicationDao.updateLoanGeneralInfo(form);
                            //驳回后重新启动流程
                            startProAfterUpdate(form);
                        }
                    }
                }
            }
            return form;
    }

    private void startProAfterUpdate(RestartDiscountSaveForm form) throws Exception {
        // 通过任务id和事项编码查询组装接口所需参数
        RefuseWarrantyReviewForm refuseWarrantyReviewForm = form.getRefuseWarrantyReviewForm();

        RefuseWarrantyReviewModel refuseWarrantyReviewModel = examinerReviewDao.refuseWarrantyReview(refuseWarrantyReviewForm);
        TaskDealPassForm taskDealPassForm = new TaskDealPassForm();
        TaskNodeItemForm taskNodeItemForm = new TaskNodeItemForm();
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
    }
}
