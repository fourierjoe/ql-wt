package yhao.micro.service.surety.business.apilist.model.enums.complex;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/8 15:03
 * @Description:查档状态
 */
public enum BilingCaseSituationStatus {
    PAWN("抵押"),SEAL("查封"),
    ENABLE("有效"), DISABLE("无效"),
    PAWN_SEAL("抵押查封"), WAITING_SEAL("轮候查封");

    BilingCaseSituationStatus(String desc) {
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
