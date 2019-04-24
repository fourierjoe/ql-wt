package yhao.micro.service.surety.baseconfig.mq;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import yhao.infra.common.CommonStatusEnum;
import yhao.infra.common.util.CommonDateUtil;
import yhao.infra.feature.activemq.ActiveMqAbstractListener;
import yhao.micro.service.surety.baseconfig.apilist.form.PartnerQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.StatusChangeForm;
import yhao.micro.service.surety.baseconfig.apilist.model.PartnerModel;
import yhao.micro.service.surety.baseconfig.constant.AmqDestination;
import yhao.micro.service.surety.baseconfig.service.PartnerService;

import javax.annotation.Resource;
import javax.jms.Message;
import java.util.Date;
import java.util.List;

/**
 * Created by yoara on 2017/12/25.
 */
@Service("partnerListener")
@EnableJms
public class PartnerListener extends ActiveMqAbstractListener {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private PartnerService partnerService;

    @Override
    @JmsListener(containerFactory = "baseConfigQueueContainerFactory", destination = AmqDestination.Q_PARTNER_CHECK)
    protected void doTask(Message message) {
        logger.info("[PartnerListener] 合作方到期日检查 开始");
        try {
            PartnerQueryForm queryForm = new PartnerQueryForm();
            queryForm.setMaxAgreementEndDate(CommonDateUtil.addDay(new Date(),-1));
            List<PartnerModel> partnerModelList = partnerService.query(queryForm);
            if (CollectionUtils.isNotEmpty(partnerModelList)) {
                StatusChangeForm statusChangeForm = new StatusChangeForm();
                statusChangeForm.setStatus(CommonStatusEnum.DISABLED);
                partnerModelList.forEach(partnerModel -> {
                    statusChangeForm.setId(partnerModel.getId());
                    partnerService.statusChange(statusChangeForm);
                    logger.info("合作方公：" + partnerModel.getCompanyName() + "。到期被禁用");
                });
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        logger.info("[PartnerListener] 合作方到期日检查 完成");
    }
}
