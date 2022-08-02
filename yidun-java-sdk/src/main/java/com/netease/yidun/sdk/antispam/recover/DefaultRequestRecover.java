package com.netease.yidun.sdk.antispam.recover;

import com.google.gson.Gson;
import com.netease.yidun.sdk.antispam.callback.AbstractCallbackHandler;
import com.netease.yidun.sdk.core.client.Client;
import com.netease.yidun.sdk.core.recover.RecoverMessage;
import com.netease.yidun.sdk.core.recover.RequestRecover;
import com.netease.yidun.sdk.core.request.BaseRequest;
import com.netease.yidun.sdk.core.response.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultRequestRecover extends WrapRecover<RecoverMessage> implements RequestRecover {

    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private Map<Class<? extends BaseResponse>, BaseResponse> fallbackMap = new HashMap<>();
    private Map<Class<?>, AbstractCallbackHandler> callbackHandlerMap = new HashMap<>();
    private Client client;
    private Gson gson = new Gson();

    public DefaultRequestRecover(RecoverConfig recoverConfig) {
        super(recoverConfig);
    }

    @Override
    public boolean doRecover(RecoverMessage message) {
        // 消息加入文件恢复
        recover(message);
        return true;
    }

    public void registerCallbackHandler(AbstractCallbackHandler callbackHandler) {
        if (callbackHandler == null) {
            return;
        }
        Type type = callbackHandler.getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            callbackHandlerMap.put((Class<?>) ((ParameterizedType) type).getActualTypeArguments()[0], callbackHandler);
        } else {
            throw new IllegalArgumentException("not support class type");
        }
    }

    public <T extends BaseResponse> void registerFallbackResponse(T fallbackResponse) {
        if (fallbackResponse == null) {
            return;
        }
        fallbackMap.put(fallbackResponse.getClass(), fallbackResponse);
    }

    @Override
    public <T extends BaseResponse> T getFallbackResponse(Class<T> clazz) {
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
    public boolean tryRecover(RecoverMessage data) {
        // 文件恢复成功之后根据返回的结果，调用对应的callbackHandler来处理
        BaseRequest request;
        try {
            Class<? extends BaseRequest> clazz = (Class<? extends BaseRequest>) Class.forName(data.getClazz());
            request = gson.fromJson(data.getMessage(), clazz);
            request.setRecover(true);
        } catch (Exception e) {
            log.error("recover message discard due to class not found or message invalid, class:{}, message:{}", data.getClazz(), data.getMessage(), e);
            return true;
        }

        BaseResponse response;
        try {
            response = client.execute(request);
        } catch (Exception e) {
            return false;
        }

        AbstractCallbackHandler callbackHandler = callbackHandlerMap.get(response.getClass());
        if (callbackHandler != null) {
            List respList = new ArrayList(1);
            respList.add(response);
            try {
                callbackHandler.handle(respList);
            } catch (Exception e) {
                log.error("recover message handler error, message:{}", data.getMessage());
                return false;
            }
        } else {
            log.error("recover message discard due to callback handler is not exist, message:{}", data.getMessage());
        }

        return true;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    protected String getDbName() {
        return null;
    }
}
