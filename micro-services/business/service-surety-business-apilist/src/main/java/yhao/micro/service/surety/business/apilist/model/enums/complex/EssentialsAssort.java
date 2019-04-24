package yhao.micro.service.surety.business.apilist.model.enums.complex;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/7 11:04
 * @Description:要件类型
 */
public enum EssentialsAssort {
    PERSON("个人"),COMPANY("公司");

    EssentialsAssort(String desc) {
        this.desc = desc;
    }

    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
