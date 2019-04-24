package yhao.micro.service.workflow.apilist.enums.flow;

/**
 * @Description:
 * @Created by ql on 2019/1/12 13:13
 * @Version: v1.0
 */
public enum ProcessType {
	MAIN("主流程"),
	SUB("子流程"),
	;
	private String desc;
	ProcessType(String desc) {
		this.desc = desc;
	}
}
