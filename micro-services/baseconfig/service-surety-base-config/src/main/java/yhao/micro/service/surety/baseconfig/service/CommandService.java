package yhao.micro.service.surety.baseconfig.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.baseconfig.apilist.form.CommandQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.CommandSaveForm;
import yhao.micro.service.surety.baseconfig.apilist.form.StatusChangeForm;
import yhao.micro.service.surety.baseconfig.apilist.model.CommandModel;
import yhao.micro.service.surety.baseconfig.dao.automapper.CommandDao;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2018-12-13
 * Time: 11:32
 */
@Service
public class CommandService {
    @Resource
    private CommandDao commandDao;

    public Pagination<CommandModel> pageQuery(CommandQueryForm form) {
        Pagination<CommandModel> page = new Pagination<>(form.getPageSize(), form.getCurrentPage());
        commandDao.query(page, form);
        return page;
    }

    public List<CommandModel> query(CommandQueryForm form){
        return commandDao.query(form);
    }

    public boolean save(CommandSaveForm form) {
        if (StringUtils.isNotBlank(form.getId())) {
            return commandDao.update(form) > 0;
        }
        return commandDao.insert(form) > 0;
    }

    public boolean statusChange(StatusChangeForm form) {
        return commandDao.statusChange(form) > 0;
    }

    public boolean deleteById(IdForm form) {
        return commandDao.deleteById(form) > 0;
    }
}
