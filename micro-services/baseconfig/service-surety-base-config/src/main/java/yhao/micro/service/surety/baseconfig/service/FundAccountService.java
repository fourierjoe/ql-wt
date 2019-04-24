package yhao.micro.service.surety.baseconfig.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import yhao.infra.apilist.RequestResultException;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.baseconfig.apilist.form.FundAccountQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.FundAccountSaveForm;
import yhao.micro.service.surety.baseconfig.apilist.form.StatusChangeForm;
import yhao.micro.service.surety.baseconfig.apilist.model.FundAccountModel;
import yhao.micro.service.surety.baseconfig.dao.automapper.FundAccountDao;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2018-12-10
 * Time: 19:44
 */
@Service
public class FundAccountService {
    @Resource
    private FundAccountDao fundAccountDao;

    public Pagination<FundAccountModel> pageQuery(FundAccountQueryForm form) {
        Pagination<FundAccountModel> page = new Pagination<>(form.getPageSize(), form.getCurrentPage());
        fundAccountDao.query(page, form);
        return page;
    }

    public List<FundAccountModel> query(FundAccountQueryForm form){
        return fundAccountDao.query(form);
    }

    public boolean save(FundAccountSaveForm form) {
        if (StringUtils.isNotBlank(form.getId())) {
            return fundAccountDao.update(form) > 0;
        }
        return fundAccountDao.insert(form) > 0;
    }

    public boolean statusChange(StatusChangeForm form) {
        return fundAccountDao.statusChange(form) > 0;
    }

    public boolean deleteById(IdForm form) {
        return fundAccountDao.deleteById(form) > 0;
    }
}
