package yhao.micro.service.surety.business.apilist.form.finance;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;
import yhao.infra.apilist.validate.PageForm;
import yhao.micro.service.surety.business.apilist.model.guarantee.page.GuaranteePageModel;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/11 17:54
 * @Description:
 */
public class FinanceBaseQueryForm extends PageForm{
    @ApiModelProperty("担保单id")
    private String guaranteeId;
    @ApiModelProperty(value = "团队id")
    private String orgId;
    @ApiModelProperty(value = "业务部门id")
    private String positionOrgId;
    @ApiModelProperty(value = "客户经理id")
    private String personId;
    @ApiModelProperty(value = "单据编号/物业名称/买卖双方")
    private String keyWord;
    public String getOrgId() {
        return orgId;
    }

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
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

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
}
