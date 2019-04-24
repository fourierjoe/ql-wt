package yhao.micro.service.workflow.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Description:
 * @Created by ql on 2019/1/6 13:50
 * @Version: v1.0
 */
public class SerialNumberUtil {

	private static final String TASK_ID_PREFIX = "P";

	/**
	 * 获取任务流水号`
	 * @return
	 */
	public static String generateSerialNumber() {
		StringBuffer sb = new StringBuffer(19);
		DateTimeFormatter yyyyMMddHHmmss = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		sb.append(TASK_ID_PREFIX).append(yyyyMMddHHmmss.format(LocalDateTime.now()));
		sb.append((int)((Math.random()*9+1)*1000));
		return sb.toString();
	}

}
