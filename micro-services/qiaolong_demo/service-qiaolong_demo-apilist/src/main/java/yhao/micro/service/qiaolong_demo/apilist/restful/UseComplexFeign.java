package yhao.micro.service.qiaolong_demo.apilist.restful;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.complex.ComplexFeign;
import yhao.infra.apilist.validate.IdForm;

@FeignClient(ZoneConstants.FEIGN_URL)
public interface UseComplexFeign {
    @RequestMapping(value = "/usecomplex/test",method = RequestMethod.POST)
    @ComplexFeign(fallbackMethod = "testDown")
    RequestResult<Boolean> test(IdForm form);

    @RequestMapping(value = "/usecomplex/testDown",method = RequestMethod.POST)
    RequestResult<Boolean> testDown(IdForm form);
}

