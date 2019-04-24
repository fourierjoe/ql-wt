package yhao.micro.service.surety.business.apilist.model.guarantee.output;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.surety.business.apilist.model.enums.guarantee.CltTypEnum;
import yhao.micro.service.surety.business.apilist.model.enums.guarantee.CtfTypEnum;

import java.math.BigDecimal;

/**
 * @Description:
 * @Created by ql on 2019/1/11 11:16
 * @Version: v1.0
 */
public class PersonInfoTradesModel extends Entity<String> {
	@ApiModelProperty(value = "担保单ID", hidden = true)
	private String guaranteeId;

	@ApiModelProperty(value = "卖方物业信息表ID")
	private String estateId;

	@ApiModelProperty(value = "用户类型", example = "SELLER")
	private CltTypEnum cltTyp;

	@ApiModelProperty(value = "姓名", example = "王五")
	private String cltName;

	@ApiModelProperty(value = "国籍", example = "中国")
	private String ctfIssCntCod;

	@ApiModelProperty(value = "联系电话", example = "131")
	private String contactTele;

	@ApiModelProperty(value = "证件类型", example = "P01")
	private CtfTypEnum ctfTyp;

	@ApiModelProperty(value = "证件号码", example = "555")
	private String ctfIdc;

	@ApiModelProperty(value = "产权份额", example = "30")
	private BigDecimal propertyPortion;

	@ApiModelProperty(value = "住址", example = "深圳后海")
	private String address;

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

}
