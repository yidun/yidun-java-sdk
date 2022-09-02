package com.netease.yidun.sdk.antispam.recover;

import com.google.gson.Gson;
import com.netease.yidun.sdk.core.client.Client;
import com.netease.yidun.sdk.core.client.DefaultClient;
import com.netease.yidun.sdk.core.recover.RecoverMessage;
import com.netease.yidun.sdk.core.request.BaseRequest;
import com.netease.yidun.sdk.core.response.BaseResponse;
import com.netease.yidun.sdk.core.utils.AssertUtils;
import com.netease.yidun.sdk.core.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FileRequestRecover extends WrapRecover<RecoverMessage> {

    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final Map<String, Client> clientMap;
    private final Gson gson = new Gson();
    private final RequestRecoverRegistry registry;
    private final String dbFileName;

    private FileRequestRecover(RecoverConfig recoverConfig, String dbFileName, RequestRecoverRegistry registry) {
        super(recoverConfig, dbFileName);
        AssertUtils.notBlank(recoverConfig.getRecoverFileDir(), "recoverFileDir should not be empty");
        this.clientMap = new ConcurrentHashMap<>();
        this.registry = registry;
        this.dbFileName = dbFileName;
    }

    public static FileRequestRecover createRecover(RecoverConfig recoverConfig, String dbFileName, RequestRecoverRegistry registry) {
        return new FileRequestRecover(recoverConfig, dbFileName, registry);
    }

    public void addClient(DefaultClient client) {
        String secretId = client.credentials().secretId();
        if (StringUtils.isBlank(secretId)) {
            return;
        }
        clientMap.putIfAbsent(secretId, client);
    }

    @Override
    public boolean tryRecover(RecoverMessage data) {
        // 文件恢复成功之后根据返回的结果，调用对应的callbackHandler来处理
        BaseRequest request;
        try {
            Class<? extends BaseRequest> clazz = (Class<? extends BaseRequest>) Class.forName(data.getClazz());
            request = gson.fromJson(data.getMessage(), clazz);
            request.setEnableRecover(false);
        } catch (Exception e) {
            log.error("recover message discard due to class not found or message invalid, class:{}, message:{}", data.getClazz(), data.getMessage(), e);
            return true;
        }

        Client client = clientMap.get(data.getSecretId());
        if (client == null) {
            log.error("recover message discard due to client not found, secretId:{}, message:{}", data.getSecretId(), data.getMessage());
            return true;
        }

        BaseResponse response;
        try {
            response = client.execute(request);
        } catch (Exception e) {
            log.warn("recover {} fail {}", dbFileName, e);
            return false;
        }

        AbstractRequestRecoverHandler handler = registry.getRecoverHandler(response.getClass());
        if (handler != null) {
            try {
                handler.handle(response);
            } catch (Exception e) {
                log.error("recover message handler error, message:{}", data.getMessage());
                return false;
            }
        } else {
            log.error("recover message discard due to request recover handler is not exist, message:{}", data.getMessage());
        }

        return true;
    }

}
