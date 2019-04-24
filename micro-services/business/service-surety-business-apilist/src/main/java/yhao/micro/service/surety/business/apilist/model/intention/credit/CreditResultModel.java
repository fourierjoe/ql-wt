package yhao.micro.service.surety.business.apilist.model.intention.credit;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

import java.util.Date;

/**
 * @Description:
 * @Created by ql on 2019/1/9 15:57
 * @Version: v1.0
 */
public class CreditResultModel extends Entity<String> {
	@ApiModelProperty("姓名")
	private String cltName;

	@ApiModelProperty("征信查询方式")
	private String isCredit;

	@ApiModelProperty("查征信的查询时间")
	private Date creditRealDate;

	@ApiModelProperty("征信结果")
	private String creditResult;

	@ApiModelProperty("征信状态/进度")
	private String creditState;

	@ApiModelProperty("征信备注")
	private String creditRemark;

	@ApiModelProperty("附件地址")
	private String attachUrl;

	public String getCltName() {
		return cltName;
	}

	public void setCltName(String cltName) {
		this.cltName = cltName;
	}

	public String getIsCredit() {
		return isCredit;
	}

	public void setIsCredit(String isCredit) {
		this.isCredit = isCredit;
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

	public String getCreditState() {
		return creditState;
	}

	public void setCreditState(String creditState) {
		this.creditState = creditState;
	}

	public String getCreditRemark() {
		return creditRemark;
	}

	public void setCreditRemark(String creditRemark) {
		this.creditRemark = creditRemark;
	}

	public String getAttachUrl() {
		return attachUrl;
	}

	public void setAttachUrl(String attachUrl) {
		this.attachUrl = attachUrl;
	}
}
