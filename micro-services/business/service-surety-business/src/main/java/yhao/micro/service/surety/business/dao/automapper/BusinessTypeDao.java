package yhao.micro.service.surety.business.dao.automapper;

import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.businessType.BusinessTypeQueryForm;
import yhao.micro.service.surety.business.apilist.form.businessType.BusinessTypeSaveForm;
import yhao.micro.service.surety.business.apilist.form.businessType.OrgIdForm;
import yhao.micro.service.surety.business.apilist.model.businessType.BusinessTypeModel;
import yhao.micro.service.surety.business.apilist.model.businessType.BusinessTypeNameModel;
import yhao.micro.service.surety.business.apilist.model.guarantee.BizFundTypeAndTransactionTypeModel;

import java.util.List;

/**
 * @Description:
 * @Created by ql on 2018/12/19 11:05
 * @Version: v1.0
 */
public interface BusinessTypeDao {

    int insertBusinessType(BusinessTypeSaveForm form);

    int updateBusinessType(BusinessTypeSaveForm form);

    List<BusinessTypeModel> queryBusinessTypePage(Pagination<BusinessTypeModel> page, BusinessTypeQueryForm form);

    BusinessTypeModel pickBusinessTypeById(String id);

    List<BusinessTypeNameModel> queryBusinessTypeAllName(OrgIdForm form);

    BizFundTypeAndTransactionTypeModel pickBusinessType(String id);
}
