package yhao.micro.service.surety.business.dao.automapper;

import org.springframework.stereotype.Repository;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.complex.*;
import yhao.micro.service.surety.business.apilist.model.*;
import yhao.micro.service.surety.business.apilist.model.businessType.BusinessTypeModel;

import java.util.List;

/**
 * @Description
 * @Author leice
 * @Date 2018/12/19 19:54
 * @Version 1.0
 */
@Repository
public interface DiscountApplicationDao {

    DiscountApplicationInfoModel queryGuaranteeInfoById(String id);

    DiscountApplicationInfoModel queryDiscountSomeInfoById(String id);

    List<OwnerModel> queryOwnerInfoById(String id);

    List<BuyModel> queryBuyerInfoById(String id);

    List<PropertyModel> queryPropertyInfoById(String id);


    void discountApplicationSave(DiscountApplicationSaveForm form);

    DiscountApplicationByIdModel queryDiscountInfoById(String id);

    void updateDiscountReasonById(RestartDiscountSaveForm form);

    void updateDiscountStatusById(RestartDiscountSaveForm form);

    Pagination<DiscountApplicationModel> pageQueryDiscountApplication(Pagination page, ApplicationQueryForm form);

    BusinessTypeModel pickBusinessTypeByGuaranteeId(String guaranteeId);

    void updateGuaranteeInfoOne(RestartDiscountSaveForm form);

    void updateGuaranteeInfoTwo(RestartDiscountSaveForm form);

    void updateGuaranteeInfoThree(RestartDiscountSaveForm form);

    void updateLoanInfo(LoanDetailsInfoForm loanDetailsInfoForm);

    void updateLoanGeneralInfo(RestartDiscountSaveForm form);

    void updateDiscountStatus(String id);

    void restartDiscountStatusById(RestartDiscountSaveForm form);

    void delect(String id);

    void updateDiscountStatusHave(String guaranteeId);
}
