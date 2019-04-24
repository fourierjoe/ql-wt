package yhao.micro.service.surety.business.apilist.model.guarantee;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.surety.business.apilist.model.guarantee.output.PersonInfoTradesModel;

import java.util.List;

/**
 * @Description:
 * @Created by ql on 2019/1/14 10:27
 * @Version: v1.0
 */
public class MainContractNumModel extends Entity<String> {
	@ApiModelProperty(value = "担保单编号")
	private String guaranteeNum;

	@ApiModelProperty(value = "客户经理姓名")
	private String managerName;

	@ApiModelProperty(value = "客户经理组织")
	private String orgName;

	@ApiModelProperty(value = "业主个人信息")
	private List<PersonInfoTradesModel> personInfoTradesModelList;

	public String getGuaranteeNum() {
		return guaranteeNum;
	}

	public void setGuaranteeNum(String guaranteeNum) {
		this.guaranteeNum = guaranteeNum;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public List<PersonInfoTradesModel> getPersonInfoTradesModelList() {
		return personInfoTradesModelList;
	}

	public void setPersonInfoTradesModelList(List<PersonInfoTradesModel> personInfoTradesModelList) {
		this.personInfoTradesModelList = personInfoTradesModelList;
	}
}
