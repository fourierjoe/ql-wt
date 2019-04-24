package yhao.micro.service.surety.business.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.infra.common.util.CommonListUtil;
import yhao.micro.service.constants.CommonConstants;
import yhao.micro.service.constants.enums.YNEnum;
import yhao.micro.service.constants.util.WrapDozerUtil;
import yhao.micro.service.surety.business.apilist.form.complex.DiscountApplicationSaveForm;
import yhao.micro.service.surety.business.apilist.form.guarantee.*;
import yhao.micro.service.surety.business.apilist.model.businessType.BusinessTypeModel;
import yhao.micro.service.surety.business.apilist.model.guarantee.*;
import yhao.micro.service.surety.business.apilist.model.guarantee.page.GuaranteePageModel;
import yhao.micro.service.surety.business.dao.automapper.BusinessTypeDao;
import yhao.micro.service.surety.business.dao.automapper.GuaranteeDao;
import yhao.micro.service.surety.business.service.validate.guarantee.InterfaceValidate;
import yhao.micro.service.surety.business.service.validate.guarantee.factory.ValidateFactory;
import yhao.micro.service.surety.business.utils.primaryKeyGenerate.GenerateGuaranteeNumberService;
import yhao.micro.service.workflow.apilist.enums.flow.ConditionNameType;
import yhao.micro.service.workflow.apilist.enums.task.TaskStatus;
import yhao.micro.service.workflow.apilist.form.task.*;
import yhao.micro.service.workflow.apilist.model.task.RefuseTaskItemModel;
import yhao.micro.service.workflow.apilist.model.task.TaskNodeItemModel;
import yhao.micro.service.workflow.apilist.restful.TaskFeign;

import javax.annotation.Resource;
import javax.validation.Validator;
import java.util.*;

/**
 * @Description:
 * @Created by ql on 2019/1/2 20:07
 * @Version: v1.0
 */
@Service
public class GuaranteeService {
	private Logger logger = LoggerFactory.getLogger(GuaranteeService.class);
	@Resource
	private GuaranteeDao guaranteeDao;
	@Resource
	private BusinessTypeDao businessTypeDao;
	@Resource
	private TaskFeign taskFeign;
	@Resource
	private DiscountApplicationService discountApplicationService;
	@Resource
	private GenerateGuaranteeNumberService generateGuaranteeNumberService;
	@Resource
	private ValidateFactory validateFactory;
	@Resource
	private Validator validate;

	@Transactional
	public GuaranteeForm saveGuarantee(GuaranteeForm form) {
		checkInterface(form);
		// 担保单ID
		String guaranteePid = UUID.randomUUID().toString();

		form.getGuaranteeSaveForm().setId(guaranteePid);
		String guaranteeNum = generateGuaranteeNumberService.generateGuaranteeNumber(form.getGuaranteeSaveForm().getOrgId(), 4);
		form.getGuaranteeSaveForm().setGuaranteeNum(guaranteeNum);
		guaranteeDao.saveGuarantee(form.getGuaranteeSaveForm());

		// 合伙人信息
		List<GuaranteePartnerSaveForm> guaranteePartnerSaveFormList = form.getGuaranteePartnerSaveFormList();
		Optional.ofNullable(guaranteePartnerSaveFormList).orElseThrow(() -> new RuntimeException("合伙人信息不能为空"))
				.forEach(guaranteePartnerSaveForm -> {
					guaranteePartnerSaveForm.setId(UUID.randomUUID().toString());
					guaranteePartnerSaveForm.setGuaranteeId(guaranteePid);
				});
		if (!CommonListUtil.isEmpty(guaranteePartnerSaveFormList)) {
			guaranteeDao.batchSavePartner(guaranteePartnerSaveFormList);
		}

		// 业主物业信息
		Optional.ofNullable(form.getEstateSellerFormList()).orElseThrow(() -> new RuntimeException("业主物业信息不能为空"))
				.forEach(estateSellerForm -> {
					String estateSellerId = UUID.randomUUID().toString();
					estateSellerForm.getEstateSellerSaveForm().setId(estateSellerId);
					estateSellerForm.getEstateSellerSaveForm().setGuaranteeId(guaranteePid);
					guaranteeDao.saveEstateSeller(estateSellerForm.getEstateSellerSaveForm());

					estateSellerForm.getEstateSellerSaveForm().getPersonInfoTradesSaveFormList().forEach(personInfoTradesSaveForm -> {
						personInfoTradesSaveForm.setId(UUID.randomUUID().toString());
						personInfoTradesSaveForm.setGuaranteeId(guaranteePid);
						personInfoTradesSaveForm.setEstateId(estateSellerId);
					});

					if (!CommonListUtil.isEmpty(estateSellerForm.getEstateSellerSaveForm().getPersonInfoTradesSaveFormList())) {
						guaranteeDao.batchSavePersonInfoTrades(estateSellerForm.getEstateSellerSaveForm().getPersonInfoTradesSaveFormList());
					}
				});

		// 买家信息
		Optional.ofNullable(form.getBuyerPersonInfoTradesSaveFormList()).orElseThrow(() -> new RuntimeException("买家个人信息不得为空"))
				.forEach(buyerPersonInfoTradesSaveForm -> {
					buyerPersonInfoTradesSaveForm.setId(UUID.randomUUID().toString());
					buyerPersonInfoTradesSaveForm.setGuaranteeId(guaranteePid);
						});
		if (!CommonListUtil.isEmpty(form.getBuyerPersonInfoTradesSaveFormList())) {
			guaranteeDao.batchSavePersonInfoTrades(form.getBuyerPersonInfoTradesSaveFormList());
		}

		// 原贷款情况
		form.getLoanSellerSaveForm().setId(UUID.randomUUID().toString());
		form.getLoanSellerSaveForm().setGuaranteeId(guaranteePid);
		guaranteeDao.saveLoanSeller(form.getLoanSellerSaveForm());

		// 成交情况
		form.getTransactionGuaranteeInfoSaveForm().setId(UUID.randomUUID().toString());
		form.getTransactionGuaranteeInfoSaveForm().setGuaranteeId(guaranteePid);
		guaranteeDao.saveTransactionGuaranteeInfo(form.getTransactionGuaranteeInfoSaveForm());

		// 新贷款信息
		form.getLoanBuyerSaveForm().setId(UUID.randomUUID().toString());
		form.getLoanBuyerSaveForm().setGuaranteeId(guaranteePid);
		guaranteeDao.saveLoanBuyer(form.getLoanBuyerSaveForm());

		List<LoanPaymentSaveForm> loanPaymentSaveFormList = form.getLoanPaymentSaveFormList();
		if (!CommonListUtil.isEmpty(loanPaymentSaveFormList)) {
			loanPaymentSaveFormList.forEach(loanPaymentSaveForm -> {
				loanPaymentSaveForm.setId(UUID.randomUUID().toString());
				loanPaymentSaveForm.setGuaranteeId(guaranteePid);
			});
			if (!CommonListUtil.isEmpty(loanPaymentSaveFormList)) {
				guaranteeDao.batchSaveLoanPayment(loanPaymentSaveFormList);
			}
		}

		// 担保情况
		form.getGuaranteeSituationSaveForm().setId(UUID.randomUUID().toString());
		form.getGuaranteeSituationSaveForm().setGuaranteeId(guaranteePid);
		guaranteeDao.saveGuaranteeSituation(form.getGuaranteeSituationSaveForm());

		// 保存反担保人信息
		if (!CommonListUtil.isEmpty(form.getAntiFormList())) {
			form.getAntiFormList().forEach(antiForm -> {
				String antiGuarantorId = UUID.randomUUID().toString();
				antiForm.getAntiGuarantorForm().setId(antiGuarantorId);
				antiForm.getAntiGuarantorForm().setGuaranteeId(guaranteePid);
				guaranteeDao.saveAntiGuarantor(antiForm.getAntiGuarantorForm());

				antiForm.getAntiEstateSaveFormList().forEach(antiEstateSaveForm -> {
					antiEstateSaveForm.setId(UUID.randomUUID().toString());
					antiEstateSaveForm.setGuaranteeId(guaranteePid);
					antiEstateSaveForm.setAntiGuarantorId(antiGuarantorId);
				});

				if (!CommonListUtil.isEmpty(antiForm.getAntiEstateSaveFormList())) {
					guaranteeDao.batchSaveAntiGuarantorEstate(antiForm.getAntiEstateSaveFormList());
				}
			});
		}

		// 借款概况信息
		form.getLoanGeneralSaveForm().setId(UUID.randomUUID().toString());
		form.getLoanGeneralSaveForm().setGuaranteeId(guaranteePid);
		guaranteeDao.saveLoanGeneral(form.getLoanGeneralSaveForm());

		// 借款明细信息
		List<LoanDetailsSaveForm> loanDetailsSaveFormList = form.getLoanDetailsSaveFormList();
		if (!CommonListUtil.isEmpty(loanDetailsSaveFormList)) {
			loanDetailsSaveFormList.forEach(loanDetailsSaveForm -> {
				loanDetailsSaveForm.setId(UUID.randomUUID().toString());
				loanDetailsSaveForm.setGuaranteeId(guaranteePid);
			});
			if (!CommonListUtil.isEmpty(loanDetailsSaveFormList)) {
				guaranteeDao.batchSaveLoanDetails(loanDetailsSaveFormList);
			}
		}

		// 交易类现金回款计划信息
		List<TransactionTypeReceivePaymentPlanSaveForm> transactionTypeReceivePaymentPlanSaveFormList = form.getTransactionTypeReceivePaymentPlanSaveFormList();
		if (!CommonListUtil.isEmpty(transactionTypeReceivePaymentPlanSaveFormList)) {

			transactionTypeReceivePaymentPlanSaveFormList.forEach(transactionTypeReceivePaymentPlanSaveForm -> {
				transactionTypeReceivePaymentPlanSaveForm.setId(UUID.randomUUID().toString());
				transactionTypeReceivePaymentPlanSaveForm.setGuaranteeId(guaranteePid);
			});
			if (!CommonListUtil.isEmpty(transactionTypeReceivePaymentPlanSaveFormList)) {
				guaranteeDao.saveTransactionTypeReceivePaymentPlanSaveFormList(transactionTypeReceivePaymentPlanSaveFormList);
			}
		}

		if (form.getSave() == YNEnum.YES) {
			// 根据业务主键到Task表查看此单据是否为首次发起,任务表中无记录则发起流程,有记录则处理事项
			TaskNodeItemModel taskNodeItemModel = guaranteeDao.selectIsFirstTask(form.getId());
			if (StringUtils.isEmpty(taskNodeItemModel.getTaskId())) { //无任务则发起任务
				startTask(form, guaranteePid);
			} else { //不发起任务,完成事项
				passTaskAuto(form, taskNodeItemModel);
			}

			// 调用打折申请接口, 发起任务和处理事项都要重新发起打折申请
			transferDiscountApplication(form, guaranteePid);
		}

		return form;
	}

	@Transactional
	public GuaranteeForm updateGuarantee(GuaranteeForm form) {
		if (StringUtils.isEmpty(form.getId())) {
			throw new RuntimeException("你传的担保单ID呢??");
		}

		checkInterface(form);

		// 担保单ID
		String guaranteePid = form.getId();
		if (form.getGuaranteeSaveForm() != null) {
			guaranteeDao.updateGuarantee(form.getGuaranteeSaveForm());
		}

		// 合伙人信息
		List<GuaranteePartnerSaveForm> guaranteePartnerSaveFormList = form.getGuaranteePartnerSaveFormList();
		// 查询数据库中合伙人的ID数据
		List<String> partnerIdList = guaranteeDao.queryPartner(form.getId());
		List<GuaranteePartnerSaveForm> insertPartnerList = Lists.newArrayList();
		List<GuaranteePartnerSaveForm> updatePartnerList = Lists.newArrayList();
		List<String> deletePartnerList = Lists.newArrayList();

		Map<String, GuaranteePartnerSaveForm> guaranteePartnerSaveFormHashMap = Maps.newHashMap();
		guaranteePartnerSaveFormList.forEach(guaranteePartnerSaveForm -> {
			guaranteePartnerSaveFormHashMap.put(guaranteePartnerSaveForm.getId(), guaranteePartnerSaveForm);
		});

		for (Map.Entry<String, GuaranteePartnerSaveForm> entry:guaranteePartnerSaveFormHashMap.entrySet()) {
			if (partnerIdList.contains(entry.getKey())) {
				entry.getValue().setGuaranteeId(guaranteePid);
				updatePartnerList.add(entry.getValue());
			} else {
				entry.getValue().setId(UUID.randomUUID().toString());
				entry.getValue().setGuaranteeId(guaranteePid);
				insertPartnerList.add(entry.getValue());
			}
			partnerIdList.remove(entry.getKey());
		}
		deletePartnerList.addAll(partnerIdList);

		if (!CommonListUtil.isEmpty(updatePartnerList)) {
			guaranteeDao.batchUpdatePartner(updatePartnerList);
		}
		if (!CommonListUtil.isEmpty(deletePartnerList)) {
			guaranteeDao.batchDeletePartner(deletePartnerList);
		}
		if (!CommonListUtil.isEmpty(insertPartnerList)) {
			guaranteeDao.batchSavePartner(insertPartnerList);
		}

		// 业主物业信息
		// 查询数据库中物业的ID数据
		List<EstateSellerModel> estateSellerModelList = guaranteeDao.queryEstateSellerPersonInfo(form.getId());
		// Map<物业ID, List<业主ID>>
		Map<String, List<String>> personInfoTradesModelMap = Maps.newHashMap();
		for (EstateSellerModel estateSellerModel:estateSellerModelList) {
			List<String> personIdList = personInfoTradesModelMap.get(estateSellerModel.getId());
			if (personIdList == null) {
				personIdList = Lists.newArrayList();
			}
			personIdList.add(estateSellerModel.getPersonId());
			personInfoTradesModelMap.put(estateSellerModel.getId(),personIdList);
		}

		//物业信息 1
		List<EstateSellerSaveForm> insertEstateSellerSaveList = Lists.newArrayList();
		List<EstateSellerSaveForm> updateEstateSellerSaveList = Lists.newArrayList();
		List<String> deleteEstateSellerList = Lists.newArrayList();

		// 业主信息 多
		List<PersonInfoTradesSaveForm> insertSellerSaveList = Lists.newArrayList();
		List<PersonInfoTradesSaveForm> updateSellerSaveList = Lists.newArrayList();
		List<String> deleteSellerList = Lists.newArrayList();

		for (EstateSellerForm estateSellerForm:form.getEstateSellerFormList()) {
			if (personInfoTradesModelMap.containsKey(estateSellerForm.getEstateSellerSaveForm().getId())) {

				estateSellerForm.getEstateSellerSaveForm().setGuaranteeId(guaranteePid);
				updateEstateSellerSaveList.add(estateSellerForm.getEstateSellerSaveForm());
				for (PersonInfoTradesSaveForm personInfoTradesSaveForm:estateSellerForm.getEstateSellerSaveForm().getPersonInfoTradesSaveFormList()) {
					if (personInfoTradesModelMap.get(estateSellerForm.getEstateSellerSaveForm().getId()).contains(personInfoTradesSaveForm.getId())) {
						// 人员信息存在
						personInfoTradesSaveForm.setGuaranteeId(guaranteePid);
						personInfoTradesSaveForm.setEstateId(estateSellerForm.getEstateSellerSaveForm().getId());
						updateSellerSaveList.add(personInfoTradesSaveForm);
						// 根据物业号删除
						personInfoTradesModelMap.get(estateSellerForm.getEstateSellerSaveForm().getId()).remove(personInfoTradesSaveForm.getId());
					} else {
						personInfoTradesSaveForm.setId(UUID.randomUUID().toString());
						personInfoTradesSaveForm.setEstateId(estateSellerForm.getEstateSellerSaveForm().getId());
						personInfoTradesSaveForm.setGuaranteeId(guaranteePid);
						insertSellerSaveList.add(personInfoTradesSaveForm);
					}
					personInfoTradesModelMap.get(estateSellerForm.getEstateSellerSaveForm().getId()).remove(personInfoTradesSaveForm.getId());
				}
				deleteSellerList.addAll(personInfoTradesModelMap.get(estateSellerForm.getEstateSellerSaveForm().getId()));
			} else {
				String newEstateId = UUID.randomUUID().toString();
				estateSellerForm.getEstateSellerSaveForm().setId(newEstateId);
				estateSellerForm.getEstateSellerSaveForm().setGuaranteeId(guaranteePid);
				insertEstateSellerSaveList.add(estateSellerForm.getEstateSellerSaveForm());

				// 新的物业,人员信息全部添加
				List<PersonInfoTradesSaveForm> list = estateSellerForm.getEstateSellerSaveForm().getPersonInfoTradesSaveFormList();
				for (PersonInfoTradesSaveForm personInfoTradesSaveForm:list) {
					personInfoTradesSaveForm.setId(UUID.randomUUID().toString());
					personInfoTradesSaveForm.setGuaranteeId(guaranteePid);
					personInfoTradesSaveForm.setEstateId(newEstateId);
				}
				insertSellerSaveList.addAll(list);
			}
			personInfoTradesModelMap.remove(estateSellerForm.getEstateSellerSaveForm().getId());
		}
		deleteEstateSellerList.addAll(personInfoTradesModelMap.keySet());

		if (!CommonListUtil.isEmpty(updateEstateSellerSaveList)) {
			guaranteeDao.batchUpdateEstateSeller(updateEstateSellerSaveList);
		}
		if (!CommonListUtil.isEmpty(deleteEstateSellerList)) {
			guaranteeDao.batchDeleteEstateSeller(deleteEstateSellerList);
			// 人员表中根据物业ID删除
			guaranteeDao.batchDeletePersonInfoTradesByEstateId(deleteEstateSellerList);
		}
		if (!CommonListUtil.isEmpty(updateSellerSaveList)) {
			guaranteeDao.batchUpdatePersonInfoTrades(updateSellerSaveList);
		}
		if (!CommonListUtil.isEmpty(deleteSellerList)) {
			// 人员表中根据人员ID删除
			guaranteeDao.batchDeletePersonInfoTrades(deleteSellerList);
		}

		if (!CommonListUtil.isEmpty(insertEstateSellerSaveList)) {
			guaranteeDao.batchSaveEstateSeller(insertEstateSellerSaveList);
		}
		if (!CommonListUtil.isEmpty(insertSellerSaveList)) {
			guaranteeDao.batchSavePersonInfoTrades(insertSellerSaveList);
		}

		// 买家信息
		buyerPersonUpdate(form, guaranteePid);

		// 原贷款情况
		form.getLoanSellerSaveForm().setGuaranteeId(guaranteePid);
		if (form.getLoanSellerSaveForm() != null) {
			guaranteeDao.updateLoanSeller(form.getLoanSellerSaveForm());
		}

		// 成交情况
		form.getTransactionGuaranteeInfoSaveForm().setGuaranteeId(guaranteePid);
		if (form.getTransactionGuaranteeInfoSaveForm() != null) {
			guaranteeDao.updateTransactionGuaranteeInfo(form.getTransactionGuaranteeInfoSaveForm());
		}

		// 新贷款信息
		form.getLoanBuyerSaveForm().setGuaranteeId(guaranteePid);
		if (form.getLoanBuyerSaveForm() != null) {
			guaranteeDao.updateLoanBuyer(form.getLoanBuyerSaveForm());
		}

		// 非交易现金新贷款
		List<LoanPaymentSaveForm> loanPaymentSaveFormList = form.getLoanPaymentSaveFormList();
		// 查询数据库中合伙人的ID数据
		List<String> loanPaymentIdList = guaranteeDao.queryLoanPayment(form.getId());
		List<LoanPaymentSaveForm> insertLoanPaymentList = Lists.newArrayList();
		List<LoanPaymentSaveForm> updateLoanPaymentList = Lists.newArrayList();
		List<String> deleteLoanPaymentList = Lists.newArrayList();

		Map<String, LoanPaymentSaveForm> loanPaymentSaveFormHashMap = Maps.newHashMap();
		if (null != loanPaymentSaveFormList) {
			for (LoanPaymentSaveForm loanPaymentSaveForm:loanPaymentSaveFormList) {
				loanPaymentSaveFormHashMap.put(loanPaymentSaveForm.getId(), loanPaymentSaveForm);
			}
		}

		for (Map.Entry<String, LoanPaymentSaveForm> entry:loanPaymentSaveFormHashMap.entrySet()) {
			if (loanPaymentIdList.contains(entry.getKey())) {
				entry.getValue().setGuaranteeId(guaranteePid);
				updateLoanPaymentList.add(entry.getValue());
			} else {
				entry.getValue().setId(UUID.randomUUID().toString());
				entry.getValue().setGuaranteeId(guaranteePid);
				insertLoanPaymentList.add(entry.getValue());
			}
			loanPaymentIdList.remove(entry.getKey());
		}
		deleteLoanPaymentList.addAll(partnerIdList);

		if (!CommonListUtil.isEmpty(updateLoanPaymentList)) {
			guaranteeDao.batchUpdateLoanPayment(updateLoanPaymentList);
		}
		if (!CommonListUtil.isEmpty(deleteLoanPaymentList)) {
			guaranteeDao.batchDeleteLoanPayment(deleteLoanPaymentList);
		}
		if (!CommonListUtil.isEmpty(insertLoanPaymentList)) {
			guaranteeDao.batchSaveLoanPayment(insertLoanPaymentList);
		}

		// 担保情况
		form.getGuaranteeSituationSaveForm().setGuaranteeId(guaranteePid);
		if (form.getGuaranteeSituationSaveForm() != null) {
			guaranteeDao.updateGuaranteeSituation(form.getGuaranteeSituationSaveForm());
		}

		// 保存反担保人信息
		List<AntiModel> antiModels = guaranteeDao.queryAnti(form.getId());
		// Map<反担保人ID, List<房产ID>>
		Map<String, List<String>> antiModelMap = Maps.newHashMap();
		for (AntiModel antiModel:antiModels) {
			List<String> estateIdList = antiModelMap.get(antiModel.getId());
			if (estateIdList == null) {
				estateIdList = Lists.newArrayList();
			}
			estateIdList.add(antiModel.getEstateId());
			antiModelMap.put(antiModel.getId(),estateIdList);
		}

		// 反担保人信息 1
		List<AntiGuarantorSaveForm> insertAntiPersonSaveList = Lists.newArrayList();
		List<AntiGuarantorSaveForm> updateAntiPersonSaveList = Lists.newArrayList();
		List<String> deleteAntiPersonList = Lists.newArrayList();

		// 房产信息 多
		List<AntiEstateSaveForm> insertAntiEstateSaveList = Lists.newArrayList();
		List<AntiEstateSaveForm> updateAntiEstateSaveList = Lists.newArrayList();
		List<String> deleteAntiEstateList = Lists.newArrayList();

		for (AntiForm antiForm:form.getAntiFormList()) {
			if (antiModelMap.containsKey(antiForm.getAntiGuarantorForm().getId())) {

				antiForm.getAntiGuarantorForm().setGuaranteeId(guaranteePid);
				updateAntiPersonSaveList.add(antiForm.getAntiGuarantorForm());
				for (AntiEstateSaveForm antiEstateSaveForm:antiForm.getAntiEstateSaveFormList()) {
					if (antiModelMap.get(antiForm.getAntiGuarantorForm().getId()).contains(antiEstateSaveForm.getId())) {
						// 人员信息存在
						antiEstateSaveForm.setGuaranteeId(guaranteePid);
						antiEstateSaveForm.setAntiGuarantorId(antiForm.getAntiGuarantorForm().getId());
						updateAntiEstateSaveList.add(antiEstateSaveForm);
						// 根据物业号删除
						antiModelMap.get(antiForm.getAntiGuarantorForm().getId()).remove(antiEstateSaveForm.getId());
					} else {
						antiEstateSaveForm.setId(UUID.randomUUID().toString());
						antiEstateSaveForm.setAntiGuarantorId(antiForm.getAntiGuarantorForm().getId());
						antiEstateSaveForm.setGuaranteeId(guaranteePid);
						insertAntiEstateSaveList.add(antiEstateSaveForm);
					}
					antiModelMap.get(antiForm.getAntiGuarantorForm().getId()).remove(antiEstateSaveForm.getId());
				}
				deleteAntiEstateList.addAll(antiModelMap.get(antiForm.getAntiGuarantorForm().getId()));
			} else {
				String newAntiGuarantorId = UUID.randomUUID().toString();
				antiForm.getAntiGuarantorForm().setId(newAntiGuarantorId);
				antiForm.getAntiGuarantorForm().setGuaranteeId(guaranteePid);
				insertAntiPersonSaveList.add(antiForm.getAntiGuarantorForm());

				// 新的物业,人员信息全部添加
				List<AntiEstateSaveForm> list = antiForm.getAntiEstateSaveFormList();
				for (AntiEstateSaveForm antiEstateSaveForm:list) {
					antiEstateSaveForm.setId(UUID.randomUUID().toString());
					antiEstateSaveForm.setGuaranteeId(guaranteePid);
					antiEstateSaveForm.setAntiGuarantorId(newAntiGuarantorId);
				}
				insertAntiEstateSaveList.addAll(list);
			}
			antiModelMap.remove(antiForm.getAntiGuarantorForm().getId());
		}
		deleteAntiPersonList.addAll(antiModelMap.keySet());

		if (!CommonListUtil.isEmpty(updateAntiPersonSaveList)) {
			guaranteeDao.batchUpdateAntiPerson(updateAntiPersonSaveList);
		}
		if (!CommonListUtil.isEmpty(deleteAntiPersonList)) {
			guaranteeDao.batchDeleteAntiPerson(deleteAntiPersonList);
			guaranteeDao.batchDeleteAntiEstateByAntiPersonId(deleteAntiPersonList);
		}
		if (!CommonListUtil.isEmpty(updateAntiEstateSaveList)) {
			guaranteeDao.batchUpdateAntiEstate(updateAntiEstateSaveList);
		}
		if (!CommonListUtil.isEmpty(deleteAntiEstateList)) {
			guaranteeDao.batchDeleteAntiEstate(deleteAntiEstateList);
		}

		if (!CommonListUtil.isEmpty(insertAntiPersonSaveList)) {
			guaranteeDao.batchSaveAntiPerson(insertAntiPersonSaveList);
		}
		if (!CommonListUtil.isEmpty(insertAntiEstateSaveList)) {
			guaranteeDao.batchSaveAntiGuarantorEstate(insertAntiEstateSaveList);
		}

		// 借款概况信息
		form.getLoanGeneralSaveForm().setGuaranteeId(guaranteePid);
		if (form.getLoanGeneralSaveForm() != null) {
			guaranteeDao.updateLoanGeneral(form.getLoanGeneralSaveForm());
		}


		// 借款明细信息
		List<LoanDetailsSaveForm> loanDetailsSaveFormList = form.getLoanDetailsSaveFormList();
		// 查询数据库中借款明细信息的ID数据
		List<String> loanDetailsIdList = guaranteeDao.queryloanDetails(form.getId());
		List<LoanDetailsSaveForm> insertLoanDetailsList = Lists.newArrayList();
		List<LoanDetailsSaveForm> updateLoanDetailsList = Lists.newArrayList();
		List<String> deleteLoanDetailsList = Lists.newArrayList();

		Map<String, LoanDetailsSaveForm> loanDetailsSaveFormHashMap = Maps.newHashMap();
		for (LoanDetailsSaveForm loanDetailsSaveForm:loanDetailsSaveFormList) {
			loanDetailsSaveFormHashMap.put(loanDetailsSaveForm.getId(), loanDetailsSaveForm);
		}

		for (Map.Entry<String, LoanDetailsSaveForm> entry:loanDetailsSaveFormHashMap.entrySet()) {
			if (loanDetailsIdList.contains(entry.getKey())) {
				entry.getValue().setGuaranteeId(guaranteePid);
				updateLoanDetailsList.add(entry.getValue());
			} else {
				entry.getValue().setId(UUID.randomUUID().toString());
				entry.getValue().setGuaranteeId(guaranteePid);
				insertLoanDetailsList.add(entry.getValue());
			}
			loanDetailsIdList.remove(entry.getKey());
		}
		deleteLoanDetailsList.addAll(partnerIdList);

		if (!CommonListUtil.isEmpty(updateLoanDetailsList)) {
			guaranteeDao.batchUpdateLoanDetails(updateLoanDetailsList);
		}
		if (!CommonListUtil.isEmpty(deleteLoanDetailsList)) {
			guaranteeDao.batchDeleteLoanDetails(deleteLoanDetailsList);
		}
		if (!CommonListUtil.isEmpty(insertLoanDetailsList)) {
			guaranteeDao.batchSaveLoanDetails(insertLoanDetailsList);
		}

		// 交易类现金回款计划信息
		List<TransactionTypeReceivePaymentPlanSaveForm> transactionTypeReceivePaymentPlanSaveFormList = form.getTransactionTypeReceivePaymentPlanSaveFormList();
		// 查询数据库中借款明细信息的ID数据
		List<String> transactionTypeReceivePaymentPlanIdList = guaranteeDao.queryTransactionTypeReceivePaymentPlan(form.getId());
		List<TransactionTypeReceivePaymentPlanSaveForm> insertTransactionTypeReceivePaymentPlanList = Lists.newArrayList();
		List<TransactionTypeReceivePaymentPlanSaveForm> updateTransactionTypeReceivePaymentPlanList = Lists.newArrayList();
		List<String> deleteTransactionTypeReceivePaymentPlanList = Lists.newArrayList();

		Map<String, TransactionTypeReceivePaymentPlanSaveForm> transactionTypeReceivePaymentPlanSaveFormHashMap = Maps.newHashMap();
		for (TransactionTypeReceivePaymentPlanSaveForm transactionTypeReceivePaymentPlanSaveForm:transactionTypeReceivePaymentPlanSaveFormList) {
			transactionTypeReceivePaymentPlanSaveFormHashMap.put(transactionTypeReceivePaymentPlanSaveForm.getId(), transactionTypeReceivePaymentPlanSaveForm);
		}

		for (Map.Entry<String, TransactionTypeReceivePaymentPlanSaveForm> entry:transactionTypeReceivePaymentPlanSaveFormHashMap.entrySet()) {
			if (transactionTypeReceivePaymentPlanIdList.contains(entry.getKey())) {
				entry.getValue().setGuaranteeId(guaranteePid);
				updateTransactionTypeReceivePaymentPlanList.add(entry.getValue());
			} else {
				entry.getValue().setId(UUID.randomUUID().toString());
				entry.getValue().setGuaranteeId(guaranteePid);
				insertTransactionTypeReceivePaymentPlanList.add(entry.getValue());
			}
			transactionTypeReceivePaymentPlanIdList.remove(entry.getKey());
		}
		deleteTransactionTypeReceivePaymentPlanList.addAll(partnerIdList);

		if (!CommonListUtil.isEmpty(updateTransactionTypeReceivePaymentPlanList)) {
			guaranteeDao.batchUpdateTransactionTypeReceivePaymentPlan(updateTransactionTypeReceivePaymentPlanList);
		}
		if (!CommonListUtil.isEmpty(deleteTransactionTypeReceivePaymentPlanList)) {
			guaranteeDao.batchDeleteTransactionTypeReceivePaymentPlan(deleteTransactionTypeReceivePaymentPlanList);
		}
		if (!CommonListUtil.isEmpty(insertTransactionTypeReceivePaymentPlanList)) {
			guaranteeDao.saveTransactionTypeReceivePaymentPlanSaveFormList(insertTransactionTypeReceivePaymentPlanList);
		}

		return form;
	}

	@Transactional
	public MainContractNumSaveForm saveMainContractNum(MainContractNumSaveForm form) {
		guaranteeDao.saveMainContractNum(form);
		return form;
	}

	public MainContractNumModel pickMainContractNum(IdForm form) {
		return guaranteeDao.pickMainContractNum(form.getId());
	}

	public GuaranteeModel pickGuarantee(IdForm form) {
		return guaranteeDao.pickGuarantee(form.getId());
	}

	public Pagination<GuaranteePageModel> queryGuaranteePage(GuaranteeQueryPageForm form) {
		var page = new Pagination<GuaranteePageModel>(form.getPageSize(), form.getCurrentPage());
		guaranteeDao.queryGuaranteePage(page, form);
		return page;
	}

	@Transactional
	public boolean cancelThisGuarantee(IdForm form) {
		// 更改任务状态
		taskFeign.cancelTask(form);
		return guaranteeDao.updateRecallState(form.getId()) > 0;
	}

	@Transactional
	public Boolean rejectGuarantee(IdForm form) {
		TaskDealRefuseForm taskDealRefuseForm = new TaskDealRefuseForm();
		RefuseTaskItemModel refuseTaskItemModel = taskFeign.pickRefuseForm(form).pickBody();

		TaskNodeItemForm taskNodeItemForm = WrapDozerUtil.map(refuseTaskItemModel, TaskNodeItemForm.class);
		// 驳回编码
		taskNodeItemForm.setItemResultCode(CommonConstants.R999);
		taskNodeItemForm.setItemFinishPerson(form.getOperatorId());
		taskNodeItemForm.setItemFinishPersonOrgId(form.getOperatorOrgId());
		taskNodeItemForm.setItemNecessary(YNEnum.NO);
		taskNodeItemForm.setItemCore(YNEnum.YES);

		taskDealRefuseForm.setTaskNodeItem(taskNodeItemForm);
		// 驳回到流程起始位置--报单员保单
		taskDealRefuseForm.setRefuseNodeId(refuseTaskItemModel.getInitialId());
		taskDealRefuseForm.setId(taskNodeItemForm.getTaskId());
		return taskFeign.refuseTask(taskDealRefuseForm).pickBody();
	}

	public Pagination<AssociateGuaranteeModel> associateGuarantee(AssociateGuaranteeForm form) {
		var page = new Pagination<AssociateGuaranteeModel>(form.getPageSize(), form.getCurrentPage());
		guaranteeDao.associateGuarantee(page, form);
		return page;
	}

	@Transactional
	public EstateFileSaveForm saveEstateFile(EstateFileSaveForm form) {
		form.setId(UUID.randomUUID().toString());
		guaranteeDao.saveEstateFile(form);
		return form;
	}

	public List<EstateFileModel> queryEstateFile(IdForm form) {
		return guaranteeDao.queryEstateFile(form.getId());
	}

	/**
	 * 检查是否打折申请
	 * @param form
	 * @return
	 */
	private boolean submitDiscount(GuaranteeForm form) {

		LoanGeneralSaveForm loanGeneralSaveForm = form.getLoanGeneralSaveForm();
		// 获取业务配置中的 实收费率&实收担保费
		BusinessTypeModel businessTypeModel = businessTypeDao.pickBusinessTypeById(form.getGuaranteeSaveForm().getBizId());
		//总对外费率  总手续费
		if (businessTypeModel.getMinRealRate().compareTo(loanGeneralSaveForm.getTotalMarketFeeRate()) == 1
				|| businessTypeModel.getMinCharge().compareTo(loanGeneralSaveForm.getCharges()) == 1) { //需要打折申请
			return true;
		}
		return  false;
	}

	private void buyerPersonUpdate (GuaranteeForm form, String guaranteePid) {
		// 买家信息
		List<PersonInfoTradesSaveForm> buyerPersonInfoTradesSaveFormList = form.getBuyerPersonInfoTradesSaveFormList();
		// 查询数据库中合伙人的ID数据
		List<String> buyerIdList = guaranteeDao.queryBuyer(form.getId());
		List<PersonInfoTradesSaveForm> insertBuyerList = Lists.newArrayList();
		List<PersonInfoTradesSaveForm> updateBuyerList = Lists.newArrayList();
		List<String> deleteBuyerList = Lists.newArrayList();

		Map<String, PersonInfoTradesSaveForm> buyerPersonInfoTradesSaveFormHashMap = Maps.newHashMap();
		buyerPersonInfoTradesSaveFormList.forEach(buyerPersonInfoTradesSaveForm -> {
			buyerPersonInfoTradesSaveFormHashMap.put(buyerPersonInfoTradesSaveForm.getId(), buyerPersonInfoTradesSaveForm);
		});

		for (Map.Entry<String, PersonInfoTradesSaveForm> entry:buyerPersonInfoTradesSaveFormHashMap.entrySet()) {
			if (buyerIdList.contains(entry.getKey())) {
				entry.getValue().setGuaranteeId(guaranteePid);
				updateBuyerList.add(entry.getValue());
			} else {
				entry.getValue().setId(UUID.randomUUID().toString());
				entry.getValue().setGuaranteeId(guaranteePid);
				insertBuyerList.add(entry.getValue());
			}
			buyerIdList.remove(entry.getKey());
		}
		deleteBuyerList.addAll(buyerIdList);

		if (!CommonListUtil.isEmpty(updateBuyerList)) {
			guaranteeDao.batchUpdatePersonInfoTrades(updateBuyerList);
		}
		if (!CommonListUtil.isEmpty(deleteBuyerList)) {
			guaranteeDao.batchDeletePersonInfoTrades(deleteBuyerList);
		}
		if (!CommonListUtil.isEmpty(insertBuyerList)) {
			guaranteeDao.batchSavePersonInfoTrades(insertBuyerList);
		}
	}

	/**
	 * 工厂类校验
	 * @param form
	 */
	private void checkInterface(GuaranteeForm form) {
		form.getEstateSellerFormList().forEach(estateSellerForm -> {
			if (estateSellerForm.getEstateSellerSaveForm().getIsModeling() == YNEnum.NO) { //无建模物业未勾选,物业名称/座落/房号必填
				if (oneOfThreeIsEmpty(estateSellerForm)) {
					throw new RuntimeException("无建模物业未勾选时,物业名称/座落/房号必填");
				}
			}
		});
		// 查询业务类型
		BizFundTypeAndTransactionTypeModel model =  businessTypeDao.pickBusinessType(form.getGuaranteeSaveForm().getBizId());

		// 工厂分类校验
		InterfaceValidate interfaceValidate = validateFactory.getInterfaceValidate(model);
		interfaceValidate.validate(form, validate);

	}

	private boolean oneOfThreeIsEmpty(EstateSellerForm estateSellerForm) {
		return StringUtils.isEmpty(estateSellerForm.getEstateSellerSaveForm().getPropertyName()) ||
				StringUtils.isEmpty(estateSellerForm.getEstateSellerSaveForm().getPropertyLocation()) ||
				StringUtils.isEmpty(estateSellerForm.getEstateSellerSaveForm().getPropertyRoomNo());
	}

	private void startTask(GuaranteeForm form, String guaranteePid) {
		// 发起流程
		TaskStartForm taskStartForm = new TaskStartForm();
		// 获取流程编码
		BusinessTypeModel businessTypeModel = businessTypeDao.pickBusinessTypeById(form.getGuaranteeSaveForm().getBizId());
		taskStartForm.setBizCodeStr(Optional.ofNullable(businessTypeModel.getWorkflowBizCode()).orElseThrow(() -> new RuntimeException("流程业务码不能为空")));
		taskStartForm.setBizEntityId(guaranteePid);
		TaskVariableSaveForm taskVariableSaveForm = new TaskVariableSaveForm();
		taskVariableSaveForm.setBizEntityId(guaranteePid);
		taskVariableSaveForm.setVariableName(ConditionNameType.GUARANTEE_AMOUNT);
		taskVariableSaveForm.setVariableText(form.getGuaranteeSituationSaveForm().getGuaranteeAmount().toString());
		taskStartForm.setTaskVariableSaveForm(taskVariableSaveForm);

		RequestResult<TaskStartForm> taskStartFormRequestResult = taskFeign.startNewTask(taskStartForm);
		if (!taskStartFormRequestResult.isSuccess()) {
			logger.error("启动任务接口调用失败...担保单id为: " + guaranteePid);
			throw new RuntimeException("启动任务接口调用失败...");
		}
	}

	private void passTaskAuto(GuaranteeForm form, TaskNodeItemModel taskNodeItemModel) {
		TaskDealPassForm taskDealPassForm = TaskDealPassForm.newTaskDealPassForm();
		taskDealPassForm.setStatus(TaskStatus.RUNNING);

		TaskNodeItemForm taskNodeItemForm = TaskNodeItemForm.newTaskNodeItemForm();
		taskNodeItemForm.setTaskId(taskNodeItemModel.getTaskId());
		taskNodeItemForm.setNodeId(taskNodeItemModel.getTaskNodeId());
		taskNodeItemForm.setItemId(taskNodeItemModel.getItemId());
		taskNodeItemForm.setItemCode(taskNodeItemModel.getItemCode());
		taskNodeItemForm.setItemResultCode(taskNodeItemModel.getItemResultCode());
		taskNodeItemForm.setItemFinishPerson(form.getOperatorId());
		taskNodeItemForm.setItemFinishPersonOrgId(form.getOperatorOrgId());
		taskDealPassForm.setTaskNodeItem(taskNodeItemForm);

		RequestResult<Boolean> booleanRequestResult = taskFeign.passTaskAuto(taskDealPassForm);
		if (!booleanRequestResult.isSuccess()) {
			logger.error("事项处理接口(报单员保单)调用失败...担保单id为: " + form.getId());
			throw new RuntimeException("事项处理接口(报单员保单)调用失败...");
		}
	}

	private void transferDiscountApplication (GuaranteeForm form, String guaranteePid) {
		if (submitDiscount(form)) { // 插入打折申请表数据
			DiscountApplicationSaveForm discountApplicationSaveForm = new DiscountApplicationSaveForm();
			discountApplicationSaveForm.setGuaranteeId(guaranteePid);
			discountApplicationSaveForm.setDiscountReason(form.getLoanGeneralSaveForm().getDiscountExplain());
			try {
				discountApplicationService.discountApplicationSave(discountApplicationSaveForm);
			} catch (Exception e) {
				throw new RuntimeException("创建打折申请接口调用失败...");
			}
		}
	}

}
