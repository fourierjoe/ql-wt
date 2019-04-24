package yhao.micro.web.surety.enums;


import yhao.infra.apilist.JsonReturnCodeEnum;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2018-12-14
 * Time: 14:31
 */
public enum WebReturnCodeEnum implements JsonReturnCodeEnum {
    F1000("文件上传失败"),
    F1001("文件下载失败");

    private String msg;

    WebReturnCodeEnum(String msg) {
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
