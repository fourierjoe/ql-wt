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
import yhao.micro.service.surety.erp.auth.apilist.form.auth.DataAuthTreeQueryForm;
import yhao.micro.service.surety.erp.auth.apilist.model.DataAuthModel;
import yhao.micro.service.surety.erp.org.apilist.enums.OrgTypeEnum;
import yhao.micro.service.surety.erp.org.apilist.form.org.OrgQueryForm;
import yhao.micro.service.surety.erp.org.apilist.model.OrgModel;
import yhao.micro.service.surety.erp.org.apilist.model.PersonModel;
import yhao.micro.web.surety.controller.WebBaseController;
import yhao.micro.web.surety.remote.erp.auth.PersonAuthConfigRemote;
import yhao.micro.web.surety.remote.erp.auth.PositionAuthConfigRemote;
import yhao.micro.web.surety.remote.erp.org.OrgRemote;
import yhao.micro.web.surety.remote.erp.org.PersonRemote;
import yhao.micro.web.surety.util.TreeBuildUtil;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by yoara on 2017/09/07.
 */
@Lazy
@RestController
@RequestMapping(value = "/security/open/dataAuth",
        produces = {"application/json;charset=UTF-8"})
@Api(value = "OpenDataAuthController", tags = "开放-数据权限树查询")
public class OpenDataAuthController extends WebBaseController {
    @Resource
    private PersonAuthConfigRemote personAuthConfigRemote;
    @Resource
    private PositionAuthConfigRemote positionAuthConfigRemote;
    @Resource
    private OrgRemote orgRemote;
    @Resource
    private PersonRemote personRemote;

    @GetMapping("/queryDataAuthTree")
    @ApiOperation(value = "数据权限树查询")
    @ApiResponses({
            @ApiResponse(code = 200, response = TreeModel.class, message = "数据权限信息")
    })
    public String queryDataAuthTree(DataAuthTreeQueryForm form) {
        //获取组织结构树信息
        List<OrgModel> erpOrgList = orgRemote.queryOrgList(new OrgQueryForm());
        //获取当前岗位已绑定数据
        List<DataAuthModel> dataAuthList;
        if (StringUtils.isNotEmpty(form.getPersonId())) {
            dataAuthList = personAuthConfigRemote.queryAllPersonDataAuthority(form);
        } else {
            dataAuthList = positionAuthConfigRemote.queryAllPositionDataAuthority(form);
        }
        return returnSuccessInfo(makeTreeModel(erpOrgList, dataAuthList));
    }

    @GetMapping("/queryCityDataAuth")
    @ApiOperation(value = "查询人或者岗位有哪些城市的数据权限")
    @ApiResponses({
            @ApiResponse(code = 200, response = OrgModel.class, message = "数据权限信息")
    })
    public String queryCityDataAuth(DataAuthTreeQueryForm form) {
        OrgQueryForm queryForm = new OrgQueryForm();
        queryForm.setOrgTypes(OrgTypeEnum.CITY.name());
        List<OrgModel> cityOrgList = orgRemote.queryOrgList(queryForm);
        List<DataAuthModel> dataAuthList;
        if (StringUtils.isNotEmpty(form.getPersonId())) {
            dataAuthList = personAuthConfigRemote.queryAllPersonDataAuthority(form);
            addManagerOrg(dataAuthList, form.getPersonId());
        } else {
            dataAuthList = positionAuthConfigRemote.queryAllPositionDataAuthority(form);
        }
        return returnSuccessInfo(matchOrg(cityOrgList, dataAuthList));
    }

    @GetMapping("/queryDataAuthByParent")
    @ApiOperation(value = "根据上级查询有数据权限的下级")
    @ApiResponses({
            @ApiResponse(code = 200, response = OrgModel.class, message = "数据权限信息")
    })
    public String queryDataAuthByParent(DataAuthTreeQueryForm form) {
        OrgQueryForm queryForm = new OrgQueryForm();
        queryForm.setParentId(form.getParentOrgId());
        queryForm.setOrgTypes(OrgTypeEnum.OPERATION_SECURITY.name());
        List<OrgModel> orgList = orgRemote.queryOrgList(queryForm);
        List<DataAuthModel> dataAuthList;
        if (StringUtils.isNotEmpty(form.getPersonId())) {
            dataAuthList = personAuthConfigRemote.queryAllPersonDataAuthority(form);
            addManagerOrg(dataAuthList, form.getPersonId());
        } else {
            dataAuthList = positionAuthConfigRemote.queryAllPositionDataAuthority(form);
        }
        return returnSuccessInfo(matchOrg(orgList, dataAuthList));
    }

    private void addManagerOrg(List<DataAuthModel> dataAuthList, String personId) {
        if (StringUtils.isNotBlank(personId)) {
            PersonModel person = personRemote.pickPersonById(new IdForm(personId));
            if (person != null && person.isManager()) {
                OrgQueryForm orgQueryForm = new OrgQueryForm();
                orgQueryForm.setIdList(Arrays.asList(personId));
                List<OrgModel> orgList = orgRemote.queryOrgList(orgQueryForm);
                OrgModel managerOrg = CollectionUtils.isEmpty(orgList) ? null : orgList.get(0);
                if (managerOrg != null && (managerOrg.getOrgType() == OrgTypeEnum.CITY || managerOrg.getOrgType() == OrgTypeEnum.OPERATION_SECURITY)) {
                    DataAuthModel dataAuthModel = new DataAuthModel();
                    dataAuthModel.setOrgId(managerOrg.getId());
                    dataAuthModel.setOrgLongNumber(managerOrg.getLongNumber());
                    dataAuthList.add(dataAuthModel);
                }
            }
        }
    }

    private List<TreeModel> makeTreeModel(List<OrgModel> erpOrgList, List<DataAuthModel> dataAuthList) {
        List<TreeModel> treeModelList = new ArrayList<>();
        Set<String> dataAuthOrgIds = null;
        if (CollectionUtils.isNotEmpty(dataAuthList)) {
            dataAuthOrgIds = dataAuthList.stream().map(DataAuthModel::getOrgId).collect(Collectors.toSet());
        }
        Set<String> parentIdSet = new HashSet<>();
        Set<String> hasChecked = new HashSet<>();
        if (CollectionUtils.isNotEmpty(erpOrgList)) {
            for (OrgModel org : erpOrgList) {
                parentIdSet.add(org.getParentId());
                TreeModel item = new TreeModel();
                item.setId(org.getId());
                item.setName(org.getName());
                item.setPid(org.getParentId());
                item.setpName(org.getParentOrgName());
                item.setOrder(StringUtils.length(org.getName()));
                item.setLongNumber(org.getLongNumber());
                item.setLeaf(false);
                if ((dataAuthOrgIds != null && dataAuthOrgIds.contains(org.getId()))
                        || hasChecked.contains(org.getParentId())) {
                    item.setChecked(true);
                    item.setExpand(true);
                    hasChecked.add(org.getId());
                }
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

    private List<OrgModel> matchOrg(List<OrgModel> orgModelList, List<DataAuthModel> dataAuthList) {
        List<OrgModel> authOrgModelList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(orgModelList) && CollectionUtils.isNotEmpty(dataAuthList)) {
            for (OrgModel org : orgModelList) {
                for (DataAuthModel authModel : dataAuthList) {
                    if (authModel.getOrgLongNumber().contains(org.getLongNumber())
                            || org.getLongNumber().contains(authModel.getOrgLongNumber())) {
                        authOrgModelList.add(org);
                        break;
                    }
                }
            }
        }
        return authOrgModelList;
    }
}
