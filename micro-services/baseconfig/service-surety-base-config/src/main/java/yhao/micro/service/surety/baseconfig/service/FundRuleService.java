package yhao.micro.service.surety.baseconfig.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.infra.common.util.CommonDateUtil;
import yhao.micro.service.surety.baseconfig.apilist.form.FundRuleQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.FundRuleSaveForm;
import yhao.micro.service.surety.baseconfig.apilist.form.StatusChangeForm;
import yhao.micro.service.surety.baseconfig.apilist.model.FundRuleModel;
import yhao.micro.service.surety.baseconfig.dao.automapper.FundRuleDao;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2018-12-11
 * Time: 10:12
 */
@Service
public class FundRuleService {
    @Resource
    private FundRuleDao fundRuleDao;

    public Pagination<FundRuleModel> pageQuery(FundRuleQueryForm form) {
        if (form.getMinEffectiveDate() != null) {
            form.setMinEffectiveDate(CommonDateUtil.getZeroOfDay(form.getMinEffectiveDate()));
        }
        if (form.getMaxEffectiveDate() != null) {
            form.setMaxEffectiveDate(CommonDateUtil.getEndOfDay(form.getMaxEffectiveDate()));
        }
        if (form.getMinExpirationDate() != null) {
            form.setMinExpirationDate(CommonDateUtil.getZeroOfDay(form.getMinExpirationDate()));
        }
        if (form.getMaxExpirationDate() != null) {
            form.setMaxExpirationDate(CommonDateUtil.getEndOfDay(form.getMaxExpirationDate()));
        }
        Pagination<FundRuleModel> page = new Pagination<>(form.getPageSize(), form.getCurrentPage());
        fundRuleDao.query(page, form);
        return page;
    }

    public List<FundRuleModel> query(FundRuleQueryForm form) {
        if (form.getMinEffectiveDate() != null) {
            form.setMinEffectiveDate(CommonDateUtil.getZeroOfDay(form.getMinEffectiveDate()));
        }
        if (form.getMaxEffectiveDate() != null) {
            form.setMaxEffectiveDate(CommonDateUtil.getEndOfDay(form.getMaxEffectiveDate()));
        }
        if (form.getMinExpirationDate() != null) {
            form.setMinExpirationDate(CommonDateUtil.getZeroOfDay(form.getMinExpirationDate()));
        }
        if (form.getMaxExpirationDate() != null) {
            form.setMaxExpirationDate(CommonDateUtil.getEndOfDay(form.getMaxExpirationDate()));
        }
        return fundRuleDao.query(form);
    }

    public boolean save(FundRuleSaveForm form) {
        if (form.getEffectiveDate() != null) {
            form.setEffectiveDate(CommonDateUtil.getZeroOfDay(form.getEffectiveDate()));
        }
        if (form.getExpirationDate() != null) {
            form.setExpirationDate(CommonDateUtil.getEndOfDay(form.getExpirationDate()));
        }
        if (StringUtils.isNotBlank(form.getId())) {
            return fundRuleDao.update(form) > 0;
        }
        return fundRuleDao.insert(form) > 0;
    }

    public boolean statusChange(StatusChangeForm form) {
        return fundRuleDao.statusChange(form) > 0;
    }

    public boolean deleteById(IdForm form) {
        return fundRuleDao.deleteById(form) > 0;
    }
}
