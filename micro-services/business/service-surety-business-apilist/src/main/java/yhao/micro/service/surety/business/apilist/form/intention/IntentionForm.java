package yhao.micro.service.surety.business.apilist.form.intention;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.micro.service.constants.enums.YNEnum;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Description:
 * @Created by ql on 2019/1/7 20:48
 * @Version: v1.0
 */
public class IntentionForm extends IdUnForm {
	@ApiModelProperty(value = "意向单是否提交, 保存 = NO, 提交 = YES", required = true)
	@NotNull(message = "意向单是否提交状态不能为空")
	private YNEnum isSubmit;

	@ApiModelProperty(value = "城市组织ID", example = "57e64f26-a6a6-4f87-8c03-67e1305d24ff", required = true)
	@NotBlank(message = "城市组织ID不能为空")
	private String orgId;

	@ApiModelProperty(value = "业务类型ID", example = "b20a5d06-6813-48aa-8599-24ffeba4c950", required = true)
	@NotBlank(message = "业务类型ID不能为空")
	private String bizId;

	@ApiModelProperty(value = "意向单附件信息")
	private List<IntentionAttachmentSaveForm> intentionAttachmentSaveFormList;

	@ApiModelProperty(value = "业主/买家征信信息", required = true)
	@Valid
	@NotEmpty(message = "业主/买家征信信息不得为空")
	private List<IntentionBuyerAndSellerSaveForm> intentionBuyerAndSellerSaveFormList;

	public YNEnum getIsSubmit() {
		return isSubmit;
	}

	public void setIsSubmit(YNEnum isSubmit) {
		this.isSubmit = isSubmit;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getBizId() {
		return bizId;
	}

	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

	public List<IntentionAttachmentSaveForm> getIntentionAttachmentSaveFormList() {
		return intentionAttachmentSaveFormList;
	}

	public void setIntentionAttachmentSaveFormList(List<IntentionAttachmentSaveForm> intentionAttachmentSaveFormList) {
		this.intentionAttachmentSaveFormList = intentionAttachmentSaveFormList;
	}

	public List<IntentionBuyerAndSellerSaveForm> getIntentionBuyerAndSellerSaveFormList() {
		return intentionBuyerAndSellerSaveFormList;
	}

	public void setIntentionBuyerAndSellerSaveFormList(List<IntentionBuyerAndSellerSaveForm> intentionBuyerAndSellerSaveFormList) {
		this.intentionBuyerAndSellerSaveFormList = intentionBuyerAndSellerSaveFormList;
	}
}
