package yhao.micro.service.surety.business.apilist.form.intention;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
import yhao.infra.apilist.validate.IdForm;
import yhao.micro.service.surety.business.apilist.model.enums.guarantee.CreditTypeEnum;

import javax.validation.constraints.NotNull;
import java.sql.Date;

/**
 * @Description:
 * @Created by ql on 2019/1/8 15:03
 * @Version: v1.0
 */
public class FollowerBuyerAndSellerForm extends IdForm {
	@ApiModelProperty(value = "担保单ID", hidden = true)
	private String guaranteeId;

	@ApiModelProperty(value = "征信查询类型", required = true)
	@NotNull(message = "征信查询类型不得为空")
	private CreditTypeEnum creditType;

	@ApiModelProperty(value = "征信预计查询时间", example = "2019-01-01")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date creditExpectedDate;

	@ApiModelProperty(value = "征信安排查询时间", example = "2019-01-01")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date creditArrangeDate;

	public String getGuaranteeId() {
		return guaranteeId;
	}

	public void setGuaranteeId(String guaranteeId) {
		this.guaranteeId = guaranteeId;
	}

	public CreditTypeEnum getCreditType() {
		return creditType;
	}

	public void setCreditType(CreditTypeEnum creditType) {
		this.creditType = creditType;
	}

	public Date getCreditExpectedDate() {
		return creditExpectedDate;
	}

	public void setCreditExpectedDate(Date creditExpectedDate) {
		this.creditExpectedDate = creditExpectedDate;
	}

	public Date getCreditArrangeDate() {
		return creditArrangeDate;
	}

	public void setCreditArrangeDate(Date creditArrangeDate) {
		this.creditArrangeDate = creditArrangeDate;
	}
}
