/*
 * @(#) DefaultClient.java 2020-07-09
 *
 * Copyright 2020 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.core.client;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ConnectionRequestTimeoutException;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.io.entity.ByteArrayEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;

import com.google.gson.Gson;
import com.netease.yidun.sdk.core.auth.Credentials;
import com.netease.yidun.sdk.core.auth.Signer;
import com.netease.yidun.sdk.core.endpoint.CompoundEndpointResolver;
import com.netease.yidun.sdk.core.endpoint.DefaultEndpointResolver;
import com.netease.yidun.sdk.core.endpoint.EndpointConfigEntry;
import com.netease.yidun.sdk.core.endpoint.EndpointResolver;
import com.netease.yidun.sdk.core.endpoint.failover.BreakStrategy;
import com.netease.yidun.sdk.core.endpoint.failover.FixedWindowBreakStrategy;
import com.netease.yidun.sdk.core.exception.YidunSdkException;
import com.netease.yidun.sdk.core.http.HttpClientConfig;
import com.netease.yidun.sdk.core.http.HttpClientFactory;
import com.netease.yidun.sdk.core.http.HttpHeaders;
import com.netease.yidun.sdk.core.http.HttpMethodEnum;
import com.netease.yidun.sdk.core.http.HttpRequest;
import com.netease.yidun.sdk.core.http.ProtocolEnum;
import com.netease.yidun.sdk.core.request.BaseRequest;
import com.netease.yidun.sdk.core.response.BaseResponse;
import com.netease.yidun.sdk.core.utils.ObjectUtils;
import com.netease.yidun.sdk.core.utils.StringUtils;
import com.netease.yidun.sdk.core.utils.ValidationUtils;

public class DefaultClient implements Client, Closeable {

    private final String defaultRegionCode;
    private final ProtocolEnum defaultProtocol;
    private final Signer signer;
    private final Credentials credentials;
    /** ?????????????????????????????? */
    private final int maxAttemptCount;
    private CloseableHttpClient httpClient;
    private EndpointResolver endpointResolver;
    private BreakStrategy breakStrategy;

    public DefaultClient(ClientProfile profile) {
        Objects.requireNonNull(profile.signer(), "signer should not be null");
        Objects.requireNonNull(profile.credentials(), "credentials should not be null");

        signer = profile.signer();
        credentials = profile.credentials();
        defaultRegionCode = StringUtils.defaultIfBlank(profile.regionCode(), ClientProfile.DEFAULT_REGION_CODE);
        maxAttemptCount = 1 + Math.max(profile.maxRetryCount(), 0);

        HttpClientConfig httpClientConfig = profile.httpClientConfig();
        if (httpClientConfig == null) {
            httpClientConfig = HttpClientConfig.defaultConfig();
        }

        defaultProtocol = ObjectUtils.defaultIfNull(httpClientConfig.protocol(), HttpClientConfig.DEFAULT_PROTOCOL);

        httpClient = HttpClientFactory.create(httpClientConfig);

        List<EndpointConfigEntry> primaryEndpoints = profile.primaryEndpoints();
        endpointResolver = (primaryEndpoints == null || primaryEndpoints.isEmpty())
                ? DefaultEndpointResolver.getInstance()
                : new CompoundEndpointResolver(primaryEndpoints);

        FixedWindowBreakStrategy.Config breakerConfig = profile.breakerConfig();
        breakStrategy = breakerConfig == null
                ? FixedWindowBreakStrategy.createDefault()
                : new FixedWindowBreakStrategy(breakerConfig);

        preheatValidation(profile.preheatRequestClassesForValidation());
        preheatValidationByInstance(profile.preheatRequestsForValidation());
    }

    public String getDefaultRegionCode() {
        return defaultRegionCode;
    }

    public String defaultRegionCode() {
        return defaultRegionCode;
    }

    public ProtocolEnum getDefaultProtocol() {
        return defaultProtocol;
    }

    public ProtocolEnum defaultProtocol() {
        return defaultProtocol;
    }

    public Signer getSigner() {
        return signer;
    }

    public Signer signer() {
        return signer;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public Credentials credentials() {
        return credentials;
    }

    public int getMaxAttemptCount() {
        return maxAttemptCount;
    }

    public int maxAttemptCount() {
        return maxAttemptCount;
    }

    public CloseableHttpClient getHttpClient() {
        return httpClient;
    }

    public CloseableHttpClient httpClient() {
        return httpClient;
    }

    public void setHttpClient(CloseableHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public DefaultClient httpClient(CloseableHttpClient httpClient) {
        this.httpClient = httpClient;
        return this;
    }

    public EndpointResolver getEndpointResolver() {
        return endpointResolver;
    }

    public EndpointResolver endpointResolver() {
        return endpointResolver;
    }

    public void setEndpointResolver(EndpointResolver endpointResolver) {
        this.endpointResolver = endpointResolver;
    }

    public DefaultClient endpointResolver(EndpointResolver endpointResolver) {
        this.endpointResolver = endpointResolver;
        return this;
    }

    public BreakStrategy getBreakStrategy() {
        return breakStrategy;
    }

    public BreakStrategy breakStrategy() {
        return breakStrategy;
    }

    public void setBreakStrategy(BreakStrategy breakStrategy) {
        this.breakStrategy = breakStrategy;
    }

    public DefaultClient breakStrategy(BreakStrategy breakStrategy) {
        this.breakStrategy = breakStrategy;
        return this;
    }

    @Override
    public <R extends BaseResponse> R execute(BaseRequest<R> request) throws YidunSdkException {
        ValidationUtils.validate(request);

        if (request.protocol() == null) {
            request.protocol(defaultProtocol);
        }

        if (StringUtils.isBlank(request.regionCode())) {
            request.regionCode(defaultRegionCode);
        }

        Context<R> ctx = new Context<>(request);
        YidunSdkException exception = null;
        while (ctx.canAttempt()) {
            ClassicHttpRequest httpRequest = ctx.createRequest();

            CloseableHttpResponse httpResponse = null;
            try {
                httpResponse = httpClient.execute(httpRequest);

                if (isServerError(httpResponse)) {
                    ctx.requestFail(httpResponse);
                } else {
                    ctx.requestSuccess(httpResponse);
                    exception = null;
                    break;
                }
            } catch (ConnectionRequestTimeoutException e) {
                // ??????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
                exception = new YidunSdkException("Fail to request server: " + e.getMessage(), e);
            } catch (Exception e) {
                ctx.requestFail(httpResponse);
                exception = new YidunSdkException("Fail to request server: " + e.getMessage(), e);
            } finally {
                ctx.incrementAttemptCount();
            }
        }

        if (exception != null) {
            throw exception;
        }

        return ctx.parseResponse();
    }

    private class Context<R extends BaseResponse> {
        final BaseRequest<R> request;
        CloseableHttpResponse response;
        /** ?????????????????????????????? */
        int attemptedCount = 0;
        /** ?????????????????????????????????????????? */
        final boolean usePreassignedDomain;
        /** ???????????????????????????????????? {@link #endpointResolver} ??????????????? */
        String[] allDomains = null;
        /** ?????????????????????????????????????????????????????? */
        int currentDomainIndex = -1;
        /** ??????????????????????????????????????????????????????????????? */
        boolean firstAttempt = true;
        /** ???????????????????????????????????????????????????????????????????????? */
        boolean allDomainsApplied = false;

        Context(BaseRequest<R> request) {
            this.request = request;
            usePreassignedDomain = StringUtils.isNotBlank(request.domain());
        }

        ClassicHttpRequest createRequest() {
            // ?????????????????????????????????????????????????????????????????????????????????
            resolveDomain();

            HttpRequest tmpRequest = request.toHttpRequest(signer, credentials);

            HttpMethodEnum method = tmpRequest.method();
            Map<String, String> headers = tmpRequest.headers();

            ClassicRequestBuilder builder = ClassicRequestBuilder.create(method.name());
            builder.setUri(tmpRequest.assembleUrl());
            headers.forEach(builder::addHeader);

            if (method.hasContent()) {
                byte[] body = tmpRequest.body();
                if (body != null) {
                    ContentType contentType = ContentType.parse(headers.get(HttpHeaders.CONTENT_TYPE));
                    String contentEncoding = headers.get(HttpHeaders.CONTENT_ENCODING);
                    builder.setEntity(new ByteArrayEntity(body, contentType, contentEncoding));
                }
            }

            return builder.build();
        }

        void resolveDomain() {
            // a. ????????????????????????????????????????????????????????????????????????????????????
            if (usePreassignedDomain) {
                return;
            }

            // b. ??????????????????
            if (firstAttempt) {
                firstAttempt = false;
                resolveDomainForFirstAttempt();
            } else {
                resolveDomainForRetry();
            }
        }

        void resolveDomainForFirstAttempt() {
            // ??????????????????????????????
            allDomains = endpointResolver
                    .resolve(request.productCode(), request.regionCode())
                    .toArray(new String[0]);

            useNextAvailableDomainOrFirstAsDefault();
        }

        void resolveDomainForRetry() {
            // ???????????????????????????????????????????????????????????????????????????
            if (allDomainsApplied) {
                currentDomainIndex = (currentDomainIndex + 1) % allDomains.length;
                request.setDomain(allDomains[currentDomainIndex]);
                return;
            }

            useNextAvailableDomainOrFirstAsDefault();
        }

        /**
         * ???????????????????????????????????????????????????????????????????????????????????????????????????????????????
         */
        void useNextAvailableDomainOrFirstAsDefault() {
            // currentDomainIndex ???????????? -1????????????????????????????????????????????? 0 ??????????????????????????????
            while (currentDomainIndex < allDomains.length - 1) {
                currentDomainIndex++;
                String domain = allDomains[currentDomainIndex];
                if (breakStrategy.attemptAccess(request.productCode(), request.regionCode(), domain)) {
                    request.setDomain(domain);
                    return;
                }
            }

            // ???????????????????????????????????????????????????????????????????????????????????????
            allDomainsApplied = true;
            currentDomainIndex = 0;
            request.setDomain(allDomains[0]);
        }

        void requestFail(CloseableHttpResponse response) {
            this.response = response;

            // ????????????????????????????????????????????????????????????????????????????????????
            if (!usePreassignedDomain) {
                breakStrategy.requestFail(
                        request.productCode(),
                        request.regionCode(),
                        request.domain());
            }
        }

        void requestSuccess(CloseableHttpResponse response) {
            this.response = response;

            // ????????????????????????????????????????????????????????????????????????????????????
            if (!usePreassignedDomain) {
                breakStrategy.requestSuccess(
                        request.productCode(),
                        request.regionCode(),
                        request.domain());
            }
        }

        R parseResponse() throws YidunSdkException {
            if (response == null) {
                throw new YidunSdkException("Server error. null response");
            }

            int statusCode = response.getCode();
            HttpEntity bodyEntity = response.getEntity();

            if (bodyEntity == null) {
                throw new YidunSdkException("Server error. null response body. code=" + statusCode);
            }

            String strBody;
            try {
                strBody = EntityUtils.toString(bodyEntity);
            } catch (Exception e) {
                throw new YidunSdkException("Fail to read response body. code=" + statusCode, e);
            }

            if (statusCode >= HttpStatus.SC_SERVER_ERROR) {
                throw new YidunSdkException(String.format("Server error. code=%s, body=%s", statusCode, strBody));
            }

            if (statusCode >= HttpStatus.SC_OK
                    && statusCode < HttpStatus.SC_REDIRECTION) {
                try {
                    return new Gson().fromJson(strBody, request.getResponseClass());
                } catch (Exception e) {
                    String errorMessage = String.format(
                            "Fail to parse response body. code=%s, body=%s", statusCode, strBody);
                    throw new YidunSdkException(errorMessage, e);
                }
            } else {
                throw new YidunSdkException(
                        String.format("Server response fail. code=%s, body=%s", statusCode, strBody));
            }
        }

        boolean canAttempt() {
            return attemptedCount < maxAttemptCount;
        }

        void incrementAttemptCount() {
            attemptedCount++;
        }
    }

    private static boolean isServerError(CloseableHttpResponse response) {
        return response == null
                || response.getCode() >= HttpStatus.SC_SERVER_ERROR
                || response.getEntity() == null;
    }

    @Override
    public void close() {
        try {
            if (httpClient != null) {
                httpClient.close();
            }
        } catch (IOException e) {
            // ignore
        }
    }

    @Override
    public String toString() {
        return "DefaultClient("
                + "defaultRegionCode=" + defaultRegionCode
                + ", defaultProtocol=" + defaultProtocol
                + ", maxAttemptCount=" + maxAttemptCount
                + ")";
    }

    private void preheatValidation(Collection<Class<?>> preheatRequestClassesForValidation) {
        // ?????? javax validation ???????????????????????????????????????????????????Request???????????????????????????????????????????????????
        ValidationUtils.preheat(preheatRequestClassesForValidation);
    }

    private void preheatValidationByInstance(Collection<BaseRequest> preheatRequestsForValidation) {
        // ?????? javax validation ???????????????????????????????????????????????????Request???????????????????????????????????????????????????
        ValidationUtils.preheatByInstance(new ArrayList<>(preheatRequestsForValidation));
    }

    public static DefaultClient createDefault(Credentials credentials) {
        return new DefaultClient(ClientProfile.defaultProfile(credentials));
    }

    public static DefaultClient createDefault(String secretId, String secretKey) {
        return createDefault(new Credentials(secretId, secretKey));
    }
}
