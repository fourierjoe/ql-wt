package yhao.micro.service.surety.baseconfig.dao.automapper;

import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.baseconfig.apilist.form.IntentionConfigQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.IntentionConfigSaveForm;
import yhao.micro.service.surety.baseconfig.apilist.form.StatusChangeForm;
import yhao.micro.service.surety.baseconfig.apilist.model.IntentionConfigModel;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2018-12-11
 * Time: 15:06
 */
public interface IntentionConfigDao {
    List<IntentionConfigModel> query(IntentionConfigQueryForm form);

    void query(Pagination<IntentionConfigModel> page, IntentionConfigQueryForm form);

    int update(IntentionConfigSaveForm form);

    int insert(IntentionConfigSaveForm form);

    int statusChange(StatusChangeForm form);

    int deleteById(IdForm form);
}
