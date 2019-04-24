package yhao.micro.service.qiaolong_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yhao.infra.apilist.validate.PageForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.qiaolong_demo.apilist.form.QuickStartInsertForm;
import yhao.micro.service.qiaolong_demo.apilist.model.QuickStartModel;
import yhao.micro.service.qiaolong_demo.dao.automapper.QuickStartDao;

import java.util.UUID;

@Service
public class QuickStartService {
    @Autowired
    private QuickStartDao quickStartDao;

    public Pagination<QuickStartModel> queryName(PageForm form) {
        Pagination<QuickStartModel> page = new Pagination(form.getPageSize(),form.getCurrentPage());
        return quickStartDao.queryName(page);
    }

    public QuickStartInsertForm insertName(QuickStartInsertForm form) {
        form.setId(UUID.randomUUID().toString());
        quickStartDao.insertName(form);
        return form;
    }
}
