package yhao.micro.service.surety.business.apilist.form.guarantee;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;
import yhao.infra.apilist.ValidationForm;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Description: 反担保人信息
 * @Created by ql on 2019/1/3 18:08
 * @Version: v1.0
 */
public class AntiForm implements ValidationForm {
	@ApiModelProperty(value = "反担保人物业信息")
	private List<AntiEstateSaveForm> antiEstateSaveFormList;

	@ApiModelProperty(value = "反担保人信息")
	private AntiGuarantorSaveForm antiGuarantorForm;

	public List<AntiEstateSaveForm> getAntiEstateSaveFormList() {
		return antiEstateSaveFormList;
	}

	public void setAntiEstateSaveFormList(List<AntiEstateSaveForm> antiEstateSaveFormList) {
		this.antiEstateSaveFormList = antiEstateSaveFormList;
	}

	public AntiGuarantorSaveForm getAntiGuarantorForm() {
		return antiGuarantorForm;
	}

	public void setAntiGuarantorForm(AntiGuarantorSaveForm antiGuarantorForm) {
		this.antiGuarantorForm = antiGuarantorForm;
	}
}
