package com.netease.yidun.sdk.core.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.InOrder;

import com.netease.yidun.sdk.core.auth.Credentials;
import com.netease.yidun.sdk.core.auth.Signer;
import com.netease.yidun.sdk.core.endpoint.EndpointResolver;
import com.netease.yidun.sdk.core.endpoint.failover.BreakStrategy;
import com.netease.yidun.sdk.core.exception.YidunSdkException;
import com.netease.yidun.sdk.core.http.HttpMethodEnum;
import com.netease.yidun.sdk.core.http.HttpRequest;
import com.netease.yidun.sdk.core.request.BaseRequest;
import com.netease.yidun.sdk.core.response.CommonResponse;

public class DefaultClientExecutionTest {

    private static final String secretId = "a-secret-id-1";
    private static final String secretKey = "a-secret-key-1";
    private static final String regionCode = "somewhere-404";
    private static final String productCode = "test-product-code-1";
    private static final String domain1 = "1.x.y.z";
    private static final String domain2 = "2.x.y.z";
    private static final String domain3 = "3.x.y.z";
    private static final String uriPattern = "/api/v1/test/[id]/[action]";
    private static final String expectedPath;
    private static final HttpMethodEnum testMethod = HttpMethodEnum.POST;
    private static final Map<String, String> testHeaders;
    private static final Map<String, String> testPathParameters;
    private static final String requestBody = "from=from-here&to=to-there";
    private static final String responseBody = "{" +
            "\"code\": 200," +
            "\"msg\": \"ok\"," +
            "\"score\": 0.99" +
            "}";

    static {
        Map<String, String> tmpHeaders = new HashMap<>();
        tmpHeaders.put("Content-Type", "application/www-urlencoded-form; charset=utf-8");
        tmpHeaders.put("test-head-name-1", "test-head-value-1");
        testHeaders = Collections.unmodifiableMap(tmpHeaders);

        Map<String, String> tmpPathParameters = new HashMap<>();
        tmpPathParameters.put("id", "123");
        tmpPathParameters.put("action", "getName");
        testPathParameters = Collections.unmodifiableMap(tmpPathParameters);
        expectedPath = "/api/v1/test/123/getName";
    }

    @Test
    public void testSuccess() throws IOException {
        CloseableHttpResponse rawResponse = mock(CloseableHttpResponse.class);
        when(rawResponse.getCode()).thenReturn(200);
        when(rawResponse.getEntity()).thenReturn(new StringEntity(responseBody));
        CloseableHttpClient httpClient = mock(CloseableHttpClient.class);
        when(httpClient.execute(any())).thenReturn(rawResponse);

        EndpointResolver endpointResolver = mock(EndpointResolver.class);
        when(endpointResolver.resolve(productCode, regionCode))
                .thenReturn(Collections.singletonList(domain1));
        BreakStrategy breakStrategy = mock(BreakStrategy.class);

        TestRequest request = spy(new TestRequest());
        request.regionCode(regionCode);

        DefaultClient client = createClient(httpClient, endpointResolver, breakStrategy);

        // 执行
        TestResponse response = client.execute(request);

        // 验证：响应对象
        assertEquals(200, response.getCode());
        assertEquals("ok", response.getMsg());
        assertEquals(Double.valueOf(0.99), response.getScore());

        // 验证：主要方法的调用顺序
        InOrder inOrder = inOrder(request, httpClient, endpointResolver, breakStrategy);

        // 获取域名
        inOrder.verify(endpointResolver).resolve(productCode, regionCode);
        // 询问域名是否可用，并设置域名
        inOrder.verify(breakStrategy).attemptAccess(productCode, regionCode, domain1);
        inOrder.verify(request).setDomain(domain1);
        // 构建 HTTP Request
        inOrder.verify(request).toHttpRequest(client.signer(), client.credentials());
        // 提交请求
        inOrder.verify(httpClient).execute(argThat(createHttpRequestMatcher(domain1)));
        // 反馈请求失败
        inOrder.verify(breakStrategy).requestSuccess(productCode, regionCode, domain1);

        // 验证：无其它调用
        verifyNoMoreInteractions(httpClient, endpointResolver, breakStrategy);
    }

    @Test
    public void testSuccessWithPreassignedDomain() throws IOException {
        CloseableHttpResponse rawResponse = mock(CloseableHttpResponse.class);
        when(rawResponse.getCode()).thenReturn(200);
        when(rawResponse.getEntity()).thenReturn(new StringEntity(responseBody));
        CloseableHttpClient httpClient = mock(CloseableHttpClient.class);
        when(httpClient.execute(any())).thenReturn(rawResponse);

        TestRequest request = spy(new TestRequest());
        request.domain(domain1);

        DefaultClient client = createClient(httpClient, null, null);

        // 执行
        TestResponse response = client.execute(request);

        // 验证：响应对象
        assertEquals(200, response.getCode());
        assertEquals("ok", response.getMsg());
        assertEquals(Double.valueOf(0.99), response.getScore());

        // 验证：HTTP Request 构建
        verify(request, times(1))
                .toHttpRequest(client.signer(), client.credentials());

        // 验证：HTTP Client 调用
        verify(httpClient, times(1))
                .execute(argThat(createHttpRequestMatcher(domain1)));

        // 验证：无其它调用
        verifyNoMoreInteractions(httpClient);
    }

    @Test
    public void readResponseBodyWithException() throws IOException {
        // mock：读取响应体数据时抛出 IOException
        InputStream responseStream = mock(InputStream.class);
        when(responseStream.read()).thenThrow(new IOException());
        StringEntity entity = spy(new StringEntity(responseBody));
        when(entity.getContent()).thenReturn(responseStream);

        CloseableHttpResponse rawResponse = mock(CloseableHttpResponse.class);
        when(rawResponse.getCode()).thenReturn(200);
        when(rawResponse.getEntity()).thenReturn(entity);

        CloseableHttpClient httpClient = mock(CloseableHttpClient.class);
        when(httpClient.execute(any())).thenReturn(rawResponse);

        TestRequest request = spy(new TestRequest());
        request.domain(domain1);

        DefaultClient client = createClient(httpClient, null, null);

        // 执行
        YidunSdkException e = null;
        try {
            client.execute(request);
        } catch (YidunSdkException ex) {
            e = ex;
        }

        // 验证：响应对象
        assertEquals("Fail to read response body. code=200", e.getMessage());

        // 验证：HTTP Request 构建
        verify(request, times(1))
                .toHttpRequest(client.signer(), client.credentials());

        // 验证：HTTP Client 调用
        verify(httpClient, times(1))
                .execute(argThat(createHttpRequestMatcher(domain1)));

        // 验证：无其它调用
        verifyNoMoreInteractions(httpClient);
    }

    @Test
    public void parseNonJsonResponseBody() throws IOException {
        CloseableHttpResponse rawResponse = mock(CloseableHttpResponse.class);
        when(rawResponse.getCode()).thenReturn(200);
        when(rawResponse.getEntity()).thenReturn(new StringEntity("123"));

        CloseableHttpClient httpClient = mock(CloseableHttpClient.class);
        when(httpClient.execute(any())).thenReturn(rawResponse);

        TestRequest request = spy(new TestRequest());
        request.domain(domain1);

        DefaultClient client = createClient(httpClient, null, null);

        // 执行
        YidunSdkException e = null;
        try {
            client.execute(request);
        } catch (YidunSdkException ex) {
            e = ex;
        }

        // 验证：响应对象
        assertEquals("Fail to parse response body. code=200, body=123", e.getMessage());

        // 验证：HTTP Request 构建
        verify(request, times(1))
                .toHttpRequest(client.signer(), client.credentials());

        // 验证：HTTP Client 调用
        verify(httpClient, times(1))
                .execute(argThat(createHttpRequestMatcher(domain1)));

        // 验证：无其它调用
        verifyNoMoreInteractions(httpClient);
    }

    @Test
    public void testNon2xxResponse() throws IOException {
        CloseableHttpResponse rawResponse = mock(CloseableHttpResponse.class);
        when(rawResponse.getCode()).thenReturn(300);
        when(rawResponse.getEntity()).thenReturn(new StringEntity("123"));

        CloseableHttpClient httpClient = mock(CloseableHttpClient.class);
        when(httpClient.execute(any())).thenReturn(rawResponse);

        TestRequest request = spy(new TestRequest());
        request.domain(domain1);

        DefaultClient client = createClient(httpClient, null, null);

        // 执行
        YidunSdkException e = null;
        try {
            client.execute(request);
        } catch (YidunSdkException ex) {
            e = ex;
        }

        // 验证：响应对象
        assertEquals("Server response fail. code=300, body=123", e.getMessage());

        // 验证：HTTP Request 构建
        verify(request, times(1))
                .toHttpRequest(client.signer(), client.credentials());

        // 验证：HTTP Client 调用
        verify(httpClient, times(1))
                .execute(argThat(createHttpRequestMatcher(domain1)));

        // 验证：无其它调用
        verifyNoMoreInteractions(httpClient);
    }

    @Test
    public void testInvalidRequestParam() {
        DefaultClient client = createClient(null, null, null);

        IllegalArgumentException e = null;
        try {
            client.execute(new TestRequest("", uriPattern, testMethod));
        } catch (IllegalArgumentException ex) {
            e = ex;
        }

        assertNotNull(e);
    }

    @Test
    public void testNoRegisteredDomain() {
        YidunSdkException expectedException = new YidunSdkException("no registered domain");
        EndpointResolver endpointResolver = mock(EndpointResolver.class);
        when(endpointResolver.resolve(any(), any())).thenThrow(expectedException);

        DefaultClient client = createClient(null, endpointResolver, null);

        YidunSdkException actualException = null;
        try {
            client.execute(new TestRequest());
        } catch (YidunSdkException e) {
            actualException = e;
        }

        assertSame(expectedException, actualException);
        verify(endpointResolver, times(1))
                .resolve(productCode, client.defaultRegionCode());
        verifyNoMoreInteractions(endpointResolver);
    }

    @Test
    public void testAllAttemptsThrowException() throws IOException {
        Exception expectedCause = new RuntimeException("error-1");
        String expectedMsg = "Fail to request server: error-1";
        CloseableHttpClient httpClient = mock(CloseableHttpClient.class);
        when(httpClient.execute(any())).thenThrow(expectedCause);

        testAllAttemptsFail(httpClient, expectedMsg, expectedCause);
    }

    @Test
    public void testAllAttemptsGetNullResponse() throws IOException {
        Exception expectedCause = null;
        String expectedMsg = "Server error. null response";
        CloseableHttpClient httpClient = mock(CloseableHttpClient.class);
        when(httpClient.execute(any())).thenReturn(null);

        testAllAttemptsFail(httpClient, expectedMsg, expectedCause);
    }

    @Test
    public void testAllAttemptsGetNullResponseBody() throws IOException {
        int responseCode = 500;
        Exception expectedCause = null;
        String expectedMsg = "Server error. null response body. code=500";
        CloseableHttpResponse response = mock(CloseableHttpResponse.class);
        when(response.getEntity()).thenReturn(null);
        when(response.getCode()).thenReturn(responseCode);
        CloseableHttpClient httpClient = mock(CloseableHttpClient.class);
        when(httpClient.execute(any())).thenReturn(response);

        testAllAttemptsFail(httpClient, expectedMsg, expectedCause);
    }

    @Test
    public void testAllAttemptsGetServerErrorCode() throws IOException {
        int responseCode = 500;
        String body = "error-body";
        Exception expectedCause = null;
        String expectedMsg = "Server error. code=500, body=error-body";
        CloseableHttpResponse response = mock(CloseableHttpResponse.class);
        when(response.getEntity()).thenReturn(null);
        when(response.getCode()).thenReturn(responseCode);
        when(response.getEntity()).thenReturn(new StringEntity(body));
        CloseableHttpClient httpClient = mock(CloseableHttpClient.class);
        when(httpClient.execute(any())).thenReturn(response);

        testAllAttemptsFail(httpClient, expectedMsg, expectedCause);
    }

    private void testAllAttemptsFail(CloseableHttpClient httpClient, String expectedMsg, Exception expectedCause)
            throws IOException {
        EndpointResolver endpointResolver = mock(EndpointResolver.class);
        when(endpointResolver.resolve(productCode, regionCode))
                .thenReturn(Arrays.asList(domain1, domain2, domain3));

        BreakStrategy breakStrategy = mock(BreakStrategy.class);
        // 前2次尝试时，熔断器都反馈域名可用
        // 第3次尝试时，熔断器反馈域名不可用，强制使用第1个域名
        // 第4次请求时，因为已询问过熔断器最后一个域名（不可用），不再询问熔断器，直接尝试下一个域名
        when(breakStrategy.attemptAccess(productCode, regionCode, domain1)).thenReturn(true, false);
        when(breakStrategy.attemptAccess(productCode, regionCode, domain2)).thenReturn(true, false);
        when(breakStrategy.attemptAccess(productCode, regionCode, domain3)).thenReturn(false, false);

        BaseRequest<?> request = spy(new TestRequest().regionCode(regionCode));

        DefaultClient client = createClient(httpClient, endpointResolver, breakStrategy);

        // 执行
        YidunSdkException e = null;
        try {
            client.execute(request);
        } catch (YidunSdkException ex) {
            e = ex;
        }

        // 验证：异常
        assertEquals(expectedMsg, e.getMessage());
        assertSame(expectedCause, e.getCause());

        // 验证：最后的domain
        assertEquals(domain2, request.domain());

        // 验证：主要方法的调用顺序
        InOrder inOrder = inOrder(request, httpClient, endpointResolver, breakStrategy);

        // 第1轮
        // 获取域名
        inOrder.verify(endpointResolver).resolve(productCode, regionCode);
        // 询问域名是否可用，并设置域名
        inOrder.verify(breakStrategy).attemptAccess(productCode, regionCode, domain1);
        inOrder.verify(request).setDomain(domain1);
        // 构建 HTTP Request
        inOrder.verify(request).toHttpRequest(client.signer(), client.credentials());
        // 提交请求
        inOrder.verify(httpClient).execute(argThat(createHttpRequestMatcher(domain1)));
        // 反馈请求失败
        inOrder.verify(breakStrategy).requestFail(productCode, regionCode, domain1);

        // 第2轮
        // 询问域名是否可用，并设置域名
        inOrder.verify(breakStrategy).attemptAccess(productCode, regionCode, domain2);
        inOrder.verify(request).setDomain(domain2);
        // 构建 HTTP Request
        inOrder.verify(request).toHttpRequest(client.signer(), client.credentials());
        // 提交请求
        inOrder.verify(httpClient).execute(argThat(createHttpRequestMatcher(domain2)));
        // 反馈请求失败
        inOrder.verify(breakStrategy).requestFail(productCode, regionCode, domain2);

        // 第3轮
        // 询问域名是否可用，得到反馈不可用，强制使用第1个域名
        inOrder.verify(breakStrategy).attemptAccess(productCode, regionCode, domain3);
        inOrder.verify(request).setDomain(domain1);
        // 构建 HTTP Request
        inOrder.verify(request).toHttpRequest(client.signer(), client.credentials());
        // 提交请求
        inOrder.verify(httpClient).execute(argThat(createHttpRequestMatcher(domain1)));
        // 反馈请求失败
        inOrder.verify(breakStrategy).requestFail(productCode, regionCode, domain1);

        // 第4轮
        // 已尝试过所有域名，不再询问熔断器，直接使用下一个域名
        inOrder.verify(request).setDomain(domain2);
        // 构建 HTTP Request
        inOrder.verify(request).toHttpRequest(client.signer(), client.credentials());
        // 提交请求
        inOrder.verify(httpClient).execute(argThat(createHttpRequestMatcher(domain2)));
        // 反馈请求失败
        inOrder.verify(breakStrategy).requestFail(productCode, regionCode, domain2);

        // 验证：无其它调用
        verifyNoMoreInteractions(httpClient, endpointResolver, breakStrategy);
    }

    private static DefaultClient createClient(
            CloseableHttpClient httpClient, EndpointResolver endpointResolver, BreakStrategy breakStrategy) {
        DefaultClient client = DefaultClient.createDefault(secretId, secretKey);
        client.httpClient(httpClient);
        client.endpointResolver(endpointResolver);
        client.breakStrategy(breakStrategy);
        return client;
    }

    private ArgumentMatcher<ClassicHttpRequest> createHttpRequestMatcher(String domain) {
        return request -> "POST".equals(request.getMethod())
                && isExpectedUri(request, domain)
                && isExpectedHeaders(request)
                && isExpectedBody(request);
    }

    private static boolean isExpectedUri(ClassicHttpRequest request, String expectedDomain) {
        try {
            URI uri = request.getUri();
            if (!"https".equals(uri.getScheme())) {
                return false;
            }

            if (!expectedDomain.equals(uri.getHost())) {
                return false;
            }

            if (!expectedPath.equals(uri.getPath())) {
                return false;
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    private static boolean isExpectedHeaders(ClassicHttpRequest request) {
        if (testHeaders.size() != request.getHeaders().length) {
            return false;
        }

        for (Map.Entry<String, String> entry : testHeaders.entrySet()) {
            Header[] headers = request.getHeaders(entry.getKey());
            if (headers.length != 1
                    || !headers[0].getValue().equals(entry.getValue())) {
                return false;
            }
        }

        return true;
    }

    private static boolean isExpectedBody(ClassicHttpRequest request) {
        HttpEntity entity = request.getEntity();

        try {
            return "application/www-urlencoded-form; charset=utf-8".equals(entity.getContentType())
                    && entity.getContentEncoding() == null
                    && requestBody.equals(EntityUtils.toString(entity));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static class TestRequest extends BaseRequest<TestResponse> {

        TestRequest() {
            this(DefaultClientExecutionTest.productCode, DefaultClientExecutionTest.uriPattern, testMethod);
        }

        TestRequest(String productCode, String uriPattern, HttpMethodEnum method) {
            this.productCode = productCode;
            this.uriPattern = uriPattern;
            this.method = method;
        }

        @Override
        public Class<TestResponse> getResponseClass() {
            return TestResponse.class;
        }

        @Override
        public HttpRequest toHttpRequest(Signer signer, Credentials credentials) {
            return new HttpRequest()
                    .protocol(protocol)
                    .method(method)
                    .domain(domain)
                    .uriPattern(uriPattern)
                    .headers(testHeaders)
                    .pathParameters(testPathParameters)
                    .body(requestBody.getBytes(StandardCharsets.UTF_8));
        }
    }

    private static class TestResponse extends CommonResponse {

        private Double score;

        public Double getScore() {
            return score;
        }

        public void setScore(Double score) {
            this.score = score;
        }
    }
}
