package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;
import yhao.micro.service.surety.business.apilist.model.enums.complex.ArchiveType;

import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/8 17:15
 * @Description:
 */
public class MaterialArchiveSaveForm implements ValidationForm {
    @ApiModelProperty(value = "担保单id",required = true)
    private String guaranteePid;
    @ApiModelProperty(value = "归档编号",required = true)
    private String archivePid;
    @ApiModelProperty(value = "归档日期",required = true)
    private Date archiveDate;
    @ApiModelProperty(value = "归档类型",required = true)
    private ArchiveType archiveType;
    @ApiModelProperty(value = "归档内容")
    private String archiveContent;
    @ApiModelProperty(value = "仓库id",required = true)
    private String archiveDepotId;
    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty(value = "创建人id",hidden = true)
    private String createrId;

    public String getGuaranteePid() {
        return guaranteePid;
    }

    public void setGuaranteePid(String guaranteePid) {
        this.guaranteePid = guaranteePid;
    }

    public String getArchivePid() {
        return archivePid;
    }

    public void setArchivePid(String archivePid) {
        this.archivePid = archivePid;
    }

    public Date getArchiveDate() {
        return archiveDate;
    }

    public void setArchiveDate(Date archiveDate) {
        this.archiveDate = archiveDate;
    }

    public ArchiveType getArchiveType() {
        return archiveType;
    }

    public void setArchiveType(ArchiveType archiveType) {
        this.archiveType = archiveType;
    }

    public String getArchiveContent() {
        return archiveContent;
    }

    public void setArchiveContent(String archiveContent) {
        this.archiveContent = archiveContent;
    }

    public String getArchiveDepotId() {
        return archiveDepotId;
    }

    public void setArchiveDepotId(String archiveDepotId) {
        this.archiveDepotId = archiveDepotId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreaterId() {
        return createrId;
    }

    public void setCreaterId(String createrId) {
        this.createrId = createrId;
    }
}
