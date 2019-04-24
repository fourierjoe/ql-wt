//package yhao.micro.web.surety.controller.security.erp.org;
//
//import com.alibaba.fastjson.JSONObject;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.web.bind.annotation.*;
//import springfox.documentation.annotations.ApiIgnore;
//import yhao.micro.service.surety.erp.auth.login.apilist.model.LoginPersonModel;
//import yhao.micro.service.surety.erp.org.apilist.form.person.PersonUpdatePswForm;
//import yhao.micro.web.surety.remote.erp.org.PersonRemote;
//import yhao.micro.service.surety.erp.auth.apilist.enums.ErpReturnCodeEnum;
//import yhao.micro.web.surety.controller.WebBaseController;
//
//import javax.annotation.Resource;
//
///**
// * Created by yoara on 2017/2/15.
// */
//@Lazy
//@RestController
//@RequestMapping(value = "/security/erp/org/personal",
//        produces = {"application/json;charset=UTF-8"})
//@ApiIgnore
//public class PersonalInfoController extends WebBaseController {
//    @Resource
//    private PersonRemote personRemote;
//
//    @PostMapping("/updatePsw")
//    @ApiOperation(value = "修改密码", tags = "person")
//    public String updatePsw(@RequestBody PersonUpdatePswForm form) {
//        form.setPersonId(getCurrentPerson().getId());
//        if(!getCurrentPerson().getPassword().equals(form.getOldPswMd5())){
//            return returnWrong(ErpReturnCodeEnum.F2000);
//        }
//        personRemote.updatePassword(form);
//        return returnSuccessInfo();
//    }
//
//    @GetMapping(value = "/pickPersonInfo")
//    @ApiOperation(value = "获取人员信息", tags = "person")
//    public String pickPersonInfo() {
//        LoginPersonModel person = getCurrentPerson();
//        JSONObject info = new JSONObject();
//        info.put("name",person.getName());
//        info.put("number",person.getNumber());
//        info.put("cardId",person.getCardId());
//        info.put("status",person.getStatus());
//        info.put("statusDesc",person.getStatusDesc());
//        info.put("sex",person.getSex());
//        info.put("sexDesc",person.getSexDesc());
//        info.put("orgId",person.getOrgId());
//        info.put("orgName",person.getOrgName());
//        info.put("phone",person.getPhone());
//        info.put("admin",person.isAdmin());
//        info.put("currentPositionLinkId",person.isAdmin());
//        info.put("currentPositionName",person.isAdmin());
//        return returnSuccessInfo(info);
//    }
//}
