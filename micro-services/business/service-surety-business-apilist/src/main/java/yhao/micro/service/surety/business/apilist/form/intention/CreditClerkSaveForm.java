package yhao.micro.service.surety.business.apilist.form.intention;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;
import yhao.infra.apilist.validate.IdForm;
import yhao.micro.service.constants.enums.YNEnum;
import yhao.micro.service.surety.business.apilist.model.enums.intention.CreditAndRepayScheduleEnum;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class CreditClerkSaveForm extends IdForm {

    @ApiModelProperty(value = "征信是否报送", required = true)
    @NotNull(message = "征信是否报送不得为空")
    private YNEnum isCreditReport;

    @ApiModelProperty(value = "征信办理状态,是否确认办结按钮", required = true)
    private CreditAndRepayScheduleEnum creditState = CreditAndRepayScheduleEnum.NO_DEAL;

    @ApiModelProperty(value = "征信确认办结日期(征信table页面实际办理日期)", hidden = true)
    private Date creditEndDate;

    @ApiModelProperty(value = "买卖双方征信查询结果信息", required = true)
    @Valid
    @NotEmpty(message = "买卖双方征信查询结果信息不得为空")
    private List<CreditResultSaveForm> creditList;

    public Date getCreditEndDate() {
        return creditEndDate;
    }

    public void setCreditEndDate(Date creditEndDate) {
        this.creditEndDate = creditEndDate;
    }

    public YNEnum getIsCreditReport() {
        return isCreditReport;
    }

    public void setIsCreditReport(YNEnum isCreditReport) {
        this.isCreditReport = isCreditReport;
    }

    public List<CreditResultSaveForm> getCreditList() {
        return creditList;
    }

    public void setCreditList(List<CreditResultSaveForm> creditList) {
        this.creditList = creditList;
    }

    public CreditAndRepayScheduleEnum getCreditState() {
        return creditState;
    }

    public void setCreditState(CreditAndRepayScheduleEnum creditState) {
        this.creditState = creditState;
    }
}
