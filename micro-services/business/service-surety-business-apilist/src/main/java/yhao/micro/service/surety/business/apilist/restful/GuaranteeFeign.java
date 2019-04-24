package yhao.micro.service.surety.business.apilist.restful;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.guarantee.*;
import yhao.micro.service.surety.business.apilist.model.guarantee.AssociateGuaranteeModel;
import yhao.micro.service.surety.business.apilist.model.guarantee.EstateFileModel;
import yhao.micro.service.surety.business.apilist.model.guarantee.GuaranteeModel;
import yhao.micro.service.surety.business.apilist.model.guarantee.MainContractNumModel;
import yhao.micro.service.surety.business.apilist.model.guarantee.page.GuaranteePageModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Auther: ql
 * @Date: 2018/12/8 17:50
 */
@FeignClient(ZoneConstants.FEIGN_URL)
public interface GuaranteeFeign {

    /**
     * 保存
     * @param form
     * @return
     */
    @PostMapping(value = "/business/guarantee/saveGuarantee")
    RequestResult<GuaranteeForm> saveGuarantee(GuaranteeForm form);

    /**
     * 编辑
     * @param form
     * @return
     */
    @PostMapping(value = "/business/guarantee/updateGuarantee")
    RequestResult<GuaranteeForm> updateGuarantee(GuaranteeForm form);

    /**
     * 担保导航分页
     * @param form
     * @return
     */
    @PostMapping(value = "/business/guarantee/queryGuaranteePage")
    RequestResult<Pagination<GuaranteePageModel>> queryGuaranteePage(GuaranteeQueryPageForm form);

    @PostMapping(value = "/business/guarantee/pickGuarantee")
    RequestResult<GuaranteeModel> pickGuarantee(IdForm form);

    /**
     * 录入主业务合同
     * @param form
     * @return
     */
    @PostMapping(value = "/business/guarantee/saveMainContractNum")
    RequestResult<MainContractNumSaveForm> saveMainContractNum(MainContractNumSaveForm form);

    @PostMapping("/business/guarantee/pickMainContractNum")
    RequestResult<MainContractNumModel> pickMainContractNum(IdForm form);

    @PostMapping("/business/guarantee/cancelThisGuarantee")
    RequestResult<Boolean> cancelThisGuarantee(IdForm form);

    @PostMapping("/business/guarantee/rejectGuarantee")
    RequestResult<Boolean> rejectGuarantee(IdForm form);

    @PostMapping("/business/guarantee/associateGuarantee")
    RequestResult<Pagination<AssociateGuaranteeModel>> associateGuarantee(AssociateGuaranteeForm form);

    @PostMapping("/business/guarantee/saveEstateFile")
    RequestResult<EstateFileSaveForm> saveEstateFile(EstateFileSaveForm form);

    @PostMapping("/business/guarantee/queryEstateFile")
    RequestResult<List<EstateFileModel>> queryEstateFile(IdForm form);

}
