//package yhao.micro.web.surety.controller.security.erp.org;
//
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import springfox.documentation.annotations.ApiIgnore;
//import yhao.micro.web.surety.remote.erp.org.PositionLinkRemote;
//import yhao.micro.web.surety.remote.erp.org.PositionRemote;
//import yhao.micro.web.surety.controller.WebBaseController;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
//import org.apache.commons.collections.CollectionUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import yhao.infra.apilist.validate.IdForm;
//import yhao.infra.common.model.Pagination;
//import yhao.micro.service.constants.annotations.AuthorityAnnotation;
//import yhao.micro.service.constants.enums.AuthorityAnnotationEnums;
//import yhao.micro.service.surety.erp.org.apilist.form.position.PositionLinkQueryForm;
//import yhao.micro.service.surety.erp.org.apilist.form.position.PositionLinkSaveForm;
//import yhao.micro.service.surety.erp.org.apilist.form.position.PositionQueryForm;
//import yhao.micro.service.surety.erp.org.apilist.form.position.PositionSaveForm;
//import yhao.micro.service.surety.erp.org.apilist.model.PositionLinkModel;
//import yhao.micro.service.surety.erp.org.apilist.model.PositionModel;
//
//import javax.annotation.Resource;
//import java.util.List;
//
///**
// * Created by yoara on 2017/8/28.
// */
//@Lazy
//@RestController
//@ApiIgnore
//@RequestMapping(value = "/security/erp/org/position", produces = {"application/json;charset=UTF-8"})
//public class PositionController extends WebBaseController {
//    @Resource
//    private PositionRemote positionRemote;
//    @Resource
//    private PositionLinkRemote positionLinkRemote;
//
//    @GetMapping("/queryPositionPage")
//    @ApiOperation(value = "查询分页岗位信息", tags = "org")
//    @ApiResponses({
//            @ApiResponse(code = 200, response = PositionModel.class, message = "岗位数据")
//    })
//    @AuthorityAnnotation(AuthorityAnnotationEnums.TEMP)
//    public String queryPositionPage(PositionQueryForm form) {
//        Pagination<PositionModel> page = positionRemote.queryPositionPage(form);
//        JSONObject json = toPageListData(page, PositionModel.class);
//        return json.toJSONString();
//    }
//
//    @PostMapping(value = "/savePosition")
//    @ApiOperation(value = "编辑岗位信息", tags = "org")
//    @AuthorityAnnotation(AuthorityAnnotationEnums.TEMP)
//    public String savePosition(PositionSaveForm form) {
//        PositionModel org = new PositionModel();
//        mapper.map(form, org);
//        org.addOperatorInfo(getCurrentPerson().getId(), StringUtils.isNotEmpty(org.getId()));
//        positionRemote.savePosition(org);
//        return returnSuccessInfo();
//    }
//
//    @GetMapping(value = "/pickPositionInfo")
//    @ApiOperation(value = "获取岗位信息", tags = "org")
//    @AuthorityAnnotation(AuthorityAnnotationEnums.TEMP)
//    public String pickPositionInfo(IdForm form) {
//        return returnSuccessInfo(positionRemote.selectById(form));
//    }
//
//    @PostMapping(value = "/positionDelete")
//    @ApiOperation(value = "删除岗位信息", tags = "org")
//    @AuthorityAnnotation(AuthorityAnnotationEnums.TEMP)
//    public String positionDelete(IdForm form) {
//        positionRemote.deleteById(form);
//        return returnSuccessInfo();
//    }
//
//    @GetMapping("/queryPositionLink")
//    @ApiOperation(value = "查询与组织关联的岗位信息", tags = "org")
//    @ApiResponses({
//            @ApiResponse(code = 200, response = PositionLinkModel.class, message = "挂职数据")
//    })
//    @AuthorityAnnotation(AuthorityAnnotationEnums.TEMP)
//    public String queryPositionLink(PositionLinkQueryForm form) {
//        List<PositionLinkModel> list = positionLinkRemote.queryPositionLinkList(form);
//        return makePositionLinkList(list).toJSONString();
//    }
//
//    private JSONObject makePositionLinkList(List<PositionLinkModel> list) {
//        JSONArray json = new JSONArray();
//        if (CollectionUtils.isNotEmpty(list)) {
//            for (PositionLinkModel link : list) {
//                JSONObject item = new JSONObject();
//                item.put("id", link.getId());
//                item.put("orgId", link.getOrgId());
//                item.put("positionId", link.getPositionId());
//                item.put("positionName", link.getPositionName());
//                item.put("positionNumber", link.getPositionNumber());
//                item.put("orgName", link.getOrgName());
//                json.add(item);
//            }
//        }
//        JSONObject result = new JSONObject();
//        result.put("items",json);
//        return result;
//    }
//
//    @PostMapping(value = "/savePositionLink")
//    @ApiOperation(value = "删除岗位信息", tags = "org")
//    @AuthorityAnnotation(AuthorityAnnotationEnums.TEMP)
//    public String savePositionLink(PositionLinkSaveForm form) {
//        form.setOperatorId(getCurrentPerson().getId());
//        positionLinkRemote.savePositionLink(form);
//        return returnSuccessInfo();
//    }
//
//    @PostMapping(value = "/deletePositionLink")
//    @ApiOperation(value = "删除挂职信息", tags = "org")
//    @AuthorityAnnotation(AuthorityAnnotationEnums.TEMP)
//    public String deletePositionLink(IdForm form) {
//        positionLinkRemote.deleteById(form);
//        return returnSuccessInfo();
//    }
//}
