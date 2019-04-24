package yhao.micro.service.surety.business.apilist.form.twiceRepay;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.validate.IdForm;

/**
 * @Description:
 * @Created by ql on 2019/2/20 10:42
 * @Version: v1.0
 */
public class RequisitesConfirmForm extends IdForm {
	@ApiModelProperty(value = "二次还款状态(1=客户经理发起,2=要件员确认,3=二次到账确认,4=申请出账,5=二次到账确认,6=二次赎楼)", hidden = true)
	private int twiceRepayState;

	@ApiModelProperty(value = "担保单Id")
	@NotBlank(message = "担保单Id不能为空")
	private String guaranteeId;

	@ApiModelProperty(value = "备注")
	private String remarks;

	public String getGuaranteeId() {
		return guaranteeId;
	}

	public void setGuaranteeId(String guaranteeId) {
		this.guaranteeId = guaranteeId;
	}

	public int getTwiceRepayState() {
		return twiceRepayState;
	}

	public void setTwiceRepayState(int twiceRepayState) {
		this.twiceRepayState = twiceRepayState;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
