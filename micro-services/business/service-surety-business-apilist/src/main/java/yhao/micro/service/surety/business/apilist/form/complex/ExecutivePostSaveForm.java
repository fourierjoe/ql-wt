package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
import yhao.infra.apilist.validate.IdUnForm;

import java.text.ParseException;
import java.util.Date;

/**
 * @Description 执行岗备注新增
 *
 * @Author leice
 * @Date 2018/12/8 18:18
 * @Version 1.0
 */
public class ExecutivePostSaveForm extends IdUnForm {

    @ApiModelProperty("资料情况")
    private String informationSituation;

    @ApiModelProperty("备注")
    private String remarks;

    @ApiModelProperty("备注时间 yyyy-MM-dd ")
    private String remarkTime;

    @ApiModelProperty("保单id")
    private String guaranteeId;

    public String getInformationSituation() {
        return informationSituation;
    }

    public void setInformationSituation(String informationSituation) {
        this.informationSituation = informationSituation;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarkTime() {
        return remarkTime;
    }

    public void setRemarkTime(String remarkTime) {
        this.remarkTime = remarkTime;
    }

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    @Override
    public String toString() {
        return "ExecutivePostSaveForm{" +
                "informationSituation='" + informationSituation + '\'' +
                ", remarks='" + remarks + '\'' +
                ", remarkTime=" + remarkTime +
                ", guaranteeId=" + guaranteeId +
                '}';
    }

}
