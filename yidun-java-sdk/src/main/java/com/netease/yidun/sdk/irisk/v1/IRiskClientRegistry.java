package com.netease.yidun.sdk.irisk.v1;

import com.netease.yidun.sdk.core.client.ClientProfile;
import com.netease.yidun.sdk.core.utils.AssertUtils;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 客户端注册器，用于保证单个secretId对应的客户端实例唯一
 */
public class IRiskClientRegistry {
    private static final Map<String, Object> clientMap = new ConcurrentHashMap<>();

    /**
     * 创建并注册client，如果已存在则直接返回
     * @param profile
     * @param clazz
     * @return
     * @param <T>
     */
    public static <T> T register(ClientProfile profile, Class<T> clazz) {
        AssertUtils.notNull(profile, "ClientProfile can not be null");
        String key = new StringBuilder(profile.getCredentials().secretId())
                .append(",").append(clazz.getName())
                .toString();

        return (T) Optional.ofNullable(clientMap.get(key)).orElseGet(() ->
                clientMap.computeIfAbsent(key, k -> {
                    try {
                        return clazz.getDeclaredConstructor(ClientProfile.class).newInstance(profile);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
        );
    }
}
