package yhao.micro.service.qiaolong_demo.api;

import org.springframework.web.bind.annotation.*;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.RestfulBaseController;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.apilist.validate.PageForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.qiaolong_demo.apilist.form.SchoolPickForm;
import yhao.micro.service.qiaolong_demo.apilist.model.SchoolModel;
import yhao.micro.service.qiaolong_demo.service.SchoolInfoService;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/schoolinfo")
public class SchoolInfoApi extends RestfulBaseController {

    @Resource
    private SchoolInfoService schoolInfoService;

    @PostMapping("pick")
    public RequestResult<SchoolModel> pickSchoolInfo(@RequestBody  SchoolPickForm schoolPickForm) {
        return new RequestResult<>(schoolInfoService.pickSchoolInfo(schoolPickForm));
    }

    @PostMapping("pickStudentInfoById")
    public RequestResult<SchoolModel> pickStudentInfoById(@RequestBody  IdForm idForm) {
        return new RequestResult<>(schoolInfoService.pickStudentInfoById(idForm));
    }

    @PostMapping("queryAllStudentInfo")
    public RequestResult<Pagination<SchoolModel>> queryAllStudentInfo(PageForm pageForm) {
        return new RequestResult<>(schoolInfoService.queryAllStudentInfo(pageForm));
    }
}
