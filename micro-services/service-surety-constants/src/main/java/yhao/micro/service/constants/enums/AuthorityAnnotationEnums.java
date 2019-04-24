package yhao.micro.service.constants.enums;

/**
 * Created by yoara on 2016/4/25.
 * 权限注解，所有权限在此处定义
 */
public enum AuthorityAnnotationEnums {
    /*菜单管理 开始*/
    AUTH_TYPE_SELECT("主界面"),
    AUTH_TYPE_ADD("菜单新增"),
    AUTH_TYPE_EDIT("菜单修改"),
    AUTH_TYPE_DELETE("菜单删除"),
    AUTH_SELECT("功能查询"),
    AUTH_ADD("功能新增"),
    AUTH_EDIT("功能修改"),
    AUTH_DELETE("功能删除"),
    /*菜单管理 结束*/

    /*岗位管理 开始*/
    AUTH_POSITION_SELECT("主界面"),
    AUTH_POSITION_AUTH_TYPE_CONFIG("菜单设置"),
    /*岗位管理 结束*/

    /*数据授权 开始*/
    AUTH_POSITION_DATA_SELECT("主界面"),
    AUTH_POSITION_DATA_CONFIG("数据授权"),
    /*数据授权 结束*/

    /*账号管理 开始*/
    AUTH_PERSON_SELECT("主界面"),
    AUTH_PERSON_CHANGE_STATUS("账号启用/禁用"),
    AUTH_PERSON_AUTH_TYPE_CONFIG("菜单设置"),
    AUTH_PERSON_DATA_CONFIG("数据授权"),
    /*账号管理 结束*/

    /*资金方案管理 开始*/
    FUND_RULE_SELECT("主界面"),
    FUND_RULE_ADD("资金方案新增"),
    FUND_RULE_DELETE("资金方案删除"),
    FUND_RULE_EDIT("资金方案修改"),
    FUND_RULE_CHANGE_STATUS("资金方案启用/禁用"),
    /*资金方案管理 结束*/

    /*资金账号管理 开始*/
    FUND_ACCOUNT_SELECT("主界面"),
    FUND_ACCOUNT_ADD("资金账号新增"),
    FUND_ACCOUNT_DELETE("资金账号删除"),
    FUND_ACCOUNT_EDIT("资金账号修改"),
    FUND_ACCOUNT_CHANGE_STATUS("资金账号启用/禁用"),
    /*资金账号管理 结束*/

    /*单据分配设置 开始*/
    INTENTION_ASSIGN_SELECT("主界面"),
    INTENTION_ASSIGN_ADD("单据分配新增"),
    INTENTION_ASSIGN_DELETE("单据分配删除"),
    INTENTION_ASSIGN_EDIT("单据分配修改"),
    INTENTION_ASSIGN_CHANGE_STATUS("单据分配启用/禁用"),
    /*单据分配设置 结束*/

    /*资方管理 开始*/
    FUND_PROVIDER_HEAD_SELECT("总行主界面"),
    FUND_PROVIDER_HEAD_ADD("总行新增"),
    FUND_PROVIDER_HEAD_DELETE("总行删除"),
    FUND_PROVIDER_HEAD_EDIT("总行修改"),
    FUND_PROVIDER_HEAD_CHANGE_STATUS("总行启用/禁用"),
    FUND_PROVIDER_BRANCH_SELECT("分行主界面"),
    FUND_PROVIDER_BRANCH_ADD("分行新增"),
    FUND_PROVIDER_BRANCH_DELETE("分行删除"),
    FUND_PROVIDER_BRANCH_EDIT("分行修改"),
    FUND_PROVIDER_BRANCH_CHANGE_STATUS("分行启用/禁用"),
    /*资方管理 结束*/

    /*合作方管理 开始*/
    PARTNERS_SELECT("主界面"),
    PARTNERS_ADD("合作方新增"),
    PARTNERS_DELETE("合作方删除"),
    PARTNERS_EDIT("合作方修改"),
    PARTNERS_CHANGE_STATUS("合作方启用/禁用"),
    /*合作方管理 结束*/

    /*指令设置 开始*/
    COMMAND_SELECT("主界面"),
    COMMAND_ADD("指令新增"),
    COMMAND_DELETE("指令删除"),
    COMMAND_EDIT("指令修改"),
    COMMAND_CHANGE_STATUS("指令启用/禁用"),
    /*指令设置 结束*/

    /*资料设置 开始*/
    MATERIAL_SELECT("主界面"),
    MATERIAL_ADD("资料新增"),
    MATERIAL_DELETE("资料删除"),
    MATERIAL_EDIT("资料修改"),
    MATERIAL_CHANGE_STATUS("资料启用/禁用"),
    /*资料设置 结束*/

    /*仓库设置 开始*/
    REPOSITORY_SELECT("主界面"),
    REPOSITORY_ADD("仓库新增"),
    REPOSITORY_DELETE("仓库删除"),
    REPOSITORY_EDIT("仓库修改"),
    /*仓库设置 结束*/

    /*流程配置 开始*/
    PROCESS_SELECT("流程配置查询"),
    PROCESS_ADD_EDIT("流程配置新增/编辑"),
    /*流程配置 结束*/

    /*流程审批 开始*/
    APPROVE_SELECT("流程审批查询"),
    APPROVE_DEAL("流程审批办理"),
    /*流程审批 结束*/

    /*节点管理 开始*/
    NODE_SELECT("节点管理查询"),
    NODE_ADD_EDIT("节点管理添加/编辑"),
    NODE_DELETE("节点管理删除"),
    /*节点管理 结束*/

    /*事项管理 开始*/
    ITEM_SELECT("事项管理查询"),
    ITEM_ADD_EDIT("事项管理添加/编辑"),
    ITEM_DELETE("事项管理删除"),
    /*事项管理 结束*/


    /*审查员审查 开始*/
    REVIEW_SELECT("审查信息分页查询"),
    REVIEW_ADD("审查担保单"),
    REVIEW_RECEIVE("审查员接收"),
    REVIEW_TRANSFER("审查员转交"),
    REFUSE_REVIEW_ADD("审查驳回"),
    /*审查员审查 结束*/

    /*执行岗备注 开始*/
    EXECUTIVENOTE_SELECT("执行岗备注分页查询"),
    EXECUTIVENOTE_ADD("执行岗备注添加"),
    EXECUTIVENOTE_SELECT_HISTORY("执行岗备注历史查询"),
    /*执行岗备注 结束*/

    /*展期申请 开始*/
    EXTENSION_SELECT("展期申请分页查询"),
    EXTENSION_ADD("展期申请添加"),
    EXTENSION_UPDATE("展期申请编辑"),
    EXTENSION_LOOK("展期申请查看"),
    EXTENSION_OVER("展期申请撤销"),
    EXTENSION_SELECT_CREATE("创建展期申请时的列表查询"),
    OVER_DUE_SELECT("查询逾期列表"),
    OVER_DUE_ADD("新增逾期"),
    OVER_DUE_OVER("撤销逾期"),
    LOOK_OVER_DUE_OVER("逾期查看"),
    LOOK_OVER_DUE_RECORD("减免费用申请查看"),
    UPUDATE_OVER_DUE_RECORD("减免费用修改"),

    /*展期申请 结束*/

    /*打折申请 开始*/
    DISCOUNT_SELECT("打折申请信息分页查询"),
    DISCOUNT_LOOK("打折申请单条信息查看"),
    DISCOUNT_RESTART("重新发起打折申请/撤销"),
    DISCOUNT_UPDATE("驳回后修改打折申请并且重新启动流程")
    /*打折申请 结束*/
    ;
    private String desc;

    AuthorityAnnotationEnums(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    }
