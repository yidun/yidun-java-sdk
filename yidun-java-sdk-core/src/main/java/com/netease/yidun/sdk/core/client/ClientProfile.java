

package com.netease.yidun.sdk.core.client;

import java.util.ArrayList;
import java.util.List;

import com.netease.yidun.sdk.core.auth.Credentials;
import com.netease.yidun.sdk.core.auth.Signer;
import com.netease.yidun.sdk.core.auth.SignerImpl;
import com.netease.yidun.sdk.core.endpoint.EndpointConfigEntry;
import com.netease.yidun.sdk.core.endpoint.failover.FixedWindowBreakStrategy;
import com.netease.yidun.sdk.core.http.HttpClientConfig;
import com.netease.yidun.sdk.core.recover.RequestRecover;
import com.netease.yidun.sdk.core.request.BaseRequest;

public class ClientProfile {

    /**
     * 默认地域：杭州
     */
    public static final String DEFAULT_REGION_CODE = "cn-hangzhou";
    public static final Signer DEFAULT_SIGNER = SignerImpl.INSTANCE;
    public static final int DEFAULT_MAX_RETRY_COUNT = 3;
    /** 最大重试次数的上限。防止客户误设置不合理的超大重试次数，导致易盾服务端在极端情况下（集群异常再恢复），积累请求太多，压垮服务。 */
    public static final int MAX_RETRY_COUNT_LIMIT = 10;
    public static final int NO_RETRY_COUNT = 0;

    /**
     * 用户可以指定首选域名。这些域名会被添加到默认域名列表头部
     */
    private List<EndpointConfigEntry> primaryEndpoints;
    private String regionCode = DEFAULT_REGION_CODE;
    private Signer signer = DEFAULT_SIGNER;
    private Credentials credentials;
    private HttpClientConfig httpClientConfig;
    private FixedWindowBreakStrategy.Config breakerConfig;
    private int maxRetryCount = DEFAULT_MAX_RETRY_COUNT;
    private RequestRecover requestRecover;

    private List<Class<?>> preheatRequestClassesForValidation = new ArrayList<>();
    private List<BaseRequest> preheatRequestsForValidation = new ArrayList<>();

    public List<EndpointConfigEntry> getPrimaryEndpoints() {
        return primaryEndpoints;
    }

    public void setPrimaryEndpoints(List<EndpointConfigEntry> primaryEndpoints) {
        this.primaryEndpoints = primaryEndpoints;
    }

    public List<EndpointConfigEntry> primaryEndpoints() {
        return primaryEndpoints;
    }

    public ClientProfile primaryEndpoints(List<EndpointConfigEntry> entries) {
        this.primaryEndpoints = entries;
        return this;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String regionCode() {
        return regionCode;
    }

    /**
     * 易盾服务所属地域代号。针对不同地域，单个服务可能有不同的访问域名。在每个地域，单个服务可能有多个访问域名。默认值：{@link #DEFAULT_REGION_CODE}
     */
    public ClientProfile regionCode(String regionCode) {
        this.regionCode = regionCode;
        return this;
    }

    public Signer getSigner() {
        return signer;
    }

    public void setSigner(Signer signer) {
        this.signer = signer;
    }

    public Signer signer() {
        return signer;
    }

    /**
     * 用于计算请求签名。默认：{@link #DEFAULT_SIGNER}
     */
    public ClientProfile signer(Signer signer) {
        this.signer = signer;
        return this;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public Credentials credentials() {
        return credentials;
    }

    /**
     * 访问易盾服务的凭证信息。可以登录易盾官网找到自己的凭证信息。请妥善保管，避免泄露。
     */
    public ClientProfile credentials(Credentials credentials) {
        this.credentials = credentials;
        return this;
    }

    /**
     * 访问易盾服务的凭证信息。可以登录易盾官网找到自己的凭证信息。请妥善保管，避免泄露。
     */
    public ClientProfile credentials(String secretId, String secretKey) {
        credentials(new Credentials(secretId, secretKey));
        return this;
    }

    public HttpClientConfig getHttpClientConfig() {
        return httpClientConfig;
    }

    public void setHttpClientConfig(HttpClientConfig httpClientConfig) {
        this.httpClientConfig = httpClientConfig;
    }

    public HttpClientConfig httpClientConfig() {
        return httpClientConfig;
    }

    /**
     * HTTP客户端相关配置
     */
    public ClientProfile httpClientConfig(HttpClientConfig httpClientConfig) {
        this.httpClientConfig = httpClientConfig;
        return this;
    }

    public FixedWindowBreakStrategy.Config getBreakerConfig() {
        return breakerConfig;
    }

    public void setBreakerConfig(FixedWindowBreakStrategy.Config breakerConfig) {
        this.breakerConfig = breakerConfig;
    }

    public FixedWindowBreakStrategy.Config breakerConfig() {
        return breakerConfig;
    }

    public ClientProfile breakerConfig(FixedWindowBreakStrategy.Config breakerConfig) {
        this.breakerConfig = breakerConfig;
        return this;
    }

    public int getMaxRetryCount() {
        return maxRetryCount;
    }

    public void setMaxRetryCount(int maxRetryCount) {
        this.maxRetryCount = Math.min(maxRetryCount, MAX_RETRY_COUNT_LIMIT);
    }

    public int maxRetryCount() {
        return maxRetryCount;
    }

    /**
     * 最大重试次数。如果小于等于0，则不重试
     */
    public ClientProfile maxRetryCount(int maxRetryCount) {
        setMaxRetryCount(maxRetryCount);
        return this;
    }

    /**
     * 不重试
     */
    public ClientProfile noRetry() {
        return maxRetryCount(NO_RETRY_COUNT);
    }

    public List<Class<?>> getPreheatRequestClassesForValidation() {
        return preheatRequestClassesForValidation;
    }

    public void setPreheatRequestClassesForValidation(List<Class<?>> preheatRequestClassesForValidation) {
        this.preheatRequestClassesForValidation = preheatRequestClassesForValidation;
    }

    public List<Class<?>> preheatRequestClassesForValidation() {
        return preheatRequestClassesForValidation;
    }

    /** 设置需要参与 javax validation 预热的 Request 类型 */
    public ClientProfile preheatRequestClassesForValidation(Class<?>... classes) {
        for (Class<?> clazz : classes) {
            preheatRequestClassesForValidation.add(clazz);
        }

        return this;
    }

    public RequestRecover getRequestRecover() {
        return requestRecover;
    }

    public void setRequestRecover(RequestRecover requestRecover) {
        this.requestRecover = requestRecover;
    }

    public RequestRecover requestRecover() {
        return requestRecover;
    }

    /**
     * 请求失败恢复器
     */
    public ClientProfile requestRecover(RequestRecover requestRecover) {
        setRequestRecover(requestRecover);
        return this;
    }

    public List<BaseRequest> getPreheatRequestsForValidation() {
        return preheatRequestsForValidation;
    }

    public void setPreheatRequestsForValidation(List<BaseRequest> preheatRequestsForValidation) {
        this.preheatRequestsForValidation = preheatRequestsForValidation;
    }

    public List<BaseRequest> preheatRequestsForValidation() {
        return preheatRequestsForValidation;
    }

    /**
     * 设置需要参与 javax validation 预热的 Request 实例 <br>
     * 因为部分 Request 类 可能没有无参构造方法，所以此处允许业务层提供 Request 实例
     */
    public ClientProfile preheatRequestsForValidation(BaseRequest... requests) {
        for (BaseRequest request : requests) {
            preheatRequestsForValidation.add(request);
        }

        return this;
    }

    @Override
    public String toString() {
        return "ClientProfile(" +
                "regionCode=" + regionCode +
                ", httpClientConfig=" + httpClientConfig +
                ", breakerConfig=" + breakerConfig +
                ", maxRetryCount=" + maxRetryCount +
                ")";
    }

    public static ClientProfile defaultProfile(Credentials credentials) {
        return new ClientProfile()
                .credentials(credentials)
                .httpClientConfig(HttpClientConfig.defaultConfig())
                .breakerConfig(FixedWindowBreakStrategy.Config.createDefault());
    }

    public static ClientProfile defaultProfile(String secretId, String secretKey) {
        return defaultProfile(new Credentials(secretId, secretKey));
    }
}
