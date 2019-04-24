package yhao.micro.service.surety.business.dao.automapper;

import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.complex.*;
import yhao.micro.service.surety.business.apilist.model.complex.*;

import java.util.List;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/6 14:44
 * @Description:综合管理dao
 */
public interface ComplexDao {
    /**
     * 分页查询所有保函
     */
    void queryRedemptionEnsure(Pagination<EnsureQueryResultForm> pagination, EnsureQueryForm queryForm);

    /**
     * 保函寄出
     */
    Integer insertRedemptionEnsure(RedemptionEnsureModel model);

    /**
     * 更新保函内容
     */
    Integer updateRedemptionEnsure(RedemptionEnsureModel model);

    void queryEssentials(Pagination<RedemptionEssentialsTakeModel> page, ComplexRedemptionBaseQueryForm form);

    RedemptionEnsureModel selectByGuaranteePid(String guaranteePid);

    /**
     * 查询担保单要件
     */
    RedemptionEssentialsTakeModel pickEssentialsByGuaranteePid(String guaranteePid);

    /**
     * 新增要件
     */
    Integer insertEssentials(RedemptionEssentialsTakeModel takeModel);

    /**
     * 新增借出资料
     */
    Integer insertEssentialsLend(MaterialLendModel model);

    /**
     * 新增归还资料
     */
    Integer insertEssentialsRemand(MaterialRemandModel model);

    /**
     * 查询借出材料
     */
    MaterialLendModel pickEssentialsLend(String id);

    /**
     * 更新借出材料
     */
    Integer updateEssentialsLend(MaterialLendModel lendModel);

    Integer updateEssentials(RedemptionEssentialsTakeModel takeModel);

    /**
     * 查询归还材料
     */
    MaterialRemandModel pickEssentialsRemand(String id);

    /**
     * 更新归还材料
     */
    Integer updateEssentialsRemand(MaterialRemandModel remandModel);

    /**
     * 新增指令
     */
    Integer insertRedeemOrder(RedemptionOrderModel model);

    /**
     * 更新指令
     */
    Integer updateRedeemOrder(RedemptionOrderModel model);

    RedeemOrderConfigForm pickOrderConfig(IdForm form);

    /**
     * 查询担保单物业信息
     */
    List<EstateOfSellerQueryForm> queryEstateOfSeller(String guaranteePid);

    /**
     * 查询反担保人物业信息
     */
    List<AntiGuaranteeQueryForm> queryAntiGuarantee(String guaranteePid);

    /**
     * 新增出账前核查信息
     */
    Integer insertBillingCheck(BillingCheckModel model);

    Integer insertBillingSituation(List<BillingCaseSituationModel> modelList);

    BillingCheckModel pickBillingCheck(String guaranteePid);

    Integer updateBillingCheck(BillingCheckModel checkModel);

    Integer insertBillingQueryRecord(BillingQueryFileRecordModel model);

    Integer updateBillingCaseSituation(BillingCaseSituationModel model);

    BillingCheckDetailForm queryBillingCheckQueryResult(IdForm form);

    List<BillingQueryFileRecordModel> queryFileRecord(IdForm form);

    /**
     * 查询归档信息
     */
    void queryMaterialArchive(Pagination<RedemptionBaseResultForm> page, ComplexRedemptionBaseQueryForm form);

    /**
     * 新增归档信息
     */
    Integer materialArchiveSave(MaterialArchiveModel form);

    List<SecondmentDetailResultForm> querySecondmentDetail(SecondmentDetailQueryForm form);

    /**
     * 解保列表查询
     */
    void queryUnProtected(Pagination<UnProtectedQueryResultForm> page, UnprotectedQueryForm form);
    /**
     * 解保
     */
    Integer unProtectedSave(UnProtectedSaveForm form);
    /**
     * 指令查询
     */
    void queryRedemptionOrder(Pagination<OrderQueryResultForm> page, OrderQueryForm form);
}
