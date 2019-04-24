package yhao.micro.service.surety.business.dao.automapper;

import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.finance.*;
import yhao.micro.service.surety.business.apilist.model.finance.FinanceArrivalDetailModel;
import yhao.micro.service.surety.business.apilist.model.finance.FinanceArrivalGeneralModel;
import yhao.micro.service.surety.business.apilist.model.finance.FinanceBillingDetailModel;
import yhao.micro.service.surety.business.apilist.model.finance.FinanceBillingGeneralModel;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Auther: yuanxy
 * @Date: 2019/1/8 15:58
 * @Description:
 */
public interface FinanceBillingArrivalDao {
    /**
     * 新增到账概况
     */
    Integer insertArrivalGeneral(FinanceArrivalGeneralModel arrivalGeneralModel);

    /**
     * 新增到账详情
     */
    Integer insertArrivalDetail(FinanceArrivalDetailModel arrivalDetailModel);

    /**
     * 到账概况
     **/
    FinanceArrivalGeneralModel pickArrivalGeneral(String guaranteeId);

    /**
     * 到账详情
     */
    FinanceArrivalDetailModel pickArrivalDetail(String id);
    /**
     * 到账概况更新
     */
    Integer updateArrivalGeneral(FinanceArrivalGeneralModel arrivalGeneralModel);
    /**
     * 删除到账详情
     */
    Integer arrivalDetailDel(String id);
    /**
     * 到账详情更新
     */
    Integer updateArrivalDetail(FinanceArrivalDetailModel arrivalDetailModel);

    /**
     * 确认到账
     */
    Integer confirmArrival(IdForm form);

    FinanceBillingGeneralModel pickBillingGeneral(String guaranteeId);

    Integer insertBillingGeneral(FinanceBillingGeneralModel billingModel);

    Integer insertBillingDetail(FinanceBillingSaveForm form);

    Integer updateBillingGeneral(FinanceBillingGeneralModel billingModel);

    FinanceBillingDetailModel pickBillingDetail(String id);

    Integer updateBillingDetail(FinanceBillingDetailModel detailModel);

    Integer confirmBilling(String guaranteeId);

   /**
     *累计出账金额
     * @param:
     * @return:
     * @auther: yuanxy
     * @date: 2019/1/14 17:25
     */
    BigDecimal pickBillingTotal(String id);
    /**
     *累计出账申请金额
     * @param:
     * @return:
     * @auther: yuanxy
     * @date: 2019/1/14 17:25
     */
    BigDecimal pickBillingApplyTotal(String id);

    /**
     * 到账分页查询
     * @param:
     * @return:
     * @auther: yuanxy
     * @date: 2019/2/26 11:40
     */
    void queryArrival(Pagination<FinanceArrivalBillingQueryResultForm> page, FinanceArrivalBillingQueryForm form);

    /**
     * 出账分页查询
     * @param:
     * @return:
     * @auther: yuanxy
     * @date: 2019/2/26 11:40
     */
    void queryBilling(Pagination<FinanceArrivalBillingQueryResultForm> page, FinanceArrivalBillingQueryForm form);

    /**
     * 转回出账查询
     * @param:
     * @return:
     * @auther: yuanxy
     * @date: 2019/2/26 11:40
     */
    List<FinanceBillingQueryResultBizForm> queryFundBilling(IdForm form);
    /**
     * 到账查询
     * @param:
     * @return:
     * @auther: yuanxy
     * @date: 2019/2/26 11:40
     */
    List<FinanceArrivalQueryResultForm> queryFundArrival(IdForm form);

    /**
     * 将第一次出账日期置空
     * @param:
     * @return:
     * @auther: yuanxy
     * @date: 2019/3/9 9:39
     */
    void updateFirstBillingDate(FinanceBillingGeneralModel billingGeneralModel);
    /**
     * 批量更新出账状态为删除
     * @param:
     * @return:
     * @auther: yuanxy
     * @date: 2019/3/9 10:03
     */
    void batchBillingDel(List<String> list);
}
