//package yhao.micro.web.surety.controller.security.erp.auth;
//
//import com.alibaba.fastjson.JSONObject;
//import org.springframework.web.bind.annotation.*;
//import springfox.documentation.annotations.ApiIgnore;
//import yhao.micro.web.surety.remote.erp.auth.BizSystemRemote;
//import yhao.micro.web.surety.controller.WebBaseController;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.context.annotation.Lazy;
//import yhao.infra.apilist.validate.IdForm;
//import yhao.infra.common.cache.RedisCache;
//import yhao.infra.common.model.Pagination;
//import yhao.micro.service.constants.annotations.AuthorityAnnotation;
//import yhao.micro.service.constants.enums.AuthorityAnnotationEnums;
//import yhao.micro.service.surety.erp.auth.apilist.form.system.BizSystemPickForm;
//import yhao.micro.service.surety.erp.auth.apilist.form.system.BizSystemQueryForm;
//import yhao.micro.service.surety.erp.auth.apilist.form.system.BizSystemSaveForm;
//import yhao.micro.service.surety.erp.auth.apilist.model.BizSystemModel;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by yoara on 2017/2/15.
// */
//@Lazy
//@RestController
//@ApiIgnore
//@RequestMapping(value = "/security/erp/auth/bizSystem", produces = {"application/json;charset=UTF-8"})
//public class BizSystemConfigController extends WebBaseController {
//    @Resource
//    private RedisCache redisCache;
//    @Resource
//    private BizSystemRemote bizSystemRemote;
//
//    @GetMapping("/allSystemKey")
//    @ApiOperation(value = "查询所有业务系统信息", tags = "system")
//    @ApiResponses({
//            @ApiResponse(code = 200, response = BizSystemModel.class, message = "业务系统信息")
//    })
//    @AuthorityAnnotation(AuthorityAnnotationEnums.TEMP)
//    public String allSystemKey() {
//        List<BizSystemModel> systemKeyList = readDataAuth();
//        return returnSuccessInfo(systemKeyList);
//    }
//
//    /**
//     * 读取数据权限
//     */
//    private List<BizSystemModel> readDataAuth() {
//        String erpId = getCurrentPerson().getId();
//        //String positionId = getCurrentPerson().getPositionId();
//        List<BizSystemModel> retainList;
//        List<BizSystemModel> systemKeyList = bizSystemRemote.queryAllBizSystem();
//        retainList = new ArrayList<>();
////            if (getCurrentPerson().isAdmin()) {
//        retainList.addAll(systemKeyList);
////            } else {
////                Map<String, Object> param = new HashMap<>();
////                param.put("erpId", erpId);
////                param.put("systemKey", CommonConstants.AUTH_SYSTEM_KEY[0]);
////                param.put("dataType", PlatformDataAuthModel.ALL_DATA_TYPE);
////                param.put("positionId", positionId);
////                List<BizSystemModel> dataAuthList = platFormErpAuthConfigService.queryAllPersonDataAuthority(param);
////                if (dataAuthList == null || dataAuthList.size() == 0) {
////                    systemKeyList.clear();
////                } else {
////                    for (BizSystemModel data : dataAuthList) {
////                        String number = platFormErpAuthConfigService.getErpOrgNumberById(data.getOrgId());
////                        for (BizSystemModel system : systemKeyList) {
////                            if (system.getBizKey().startsWith(number) && !retainList.contains(system)) {
////                                retainList.add(system);
////                            }
////                        }
////                    }
////                }
////            }
//        return retainList;
//    }
//
//    @GetMapping("/querySystemPage")
//    @ApiOperation(value = "查询分页业务系统配置信息", tags = "system")
//    @AuthorityAnnotation(AuthorityAnnotationEnums.TEMP)
//    public String querySystemPage(BizSystemQueryForm form) {
//        Pagination<BizSystemModel> page = bizSystemRemote.queryBizSystemPage(form);
//        JSONObject json = toPageListData(page, BizSystemModel.class);
//        return json.toJSONString();
//    }
//
//    @GetMapping("/pickBizSystem")
//    @ApiOperation(value = "获取业务系统配置信息", tags = "system")
//    @AuthorityAnnotation(AuthorityAnnotationEnums.TEMP)
//    public String pickBizSystem(IdForm form) {
//        return returnSuccessInfo(bizSystemRemote.selectById(form));
//    }
//
//    @GetMapping("/pickBizSystemBySystemKey")
//    @ApiOperation(value = "获取业务系统配置信息", tags = "system")
//    @AuthorityAnnotation(AuthorityAnnotationEnums.TEMP)
//    public String pickBizSystemBySystemKey(BizSystemPickForm form) {
//        return returnSuccessInfo(bizSystemRemote.selectByKey(form));
//    }
//
//    @PostMapping(value="/deleteBizSystem")
//    @ApiOperation(value = "删除业务系统配置信息", tags = "system")
//    @AuthorityAnnotation(AuthorityAnnotationEnums.TEMP)
//    public String deleteBizSystem(@RequestBody IdForm form) {
//        bizSystemRemote.deleteBizSystem(form);
//        return returnSuccessInfo();
//    }
//
//    @PostMapping(value="/saveBizSystem")
//    @ApiOperation(value = "保存业务系统配置信息", tags = "system")
//    @AuthorityAnnotation(AuthorityAnnotationEnums.TEMP)
//    public String saveBizSystem(BizSystemSaveForm form) {
//        String[] dataType = form.getDataType();
//        BizSystemModel model = new BizSystemModel();
//        mapper.map(form, model);
//        if (dataType != null && dataType.length > 0) {
//            String[] dataTypeDesc = form.getDataTypeDesc();
//            String[] data = new String[dataType.length];
//            for (int i = 0; i < dataType.length; i++) {
//                data[i] = dataType[i] + "=" + dataTypeDesc[i];
//            }
//            model.setDataType(StringUtils.join(data, ",").replaceAll(" ", ""));
//        } else {
//            model.setDataType(null);
//        }
//        model.addOperatorInfo(getCurrentPerson().getId(),StringUtils.isNotEmpty(model.getId()));
//
//        bizSystemRemote.saveBizSystem(model);
//        return returnSuccessInfo();
//    }
//}
