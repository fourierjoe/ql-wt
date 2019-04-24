package yhao.micro.service.qiaolong_demo.apilist.restful;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yhao.infra.apilist.RequestResult;

/**
 * Created by yoara on 2017/11/27.
 */
@FeignClient(value = ZoneConstants.FEIGN_URL)
public interface TraceTestFeign {
    @RequestMapping(value = "/tracetest/traceOut",method = RequestMethod.POST)
    RequestResult<Boolean> traceOut();

    @RequestMapping(value = "/tracetest/traceInner",method = RequestMethod.POST)
    RequestResult<Boolean> traceInner();
}
