package yhao.micro.service.surety.business.apilist.model.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/25 19:36
 * @Description:
 */
public class BillingQueryFileRecordModel extends Entity<String> {
    @ApiModelProperty(value = "担保单id")
    private String guaranteePid;
    @ApiModelProperty(value = "产权状态")
    private String status;
    @ApiModelProperty(value = "抵押日期")
    private Date mortgageDate;
    @ApiModelProperty(value = "抵押权人")
    private String mortgagePerson;
    @ApiModelProperty(value = "区域")
    private String area;
    @ApiModelProperty(value = "查档人")
    private String queryPersonId;
    @ApiModelProperty(value = "查档结果")
    private String result;
    @ApiModelProperty(value = "查档请求内容")
    private String queryContent;
    @ApiModelProperty(value = "产证类型")
    private String deedType;
    @ApiModelProperty(value = "产证编号")
    private String deedNum;
    @ApiModelProperty(value = "身份证号码")
    private String personInfo;

    public String getGuaranteePid() {
        return guaranteePid;
    }

    public void setGuaranteePid(String guaranteePid) {
        this.guaranteePid = guaranteePid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getMortgageDate() {
        return mortgageDate;
    }

    public void setMortgageDate(Date mortgageDate) {
        this.mortgageDate = mortgageDate;
    }

    public String getMortgagePerson() {
        return mortgagePerson;
    }

    public void setMortgagePerson(String mortgagePerson) {
        this.mortgagePerson = mortgagePerson;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getQueryPersonId() {
        return queryPersonId;
    }

    public void setQueryPersonId(String queryPersonId) {
        this.queryPersonId = queryPersonId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getQueryContent() {
        return queryContent;
    }

    public void setQueryContent(String queryContent) {
        this.queryContent = queryContent;
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
}
