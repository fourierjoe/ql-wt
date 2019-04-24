package yhao.micro.service.surety.baseconfig.dao.automapper;

import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.baseconfig.apilist.form.MaterialQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.MaterialSaveForm;
import yhao.micro.service.surety.baseconfig.apilist.form.StatusChangeForm;
import yhao.micro.service.surety.baseconfig.apilist.model.MaterialModel;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2018-12-10
 * Time: 10:36
 */
public interface MaterialDao {
    List<MaterialModel> query(MaterialQueryForm queryForm);

    void query(Pagination<MaterialModel> page, MaterialQueryForm form);

    int update(MaterialSaveForm form);

    int insert(MaterialSaveForm form);

    int statusChange(StatusChangeForm form);

    int deleteById(IdForm form);
}
