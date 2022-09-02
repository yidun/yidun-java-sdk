package com.netease.yidun.sdk.antispam;

import com.netease.yidun.sdk.antispam.recover.DefaultRequestRecover;
import com.netease.yidun.sdk.core.client.Client;
import com.netease.yidun.sdk.core.client.ClientProfile;
import com.netease.yidun.sdk.core.client.DefaultClient;
import com.netease.yidun.sdk.core.response.BaseResponse;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AntispamClient {
    protected DefaultClient client;

    public AntispamClient(ClientProfile clientProfile) {
        client = new DefaultClient(clientProfile);
        if (clientProfile.getRequestRecover() != null && clientProfile.getRequestRecover() instanceof DefaultRequestRecover) {
            if (clientName() == null) {
                return;
            }
            // 找到类中所有发出接口请求的方法，并加入到文件恢复中
            DefaultRequestRecover requestRecover = (DefaultRequestRecover) clientProfile.getRequestRecover();
            List<Class<?>> classes = Arrays.stream(this.getClass().getDeclaredMethods())
                    .filter(m -> m.getReturnType() != null && BaseResponse.class.isAssignableFrom(m.getReturnType()))
                    .map(Method::getReturnType)
                    .collect(Collectors.toList());

            requestRecover.registerRecover(classes, clientName(), client);
        }
    }

    protected String clientName() {
        return null;
    }

}
