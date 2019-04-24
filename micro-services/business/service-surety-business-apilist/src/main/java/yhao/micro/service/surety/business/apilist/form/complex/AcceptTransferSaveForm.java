package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

/**
 * @Description 接受/转交担保单给审查员form
 *
 * @Author leice
 * @Date 2018/12/8 18:57
 * @Version 1.0
 */
public class AcceptTransferSaveForm extends Entity<String> {

    @ApiModelProperty("担保单id")
    private String warrantyId;

    @ApiModelProperty("登录用户id")
    private String userId;

    public String getWarrantyId() {
        return warrantyId;
    }

    public void setWarrantyId(String warrantyId) {
        this.warrantyId = warrantyId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "AcceptTransferSaveForm{" +
                "warrantyId='" + warrantyId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
