package com.netease.yidun.sdk.antispam;

import com.netease.yidun.sdk.core.client.ClientProfile;
import com.netease.yidun.sdk.core.endpoint.failover.FixedWindowBreakStrategy;
import com.netease.yidun.sdk.core.http.HttpClientConfig;

public class AbstractDemo {

    protected static AntispamRequester createAntispamRequester(String secretId, String secretKey){
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = new AntispamRequester(secretId, secretKey);

        // 可选自定义请求器的参数，如果不需要自定义设置，可跳过，否则请参考如下注释内容：
//        ClientProfile clientProfile = AntispamRequester.createDefaultProfile("SecretId", "SecretKey");
//        // 设置http请求的相关配置
//        HttpClientConfig httpClientConfig = clientProfile.getHttpClientConfig();
//        httpClientConfig.socketTimeoutMillis(60000);
//
//        // 设置固定窗口的熔断配置
//        FixedWindowBreakStrategy.Config breakerConfig = clientProfile.getBreakerConfig();
//        breakerConfig.statWindowMillis(300000);
//
//        // 设置请求失败时的重试次数
//        clientProfile.setMaxRetryCount(2);
//        AntispamRequester antispamRequester = new AntispamRequester(clientProfile);
        return antispamRequester;
    }
}
