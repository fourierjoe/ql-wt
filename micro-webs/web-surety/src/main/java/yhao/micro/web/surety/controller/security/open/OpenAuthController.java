package yhao.micro.web.surety.controller.security.open;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yhao.micro.service.constants.CommonConstants;
import yhao.micro.service.constants.model.TreeModel;
import yhao.micro.service.surety.erp.auth.apilist.form.auth.AuthTreeQueryForm;
import yhao.micro.service.surety.erp.auth.apilist.model.AuthLeafModel;
import yhao.micro.web.surety.controller.WebBaseController;
import yhao.micro.web.surety.remote.erp.auth.AuthConfigRemote;
import yhao.micro.web.surety.remote.erp.auth.PersonAuthConfigRemote;
import yhao.micro.web.surety.remote.erp.auth.PositionAuthConfigRemote;
import yhao.micro.web.surety.util.TreeBuildUtil;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yoara on 2017/09/07.
 */
@Lazy
@RestController
@RequestMapping(value = "/security/open/auth",
        produces = { "application/json;charset=UTF-8" })
@Api(value = "OpenAuthController", tags = "开放-菜单功能权限树")
public class OpenAuthController extends WebBaseController {
    @Resource
    private AuthConfigRemote authConfigRemote;
    @Resource
    private PersonAuthConfigRemote personAuthConfigRemote;
    @Resource
    private PositionAuthConfigRemote positionAuthConfigRemote;

    @GetMapping("/queryAuthTree")
    @ApiOperation(value = "权限树查询")
    @ApiResponses({
            @ApiResponse(code = 200, response = TreeModel.class, message = "权限信息")
    })
    public String queryAuthTree(AuthTreeQueryForm form) {
        //拿到权限关联信息
        List<AuthLeafModel> listAuth = authConfigRemote.queryAuthLeafListBySystemKey(form);
        List<AuthLeafModel> listPAndA;
        if(StringUtils.isNotEmpty(form.getPersonId())){
            listPAndA = personAuthConfigRemote.queryAllPersonAuthorityId(form);
        }else{
            listPAndA = positionAuthConfigRemote.queryAllPositionAuthority(form);
        }
        return returnSuccessInfo(makeTreeModel(listAuth,listPAndA));
    }

    private List<TreeModel> makeTreeModel(List<AuthLeafModel> listAuth,List<AuthLeafModel> listPAndA) {
        List<TreeModel> treeModelList = new ArrayList<>();
        TreeModel root = new TreeModel();
        root.setId("0");
        root.setName(CommonConstants.SYSTEM_NAME);
        root.setOrder(1);
        root.setExpand(true);
        root.setChecked(false);
        treeModelList.add(root);
        if (CollectionUtils.isNotEmpty(listAuth)) {
            Map<String,TreeModel> typeMap = new HashMap<>();
            for (AuthLeafModel leaf : listAuth) {
                TreeModel item = new TreeModel();
                item.setId(leaf.getId());
                item.setName(leaf.getName());
                item.setPid(leaf.getTypeId());
                item.setpName(leaf.getTypeName());
                item.setOrder(leaf.getOrder());
                item.setExpand(false);
                item.setChecked(false);
                item.setLeaf(true);

                if(!typeMap.containsKey(leaf.getTypeTopId())){
                    TreeModel typeTop = new TreeModel();
                    typeTop.setId(leaf.getTypeTopId());
                    typeTop.setName(leaf.getTypeTopName());
                    typeTop.setPid("0");
                    typeTop.setpName(CommonConstants.SYSTEM_NAME);
                    typeTop.setOrder(leaf.getTypeTopOrder());
                    typeTop.setExpand(false);
                    typeTop.setChecked(false);
                    typeTop.setLeaf(false);
                    typeMap.put(leaf.getTypeTopId(),typeTop);
                }
                if(!typeMap.containsKey(leaf.getTypeId())){
                    TreeModel type = new TreeModel();
                    type.setId(leaf.getTypeId());
                    type.setName(leaf.getTypeName());
                    type.setPid(leaf.getTypeTopId());
                    type.setpName(leaf.getTypeTopName());
                    type.setOrder(leaf.getTypeOrder());
                    type.setExpand(false);
                    type.setChecked(false);
                    type.setLeaf(false);
                    typeMap.put(leaf.getTypeId(),type);
                }
                if(CollectionUtils.isNotEmpty(listPAndA)&&listPAndA.contains(leaf)){
                    item.setChecked(true);
                    item.setExpand(true);
                }
                treeModelList.add(item);
            }
            treeModelList.addAll(typeMap.values());
        }
        return TreeBuildUtil.buildTree(treeModelList);
    }
}
