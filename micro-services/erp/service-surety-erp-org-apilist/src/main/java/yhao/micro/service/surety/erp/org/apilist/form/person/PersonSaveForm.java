package yhao.micro.service.surety.erp.org.apilist.form.person;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import yhao.infra.apilist.ValidationForm;
import yhao.infra.common.CommonStatusEnum;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by yoara on 2017/8/24.
 */
public class PersonSaveForm implements ValidationForm {
    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "组织id")
    @NotEmpty(message="组织不能为空")
    private String orgId;

    @ApiModelProperty(value = "是否启用", required = true)
    @NotNull(message="是否启用需要设置")
    private CommonStatusEnum status;

    @ApiModelProperty(value = "性别，1为男，0为女", required = true)
    @NotNull(message="性别需要设置")
    private Integer sex;

    @ApiModelProperty(value = "姓名", required = true)
    @NotEmpty(message="姓名不能为空")
    private String name;

    @ApiModelProperty(value = "证件号", required = true)
    @NotEmpty(message="证件号不能为空")
    private String cardId;

    @ApiModelProperty(value = "挂职ID", required = true)
    @NotEmpty(message="挂职ID不能为空")
    private String positionLinkId;

    @ApiModelProperty(value = "手机号", required = true)
    @NotEmpty(message="手机号不能为空")
    private String phone;

    @ApiModelProperty(value = "是否为组织管理员")
    private boolean manager;

    @ApiModelProperty(value = "入职日期", required = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message="入职日期不得为空")
    private Date joinDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public CommonStatusEnum getStatus() {
        return status;
    }

    public void setStatus(CommonStatusEnum status) {
        this.status = status;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getPositionLinkId() {
        return positionLinkId;
    }

    public void setPositionLinkId(String positionLinkId) {
        this.positionLinkId = positionLinkId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isManager() {
        return manager;
    }

    public void setManager(boolean manager) {
        this.manager = manager;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }
}
