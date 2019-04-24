package yhao.micro.service.workflow.config;

import yhao.infra.common.cache.cachekey.CacheKeyType;

public enum WorkFlowCacheKey implements CacheKeyType {
    PROCESS_DEF("WORKFLOW"),
    PROCESS_DEF_ID("WORKFLOW")
    ;
    private String baseType;

    WorkFlowCacheKey(String baseType) {
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
