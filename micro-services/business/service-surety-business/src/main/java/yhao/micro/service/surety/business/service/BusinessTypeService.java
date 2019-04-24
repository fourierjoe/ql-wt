package yhao.micro.service.surety.business.service;

import com.alibaba.fastjson.JSONArray;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.businessType.BusinessTypeQueryForm;
import yhao.micro.service.surety.business.apilist.form.businessType.BusinessTypeSaveForm;
import yhao.micro.service.surety.business.apilist.form.businessType.OrgIdForm;
import yhao.micro.service.surety.business.apilist.model.businessType.BusinessTypeModel;
import yhao.micro.service.surety.business.apilist.model.businessType.BusinessTypeNameModel;
import yhao.micro.service.surety.business.dao.automapper.BusinessTypeDao;
import yhao.micro.service.workflow.apilist.form.flow.processBussiness.BizFlowProcessDefinitionForm;
import yhao.micro.service.workflow.apilist.restful.ProcessFeign;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @Description:
 * @Created by ql on 2018/12/19 11:02
 * @Version: v1.0
 */
@Service
public class BusinessTypeService {

    @Resource
    private BusinessTypeDao businessTypeDao;
    @Resource
    private ProcessFeign processFeign;

    @Transactional
    public BusinessTypeSaveForm saveBusinessType(BusinessTypeSaveForm form) {
        checkInterface(form);

        form.getBizFlowProcessDefinitionForm().setOperatorId(form.getOperatorId());
        RequestResult<BizFlowProcessDefinitionForm> bizFlowProcessDefinitionFormRequestResult = processFeign.saveBizProcessDefinition(form.getBizFlowProcessDefinitionForm());
        if (!bizFlowProcessDefinitionFormRequestResult.isSuccess()) {
            throw new RuntimeException("主流程保存接口调用失败");
        }

        boolean successFlag;
        form.setWorkflowBizCode(bizFlowProcessDefinitionFormRequestResult.pickBody().getBizCodeStr());
        if (StringUtils.isEmpty(form.getId())) {
            form.setId(UUID.randomUUID().toString());//SURETY.IX_BUSINESS_TYPE_N03

            try {
                successFlag = businessTypeDao.insertBusinessType(form) > 0;
            } catch (Throwable e) {
                Throwable cause = e.getCause();
                if(cause instanceof org.springframework.dao.DuplicateKeyException) {
                    String errMsg = cause.getMessage();
                    if(StringUtils.isNotBlank(errMsg) && errMsg.indexOf("SURETY.IX_BUSINESS_TYPE_N03")!=-1) {
                        throw new RuntimeException("同一城市下业务类型名称不能重复！");
                    }
                }
                throw e;

            }
        } else {
            successFlag = businessTypeDao.updateBusinessType(form) > 0;
        }

        if (!successFlag) {
            throw new RuntimeException("业务类型配置保存或修改失败,请重试...");
        }

        return form;
    }

    public Pagination<BusinessTypeModel> queryBusinessTypePage(BusinessTypeQueryForm form) {
        var page = new Pagination<BusinessTypeModel>(form.getPageSize(), form.getCurrentPage());
        businessTypeDao.queryBusinessTypePage(page, form);
        return page;
    }

    public BusinessTypeModel pickBusinessTypeById(IdForm form) {
        return businessTypeDao.pickBusinessTypeById(form.getId());
    }

    public List<BusinessTypeNameModel> queryBusinessTypeAllName(OrgIdForm form) {
        return businessTypeDao.queryBusinessTypeAllName(form);
    }

    private void checkInterface(BusinessTypeSaveForm form) {
        // [{overdueDays:逾期天数，rate:费率}]
        try {
            List<OverdueRateJson> overdueRateJsons = JSONArray.parseArray(form.getOverdueRateJson(), OverdueRateJson.class);
            overdueRateJsons.forEach(overdueRateJson -> {
                if (overdueRateJsonIsNull(overdueRateJson)) {
                    throw new RuntimeException("逾期天数或费率必填");
                }
            });
        } catch (Exception e) {
            throw new RuntimeException("输入overdueRateJson非法,请检查");
        }

        // [{materialId：资料id，name:资料名字, checked:boolean, weight:number, count：数量}]
        try {
            List<MaterialJson> materialJsons = JSONArray.parseArray(form.getMaterialJson(), MaterialJson.class);
            materialJsons.forEach(materialJson -> {
                if (materialJsonIsNull(materialJson)) {
                    throw new RuntimeException("资料id或数量或顺序必填");
                }
            });
        } catch (Exception e) {
            throw new RuntimeException("输入materialJsons非法,请检查");
        }
    }

    private boolean overdueRateJsonIsNull(OverdueRateJson overdueRateJson) {
        return overdueRateJson.getOverdueDays() == null || overdueRateJson.getRate() == null;
    }
    private boolean materialJsonIsNull(MaterialJson materialJson) {
        return materialJson.getMaterialId() == null || materialJson.getCount() == null || materialJson.getWeight() == null;
    }

    private static class OverdueRateJson {
        private Integer overdueDays;
        private Double rate;

        public Integer getOverdueDays() {
            return overdueDays;
        }

        public void setOverdueDays(Integer overdueDays) {
            this.overdueDays = overdueDays;
        }

        public Double getRate() {
            return rate;
        }

        public void setRate(Double rate) {
            this.rate = rate;
        }
    }

    private static class MaterialJson {
        private String materialId;
        private String name;
        private String checked;
        private Integer weight;
        private Integer count;

        public String getMaterialId() {
            return materialId;
        }

        public void setMaterialId(String materialId) {
            this.materialId = materialId;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getChecked() {
            return checked;
        }

        public void setChecked(String checked) {
            this.checked = checked;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }
    }
}
