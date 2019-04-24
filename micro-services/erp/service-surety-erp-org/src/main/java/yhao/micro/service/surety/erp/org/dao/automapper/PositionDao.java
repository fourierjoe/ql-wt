package yhao.micro.service.surety.erp.org.dao.automapper;

import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.erp.org.apilist.form.position.PositionQueryForm;
import yhao.micro.service.surety.erp.org.apilist.model.PositionModel;

import java.util.List;

/**
 * Created by yoara on 2017/8/23.
 */
public interface PositionDao {
    PositionModel selectById(String id);

    void queryPosition(Pagination<PositionModel> pagination, PositionQueryForm param);

    void insertPosition(PositionModel org);

    void updatePosition(PositionModel org);

    void deleteById(String id);

    void deleteAllBySystem(List<String> ids);
}
