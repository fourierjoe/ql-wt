package yhao.micro.service.workflow.dao;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.workflow.apilist.form.flow.*;
import yhao.micro.service.workflow.apilist.form.flow.processBussiness.BizFlowNodeForm;
import yhao.micro.service.workflow.apilist.form.flow.processBussiness.BizFlowNodeItemForm;
import yhao.micro.service.workflow.apilist.form.flow.processBussiness.BizFlowNodeWarnForm;
import yhao.micro.service.workflow.apilist.form.flow.processBussiness.ItemCodeForm;
import yhao.micro.service.workflow.apilist.form.flow.processCenter.FlowNodeForm;
import yhao.micro.service.workflow.apilist.form.flow.processCenter.FlowNodeItemForm;
import yhao.micro.service.workflow.apilist.model.flow.*;

import java.util.List;

@MappedJdbcTypes({JdbcType.VARCHAR})
public interface ProcessDao {
    void insertProcessDefinition(BaseFlowProcessDefinitionForm form);

    void batchInsertFlowNode(List<FlowNodeForm> nodes);

    /**
     * 主流程-插入节点
     * @param nodes
     */
    void batchBizInsertFlowNode(List<BizFlowNodeForm> nodes);

    void batchInsertFlowTransition(List<FlowTransitionForm> nodes);

    void overrideProcessDefinitionById(String id);

    void overrideProcessDefinitionByBizCode(String bizCode);

    void updateBizCode(FlowProcessBizCodeChangeForm form);

    void saveNodeTemplate(FlowNodeTemplateForm form);

    void updateNodeTemplate(FlowNodeTemplateForm form);

    List<FlowProcessDefinitionModel> queryProcessDefinitionByBizCode(String bizCode);

    List<FlowNodeModel> queryNodeByProcessId(String id);

    List<FlowTransitionModel> queryTransitionByProcessId(String id);

    void updateNodeItemTemplate(FlowNodeItemTemplateSaveForm form);

    void saveNodeItemTemplate(FlowNodeItemTemplateSaveForm form);

    /**
     * 批量添加主流程业务中的节点多个事项
     * @param itemList
     */
    void batchBizInsertFlowNodeItem(List<BizFlowNodeItemForm> itemList);

    /**
     * 添加一个节点事项,用于子流程自动生成事项
     * @param item
     */
    void insertFlowNodeItem(FlowNodeItemForm item);

    void batchInsertFlowNodeNotify(List<FlowNodeNotifyForm> notifyList);

    void insertFlowNodeWarn(BizFlowNodeWarnForm warnForm);

    FlowNodeWarnModel selectNodeWarnByNodeId(String nodeId);


    List<FlowNodeTemplateModel> queryAllNodeTemplateByOrgId(Pagination<FlowNodeTemplateModel> page, FlowNodeTemplateQueryForm form);

    /**
     * 注意通过id获取的流程记录，可能不是最新的
     * **/
    FlowProcessDefinitionModel selectProcessDefinitionById(String id);

    List<FlowNodeItemModel> queryNodeItemByNodeId(String nodeId);

    List<FlowNodeNotifyModel> queryNodeNotifyByNodeId(String nodeId);

    List<FlowProcessDefinitionModel> queryProcessPage(Pagination<FlowProcessDefinitionModel> page, FlowProcessQueryForm form);

    List<FlowItemTemplateModel> queryAllItemTemplate(Pagination<FlowItemTemplateModel> page, FlowNodeItemTemplateQueryForm form);

    List<ItemConfigModel> queryItemConfig(Pagination<ItemConfigModel> page, ItemCodeForm form);

    void deleteItemTemplate(String id);

    List<SubProcessNameModel> pickSubProcessId(SubProcessNameQueryForm form);

    void deleteNodeTemplate(String id);

    List<FlowNodeTemplateModel> pickFlowCenterNodeByName(FlowNodeNameForm form);

    FlowProcessDefinitionModel selectProcessBizCod(String taskId);

    String selectMaxBizCode2Db();

    List<FlowNodeTemplateModel> pickAllNode(FlowNodeTempleteForm form);

    void deleteOverrideProcess();

    int pickProcessNodeIsDelete(String id);

    List<String> selectForUpdate(List<String> list);

    List<String> selectProcessNodeId(String id);
}