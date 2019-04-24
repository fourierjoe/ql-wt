package yhao.micro.service.surety.business.apilist.form.guarantee;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.validate.IdForm;

/**
 * @Description:
 * @Created by ql on 2019/1/3 14:57
 * @Version: v1.0
 */
public class MainContractNumSaveForm extends IdForm {
	@ApiModelProperty("银行主合同编号")
	@NotBlank(message = "银行主合同编号不得为空")
	private String bankContractNum;

	public String getBankContractNum() {
		return bankContractNum;
	}

	public void setBankContractNum(String bankContractNum) {
		this.bankContractNum = bankContractNum;
	}
}
