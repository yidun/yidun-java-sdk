package com.netease.yidun.sdk.antispam;

import com.netease.yidun.sdk.core.client.ClientProfile;
import com.netease.yidun.sdk.core.utils.AssertUtils;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * AntispamRequester注册器，用于保证单个secretId对应的AntispamRequester实例唯一
 */
public class AntispamRequesterRegistry {
    private static final Map<String, AntispamRequester> requesterMap = new ConcurrentHashMap<>();

    /**
     * 创建并注册AntispamRequester，如果已存在则直接返回
     *
     * @param secretId
     * @param secretKey
     * @return
     */
    public static AntispamRequester register(String secretId, String secretKey) {
        AssertUtils.notBlank(secretId, "secretId can not be null or empty");
        String key = secretId;
        return Optional.ofNullable(requesterMap.get(key)).orElseGet(() ->
                requesterMap.computeIfAbsent(key, k -> new AntispamRequester(secretId, secretKey))
        );
    }

    /**
     * 创建并注册AntispamRequester，如果已存在则直接返回
     *
     * @param clientProfile
     * @return
     */
    public static AntispamRequester register(ClientProfile clientProfile) {
        AssertUtils.notNull(clientProfile, "clientProfile can not be null");
        AssertUtils.notNull(clientProfile.credentials(), "credentials can not be null");
        AssertUtils.notBlank(clientProfile.credentials().secretId(), "secretId can not be null or empty");
        String key = clientProfile.credentials().secretId();
        return Optional.ofNullable(requesterMap.get(key)).orElseGet(() ->
                requesterMap.computeIfAbsent(key, k -> new AntispamRequester(clientProfile))
        );
    }
}
