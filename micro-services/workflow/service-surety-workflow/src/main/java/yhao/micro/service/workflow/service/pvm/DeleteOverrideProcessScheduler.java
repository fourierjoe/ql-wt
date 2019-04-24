package yhao.micro.service.workflow.service.pvm;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import yhao.micro.service.workflow.dao.ProcessDao;

import javax.annotation.Resource;

/**
 * @Description:
 * @Created by ql on 2019/1/12 19:40
 * @Version: v1.0
 */
@Component
public class DeleteOverrideProcessScheduler {
	@Resource
	private ProcessDao processDao;

	@Scheduled(cron = "0 0 0 15 * ?") //每月15号凌晨12点
	public void deleteOverrideProcessScheduler() {
		processDao.deleteOverrideProcess();
	}
}
