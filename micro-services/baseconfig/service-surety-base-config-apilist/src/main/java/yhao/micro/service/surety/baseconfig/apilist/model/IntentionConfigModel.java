package yhao.micro.service.surety.baseconfig.apilist.model;

import io.swagger.annotations.ApiModelProperty;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import yhao.infra.common.CommonStatusEnum;
import yhao.infra.common.model.Entity;
import yhao.micro.service.surety.baseconfig.apilist.enums.IntentionPositionTypeEnum;
import yhao.micro.service.surety.baseconfig.apilist.form.IntentionConfigSaveForm;

/**
 * Created with IntelliJ IDEA.
 * Description:单据分配设置模型  Model
 * User: GUO.MAO.LIN
 * Date: 2018-11-29
 * Time: 14:08
 */
public class IntentionConfigModel extends Entity<String> {
    private Mapper mapper = new DozerBeanMapper();

    @ApiModelProperty(value = "组织ID", example = "string")
    private String orgId;
    @ApiModelProperty(value = "岗位类型", example = "FOLLOWER")
    private IntentionPositionTypeEnum positionType;
    @ApiModelProperty(value = "跟单员或者报单员的账号id", example = "string")
    private String personId;
    @ApiModelProperty(value = "负责的部门组织ID串，用,隔开", example = "string")
    private String responsibleOrgIds;
    @ApiModelProperty(value = "状态", example = "ENABLED")
    private CommonStatusEnum status;

    /*以下是非数据库字段，是关联表的冗余字段，查询时可关联带出值*/
    @ApiModelProperty(value = "组织名称",example = "深圳万通")
    private String orgName;
    @ApiModelProperty(value = "跟单员或者报单员姓名",example = "许仙")
    private String personName;
    @ApiModelProperty(value = "负责组织的名称，用,隔开",example = "担保一部，担保二部")
    private String responsibleOrgNames;

    @ApiModelProperty(value = "状态中文描述", example = "启用")
    public String getStatusDesc(){
        if(status==null){
            return "";
        }
        if(status==CommonStatusEnum.ENABLED){
            return "启用";
        }
        if(status==CommonStatusEnum.DISABLED){
            return "禁用";
        }
        return "";
    }

    @ApiModelProperty(value = "岗位类型中文描述", example = "跟单员")
    public String getPositionTypeDesc(){
        return positionType != null ? positionType.getDesc() : "";
    }

    public IntentionConfigSaveForm toSaveForm() {
        return mapper.map(this, IntentionConfigSaveForm.class);
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public IntentionPositionTypeEnum getPositionType() {
        return positionType;
    }

    public void setPositionType(IntentionPositionTypeEnum positionType) {
        this.positionType = positionType;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getResponsibleOrgIds() {
        return responsibleOrgIds;
    }

    public void setResponsibleOrgIds(String responsibleOrgIds) {
        this.responsibleOrgIds = responsibleOrgIds;
    }

    public CommonStatusEnum getStatus() {
        return status;
    }

    public void setStatus(CommonStatusEnum status) {
        this.status = status;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getResponsibleOrgNames() {
        return responsibleOrgNames;
    }

    public void setResponsibleOrgNames(String responsibleOrgNames) {
        this.responsibleOrgNames = responsibleOrgNames;
    }
}
