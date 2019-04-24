package yhao.micro.service.surety.baseconfig.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.infra.common.util.CommonDateUtil;
import yhao.micro.service.surety.baseconfig.apilist.form.PartnerQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.PartnerSaveForm;
import yhao.micro.service.surety.baseconfig.apilist.form.StatusChangeForm;
import yhao.micro.service.surety.baseconfig.apilist.model.PartnerModel;
import yhao.micro.service.surety.baseconfig.dao.automapper.PartnerDao;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2018-12-10
 * Time: 16:46
 */
@Service
public class PartnerService {
    @Resource
    private PartnerDao partnerDao;

    public Pagination<PartnerModel> pageQuery(PartnerQueryForm form) {
        if (form.getMinAgreementEndDate() != null) {
            form.setMinAgreementEndDate(CommonDateUtil.getZeroOfDay(form.getMinAgreementEndDate()));
        }
        if (form.getMaxAgreementEndDate() != null) {
            form.setMaxAgreementEndDate(CommonDateUtil.getEndOfDay(form.getMaxAgreementEndDate()));
        }
        Pagination<PartnerModel> page = new Pagination<>(form.getPageSize(), form.getCurrentPage());
        partnerDao.query(page, form);
        return page;
    }

    public List<PartnerModel> query(PartnerQueryForm form) {
        if (form.getMinAgreementEndDate() != null) {
            form.setMinAgreementEndDate(CommonDateUtil.getZeroOfDay(form.getMinAgreementEndDate()));
        }
        if (form.getMaxAgreementEndDate() != null) {
            form.setMaxAgreementEndDate(CommonDateUtil.getEndOfDay(form.getMaxAgreementEndDate()));
        }
        return partnerDao.query(form);
    }

    public boolean save(PartnerSaveForm form) {
        if (form.getAgreementEndDate() != null) {
            form.setAgreementEndDate(CommonDateUtil.getEndOfDay(form.getAgreementEndDate()));
        }
        if (StringUtils.isNotBlank(form.getId())) {
            return partnerDao.update(form) > 0;
        }
        return partnerDao.insert(form) > 0;
    }

    public boolean deleteById(IdForm form) {
        return partnerDao.deleteById(form) > 0;
    }

    public boolean statusChange(StatusChangeForm form) {
        return partnerDao.statusChange(form) > 0;
    }
}
