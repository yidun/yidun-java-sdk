package com.netease.yidun.sdk.core.http;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

public class HttpRequestTest {

    private static final ProtocolEnum protocol = ProtocolEnum.HTTPS;
    private static final HttpMethodEnum method = HttpMethodEnum.POST;
    private static final String domain = "test.org";
    private static final String uriPattern = "/api/v1/res/[id]/[action]";
    private static final Map<String, String> headers;
    private static final Map<String, String> pathParameters;
    private static final Map<String, String> queryParameters;
    private static final byte[] body = {'0', '1', '2', 'a', 'b', 'c'};

    static {
        Map<String, String> tmpHeaders = new HashMap<>();
        tmpHeaders.put("header1", "header-value-1");
        tmpHeaders.put("header2", "header-value-2");
        headers = tmpHeaders;

        Map<String, String> tmpPathParameters = new HashMap<>();
        tmpPathParameters.put("id", "id-1");
        tmpPathParameters.put("action", "获取名称");
        pathParameters = tmpPathParameters;

        Map<String, String> tmpQueryParameters = new HashMap<>();
        tmpQueryParameters.put("from", "from-there");
        tmpQueryParameters.put("to", "这里");
        tmpQueryParameters.put("nothing", null);
        queryParameters = tmpQueryParameters;
    }

    @Test
    public void testAddSingleHeader() {
        Map<String, String> originalHeaders = new HashMap<>();
        originalHeaders.put("h1", "v1");
        HttpRequest request = new HttpRequest().headers(originalHeaders);

        request.header("h2", "v2");
        Map<String, String> newHeaders = request.headers();

        assertEquals(2, newHeaders.size());
        assertEquals("v1", newHeaders.get("h1"));
        assertEquals("v2", newHeaders.get("h2"));
    }

    @Test
    public void testAddSinglePathParameter() {
        Map<String, String> originalPathParameters = new HashMap<>();
        originalPathParameters.put("p1", "v1");
        HttpRequest request = new HttpRequest().pathParameters(originalPathParameters);

        request.pathParameter("p2", "v2");
        Map<String, String> newPathParameters = request.pathParameters();

        assertEquals(2, newPathParameters.size());
        assertEquals("v1", newPathParameters.get("p1"));
        assertEquals("v2", newPathParameters.get("p2"));
    }

    @Test
    public void testAddSingleQueryParameter() {
        Map<String, String> originalQueryParameters = new HashMap<>();
        originalQueryParameters.put("q1", "v1");
        HttpRequest request = new HttpRequest().queryParameters(originalQueryParameters);

        request.queryParameter("q2", "v2");
        Map<String, String> newQueryParameters = request.queryParameters();

        assertEquals(2, newQueryParameters.size());
        assertEquals("v1", newQueryParameters.get("q1"));
        assertEquals("v2", newQueryParameters.get("q2"));
    }

    @Test
    public void testAssembleUrl() {
        String expectedUrl = "https://test.org/api/v1/res/id-1/%E8%8E%B7%E5%8F%96%E5%90%8D%E7%A7%B0" +
                "?nothing&from=from-there&to=%E8%BF%99%E9%87%8C";
        HttpRequest request = createRequestWithFluentApi();

        String actualUrl = request.assembleUrl();

        assertEquals(expectedUrl, actualUrl);
    }

    @Test
    public void testUrlWithPredefinedQueryParamAndEmptyPathParam() {
        String expectedUrl = "http://x.y.z/api/v1/getName?token=abc&id=123";

        // path parameter 为空map
        HttpRequest request = new HttpRequest()
                .protocol(ProtocolEnum.HTTP)
                .domain("x.y.z")
                .uriPattern("/api/v1/getName?token=abc")
                .pathParameters(Collections.emptyMap())
                .queryParameter("id", "123");
        assertEquals(expectedUrl, request.assembleUrl());

        // path parameter 为 null
        request.pathParameters(null);
        assertEquals(expectedUrl, request.assembleUrl());
    }

    @Test
    public void testToString() {
        String partialStr = "HttpRequest(" +
                "protocol=https" +
                ", method=POST" +
                ", domain=test.org" +
                ", uriPattern=/api/v1/res/[id]/[action]" +
                ", headers=" + headers +
                ", pathParameters=" + pathParameters +
                ", queryParameters=" + queryParameters;

        String nonNullBodyStr = partialStr + ", body=" + Hex.encodeHexString(body) + ")";
        HttpRequest request = createRequestWithFluentApi();
        assertEquals(nonNullBodyStr, request.toString());

        String nullBodyStr = partialStr + ", body=null)";
        request.setBody(null);
        assertEquals(nullBodyStr, request.toString());
    }

    @Test
    public void testGetterSetter() {
        HttpRequest request = new HttpRequest();
        request.setProtocol(protocol);
        request.setMethod(method);
        request.setDomain(domain);
        request.setUriPattern(uriPattern);
        request.setHeaders(headers);
        request.setPathParameters(pathParameters);
        request.setQueryParameters(queryParameters);
        request.setBody(body);

        assertEquals(protocol, request.getProtocol());
        assertEquals(method, request.getMethod());
        assertEquals(domain, request.getDomain());
        assertEquals(uriPattern, request.getUriPattern());
        assertEquals(headers, request.getHeaders());
        assertEquals(pathParameters, request.getPathParameters());
        assertEquals(queryParameters, request.getQueryParameters());
        assertArrayEquals(body, request.getBody());
    }

    @Test
    public void testFluentGetterSetter() {
        HttpRequest request = createRequestWithFluentApi();

        assertEquals(protocol, request.protocol());
        assertEquals(method, request.method());
        assertEquals(domain, request.domain());
        assertEquals(uriPattern, request.uriPattern());
        assertEquals(headers, request.headers());
        assertEquals(pathParameters, request.pathParameters());
        assertEquals(queryParameters, request.queryParameters());
        assertArrayEquals(body, request.body());
    }

    private HttpRequest createRequestWithFluentApi() {
        return new HttpRequest()
                .protocol(protocol)
                .method(method)
                .domain(domain)
                .uriPattern(uriPattern)
                .headers(headers)
                .pathParameters(pathParameters)
                .queryParameters(queryParameters)
                .body(body);
    }
}
