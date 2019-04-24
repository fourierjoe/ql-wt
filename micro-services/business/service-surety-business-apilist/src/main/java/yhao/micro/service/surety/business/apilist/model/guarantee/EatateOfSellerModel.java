package yhao.micro.service.surety.business.apilist.model.guarantee;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

import java.util.List;

/**
 * @Description:
 * @Created by ql on 2018/12/10 20:07
 * @Version: v1.0
 */
public class EatateOfSellerModel extends Entity<String> {

    @ApiModelProperty(value = "物业名称")
    private String propertyName;

    @ApiModelProperty("坐落")
    private String propertyLocation;

    @ApiModelProperty("房号")
    private String propertyRoomNo;

    @ApiModelProperty("是否有建模物业")
    private String isModeling;

    @ApiModelProperty("用途")
    private String estateUse;

    @ApiModelProperty("面积")
    private String estateArea;

    @ApiModelProperty("房产名称")
    private String estateName;

    @ApiModelProperty("产证类型")
    private String deedType;

    @ApiModelProperty("产证编号")
    private String deedNum;

    @ApiModelProperty("业主基本信息")
    private List<BuyerAndSellerBaseInfoModel> sellerBaseInfoList;

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyLocation() {
        return propertyLocation;
    }

    public void setPropertyLocation(String propertyLocation) {
        this.propertyLocation = propertyLocation;
    }

    public String getPropertyRoomNo() {
        return propertyRoomNo;
    }

    public void setPropertyRoomNo(String propertyRoomNo) {
        this.propertyRoomNo = propertyRoomNo;
    }

    public String getIsModeling() {
        return isModeling;
    }

    public void setIsModeling(String isModeling) {
        this.isModeling = isModeling;
    }

    public String getEstateUse() {
        return estateUse;
    }

    public void setEstateUse(String estateUse) {
        this.estateUse = estateUse;
    }

    public String getEstateArea() {
        return estateArea;
    }

    public void setEstateArea(String estateArea) {
        this.estateArea = estateArea;
    }

    public String getEstateName() {
        return estateName;
    }

    public void setEstateName(String estateName) {
        this.estateName = estateName;
    }

    public String getDeedType() {
        return deedType;
    }

    public void setDeedType(String deedType) {
        this.deedType = deedType;
    }

    public String getDeedNum() {
        return deedNum;
    }

    public void setDeedNum(String deedNum) {
        this.deedNum = deedNum;
    }

    public List<BuyerAndSellerBaseInfoModel> getSellerBaseInfoList() {
        return sellerBaseInfoList;
    }

    public void setSellerBaseInfoList(List<BuyerAndSellerBaseInfoModel> sellerBaseInfoList) {
        this.sellerBaseInfoList = sellerBaseInfoList;
    }
}
