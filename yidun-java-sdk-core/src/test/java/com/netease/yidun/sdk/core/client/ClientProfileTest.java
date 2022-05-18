package com.netease.yidun.sdk.core.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.netease.yidun.sdk.core.auth.Credentials;
import com.netease.yidun.sdk.core.auth.Signer;
import com.netease.yidun.sdk.core.auth.SignerImpl;
import com.netease.yidun.sdk.core.endpoint.EndpointConfigEntry;
import com.netease.yidun.sdk.core.endpoint.failover.FixedWindowBreakStrategy;
import com.netease.yidun.sdk.core.http.HttpClientConfig;
import com.netease.yidun.sdk.core.http.HttpRequest;
import com.netease.yidun.sdk.core.request.BaseRequest;
import com.netease.yidun.sdk.core.response.BaseResponse;

public class ClientProfileTest {

    private static final List<EndpointConfigEntry> primaryEndpoints = new ArrayList<>();
    private static final String regionCode = "region-code-1";
    private static final Signer signer = mock(Signer.class);
    private static final String secretId = "a-secret-id-1";
    private static final String secretKey = "a-secret-key-1";
    private static final Credentials credentials = new Credentials(secretId, secretKey);
    private static final HttpClientConfig httpClientConfig = new HttpClientConfig();
    private static final FixedWindowBreakStrategy.Config breakerConfig = FixedWindowBreakStrategy.Config
            .createDefault();
    private static final int maxRetryCount = 10;
    private static final BaseRequest requestForValidation1 = new TestRequest1();
    private static final BaseRequest requestForValidation2 = new TestRequest2();
    private static final Class<?> requestClassForValidation1 = TestRequest1.class;
    private static final Class<?> requestClassForValidation2 = TestRequest2.class;

    @Test
    public void testNoRetry() {
        int actualMaxRetryCount = new ClientProfile()
                .noRetry()
                .maxRetryCount();

        assertEquals(0, actualMaxRetryCount);
    }

    @Test
    public void testCredentialsWithSecretIdAndKey() {
        ClientProfile profile = new ClientProfile()
                .credentials(secretId, secretKey);

        Credentials credentials = profile.credentials();
        assertEquals(secretId, credentials.secretId());
        assertEquals(secretKey, credentials.secretKey());
    }

    @Test
    public void testDefault() {
        testDefault(ClientProfile.defaultProfile(secretId, secretKey));
        testDefault(ClientProfile.defaultProfile(new Credentials(secretId, secretKey)));
    }

    @Test
    public void testGetterSetter() {
        ClientProfile profile = new ClientProfile();
        profile.setPrimaryEndpoints(primaryEndpoints);
        profile.setRegionCode(regionCode);
        profile.setSigner(signer);
        profile.setCredentials(credentials);
        profile.setHttpClientConfig(httpClientConfig);
        profile.setBreakerConfig(breakerConfig);
        profile.setMaxRetryCount(maxRetryCount);
        profile.setPreheatRequestClassesForValidation(
                Arrays.asList(requestClassForValidation1, requestClassForValidation2));
        profile.setPreheatRequestsForValidation(Arrays.asList(requestForValidation1, requestForValidation2));

        assertEquals(regionCode, profile.getRegionCode());
        assertSame(signer, profile.getSigner());
        assertSame(credentials, profile.getCredentials());
        assertSame(httpClientConfig, profile.getHttpClientConfig());
        assertSame(breakerConfig, profile.getBreakerConfig());
        assertEquals(maxRetryCount, profile.getMaxRetryCount());

        List<Class<?>> preheatRequestClasses = profile.getPreheatRequestClassesForValidation();
        assertEquals(2, preheatRequestClasses.size());
        assertSame(requestClassForValidation1, preheatRequestClasses.get(0));
        assertSame(requestClassForValidation2, preheatRequestClasses.get(1));

        List<BaseRequest> preheatRequests = profile.getPreheatRequestsForValidation();
        assertEquals(2, preheatRequests.size());
        assertSame(requestForValidation1, preheatRequests.get(0));
        assertSame(requestForValidation2, preheatRequests.get(1));
    }

    @Test
    public void testFluentGetterSetter() {
        ClientProfile profile = new ClientProfile()
                .primaryEndpoints(primaryEndpoints)
                .regionCode(regionCode)
                .signer(signer)
                .credentials(credentials)
                .httpClientConfig(httpClientConfig)
                .breakerConfig(breakerConfig)
                .maxRetryCount(maxRetryCount)
                .preheatRequestClassesForValidation(requestClassForValidation1, requestClassForValidation2)
                .preheatRequestsForValidation(requestForValidation1, requestForValidation2);

        assertSame(primaryEndpoints, profile.getPrimaryEndpoints());
        assertEquals(regionCode, profile.regionCode());
        assertSame(signer, profile.signer());
        assertSame(credentials, profile.credentials());
        assertSame(httpClientConfig, profile.httpClientConfig());
        assertSame(breakerConfig, profile.breakerConfig());
        assertEquals(maxRetryCount, profile.maxRetryCount());

        List<Class<?>> preheatRequestClasses = profile.preheatRequestClassesForValidation();
        assertEquals(2, preheatRequestClasses.size());
        assertSame(requestClassForValidation1, preheatRequestClasses.get(0));
        assertSame(requestClassForValidation2, preheatRequestClasses.get(1));

        List<BaseRequest> preheatRequests = profile.preheatRequestsForValidation();
        assertEquals(2, preheatRequests.size());
        assertSame(requestForValidation1, preheatRequests.get(0));
        assertSame(requestForValidation2, preheatRequests.get(1));
    }

    private void testDefault(ClientProfile profile) {
        HttpClientConfig expectedHttpConfig = HttpClientConfig.defaultConfig();
        FixedWindowBreakStrategy.Config expectedBreakerConfig = FixedWindowBreakStrategy.Config.createDefault();
        String expectedString = String.format(
                "ClientProfile(regionCode=cn-hangzhou, httpClientConfig=%s, breakerConfig=%s, maxRetryCount=3)",
                expectedHttpConfig.toString(), expectedBreakerConfig.toString());

        assertNull(profile.getPrimaryEndpoints());

        assertEquals("cn-hangzhou", profile.regionCode());
        assertSame(SignerImpl.INSTANCE, profile.signer());

        Credentials credentials = profile.credentials();
        assertEquals(secretId, credentials.secretId());
        assertEquals(secretKey, credentials.secretKey());

        // 通过 toString() 验证 httpClientConfig；
        // 由 httpClientConfig 的测试保证其 toString() 能体现所有配置
        assertEquals(expectedHttpConfig.toString(), profile.httpClientConfig().toString());

        // 通过 toString() 验证 breakerConfig；
        // 由 breakerConfig 的测试保证其 toString() 能体现所有配置
        assertEquals(expectedBreakerConfig.toString(), profile.breakerConfig().toString());

        assertEquals(3, profile.maxRetryCount());

        assertEquals(expectedString, profile.toString());
    }

    private static class TestRequest1 extends BaseRequest<BaseResponse> {

        @Override
        public Class<BaseResponse> getResponseClass() {
            return null;
        }

        @Override
        public HttpRequest toHttpRequest(Signer signer, Credentials credentials) {
            return null;
        }
    }

    private static class TestRequest2 extends BaseRequest<BaseResponse> {

        @Override
        public Class<BaseResponse> getResponseClass() {
            return null;
        }

        @Override
        public HttpRequest toHttpRequest(Signer signer, Credentials credentials) {
            return null;
        }
    }
}
