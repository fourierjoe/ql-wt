package yhao.micro.service.workflow.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yhao.infra.apilist.RequestResultException;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.infra.common.util.CommonListUtil;
import yhao.micro.service.constants.CommonConstants;
import yhao.micro.service.constants.enums.YNEnum;
import yhao.micro.service.workflow.apilist.enums.flow.*;
import yhao.micro.service.workflow.apilist.form.flow.*;
import yhao.micro.service.workflow.apilist.form.flow.processBussiness.*;
import yhao.micro.service.workflow.apilist.form.flow.processCenter.FlowNodeForm;
import yhao.micro.service.workflow.apilist.form.flow.processCenter.FlowNodeItemForm;
import yhao.micro.service.workflow.apilist.form.flow.processCenter.FlowProcessDefinitionForm;
import yhao.micro.service.workflow.apilist.model.flow.*;
import yhao.micro.service.workflow.dao.ProcessDao;
import yhao.micro.service.workflow.service.pvm.ProcessSearcher;

import javax.annotation.Resource;
import java.util.*;

@Service
public class ProcessService {
    private Logger logger = LoggerFactory.getLogger(ProcessService.class);
    @Resource
    private ProcessDao processDao;

    @Resource
    private ProcessSearcher processSearcher;

    @Transactional
    public boolean updateBizCode(FlowProcessBizCodeChangeForm form){
        if(StringUtils.isEmpty(form.getBizCodeStr())&&form.getBizCode()==null){
            throw new RuntimeException("必须设置业务编码");
        }
        if(form.getBizCode()!=null){        //优先使用预定义的业务编码
            form.setBizCodeStr(form.getBizCode().toString());
        }
        FlowProcessDefinitionModel model = processDao.selectProcessDefinitionById(form.getId());
        if(model==null || model.getStatus()!= ProcessDefinitionStatus.ENABLED){
            throw new RuntimeException("流程定义不存在或已过期");
        }
        processDao.overrideProcessDefinitionByBizCode(form.getBizCodeStr());
        processDao.updateBizCode(form);
        processSearcher.removeProcessDefinitionCacheByCode(model.getBizCode());
        processSearcher.removeProcessDefinitionCacheByCode(form.getBizCodeStr());
        return true;
    }

    /**
     * 流程中心
     * 流程定义保存-保存子流程(需要自动根据节点生成事项)
     * @param form
     * @return
     */
    @Transactional
    public FlowProcessDefinitionForm saveProcessDefinition(FlowProcessDefinitionForm form) {
//        if(StringUtils.isEmpty(form.getBizCodeStr())&&form.getBizCode()==null){
//            throw new RuntimeException("必须设置业务编码");
//        }
//        if(form.getBizCode()!=null){        //优先使用预定义的业务编码
//            form.setBizCodeStr(form.getBizCode().toString());
//        }

        // 接口业务校验
        checkFlowProcessInterface(form);

        // 子任务节点检查
        if(StringUtils.isNotEmpty(form.getId())) { //修改时检查是否删除节点
            // 查出此流程原有的所有节点id
            List<String>  oldNodeIdList = processDao.selectProcessNodeId(form.getId());
            List<String> newNodeIdList = Lists.newArrayList();

            // 筛选需要检查的节点id
            List<String> checkNodeIdList = Lists.newArrayList();

            form.getNodes().forEach(flowNodeForm -> newNodeIdList.add(flowNodeForm.getId()));
            oldNodeIdList.forEach(oldNodeId -> {
                if (!newNodeIdList.contains(oldNodeId)) { //修改流程时有删除节点
                    checkNodeIdList.add(oldNodeId);
                }
            });
            if (!CommonListUtil.isEmpty(checkNodeIdList)) {
                checkNodeIdList.forEach(checkNodeId -> {
                    if (!pickProcessNodeIsDelete(checkNodeId)) {
                        logger.error(checkNodeId + "节点正在运行不得删除,请稍后再试...");
                        throw new RuntimeException(checkNodeId + "节点正在运行不得删除,请稍后再试...");
                    }
                });
            }
            // lock包含该节点的流程的所有任务,确保保存过程不删除当前节点
            processDao.selectForUpdate(newNodeIdList);
        }

        // 拼接流程顺序trans
        joinTrans(form);

        //校验有效性
        if(checkLoopProcessDefinition(form)){
           throw new RuntimeException("存在有循环引用，请重新设置");
        }
        String errMsg = checkAndSetTransProcessDefinition(form);
        if(StringUtils.isNotEmpty(errMsg)){
            throw new RuntimeException(errMsg);
        }
        if(StringUtils.isNotEmpty(form.getId())){
            //编辑流程，则原来的流程设置为过期。
            processDao.overrideProcessDefinitionById(form.getId());
            processSearcher.removeProcessDefinitionCacheById(form.getId());
            if (StringUtils.isEmpty(form.getBizCodeStr())) { //修改步骤,流程编码唯一
                throw new RuntimeException("编辑流程必须传入流程编码(bizCodeStr)...");
            }
        } else { //新增步骤
            //找出数据库中最大流程编码再递增
            int bizCode2Db = Integer.parseInt(processDao.selectMaxBizCode2Db());
            form.setBizCodeStr(String.valueOf(++bizCode2Db));
        }
        processSearcher.removeProcessDefinitionCacheByCode(form.getBizCodeStr());
        //编辑流程，则原来的流程设置为过期。
        processDao.overrideProcessDefinitionByBizCode(form.getBizCodeStr());

        //将原来关联到
        String processId = UUID.randomUUID().toString();
        form.setId(processId);

        //标准流程,子流程
        form.setProcessType(ProcessType.SUB);
        processDao.insertProcessDefinition((BaseFlowProcessDefinitionForm)form);
        //节点
        for(FlowNodeForm node:form.getNodes()){
            node.setProcessId(processId);

            // 子流程生成事项和节点ID一样的
            FlowNodeItemForm autoNodeItemForm = new FlowNodeItemForm();
            autoNodeItemForm.setId(node.getId());
            autoNodeItemForm.setNodeId(node.getId());
            autoNodeItemForm.setItemCode(node.getId());
            autoNodeItemForm.setOrgId(form.getOrgId());
            autoNodeItemForm.setItemExpect(CommonConstants.PASS);
            // 节点编号必须从1开始
            autoNodeItemForm.setItemOrder(node.getOrderNo());

            processDao.insertFlowNodeItem(autoNodeItemForm);

            //节点通知
            batchInsertFlowNodeNotify(node.getNotifyList(), node.getId());
        }
        processDao.batchInsertFlowNode(form.getNodes());
        //连接点
        for(FlowTransitionForm tran:form.getTrans()){
            tran.setProcessId(processId);
        }
        processDao.batchInsertFlowTransition(form.getTrans());
        return form;
    }


    /**
     * 业务流程配置-主流程(包含子流程,事项)
     * @param form
     * @return
     */
    @Transactional
    public BizFlowProcessDefinitionForm saveBizProcessDefinition(final BizFlowProcessDefinitionForm form) {
//        if(StringUtils.isEmpty(form.getBizCodeStr())&&form.getBizCode()==null){
//            throw new RuntimeException("修改流程时必须设置业务编码");
//        }
//        if(form.getBizCode()!=null){        //优先使用预定义的业务编码
//            form.setBizCodeStr(form.getBizCode().toString());
//        }
        // 接口业务校验
        checkBizProcessInterface(form);

        // 主任务节点检查
        if(StringUtils.isNotEmpty(form.getId())) { //修改检查是否删除节点
            List<String> nodeIdList = Lists.newArrayList();
            for (BizFlowNodeForm flowNodeForm : form.getBizNodes()) {
                if (!pickProcessNodeIsDelete(flowNodeForm.getId())) {
                    throw new RuntimeException(flowNodeForm.getId() + "节点正在运行不得删除,请稍后再试...");
                }
                nodeIdList.add(flowNodeForm.getId());
            }
            // lock包含该节点的流程的所有任务,确保保存过程不删除当前节点
            processDao.selectForUpdate(nodeIdList);
        }

        // 拼接流程顺序trans
        joinBizTrans(form);

        //校验有效性
        if(checkLoopProcessDefinition(form)){
            throw new RuntimeException("存在有循环引用，请重新设置");
        }
        //校验事项或子节点必须选其一
        ArrayList<BizFlowNodeItemForm> coreItemList = Lists.newArrayList();
        for (BizFlowNodeForm bizFlowNodeForm:form.getBizNodes()) {
            List<BizFlowNodeItemForm> nodeItemList = bizFlowNodeForm.getItems();
            if (StringUtils.isEmpty(bizFlowNodeForm.getSubProcessId()) && (nodeItemList == null || nodeItemList.isEmpty())) {
                throw new RuntimeException("事项或子节点必须配置其一") ;
            }

            //校验核心事项和必要事项只能选其一
            if (nodeItemList != null) {
                for (BizFlowNodeItemForm bizFlowNodeItemForm:nodeItemList) {
                    if (bizFlowNodeItemForm.getCore() == YNEnum.YES) {
                        coreItemList.add(bizFlowNodeItemForm);
                        if (bizFlowNodeItemForm.getCore() == bizFlowNodeItemForm.getNecessary()) {
                            throw new RuntimeException("核心事项和必要事项只能选其一(只能有一个是YES)") ;
                        }
                    }
                }
                if (coreItemList.size() > 1) {
                    throw new RuntimeException("核心事项只能设置一个") ;
                }
            }
            coreItemList.clear();
        }

        String errMsg = checkAndSetBizTransProcessDefinition(form);
        if(StringUtils.isNotEmpty(errMsg)){
            throw new RuntimeException(errMsg);
        }
        if(StringUtils.isNotEmpty(form.getId())){
            //编辑流程，则原来的流程设置为过期。
            processDao.overrideProcessDefinitionById(form.getId());
            processSearcher.removeProcessDefinitionCacheById(form.getId());
            if (StringUtils.isEmpty(form.getBizCodeStr())) { //修改步骤,流程编码唯一
                throw new RuntimeException("编辑流程必须传入流程编码(bizCodeStr)...");
            }
        } else {
            //找出数据库中最大流程编码
            Integer bizCode2Db = Integer.parseInt(processDao.selectMaxBizCode2Db());
            form.setBizCodeStr(String.valueOf(++bizCode2Db));
        }
        processSearcher.removeProcessDefinitionCacheByCode(form.getBizCodeStr());
        //编辑流程，则原来的流程设置为过期。
        processDao.overrideProcessDefinitionByBizCode(form.getBizCodeStr());
        //将原来关联到
        String processId = UUID.randomUUID().toString();
        form.setId(processId);

        //业务流程
        form.setProcessType(ProcessType.MAIN);
        processDao.insertProcessDefinition((BaseFlowProcessDefinitionForm)form);
        //节点
        for(BizFlowNodeForm node:form.getBizNodes()){
            node.setProcessId(processId);
            //节点事项
            if(!CommonListUtil.isEmpty(node.getItems())){

                List<String> coreItemCheck = Lists.newArrayList();
                for(BizFlowNodeItemForm item:node.getItems()){
                    // 校验核心事项是否只有一个,核心事项设置多个报错
                    if (CommonConstants.YES.equals(item.getCore().toString())) {
                        coreItemCheck.add(item.getItemCode());

                        if (coreItemCheck.size() > 1) {
                            throw new RuntimeException("一个节点的核心事项只能配置一个,请重新配置");
                        }
                    }

                    item.setNodeId(node.getId());
                    String itemId = UUID.randomUUID().toString();
                    item.setId(itemId);
                }
                processDao.batchBizInsertFlowNodeItem(node.getItems());
            }

            // 预警设置
            if(node.getWarn() != null && CommonConstants.YES.equals(node.getWarn().toString()) && node.getBizNodemWarn() != null) {
                BizFlowNodeWarnForm warnForm = node.getBizNodemWarn();
                warnForm.setId(UUID.randomUUID().toString());
                warnForm.setNodeId(node.getId());
                processDao.insertFlowNodeWarn(warnForm);
            }

            //节点通知
            batchInsertFlowNodeNotify(node.getNotifyList(), node.getId());

            //校验是否有子任务，有则至多只能引用一级子任务
            if(StringUtils.isNotEmpty(node.getSubProcessId())){
                FlowProcessDefinitionModel subDef = processSearcher.searchProcessDefinitionById(node.getSubProcessId());
                for(FlowNodeModel model:subDef.getNodeList()){
                    if(StringUtils.isNotEmpty(model.getSubProcessId())){
                        throw new RuntimeException("节点包含的子流程不可再引用其他子流程，至多嵌套1层子流程！请重新设置");
                    }
                }
            }
        }
        processDao.batchBizInsertFlowNode(form.getBizNodes());
        //连接点
        for(FlowTransitionForm tran:form.getTrans()){
            tran.setProcessId(processId);
        }
        processDao.batchInsertFlowTransition(form.getTrans());

        return form;
    }


    private String checkAndSetTransProcessDefinition(FlowProcessDefinitionForm form) {
        Map<Integer, FlowNodeForm> nodeMap = new HashMap<>();
        for(FlowNodeForm node:form.getNodes()){
            node.setId(UUID.randomUUID().toString());
            if(!nodeMap.containsKey(node.getOrderNo())){
                nodeMap.put(node.getOrderNo(),node);
            }
        }
        if(nodeMap.values().size()!=form.getNodes().size()){
            return "节点编号重复，请重新设置";
        }
        Map<Integer,Integer> sourceCountMap = new HashMap<>();
        for(FlowTransitionForm tran:form.getTrans()){
            FlowNodeForm source = nodeMap.get(tran.getSourceOrderNo());
            FlowNodeForm destination = nodeMap.get(tran.getDestinationOrderNo());
            if(source==null || destination==null){
                return "连接未编号的节点，请重新设置";
            }
            tran.setId(UUID.randomUUID().toString());
            tran.setSourceId(source.getId());
            tran.setDestinationId(destination.getId());
            if(!sourceCountMap.containsKey(tran.getSourceOrderNo())){
                sourceCountMap.put(tran.getSourceOrderNo(),0);
            }
            if(!sourceCountMap.containsKey(tran.getDestinationOrderNo())){
                sourceCountMap.put(tran.getDestinationOrderNo(),0);
            }
            //给目的节点的来源count+1
            sourceCountMap.put(tran.getDestinationOrderNo(),sourceCountMap.get(tran.getDestinationOrderNo())+1);
        }
        if(sourceCountMap.keySet().size()!=form.getNodes().size()){
            return "存在孤立的节点，请重新设置";
        }
        //有且只有一个节点不存在来源节点，即初始节点，其他所有节点必须都有来源节点。
        int rootCount = 0;
        for(Integer count:sourceCountMap.values()){
            if(count==0){
                rootCount++;
            }
        }
        if(rootCount>1){
            return "起始节点数量大于1，请重新设置";
        }else if(rootCount == 0){
            return "没有起始节点，请重新设置";
        }
        return null;
    }

    /**
     * 业务流程
     * @param form
     * @return
     */
    private String checkAndSetBizTransProcessDefinition(BizFlowProcessDefinitionForm form) {
        Map<Integer, BizFlowNodeForm> nodeMap = new HashMap<>();
        for(BizFlowNodeForm node:form.getBizNodes()){
            node.setId(UUID.randomUUID().toString());
            if(!nodeMap.containsKey(node.getOrderNo())){
                nodeMap.put(node.getOrderNo(),node);
            }
        }
        if(nodeMap.values().size()!=form.getBizNodes().size()){
            return "节点编号重复，请重新设置";
        }
        Map<Integer,Integer> sourceCountMap = new HashMap<>();
        for(FlowTransitionForm tran:form.getTrans()){
            BizFlowNodeForm source = nodeMap.get(tran.getSourceOrderNo());
            BizFlowNodeForm destination = nodeMap.get(tran.getDestinationOrderNo());
            if(source==null || destination==null){
                return "连接未编号的节点，请重新设置";
            }
            tran.setId(UUID.randomUUID().toString());
            tran.setSourceId(source.getId());
            tran.setDestinationId(destination.getId());
            if(!sourceCountMap.containsKey(tran.getSourceOrderNo())){
                sourceCountMap.put(tran.getSourceOrderNo(),0);
            }
            if(!sourceCountMap.containsKey(tran.getDestinationOrderNo())){
                sourceCountMap.put(tran.getDestinationOrderNo(),0);
            }
            //给目的节点的来源count+1
            sourceCountMap.put(tran.getDestinationOrderNo(),sourceCountMap.get(tran.getDestinationOrderNo())+1);
        }
        if(sourceCountMap.keySet().size()!=form.getBizNodes().size()){
            return "存在孤立的节点，请重新设置";
        }
        //有且只有一个节点不存在来源节点，即初始节点，其他所有节点必须都有来源节点。
        int rootCount = 0;
        for(Integer count:sourceCountMap.values()){
            if(count==0){
                rootCount++;
            }
        }
        if(rootCount>1){
            return "起始节点数量大于1，请重新设置";
        }else if(rootCount == 0){
            return "没有起始节点，请重新设置";
        }
        return null;
    }

    private boolean checkLoopProcessDefinition(BaseFlowProcessDefinitionForm form) {
        //检查是否成环
        Map<Integer, Set<Integer>> checkMap = new HashMap<>();
        for(FlowTransitionForm tran:form.getTrans()){
            if(!checkMap.containsKey(tran.getSourceOrderNo())){
                checkMap.put(tran.getSourceOrderNo(),new HashSet<>());
            }
            checkMap.get(tran.getSourceOrderNo()).add(tran.getDestinationOrderNo());
        }
        for(Integer source:checkMap.keySet()){
            for(Integer destination : checkMap.get(source)){
                if(checkMap.get(destination)!=null &&
                        checkMap.get(destination).contains(source)){
                    return true;
                }
            }
        }
        return false;
    }

    @Transactional
    public FlowNodeTemplateForm saveNodeTemplate(FlowNodeTemplateForm form) {
        if(StringUtils.isNotEmpty(form.getId())){
            processDao.updateNodeTemplate(form);
        }else{
            form.setId(UUID.randomUUID().toString());
            try {
                processDao.saveNodeTemplate(form);
            } catch (Throwable e) {
                Throwable cause = e.getCause();
                if(cause instanceof org.springframework.dao.DuplicateKeyException) {
                    String errMsg = ((org.springframework.dao.DuplicateKeyException)cause).getMessage();
                    if(StringUtils.isNotBlank(errMsg) && errMsg.indexOf("SURETY.IX_UNIQUE_NAME")!=-1) {
                        throw new RuntimeException("同一城市下节点名称不能重复！");
                    }
                }
                throw e;

            }
        }
        return form;
    }


    public FlowNodeItemTemplateSaveForm saveNodeItemTemplate(FlowNodeItemTemplateSaveForm form) {
        if(StringUtils.isNotEmpty(form.getId())){
            covertUpdateJson(form);
            processDao.updateNodeItemTemplate(form);
        }else{
            form.setId(UUID.randomUUID().toString());
            covertJson(form);
            processDao.saveNodeItemTemplate(form);
        }
        return form;
    }

    private void covertJson(FlowNodeItemTemplateSaveForm form) {
        StringBuilder sb = new StringBuilder();
        for (String orgId : form.getOrgIdArr()) {
            sb.append(orgId).append("#");
        }
        form.setOrgId(sb.toString());
    }

    private void covertUpdateJson(FlowNodeItemTemplateSaveForm form) {
        StringBuilder sb = new StringBuilder();
        for (String orgId : form.getOrgIdArr()) {
            sb.append(orgId).append("#");
        }

        form.setOrgId(sb.toString());
    }

    private String joinStr(String str) {
        StringBuffer sb = new StringBuffer(3);
        int step = 3 - str.length();
        for (int i = 0; i < step; i++) {
            sb.append('0');
        }
        return sb.append(str).toString();
    }

    public Pagination<FlowNodeTemplateModel> queryNodeTemplatePage(FlowNodeTemplateQueryForm form) {
        Pagination<FlowNodeTemplateModel> page = new Pagination<>(form.getPageSize(), form.getCurrentPage());
        processDao.queryAllNodeTemplateByOrgId(page, form);
        return page;
    }

    public Boolean deleteNodeTemplate(IdForm form) {
        processDao.deleteNodeTemplate(form.getId());
        return true;
    }

    public List<FlowNodeTemplateModel> pickFlowCenterNodeByName(FlowNodeNameForm form) {
        return processDao.pickFlowCenterNodeByName(form);
    }

    public Pagination<FlowProcessDefinitionModel> queryProcessPage(FlowProcessQueryForm form) {
        Pagination<FlowProcessDefinitionModel> page = new Pagination<>(form.getPageSize(),form.getCurrentPage());
        processDao.queryProcessPage(page,form);
        return page;
    }

    public List<FlowNodeTemplateModel> pickAllNode(FlowNodeTempleteForm form) {
        return processDao.pickAllNode(form);
    }

    /**
     *
     * @param form 任务id
     * @return
     */
    public BizFlowProcessDefinitionModel pickProcessDefinitionByBizCod(BizCodeForm form) {
        BizFlowProcessDefinitionModel model = new BizFlowProcessDefinitionModel();
        FlowProcessDefinitionModel flowProcessDefinitionModel = processSearcher.searchNewestProcessDefinitionByCode(form.getBizCode());
        model.setFlowProcessDefinitionModel(flowProcessDefinitionModel);
        return model;
    }


    public Pagination<FlowItemTemplateModel> queryItemTemplatePage(FlowNodeItemTemplateQueryForm form) {
        Pagination<FlowItemTemplateModel> page = new Pagination<>(form.getPageSize(),form.getCurrentPage());
        processDao.queryAllItemTemplate(page,form);
        return page;
    }

    public Pagination<ItemConfigModel> queryItemConfig(ItemCodeForm form) {
        Pagination<ItemConfigModel> page = new Pagination<>(form.getPageSize(),form.getCurrentPage());
        processDao.queryItemConfig(page, form);
        return page;
    }

    public Boolean deleteItemTemplate(IdForm form) {
        processDao.deleteItemTemplate(form.getId());
        return true;
    }

    public List<SubProcessNameModel> pickSubProcessId(SubProcessNameQueryForm form) {
        return processDao.pickSubProcessId(form);
    }

    public boolean pickProcessNodeIsDelete(String id) {
        return processDao.pickProcessNodeIsDelete(id) == 0;
    }

    private void checkFlowProcessInterface(FlowProcessDefinitionForm form) {
        for (FlowNodeForm flowNodeForm : form.getNodes()) {
            checkNotify(flowNodeForm.getNotifyList());
            if (StringUtils.isNotEmpty(flowNodeForm.getNodeConditionName())) {
                if (!flowNodeForm.getNodeConditionName().equals(ConditionNameType.GUARANTEE_AMOUNT.toString())
                        && !flowNodeForm.getNodeConditionName().equals(ConditionNameType.BILLING_AMOUNT.toString())) {
                    throw new RequestResultException("传入条件设置名称不符...");
                }
            }
        }
        if(form.getStatus() != ProcessDefinitionStatus.ENABLED
                && form.getStatus() != ProcessDefinitionStatus.DISENABLED) {
            throw new RuntimeException("流程保存或修改状态只能是ENABLED/DISENABLED...");
        }
    }

    private void checkBizProcessInterface(BizFlowProcessDefinitionForm form) {
        for (BizFlowNodeForm bizFlowNodeForm : form.getBizNodes()) {
            checkNotify(bizFlowNodeForm.getNotifyList());

            if (StringUtils.isNotEmpty(bizFlowNodeForm.getSubProcessId())) { //子流程通过
                if (!CommonListUtil.isEmpty(bizFlowNodeForm.getItems())) {
                    throw new RuntimeException("完成事项和子流程通过只能选其一...");
                }
            } else { // 完成事项
                if (CommonListUtil.isEmpty(bizFlowNodeForm.getItems())) {
                    throw new RuntimeException("完成事项和子流程通过必须选其一...");
                }
            }

            // 校验预警
            if (bizFlowNodeForm.getWarn() == YNEnum.NO
                    && bizFlowNodeForm.getBizNodemWarn() != null) {
                throw new RuntimeException("节点无需预警时不得传预警信息...");
            }
        }

    }

    private void checkNotify(List<FlowNodeNotifyForm> notifyList) {
        for (FlowNodeNotifyForm flowNodeNotifyForm:notifyList) {
            if (flowNodeNotifyForm.getIsNotify() == FlowIsNotifyType.NO) {
                if (StringUtils.isNotEmpty(flowNodeNotifyForm.getNotifyType())
                        ||StringUtils.isNotEmpty(flowNodeNotifyForm.getNotifyMessage())) {
                    throw new RuntimeException("节点无需通知时不得传通知方式与通知内容...");
                }
            }
        }
    }

    private void joinTrans(FlowProcessDefinitionForm form) {
        for(FlowNodeForm node:form.getNodes()) {
            if (node.getOrderNo() == 0) {
                throw new RuntimeException("节点编号必须从1开始");
            }
        }
        form.getNodes().sort(new Comparator<FlowNodeForm>() {
            @Override
            public int compare(FlowNodeForm o1, FlowNodeForm o2) {
                return o1.getOrderNo() - o2.getOrderNo();
            }
        });

        LinkedList<FlowNodeForm> flowNodeFormLinkedList = Lists.newLinkedList();
        flowNodeFormLinkedList.addAll(form.getNodes());

        ArrayList<FlowTransitionForm> flowTransitionFormArrayList = Lists.newArrayList();
        for (int i=0; i < flowNodeFormLinkedList.size() - 1; i++) {
            FlowTransitionForm flowTransitionForm = new FlowTransitionForm();
            flowTransitionForm.setSourceOrderNo(flowNodeFormLinkedList.get(i).getOrderNo());
            flowTransitionForm.setDestinationOrderNo(flowNodeFormLinkedList.get(i+1).getOrderNo());
            flowTransitionForm.setType(FlowTransitionType.PASS);
            flowTransitionFormArrayList.add(flowTransitionForm);
        }
        form.setTrans(flowTransitionFormArrayList);
    }

    private void joinBizTrans(BizFlowProcessDefinitionForm form) {
        for(BizFlowNodeForm node:form.getBizNodes()) {
            if (node.getOrderNo() == 0) {
                throw new RuntimeException("节点编号必须从1开始");
            }
        }
        form.getBizNodes().sort(new Comparator<BizFlowNodeForm>() {
            @Override
            public int compare(BizFlowNodeForm o1, BizFlowNodeForm o2) {
                return o1.getOrderNo() - o2.getOrderNo();
            }
        });

        LinkedList<BizFlowNodeForm> bizFlowNodeFormLinkedList = Lists.newLinkedList();
        bizFlowNodeFormLinkedList.addAll(form.getBizNodes());

        ArrayList<FlowTransitionForm> flowTransitionFormArrayList = Lists.newArrayList();
        for (int i=0; i < bizFlowNodeFormLinkedList.size() - 1; i++) {
            FlowTransitionForm flowTransitionForm = new FlowTransitionForm();
            flowTransitionForm.setSourceOrderNo(bizFlowNodeFormLinkedList.get(i).getOrderNo());
            flowTransitionForm.setDestinationOrderNo(bizFlowNodeFormLinkedList.get(i+1).getOrderNo());
            flowTransitionForm.setType(FlowTransitionType.PASS);
            flowTransitionFormArrayList.add(flowTransitionForm);
        }
        form.setTrans(flowTransitionFormArrayList);
    }

    /**
     * 批量插入节点通知
     * @param list
     * @param nodeId
     */
    private void batchInsertFlowNodeNotify(List<FlowNodeNotifyForm> list, String nodeId) {
        if(!CommonListUtil.isEmpty(list)){
            for(FlowNodeNotifyForm notify:list){
                notify.setNodeId(nodeId);
                notify.setId(UUID.randomUUID().toString());
            }
            processDao.batchInsertFlowNodeNotify(list);
        }
    }

    private class ItemConfig {
        private String code;
        private String value;

        ItemConfig(String code, String value) {
            this.code = code;
            this.value = value;
        }
        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

}
