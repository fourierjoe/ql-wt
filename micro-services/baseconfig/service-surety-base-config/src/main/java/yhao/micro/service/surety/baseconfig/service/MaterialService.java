package yhao.micro.service.surety.baseconfig.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.baseconfig.apilist.form.MaterialQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.MaterialSaveForm;
import yhao.micro.service.surety.baseconfig.apilist.form.StatusChangeForm;
import yhao.micro.service.surety.baseconfig.apilist.model.MaterialModel;
import yhao.micro.service.surety.baseconfig.dao.automapper.MaterialDao;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2018-12-10
 * Time: 10:36
 */
@Service
public class MaterialService {
    @Resource
    private MaterialDao materialDao;

    public Pagination<MaterialModel> pageQuery(MaterialQueryForm form) {
        Pagination<MaterialModel> page = new Pagination<>(form.getPageSize(), form.getCurrentPage());
        if(StringUtils.isNotBlank(form.getIds())){
            form.setIdList(Arrays.asList(form.getIds().split(",")));
        }
        materialDao.query(page, form);
        return page;
    }

    public List<MaterialModel> query(MaterialQueryForm form) {
        if(StringUtils.isNotBlank(form.getIds())){
            form.setIdList(Arrays.asList(form.getIds().split(",")));
        }
        return materialDao.query(form);
    }

    public boolean save(MaterialSaveForm form) {
        if (StringUtils.isNotBlank(form.getId())) {
            return materialDao.update(form) > 0;
        }
        return materialDao.insert(form) > 0;
    }

    public boolean deleteById(IdForm form) {
        return materialDao.deleteById(form) > 0;
    }

    public boolean statusChange(StatusChangeForm form) {
        return materialDao.statusChange(form) > 0;
    }
}
