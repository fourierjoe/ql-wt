package yhao.micro.service.surety.business.apilist.form.guarantee;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.IdUnForm;

/**
 * @Description:
 * @Created by ql on 2019/1/2 17:43
 * @Version: v1.0
 */
public class AttachmentSaveForm extends IdUnForm {
	@ApiModelProperty(value = "担保单ID", hidden = true)
	private String guaranteeId;

	@ApiModelProperty(value = "资料ID")
	private String dataId;

	@ApiModelProperty(value = "资料名字")
	private String dataName;

	@ApiModelProperty(value = "资料URL")
	private String dataUrl;

	@ApiModelProperty(value = "上传节点")
	private String nodeUpload;

	@ApiModelProperty(value = "是否收到")
	private String isReceive;

	@ApiModelProperty(value = "跟单员收到的资料份数")
	private String receiveNums;

	public String getGuaranteeId() {
		return guaranteeId;
	}

	public void setGuaranteeId(String guaranteeId) {
		this.guaranteeId = guaranteeId;
	}

	public String getDataId() {
		return dataId;
	}

	public void setDataId(String dataId) {
		this.dataId = dataId;
	}

	public String getDataName() {
		return dataName;
	}

	public void setDataName(String dataName) {
		this.dataName = dataName;
	}

	public String getDataUrl() {
		return dataUrl;
	}

	public void setDataUrl(String dataUrl) {
		this.dataUrl = dataUrl;
	}

	public String getNodeUpload() {
		return nodeUpload;
	}

	public void setNodeUpload(String nodeUpload) {
		this.nodeUpload = nodeUpload;
	}

	public String getIsReceive() {
		return isReceive;
	}

	public void setIsReceive(String isReceive) {
		this.isReceive = isReceive;
	}

	public String getReceiveNums() {
		return receiveNums;
	}

	public void setReceiveNums(String receiveNums) {
		this.receiveNums = receiveNums;
	}
}
