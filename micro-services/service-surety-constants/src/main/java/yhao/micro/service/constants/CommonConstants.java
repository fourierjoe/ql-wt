package yhao.micro.service.constants;

public class CommonConstants {
    /*系统标识*/
    public static final String SYSTEM_KEY = "SURETY";
    /*系统中文名*/
    public static final String SYSTEM_NAME = "万通担保系统";
    /*系统数据权限类型*/
    public static final String SYSTEM_DATA_TYPE = "SURETY";
    /*短信平台系统标识*/
    public static final String SMS_SYSTEM_KEY = "SURETY";
    /*短信平台模板标识*/
    public static final String SMS_TEMPLATE_KEY = "SURETY_TEMPLATE_01";
    /*是*/
    public final static String YES = "YES";
    /*否*/
    public final static String NO = "NO";

    /*岗位类型 开始*/
    public static final String POSITION_TYPE_FOLLOWER = "FOLLOWER";//跟单员
    public static final String POSITION_TYPE_DECLARER = "DECLARER";//报单员
    public static final String POSITION_TYPE_CREDIT_CLERK = "CREDIT_CLERK";//征信专员
    public static final String POSITION_TYPE_MANAGER = "MANAGER";//客户经理
    public static final String POSITION_TYPE_OBTAINER = "OBTAINER";//取证专员
    public static final String POSITION_TYPE_FORECLOSER = "FORECLOSER";//赎楼员
    public static final String POSITION_TYPE_RESIDENT = "RESIDENT";//驻点专员
    public static final String POSITION_TYPE_EXAMINER = "EXAMINER";//审查员
    /*岗位类型 结束*/

    //子流程事项默认事项配置
    public static final String PASS = "R998";
    public static final String REFUSED = "R999";

    public static final String R998 = "通过";
    public static final String R999 = "驳回";

    public static final String SUB_PROCESS_ITEM_CONFIG = "{\"R998\":\"通过\",\"R999\":\"驳回\"}";
}
