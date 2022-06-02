

package com.netease.yidun.sdk.core.http;

import java.util.concurrent.TimeUnit;

import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.core5.http.io.SocketConfig;
import org.apache.hc.core5.util.TimeValue;

public class HttpClientFactory {

    public static CloseableHttpClient create(HttpClientConfig config) {
        RequestConfig requestConfig = RequestConfig.custom()
                .setDefaultKeepAlive(config.connectionKeepAliveMillis(), TimeUnit.MILLISECONDS)
                .setConnectionRequestTimeout(config.connectionRequestTimeoutMillis(), TimeUnit.MILLISECONDS)
                .setConnectTimeout(config.connectionTimeoutMillis(), TimeUnit.MILLISECONDS)
                .setResponseTimeout(config.responseTimeoutMillis(), TimeUnit.MILLISECONDS)
                .build();

        SocketConfig socketConfig = SocketConfig.custom()
                .setSoTimeout(config.socketTimeoutMillis(), TimeUnit.MILLISECONDS)
                .build();

        PoolingHttpClientConnectionManager connManager = PoolingHttpClientConnectionManagerBuilder.create()
                .setMaxConnTotal(config.maxConnectionCount())
                .setMaxConnPerRoute(config.maxConnectionCountPerRoute())
                .setDefaultSocketConfig(socketConfig)
                .build();

        return HttpClients.custom()
                .evictIdleConnections(TimeValue.of(config.maxIdleTimeMillis(), TimeUnit.MILLISECONDS))
                .evictExpiredConnections()
                .setConnectionManager(connManager)
                .setDefaultRequestConfig(requestConfig)
                .useSystemProperties()
                .build();
    }
}
