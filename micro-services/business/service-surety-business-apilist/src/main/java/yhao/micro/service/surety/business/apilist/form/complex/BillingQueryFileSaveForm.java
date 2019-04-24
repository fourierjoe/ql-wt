package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.ValidationForm;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/25 17:43
 * @Description:
 */
public class BillingQueryFileSaveForm implements ValidationForm {
    @ApiModelProperty(value = "担保单id", required = true)
    @NotBlank(message = "担保单id不得为空")
    private String guaranteePid;
    @ApiModelProperty(value = "产证类型",required = true)
    @NotBlank(message = "产证类型不得为空")
    private String deedType;
    @ApiModelProperty(value = "产证编号",required = true)
    @NotBlank(message = "产证编号不得为空")
    private String deedNum;
    @ApiModelProperty(value = "身份证号码",required = true)
    @NotBlank(message = "身份证号码不得为空")
    private String personInfo;
    @ApiModelProperty(value = "创建人id",hidden = true)
    private String createrId;

    public String getGuaranteePid() {
        return guaranteePid;
    }

    public void setGuaranteePid(String guaranteePid) {
        this.guaranteePid = guaranteePid;
    }

    public String getDeedType() {
        return deedType;
    }

    public void setDeedType(String deedType) {
        this.deedType = deedType;
    }

    public String getDeedNum() {
        return deedNum;
    }

    public void setDeedNum(String deedNum) {
        this.deedNum = deedNum;
    }

    public String getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(String personInfo) {
        this.personInfo = personInfo;
    }

    public String getCreaterId() {
        return createrId;
    }

    public void setCreaterId(String createrId) {
        this.createrId = createrId;
    }
}
