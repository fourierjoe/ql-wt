package yhao.micro.service.qiaolong_demo.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.RestfulBaseController;
import yhao.infra.apilist.validate.PageForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.qiaolong_demo.apilist.form.QuickStartInsertForm;
import yhao.micro.service.qiaolong_demo.apilist.model.QuickStartModel;
import yhao.micro.service.qiaolong_demo.service.QuickStartService;

import javax.annotation.Resource;

/**
 * Created by yoara on 2017/2/15.
 */
@RestController
@RequestMapping(value = "/quickstart")
public class QuickStartApi extends RestfulBaseController {
    @Resource
    private QuickStartService quickStartService;

    @PostMapping("/insertName")
    public RequestResult<QuickStartInsertForm> insertName(@RequestBody QuickStartInsertForm form){
        return new RequestResult<>(quickStartService.insertName(form));
    }

    @PostMapping("/queryName")
    public RequestResult<Pagination<QuickStartModel>> queryName(PageForm form){
        return new RequestResult<>(quickStartService.queryName(form));
    }
}
