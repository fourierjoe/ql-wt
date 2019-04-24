package yhao.micro.service.workflow.service.pvm;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yhao.infra.common.cache.RedisCache;
import yhao.infra.common.util.CommonListUtil;
import yhao.micro.service.workflow.apilist.model.flow.FlowNodeModel;
import yhao.micro.service.workflow.apilist.model.flow.FlowProcessDefinitionModel;
import yhao.micro.service.workflow.apilist.model.flow.FlowTransitionModel;
import yhao.micro.service.workflow.config.WorkFlowCacheKey;
import yhao.micro.service.workflow.dao.ProcessDao;

import java.util.List;
import java.util.Map;

/**
 * 流程查找器
 */
@Service
public class ProcessSearcher {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ProcessDao processDao;
    @Autowired
    private RedisCache redisCache;

    /**
     * 获取起始节点
     * @return
     */
    public FlowNodeModel findStartNode(String bizCode){
        FlowProcessDefinitionModel definition = searchNewestProcessDefinitionByCode(bizCode);
        return definition.getInitial();
    }

    /**
     * 获取通过下一级节点
     * @return
     */
    public List<FlowNodeModel> findNextNodes(String bizCode, String currentNodeId){
        FlowProcessDefinitionModel definition = searchNewestProcessDefinitionByCode(bizCode);
        return definition.getPassNextNode().get(currentNodeId);
    }

    /**
     * 根据当前流程bizCod和当前节点,获取下一级节点ID
     * @param bizCode
     * @param currentNodeId
     * @return
     */
    public FlowNodeModel findNextNode(String bizCode, String currentNodeId){
        FlowProcessDefinitionModel definition = searchNewestProcessDefinitionByCode(bizCode);
        List<FlowTransitionModel> tranList = definition.getTranList();
        for(FlowTransitionModel list:tranList) {
            if(list.getSourceId().equals(currentNodeId)) {
                Map<String, FlowNodeModel> nodeMap = definition.getNodeMap();
                return nodeMap.get(list.getDestinationId());
            }
        }
        return null;
    }

    /**
     * 根据当前流程bizCod和当前节点,获取上一级节点ID
     * @param bizCode
     * @param currentNodeId
     * @return
     */
    public FlowNodeModel findPreviousNode(String bizCode, String currentNodeId){
        FlowProcessDefinitionModel definition = searchNewestProcessDefinitionByCode(bizCode);
        List<FlowTransitionModel> tranList = definition.getTranList();
        for(FlowTransitionModel list:tranList) {
            if(list.getDestinationId().equals(currentNodeId)) {
                Map<String, FlowNodeModel> nodeMap = definition.getNodeMap();
                return nodeMap.get(list.getSourceId());
            }
        }
        return null;
    }

    /**
     * 获取驳回上一级节点
     * @return
     */
    public List<FlowNodeModel> findPreviousNodes(String processId, String nodeId){
        FlowProcessDefinitionModel definition = searchProcessDefinitionById(processId);
        return definition.getRefuseNextNode().get(nodeId);
    }

    /**
     * 获取当前节点
     * @return
     */
    public FlowNodeModel findCurrentNode(String processId, String currentNodeId) {
        FlowProcessDefinitionModel definition = searchProcessDefinitionById(processId);
        return definition.getNodeMap().get(currentNodeId);
    }

    /**
     * 使bizCode关联的流程定义缓存失效
     * @param bizCode
     */
    public void removeProcessDefinitionCacheByCode(String bizCode){
        redisCache.remove(WorkFlowCacheKey.PROCESS_DEF,bizCode);
    }

    /**
     * 通过id使bizCode关联的流程定义缓存失效
     * @param processId
     */
    public void removeProcessDefinitionCacheById(String processId){
        FlowProcessDefinitionModel model = processDao.selectProcessDefinitionById(processId);
        if(model!= null && StringUtils.isNotEmpty(model.getBizCode())){
            redisCache.remove(WorkFlowCacheKey.PROCESS_DEF,model.getBizCode());
            redisCache.remove(WorkFlowCacheKey.PROCESS_DEF_ID,model.getId());
        }
    }

    /**
     * 注意通过id获取的流程记录，可能不是最新的
     * **/
    public FlowProcessDefinitionModel searchProcessDefinitionById(String id) {
        FlowProcessDefinitionModel definition
                = (FlowProcessDefinitionModel)redisCache.get(WorkFlowCacheKey.PROCESS_DEF_ID,id);
        if(definition==null){
            definition = processDao.selectProcessDefinitionById(id);
            if(definition==null){
                throw new RuntimeException("无法找到有效的流程定义，id："+id);
            }
            fillDefinition(definition);
            redisCache.put(WorkFlowCacheKey.PROCESS_DEF_ID,id,definition);
        }
        return definition;
    }

    /**
     * 通过code返回流程定义，始终返回最新的流程记录
     * @param bizCode
     * @return
     */
    public FlowProcessDefinitionModel searchNewestProcessDefinitionByCode(String bizCode) {
        FlowProcessDefinitionModel definition
                = (FlowProcessDefinitionModel)redisCache.get(WorkFlowCacheKey.PROCESS_DEF,bizCode);
        if(definition==null){
            List<FlowProcessDefinitionModel> list = processDao.queryProcessDefinitionByBizCode(bizCode);
            if(CommonListUtil.isEmpty(list)){
                throw new RuntimeException("无法找到对应的流程定义，bizCode："+bizCode);
            }
            if(list.size()>1){
                logger.error("找到超过一个的有效定义，bizCode:"+bizCode);
            }
            definition = list.get(0);

            fillDefinition(definition);
            redisCache.put(WorkFlowCacheKey.PROCESS_DEF,bizCode,definition);
        }
        return definition;
    }

    /**填充定义数据**/
    private void fillDefinition(FlowProcessDefinitionModel definition) {
        //查找关联节点
        List<FlowNodeModel> nodeList = processDao.queryNodeByProcessId(definition.getId());
        for(FlowNodeModel node:nodeList){
            node.setNodeWarn(processDao.selectNodeWarnByNodeId(node.getId()));
            node.setItems(processDao.queryNodeItemByNodeId(node.getId()));
            node.setNotifyList(processDao.queryNodeNotifyByNodeId(node.getId()));
        }
        //查找关联连接线
        List<FlowTransitionModel> tranList = processDao.queryTransitionByProcessId(definition.getId());
        //拼装数据结构
        definition.initDefinitionImage(nodeList,tranList);
    }
}
