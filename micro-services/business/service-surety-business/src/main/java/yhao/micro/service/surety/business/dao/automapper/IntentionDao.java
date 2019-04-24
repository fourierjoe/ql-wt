package yhao.micro.service.surety.business.dao.automapper;

import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.intention.CreditResultSaveForm;
import yhao.micro.service.surety.business.apilist.form.intention.FollowerTransferForm;
import yhao.micro.service.surety.business.apilist.form.intention.IntentionQueryForm;
import yhao.micro.service.surety.business.apilist.form.intention.IntentionRepaySaveForm;
import yhao.micro.service.surety.business.apilist.model.intention.intention.IntentionModel;
import yhao.micro.service.surety.business.apilist.model.intention.intention.IntentionPageModel;
import yhao.micro.service.surety.business.apilist.model.intention.repay.RepayModel;
import yhao.micro.service.surety.business.apilist.model.intention.credit.CreditModel;
import yhao.micro.service.surety.business.apilist.model.intention.follower.FollowerModel;
import yhao.micro.service.surety.business.apilist.model.intention.follower.FollowerPageModel;
import yhao.micro.service.surety.business.apilist.model.intention.repay.RepayPageModel;

import java.util.List;

/**
 * @Description:
 * @Created by ql on 2019/1/7 20:46
 * @Version: v1.0
 */
public interface IntentionDao {
	void deleteIntention(String id);
	void deleteAttachment(String id);
	void deletePerson(String id);

	int updateTransferState(FollowerTransferForm form);

	void queryIntentionPage(Pagination<IntentionPageModel> page, IntentionQueryForm form);

	IntentionModel selectIntention(String id);

	FollowerModel queryFollowerIntention(String id);

	void queryFollowerPage(Pagination<FollowerPageModel> page, IntentionQueryForm form);

	void saveCreditResult(List<CreditResultSaveForm> list);

	CreditModel pickCredit(String id);

	void queryCreditPage(Pagination<CreditModel> page, IntentionQueryForm form);

	void saveRepay(IntentionRepaySaveForm form);

	void updateRepay(IntentionRepaySaveForm form);

	void updateRepayState(IntentionRepaySaveForm form);

	RepayModel selectRepay(String id);

	void queryRepay(Pagination<RepayPageModel> page, IntentionQueryForm form);
}
