package yhao.micro.service.surety.business.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.infra.common.util.CommonListUtil;
import yhao.micro.service.constants.enums.YNEnum;
import yhao.micro.service.constants.util.WrapDozerUtil;
import yhao.micro.service.surety.baseconfig.apilist.model.IntentionConfigModel;
import yhao.micro.service.surety.baseconfig.apilist.restful.IntentionConfigFeign;
import yhao.micro.service.surety.business.apilist.form.guarantee.AttachmentSaveForm;
import yhao.micro.service.surety.business.apilist.form.guarantee.GuaranteeSaveForm;
import yhao.micro.service.surety.business.apilist.form.guarantee.PersonInfoTradesSaveForm;
import yhao.micro.service.surety.business.apilist.form.guarantee.RepaySaveForm;
import yhao.micro.service.surety.business.apilist.form.intention.*;
import yhao.micro.service.surety.business.apilist.model.enums.guarantee.CreditTypeEnum;
import yhao.micro.service.surety.business.apilist.model.enums.intention.CreditAndRepayScheduleEnum;
import yhao.micro.service.surety.business.apilist.model.enums.intention.RepayTypeEnum;
import yhao.micro.service.surety.business.apilist.model.intention.credit.CreditModel;
import yhao.micro.service.surety.business.apilist.model.intention.follower.FollowerModel;
import yhao.micro.service.surety.business.apilist.model.intention.follower.FollowerPageModel;
import yhao.micro.service.surety.business.apilist.model.intention.intention.IntentionModel;
import yhao.micro.service.surety.business.apilist.model.intention.intention.IntentionPageModel;
import yhao.micro.service.surety.business.apilist.model.intention.repay.RepayModel;
import yhao.micro.service.surety.business.apilist.model.intention.repay.RepayPageModel;
import yhao.micro.service.surety.business.dao.automapper.GuaranteeDao;
import yhao.micro.service.surety.business.dao.automapper.IntentionDao;
import yhao.micro.service.surety.business.utils.primaryKeyGenerate.GenerateGuaranteeNumberService;
import yhao.micro.service.surety.erp.org.apilist.model.PersonModel;
import yhao.micro.service.surety.erp.org.apilist.restful.PersonFeign;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Description:
 * @Created by ql on 2019/1/7 20:45
 * @Version: v1.0
 */
@Service
public class IntentionService {
	@Resource
	private IntentionDao intentionDao;
	@Resource
	private GuaranteeDao guaranteeDao;
	@Resource
	private GenerateGuaranteeNumberService generateGuaranteeNumberService;
	@Resource
	private IntentionConfigFeign intentionConfigFeign;
	@Resource
	private PersonFeign personFeign;

	@Transactional
	public IntentionForm saveIntention(IntentionForm form) {

		checkIntentionInterface(form);

		// 映射内部form
		List<IntentionAttachmentSaveForm> intentionAttachmentSaveFormList = form.getIntentionAttachmentSaveFormList();
		List<IntentionBuyerAndSellerSaveForm> intentionBuyerAndSellerSaveFormList = form.getIntentionBuyerAndSellerSaveFormList();
		List<AttachmentSaveForm> attachmentSaveFormList = WrapDozerUtil.mapList(intentionAttachmentSaveFormList, AttachmentSaveForm.class);
		List<PersonInfoTradesSaveForm> personInfoTradesSaveFormList = WrapDozerUtil.mapList(intentionBuyerAndSellerSaveFormList, PersonInfoTradesSaveForm.class);

		GuaranteeSaveForm guaranteeSaveForm = new GuaranteeSaveForm();
		String guaranteePid = UUID.randomUUID().toString();
		guaranteeSaveForm.setId(guaranteePid);
		// TODO: 2019/1/8
		String guaranteeNum = generateGuaranteeNumberService.generateGuaranteeNumber(form.getOrgId(), 4);
		guaranteeSaveForm.setGuaranteeNum(guaranteeNum);
		guaranteeSaveForm.setBizId(form.getBizId());
		guaranteeSaveForm.setOrgId(form.getOrgId());
		guaranteeSaveForm.setIsSubmit(form.getIsSubmit());

		// 获取跟单员ID
		IntentionConfigModel intentionConfigModel = intentionConfigFeign.pickFollowerByResponsibleOrgId(new IdForm(form.getOrgId())).pickBody();
		Optional.ofNullable(intentionConfigModel).ifPresent(a -> guaranteeSaveForm.setFollowerId(intentionConfigModel.getPersonId()));
//		guaranteeSaveForm.setFollowerId(intentionConfigModel.getPersonId());
		// 获取征信专员ID
		List<PersonModel> personModels = personFeign.queryCreditClerkByCityOrg(new IdForm(form.getOrgId())).pickBody();
		if (!CommonListUtil.isEmpty(personModels)) {
			guaranteeSaveForm.setCreditClerkId(personModels.get(0).getId());
		}

		// 征信进度状态
		if (form.getIntentionBuyerAndSellerSaveFormList().get(0).getCreditType() == CreditTypeEnum.MANAGERDEAL) {
			guaranteeSaveForm.setCreditState(CreditAndRepayScheduleEnum.NO_ARRANGE.toString());
		} else {
			guaranteeSaveForm.setCreditState(CreditAndRepayScheduleEnum.NO_DEAL.toString());
		}
		// 还款申请状态:未安排
		guaranteeSaveForm.setRepayState(CreditAndRepayScheduleEnum.NO_ARRANGE.toString());
		// 跟单员接受状态:未接收
		guaranteeSaveForm.setReceiveState(YNEnum.NO);
		guaranteeDao.saveGuarantee(guaranteeSaveForm);

		for (AttachmentSaveForm attachmentSaveForm:attachmentSaveFormList) {
			attachmentSaveForm.setId(UUID.randomUUID().toString());
			attachmentSaveForm.setGuaranteeId(guaranteePid);
		}
		if (!CommonListUtil.isEmpty(attachmentSaveFormList)) {
			guaranteeDao.batchSaveAttachment(attachmentSaveFormList);
		}

		for (PersonInfoTradesSaveForm personInfoTradesSaveForm:personInfoTradesSaveFormList) {
			personInfoTradesSaveForm.setId(UUID.randomUUID().toString());
			personInfoTradesSaveForm.setGuaranteeId(guaranteePid);
		}
		guaranteeDao.batchSavePersonInfoTrades(personInfoTradesSaveFormList);
		return form;
	}

	@Transactional
	public IntentionForm updateIntention(IntentionForm form) {
		if (StringUtils.isEmpty(form.getId())) {
			throw new RuntimeException("编辑接口,未传入单据ID");
		}

		// 映射内部form
		List<IntentionAttachmentSaveForm> intentionAttachmentSaveFormList = form.getIntentionAttachmentSaveFormList();
		List<IntentionBuyerAndSellerSaveForm> intentionBuyerAndSellerSaveFormList = form.getIntentionBuyerAndSellerSaveFormList();
		List<AttachmentSaveForm> attachmentSaveFormList = WrapDozerUtil.mapList(intentionAttachmentSaveFormList, AttachmentSaveForm.class);
		List<PersonInfoTradesSaveForm> personInfoTradesSaveFormList = WrapDozerUtil.mapList(intentionBuyerAndSellerSaveFormList, PersonInfoTradesSaveForm.class);

		String guaranteePid = form.getId();

		GuaranteeSaveForm guaranteeSaveForm = new GuaranteeSaveForm();
		guaranteeSaveForm.setId(guaranteePid);
		guaranteeSaveForm.setBizId(form.getBizId());

		// 征信进度状态,只是修改
		if (form.getIntentionBuyerAndSellerSaveFormList().get(0).getCreditType() == CreditTypeEnum.MANAGERDEAL) {
			guaranteeSaveForm.setCreditState(CreditAndRepayScheduleEnum.NO_ARRANGE.toString());
		}

		guaranteeDao.updateGuarantee(guaranteeSaveForm);

		// 批量修改附件信息
		// 查询数据库中合伙人的ID数据
		List<String> attachmentList = guaranteeDao.queryAttachment(form.getId());
		List<AttachmentSaveForm> insertAttachmentList = Lists.newArrayList();
		List<AttachmentSaveForm> updateAttachmentList = Lists.newArrayList();
		List<String> deleteAttachmentList = Lists.newArrayList();

		Map<String, AttachmentSaveForm> attachmentSaveFormHashMap = Maps.newHashMap();
		for (AttachmentSaveForm attachmentSaveForm:attachmentSaveFormList) {
			attachmentSaveFormHashMap.put(attachmentSaveForm.getId(), attachmentSaveForm);
		}

		for (Map.Entry<String, AttachmentSaveForm> entry:attachmentSaveFormHashMap.entrySet()) {
			if (attachmentList.contains(entry.getKey())) {
				entry.getValue().setGuaranteeId(guaranteePid);
				updateAttachmentList.add(entry.getValue());
			} else {
				entry.getValue().setId(UUID.randomUUID().toString());
				entry.getValue().setGuaranteeId(guaranteePid);
				insertAttachmentList.add(entry.getValue());
			}
			attachmentList.remove(entry.getKey());
		}
		deleteAttachmentList.addAll(attachmentList);
		if (insertAttachmentList.size() > 0) {
			guaranteeDao.batchSaveAttachment(insertAttachmentList);
		}
		if (updateAttachmentList.size() > 0) {
			guaranteeDao.batchUpdateAttachment(updateAttachmentList);
		}
		if (deleteAttachmentList.size() > 0) {
			guaranteeDao.batchDeleteAttachment(deleteAttachmentList);
		}

		// 批量修改业主/买家信息
		List<String> personIdList = guaranteeDao.queryPerson(form.getId());
		List<PersonInfoTradesSaveForm> insertPersonList = Lists.newArrayList();
		List<PersonInfoTradesSaveForm> updatePersonList = Lists.newArrayList();
		List<String> deletePersonList = Lists.newArrayList();

		Map<String, PersonInfoTradesSaveForm> personInfoTradesSaveFormHashMap = Maps.newHashMap();
		for (PersonInfoTradesSaveForm guaranteePartnerSaveForm:personInfoTradesSaveFormList) {
			personInfoTradesSaveFormHashMap.put(guaranteePartnerSaveForm.getId(), guaranteePartnerSaveForm);
		}

		for (Map.Entry<String, PersonInfoTradesSaveForm> entry:personInfoTradesSaveFormHashMap.entrySet()) {
			if (personIdList.contains(entry.getKey())) {
				entry.getValue().setGuaranteeId(guaranteePid);
				updatePersonList.add(entry.getValue());
			} else {
				entry.getValue().setId(UUID.randomUUID().toString());
				entry.getValue().setGuaranteeId(guaranteePid);
				insertPersonList.add(entry.getValue());
			}
			personIdList.remove(entry.getKey());
		}
		deletePersonList.addAll(personIdList);
		if (insertPersonList.size() > 0) {
			guaranteeDao.batchSavePersonInfoTrades(insertPersonList);
		}
		if (updatePersonList.size() > 0) {
			guaranteeDao.batchUpdatePersonInfoTrades(updatePersonList);
		}
		if (deletePersonList.size() > 0) {
			guaranteeDao.batchDeletePersonInfoTrades(deletePersonList);
		}

		return form;
	}

	@Transactional
	public boolean deleteIntention(IdForm form) {
		intentionDao.deleteIntention(form.getId());
		intentionDao.deleteAttachment(form.getId());
		intentionDao.deletePerson(form.getId());
		return true;
	}

	public Pagination<IntentionPageModel> intentionPage(IntentionQueryForm form) {
		var page = new Pagination<IntentionPageModel>(form.getPageSize(), form.getCurrentPage());
		intentionDao.queryIntentionPage(page, form);
		return page;
	}

	public IntentionModel intentionPick(IdForm form) {
		return intentionDao.selectIntention(form.getId());
	}


	/***********************************跟单员*********************************************/
	@Transactional
	public boolean followIntention(FollowerUpdateForm form) {

		checkFollowIntentionInterface(form);

		// 映射内部form
		List<FollowerBuyerAndSellerForm> followerBuyerAndSellerFormList = form.getFollowerBuyerAndSellerFormList();
		List<FollowerAttachmentForm> followerAttachmentFormList = form.getFollowerAttachmentFormList();

//		List<PersonInfoTradesSaveForm> personInfoTradesSaveFormList = WrapDozerUtil.mapList(followerBuyerAndSellerFormList, PersonInfoTradesSaveForm.class);
//		List<AttachmentSaveForm> attachmentSaveFormList = WrapDozerUtil.mapList(followerAttachmentFormList, AttachmentSaveForm.class);

		// 征信
		guaranteeDao.batchUpdateFollowerPersonInfoTrades(followerBuyerAndSellerFormList);
		// 档案资料清单
		guaranteeDao.batchUpdateFollowerAttachment(followerAttachmentFormList);

		// 增加还款申请
		FollowerRedeemForm followerRedeem = form.getFollowerRedeem();
		RepaySaveForm repaySaveForm = WrapDozerUtil.map(followerRedeem, RepaySaveForm.class);
		if (StringUtils.isNotEmpty(repaySaveForm.getId())) { // 修改

			guaranteeDao.updateRepay(repaySaveForm);
		} else { //新增
			repaySaveForm.setGuaranteeId(form.getId());
			repaySaveForm.setId(UUID.randomUUID().toString());
			guaranteeDao.saveRepay(repaySaveForm);
		}

		// 增加赎楼员ID, // 修改跟单员意见
		GuaranteeSaveForm guaranteeSaveForm = WrapDozerUtil.map(form, GuaranteeSaveForm.class);
		guaranteeSaveForm.setRedeemId(followerRedeem.getRedeemId());
		guaranteeDao.updateFollowerGuarantee(guaranteeSaveForm);

		return true;
	}

	@Transactional
	public Boolean followTransfer(FollowerTransferForm form) {
		return intentionDao.updateTransferState(form) > 0;
	}

	public FollowerModel followerPick(IdForm form) {
		return intentionDao.queryFollowerIntention(form.getId());
	}

	public Pagination<FollowerPageModel> followPage(IntentionQueryForm form) {
		var page = new Pagination<FollowerPageModel>(form.getPageSize(), form.getCurrentPage());
		intentionDao.queryFollowerPage(page, form);
		return page;
	}

	@Transactional
	public boolean creditDeal(CreditClerkSaveForm form) {

		// 新增征信结果
		List<CreditResultSaveForm> creditList = form.getCreditList();
		ArrayList<CreditResultSaveForm> saveFormArrayList = Lists.newArrayList();
		for (CreditResultSaveForm creditResultSaveForm:creditList) {
			if(StringUtils.isEmpty(creditResultSaveForm.getId())) {
				creditResultSaveForm.setId(UUID.randomUUID().toString());
				creditResultSaveForm.setGuaranteeId(form.getId());
				saveFormArrayList.add(creditResultSaveForm);
			}
		}
		if (!CommonListUtil.isEmpty(saveFormArrayList)) {
			intentionDao.saveCreditResult(saveFormArrayList);
		}

		// 设置征信办理时间
		if (form.getCreditState() == CreditAndRepayScheduleEnum.DEALED) {
			form.setCreditEndDate(new Date());
		}
		// 新增征信报送状态
		guaranteeDao.updateIsCreditReport(form);

		return true;
	}

	public CreditModel creditPick(IdForm form) {

		return intentionDao.pickCredit(form.getId());
	}

	public Pagination<CreditModel> creditPage(IntentionQueryForm form) {
		var page = new Pagination<CreditModel>(form.getPageSize(), form.getCurrentPage());
		intentionDao.queryCreditPage(page, form);
		return page;
	}

	/**
	 * 还款申请办理
	 * @param form
	 * @return
	 */
	@Transactional
	public Boolean repayDeal(IntentionRepaySaveForm form) {

		intentionDao.updateRepay(form);
		intentionDao.updateRepayState(form);
		return true;
	}

	public RepayModel repayPick(IdForm form) {

		return intentionDao.selectRepay(form.getId());
	}

	/**
	 * 还款申请分页
	 * @param form
	 * @return
	 */
	public Pagination<RepayPageModel> repayPage(IntentionQueryForm form) {
		Pagination<RepayPageModel> page = new Pagination<>(form.getPageSize(), form.getCurrentPage());
		intentionDao.queryRepay(page, form);
		return page;
	}

	private void checkIntentionInterface(IntentionForm form) {
		for(IntentionBuyerAndSellerSaveForm intentionBuyerAndSellerSaveForm : form.getIntentionBuyerAndSellerSaveFormList()) {
			if (intentionBuyerAndSellerSaveForm.getCreditType() != CreditTypeEnum.DETERMINED
					&& intentionBuyerAndSellerSaveForm.getCreditExpectedDate() != null) {
				throw new RuntimeException("征信时间不确定或不需要查征信时,请不要传征信时间...");
			}
		}
	}

	private void checkFollowIntentionInterface(FollowerUpdateForm form) {
		for (FollowerBuyerAndSellerForm followerBuyerAndSellerForm: form.getFollowerBuyerAndSellerFormList()) {
			if (followerBuyerAndSellerForm.getCreditType() != CreditTypeEnum.DETERMINED
					&& (followerBuyerAndSellerForm.getCreditExpectedDate() != null
					|| followerBuyerAndSellerForm.getCreditArrangeDate() != null)) {
				throw new RuntimeException("安排征信后才能传征信时间...");
			}

			if (form.getFollowerRedeem().getRepayType() != RepayTypeEnum.DETERMINED
					&& (form.getFollowerRedeem().getRepayExpectedDate() != null
					|| StringUtils.isNotEmpty(form.getFollowerRedeem().getRedeemId()))) {
				throw new RuntimeException("请检查还款申请输入框...");
			}
		}
	}

}
