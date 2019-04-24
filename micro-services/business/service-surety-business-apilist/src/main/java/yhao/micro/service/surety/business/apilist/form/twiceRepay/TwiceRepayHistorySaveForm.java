package yhao.micro.service.surety.business.apilist.form.twiceRepay;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.IdUnForm;

/**
 * @Description:
 * @Created by ql on 2019/2/21 15:04
 * @Version: v1.0
 */
public class TwiceRepayHistorySaveForm extends IdUnForm {
	@ApiModelProperty(value = "担保单id")
	private String guaranteeId;

	@ApiModelProperty(value = "操作名称")
	private String operateName;

	@ApiModelProperty(value = "操作状态")
	private String operateState;

	@ApiModelProperty(value = "操作内容")
	private String operateContent;

	public String getGuaranteeId() {
		return guaranteeId;
	}

	public void setGuaranteeId(String guaranteeId) {
		this.guaranteeId = guaranteeId;
	}

	public String getOperateName() {
		return operateName;
	}

	public void setOperateName(String operateName) {
		this.operateName = operateName;
	}

	public String getOperateState() {
		return operateState;
	}

	public void setOperateState(String operateState) {
		this.operateState = operateState;
	}

	public String getOperateContent() {
		return operateContent;
	}

	public void setOperateContent(String operateContent) {
		this.operateContent = operateContent;
	}

	public static TwiceRepayHistorySaveForm newTwiceRepayHistorySaveForm() {
		return new TwiceRepayHistorySaveForm();
	}
}
