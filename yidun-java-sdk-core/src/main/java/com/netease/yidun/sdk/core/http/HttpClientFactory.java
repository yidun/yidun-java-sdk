package com.netease.yidun.sdk.core.http;

import com.netease.yidun.sdk.core.client.NoResponseRetryStrategy;
import com.netease.yidun.sdk.core.utils.StringUtils;
import org.apache.hc.client5.http.DnsResolver;
import org.apache.hc.client5.http.SystemDefaultDnsResolver;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.io.SocketConfig;
import org.apache.hc.core5.util.TimeValue;
import org.apache.hc.core5.util.VersionInfo;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class HttpClientFactory {

    public static CloseableHttpClient create(HttpClientConfig config) {
        RequestConfig requestConfig = RequestConfig
                .custom()
                .setDefaultKeepAlive(config.connectionKeepAliveMillis(), TimeUnit.MILLISECONDS)
                .setConnectionRequestTimeout(config.connectionRequestTimeoutMillis(), TimeUnit.MILLISECONDS)
                .setConnectTimeout(config.connectionTimeoutMillis(), TimeUnit.MILLISECONDS)
                .setResponseTimeout(config.responseTimeoutMillis(), TimeUnit.MILLISECONDS)
                .setProxy(StringUtils.isNotBlank(config.getProxyHost()) ? new HttpHost(config.proxyScheme(), config.proxyHost(),
                                                                                       config.proxyPort()) : null)
                .build();

        SocketConfig socketConfig = SocketConfig
                .custom()
                .setSoTimeout(config.socketTimeoutMillis(), TimeUnit.MILLISECONDS)
                .build();

        Map<String, String> dnsCache = config.dnsCache();
        DnsResolver dnsResolver = (dnsCache != null && !dnsCache.isEmpty()) ? new DnsCacheResolver(
                dnsCache) : SystemDefaultDnsResolver.INSTANCE;

        PoolingHttpClientConnectionManager connManager = PoolingHttpClientConnectionManagerBuilder
                .create()
                .setMaxConnTotal(config.maxConnectionCount())
                .setMaxConnPerRoute(config.maxConnectionCountPerRoute())
                .setDefaultSocketConfig(socketConfig)
                .setDnsResolver(dnsResolver)
                .build();

        return HttpClients
                .custom()
                .evictIdleConnections(TimeValue.of(config.maxIdleTimeMillis(), TimeUnit.MILLISECONDS))
                .evictExpiredConnections()
                .setConnectionManager(connManager)
                .setDefaultRequestConfig(requestConfig)
                .useSystemProperties()
                // 设置版本号在ua上，方便统计
                .setUserAgent(getCustomizeSdkUserAgent())
                .setRetryStrategy(new NoResponseRetryStrategy(config.maxNoResponseRetryCount(), 10))
                .build();
    }

    /**
     *
     * @return
     */
    private static String getCustomizeSdkUserAgent() {
        return HttpHeaders.SDK_VERSION
                .concat("/")
                .concat(HttpHeaders.DEFAULT_SDK_VERSION)
                .concat(";")
                .concat(getDefaultUserAgent());
    }

    /**
     * 获取默认的user-agent（和HttpClientBuilder包中设置的保持一致）
     *
     * @return 默认的user-agent
     */
    private static String getDefaultUserAgent() {
        return VersionInfo.getSoftwareInfo("Apache-HttpClient", "org.apache.hc.client5", HttpClientBuilder.class);
    }

}
