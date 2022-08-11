package com.netease.yidun.sdk.antispam.recover;

import com.google.gson.Gson;
import com.netease.yidun.sdk.antispam.recover.recovery.RecoverManager;
import com.netease.yidun.sdk.core.client.Client;
import com.netease.yidun.sdk.core.recover.RecoverMessage;
import com.netease.yidun.sdk.core.request.BaseRequest;
import com.netease.yidun.sdk.core.response.BaseResponse;
import com.netease.yidun.sdk.core.utils.AssertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class FileRequestRecover extends WrapRecover<RecoverMessage> {

    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private Client client;
    private Gson gson = new Gson();
    private RecoverManager recoverManager;
    private RequestRecoverRegistry registry;
    private String dbFileName;

    private FileRequestRecover(RecoverConfig recoverConfig, String dbFileName, Client client, RequestRecoverRegistry registry) {
        super(recoverConfig, dbFileName);
        AssertUtils.notBlank(recoverConfig.getRecoverFileDir(), "recoverFileDir should not be empty");
        recoverManager = new RecoverManager(recoverConfig);
        this.client = client;
        this.registry = registry;
        this.dbFileName = dbFileName;
    }

    public static FileRequestRecover createRecover(RecoverConfig recoverConfig, String dbFileName, Client client, RequestRecoverRegistry registry) {
        return new FileRequestRecover(recoverConfig, dbFileName, client, registry);
    }

    @Override
    public void start() {
        recoverManager.start();
        super.start();
    }

    @Override
    public void stop() {
        recoverManager.stop();
        super.stop();
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

        BaseResponse response;
        try {
            response = client.execute(request);
        } catch (Exception e) {
            log.warn("recover {} fail {}", dbFileName, e.getMessage());
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
