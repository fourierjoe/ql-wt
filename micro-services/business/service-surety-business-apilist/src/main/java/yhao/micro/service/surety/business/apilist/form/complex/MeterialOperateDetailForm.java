package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;

import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/8 17:42
 * @Description:材料借还详情
 */
public class MeterialOperateDetailForm implements ValidationForm {
    @ApiModelProperty("单据编号")
    private String intentionPid;
    @ApiModelProperty("房产名称")
    private String estateName;
    @ApiModelProperty("客户经理名称")
    private String createrName;
    @ApiModelProperty("部门")
    private String orgName;
    @ApiModelProperty("归档编号")
    private String archivePid;
    @ApiModelProperty("借出人")
    private String lendName;
    @ApiModelProperty("借出日期")
    private Date lendDate;
    @ApiModelProperty("归还日期")
    private Date remandDate;
    @ApiModelProperty("借出内容")
    private String lendContent;
    @ApiModelProperty("归还内容")
    private String remandContent;

    public String getIntentionPid() {
        return intentionPid;
    }

    public void setIntentionPid(String intentionPid) {
        this.intentionPid = intentionPid;
    }

    public String getEstateName() {
        return estateName;
    }

    public void setEstateName(String estateName) {
        this.estateName = estateName;
    }

    public String getCreaterName() {
        return createrName;
    }

    public void setCreaterName(String createrName) {
        this.createrName = createrName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getArchivePid() {
        return archivePid;
    }

    public void setArchivePid(String archivePid) {
        this.archivePid = archivePid;
    }

    public String getLendName() {
        return lendName;
    }

    public void setLendName(String lendName) {
        this.lendName = lendName;
    }

    public Date getLendDate() {
        return lendDate;
    }

    public void setLendDate(Date lendDate) {
        this.lendDate = lendDate;
    }

    public Date getRemandDate() {
        return remandDate;
    }

    public void setRemandDate(Date remandDate) {
        this.remandDate = remandDate;
    }

    public String getLendContent() {
        return lendContent;
    }

    public void setLendContent(String lendContent) {
        this.lendContent = lendContent;
    }

    public String getRemandContent() {
        return remandContent;
    }

    public void setRemandContent(String remandContent) {
        this.remandContent = remandContent;
    }
}
