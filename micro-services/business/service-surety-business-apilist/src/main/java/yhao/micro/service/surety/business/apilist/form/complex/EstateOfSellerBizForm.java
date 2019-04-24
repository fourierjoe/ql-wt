package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;

import java.util.List;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/24 11:33
 * @Description:
 */
public class EstateOfSellerBizForm implements ValidationForm {
    @ApiModelProperty("物业名称")
    private String name;
    @ApiModelProperty("业主名称")
    private List<EstateOfSellerInfo> baseInfoList;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EstateOfSellerInfo> getBaseInfoList() {
        return baseInfoList;
    }

    public void setBaseInfoList(List<EstateOfSellerInfo> baseInfoList) {
        this.baseInfoList = baseInfoList;
    }
}
