package yhao.micro.service.surety.erp.auth.apilist.enums;


import yhao.infra.apilist.JsonReturnCodeEnum;

/**
 * Created by yoara on 2017/9/5.
 */
public enum ErpReturnCodeEnum implements JsonReturnCodeEnum {
    F1000("用户名或密码有误"),
    F1001("旧密码不正确");
    private String msg;

    ErpReturnCodeEnum(String msg){
        this.msg = msg;
    }

    @Override
    public String getMessage() {
        return msg;
    }

    @Override
    public String getStatus() {
        return name();
    }
}
