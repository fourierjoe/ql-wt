package yhao.micro.service.surety.baseconfig.dao.automapper;

import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.baseconfig.apilist.form.RepositoryQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.RepositorySaveForm;
import yhao.micro.service.surety.baseconfig.apilist.model.RepositoryModel;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2019-01-14
 * Time: 9:59
 */
public interface RepositoryDao {
    List<RepositoryModel> query(RepositoryQueryForm form);

    void query(Pagination<RepositoryModel> page, RepositoryQueryForm form);

    int update(RepositorySaveForm form);

    int insert(RepositorySaveForm form);

    int deleteById(IdForm form);
}
