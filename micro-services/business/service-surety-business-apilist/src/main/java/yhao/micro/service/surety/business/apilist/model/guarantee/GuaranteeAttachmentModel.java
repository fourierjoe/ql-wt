package yhao.micro.service.surety.business.apilist.model.guarantee;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

import java.util.Date;

/**
 * @Description:
 * @Created by ql on 2018/12/17 16:08
 * @Version: v1.0
 */
public class GuaranteeAttachmentModel extends Entity<String> {

    @ApiModelProperty("附件名称")
    private String attachmentName;

    @ApiModelProperty("附件URL")
    private String attachmentUrl;

    @ApiModelProperty("上传人")
    private String createOperatorId;

    @ApiModelProperty("上传时间")
    private Date crerteTime;

    public String getAttachmentName() {
        return attachmentName;
    }

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName;
    }

    public String getAttachmentUrl() {
        return attachmentUrl;
    }

    public void setAttachmentUrl(String attachmentUrl) {
        this.attachmentUrl = attachmentUrl;
    }

    @Override
    public String getCreateOperatorId() {
        return createOperatorId;
    }

    @Override
    public void setCreateOperatorId(String createOperatorId) {
        this.createOperatorId = createOperatorId;
    }

    public Date getCrerteTime() {
        return crerteTime;
    }

    public void setCrerteTime(Date crerteTime) {
        this.crerteTime = crerteTime;
    }
}
