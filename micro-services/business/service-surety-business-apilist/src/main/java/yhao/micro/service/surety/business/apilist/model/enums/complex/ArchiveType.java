package yhao.micro.service.surety.business.apilist.model.enums.complex;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/8 12:01
 * @Description:归档类型
 */
public enum ArchiveType {
    FIRST_GEAR("第一次归档"),SECOND_GEAR("第二次归档"),
    THIRD_GEAR("第三次归档");

    ArchiveType(String desc) {
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
