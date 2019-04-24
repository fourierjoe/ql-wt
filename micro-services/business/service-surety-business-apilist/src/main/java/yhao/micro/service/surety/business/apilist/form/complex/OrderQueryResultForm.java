package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.micro.service.surety.business.apilist.model.guarantee.page.GuaranteePageModel;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/10 14:41
 * @Description:
 */
public class OrderQueryResultForm extends GuaranteePageModel {
    @ApiModelProperty("指令状态 YES 已发送 NO 未发送")
    private String status;
    @ApiModelProperty("发送次数")
    private Integer num;
    @ApiModelProperty("有效期")
    private String dayCount;
    @ApiModelProperty("有效期类型 WORK_DAY=工作日，NATURAL_DAY=自然日，PERMANENT=长期有效")
    private String validityType;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getDayCount() {
        return dayCount;
    }

    public void setDayCount(String dayCount) {
        this.dayCount = dayCount;
    }

    public String getValidityType() {
        return validityType;
    }

    public void setValidityType(String validityType) {
        this.validityType = validityType;
    }
}
