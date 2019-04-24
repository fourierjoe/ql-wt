package yhao.micro.web.surety.remote.workflow;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
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
import yhao.micro.service.workflow.apilist.restful.ProcessFeign;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProcessRemote {
    private Logger logger = LoggerFactory.getLogger(ProcessRemote.class);

    @Resource
    private ProcessFeign processFeign;

    /******************************节点******************************************************************/
    @HystrixCommand
    public void saveNodeTemplate(FlowNodeTemplateForm form) {
        processFeign.saveNodeTemplate(form);
    }

    @HystrixCommand
    public void saveMainNodeTemplate(@RequestBody FlowMainNodeTemplateForm form) {
        processFeign.saveMainNodeTemplate(form).pickBody();
    }

    @HystrixCommand
    public void saveSubNodeTemplate(@RequestBody FlowSubNodeTemplateForm form) {
        processFeign.saveSubNodeTemplate(form);
    }


    @HystrixCommand(fallbackMethod = "queryNodeTemplatePageDown")
    public Pagination<FlowNodeTemplateModel> queryNodeTemplatePage(FlowNodeTemplateQueryForm form) {
        return processFeign.queryNodeTemplatePage(form).pickBody();
    }
    public Pagination<FlowNodeTemplateModel> queryNodeTemplatePageDown(FlowNodeTemplateQueryForm form, Throwable e) {
        logger.error("Service Down:[ProcessService.queryNodeTemplatePage]");
        logger.error(e.getMessage(),e.getCause());
        return new Pagination<FlowNodeTemplateModel>();
    }

    @HystrixCommand
    public void deleteNodeTemplate(IdForm form) {
        processFeign.deleteNodeTemplate(form);
    }

    @HystrixCommand(fallbackMethod = "pickFlowCenterNodeByNameDown")
    public List<FlowNodeTemplateModel> pickFlowCenterNodeByName(FlowNodeNameForm form) {
        return processFeign.pickFlowCenterNodeByName(form).pickBody();
    }
    public List<FlowNodeTemplateModel> pickFlowCenterNodeByNameDown(FlowNodeNameForm form, Throwable e) {
        logger.error("Service Down:[ProcessService.pickFlowCenterNodeByName]");
        logger.error(e.getMessage(),e.getCause());
        return new ArrayList<FlowNodeTemplateModel>();
    }

    @HystrixCommand(fallbackMethod = "pickBizNodeByNameDown")
    public List<FlowNodeTemplateModel> pickBizNodeByName(BizNodeNameForm form) {
        return processFeign.pickBizNodeByName(form).pickBody();
    }
    public List<FlowNodeTemplateModel> pickBizNodeByNameDown(BizNodeNameForm form, Throwable e) {
        logger.error("Service Down:[ProcessService.pickBizNodeByName]");
        logger.error(e.getMessage(),e.getCause());
        return new ArrayList<FlowNodeTemplateModel>();
    }

    @HystrixCommand(fallbackMethod = "pickFlowCenterAllNodeDown")
    public List<FlowNodeTemplateModel> pickFlowCenterAllNode(FlowNodeTempleteForm form) {
        return processFeign.pickFlowCenterAllNode(form).pickBody();
    }
    public List<FlowNodeTemplateModel> pickFlowCenterAllNodeDown(FlowNodeTempleteForm form, Throwable e) {
        logger.error("Service Down:[ProcessService.pickFlowCenterAllNode]");
        logger.error(e.getMessage(),e.getCause());
        return new ArrayList<FlowNodeTemplateModel>();
    }

    @HystrixCommand(fallbackMethod = "pickBizAllNodeDown")
    public List<FlowNodeTemplateModel> pickBizAllNode(FlowNodeTempleteForm form) {
        return processFeign.pickBizAllNode(form).pickBody();
    }
    public List<FlowNodeTemplateModel> pickBizAllNodeDown(FlowNodeTempleteForm form, Throwable e) {
        logger.error("Service Down:[ProcessService.pickBizAllNode]");
        logger.error(e.getMessage(),e.getCause());
        return new ArrayList<FlowNodeTemplateModel>();
    }

    /******************************事项**********************************************/
    @HystrixCommand(fallbackMethod = "queryItemTemplatePageDown")
    public Pagination<FlowItemTemplateModel> queryItemTemplatePage(FlowNodeItemTemplateQueryForm form) {
        return processFeign.queryItemTemplatePage(form).pickBody();
    }
    public Pagination<FlowItemTemplateModel> queryItemTemplatePageDown(FlowNodeItemTemplateQueryForm form, Throwable e) {
        logger.error("Service Down:[ProcessService.queryItemTemplatePage]");
        logger.error(e.getMessage(),e.getCause());
        return new Pagination<FlowItemTemplateModel>();
    }

    @HystrixCommand
    public void deleteItemTemplate(IdForm form) {
        processFeign.deleteItemTemplate(form);
    }

    @HystrixCommand(fallbackMethod = "queryItemConfigDown")
    public Pagination<ItemConfigModel> queryItemConfig(ItemCodeForm form) {
        return processFeign.queryItemConfig(form).pickBody();
    }
    public Pagination<ItemConfigModel> queryItemConfigDown(ItemCodeForm form, Throwable e) {
        logger.error("Service Down:[ProcessService.queryItemConfig]");
        logger.error(e.getMessage(),e.getCause());
        return new Pagination<>();
    }

    @HystrixCommand
    public void saveNodeItemTemplate(FlowNodeItemTemplateSaveForm form) {
        processFeign.saveNodeItemTemplate(form);
    }

    /******************************流程定义****************************************************/
    @HystrixCommand(fallbackMethod = "queryProcessPageDown")
    public Pagination<FlowProcessDefinitionModel> queryProcessPage(FlowProcessQueryForm form) {
        return processFeign.queryProcessPage(form).pickBody();
    }
    public Pagination<FlowProcessDefinitionModel> queryProcessPageDown(FlowProcessQueryForm form, Throwable e) {
        logger.error("Service Down:[ProcessService.queryProcessPage]");
        logger.error(e.getMessage(),e.getCause());
        return new Pagination<FlowProcessDefinitionModel>();
    }


    @HystrixCommand
    public FlowProcessDefinitionForm saveProcessDefinition(FlowProcessDefinitionForm form) {
        return processFeign.saveProcessDefinition(form).pickBody();
    }

    @HystrixCommand
    public BizFlowProcessDefinitionForm saveBizProcessDefinition(BizFlowProcessDefinitionForm form) {
        return processFeign.saveBizProcessDefinition(form).pickBody();
    }

    @HystrixCommand
    public void updateBizCode(FlowProcessBizCodeChangeForm form) {
        processFeign.updateBizCode(form).pickBody();
    }

    @HystrixCommand(fallbackMethod = "searchNewestProcessDefinitionByCodeDown")
    public FlowProcessDefinitionModel searchNewestProcessDefinitionByCode(BizCodeForm form) {
        return processFeign.searchNewestProcessDefinitionByCode(form).pickBody();
    }
    public FlowProcessDefinitionModel searchNewestProcessDefinitionByCodeDown(BizCodeForm form, Throwable e) {
        logger.error("Service Down:[ProcessService.searchNewestProcessDefinitionByCode]");
        logger.error(e.getMessage(),e.getCause());
        return new FlowProcessDefinitionModel();
    }

    @HystrixCommand(fallbackMethod = "pickSubProcessIdDown")
    public List<SubProcessNameModel> pickSubProcessId(SubProcessNameQueryForm form) {
        return processFeign.pickSubProcessId(form).pickBody();
    }
    public List<SubProcessNameModel> pickSubProcessIdDown(SubProcessNameQueryForm form, Throwable e) {
        logger.error("Service Down:[ProcessService.pickSubProcessIdDown]");
        logger.error(e.getMessage(),e.getCause());
        return new ArrayList<SubProcessNameModel>();
    }

    @HystrixCommand(fallbackMethod = "pickProcessNodeIsDeleteDown")
    public Boolean pickProcessNodeIsDelete(IdForm form) {
        return processFeign.pickProcessNodeIsDelete(form).pickBody();
    }
    public Boolean pickProcessNodeIsDeleteDown(IdForm form, Throwable e) {
        logger.error("Service Down:[ProcessService.pickProcessNodeIsDelete]");
        logger.error(e.getMessage(),e.getCause());
        return Boolean.FALSE;
    }

}
