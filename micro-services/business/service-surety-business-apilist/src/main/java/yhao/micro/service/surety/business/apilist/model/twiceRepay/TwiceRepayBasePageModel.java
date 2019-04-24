package yhao.micro.service.surety.business.apilist.model.twiceRepay;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.surety.business.apilist.model.guarantee.page.ApplicationPersonModel;
import yhao.micro.service.surety.business.apilist.model.guarantee.page.EstatePageModel;

import java.util.List;

/**
 * @Description: 二次还款Model
 *
 * @Auther: ql
 * @Date: 2018/12/8 17:53
 */
public class TwiceRepayBasePageModel extends Entity<String> {

    @ApiModelProperty("担保单Id")
    private String guaranteeId;

    @ApiModelProperty("单据编号")
    private String guaranteeNum;

    @ApiModelProperty("担保单关联单ID")
    private String kguaranteeId;

    @ApiModelProperty("单据类型")
    private String guaranteeType;

    @ApiModelProperty("业务类型名称")
    private String businessName;

    @ApiModelProperty("房产名称")
    private List<EstatePageModel> estatePageModelList;

    @ApiModelProperty(value = "买卖方姓名")
    private List<ApplicationPersonModel> applicationPersonModelList;

    @ApiModelProperty(value = "二次还款状态", hidden = true)
    private int twiceRepayState;

    public String getKguaranteeId() {
        return kguaranteeId;
    }

    public void setKguaranteeId(String kguaranteeId) {
        this.kguaranteeId = kguaranteeId;
    }

    public String getGuaranteeNum() {
        return guaranteeNum;
    }

    public void setGuaranteeNum(String guaranteeNum) {
        this.guaranteeNum = guaranteeNum;
    }

    public String getGuaranteeType() {
        return guaranteeType;
    }

    public void setGuaranteeType(String guaranteeType) {
        this.guaranteeType = guaranteeType;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public List<EstatePageModel> getEstatePageModelList() {
        return estatePageModelList;
    }

    public void setEstatePageModelList(List<EstatePageModel> estatePageModelList) {
        this.estatePageModelList = estatePageModelList;
    }

    public List<ApplicationPersonModel> getApplicationPersonModelList() {
        return applicationPersonModelList;
    }

    public void setApplicationPersonModelList(List<ApplicationPersonModel> applicationPersonModelList) {
        this.applicationPersonModelList = applicationPersonModelList;
    }

    public int getTwiceRepayState() {
        return twiceRepayState;
    }

    public void setTwiceRepayState(int twiceRepayState) {
        this.twiceRepayState = twiceRepayState;
    }

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }
}
