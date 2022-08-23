package com.netease.yidun.sdk.antispam.recover;

import com.netease.yidun.sdk.core.client.Client;
import com.netease.yidun.sdk.core.recover.RecoverMessage;
import com.netease.yidun.sdk.core.recover.RequestRecover;
import com.netease.yidun.sdk.core.response.BaseResponse;
import com.netease.yidun.sdk.core.utils.AssertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class DefaultRequestRecover implements RequestRecover,LifeCycle {

    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private RequestRecoverRegistry requestRecoverRegistry;

    private static volatile DefaultRequestRecover requestRecover;

    private DefaultRequestRecover(RecoverConfig recoverConfig) {
        AssertUtils.notBlank(recoverConfig.getRecoverFileDir(), "recoverFileDir should not be empty");
        requestRecoverRegistry = new RequestRecoverRegistry(recoverConfig);
    }

    public static DefaultRequestRecover createRecover(String recoverFileDir) {
        RecoverConfig recoverConfig = new RecoverConfig();
        recoverConfig.setRecoverFileDir(recoverFileDir);
        return createRecover(recoverConfig);
    }

    public static DefaultRequestRecover createRecover(RecoverConfig recoverConfig) {
        if (requestRecover == null) {
            synchronized (DefaultRequestRecover.class) {
                if (requestRecover == null) {
                    requestRecover = new DefaultRequestRecover(recoverConfig);
                }
            }
        }
        return requestRecover;
    }

    /**
     * 当前请求是否支持故障恢复
     *
     * @param responseClass
     * @return
     */
    @Override
    public boolean isSupport(Class<?> responseClass) {
        return requestRecoverRegistry.getRecoverHandler(responseClass) != null;
    }

    @Override
    public boolean doRecover(RecoverMessage message, Class<?> responseClass) {
        // 消息加入文件恢复
        FileRequestRecover fileRequestRecover = requestRecoverRegistry.getRecover(responseClass);
        if (fileRequestRecover == null) {
            return false;
        }
        try {
            fileRequestRecover.recover(message);
            return true;
        } catch (Exception e) {
            log.error("recover request fails ", e);
            return false;
        }
    }

    /**
     * clientProfile设置了请求恢复，且各个业务的client支持文件恢复时，每个client都会创建一个独立的file recover。
     *
     * @param responseClasses 请求的response的类
     * @param recoverName     每个业务对应的文件恢复的文件标识
     * @param client          用于执行请求恢复的client，每个client可能存在不同的clientProfile
     */
    public void registerRecover(List<Class<?>> responseClasses, String recoverName, Client client) {
        requestRecoverRegistry.registerRecover(responseClasses, recoverName, client);
    }

    /**
     * 不同请求的response类，注册对应的handler，如果多个请求的response类相同，则只能注册一个handler
     *
     * @param handler 请求恢复成功后，业务方处理请求结果的handler
     */
    public void registerRecoverHandler(AbstractRequestRecoverHandler handler) {
        requestRecoverRegistry.registerRecoverHandler(handler);
    }

    /**
     * 当请求失败时，默认返回的请求结果
     *
     * @param fallbackResponse 默认返回的结果
     * @param <T>
     */
    public <T extends BaseResponse> void registerFallback(T fallbackResponse) {
        requestRecoverRegistry.registerFallback(fallbackResponse);
    }

    @Override
    public <T extends BaseResponse> T getFallbackResponse(Class<T> responseClass) {
        return requestRecoverRegistry.getFallback(responseClass);
    }

    @Override
    public void start() {
        requestRecoverRegistry.start();
    }

    @Override
    public void stop() {
        requestRecoverRegistry.stop();
    }
}
