package yhao.micro.service.surety.business.apilist.form.finance;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
import yhao.micro.service.surety.business.apilist.model.enums.finance.FundTypeEnum;
import yhao.micro.service.surety.business.apilist.model.enums.finance.PlanStatusEnum;

import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/11 17:38
 * @Description:
 */
public class FundPlanQueryForm extends FinanceBaseQueryForm{
    @ApiModelProperty("安排进度")
    private PlanStatusEnum status;
    @ApiModelProperty("资金类型")
    private FundTypeEnum fundType;
    @ApiModelProperty("预计用款开始日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date planFundStartDate;
    @ApiModelProperty("预计用款结束日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date planFundEndDate;
    @ApiModelProperty("平台资金id 当选择平台资金时，必填")
    private String platformId;

    public PlanStatusEnum getStatus() {
        return status;
    }

    public void setStatus(PlanStatusEnum status) {
        this.status = status;
    }

    public FundTypeEnum getFundType() {
        return fundType;
    }

    public void setFundType(FundTypeEnum fundType) {
        this.fundType = fundType;
    }

    public Date getPlanFundStartDate() {
        return planFundStartDate;
    }

    public void setPlanFundStartDate(Date planFundStartDate) {
        this.planFundStartDate = planFundStartDate;
    }

    public Date getPlanFundEndDate() {
        return planFundEndDate;
    }

    public void setPlanFundEndDate(Date planFundEndDate) {

        this.planFundEndDate = planFundEndDate;
    }


    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }
}
