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
import yhao.infra.apilist.validate.IdForm;
import yhao.micro.service.constants.model.TreeModel;
import yhao.micro.service.surety.erp.org.apilist.form.org.OrgQueryForm;
import yhao.micro.service.surety.erp.org.apilist.form.org.PositionOrgQueryForm;
import yhao.micro.service.surety.erp.org.apilist.model.OrgModel;
import yhao.micro.web.surety.controller.WebBaseController;
import yhao.micro.web.surety.util.TreeBuildUtil;
import yhao.micro.web.surety.remote.erp.org.OrgRemote;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2018-11-28
 * Time: 21:33
 */
@Lazy
@RestController
@RequestMapping(value = "/security/open/org", produces = {"application/json;charset=UTF-8"})
@Api(value = "OpenOrgController", tags = "开放-组织查询")
public class OpenOrgController extends WebBaseController {
    @Resource
    private OrgRemote orgRemote;

    @GetMapping("/queryOrgTree")
    @ApiOperation(value = "根据指定的根查询所有指定类型的下级组织，而且会带出所有的父亲节点")
    @ApiResponses({
            @ApiResponse(code = 200, response = TreeModel.class, message = "组织数据")
    })
    public String queryOrgTree(OrgQueryForm queryForm) {
        if (StringUtils.isNotBlank(queryForm.getOrgTypes())) {
            queryForm.setFindParent(true);
        }
        List<OrgModel> orgModelList = orgRemote.queryOrgList(queryForm);
        return returnSuccessInfo(makeTreeModel(orgModelList));
    }

    @GetMapping("/queryCityOrgByChildOrgId")
    @ApiOperation(value = "查询指定组织的所属城市组织")
    @ApiResponses({
            @ApiResponse(code = 200, response = TreeModel.class, message = "组织数据")
    })
    public String queryCityOrgByChildOrgId(IdForm idForm) {
        return returnSuccessInfo(orgRemote.queryCityOrgByChildOrgId(idForm));
    }

    @GetMapping("/queryOrgTreeByPosition")
    @ApiOperation(value = "根据指定的挂职岗位所在的城市组织为根查询所有指定类型的下级组织，而且会带出所有的父亲节点")
    @ApiResponses({
            @ApiResponse(code = 200, response = TreeModel.class, message = "组织数据")
    })
    public String queryOrgTreeByPosition(PositionOrgQueryForm queryForm) {
        if (StringUtils.isNotBlank(queryForm.getOrgTypes())) {
            queryForm.setFindParent(true);
        }
        List<OrgModel> orgModelList = orgRemote.queryOrgListByPosition(queryForm);
        return returnSuccessInfo(makeTreeModel(orgModelList));
    }

    private List<TreeModel> makeTreeModel(List<OrgModel> orgModelList) {
        List<TreeModel> treeModelList = new ArrayList<>();
        Set<String> parentIdSet = new HashSet<>();
        if (CollectionUtils.isNotEmpty(orgModelList)) {
            for (OrgModel org : orgModelList) {
                parentIdSet.add(org.getParentId());
                TreeModel item = new TreeModel();
                item.setId(org.getId());
                item.setName(org.getName());
                item.setPid(org.getParentId());
                item.setpName(org.getParentOrgName());
                item.setLongNumber(org.getLongNumber());
                item.setOrder(StringUtils.length(org.getName()));
                item.setLeaf(false);
                item.setChecked(false);
                item.setExpand(true);
                treeModelList.add(item);
            }
        }
        if (CollectionUtils.isNotEmpty(treeModelList)) {
            treeModelList.forEach(model -> {
                if (!parentIdSet.contains(model.getId())) {
                    model.setLeaf(true);
                }
            });
        }
        return TreeBuildUtil.buildTree(treeModelList);

    }


}
