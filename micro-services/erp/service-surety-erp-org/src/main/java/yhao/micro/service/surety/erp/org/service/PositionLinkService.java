package yhao.micro.service.surety.erp.org.service;

import yhao.micro.service.surety.erp.org.apilist.form.position.PositionLinkQueryForm;
import yhao.micro.service.surety.erp.org.apilist.form.position.PositionLinkSaveForm;
import yhao.micro.service.surety.erp.org.apilist.model.PositionLinkModel;
import yhao.micro.service.surety.erp.org.dao.automapper.PositionLinkDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PositionLinkService {
    @Resource
    private PositionLinkDao positionLinkDao;

    public List<PositionLinkModel> queryPositionLinkList(PositionLinkQueryForm form) {
        return positionLinkDao.queryPositionLink(form);
    }

    public boolean savePositionLink(PositionLinkSaveForm form) {
        if(StringUtils.isEmpty(form.getOrgId())||StringUtils.isEmpty(form.getPositionIds())){
            return false;
        }
        String[] pids = form.getPositionIds().split(",");
        if(pids.length==0){
            return false;
        }
        form.setPositionIdArray(Arrays.asList(pids));
        positionLinkDao.savePositionLink(form);
        return true;
    }

    public boolean deleteById(String id) {
        positionLinkDao.deleteById(id);
        return true;
    }
}
