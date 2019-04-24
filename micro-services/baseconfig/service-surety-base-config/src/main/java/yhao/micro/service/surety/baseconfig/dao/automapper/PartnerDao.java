package yhao.micro.service.surety.baseconfig.dao.automapper;

import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.baseconfig.apilist.form.PartnerQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.PartnerSaveForm;
import yhao.micro.service.surety.baseconfig.apilist.form.StatusChangeForm;
import yhao.micro.service.surety.baseconfig.apilist.model.PartnerModel;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2018-12-10
 * Time: 17:01
 */
public interface PartnerDao {
    List<PartnerModel> query(PartnerQueryForm form);

    void query(Pagination<PartnerModel> page, PartnerQueryForm form);

    int update(PartnerSaveForm form);

    int insert(PartnerSaveForm form);

    int statusChange(StatusChangeForm form);

    int deleteById(IdForm form);
}
