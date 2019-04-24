package yhao.micro.service.surety.business.apilist.model.intention.follower;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
import yhao.infra.common.model.Entity;
import yhao.micro.service.surety.business.apilist.model.enums.guarantee.CreditTypeEnum;
import yhao.micro.service.surety.business.apilist.model.enums.intention.RepayTypeEnum;

import java.util.Date;

/**
 * @Description:
 * @Created by ql on 2019/1/8 17:36
 * @Version: v1.0
 */
public class FollowerCreditModel extends Entity<String> {
	@ApiModelProperty(value = "用户类型", example = "BUYER")
	private String cltTyp;

	@ApiModelProperty("姓名")
	private String cltName;

	@ApiModelProperty("电话")
	private String contactTele;

	@ApiModelProperty(value = "征信查询方式")
	private String creditType;

	@ApiModelProperty(value = "征信查询方式(页面显示)")
	private String creditTypeEnum;

	@ApiModelProperty(value = "征信预计查询日期")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date creditExpectedDate;

	@ApiModelProperty(value = "征信安排查询时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date creditArrangeDate;

	public String getCreditTypeEnum() {
		return creditTypeEnum;
	}

	public void setCreditTypeEnum(String creditTypeEnum) {
		if (RepayTypeEnum.DETERMINED.toString().equals(creditType)) {
			this.creditTypeEnum = CreditTypeEnum.DETERMINED.getDesc();
		} else if (RepayTypeEnum.UNDETERMINED.toString().equals(creditType)) {
			this.creditTypeEnum = CreditTypeEnum.UNDETERMINED.getDesc();
		} else if (RepayTypeEnum.MANAGERDEAL.toString().equals(creditType)) {
			this.creditTypeEnum = CreditTypeEnum.MANAGERDEAL.getDesc();
		} else {
			this.creditTypeEnum = "";
		}
	}

	public Date getCreditArrangeDate() {
		return creditArrangeDate;
	}

	public void setCreditArrangeDate(Date creditArrangeDate) {
		this.creditArrangeDate = creditArrangeDate;
	}

	public String getCreditType() {
		return creditType;
	}

	public void setCreditType(String creditType) {
		this.creditType = creditType;
	}

	public Date getCreditExpectedDate() {
		return creditExpectedDate;
	}

	public void setCreditExpectedDate(Date creditExpectedDate) {
		this.creditExpectedDate = creditExpectedDate;
	}

	public String getCltTyp() {
		return cltTyp;
	}

	public void setCltTyp(String cltTyp) {
		this.cltTyp = cltTyp;
	}

	public String getCltName() {
		return cltName;
	}

	public void setCltName(String cltName) {
		this.cltName = cltName;
	}

	public String getContactTele() {
		return contactTele;
	}

	public void setContactTele(String contactTele) {
		this.contactTele = contactTele;
	}
}
