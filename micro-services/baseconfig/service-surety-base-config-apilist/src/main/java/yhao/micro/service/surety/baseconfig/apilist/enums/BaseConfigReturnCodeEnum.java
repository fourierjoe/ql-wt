package yhao.micro.service.surety.baseconfig.apilist.enums;

import yhao.infra.apilist.JsonReturnCodeEnum;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2019-01-28
 * Time: 9:38
 */
public enum BaseConfigReturnCodeEnum implements JsonReturnCodeEnum {
    F2000("银行名称重复，请修改银行名称"),
    F2001("请先删除当前银行下级银行");

    private String msg;

    BaseConfigReturnCodeEnum(String msg) {
        this.msg = msg;
    }

    @Override
    public String getMessage() {
        return msg;
    }

    @Override
    public String getStatus() {
        return null;
    }
}
