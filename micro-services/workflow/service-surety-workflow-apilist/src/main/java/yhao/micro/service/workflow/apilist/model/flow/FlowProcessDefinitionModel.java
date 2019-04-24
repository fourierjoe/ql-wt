package yhao.micro.service.workflow.apilist.model.flow;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.infra.common.util.CommonListUtil;
import yhao.micro.service.workflow.apilist.enums.flow.FlowTransitionType;
import yhao.micro.service.workflow.apilist.enums.flow.ProcessDefinitionStatus;
import yhao.micro.service.workflow.apilist.enums.flow.ProcessDefinitionType;

import java.util.*;

/**
 * 流程定义类，凝结了一个不变流程的相关信息。
 */
public class FlowProcessDefinitionModel extends Entity<String> {
    @ApiModelProperty("流程名称")
    private String name;
    @ApiModelProperty("业务编号")
    private String bizCode;
    @ApiModelProperty("业务状态")
    private ProcessDefinitionStatus status;
    @ApiModelProperty("业务状态")
    private String statusEnum;
    @ApiModelProperty("城市组织ID")
    private String orgId;
    @ApiModelProperty(value = "流程分组")
    private ProcessDefinitionType processGroupe;
    @ApiModelProperty("流程分组")
    private String processGroupeEnum;

    @ApiModelProperty(value = "流程最开始的节点",hidden = true)
    @JSONField(serialize = false)
    private FlowNodeModel initial;

    @ApiModelProperty(value = "包含节点",hidden = true)
    @JSONField(serialize = false)
    private List<FlowNodeModel> nodeList;

    @ApiModelProperty(value = "包含连接线",hidden = true)
    @JSONField(serialize = false)
    List<FlowTransitionModel> tranList;

    @ApiModelProperty(value = "审核通过下一级节点",hidden = true)
    @JSONField(serialize = false)
    private Map<String,List<FlowNodeModel>> passNextNode;

    @ApiModelProperty(value = "审核拒绝下一级节点",hidden = true)
    @JSONField(serialize = false)
    private Map<String,List<FlowNodeModel>> refuseNextNode;

    @ApiModelProperty(value = "节点map",hidden = true)
    @JSONField(serialize = false)
    private Map<String,FlowNodeModel> nodeMap;

    @ApiModelProperty(value = "页面显示节点顺序")
    private Map<Integer, FlowNodeModel> returnNodeMap;

    @ApiModelProperty(value = "节点数")
    private Integer nodeCount;

    @ApiModelProperty(value = "创建人")
    private String createOperatorName;

    public String getStatusEnum() {
        return statusEnum;
    }

    public void setStatusEnum(String statusEnum) {
        this.statusEnum = Optional.ofNullable(status).orElseGet(() -> ProcessDefinitionStatus.UNVALID).getDesc();
    }

    public ProcessDefinitionType getProcessGroupe() {
        return processGroupe;
    }

    public void setProcessGroupe(ProcessDefinitionType processGroupe) {
        this.processGroupe = processGroupe;
    }

    public String getProcessGroupeEnum() {
        return processGroupeEnum;
    }

    public void setProcessGroupeEnum(String processGroupeEnum) {
        this.processGroupeEnum = Optional.ofNullable(processGroupe).orElseGet(() -> ProcessDefinitionType.UNVALID).getDesc();
    }

    public String getCreateOperatorName() {
        return createOperatorName;
    }

    public void setCreateOperatorName(String createOperatorName) {
        this.createOperatorName = createOperatorName;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public Map<Integer, FlowNodeModel> getReturnNodeMap() {
        return returnNodeMap;
    }

    public void setReturnNodeMap(Map<Integer, FlowNodeModel> returnNodeMap) {
        this.returnNodeMap = returnNodeMap;
    }

    public void setNodeList(List<FlowNodeModel> nodeList) {
        this.nodeList = nodeList;
    }

    public void setTranList(List<FlowTransitionModel> tranList) {
        this.tranList = tranList;
    }

    public void setPassNextNode(Map<String, List<FlowNodeModel>> passNextNode) {
        this.passNextNode = passNextNode;
    }

    public void setRefuseNextNode(Map<String, List<FlowNodeModel>> refuseNextNode) {
        this.refuseNextNode = refuseNextNode;
    }

    public void setNodeMap(Map<String, FlowNodeModel> nodeMap) {
        this.nodeMap = nodeMap;
    }

    public Integer getNodeCount() {
        return nodeCount;
    }

    public void setNodeCount(Integer nodeCount) {
        this.nodeCount = nodeCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public FlowNodeModel getInitial() {
        return initial;
    }

    public void setInitial(FlowNodeModel initial) {
        this.initial = initial;
    }

    public List<FlowNodeModel> getNodeList() {
        return nodeList;
    }

    public List<FlowTransitionModel> getTranList() {
        return tranList;
    }

    public Map<String, List<FlowNodeModel>> getPassNextNode() {
        return passNextNode;
    }

    public Map<String, List<FlowNodeModel>> getRefuseNextNode() {
        return refuseNextNode;
    }

    public Map<String, FlowNodeModel> getNodeMap() {
        return nodeMap;
    }

    public ProcessDefinitionStatus getStatus() {
        return status;
    }

    public void setStatus(ProcessDefinitionStatus status) {
        this.status = status;
    }

    public synchronized void initDefinitionImage(List<FlowNodeModel> nodeList, List<FlowTransitionModel> tranList){
        if(CommonListUtil.isEmpty(nodeList) || CommonListUtil.isEmpty(tranList) ){
            return;
        }
        this.nodeList = nodeList;
        this.tranList = tranList;
        passNextNode = new HashMap<>();
        refuseNextNode = new HashMap<>();
        nodeMap = new HashMap<>();
        for(FlowNodeModel node:nodeList){
            passNextNode.put(node.getId(),new ArrayList<>());
            refuseNextNode.put(node.getId(),new ArrayList<>());
            nodeMap.put(node.getId(),node);
        }
        Map<String,Integer> sourceCountMap = new HashMap<>();
        for(FlowTransitionModel tran:tranList){
            FlowNodeModel source = nodeMap.get(tran.getSourceId());
            FlowNodeModel destination = nodeMap.get(tran.getDestinationId());
            if(!sourceCountMap.containsKey(tran.getSourceId())){
                sourceCountMap.put(tran.getSourceId(),0);
            }
            if(!sourceCountMap.containsKey(tran.getDestinationId())){
                sourceCountMap.put(tran.getDestinationId(),0);
            }
            if(tran.getType().equals(FlowTransitionType.PASS)){
                passNextNode.get(tran.getSourceId()).add(destination);
                refuseNextNode.get(tran.getDestinationId()).add(source);
            }else if(tran.getType().equals(FlowTransitionType.REFUSE)){
                refuseNextNode.get(tran.getSourceId()).add(destination);
            }
            sourceCountMap.put(tran.getDestinationId(),sourceCountMap.get(tran.getDestinationId())+1);
        }
        for(Map.Entry<String,Integer> entry:sourceCountMap.entrySet()){
            if(entry.getValue()==0){
                initial = nodeMap.get(entry.getKey());
            }
        }
    }
}
