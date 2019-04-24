package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;
import yhao.micro.service.surety.business.apilist.model.enums.complex.BilingCaseSituationStatus;

import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/26 15:49
 * @Description:
 */
public class BillingCheckDetailForm implements ValidationForm {
    @ApiModelProperty("查档时间")
    private Date checkFileDate;
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("状态")
    private BilingCaseSituationStatus status;
    @ApiModelProperty(value = "产证类型")
    private String deedType;
    @ApiModelProperty(value = "产证编号")
    private String deedNum;
    @ApiModelProperty(value = "身份证号码")
    private String personInfo;
}
