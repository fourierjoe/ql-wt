package yhao.micro.service.surety.erp.auth.dao.automapper;

import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.erp.auth.apilist.form.system.BizSystemQueryForm;
import yhao.micro.service.surety.erp.auth.apilist.form.system.BizSystemRelaDeleteForm;
import yhao.micro.service.surety.erp.auth.apilist.model.BizSystemModel;

import java.util.List;

/**
 * 业务系统配置服务层Service
 * Created by null on 2017-09-05
 */
public interface BizSystemDao {
	void insertBizSystem(BizSystemModel bizSystem);

	void updateBizSystem(BizSystemModel bizSystem);

	BizSystemModel selectById(String id);

	void queryBizSystem(Pagination<BizSystemModel> page, BizSystemQueryForm form);

	List<BizSystemModel> queryBizSystem(BizSystemQueryForm form);

	void deleteBizSystem(String id);

	BizSystemModel selectByKey(String key);

    void deletePositionData(BizSystemRelaDeleteForm form);

	void deletePersonData(BizSystemRelaDeleteForm form);
}
