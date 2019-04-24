package yhao.micro.web.surety.controller.security.open;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yhao.infra.apilist.validate.IdForm;
import yhao.micro.service.surety.business.apilist.model.guarantee.page.ApplicationPersonModel;
import yhao.micro.web.surety.controller.WebBaseController;

/**
 * @Description:
 * @Created by ql on 2018/12/10 14:40
 * @Version: v1.0
 */
@Lazy
@RestController
@RequestMapping(value = "/security/open/guarantee", produces = { "application/json;charset=UTF-8" })
@Api(value = "OpenGuaranteeController", tags = "开放-担保导航查询条件")
public class OpenGuaranteeController extends WebBaseController {

    @GetMapping("/queryAllSellerAndBuyerNameByGuaranteeId")
    @ApiOperation(value = "查询担保单的买卖双方姓名")
    @ApiResponses(
            @ApiResponse(code = 200, response = ApplicationPersonModel.class, message = "买卖双方姓名")
    )
    public String queryAllSellerAndBuyerNameByGuaranteeId(IdForm form) {
        return returnSuccessInfo();
    }
}
