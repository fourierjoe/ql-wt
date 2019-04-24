package yhao.micro.service.qiaolong_demo.apilist.restful;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.apilist.validate.PageForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.qiaolong_demo.apilist.form.SchoolPickForm;
import yhao.micro.service.qiaolong_demo.apilist.model.SchoolModel;
import yhao.infra.apilist.RequestResult;

@FeignClient(ZoneConstants.MY_FEIGN_URL)
public interface SchoolInfoFeign {

    @PostMapping(value = "/schoolinfo/pick")
    RequestResult<SchoolModel> pickSchoolInfo(SchoolPickForm form);

    @RequestMapping(value = "/schoolinfo/pickStudentInfoById", method = RequestMethod.POST)
    RequestResult<SchoolModel> pickStudentInfoById(IdForm idForm);

    @RequestMapping(value = "/schoolinfo/queryAllStudentInfo", method = RequestMethod.POST)
    RequestResult<Pagination<SchoolModel>> queryAllStudentInfo(PageForm pageForm);
}
