package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.PageForm;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/5 15:07
 * @Description:
 */
public class ComplexRedemptionBaseQueryForm extends PageForm {
    @ApiModelProperty(value = "团队id")
    private String orgId;
    @ApiModelProperty(value = "业务部门id")
    private String positionOrgId;
    @ApiModelProperty(value = "客户经理id")
    private String personId;
    @ApiModelProperty(value = "业务类别id")
    private String bizId;
    @ApiModelProperty(value = "单据编号/物业名称/买卖双方")
    private String keyWord;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getPositionOrgId() {
        return positionOrgId;
    }

    public void setPositionOrgId(String positionOrgId) {
        this.positionOrgId = positionOrgId;
    }

    @Override
    public String getPersonId() {
        return personId;
    }

    @Override
    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
}
