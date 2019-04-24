//package yhao.micro.web.surety.controller.security.erp.org;
//
//import com.alibaba.fastjson.JSONObject;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.web.bind.annotation.*;
//import springfox.documentation.annotations.ApiIgnore;
//import yhao.infra.apilist.validate.IdForm;
//import yhao.infra.common.model.Pagination;
//import yhao.micro.service.constants.annotations.AuthorityAnnotation;
//import yhao.micro.service.constants.enums.AuthorityAnnotationEnums;
//import yhao.micro.service.surety.erp.org.apilist.form.StatusUpdateForm;
//import yhao.micro.service.surety.erp.org.apilist.form.person.PersonQueryForm;
//import yhao.micro.service.surety.erp.org.apilist.form.person.PersonSaveForm;
//import yhao.micro.service.surety.erp.org.apilist.form.person.PersonUpdatePswForm;
//import yhao.micro.service.surety.erp.org.apilist.form.position.AddPositionLinkSaveForm;
//import yhao.micro.service.surety.erp.org.apilist.model.PersonModel;
//import yhao.micro.service.surety.erp.org.apilist.model.PositionLinkModel;
//import yhao.micro.service.surety.erp.org.apilist.model.PositionListModel;
//import yhao.micro.web.surety.remote.erp.org.PersonRemote;
//import yhao.micro.web.surety.controller.WebBaseController;
//
//import javax.annotation.Resource;
//import java.util.List;
//
//import static yhao.infra.web.bean.JsonCommonCodeEnum.C0000;
//
//
///**
// * Created by yoara on 2017/2/15.
// */
//@Lazy
//@RestController
//@ApiIgnore
//@RequestMapping(value = "/security/erp/org/person",
//        produces = {"application/json;charset=UTF-8"})
//public class PersonController extends WebBaseController {
//    @Resource
//    private PersonRemote personRemote;
//
//    @GetMapping("/queryPersonPage")
//    @ApiOperation(value = "查询分页人员信息", tags = "person")
//    @ApiResponses({
//            @ApiResponse(code = 200, response = PersonModel.class, message = "人员数据")
//    })
//    @AuthorityAnnotation(AuthorityAnnotationEnums.TEMP)
//    public String queryPersonPage(PersonQueryForm form) {
//        form.setPositionType("MAJOR");
//        Pagination<PersonModel> page = personRemote.queryPersonPage(form);
//        JSONObject json = toPageListData(page, PersonModel.class);
//        return json.toJSONString();
//    }
//
//    @PostMapping(value = "/savePerson")
//    @ApiOperation(value = "编辑人员信息", tags = "person")
//    @AuthorityAnnotation(AuthorityAnnotationEnums.TEMP)
//    public String savePerson(PersonSaveForm form) {
//        PersonModel person = new PersonModel();
//        mapper.map(form,person);
//        person.addOperatorInfo(getCurrentPerson().getId(), StringUtils.isNotEmpty(person.getId()));
//        personRemote.savePerson(person);
//        return returnSuccessInfo();
//    }
//
//    @PostMapping(value = "/statusChange")
//    @ApiOperation(value = "更改人员在ERP的状态", tags = "person")
//    @AuthorityAnnotation(AuthorityAnnotationEnums.TEMP)
//    public String statusChange(@RequestBody StatusUpdateForm form) {
//        form.setOperatorId(getCurrentPerson().getId());
//        personRemote.personStatusChange(form);
//        return returnSuccessInfo();
//    }
//
//    @PostMapping(value = "/resetPsw")
//    @ApiOperation(value = "重置密码密码", tags = "person")
//    @AuthorityAnnotation(AuthorityAnnotationEnums.TEMP)
//    public String resetPsw(@RequestBody IdForm form) {
//        PersonUpdatePswForm pswForm = new PersonUpdatePswForm();
//        pswForm.setPersonId(form.getId());
//        personRemote.updatePassword(pswForm);
//        return returnSuccessInfo();
//    }
//
//    @GetMapping(value = "/pickPersonInfo")
//    @ApiOperation(value = "获取人员信息", tags = "person")
//    @AuthorityAnnotation(AuthorityAnnotationEnums.TEMP)
//    public String pickPersonInfo(IdForm form) {
//        return returnSuccessInfo(personRemote.selectById(form));
//    }
//
//    @PostMapping(value = "/saveAddPosition")
//    @ApiOperation(value = "保存人员兼职岗位信息", tags = "person")
//    @AuthorityAnnotation(AuthorityAnnotationEnums.TEMP)
//    public String saveAddPosition(AddPositionLinkSaveForm form) {
//        personRemote.saveAddPosition(form);
//        return returnSuccessInfo();
//    }
//
//    @GetMapping("/queryAddPosition")
//    @ApiOperation(value = "查询人员兼职信息", tags = "person")
//    @ApiResponses({
//            @ApiResponse(code = 200, response = PositionLinkModel.class, message = "人员数据")
//    })
//    @AuthorityAnnotation(AuthorityAnnotationEnums.TEMP)
//    public String queryAddPosition(IdForm idForm) {
//        List<PositionLinkModel> list =  personRemote.queryAddPosition(idForm.getId());
//        return returnJsonInfo(list,C0000);
//    }
//
//    @PostMapping(value = "/deleteAddPosition")
//    @ApiOperation(value = "删除人员兼职岗位信息", tags = "person")
//    @AuthorityAnnotation(AuthorityAnnotationEnums.TEMP)
//    public String deleteAddPosition(AddPositionLinkSaveForm form) {
//        personRemote.deleteAddPosition(form);
//        return returnSuccessInfo();
//    }
//
//    @GetMapping("/queryPersonPositionList")
//    @ApiOperation(value = "查询人员履职信息", tags = "person")
//    @ApiResponses({
//            @ApiResponse(code = 200, response = PositionLinkModel.class, message = "人员数据")
//    })
//    @AuthorityAnnotation(AuthorityAnnotationEnums.TEMP)
//    public String queryPersonPositionList(IdForm idForm) {
//        List<PositionListModel> list =  personRemote.queryPersonPositionList(idForm.getId());
//        return returnJsonInfo(list,C0000);
//    }
//}
