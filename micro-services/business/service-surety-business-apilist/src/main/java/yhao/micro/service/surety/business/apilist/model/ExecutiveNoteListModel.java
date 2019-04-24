package yhao.micro.service.surety.business.apilist.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description 执行岗备注列表model
 *
 * @Author leice
 * @Date 2018/12/8 14:25
 * @Version 1.0
 */
public class ExecutiveNoteListModel extends Entity<String> {

    @ApiModelProperty("备注id")
    private String remarkId;

    @ApiModelProperty("资料情况")
    private String informationSituation;

    @ApiModelProperty("备注")
    private String remarks;

    @ApiModelProperty("备注时间 yyyy-MM-dd")
    private String remarkTime;

    public String getRemarkId() {
        return remarkId;
    }

    public void setRemarkId(String remarkId) {
        this.remarkId = remarkId;
    }

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

    @Override
    public String toString() {
        return "ExecutiveNoteListModel{" +
                "remarkId='" + remarkId + '\'' +
                ", informationSituation='" + informationSituation + '\'' +
                ", remarks='" + remarks + '\'' +
                ", remarkTime=" + remarkTime +
                '}';
    }
}
