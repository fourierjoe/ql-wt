package yhao.micro.web.surety.controller.security.open;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yhao.micro.service.surety.business.apilist.form.businessType.OrgIdForm;
import yhao.micro.service.surety.business.apilist.model.businessType.BusinessTypeNameModel;
import yhao.micro.web.surety.controller.WebBaseController;
import yhao.micro.web.surety.remote.business.BusinessTypeRemote;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Created by ql on 2018/12/26 21:04
 * @Version: v1.0
 */

@Lazy
@RestController
@RequestMapping(value = "/security/open/businessType", produces = {"application/json;charset=UTF-8"})
@Api(value = "OpenBusinessTypeController", tags = "开放-业务类型设置查询")
public class OpenBusinessTypeController extends WebBaseController {

	@Resource
	private BusinessTypeRemote businessTypeRemote;

	@GetMapping("/queryBusinessTypeAllName")
	@ApiOperation(value = "业务类型名称查询, 用于担保导航菜单栏筛选条件")
	@ApiResponses(
			@ApiResponse(code = 200, response = BusinessTypeNameModel.class, message = "业务类型名称信息")
	)
	public String queryBusinessTypeAllName(OrgIdForm form) {
		List<BusinessTypeNameModel> list = businessTypeRemote.queryBusinessTypeAllName(form);
		return returnSuccessInfo(list);
	}
}
