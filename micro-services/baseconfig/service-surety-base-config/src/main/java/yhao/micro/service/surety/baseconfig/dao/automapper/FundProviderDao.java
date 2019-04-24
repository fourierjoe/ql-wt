package yhao.micro.service.surety.baseconfig.dao.automapper;

import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.baseconfig.apilist.form.FundProviderQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.FundProviderSaveForm;
import yhao.micro.service.surety.baseconfig.apilist.form.StatusChangeForm;
import yhao.micro.service.surety.baseconfig.apilist.model.FundProviderModel;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2018-12-11
 * Time: 14:01
 */
public interface FundProviderDao {

    List<FundProviderModel> query(FundProviderQueryForm form);

    void query(Pagination<FundProviderModel> page, FundProviderQueryForm form);

    List<FundProviderModel> queryAllChildByParent(FundProviderQueryForm form);

    int update(FundProviderSaveForm form);

    int insert(FundProviderSaveForm form);

    int statusChange(StatusChangeForm form);

    int deleteById(IdForm form);
}
