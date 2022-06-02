

package com.netease.yidun.sdk.core.http;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Hex;

import com.netease.yidun.sdk.core.utils.ObjectUtils;
import com.netease.yidun.sdk.core.utils.UrlUtils;

/**
 * 业务请求对象 与 具体HTTP Client所需请求对象 之间的桥梁
 */
public final class HttpRequest {

    private ProtocolEnum protocol;
    private HttpMethodEnum method;
    private String domain;
    private String uriPattern;
    private Map<String, String> headers = new HashMap<>();
    private Map<String, String> pathParameters = new HashMap<>();
    private Map<String, String> queryParameters = new HashMap<>();
    private byte[] body;

    public ProtocolEnum getProtocol() {
        return protocol;
    }

    public void setProtocol(ProtocolEnum protocol) {
        this.protocol = protocol;
    }

    public ProtocolEnum protocol() {
        return protocol;
    }

    public HttpRequest protocol(ProtocolEnum protocol) {
        this.protocol = protocol;
        return this;
    }

    public HttpMethodEnum getMethod() {
        return method;
    }

    public void setMethod(HttpMethodEnum method) {
        this.method = method;
    }

    public HttpMethodEnum method() {
        return method;
    }

    public HttpRequest method(HttpMethodEnum method) {
        this.method = method;
        return this;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String domain() {
        return domain;
    }

    public HttpRequest domain(String domain) {
        this.domain = domain;
        return this;
    }

    public String getUriPattern() {
        return uriPattern;
    }

    public void setUriPattern(String uriPattern) {
        this.uriPattern = uriPattern;
    }

    public String uriPattern() {
        return uriPattern;
    }

    public HttpRequest uriPattern(String uriPattern) {
        this.uriPattern = uriPattern;
        return this;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Map<String, String> headers() {
        return headers;
    }

    public HttpRequest headers(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    public HttpRequest header(String name, String value) {
        headers.put(name, value);
        return this;
    }

    public Map<String, String> getPathParameters() {
        return pathParameters;
    }

    public void setPathParameters(Map<String, String> pathParameters) {
        this.pathParameters = pathParameters;
    }

    public Map<String, String> pathParameters() {
        return pathParameters;
    }

    public HttpRequest pathParameters(Map<String, String> pathParameters) {
        this.pathParameters = pathParameters;
        return this;
    }

    public HttpRequest pathParameter(String name, String value) {
        pathParameters.put(name, value);
        return this;
    }

    public Map<String, String> getQueryParameters() {
        return queryParameters;
    }

    public void setQueryParameters(Map<String, String> queryParameters) {
        this.queryParameters = queryParameters;
    }

    public Map<String, String> queryParameters() {
        return queryParameters;
    }

    public HttpRequest queryParameters(Map<String, String> queryParameters) {
        this.queryParameters = queryParameters;
        return this;
    }

    public HttpRequest queryParameter(String name, String value) {
        queryParameters.put(name, value);
        return this;
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

    public byte[] body() {
        return body;
    }

    public HttpRequest body(byte[] body) {
        this.body = body;
        return this;
    }

    public String assembleUrl() {
        Map<String, String> mapQueries = ObjectUtils.defaultIfNull(queryParameters, Collections.emptyMap());
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(protocol.toString());
        urlBuilder.append("://").append(domain);
        if (null != this.uriPattern) {
            urlBuilder.append(populatePathParams(uriPattern, pathParameters));
        }
        if (-1 == urlBuilder.indexOf("?")) {
            urlBuilder.append("?");
        } else if (!urlBuilder.toString().endsWith("?")) {
            urlBuilder.append("&");
        }

        if (!mapQueries.isEmpty()) {
            urlBuilder.append(UrlUtils.encode(mapQueries));
        }

        String url = urlBuilder.toString();

        if (url.endsWith("?") || url.endsWith("&")) {
            url = url.substring(0, url.length() - 1);
        }
        return url;
    }

    @Override
    public String toString() {
        return "HttpRequest("
                + "protocol=" + protocol
                + ", method=" + method
                + ", domain=" + domain
                + ", uriPattern=" + uriPattern
                + ", headers=" + headers
                + ", pathParameters=" + pathParameters
                + ", queryParameters=" + queryParameters
                + ", body=" + (body == null ? null : Hex.encodeHexString(body))
                + ")";
    }

    private static String populatePathParams(String uriPattern, Map<String, String> pathParams) {
        if (pathParams == null || pathParams.isEmpty()) {
            return uriPattern;
        }

        String result = uriPattern;
        for (Map.Entry<String, String> entry : pathParams.entrySet()) {
            String key = entry.getKey();
            String value = UrlUtils.encode(entry.getValue());
            String target = "[" + key + "]";
            result = result.replace(target, value);
        }
        return result;
    }
}
