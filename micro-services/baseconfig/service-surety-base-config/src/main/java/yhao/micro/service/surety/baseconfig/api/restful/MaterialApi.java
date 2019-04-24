package yhao.micro.service.surety.baseconfig.api.restful;

import org.springframework.web.bind.annotation.*;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.RestfulBaseController;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.baseconfig.apilist.form.MaterialQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.MaterialSaveForm;
import yhao.micro.service.surety.baseconfig.apilist.form.StatusChangeForm;
import yhao.micro.service.surety.baseconfig.apilist.model.MaterialModel;
import yhao.micro.service.surety.baseconfig.service.MaterialService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2018-12-10
 * Time: 10:35
 */
@RestController
@RequestMapping(value = "/baseconfig/material")
public class MaterialApi extends RestfulBaseController {
    @Resource
    private MaterialService materialService;

    @PostMapping("/pageQuery")
    public RequestResult<Pagination<MaterialModel>> pageQuery(@RequestBody MaterialQueryForm form) {
        return new RequestResult<>(materialService.pageQuery(form));
    }

    @PostMapping("/query")
    public RequestResult<List<MaterialModel>> query(@RequestBody MaterialQueryForm form) {
        return new RequestResult<>(materialService.query(form));
    }

    @PostMapping("/save")
    public RequestResult save(@RequestBody MaterialSaveForm form) {
        return new RequestResult<>(materialService.save(form));
    }

    @PostMapping("/statusChange")
    public RequestResult statusChange(@RequestBody StatusChangeForm form){
        return new RequestResult<>(materialService.statusChange(form));
    }

    @RequestMapping(value = "/deleteById",method = RequestMethod.POST)
    public RequestResult deleteById(@RequestBody IdForm form){
        return new RequestResult<>(materialService.deleteById(form));
    }
}
