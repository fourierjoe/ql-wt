package yhao.micro.service.surety.business.apilist.model.twiceRepay;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
import yhao.infra.common.model.Entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description:
 * @Created by ql on 2019/2/20 14:56
 * @Version: v1.0
 */
public class TwiceRepayHistoryModel extends Entity<String> {
	@ApiModelProperty(value = "第一次到账")
	private BigDecimal firstArrival;

	@ApiModelProperty(value = "第二次到账")
	private BigDecimal secondArrival;

	@ApiModelProperty(value = "合计到账 = 第一次到账+第二次到账")
	private BigDecimal totalArrival;

	@ApiModelProperty(value = "第一次赎楼合计")
	private BigDecimal firstRedeem;

	@ApiModelProperty(value = "第二次赎楼合计 = 第二次实际还贷本金+第二次利息+第二次罚息")
	private BigDecimal secondRedeem;

	@ApiModelProperty(value = "赎楼合计 = 第一次赎楼合计+第二次赎楼合计")
	private BigDecimal totalRedeem;

	@ApiModelProperty(value = "第一次退余款 = 第一次到账-第一次赎楼合计")
	private BigDecimal firstBalance;

	@ApiModelProperty(value = "第二次退余款 = 第二次到账-第二次赎楼合计")
	private BigDecimal secondBalance;

	@ApiModelProperty(value = "合计退余款 = 第一次退余款+第二次退余款")
	private BigDecimal totalBalance;

	@ApiModelProperty(value = "第二次实际还贷本金", hidden = true)
	private BigDecimal twiceRealRepaymentFund;

	@ApiModelProperty(value = "第二次利息", hidden = true)
	private BigDecimal twiceInterest;

	@ApiModelProperty(value = "第二次罚息", hidden = true)
	private BigDecimal twicePenaltyInterest;

	/***********************************操作记录*************************************************/
	@ApiModelProperty(value = "操作名称")
	private String operateName;

	@ApiModelProperty(value = "操作人id")
	private String operatorId;

	@ApiModelProperty(value = "操作人姓名")
	private String operatorName;

	@ApiModelProperty(value = "操作状态")
	private String operateState;

	@ApiModelProperty(value = "操作时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date operateDate;

	@ApiModelProperty(value = "操作内容")
	private String operateContent;

	public BigDecimal getFirstArrival() {
		return firstArrival;
	}

	public void setFirstArrival(BigDecimal firstArrival) {
		this.firstArrival = firstArrival;
	}

	public BigDecimal getSecondArrival() {
		return secondArrival;
	}

	public void setSecondArrival(BigDecimal secondArrival) {
		this.secondArrival = secondArrival;
	}

	public BigDecimal getTotalArrival() {
		return totalArrival;
	}

	public void setTotalArrival(BigDecimal totalArrival) {
		BigDecimal bigDecimal = new BigDecimal(0);
		this.totalArrival = bigDecimal.add(firstArrival).add(secondArrival);
	}

	public BigDecimal getFirstRedeem() {
		return firstRedeem;
	}

	public void setFirstRedeem(BigDecimal firstRedeem) {
		this.firstRedeem = firstRedeem;
	}

	public BigDecimal getSecondRedeem() {
		return secondRedeem;
	}

	public void setSecondRedeem(BigDecimal secondRedeem) {
		BigDecimal bigDecimal = new BigDecimal(0);
		this.secondRedeem = bigDecimal.add(twiceRealRepaymentFund).add(twiceInterest).add(twicePenaltyInterest);
	}

	public BigDecimal getTotalRedeem() {
		return totalRedeem;
	}

	public void setTotalRedeem(BigDecimal totalRedeem) {
		BigDecimal bigDecimal = new BigDecimal(0);
		this.totalRedeem = bigDecimal.add(firstRedeem).add(secondRedeem);
	}

	public BigDecimal getFirstBalance() {
		return firstBalance;
	}

	public void setFirstBalance(BigDecimal firstBalance) {
		BigDecimal bigDecimal = new BigDecimal(0);
		this.firstBalance = bigDecimal.add(firstArrival).subtract(firstRedeem);
	}

	public BigDecimal getSecondBalance() {
		return secondBalance;
	}

	public void setSecondBalance(BigDecimal secondBalance) {
		BigDecimal bigDecimal = new BigDecimal(0);
		this.secondBalance = bigDecimal.add(secondArrival).subtract(secondRedeem);
	}

	public BigDecimal getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(BigDecimal totalBalance) {
		BigDecimal bigDecimal = new BigDecimal(0);
		this.totalBalance = bigDecimal.add(firstBalance).add(secondBalance);
	}

	public String getOperateName() {
		return operateName;
	}

	public void setOperateName(String operateName) {
		this.operateName = operateName;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getOperateState() {
		return operateState;
	}

	public void setOperateState(String operateState) {
		this.operateState = operateState;
	}

	public Date getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}

	public String getOperateContent() {
		return operateContent;
	}

	public void setOperateContent(String operateContent) {
		this.operateContent = operateContent;
	}

	public BigDecimal getTwiceRealRepaymentFund() {
		return twiceRealRepaymentFund;
	}

	public void setTwiceRealRepaymentFund(BigDecimal twiceRealRepaymentFund) {
		this.twiceRealRepaymentFund = twiceRealRepaymentFund;
	}

	public BigDecimal getTwiceInterest() {
		return twiceInterest;
	}

	public void setTwiceInterest(BigDecimal twiceInterest) {
		this.twiceInterest = twiceInterest;
	}

	public BigDecimal getTwicePenaltyInterest() {
		return twicePenaltyInterest;
	}

	public void setTwicePenaltyInterest(BigDecimal twicePenaltyInterest) {
		this.twicePenaltyInterest = twicePenaltyInterest;
	}
}
