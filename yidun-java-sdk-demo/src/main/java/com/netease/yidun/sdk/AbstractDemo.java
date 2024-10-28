package com.netease.yidun.sdk;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.core.auth.Credentials;
import com.netease.yidun.sdk.core.client.ClientProfile;
import com.netease.yidun.sdk.core.endpoint.failover.FixedWindowBreakStrategy;
import com.netease.yidun.sdk.core.http.HttpClientConfig;

public class AbstractDemo {

    /**
     * 创建内容安全通用请求器
     * @param secretId 产品密钥ID
     * @param secretKey 产品私有密钥
     * @return 内容安全请求器
     */
    protected static AntispamRequester createAntispamRequester(String secretId, String secretKey){
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = AntispamRequester.getInstance(secretId, secretKey);

        // 可选自定义请求器的参数，如果不需要自定义设置，可跳过，否则请参考如下注释内容：
//        ClientProfile clientProfile = createProfile("SecretId", "SecretKey");
//        AntispamRequester antispamRequester = AntispamRequester.getInstance(clientProfile);

        return antispamRequester;
    }

    /**
     * 创建自定义请求配置
     * @param secretId 产品密钥ID
     * @param secretKey 产品私有密钥
     */
    protected static ClientProfile createProfile(String secretId, String secretKey) {
        ClientProfile clientProfile = ClientProfile.defaultProfile(new Credentials(secretId, secretKey));
        // 设置http请求的相关配置
        HttpClientConfig httpClientConfig = new HttpClientConfig();
        httpClientConfig.setMaxConnectionCountPerRoute(100);
        httpClientConfig.socketTimeoutMillis(60000);
        clientProfile.setHttpClientConfig(httpClientConfig);
        // 设置固定窗口的熔断配置
        FixedWindowBreakStrategy.Config breakerConfig = clientProfile.getBreakerConfig();
        breakerConfig.statWindowMillis(300000);
        // 设置请求失败时的重试次数
        clientProfile.setMaxRetryCount(2);
        return clientProfile;
    }
}
