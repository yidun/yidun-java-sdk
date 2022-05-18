package com.netease.yidun.sdk.core.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.io.IOException;
import java.time.Clock;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.junit.Test;

import com.netease.yidun.sdk.core.endpoint.EndpointResolver;
import com.netease.yidun.sdk.core.endpoint.failover.BreakStrategy;
import com.netease.yidun.sdk.core.endpoint.failover.FixedWindowBreakStrategy;
import com.netease.yidun.sdk.core.http.ProtocolEnum;

public class DefaultClientTest {

    private static final String secretId = "a-secret-id-1";
    private static final String secretKey = "a-secret-key-1";

    @Test
    public void testNullSigner() {
        ClientProfile profile = ClientProfile.defaultProfile(secretId, secretKey);
        profile.signer(null);

        NullPointerException e = null;

        try {
            new DefaultClient(profile);
        } catch (NullPointerException ex) {
            e = ex;
        }

        assertEquals("signer should not be null", e.getMessage());
    }

    @Test
    public void testNullCredentials() {
        NullPointerException e = null;

        try {
            new DefaultClient(ClientProfile.defaultProfile(null));
        } catch (NullPointerException ex) {
            e = ex;
        }

        assertEquals("credentials should not be null", e.getMessage());
    }

    @Test
    public void testDefaultHttpClientConfig() {
        ClientProfile profile = ClientProfile
                .defaultProfile(secretId, secretKey)
                .httpClientConfig(null);

        DefaultClient client = new DefaultClient(profile);

        // 因 httpClient（CloseableHttpClient）属性的校验难度较大，暂时只校验 defaultProtocol
        assertEquals(ProtocolEnum.HTTPS, client.defaultProtocol());
    }

    @Test
    public void testDefaultBreakerConfig() {
        ClientProfile profile = ClientProfile
                .defaultProfile(secretId, secretKey)
                .breakerConfig(null);

        DefaultClient client = new DefaultClient(profile);

        FixedWindowBreakStrategy breakStrategy = (FixedWindowBreakStrategy) client.breakStrategy();

        assertEquals(Clock.systemDefaultZone(), breakStrategy.clock());

        assertEquals(FixedWindowBreakStrategy.Config.DEFAULT_STAT_WINDOW_MILLIS,
                breakStrategy.statWindowMillis());

        assertEquals(FixedWindowBreakStrategy.Config.DEFAULT_CIRCUIT_BREAKER_FAIL_THRESHOLD_PERCENTAGE,
                breakStrategy.circuitBreakerFailThresholdPercentage());

        assertEquals(FixedWindowBreakStrategy.Config.DEFAULT_CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD,
                breakStrategy.circuitBreakerRequestVolumeThreshold());

        assertEquals(FixedWindowBreakStrategy.Config.DEFAULT_CIRCUIT_BREAKER_SLEEP_WINDOW_MILLIS,
                breakStrategy.circuitBreakerSleepWindowMillis());
    }

    @Test
    public void testCloseNormal() throws Exception {
        DefaultClient client = DefaultClient.createDefault(secretId, secretKey);

        CloseableHttpClient httpClient = mock(CloseableHttpClient.class);
        client.httpClient(httpClient);

        client.close();

        verify(httpClient, times(1)).close();
        verifyNoMoreInteractions(httpClient);
    }

    @Test
    public void testCloseWithIOException() throws Exception {
        DefaultClient client = DefaultClient.createDefault(secretId, secretKey);

        CloseableHttpClient httpClient = mock(CloseableHttpClient.class);
        doThrow(new IOException()).when(httpClient).close();
        client.httpClient(httpClient);

        client.close();

        verify(httpClient, times(1)).close();
        verifyNoMoreInteractions(httpClient);
    }

    @Test
    public void testCloseNonIOException() throws Exception {
        DefaultClient client = DefaultClient.createDefault(secretId, secretKey);

        RuntimeException expectedException = new RuntimeException();
        CloseableHttpClient httpClient = mock(CloseableHttpClient.class);
        doThrow(expectedException).when(httpClient).close();
        client.httpClient(httpClient);

        RuntimeException actualException = null;
        try {
            client.close();
        } catch (RuntimeException e) {
            actualException = e;
        }

        assertSame(expectedException, actualException);

        verify(httpClient, times(1)).close();
        verifyNoMoreInteractions(httpClient);
    }

    @Test
    public void testCloseNullHttpClient() {
        DefaultClient client = DefaultClient.createDefault(secretId, secretKey);

        client.httpClient(null);

        client.close();
    }

    @Test
    public void testToString() {
        DefaultClient client = DefaultClient.createDefault(secretId, secretKey);

        String expectedStr = "DefaultClient("
                + "defaultRegionCode=" + client.defaultRegionCode()
                + ", defaultProtocol=" + client.defaultProtocol()
                + ", maxAttemptCount=" + client.maxAttemptCount()
                + ")";

        assertEquals(expectedStr, client.toString());
    }

    @Test
    public void testGetterSetter() {
        ClientProfile profile = ClientProfile.defaultProfile(secretId, secretKey);
        DefaultClient client = new DefaultClient(profile);

        assertEquals(profile.regionCode(), client.defaultRegionCode());
        assertEquals(profile.regionCode(), client.getDefaultRegionCode());

        assertEquals(profile.httpClientConfig().protocol(), client.defaultProtocol());
        assertEquals(profile.httpClientConfig().protocol(), client.getDefaultProtocol());

        assertSame(profile.signer(), client.signer());
        assertSame(profile.signer(), client.getSigner());

        assertSame(profile.credentials(), client.credentials());
        assertSame(profile.credentials(), client.getCredentials());

        assertEquals(profile.maxRetryCount() + 1, client.maxAttemptCount());
        assertEquals(profile.maxRetryCount() + 1, client.getMaxAttemptCount());

        CloseableHttpClient httpClient = mock(CloseableHttpClient.class);
        client.httpClient(httpClient);
        assertSame(httpClient, client.httpClient());
        assertSame(httpClient, client.getHttpClient());

        httpClient = mock(CloseableHttpClient.class);
        client.setHttpClient(httpClient);
        assertSame(httpClient, client.httpClient());
        assertSame(httpClient, client.getHttpClient());

        EndpointResolver endpointResolver = mock(EndpointResolver.class);
        client.endpointResolver(endpointResolver);
        assertSame(endpointResolver, client.endpointResolver());
        assertSame(endpointResolver, client.getEndpointResolver());

        endpointResolver = mock(EndpointResolver.class);
        client.setEndpointResolver(endpointResolver);
        assertSame(endpointResolver, client.endpointResolver());
        assertSame(endpointResolver, client.getEndpointResolver());

        BreakStrategy breakStrategy = mock(BreakStrategy.class);
        client.breakStrategy(breakStrategy);
        assertSame(breakStrategy, client.breakStrategy());
        assertSame(breakStrategy, client.getBreakStrategy());

        breakStrategy = mock(BreakStrategy.class);
        client.setBreakStrategy(breakStrategy);
        assertSame(breakStrategy, client.breakStrategy());
        assertSame(breakStrategy, client.getBreakStrategy());
    }
}
