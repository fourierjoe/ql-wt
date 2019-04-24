package yhao.micro.service.surety.baseconfig.service;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import yhao.infra.apilist.RequestResultException;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.baseconfig.apilist.enums.BaseConfigReturnCodeEnum;
import yhao.micro.service.surety.baseconfig.apilist.form.FundProviderQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.FundProviderSaveForm;
import yhao.micro.service.surety.baseconfig.apilist.form.StatusChangeForm;
import yhao.micro.service.surety.baseconfig.apilist.model.FundProviderModel;
import yhao.micro.service.surety.baseconfig.dao.automapper.FundProviderDao;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2018-12-11
 * Time: 14:01
 */
@Service
public class FundProviderService {
    @Resource
    private FundProviderDao fundProviderDao;

    public Pagination<FundProviderModel> pageQuery(FundProviderQueryForm form) {
        Pagination<FundProviderModel> page = new Pagination<>(form.getPageSize(), form.getCurrentPage());
        fundProviderDao.query(page, form);
        return page;
    }

    public List<FundProviderModel> query(FundProviderQueryForm form) {
        return fundProviderDao.query(form);
    }

    public List<FundProviderModel> queryAllChildByParent(FundProviderQueryForm form) {
        return fundProviderDao.queryAllChildByParent(form);
    }

    public boolean save(FundProviderSaveForm form) {
        FundProviderQueryForm queryForm = new FundProviderQueryForm();
        queryForm.setName(form.getName());
        queryForm.setExcludeId(form.getId());
        List<FundProviderModel> fundProviderModelList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(fundProviderModelList)) {
            throw new RequestResultException(BaseConfigReturnCodeEnum.F2000.getMessage(), BaseConfigReturnCodeEnum.F2000);
        }
        if (StringUtils.isNotBlank(form.getId())) {
            return fundProviderDao.update(form) > 0;
        }
        return fundProviderDao.insert(form) > 0;
    }

    public boolean statusChange(StatusChangeForm form) {
        return fundProviderDao.statusChange(form) > 0;
    }

    public boolean deleteById(IdForm form) {
        FundProviderQueryForm queryForm = new FundProviderQueryForm();
        queryForm.setParentId(form.getId());
        queryForm.setWithSelf(false);
        List<FundProviderModel> childList = queryAllChildByParent(queryForm);
        if (CollectionUtils.isNotEmpty(childList)) {
            throw new RequestResultException(BaseConfigReturnCodeEnum.F2001.getMessage(), BaseConfigReturnCodeEnum.F2001);
        }
        return fundProviderDao.deleteById(form) > 0;
    }
}
