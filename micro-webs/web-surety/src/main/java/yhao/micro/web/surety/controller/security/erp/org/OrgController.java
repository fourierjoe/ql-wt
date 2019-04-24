//package yhao.micro.web.surety.controller.security.erp.org;
//
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
//import org.apache.commons.collections.CollectionUtils;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.web.bind.annotation.*;
//import springfox.documentation.annotations.ApiIgnore;
//import yhao.infra.apilist.validate.IdForm;
//import yhao.infra.common.model.Pagination;
//import yhao.micro.service.constants.annotations.AuthorityAnnotation;
//import yhao.micro.service.constants.enums.AuthorityAnnotationEnums;
//import yhao.micro.service.surety.erp.org.apilist.form.StatusUpdateForm;
//import yhao.micro.service.surety.erp.org.apilist.form.org.OrgPropertyChangeForm;
//import yhao.micro.service.surety.erp.org.apilist.form.org.OrgQueryForm;
//import yhao.micro.service.surety.erp.org.apilist.form.org.OrgQueryPageForm;
//import yhao.micro.service.surety.erp.org.apilist.form.org.OrgSaveForm;
//import yhao.micro.service.surety.erp.org.apilist.model.OrgModel;
//import yhao.micro.web.surety.remote.erp.org.OrgRemote;
//import yhao.micro.web.surety.controller.WebBaseController;
//
//import javax.annotation.Resource;
//import java.util.List;
//
///**
// * Created by yoara on 2017/2/15.
// */
//@Lazy
//@RestController
//@RequestMapping(value = "/security/erp/org/org", produces = {"application/json;charset=UTF-8"})
//@ApiIgnore
//public class OrgController extends WebBaseController {
//    @Resource
//    private OrgRemote orgRemote;
//
//    @GetMapping("/queryOrgTree")
//    @ApiOperation(value = "查询组织树信息", tags = "组织查询")
//    @ApiResponses({
//            @ApiResponse(code = 200, response = OrgModel.class, message = "组织数据")
//    })
//    @AuthorityAnnotation(AuthorityAnnotationEnums.TEMP)
//    public String queryOrgTree(OrgQueryPageForm form) {
//        if(StringUtils.isEmpty(form.getParentId())){
//            form.setParentIdNull(true);
//        }
//        OrgQueryForm formQuery = new OrgQueryForm();
//        mapper.map(form,formQuery);
//        formQuery.setCurrentPage(1);
//        formQuery.setPageSize(Integer.MAX_VALUE);
//        List<OrgModel> list = orgRemote.queryOrgList(formQuery);
//        JSONArray json = makeLigerTree(list);
//        return json.toJSONString();
//    }
//
//    private JSONArray makeLigerTree(List<OrgModel> list) {
//        JSONArray json = new JSONArray();
//        if (CollectionUtils.isNotEmpty(list)) {
//            for (OrgModel org : list) {
//                JSONObject item = new JSONObject();
//                item.put("id",org.getId());
//                item.put("name",org.getName());
//                item.put("isexpand",false);
//                json.add(item);
//            }
//        }
//        return json;
//    }
//
//    @GetMapping("/queryOrgPage")
//    @ApiOperation(value = "查询分页组织信息", tags = "org")
//    @ApiResponses({
//            @ApiResponse(code = 200, response = OrgModel.class, message = "组织数据")
//    })
//    @AuthorityAnnotation(AuthorityAnnotationEnums.TEMP)
//    public String queryOrgPage(OrgQueryForm form) {
//        if(StringUtils.isNotEmpty(form.getParentId())){
//            form.setWithSelf(true);
//        }
//        Pagination<OrgModel> page = orgRemote.queryOrgPage(form);
//        JSONObject json = toPageListData(page, OrgModel.class);
//        return json.toJSONString();
//    }
//
//    @PostMapping(value = "/saveOrg")
//    @ApiOperation(value = "编辑组织信息", tags = "org")
//    @AuthorityAnnotation(AuthorityAnnotationEnums.TEMP)
//    public String saveOrg(OrgSaveForm form) {
//        OrgModel org = new OrgModel();
//        mapper.map(form,org);
//        org.addOperatorInfo(getCurrentPerson().getId(),StringUtils.isNotEmpty(org.getId()));
//        orgRemote.saveOrg(org);
//        return returnSuccessInfo();
//    }
//
//    @PostMapping(value = "/statusChange")
//    @ApiOperation(value = "更改组织状态", tags = "org")
//    @AuthorityAnnotation(AuthorityAnnotationEnums.TEMP)
//    public String statusChange(@RequestBody StatusUpdateForm form) {
//        form.setOperatorId(getCurrentPerson().getId());
//        orgRemote.orgStatusChange(form);
//        return returnSuccessInfo();
//    }
//
//    @PostMapping(value = "/cityOrgChange")
//    @ApiOperation(value = "更改城市公司状态", tags = "org")
//    @AuthorityAnnotation(AuthorityAnnotationEnums.TEMP)
//    public String cityOrgChange(OrgPropertyChangeForm form) {
//        form.setOperatorId(getCurrentPerson().getId());
//        orgRemote.cityOrgChange(form);
//        return returnSuccessInfo();
//    }
//
//    @GetMapping(value = "/pickOrgInfo")
//    @ApiOperation(value = "获取组织信息", tags = "org")
//    @AuthorityAnnotation(AuthorityAnnotationEnums.TEMP)
//    public String pickOrgInfo(IdForm form) {
//        return returnSuccessInfo(orgRemote.selectById(form));
//    }
//}
