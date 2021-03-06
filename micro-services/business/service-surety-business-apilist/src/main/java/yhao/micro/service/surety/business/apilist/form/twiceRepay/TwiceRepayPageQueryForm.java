package yhao.micro.service.surety.business.apilist.form.twiceRepay;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import yhao.infra.apilist.validate.PageForm;
import yhao.micro.service.constants.enums.YNEnum;
import yhao.micro.service.surety.business.apilist.model.enums.twiceRepay.TwiceRepayDateTypeEnum;

import java.util.Date;

/**
 * @Description:
 * @Created by ql on 2019/2/20 09:07
 * @Version: v1.0
 */
public class TwiceRepayPageQueryForm extends PageForm {
	@ApiModelProperty(value = "城市组织ID", required = true)
	@NotBlank(message = "城市组织ID不得为空")
	private String orgId;

	@ApiModelProperty(value = "客户经理Id")
	private String managerId;

	@ApiModelProperty(value = "业务类型Id")
	private String bizTypeId;

	// 单据号,物业,买卖双方,房产证号
	@ApiModelProperty(value = "单据号,物业,买卖双方,房产证号")
	private String mix;

	@ApiModelProperty(value = "日期类型")
	private TwiceRepayDateTypeEnum twiceRepayDateType;

	@ApiModelProperty(value = "日期类型所在表", hidden = true)
	private String twiceRepayDateTable;

	@ApiModelProperty(value = "日期类型对应字段", hidden = true)
	private String twiceRepayDateColumn;

	@ApiModelProperty(value = "开始日期")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;

	@ApiModelProperty(value = "结束日期")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;

	@ApiModelProperty(value = "余款状态, 无余款,未确认,已确认")
	private YNEnum balanceState;

	@ApiModelProperty(value = "客户经理发起状态/要件员确认状态/二次到账状态/还款状态")
	private YNEnum state;

	@ApiModelProperty(value = "客户经理发起状态/要件员确认状态/二次到账状态/还款状态", hidden = true)
	private int stateInt;

	public int getStateInt() {
		return stateInt;
	}

	public void setStateInt(int stateInt) {
		this.stateInt = stateInt;
	}

	public YNEnum getState() {
		return state;
	}

	public void setState(YNEnum state) {
		this.state = state;
	}

	public String getTwiceRepayDateTable() {
		return twiceRepayDateTable;
	}

	public void setTwiceRepayDateTable(String twiceRepayDateTable) {
		if (twiceRepayDateType != null) {
			this.twiceRepayDateTable = twiceRepayDateType.toString().split("999")[0];
		}
	}

	public String getTwiceRepayDateColumn() {
		return twiceRepayDateColumn;
	}

	public void setTwiceRepayDateColumn(String twiceRepayDateColumn) {
		if (twiceRepayDateType != null) {
			this.twiceRepayDateColumn = twiceRepayDateType.toString().split("999")[1];
		}
	}

	public String getMix() {
		return mix;
	}

	public void setMix(String mix) {
		this.mix = mix;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getBizTypeId() {
		return bizTypeId;
	}

	public void setBizTypeId(String bizTypeId) {
		this.bizTypeId = bizTypeId;
	}

	public TwiceRepayDateTypeEnum getTwiceRepayDateType() {
		return twiceRepayDateType;
	}

	public void setTwiceRepayDateType(TwiceRepayDateTypeEnum twiceRepayDateType) {
		this.twiceRepayDateType = twiceRepayDateType;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
