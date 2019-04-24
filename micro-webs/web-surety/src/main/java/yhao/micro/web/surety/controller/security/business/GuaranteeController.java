package yhao.micro.web.surety.controller.security.business;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.guarantee.*;
import yhao.micro.service.surety.business.apilist.model.guarantee.*;
import yhao.micro.service.surety.business.apilist.model.guarantee.page.GuaranteePageModel;
import yhao.micro.service.surety.erp.auth.login.apilist.model.LoginPersonModel;
import yhao.micro.web.surety.controller.WebBaseController;
import yhao.micro.web.surety.remote.business.GuaranteeRemote;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Created by ql on 2018/12/9 15:23
 * @Version: v1.0
 */
@Lazy
@RestController
@RequestMapping(value = "/security/business/guarantee", produces = {"application/json;charset=UTF-8"})
@Api(value = "GuaranteeController", tags = "担保业务-担保导航")
public class GuaranteeController extends WebBaseController {
    @Resource
    private GuaranteeRemote guaranteeRemote;

    @PostMapping(value = "/guarantee")
    @ApiOperation(value = "担保单保存")
    public String saveGuarantee(@RequestBody GuaranteeForm form) {
        form.setOperatorId(getCurrentPerson().getId());
        form.setOperatorOrgId(getCurrentPerson().getOrgId());
        guaranteeRemote.saveGuarantee(form);
        return returnSuccessInfo();
    }

    @PostMapping(value = "/updateGuarantee")
    @ApiOperation(value = "担保单修改")
    public String updateGuarantee(@RequestBody GuaranteeForm form) {
        form.setOperatorId(getCurrentPerson().getId());
        form.setOperatorOrgId(getCurrentPerson().getOrgId());
        guaranteeRemote.updateGuarantee(form);
        return returnSuccessInfo();
    }

    /**
     * 担保导航分页
     * @param form
     * @return
     */
    @GetMapping(value = "/guarantee")
    @ApiOperation(value = "担保单分页查询")
    @ApiResponses(
            @ApiResponse(code = 200, response = GuaranteePageModel.class, message = "担保单信息")
    )
    public String queryGuaranteePage(GuaranteeQueryPageForm form) {
        Pagination<GuaranteePageModel> page = guaranteeRemote.queryGuaranteePage(form);
        Object object = JSON.toJSON(page);
        return returnSuccessInfo(object);
    }

    @GetMapping(value = "/pickGuarantee")
    @ApiOperation(value = "担保单根据单据号查询")
    @ApiResponses(
            @ApiResponse(code = 200, response = GuaranteeModel.class, message = "担保单信息")
    )
    public String pickGuarantee(IdForm form) {
        return returnSuccessInfo(guaranteeRemote.pickGuarantee(form));
    }

    /**
     * 录入主业务合同
     * @param form
     * @return
     */@PostMapping(value = "/saveMainContractNum")
    @ApiOperation(value = "担保单录入")
    public String saveMainContractNum(@RequestBody MainContractNumSaveForm form) {
        form.setOperatorId(getCurrentPerson().getId());
        guaranteeRemote.saveMainContractNum(form);
        return returnSuccessInfo();
    }

    /**
     * 担保单录入查看
     * @param form
     * @return
     */
    @GetMapping(value = "/pickMainContractNum")
    @ApiOperation(value = "担保单录入查看")
    public String pickMainContractNum(IdForm form) {
        MainContractNumModel mainContractNumModel = guaranteeRemote.pickMainContractNum(form);
        return returnSuccessInfo(mainContractNumModel);
    }

    /**
     * 赎楼前可撤单，赎楼后无需该按钮
     * 撤单后，所有子流程不显示（打折申请、出账申批、）
     *
     * @param form
     * @return
     */
    @PostMapping(value = "cancelThisGuarantee")
    @ApiOperation(value = "担保单撤单")
    public String cancelThisGuarantee(@RequestBody IdForm form) {
        return returnSuccessInfo(guaranteeRemote.cancelThisGuarantee(form));
    }

    /**
     * 保存/提交按钮,更改单据状态
     * @param form
     * @return
     */
    @PostMapping(value = "/updateGuaranteeState")
    @ApiOperation(value = "担保单修改单据状态")
    public String updateGuaranteeState(@RequestBody GuaranteeStateUpdateForm form) {
        return returnSuccessInfo();
    }

    /**
     * 担保单驳回
     * @param form
     * @return
     */
    @PostMapping(value = "/rejectGuarantee")
    @ApiOperation(value = "担保单驳回")
    public String rejectGuarantee(@RequestBody IdForm form) {
        LoginPersonModel currentPerson = getCurrentPerson();
        form.setOperatorId(currentPerson.getId());
        form.setOperatorOrgId(currentPerson.getOrgId());
        return returnSuccessInfo(guaranteeRemote.rejectGuarantee(form));
    }

    @GetMapping(value = "/guaranteeAttachment")
    @ApiOperation(value = "查询担保单附件信息")
    @ApiResponses(
            @ApiResponse(code = 200, response = GuaranteeAttachmentModel.class, message = "担保单附件信息")
    )
    public String queryGuaranteeAttachment(IdForm form) {
        return returnSuccessInfo();
    }

    @GetMapping("/associateGuarantee")
    @ApiOperation(value = "查询关联单信息")
    @ApiResponses(
            @ApiResponse(code = 200, response = AssociateGuaranteeModel.class, message = "关联单信息")
    )
    public String associateGuarantee(AssociateGuaranteeForm form) {
        return returnSuccessInfo(guaranteeRemote.associateGuarantee(form));
    }

    /**
     * 物业查档保存
     * @param form
     * @return
     */
    @PostMapping("/saveEstateFile")
    @ApiOperation(value = "物业查档保存")
    public String saveEstateFile(@RequestBody EstateFileSaveForm form) {
        return returnSuccessInfo(guaranteeRemote.saveEstateFile(form));
    }

    /**
     * 查询查档
     * @param form, 传入物业id
     * @return
     */
    @GetMapping("/queryEstateFile")
    @ApiOperation(value = "物业查档信息")
    @ApiResponses(
            @ApiResponse(code = 200, response = EstateFileModel.class, message = "物业查档信息")
    )
    public String queryEstateFile(IdForm form) {
        return returnSuccessInfo(guaranteeRemote.queryEstateFile(form));
    }

}
