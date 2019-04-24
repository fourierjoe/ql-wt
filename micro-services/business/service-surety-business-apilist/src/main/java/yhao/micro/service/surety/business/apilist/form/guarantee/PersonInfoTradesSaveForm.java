package yhao.micro.service.surety.business.apilist.form.guarantee;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.micro.service.surety.business.apilist.model.enums.guarantee.CltTypEnum;
import yhao.micro.service.surety.business.apilist.model.enums.guarantee.CreditTypeEnum;
import yhao.micro.service.surety.business.apilist.model.enums.guarantee.CtfTypEnum;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * @Description:
 * @Created by ql on 2019/1/2 18:34
 * @Version: v1.0
 */
public class PersonInfoTradesSaveForm extends IdUnForm {
	@ApiModelProperty(value = "担保单ID", hidden = true)
	private String guaranteeId;

	@ApiModelProperty(value = "卖方物业信息表ID")
	private String estateId;

	@ApiModelProperty(value = "用户类型", example = "SELLER")
	@NotNull(message = "用户类型不得为空")
	private CltTypEnum cltTyp;

	@ApiModelProperty(value = "姓名", example = "王五")
	@NotBlank(message = "姓名不得为空")
	private String cltName;

	@ApiModelProperty(value = "国籍", example = "中国")
	@NotBlank(message = "国籍不得为空")
	private String ctfIssCntCod;

	@ApiModelProperty(value = "联系电话", example = "131")
	@NotBlank(message = "联系电话不得为空")
	private String contactTele;

	@ApiModelProperty(value = "证件类型", example = "P01")
	@NotNull(message = "证件类型不得为空")
	private CtfTypEnum ctfTyp;

	@ApiModelProperty(value = "证件号码", example = "555")
	@NotBlank(message = "证件号码不得为空")
	private String ctfIdc;

	@ApiModelProperty(value = "产权份额", example = "30")
	@NotNull(message = "产权份额不得为空")
	private BigDecimal propertyPortion;

	@ApiModelProperty(value = "住址", example = "深圳后海")
	@NotBlank(message = "住址不得为空")
	private String address;

	@ApiModelProperty(value = "征信查询类型")
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

	public String getEstateId() {
		return estateId;
	}

	public void setEstateId(String estateId) {
		this.estateId = estateId;
	}

	public CltTypEnum getCltTyp() {
		return cltTyp;
	}

	public void setCltTyp(CltTypEnum cltTyp) {
		this.cltTyp = cltTyp;
	}

	public String getCltName() {
		return cltName;
	}

	public void setCltName(String cltName) {
		this.cltName = cltName;
	}

	public String getCtfIssCntCod() {
		return ctfIssCntCod;
	}

	public void setCtfIssCntCod(String ctfIssCntCod) {
		this.ctfIssCntCod = ctfIssCntCod;
	}

	public String getContactTele() {
		return contactTele;
	}

	public void setContactTele(String contactTele) {
		this.contactTele = contactTele;
	}

	public CtfTypEnum getCtfTyp() {
		return ctfTyp;
	}

	public void setCtfTyp(CtfTypEnum ctfTyp) {
		this.ctfTyp = ctfTyp;
	}

	public String getCtfIdc() {
		return ctfIdc;
	}

	public void setCtfIdc(String ctfIdc) {
		this.ctfIdc = ctfIdc;
	}

	public BigDecimal getPropertyPortion() {
		return propertyPortion;
	}

	public void setPropertyPortion(BigDecimal propertyPortion) {
		this.propertyPortion = propertyPortion;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
