package com.netease.yidun.sdk.antispam.recover;

import com.netease.yidun.sdk.antispam.recover.recovery.RecoverManager;
import com.netease.yidun.sdk.core.client.Client;
import com.netease.yidun.sdk.core.exception.YidunSdkException;
import com.netease.yidun.sdk.core.response.BaseResponse;
import com.netease.yidun.sdk.core.response.CommonResponse;
import com.netease.yidun.sdk.core.utils.AssertUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RequestRecoverRegistry implements LifeCycle{
    private Map<Class<? extends BaseResponse>, BaseResponse> fallbackMap = new ConcurrentHashMap<>();
    private Map<Class<?>, AbstractRequestRecoverHandler> handlerMap = new ConcurrentHashMap<>();
    private Map<Class<?>, FileRequestRecover> recoverMap = new ConcurrentHashMap<>();
    private RecoverConfig recoverConfig;
    private RecoverManager recoverManager;

    public RequestRecoverRegistry(RecoverConfig recoverConfig) {
        this.recoverConfig = recoverConfig;
        this.recoverManager = new RecoverManager(recoverConfig);
    }

    /**
     * 注册文件恢复类到注册中心，此方法不是线程安全的，当前调用是在单线程的场景下
     *
     * @param responseClasses
     * @param recoverName
     * @param client
     */
    public void registerRecover(List<Class<?>> responseClasses, String recoverName, Client client) {
        if (responseClasses == null) {
            return;
        }
        FileRequestRecover recover = FileRequestRecover.createRecover(recoverConfig, recoverName, client, this);
        for (Class responseClass : responseClasses) {
            recoverMap.put(responseClass, recover);
        }
    }

    public FileRequestRecover getRecover(Class responseClass) {
        if (responseClass == null) {
            return null;
        }
        return recoverMap.get(responseClass);
    }

    public void registerRecoverHandler(AbstractRequestRecoverHandler handler) {
        AssertUtils.notNull(handler, "recoverHandler can not be null");

        Class clazz = handler.getClass();
        while (clazz.getSuperclass() != null && clazz.getSuperclass() != AbstractRequestRecoverHandler.class) {
            clazz = clazz.getSuperclass();
        }
        if (clazz == Object.class) {
            throw new IllegalArgumentException("not support class type");
        }

        Type type = clazz.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            try {
                Class<? extends CommonResponse> responseClass = (Class<? extends CommonResponse>) ((ParameterizedType) type).getActualTypeArguments()[0];
                handlerMap.put(responseClass, handler);
                if (getFallback(responseClass) != null) {
                    return;
                }
                CommonResponse defaultFallback = responseClass.newInstance();
                defaultFallback.setCode(200);
                defaultFallback.setMsg("default fallback response");
                registerFallback(defaultFallback);

            } catch (Exception e) {
                throw new YidunSdkException(e);
            }
        } else {
            throw new IllegalArgumentException("not support class type");
        }
    }

    public AbstractRequestRecoverHandler getRecoverHandler(Class responseClass) {
        if (responseClass == null) {
            return null;
        }
        return handlerMap.get(responseClass);
    }

    public <T extends BaseResponse> void registerFallback(T fallbackResponse) {
        if (fallbackResponse == null) {
            return;
        }
        fallbackMap.put(fallbackResponse.getClass(), fallbackResponse);
    }

    public <T extends BaseResponse> T getFallback(Class<T> clazz) {
        if (clazz == null) {
            return null;
        }
        BaseResponse fallbackResp = fallbackMap.get(clazz);
        if (fallbackResp == null) {
            return null;
        }
        return (T) fallbackResp;
    }

    @Override
    public void start() {
        if (recoverMap.size() == 0) {
            return;
        }
        for (FileRequestRecover recover : recoverMap.values()) {
            recover.start();
        }
        recoverManager.start();
    }

    @Override
    public void stop() {
        if (recoverMap.size() == 0) {
            return;
        }
        for (FileRequestRecover recover : recoverMap.values()) {
            recover.stop();
        }
        recoverManager.stop();
    }
}
