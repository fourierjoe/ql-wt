package yhao.micro.service.surety.business.apilist.model.guarantee.output;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.constants.enums.YNEnum;
import yhao.micro.service.surety.business.apilist.model.enums.guarantee.DeedTypeEnum;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description:
 * @Created by ql on 2019/1/11 11:16
 * @Version: v1.0
 */
public class EstateOutModel extends Entity<String> {
	@ApiModelProperty(value = "担保单ID", hidden = true)
	private String guaranteeId;

	@ApiModelProperty(value = "物业名称", example = "XX小区")
	private String propertyName;

	@ApiModelProperty(value = "座落", example = "XX坐落")
	private String propertyLocation;

	@ApiModelProperty(value = "房号",example = "XX房号")
	private String propertyRoomNo;

	@ApiModelProperty(value = "是否有建模", example = "NO")
	private YNEnum isModeling;

	@ApiModelProperty(value = "用途", example = "住宅")
	private String estateUse;
	@ApiModelProperty(value = "面积" ,example = "130.21")
	private BigDecimal estateArea;

	@ApiModelProperty(value = "房产名称", example = "XX房产")
	private String estateName;

	@ApiModelProperty(value = "产证类型", example = "FCZ")
	private DeedTypeEnum deedType;
	@ApiModelProperty(value = "产证编号", example = "147")
	private String deedNum;

	@ApiModelProperty(value = "评估价", example = "13000001")
	private BigDecimal evaluatePrice;

	@ApiModelProperty(value = "来源联系人", example = "李四")
	private String sourceContactName;
	@ApiModelProperty(value = "来源电话", example = "131")
	private String sourceContactTele;

	@ApiModelProperty(value = "业主个人信息")
	private List<PersonInfoTradesModel> personInfoTradesModelList;

	public List<PersonInfoTradesModel> getPersonInfoTradesModelList() {
		return personInfoTradesModelList;
	}

	public void setPersonInfoTradesModelList(List<PersonInfoTradesModel> personInfoTradesModelList) {
		this.personInfoTradesModelList = personInfoTradesModelList;
	}

	public String getGuaranteeId() {
		return guaranteeId;
	}

	public void setGuaranteeId(String guaranteeId) {
		this.guaranteeId = guaranteeId;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertyLocation() {
		return propertyLocation;
	}

	public void setPropertyLocation(String propertyLocation) {
		this.propertyLocation = propertyLocation;
	}

	public String getPropertyRoomNo() {
		return propertyRoomNo;
	}

	public void setPropertyRoomNo(String propertyRoomNo) {
		this.propertyRoomNo = propertyRoomNo;
	}

	public YNEnum getIsModeling() {
		return isModeling;
	}

	public void setIsModeling(YNEnum isModeling) {
		this.isModeling = isModeling;
	}

	public String getEstateUse() {
		return estateUse;
	}

	public void setEstateUse(String estateUse) {
		this.estateUse = estateUse;
	}

	public BigDecimal getEstateArea() {
		return estateArea;
	}

	public void setEstateArea(BigDecimal estateArea) {
		this.estateArea = estateArea;
	}

	public String getEstateName() {
		return estateName;
	}

	public void setEstateName(String estateName) {
		this.estateName = estateName;
	}

	public DeedTypeEnum getDeedType() {
		return deedType;
	}

	public void setDeedType(DeedTypeEnum deedType) {
		this.deedType = deedType;
	}

	public String getDeedNum() {
		return deedNum;
	}

	public void setDeedNum(String deedNum) {
		this.deedNum = deedNum;
	}

	public BigDecimal getEvaluatePrice() {
		return evaluatePrice;
	}

	public void setEvaluatePrice(BigDecimal evaluatePrice) {
		this.evaluatePrice = evaluatePrice;
	}

	public String getSourceContactName() {
		return sourceContactName;
	}

	public void setSourceContactName(String sourceContactName) {
		this.sourceContactName = sourceContactName;
	}

	public String getSourceContactTele() {
		return sourceContactTele;
	}

	public void setSourceContactTele(String sourceContactTele) {
		this.sourceContactTele = sourceContactTele;
	}
}
