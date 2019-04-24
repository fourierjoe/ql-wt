package yhao.micro.service.surety.business.apilist.model.enums.finance;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/11 19:19
 * @Description:
 */
public enum FundTypeEnum {
    OWN_FUND("自有资金"),PLATFORM_FUND ("平台资金");

    FundTypeEnum(String desc) {
        this.desc = desc;
    }

    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public static void main(String[] args){
        System.out.println(""+FundTypeEnum.OWN_FUND.name());
    	System.out.println(FundTypeEnum.OWN_FUND.toString().equals(FundTypeEnum.OWN_FUND.name()));
    }
}
