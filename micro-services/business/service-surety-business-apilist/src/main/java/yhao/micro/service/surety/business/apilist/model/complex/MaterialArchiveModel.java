package yhao.micro.service.surety.business.apilist.model.complex;


import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.surety.business.apilist.model.enums.complex.ArchiveType;

import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/8 11:59
 * @Description:
 */
public class MaterialArchiveModel extends Entity<String> {
    @ApiModelProperty("担保单id")
    private String guaranteePid;
    @ApiModelProperty("归档编号")
    private String archivePid;
    @ApiModelProperty("归档日期")
    private Date archiveDate;
    @ApiModelProperty("归档类型")
    private ArchiveType archiveType;
    @ApiModelProperty("归档内容")
    private String archiveContent;
    @ApiModelProperty("仓库id")
    private String archiveDepotId;
    @ApiModelProperty("备注")
    private String remark;

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
}
