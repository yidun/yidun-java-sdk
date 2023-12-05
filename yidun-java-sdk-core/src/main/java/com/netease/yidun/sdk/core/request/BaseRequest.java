

package com.netease.yidun.sdk.core.request;

import com.netease.yidun.sdk.core.auth.Credentials;
import com.netease.yidun.sdk.core.auth.Signer;
import com.netease.yidun.sdk.core.http.HttpMethodEnum;
import com.netease.yidun.sdk.core.http.HttpRequest;
import com.netease.yidun.sdk.core.http.ProtocolEnum;
import com.netease.yidun.sdk.core.response.BaseResponse;
import com.netease.yidun.sdk.core.utils.StringHashMap;
import com.netease.yidun.sdk.core.validation.limitation.NotBlank;
import com.netease.yidun.sdk.core.validation.limitation.NotNull;

import java.util.Collections;
import java.util.Map;

public abstract class BaseRequest<T extends BaseResponse> {

    protected String regionCode;

    protected ProtocolEnum protocol;

    /**
     * 当HTTPS请求失败时，是否尝试使用HTTP协议进行重试
     */
    protected Boolean fallbackHttp;

    /**
     * 指定域名
     */
    protected String domain;

    @NotBlank(message = "productCode不能为空")
    protected String productCode;

    /**
     * URL模板，如/api/v1/getname/[id]
     */
    @NotBlank(message = "uriPattern不能为空")
    protected String uriPattern;

    @NotNull(message = "method不能为空")
    protected HttpMethodEnum method;

    /**
     * 当前请求是否启动recover
     */
    private boolean enableRecover = true;

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String regionCode() {
        return regionCode;
    }

    public BaseRequest<T> regionCode(String regionCode) {
        this.regionCode = regionCode;
        return this;
    }

    public ProtocolEnum getProtocol() {
        return protocol;
    }

    public void setProtocol(ProtocolEnum protocol) {
        this.protocol = protocol;
    }

    public ProtocolEnum protocol() {
        return protocol;
    }

    public BaseRequest<T> protocol(ProtocolEnum protocol) {
        this.protocol = protocol;
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

    public BaseRequest<T> domain(String domain) {
        this.domain = domain;
        return this;
    }

    public String getProductCode() {
        return productCode;
    }

    public String productCode() {
        return productCode;
    }

    public String getUriPattern() {
        return uriPattern;
    }

    public String uriPattern() {
        return uriPattern;
    }

    public HttpMethodEnum getMethod() {
        return method;
    }

    public HttpMethodEnum method() {
        return method;
    }

    /**
     * 默认返回空，子类可继承后在其上追加
     */
    public Map<String, String> getHeaders() {
        return new StringHashMap();
    }

    /**
     * 默认返回空，子类可复写
     */
    public Map<String, String> getPathParameters() {
        return Collections.emptyMap();
    }

    /**
     * 默认返回空，子类可复写
     */
    public Map<String, String> getQueryParameters() {
        return Collections.emptyMap();
    }

    /**
     * 默认返回null，子类可复写
     */
    public byte[] getBody() {
        return null;
    }

    public abstract Class<T> getResponseClass();
    
    // 默认全局返回nul，即不支持使用泛型
    public java.lang.reflect.Type getResponseType() {
        return null;
    }

    public abstract HttpRequest toHttpRequest(Signer signer, Credentials credentials);

    public boolean isEnableRecover() {
        return enableRecover;
    }

    public void setEnableRecover(boolean enableRecover) {
        this.enableRecover = enableRecover;
    }

    public Boolean getFallbackHttp() {
        return fallbackHttp;
    }

    public void setFallbackHttp(Boolean fallbackHttp) {
        this.fallbackHttp = fallbackHttp;
    }

    @Override
    public String toString() {
        return "BaseRequest("
                + "regionCode=" + regionCode
                + ", protocol=" + protocol
                + ", domain=" + domain
                + ", productCode=" + productCode
                + ", uriPattern=" + uriPattern
                + ", method=" + method
                + ", fallbackHttp=" + fallbackHttp
                + ")";
    }
}
