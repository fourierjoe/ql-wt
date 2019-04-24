package yhao.micro.service.qiaolong_demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.apilist.validate.PageForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.qiaolong_demo.apilist.form.SchoolPickForm;
import yhao.micro.service.qiaolong_demo.apilist.model.SchoolModel;
import yhao.micro.service.qiaolong_demo.dao.automapper.SchoolPickDao;

import javax.annotation.Resource;

@Service
@Transactional
public class SchoolInfoService {

    @Resource
    private SchoolPickDao schoolPickDao;

    public SchoolModel pickSchoolInfo(SchoolPickForm form) {
        String id = form.getId();
        return schoolPickDao.pickSchoolInfo(id);
    }

    public SchoolModel pickStudentInfoById(IdForm idForm) {
        return schoolPickDao.pickStudentInfoById(idForm.getId());
    }

    public Pagination<SchoolModel> queryAllStudentInfo(PageForm pageForm) {
        var page = new Pagination<SchoolModel>(pageForm.getPageSize(), pageForm.getCurrentPage());
        return schoolPickDao.queryAllStudentInfo(page);
    }
}
