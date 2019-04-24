package yhao.micro.service.surety.business.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.RestfulBaseController;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.guarantee.*;
import yhao.micro.service.surety.business.apilist.model.guarantee.AssociateGuaranteeModel;
import yhao.micro.service.surety.business.apilist.model.guarantee.EstateFileModel;
import yhao.micro.service.surety.business.apilist.model.guarantee.GuaranteeModel;
import yhao.micro.service.surety.business.apilist.model.guarantee.page.GuaranteePageModel;
import yhao.micro.service.surety.business.apilist.model.guarantee.MainContractNumModel;
import yhao.micro.service.surety.business.service.GuaranteeService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Created by ql on 2019/1/2 17:31
 * @Version: v1.0
 */
@RestController
@RequestMapping(value = "/business/guarantee")
public class GuaranteeApi extends RestfulBaseController {
	@Resource
	private GuaranteeService guaranteeService;

	@PostMapping("/saveGuarantee")
	public RequestResult<GuaranteeForm> saveGuarantee(@RequestBody GuaranteeForm form) {
		return new RequestResult(guaranteeService.saveGuarantee(form));
	}

	@PostMapping("/updateGuarantee")
	public RequestResult<GuaranteeForm> updateGuarantee(@RequestBody GuaranteeForm form) {
		return new RequestResult(guaranteeService.updateGuarantee(form));
	}

	/**
	 * 录入合同编号
	 * @param form
	 * @return
	 */
	@PostMapping("/saveMainContractNum")
	public RequestResult<MainContractNumSaveForm> saveMainContractNum(@RequestBody MainContractNumSaveForm form) {
		return new RequestResult(guaranteeService.saveMainContractNum(form));
	}

	/**
	 * 录入合同查看按钮
	 * @param form
	 * @return
	 */
	@PostMapping("/pickMainContractNum")
	public RequestResult<MainContractNumModel> pickMainContractNum(@RequestBody IdForm form) {
		return new RequestResult(guaranteeService.pickMainContractNum(form));
	}

	@PostMapping("/pickGuarantee")
	public RequestResult<GuaranteeModel> pickGuarantee(@RequestBody IdForm form) {
		return new RequestResult(guaranteeService.pickGuarantee(form));
	}

	@PostMapping("/queryGuaranteePage")
	public RequestResult<Pagination<GuaranteePageModel>> queryGuaranteePage(@RequestBody GuaranteeQueryPageForm form) {
		return new RequestResult(guaranteeService.queryGuaranteePage(form));
	}

	/**
	 * 撤单
	 * @param form
	 * @return
	 */
	@PostMapping("/cancelThisGuarantee")
	public RequestResult<Boolean> cancelThisGuarantee(@RequestBody IdForm form) {
		return new RequestResult(guaranteeService.cancelThisGuarantee(form));
	}

	/**
	 * 驳回
	 * @param form
	 * @return
	 */
	@PostMapping("/rejectGuarantee")
	public RequestResult<Boolean> rejectGuarantee(@RequestBody IdForm form) {
		return new RequestResult(guaranteeService.rejectGuarantee(form));
	}

	/**
	 * 关联单接口
	 * @param form
	 * @return
	 */
	@PostMapping("/associateGuarantee")
	public RequestResult<Pagination<AssociateGuaranteeModel>> associateGuarantee(@RequestBody AssociateGuaranteeForm form) {
		return new RequestResult(guaranteeService.associateGuarantee(form));
	}

	/**
	 * 查档保存
	 * @param form
	 * @return
	 */
	@PostMapping("/saveEstateFile")
	public RequestResult<EstateFileSaveForm> saveEstateFile(@RequestBody EstateFileSaveForm form) {
		return new RequestResult(guaranteeService.saveEstateFile(form));
	}

	/**
	 * 查询查档
	 * @param form
	 * @return
	 */
	@PostMapping("/queryEstateFile")
	public RequestResult<List<EstateFileModel>> queryEstateFile(@RequestBody IdForm form) {
		return new RequestResult(guaranteeService.queryEstateFile(form));
	}
}
