package yhao.micro.service.surety.erp.auth.dao.automapper;


import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.erp.auth.apilist.form.auth.PositionAuthQueryForm;
import yhao.micro.service.surety.erp.auth.apilist.model.AuthPositionLinkModel;

/**
 * Created by yoara on 2017/8/23.
 */
public interface PositionLinkDao {
    void queryPositionLink(Pagination<AuthPositionLinkModel> page, PositionAuthQueryForm param);
}
