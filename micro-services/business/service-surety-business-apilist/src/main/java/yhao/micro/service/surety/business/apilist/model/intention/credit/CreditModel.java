package yhao.micro.service.surety.business.apilist.model.intention.credit;

import io.swagger.annotations.ApiModelProperty;
import yhao.micro.service.surety.business.apilist.model.intention.IntentionBasePageModel;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Created by ql on 2019/1/9 00:13
 * @Version: v1.0
 */
public class CreditModel extends IntentionBasePageModel {
	@ApiModelProperty(value = "担保单编号")
	private String guaranteeNum;

	@ApiModelProperty(value = "单据类型")
	private String guaranteeType;

	@ApiModelProperty(value = "业务类型")
	private String businessName;

	@ApiModelProperty("客户经理姓名")
	private String managerName;

	@ApiModelProperty(value = "客户经理电话")
	private String phone;

	@ApiModelProperty(value = "用户信息")
	private List<CreditOfBuyerAndSellerModel> creditOfBuyerAndSellerModelList;

	@ApiModelProperty(value = "用户征信结果")
	private List<CreditResultModel> creditResultModelList;

	@ApiModelProperty(value = "征信确认办结日期(征信table页面实际办理日期)")
	private Date creditEndDate;

	@ApiModelProperty(value = "征信是否报送")
	private String isCreditReport;

	public String getGuaranteeNum() {
		return guaranteeNum;
	}

	public void setGuaranteeNum(String guaranteeNum) {
		this.guaranteeNum = guaranteeNum;
	}

	public String getGuaranteeType() {
		return guaranteeType;
	}

	public void setGuaranteeType(String guaranteeType) {
		this.guaranteeType = guaranteeType;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<CreditOfBuyerAndSellerModel> getCreditOfBuyerAndSellerModelList() {
		return creditOfBuyerAndSellerModelList;
	}

	public void setCreditOfBuyerAndSellerModelList(List<CreditOfBuyerAndSellerModel> creditOfBuyerAndSellerModelList) {
		this.creditOfBuyerAndSellerModelList = creditOfBuyerAndSellerModelList;
	}

	public List<CreditResultModel> getCreditResultModelList() {
		return creditResultModelList;
	}

	public void setCreditResultModelList(List<CreditResultModel> creditResultModelList) {
		this.creditResultModelList = creditResultModelList;
	}

	public Date getCreditEndDate() {
		return creditEndDate;
	}

	public void setCreditEndDate(Date creditEndDate) {
		this.creditEndDate = creditEndDate;
	}

	public String getIsCreditReport() {
		return isCreditReport;
	}

	public void setIsCreditReport(String isCreditReport) {
		this.isCreditReport = isCreditReport;
	}
}
