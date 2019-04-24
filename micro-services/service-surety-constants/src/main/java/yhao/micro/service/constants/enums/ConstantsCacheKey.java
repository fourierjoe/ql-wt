package yhao.micro.service.constants.enums;

import yhao.infra.common.cache.cachekey.CacheKeyType;

public enum ConstantsCacheKey implements CacheKeyType {
    /**登录session刷新**/
    MGR_SESSION_REFRESH("SURETY_SESSION_REFRESH");
    private String baseType;

    ConstantsCacheKey(String baseType) {
        this.baseType = baseType;
    }

    @Override
    public String getCacheKey() {
        return name();
    }

    @Override
    public String getBaseType() {
        return baseType;
    }

}