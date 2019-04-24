package yhao.micro.service.surety.business.apilist.form.guarantee;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.IdUnForm;

import java.sql.Date;

/**
 * @Description:
 * @Created by ql on 2019/1/2 17:50
 * @Version: v1.0
 */
public class CreditRecordSaveForm extends IdUnForm {
	@ApiModelProperty(value = "担保单ID", hidden = true)
	private String guaranteeId;

	@ApiModelProperty(value = "业主或买家ID")
	private String tradesId;

	@ApiModelProperty(value = "姓名")
	private String cltNam;

	@ApiModelProperty(value = "类型：买家或者卖家")
	private String cltTyp;

	@ApiModelProperty(value = "查询时间")
	private Date creditRealDate;
	@ApiModelProperty(value = "查询结果")
	private String creditResult;

	@ApiModelProperty(value = "备注")
	private String creditRemark;

	public String getGuaranteeId() {
		return guaranteeId;
	}

	public void setGuaranteeId(String guaranteeId) {
		this.guaranteeId = guaranteeId;
	}

	public String getTradesId() {
		return tradesId;
	}

	public void setTradesId(String tradesId) {
		this.tradesId = tradesId;
	}

	public String getCltNam() {
		return cltNam;
	}

	public void setCltNam(String cltNam) {
		this.cltNam = cltNam;
	}

	public String getCltTyp() {
		return cltTyp;
	}

	public void setCltTyp(String cltTyp) {
		this.cltTyp = cltTyp;
	}

	public Date getCreditRealDate() {
		return creditRealDate;
	}

	public void setCreditRealDate(Date creditRealDate) {
		this.creditRealDate = creditRealDate;
	}

	public String getCreditResult() {
		return creditResult;
	}

	public void setCreditResult(String creditResult) {
		this.creditResult = creditResult;
	}

	public String getCreditRemark() {
		return creditRemark;
	}

	public void setCreditRemark(String creditRemark) {
		this.creditRemark = creditRemark;
	}
}
