package com.netease.yidun.sdk.core.http;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HttpClientConfigTest {

    @Test
    public void testDefault() {
        HttpClientConfig config = HttpClientConfig.defaultConfig();

        assertEquals(ProtocolEnum.HTTPS, config.protocol());
        assertEquals(5000, config.socketTimeoutMillis());
        assertEquals(60000, config.maxIdleTimeMillis());
        assertEquals(1000, config.connectionRequestTimeoutMillis());
        assertEquals(120000, config.connectionKeepAliveMillis());
        assertEquals(15000, config.connectionTimeoutMillis());
        assertEquals(20000, config.responseTimeoutMillis());
        assertEquals(200, config.maxConnectionCount());
        assertEquals(20, config.maxConnectionCountPerRoute());
    }

    @Test
    public void testToString() {
        String expectedStr = "HttpClientConfig(" +
                "protocol=https" +
                ", socketTimeoutMillis=5000" +
                ", maxIdleTimeMillis=60000" +
                ", connectionRequestTimeoutMillis=1000" +
                ", connectionKeepAliveMillis=120000" +
                ", connectionTimeoutMillis=15000" +
                ", responseTimeoutMillis=20000" +
                ", maxConnectionCount=200" +
                ", maxConnectionCountPerRoute=20)";

        HttpClientConfig config = HttpClientConfig.defaultConfig();

        assertEquals(expectedStr, config.toString());
    }

    @Test
    public void testGetterSetter() {
        ProtocolEnum protocol = ProtocolEnum.HTTP;
        int socketTimeoutMillis = 11;
        long maxIdleTimeMillis = 12;
        long connectionRequestTimeoutMillis = 22;
        long connectionKeepAliveMillis = 34;
        long connectionTimeoutMillis = 56;
        long responseTimeoutMillis = 78;
        int maxConnectionCount = 90;
        int maxConnectionCountPerRoute = 100;

        HttpClientConfig config = new HttpClientConfig();

        config.setProtocol(protocol);
        config.setSocketTimeoutMillis(socketTimeoutMillis);
        config.setMaxIdleTimeMillis(maxIdleTimeMillis);
        config.setConnectionRequestTimeoutMillis(connectionRequestTimeoutMillis);
        config.setConnectionKeepAliveMillis(connectionKeepAliveMillis);
        config.setConnectionTimeoutMillis(connectionTimeoutMillis);
        config.setResponseTimeoutMillis(responseTimeoutMillis);
        config.setMaxConnectionCount(maxConnectionCount);
        config.setMaxConnectionCountPerRoute(maxConnectionCountPerRoute);

        assertEquals(protocol, config.getProtocol());
        assertEquals(socketTimeoutMillis, config.getSocketTimeoutMillis());
        assertEquals(maxIdleTimeMillis, config.getMaxIdleTimeMillis());
        assertEquals(connectionRequestTimeoutMillis, config.getConnectionRequestTimeoutMillis());
        assertEquals(connectionKeepAliveMillis, config.getConnectionKeepAliveMillis());
        assertEquals(connectionTimeoutMillis, config.getConnectionTimeoutMillis());
        assertEquals(responseTimeoutMillis, config.getResponseTimeoutMillis());
        assertEquals(maxConnectionCount, config.getMaxConnectionCount());
        assertEquals(maxConnectionCountPerRoute, config.getMaxConnectionCountPerRoute());
    }

    @Test
    public void testFluentGetterSetter() {
        ProtocolEnum protocol = ProtocolEnum.HTTP;
        int socketTimeoutMillis = 11;
        long maxIdleTimeMillis = 12;
        long connectionRequestTimeoutMillis = 22;
        long connectionKeepAliveMillis = 34;
        long connectionTimeoutMillis = 56;
        long responseTimeoutMillis = 78;
        int maxConnectionCount = 90;
        int maxConnectionCountPerRoute = 100;

        HttpClientConfig config = new HttpClientConfig()
                .protocol(protocol)
                .socketTimeoutMillis(socketTimeoutMillis)
                .maxIdleTimeMillis(maxIdleTimeMillis)
                .connectionRequestTimeoutMillis(connectionRequestTimeoutMillis)
                .connectionKeepAliveMillis(connectionKeepAliveMillis)
                .connectionTimeoutMillis(connectionTimeoutMillis)
                .responseTimeoutMillis(responseTimeoutMillis)
                .maxConnectionCount(maxConnectionCount)
                .maxConnectionCountPerRoute(maxConnectionCountPerRoute);

        assertEquals(protocol, config.protocol());
        assertEquals(socketTimeoutMillis, config.socketTimeoutMillis());
        assertEquals(maxIdleTimeMillis, config.maxIdleTimeMillis());
        assertEquals(connectionRequestTimeoutMillis, config.connectionRequestTimeoutMillis());
        assertEquals(connectionKeepAliveMillis, config.connectionKeepAliveMillis());
        assertEquals(connectionTimeoutMillis, config.connectionTimeoutMillis());
        assertEquals(responseTimeoutMillis, config.responseTimeoutMillis());
        assertEquals(maxConnectionCount, config.maxConnectionCount());
        assertEquals(maxConnectionCountPerRoute, config.maxConnectionCountPerRoute());
    }
}
