package yhao.micro.service.qiaolong_demo.dao.automapper;

import yhao.infra.common.model.Pagination;
import yhao.micro.service.qiaolong_demo.apilist.form.QuickStartInsertForm;
import yhao.micro.service.qiaolong_demo.apilist.model.QuickStartModel;

/**
 * dao层仅需要接口即可
 */
public interface QuickStartDao {
    /**
     * 查询名字，page对象始终放在第一参数位置
     * @param page
     * @return
     */
    Pagination<QuickStartModel> queryName(Pagination page);

    void insertName(QuickStartInsertForm form);
}
