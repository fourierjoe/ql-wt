package yhao.micro.service.workflow.apilist.restful;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.workflow.apilist.form.flow.*;
import yhao.micro.service.workflow.apilist.form.flow.processBussiness.BizFlowProcessDefinitionForm;
import yhao.micro.service.workflow.apilist.form.flow.processBussiness.ItemCodeForm;
import yhao.micro.service.workflow.apilist.form.flow.processCenter.FlowProcessDefinitionForm;
import yhao.micro.service.workflow.apilist.model.flow.*;

import java.util.List;

@FeignClient(ZoneConstants.FEIGN_URL)
public interface ProcessFeign {

    @RequestMapping(value = "/process/saveNodeTemplate",method = RequestMethod.POST)
    RequestResult<FlowNodeTemplateForm> saveNodeTemplate(FlowNodeTemplateForm form);

    @RequestMapping(value = "/process/saveMainNodeTemplate",method = RequestMethod.POST)
    RequestResult<FlowNodeTemplateForm> saveMainNodeTemplate(@RequestBody FlowMainNodeTemplateForm form);

    @RequestMapping(value = "/process/saveSubNodeTemplate",method = RequestMethod.POST)
    RequestResult<FlowNodeTemplateForm> saveSubNodeTemplate(@RequestBody FlowSubNodeTemplateForm form);

    @PostMapping("/process/queryNodeTemplatePage")
    RequestResult<Pagination<FlowNodeTemplateModel>> queryNodeTemplatePage(FlowNodeTemplateQueryForm form);

    @PostMapping("/process/deleteNodeTemplate")
    RequestResult<Boolean> deleteNodeTemplate(IdForm form);

    @PostMapping("/process/pickFlowCenterNodeByName")
    RequestResult<List<FlowNodeTemplateModel>> pickFlowCenterNodeByName(FlowNodeNameForm form);

    @PostMapping("/process/pickBizNodeByName")
    RequestResult<List<FlowNodeTemplateModel>> pickBizNodeByName(BizNodeNameForm form);

    @PostMapping("/process/pickFlowCenterAllNode")
    RequestResult<List<FlowNodeTemplateModel>> pickFlowCenterAllNode(FlowNodeTempleteForm form);

    @PostMapping("/process/pickBizAllNode")
    RequestResult<List<FlowNodeTemplateModel>> pickBizAllNode(FlowNodeTempleteForm form);

    /******************************************事项*************************************************/
    @PostMapping("/process/queryItemTemplatePage")
    RequestResult<Pagination<FlowItemTemplateModel>> queryItemTemplatePage(FlowNodeItemTemplateQueryForm form);

    @PostMapping("/process/deleteItemTemplate")
    RequestResult deleteItemTemplate(IdForm form);

    @PostMapping("/process/queryItemConfig")
    RequestResult<Pagination<ItemConfigModel>> queryItemConfig(ItemCodeForm form);

    /******************************************流程定义*************************************************/
    /**
     * 流程中心流程保存
     * @param form
     * @return
     */
    @PostMapping("/process/saveProcessDefinition")
    RequestResult<FlowProcessDefinitionForm> saveProcessDefinition(FlowProcessDefinitionForm form);

    /**
     * 业务流程保存
     * @param form
     * @return
     */
    @PostMapping("/process/saveBizProcessDefinition")
    RequestResult<BizFlowProcessDefinitionForm> saveBizProcessDefinition(BizFlowProcessDefinitionForm form);

    @PostMapping("/process/updateBizCode")
    RequestResult<FlowProcessBizCodeChangeForm> updateBizCode(FlowProcessBizCodeChangeForm form);

    @PostMapping("/process/saveNodeItemTemplate")
    RequestResult<FlowNodeItemTemplateSaveForm> saveNodeItemTemplate(FlowNodeItemTemplateSaveForm form);

    @PostMapping("/process/queryProcessPage")
    RequestResult<Pagination<FlowProcessDefinitionModel>> queryProcessPage(FlowProcessQueryForm form);

    @PostMapping("/process/searchNewestProcessDefinitionByCode")
    RequestResult<FlowProcessDefinitionModel> searchNewestProcessDefinitionByCode(BizCodeForm form);

    @PostMapping("/process/pickSubProcessId")
    RequestResult<List<SubProcessNameModel>> pickSubProcessId(SubProcessNameQueryForm form);

    @RequestMapping(value = "/process/pickProcessNodeIsDelete", method = RequestMethod.POST)
    RequestResult<Boolean> pickProcessNodeIsDelete(IdForm form);
}
