package yhao.micro.service.surety.business.apilist.model.guarantee;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

/**
 * @Description:
 * @Created by ql on 2019/2/28 10:05
 * @Version: v1.0
 */
public class AssociateGuaranteeModel extends Entity<String> {
	@ApiModelProperty(value = "单据号")
	private String guaranteeNum;

	@ApiModelProperty(value = "用户类型")
	private String cltTyp;

	@ApiModelProperty(value = "姓名")
	private String cltName;

	@ApiModelProperty(value = "房产名称")
	private String estateName;

	public String getGuaranteeNum() {
		return guaranteeNum;
	}

	public void setGuaranteeNum(String guaranteeNum) {
		this.guaranteeNum = guaranteeNum;
	}

	public String getCltTyp() {
		return cltTyp;
	}

	public void setCltTyp(String cltTyp) {
		this.cltTyp = cltTyp;
	}

	public String getCltName() {
		return cltName;
	}

	public void setCltName(String cltName) {
		this.cltName = cltName;
	}

	public String getEstateName() {
		return estateName;
	}

	public void setEstateName(String estateName) {
		this.estateName = estateName;
	}
}
