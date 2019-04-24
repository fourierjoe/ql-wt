//package yhao.micro.web.surety.controller.security.erp.auth;
//
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import org.springframework.web.bind.annotation.*;
//import springfox.documentation.annotations.ApiIgnore;
//import yhao.micro.web.surety.remote.erp.auth.BizSystemOrgLinkRemote;
//import yhao.micro.web.surety.controller.WebBaseController;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
//import org.apache.commons.collections.CollectionUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.context.annotation.Lazy;
//import yhao.micro.service.constants.annotations.AuthorityAnnotation;
//import yhao.micro.service.constants.enums.AuthorityAnnotationEnums;
//import yhao.micro.service.surety.erp.auth.apilist.form.system.SystemOrgLinkQueryForm;
//import yhao.micro.service.surety.erp.auth.apilist.form.system.SystemOrgLinkSaveForm;
//import yhao.micro.service.surety.erp.auth.apilist.model.AuthOrgModel;
//import yhao.micro.service.surety.erp.auth.apilist.model.BizSystemModel;
//
//import javax.annotation.Resource;
//import java.util.List;
//
///**
// * Created by yoara on 2017/9/15.
// */
//@Lazy
//@RestController
//@ApiIgnore
//@RequestMapping(value = "/security/erp/auth/bizSystemOrgLink",
//        produces = {"application/json;charset=UTF-8"})
//public class BizSystemOrgLinkConfigController extends WebBaseController {
//    @Resource
//    private BizSystemOrgLinkRemote bizSystemOrgLinkRemote;
//
//    @GetMapping("/allSystemOrgLink")
//    @ApiOperation(value = "查询所有业务系统关联的组织", tags = "system")
//    @ApiResponses({
//            @ApiResponse(code = 200, response = BizSystemModel.class, message = "业务系统信息")
//    })
//    @AuthorityAnnotation(AuthorityAnnotationEnums.TEMP)
//    public String allSystemOrgLink(SystemOrgLinkQueryForm form) {
//        List<AuthOrgModel> orgList = bizSystemOrgLinkRemote.querySystemOrgLink(form);
//        return returnSuccessInfo(orgList);
//    }
//
//    @PostMapping("/saveOrgLink")
//    @ApiOperation(value = "保存业务系统关联的组织", tags = "system")
//    @AuthorityAnnotation(AuthorityAnnotationEnums.TEMP)
//    public String saveOrgLink(@RequestBody SystemOrgLinkSaveForm form) {
//        bizSystemOrgLinkRemote.saveOrgLink(form);
//        return returnSuccessInfo();
//    }
//
//    @GetMapping("/queryOrgTree")
//    @AuthorityAnnotation(AuthorityAnnotationEnums.TEMP)
//    public String queryOrgTree(SystemOrgLinkQueryForm form) {
//        //拿到权限关联信息
//        List<AuthOrgModel> listAllOrg = bizSystemOrgLinkRemote.queryAllOrg();
//        List<AuthOrgModel> listLinkOrg = bizSystemOrgLinkRemote.querySystemOrgLink(form);
//        JSONArray json = makeLigerTree(form.getSystemKey(),listAllOrg,listLinkOrg);
//        return json.toJSONString();
//    }
//
//    private JSONArray makeLigerTree(String systemKey, List<AuthOrgModel> listAllOrg, List<AuthOrgModel> listLinkOrg) {
//        JSONArray json = new JSONArray();
//        JSONObject root = new JSONObject();
//        root.put("id","0");
//        root.put("name",systemKey);
//        root.put("isexpand",true);
//        json.add(root);
//
//        if (CollectionUtils.isNotEmpty(listAllOrg)) {
//            for (AuthOrgModel org : listAllOrg) {
//                JSONObject item = new JSONObject();
//                item.put("id",org.getId());
//                item.put("name",org.getName());
//                if(StringUtils.isNotEmpty(org.getParentId())){
//                    item.put("pid",org.getParentId());
//                }else{
//                    item.put("pid","0");
//                }
//                if(CollectionUtils.isNotEmpty(listLinkOrg)&&listLinkOrg.contains(org)){
//                    item.put("isexpand",true);
//                    item.put("ischecked",true);
//                }
//                json.add(item);
//            }
//        }
//        return json;
//    }
//}
