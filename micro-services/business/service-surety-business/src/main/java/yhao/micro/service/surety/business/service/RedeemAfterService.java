package yhao.micro.service.surety.business.service;

import org.apache.commons.lang.StringUtils;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.redemption.RDTAfterFollowQueryForm;
import yhao.micro.service.surety.business.apilist.form.redemption.RDTAfterFollowQueryResultForm;
import yhao.micro.service.surety.business.apilist.form.redemption.RedeemAfterSaveForm;
import yhao.micro.service.surety.business.apilist.model.redemption.RDTAfterFollowModel;
import yhao.micro.service.surety.business.dao.automapper.RedeemDao;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Optional;

/**
 * @Auther: yuanxy
 * @Date: 2019/1/2 11:12
 * @Description:赎楼后跟进逻辑实现相关
 */
@Service
public class RedeemAfterService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private DozerBeanMapper dozerMapper = new DozerBeanMapper();

    @Resource
    private RedeemDao redeemDao;


    /**
     * 赎楼后跟进查询
     * @param: 
     * @return: 
     * @auther: yuanxy
     * @date: 2019/3/2 17:27
     */
    public Pagination<RDTAfterFollowQueryResultForm> queryRedeemAfter(RDTAfterFollowQueryForm form) {
        Pagination<RDTAfterFollowQueryResultForm> page =new Pagination<RDTAfterFollowQueryResultForm>();
        redeemDao.queryRedeemAfter(page,form);
        return page;
    }


    /**
     *
     * 赎楼后跟进信息保存
     * @param: 
     * @return: 
     * @auther: yuanxy
     * @date: 2019/3/2 17:37
     */
    public Boolean redemptionAfterSave(RedeemAfterSaveForm form) {
        Optional.ofNullable(form.getPositionType()).orElseThrow((() ->new RuntimeException("业务类型不能为空")));
        RDTAfterFollowModel model = redeemDao.pickRedeemAfter(form.getGuaranteeId());

        if ("takeCert".equals(form.getPositionType())) {
            if(model !=null){
                throw new RuntimeException("该担保单已取过原证,请仔细核实");
            }
            model = new RDTAfterFollowModel();
            model.setTakeCertId(form.getCreateOperatorId());
            dozerMapper.map(form,model);
            Integer result = redeemDao.insertRedeemAfterFollow(model);
            if (result < 1) {
                logger.error("取新证时出错,担保单id" + form.getGuaranteeId());
                throw new RuntimeException("取新证失败,请稍后再试");
            }
        }
        dozerMapper.map(form,model);
        model.setUpdateOperatorId(form.getCreateOperatorId());
        model.setUpdateTime(new Date());
        if("certLogout".equals(form.getPositionType())){
            model.setCertLogoutId(form.getCreateOperatorId());
        }else if("transfer".equals(form.getPositionType())){
            model.setTransferId(form.getCreateOperatorId());
        }else if("takeNewCert".equals(form.getPositionType())){
            model.setTakeNewCertId(form.getCreateOperatorId());
        }else if("mortgage".equals(form.getPositionType())){
            model.setMortgageId(form.getCreateOperatorId());
        }
        redeemDao.updateRedeemAfter(model);

        return true;
    }
}
