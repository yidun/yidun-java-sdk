package com.netease.yidun.sdk.antispam;

import com.netease.yidun.sdk.core.utils.AssertUtils;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 客户端注册器，用于保证单个secretId对应的客户端实例唯一
 */
public class ClientRegistry {
    private static final Map<String, BaseClient> clientMap = new ConcurrentHashMap<>();

    /**
     * 创建并注册client，如果已存在则直接返回
     * @param antispamRequester
     * @param clazz
     * @return
     * @param <T>
     */
    public static <T extends BaseClient> T register(AntispamRequester antispamRequester, Class<T> clazz) {
        AssertUtils.notNull(antispamRequester, "AntispamRequester can not be null");
        String key = new StringBuilder(antispamRequester.getClientProfile().getCredentials().getSecretId())
                .append(",").append(clazz.getName())
                .toString();

        return (T) Optional.ofNullable(clientMap.get(key)).orElseGet(() ->
                clientMap.computeIfAbsent(key, k -> {
                    try {
                        return clazz.getDeclaredConstructor(AntispamRequester.class).newInstance(antispamRequester);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
        );
    }
}
