package yhao.micro.service.surety.erp.auth.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.erp.auth.apilist.form.system.BizSystemQueryForm;
import yhao.micro.service.surety.erp.auth.apilist.form.system.BizSystemRelaDeleteForm;
import yhao.micro.service.surety.erp.auth.apilist.model.BizSystemModel;
import yhao.micro.service.surety.erp.auth.dao.automapper.BizSystemDao;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by yoara on 2017/2/16.
 */
@Service
public class BizSystemService{
    @Resource
    private BizSystemDao bizSystemDao;

    public Pagination<BizSystemModel> queryBizSystemPage(BizSystemQueryForm form) {
        Pagination<BizSystemModel> page = new Pagination(form.getPageSize(), form.getCurrentPage());
        bizSystemDao.queryBizSystem(page, form);
        return page;
    }

    public boolean saveBizSystem(BizSystemModel bizSystem) {
        if (StringUtils.isEmpty(bizSystem.getId())) {
            bizSystem.setId(UUID.randomUUID().toString());
            bizSystemDao.insertBizSystem(bizSystem);
        } else {
            bizSystemDao.updateBizSystem(bizSystem);
            //删除已经去除的数据权限
            if(StringUtils.isNotEmpty(bizSystem.getDataType())){
                List<String> datas = new ArrayList<>();
                for(String dataType:bizSystem.getDataType().split(",")){
                    datas.add(dataType.split("=")[0]);
                }
                BizSystemRelaDeleteForm form = new BizSystemRelaDeleteForm();
                form.setSystemKey(bizSystem.getSystemKey());
                form.setDataKey(datas);
                bizSystemDao.deletePositionData(form);
                bizSystemDao.deletePersonData(form);
            }
        }
        return true;
    }

    public BizSystemModel selectById(String id) {
        return bizSystemDao.selectById(id);
    }

    public boolean deleteBizSystem(String id) {
        bizSystemDao.deleteBizSystem(id);
        return true;
    }

    public List<BizSystemModel> queryAllBizSystem() {
        return bizSystemDao.queryBizSystem(null);
    }

    public BizSystemModel selectByKey(String key) {
        return bizSystemDao.selectByKey(key);
    }
}
