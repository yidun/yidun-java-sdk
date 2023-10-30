package com.netease.yidun.sdk.antispam;

import com.netease.yidun.sdk.antispam.callback.AbstractCallbackHandler;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * callback注册器，用于保证单个secretId和businessId对应的callback轮询实例唯一
 */
public class CallbackRegistry {
    private static final Map<String, AbstractCallbackHandler> callbackMap = new ConcurrentHashMap<>();

    /**
     * 注册并启动callback
     *
     * @param requester
     * @param callbacks
     */
    public static void register(AntispamRequester requester, AbstractCallbackHandler... callbacks) {
        if (callbacks != null && callbacks.length > 0) {
            for (AbstractCallbackHandler callback : callbacks) {
                if (callback.getAntispamRequester() == null) {
                    callback.setAntispamRequester(requester);
                }
                String key = new StringBuilder(callback.getAntispamRequester().getClientProfile().getCredentials().getSecretId())
                        .append(",").append(callback.getProfile().getBusinessId())
                        .append(",").append(callback.getClass().getName())
                        .toString();
                if (callbackMap.get(key) == null) {
                    callbackMap.computeIfAbsent(key, k -> {
                        callback.start();
                        return callback;
                    });
                }
            }
        }
    }

    /**
     * 获取所有启动的callback
     *
     * @return
     */
    public static Collection<AbstractCallbackHandler> all() {
        return Collections.unmodifiableCollection(callbackMap.values());
    }

}
