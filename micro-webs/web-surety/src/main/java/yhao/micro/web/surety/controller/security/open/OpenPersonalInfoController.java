package yhao.micro.web.surety.controller.security.open;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;
import yhao.micro.service.surety.erp.auth.apilist.form.auth.PositionChangeForm;
import yhao.micro.service.surety.erp.auth.login.apilist.model.LoginPersonModel;
import yhao.micro.service.surety.erp.org.apilist.form.person.PersonUpdatePswForm;
import yhao.micro.service.surety.erp.auth.apilist.enums.ErpReturnCodeEnum;
import yhao.micro.web.surety.controller.WebBaseController;
import yhao.micro.web.surety.remote.erp.org.PersonRemote;

import javax.annotation.Resource;

/**
 * Created by yoara on 2017/2/15.
 */
@Lazy
@RestController
@RequestMapping(value = "/security/open/personalInfo", produces = {"application/json;charset=UTF-8"})
@Api(value = "OpenPersonalInfoController", tags = "开放-个人信息查询")
public class OpenPersonalInfoController extends WebBaseController {
    @Resource
    private PersonRemote personRemote;

    @PostMapping("/updatePsw")
    @ApiOperation(value = "修改密码")
    public String updatePsw(@RequestBody PersonUpdatePswForm form) {
        form.setPersonId(getCurrentPerson().getId());
        if(!getCurrentPerson().getPassword().equals(form.getOldPswMd5())){
            return returnWrong(ErpReturnCodeEnum.F1001);
        }
        personRemote.updatePassword(form);
        return returnSuccessInfo();
    }

    @GetMapping(value = "/pickPersonInfo")
    @ApiOperation(value = "获取人员信息")
    public String pickPersonInfo() {
        return returnSuccessInfo(getCurrentPerson());
    }

    @GetMapping(value = "/changePosition")
    @ApiOperation(value = "切换岗位")
    public String changePosition(PositionChangeForm form){
        LoginPersonModel person = getCurrentPerson();
        person.changePosition(form.getPositionLinkId());
        return returnSuccessInfo(person);
    }
}
