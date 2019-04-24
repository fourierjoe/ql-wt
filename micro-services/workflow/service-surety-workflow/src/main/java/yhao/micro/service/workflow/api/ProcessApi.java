package yhao.micro.service.workflow.api;

import com.google.common.collect.Maps;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.web.bind.annotation.*;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.RestfulBaseController;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.workflow.apilist.enums.flow.FlowNodeType;
import yhao.micro.service.workflow.apilist.form.flow.*;
import yhao.micro.service.workflow.apilist.form.flow.processBussiness.BizFlowProcessDefinitionForm;
import yhao.micro.service.workflow.apilist.form.flow.processBussiness.ItemCodeForm;
import yhao.micro.service.workflow.apilist.form.flow.processCenter.FlowProcessDefinitionForm;
import yhao.micro.service.workflow.apilist.model.flow.*;
import yhao.micro.service.workflow.service.ProcessService;
import yhao.micro.service.workflow.service.pvm.ProcessSearcher;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * 流程管理Api
 */
@RestController
@RequestMapping(value = "/process")
public class ProcessApi extends RestfulBaseController {
    @Resource
    private ProcessService processService;

    @Resource
    private ProcessSearcher processSearcher;
    private Mapper mapper = new DozerBeanMapper();

    /***********************************节点*************************************************/
    @PostMapping("/saveNodeTemplate")
    public RequestResult<FlowNodeTemplateForm> saveNodeTemplate(@RequestBody FlowNodeTemplateForm form){
        return new RequestResult(processService.saveNodeTemplate(form));
    }

    @PostMapping("/saveMainNodeTemplate")
    public RequestResult<FlowNodeTemplateForm> saveMainNodeTemplate(@RequestBody FlowMainNodeTemplateForm form){
        FlowNodeTemplateForm flowNodeTemplateForm = mapper.map(form, FlowNodeTemplateForm.class);
        return new RequestResult(processService.saveNodeTemplate(flowNodeTemplateForm));
    }

    @PostMapping("/saveSubNodeTemplate")
    public RequestResult<FlowSubNodeTemplateForm> saveSubNodeTemplate(@RequestBody FlowSubNodeTemplateForm form){
        FlowNodeTemplateForm flowNodeTemplateForm = mapper.map(form, FlowNodeTemplateForm.class);
        return new RequestResult(processService.saveNodeTemplate(flowNodeTemplateForm));
    }

    @PostMapping("/queryNodeTemplatePage")
    public RequestResult<Pagination<FlowNodeTemplateModel>> queryNodeTemplatePage(@RequestBody FlowNodeTemplateQueryForm form){
        return new RequestResult(processService.queryNodeTemplatePage(form));
    }

    @PostMapping("/deleteNodeTemplate")
    public RequestResult<Boolean> deleteNodeTemplate(@RequestBody IdForm form){
        return new RequestResult(processService.deleteNodeTemplate(form));
    }

    @PostMapping("/pickFlowCenterNodeByName")
    public RequestResult<List<FlowNodeModel>> pickFlowCenterNodeByName(@RequestBody FlowNodeNameForm form) {
        return new RequestResult(processService.pickFlowCenterNodeByName(form));
    }

    @PostMapping("/pickBizNodeByName")
    public RequestResult<FlowNodeTemplateModel> pickBizNodeByName(@RequestBody BizNodeNameForm form) {
        FlowNodeNameForm flowNodeNameForm = mapper.map(form, FlowNodeNameForm.class);
        return new RequestResult(processService.pickFlowCenterNodeByName(flowNodeNameForm));
    }

    @PostMapping("/pickFlowCenterAllNode")
    public RequestResult<List<FlowNodeTemplateModel>> pickFlowCenterAllNode(@RequestBody FlowNodeTempleteForm form) {
        form.setNodeType(FlowNodeType.SUB);
        return new RequestResult(processService.pickAllNode(form));
    }

    /**
     * 流程配置中主节点
     * @param form
     * @return
     */
    @PostMapping("/pickBizAllNode")
    public RequestResult<List<FlowNodeTemplateModel>> pickBizAllNode(@RequestBody FlowNodeTempleteForm form) {
        form.setNodeType(FlowNodeType.MAIN);
        return new RequestResult(processService.pickAllNode(form));
    }


    /***********************************事项*************************************************/
    @PostMapping("/saveNodeItemTemplate")
    public RequestResult<FlowNodeItemTemplateSaveForm> saveNodeItemTemplate(@RequestBody FlowNodeItemTemplateSaveForm form){
        return new RequestResult(processService.saveNodeItemTemplate(form));
    }

    @PostMapping("/queryItemTemplatePage")
    public RequestResult<Pagination<FlowItemTemplateModel>> queryItemTemplatePage(@RequestBody FlowNodeItemTemplateQueryForm form){
        return new RequestResult(processService.queryItemTemplatePage(form));
    }

    @PostMapping("/queryItemConfig")
    public RequestResult<Pagination<ItemConfigModel>> queryItemConfig(@RequestBody ItemCodeForm form){
        return new RequestResult(processService.queryItemConfig(form));
    }

    @PostMapping("/deleteItemTemplate")
    public RequestResult<Boolean> deleteItemTemplate(@RequestBody IdForm form){
        return new RequestResult(processService.deleteItemTemplate(form));
    }

    /***********************************流程定义*************************************************/

    /**
     * 流程中心流程定义保存
     * @param form
     * @return
     */
    @PostMapping("/saveProcessDefinition")
    public RequestResult<FlowProcessDefinitionForm> saveProcessDefinition(@RequestBody FlowProcessDefinitionForm form){
        return new RequestResult(processService.saveProcessDefinition(form));
    }

    /**
     * 业务类型设置流程定义保存
     * @param form
     * @return
     */
    @PostMapping("/saveBizProcessDefinition")
    public RequestResult<BizFlowProcessDefinitionForm> saveBizProcessDefinition(@RequestBody BizFlowProcessDefinitionForm form){
        return new RequestResult(processService.saveBizProcessDefinition(form));
    }

    @PostMapping("/updateBizCode")
    public RequestResult<FlowProcessBizCodeChangeForm> updateBizCode(@RequestBody FlowProcessBizCodeChangeForm form){
        return new RequestResult(processService.updateBizCode(form));
    }


    @PostMapping("/queryProcessPage")
    public RequestResult<Pagination<FlowProcessDefinitionModel>> queryProcessPage(@RequestBody FlowProcessQueryForm form){
        return new RequestResult(processService.queryProcessPage(form));
    }

    /**
     * 此方法禁用
     * @param form
     * @return
     */
    @Deprecated
    @PostMapping("/pickProcessDefinitionByBizCod")
    public RequestResult<BizFlowProcessDefinitionModel> pickProcessDefinitionByBizCod(@RequestBody BizCodeForm form){
        return new RequestResult(processService.pickProcessDefinitionByBizCod(form));
    }

    /**
     * 根据业务码查询流程所有信息
     * @param form
     * @return
     */
    @PostMapping("/searchNewestProcessDefinitionByCode")
    public RequestResult<FlowProcessDefinitionModel> searchNewestProcessDefinitionByCode(@RequestBody BizCodeForm form){
        FlowProcessDefinitionModel flowProcessDefinitionModel = processSearcher.searchNewestProcessDefinitionByCode(form.getBizCode());
        Map<Integer, FlowNodeModel> returnNodeMap = Maps.newLinkedHashMap();

        List<FlowTransitionModel> tranList = flowProcessDefinitionModel.getTranList();
        tranList.sort(new Comparator<FlowTransitionModel>() { //升序排列
            @Override
            public int compare(FlowTransitionModel o1, FlowTransitionModel o2) {
                return o1.getDestinationNodeOrder() - o2.getDestinationNodeOrder();
            }
        });
        Map<String, FlowNodeModel> nodeMap = flowProcessDefinitionModel.getNodeMap();
        for (FlowTransitionModel flowTransitionModel: tranList) {
            returnNodeMap.put(flowTransitionModel.getDestinationNodeOrder(), nodeMap.get(flowTransitionModel.getDestinationId()));
        }
        returnNodeMap.put(((Integer) returnNodeMap.keySet().toArray()[0]) - 1,flowProcessDefinitionModel.getInitial());
        flowProcessDefinitionModel.setReturnNodeMap(returnNodeMap);
        return new RequestResult(flowProcessDefinitionModel);
    }


    @RequestMapping(value = "/pickSubProcessId", method = RequestMethod.POST)
    public RequestResult<List<SubProcessNameModel>> pickSubProcessId(@RequestBody SubProcessNameQueryForm form) {
        return new RequestResult(processService.pickSubProcessId(form));
    }

    /**
     * 流程编辑查询节点是否可删
     * @param form 传入节点ID
     * @return
     */
    @RequestMapping(value = "/pickProcessNodeIsDelete", method = RequestMethod.POST)
    public RequestResult<Boolean> pickProcessNodeIsDelete(@RequestBody IdForm form) {
        return new RequestResult(processService.pickProcessNodeIsDelete(form.getId()));
    }
}
