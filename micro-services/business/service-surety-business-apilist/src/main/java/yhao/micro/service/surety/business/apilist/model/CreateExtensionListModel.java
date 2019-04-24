package yhao.micro.service.surety.business.apilist.model;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

import java.io.Serializable;
import java.util.List;

/**
 * @Description
 * @Author leice
 * @Date 2019/2/27 15:55
 * @Version 1.0
 */
public class CreateExtensionListModel extends Entity<String> {

    @ApiModelProperty("担保单id")
    private String guaranteeId;

    @ApiModelProperty("业务编号")
    private String guaranteeNum;

    @ApiModelProperty("应交担保费")
    private Double shouldGuaranteePay;

    @ApiModelProperty("业务类型")
    private String businessType;

    @ApiModelProperty("物业")
    private List<PropertyModel> propertys;

    @ApiModelProperty("卖方")
    private List<OwnerModel> sellers;

    @ApiModelProperty("买方")
    private List<BuyModel> buyers;

    @ApiModelProperty("借款详细数据")
    private List<ExtensionLoans> extensionLoans;

    public Double getShouldGuaranteePay() {
        return shouldGuaranteePay;
    }

    public void setShouldGuaranteePay(Double shouldGuaranteePay) {
        this.shouldGuaranteePay = shouldGuaranteePay;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public String getGuaranteeNum() {
        return guaranteeNum;
    }

    public void setGuaranteeNum(String guaranteeNum) {
        this.guaranteeNum = guaranteeNum;
    }

    public List<PropertyModel> getPropertys() {
        return propertys;
    }

    public void setPropertys(List<PropertyModel> propertys) {
        this.propertys = propertys;
    }

    public List<OwnerModel> getSellers() {
        return sellers;
    }

    public void setSellers(List<OwnerModel> sellers) {
        this.sellers = sellers;
    }

    public List<BuyModel> getBuyers() {
        return buyers;
    }

    public void setBuyers(List<BuyModel> buyers) {
        this.buyers = buyers;
    }

    public List<ExtensionLoans> getExtensionLoans() {
        return extensionLoans;
    }

    public void setExtensionLoans(List<ExtensionLoans> extensionLoans) {
        this.extensionLoans = extensionLoans;
    }
}
