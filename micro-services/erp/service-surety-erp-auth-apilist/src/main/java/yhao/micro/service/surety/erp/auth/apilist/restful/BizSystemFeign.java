package yhao.micro.service.surety.erp.auth.apilist.restful;

import yhao.micro.service.surety.erp.auth.apilist.form.system.BizSystemPickForm;
import yhao.micro.service.surety.erp.auth.apilist.form.system.BizSystemQueryForm;
import yhao.micro.service.surety.erp.auth.apilist.model.BizSystemModel;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;

import java.util.List;

/**
 * Created by yoara on 2017/11/27.
 */
@FeignClient(ZoneConstants.FEIGN_URL)
public interface BizSystemFeign {
    @RequestMapping(value = "/system/biz/queryAllBizSystem",method = RequestMethod.POST)
    RequestResult<List<BizSystemModel>> queryAllBizSystem();

    @RequestMapping(value = "/system/biz/queryBizSystemPage",method = RequestMethod.POST)
    RequestResult<Pagination<BizSystemModel>> queryBizSystemPage(BizSystemQueryForm form);

    @RequestMapping(value = "/system/biz/selectById",method = RequestMethod.POST)
    RequestResult<BizSystemModel> selectById(IdForm form);

    @RequestMapping(value = "/system/biz/deleteBizSystem",method = RequestMethod.POST)
    void deleteBizSystem(IdForm form);

    @RequestMapping(value = "/system/biz/saveBizSystem",method = RequestMethod.POST)
    void saveBizSystem(BizSystemModel model);

    @RequestMapping(value = "/system/biz/selectByKey",method = RequestMethod.POST)
    RequestResult<BizSystemModel> selectByKey(BizSystemPickForm form);
}
