package yhao.micro.service.surety.baseconfig.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.baseconfig.apilist.form.RepositoryQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.RepositorySaveForm;
import yhao.micro.service.surety.baseconfig.apilist.model.RepositoryModel;
import yhao.micro.service.surety.baseconfig.dao.automapper.RepositoryDao;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2019-01-14
 * Time: 9:54
 */
@Service
public class RepositoryService {
    @Resource
    private RepositoryDao repositoryDao;

    public Pagination<RepositoryModel> pageQuery(RepositoryQueryForm form) {
        Pagination<RepositoryModel> page = new Pagination<>(form.getPageSize(), form.getCurrentPage());
        repositoryDao.query(page, form);
        return page;
    }

    public List<RepositoryModel> query(RepositoryQueryForm form) {
        return repositoryDao.query(form);
    }

    public boolean save(RepositorySaveForm form) {
        if (StringUtils.isNotBlank(form.getId())) {
            return repositoryDao.update(form) > 0;
        }
        return repositoryDao.insert(form) > 0;
    }

    public boolean deleteById(IdForm form) {
        return repositoryDao.deleteById(form) > 0;
    }
}
