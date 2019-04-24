package yhao.micro.service.qiaolong_demo.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.RestfulBaseController;
import yhao.micro.service.qiaolong_demo.service.TraceTestService;

import javax.annotation.Resource;

/**
 * Created by yoara on 2017/2/15.
 */
@RestController
@RequestMapping(value = "/tracetest")
public class TraceTestApi extends RestfulBaseController {
    @Resource
    private TraceTestService traceTestService;

    @PostMapping("/traceOut")
    public RequestResult<Boolean> traceOut(){
        return new RequestResult<>(traceTestService.traceOut());
    }

    @PostMapping("/traceInner")
    public RequestResult<Boolean> traceInner(){
        return new RequestResult<>(traceTestService.traceInner());
    }
}
