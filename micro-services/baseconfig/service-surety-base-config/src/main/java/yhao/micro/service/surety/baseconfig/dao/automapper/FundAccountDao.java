package yhao.micro.service.surety.baseconfig.dao.automapper;

import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.baseconfig.apilist.form.FundAccountQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.FundAccountSaveForm;
import yhao.micro.service.surety.baseconfig.apilist.form.StatusChangeForm;
import yhao.micro.service.surety.baseconfig.apilist.model.FundAccountModel;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2018-12-10
 * Time: 19:44
 */
public interface FundAccountDao {
    List<FundAccountModel> query(FundAccountQueryForm form);

    void query(Pagination<FundAccountModel> page, FundAccountQueryForm form);

    int update(FundAccountSaveForm form);

    int insert(FundAccountSaveForm form);

    int statusChange(StatusChangeForm form);

    int deleteById(IdForm form);
}
