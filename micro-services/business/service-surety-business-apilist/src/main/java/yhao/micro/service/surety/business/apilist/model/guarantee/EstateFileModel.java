package yhao.micro.service.surety.business.apilist.model.guarantee;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description:
 * @Created by ql on 2019/2/28 15:00
 * @Version: v1.0
 */
public class EstateFileModel extends Entity<String> {
	@ApiModelProperty(value = "担保单id", required = true)
	private String guaranteeId;

	@ApiModelProperty(value = "物业id", required = true)
	private String estateId;

	@ApiModelProperty(value = "产权状态", required = true)
	private String propertyState;

	@ApiModelProperty(value = "区域", required = true)
	private String region;

	@ApiModelProperty(value = "抵押权人", required = true)
	private String mortgagee;

	@ApiModelProperty(value = "抵押日期", required = true)
	private Date mortgageDate;

	@ApiModelProperty(value = "查档人", required = true)
	private String fileClerk;

	@ApiModelProperty(value = "查档时间", required = true)
	private Date fileDate;

	@ApiModelProperty(value = "查询结果", required = true, example = "成功/失败")
	private String fileResult;

	@ApiModelProperty(value = "面积", required = true)
	private String area;

	@ApiModelProperty(value = "登记价", required = true)
	private BigDecimal registrationPrice;

	@ApiModelProperty(value = "竣工日期", required = true)
	private Date completedDate;

	@ApiModelProperty(value = "类别", required = true)
	private String category;

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

	public String getPropertyState() {
		return propertyState;
	}

	public void setPropertyState(String propertyState) {
		this.propertyState = propertyState;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getMortgagee() {
		return mortgagee;
	}

	public void setMortgagee(String mortgagee) {
		this.mortgagee = mortgagee;
	}

	public Date getMortgageDate() {
		return mortgageDate;
	}

	public void setMortgageDate(Date mortgageDate) {
		this.mortgageDate = mortgageDate;
	}

	public String getFileClerk() {
		return fileClerk;
	}

	public void setFileClerk(String fileClerk) {
		this.fileClerk = fileClerk;
	}

	public Date getFileDate() {
		return fileDate;
	}

	public void setFileDate(Date fileDate) {
		this.fileDate = fileDate;
	}

	public String getFileResult() {
		return fileResult;
	}

	public void setFileResult(String fileResult) {
		this.fileResult = fileResult;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public BigDecimal getRegistrationPrice() {
		return registrationPrice;
	}

	public void setRegistrationPrice(BigDecimal registrationPrice) {
		this.registrationPrice = registrationPrice;
	}

	public Date getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
