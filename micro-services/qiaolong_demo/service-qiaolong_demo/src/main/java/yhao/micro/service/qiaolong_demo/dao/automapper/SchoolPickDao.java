package yhao.micro.service.qiaolong_demo.dao.automapper;

import yhao.infra.common.model.Pagination;
import yhao.micro.service.qiaolong_demo.apilist.model.SchoolModel;

/**
 * dao层仅需要接口即可
 */
public interface SchoolPickDao {

    SchoolModel pickSchoolInfo(String id);

    SchoolModel pickStudentInfoById(String id);

    Pagination<SchoolModel> queryAllStudentInfo(Pagination pag);
}
