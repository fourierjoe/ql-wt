package yhao.micro.web.surety.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.CollectionUtils;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import yhao.infra.apilist.validate.PageForm;
import yhao.infra.common.model.Pagination;
import yhao.infra.web.controller.BaseController;
import yhao.micro.service.constants.CommonConstants;
import yhao.micro.service.surety.erp.auth.login.apilist.model.LoginPersonModel;
import yhao.micro.service.surety.erp.auth.apilist.constants.ErpAuthConstants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yoara on 2016/5/23.
 */
public class WebBaseController extends BaseController {

    protected Mapper mapper = new DozerBeanMapper();
    public LoginPersonModel getCurrentPerson(){
        return (LoginPersonModel) getRequest().
                    getSession().getAttribute(ErpAuthConstants.CURRENT_LOGIN_PERSON);
    }


    /**
     * 转换输出数据
     * @param page
     * @param clazz
     * @return
     */
    protected JSONObject toPageListData(Pagination page, Class clazz) {
        JSONObject json = new JSONObject();
        json.put("recordCount", page.getRecordCount());
        final List<Object> list = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(page.getItems()) && clazz != null) {
            for (Object obj : page.getItems()) {
                Map<String,Object> item = new HashMap<>();
                mapper.map(clazz.cast(obj),item);
                list.add(item);
            }
            json.put("itemList", list);
        }else {
            json.put("itemList", list);
        }
        return json;
    }

    /**
     * 转换输出数据
     * @param page
     * @param itemConverter
     * @return
     */
    protected JSONObject toPageListData(Pagination page, ItemConverter itemConverter) {
        JSONObject json = new JSONObject();
        json.put("recordCount", page.getRecordCount());
        final List<Object> list = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(page.getItems()) && itemConverter != null) {
            for (Object obj : page.getItems()) {
                list.add(itemConverter.convert(obj));
            }
            json.put("items", list);
        }else {
            json.put("items", list);
        }
        return json;
    }

    public interface ItemConverter {
        Object convert(Object obj);
    }

    protected void initDataAuth(PageForm form){
        LoginPersonModel person = getCurrentPerson();
        form.setDatas(person.getCurrentDataOrgLongNumber(CommonConstants.SYSTEM_DATA_TYPE));
        form.setOrgManager(person.isManager());
        form.setPersonOrgLongNumber(person.getOrgLongNumber());
        form.setPersonId(person.getId());
    }
}
