package yhao.micro.service.surety.baseconfig.dao.automapper;

import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.baseconfig.apilist.form.FundRuleQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.FundRuleSaveForm;
import yhao.micro.service.surety.baseconfig.apilist.form.StatusChangeForm;
import yhao.micro.service.surety.baseconfig.apilist.model.FundRuleModel;

import java.util.List;

/**
 * 资金方案服务层Service
 * Created by Administrator on 2018-12-11
 */
public interface FundRuleDao{

    List<FundRuleModel> query(FundRuleQueryForm form);

    void query(Pagination<FundRuleModel> page, FundRuleQueryForm form);

    int update(FundRuleSaveForm form);

    int insert(FundRuleSaveForm form);

    int statusChange(StatusChangeForm form);

    int deleteById(IdForm form);
}
