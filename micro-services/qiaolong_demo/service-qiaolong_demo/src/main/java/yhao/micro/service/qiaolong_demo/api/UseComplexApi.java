package yhao.micro.service.qiaolong_demo.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.RestfulBaseController;
import yhao.infra.apilist.validate.IdForm;

/**
 * Created by yoara on 2017/12/28.
 */
@RestController
@RequestMapping("/usecomplex")
public class UseComplexApi extends RestfulBaseController {
    @PostMapping(value = "/test")
    public RequestResult<Boolean> test(@RequestBody IdForm form) {
        System.out.println("test in");
        return new RequestResult(true);
    }

    @PostMapping(value = "/testDown")
    public RequestResult<Boolean> testDown(@RequestBody IdForm form) {
        System.out.println("testDown in");
        return new RequestResult(true);
    }
}