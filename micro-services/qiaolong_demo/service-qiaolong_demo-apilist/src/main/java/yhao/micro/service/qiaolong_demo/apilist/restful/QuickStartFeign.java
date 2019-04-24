package yhao.micro.service.qiaolong_demo.apilist.restful;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.PageForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.qiaolong_demo.apilist.form.QuickStartInsertForm;
import yhao.micro.service.qiaolong_demo.apilist.model.QuickStartModel;

/**
 * Created by yoara on 2017/11/27.
 */
@FeignClient(value = ZoneConstants.MY_FEIGN_URL)
public interface QuickStartFeign {
    @RequestMapping(value = "/quickstart/insertName",method = RequestMethod.POST)
    RequestResult<QuickStartInsertForm> insertName(QuickStartInsertForm form);

    @RequestMapping(value = "/quickstart/queryName",method = RequestMethod.POST)
    RequestResult<Pagination<QuickStartModel>> queryName(PageForm form);
}
