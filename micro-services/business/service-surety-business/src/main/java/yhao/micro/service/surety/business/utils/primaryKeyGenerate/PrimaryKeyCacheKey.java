package yhao.micro.service.surety.business.utils.primaryKeyGenerate;

import yhao.infra.common.cache.cachekey.CacheKeyType;

/**
 * @Description:
 * @Created by ql on 2019/1/6 13:57
 * @Version: v1.0
 */
public enum PrimaryKeyCacheKey implements CacheKeyType {
	GUARANTEE_NUM("PRIMARY_ID");

	private String baseType;

	PrimaryKeyCacheKey(String baseType) {
		this.baseType = baseType;
	}

	@Override
	public String getBaseType() {
		return baseType;
	}

	@Override
	public String getCacheKey() {
		return name();
	}
}
