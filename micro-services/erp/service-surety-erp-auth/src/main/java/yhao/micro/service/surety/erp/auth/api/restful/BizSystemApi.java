package yhao.micro.service.surety.erp.auth.api.restful;

import yhao.micro.service.surety.erp.auth.apilist.form.system.BizSystemPickForm;
import yhao.micro.service.surety.erp.auth.apilist.form.system.BizSystemQueryForm;
import yhao.micro.service.surety.erp.auth.apilist.model.BizSystemModel;
import yhao.micro.service.surety.erp.auth.service.BizSystemService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.RestfulBaseController;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yoara on 2017/11/27.
 */
@RestController
@RequestMapping(value = "/system/biz")
public class BizSystemApi extends RestfulBaseController {
    @Resource
    private BizSystemService bizSystemService;

    @PostMapping("/queryAllBizSystem")
    public RequestResult<List<BizSystemModel>> queryAllBizSystem(){
        return new RequestResult<>(bizSystemService.queryAllBizSystem());
    }

    @PostMapping("/queryBizSystemPage")
    public RequestResult<Pagination<BizSystemModel>> queryBizSystemPage(@RequestBody BizSystemQueryForm form){
        return new RequestResult<>(bizSystemService.queryBizSystemPage(form));
    }

    @PostMapping("/selectById")
    public RequestResult<BizSystemModel> selectById(@RequestBody IdForm form){
        return new RequestResult<>(bizSystemService.selectById(form.getId()));
    }

    @PostMapping("/selectByKey")
    public RequestResult<BizSystemModel> selectByKey(@RequestBody BizSystemPickForm form){
        return new RequestResult<>(bizSystemService.selectByKey(form.getKey()));
    }

    @PostMapping("/deleteBizSystem")
    public RequestResult deleteBizSystem(@RequestBody IdForm form){
        return new RequestResult<>(bizSystemService.deleteBizSystem(form.getId()));
    }

    @PostMapping("/saveBizSystem")
    public RequestResult saveBizSystem(@RequestBody BizSystemModel model){
        return new RequestResult<>(bizSystemService.saveBizSystem(model));
    }
}
