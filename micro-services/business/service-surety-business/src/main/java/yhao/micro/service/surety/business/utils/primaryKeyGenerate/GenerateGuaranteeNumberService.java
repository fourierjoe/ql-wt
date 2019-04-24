package yhao.micro.service.surety.business.utils.primaryKeyGenerate;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import yhao.infra.common.cache.RedisCache;
import yhao.infra.common.util.CommonDateUtil;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Description: redis组合guava生成担保单编号
 * @Created by ql on 2019/1/6 13:50
 * @Version: v1.0
 */
@Component
public class GenerateGuaranteeNumberService {
	@Resource
	private RedisCache redisCache;

	private static final String MAX_NUM = "MAX_NUM";

	/**
	 * redis步长,一次从redis获取的数量
	 */
	private static final int REDIS_STEP = 50;

	// 先获取本地缓存
	private Cache<String, Long> cache = CacheBuilder.newBuilder().maximumSize(50)
			.expireAfterAccess(CommonDateUtil.getTodayLeftSeconds(), TimeUnit.SECONDS)
			.build();

	/**
	 *
	 * @param orgId
	 * @param size 日期后生成编码长短
	 * @return
	 */
	public synchronized String generateGuaranteeNumber(String orgId, int size) {
		if (StringUtils.isEmpty(orgId)) {
			throw new RuntimeException("生成担保单编号城市组织ID不得为空...");
		}
		String currentDate = DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDate.now());
		StringBuilder sb = new StringBuilder(currentDate);


		long incr = 0;
		try {
			incr = cache.get(orgId.concat(currentDate), new Callable<Long>() {
				@Override
				public Long call() throws Exception {
					// 例如:获取当前redis值100
					long incr = redisCache.incr(PrimaryKeyCacheKey.GUARANTEE_NUM, orgId.concat(currentDate), REDIS_STEP, CommonDateUtil.getTodayLeftSeconds());
					// 返回起始值51
					cache.put("MAX_NUM", incr);
					return incr - REDIS_STEP + 1;
				}
			});
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		if (Optional.ofNullable(cache.getIfPresent(MAX_NUM)).orElse(0L)
				< Optional.ofNullable(cache.getIfPresent(orgId.concat(currentDate))).orElse(1L)) { //为null重新加载
			long maxNum = redisCache.incr(PrimaryKeyCacheKey.GUARANTEE_NUM, orgId.concat(currentDate), REDIS_STEP, CommonDateUtil.getTodayLeftSeconds());
			cache.put(MAX_NUM, maxNum);
			cache.put(orgId.concat(currentDate), maxNum - REDIS_STEP + 1);
		}

		int incrStrLen = String.valueOf(cache.getIfPresent(orgId.concat(currentDate))).length();
		for (int i = 0; i < size - incrStrLen; i++) {
			sb.append("0");
		}
		sb.append(cache.getIfPresent(orgId.concat(currentDate)));

		// 缓存自增加1
		cache.put(orgId.concat(currentDate), incr + 1);

		return sb.toString();
	}
	
}
