package com.netease.yidun.sdk.core.request;

import com.netease.yidun.sdk.core.auth.Credentials;
import com.netease.yidun.sdk.core.auth.Signer;
import com.netease.yidun.sdk.core.http.HttpHeaders;
import com.netease.yidun.sdk.core.http.HttpMethodEnum;
import com.netease.yidun.sdk.core.http.HttpRequest;
import com.netease.yidun.sdk.core.response.BaseResponse;

import java.util.Collections;
import java.util.Map;

/**
 * 用于get请求的封装，提供默认参数和签名的默认实现
 * @param <T>
 */
public abstract class GetRequest<T extends BaseResponse> extends PostFormRequest<T> {

    protected GetRequest() {
        super();
        method = HttpMethodEnum.GET;
    }

    /**
     * 获取待签名参数列表，调用子类方法添加个性化参数。<br/>
     * 自动添加公共参数包括 timestamp, nonce, signatureMethod（如果不为null）。<br/>
     * 注：secretId 会在计算签名前被自动添加。
     *
     * @return 返回需要参与签名的参数
     */
    protected Map<String, String> getSignParams() {
        Map<String, String> params = getCustomSignParams();
        params.put("timestamp", String.valueOf(timestamp));
        params.put("nonce", nonce);
        if (signatureMethod != null) {
            params.put("signatureMethod", signatureMethod.name());
        }
        return params;
    }

    /**
     * 获取具体业务中特有的需要参与签名计算的参数
     *
     * @return 返回需要参与签名的参数
     */
    protected abstract Map<String, String> getCustomSignParams();

    /**
     * 获取具体业务中特有的不参与签名计算的参数
     *
     * @return 返回无需参与签名的参数
     */
    protected Map<String, String> getNonSignParams() {
        return Collections.emptyMap();
    }

    /**
     * 默认添加 Content-Type 与 Content-Encoding（如果指定gzip压缩），子类可继承后在其上追加
     */
    @Override
    public Map<String, String> getHeaders() {
        Map<String, String> headers = super.getHeaders();
        headers.put(HttpHeaders.SDK_VERSION, HttpHeaders.DEFAULT_SDK_VERSION);

        if (gzipCompress) {
            headers.put(HttpHeaders.CONTENT_ENCODING, "gzip");
        }

        return headers;
    }

    /**
     * 构建http请求
     *
     * @param signer
     * @param credentials
     * @return
     */
    @Override
    public HttpRequest toHttpRequest(Signer signer, Credentials credentials) {
        return new HttpRequest()
                .protocol(protocol)
                .method(method)
                .domain(domain)
                .uriPattern(uriPattern)
                .headers(getHeaders())
                .pathParameters(getPathParameters())
                .queryParameters(getQueryParameters());
    }

    @Override
    public String toString() {
        String str = "GetRequest("
                + "super=" + super.toString()
                + ", version=" + version
                + ", timestamp=" + timestamp
                + ", nonce=" + nonce;

        if (signatureMethod != null) {
            str += ", signatureMethod=" + signatureMethod.name();
        }

        str += ", gzipCompress=" + gzipCompress
                + ")";

        return str;
    }
}
