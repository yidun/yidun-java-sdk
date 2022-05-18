/*
 * @(#) PostFormRequest.java 2021-01-07
 *
 * Copyright 2021 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.core.request;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;
import java.util.zip.GZIPOutputStream;

import com.netease.yidun.sdk.core.auth.Credentials;
import com.netease.yidun.sdk.core.auth.SignResult;
import com.netease.yidun.sdk.core.auth.SignatureMethodEnum;
import com.netease.yidun.sdk.core.auth.Signer;
import com.netease.yidun.sdk.core.client.Client;
import com.netease.yidun.sdk.core.exception.YidunSdkException;
import com.netease.yidun.sdk.core.http.HttpHeaders;
import com.netease.yidun.sdk.core.http.HttpMethodEnum;
import com.netease.yidun.sdk.core.http.HttpRequest;
import com.netease.yidun.sdk.core.response.BaseResponse;
import com.netease.yidun.sdk.core.utils.StringHashMap;
import com.netease.yidun.sdk.core.utils.UrlUtils;

/**
 * 为方便子服务对接，集成常用操作
 * 
 * @formatter:off
 * 包含特性：
 * 1. 用 HTTP POST 提交参数（表单），Content-Type 为 application/x-www-form-urlencoded;charset=utf-8
 * 2. 添加签名（由 {@link Client} 在提交请求前计算并添加签名）。签名信息会作为表单数据的一部分，与其它参数一起提交
 * @formatter:on
 */
public abstract class PostFormRequest<T extends BaseResponse> extends BaseRequest<T> {

    protected String version;
    protected long timestamp = System.currentTimeMillis();
    protected String nonce = UUID.randomUUID().toString().replace("-", "");
    /**
     * 请求签名的Hash计算方法。<br/>
     * 
     * 配合{@link Signer}使用，即{@link Signer}的实现类必须能识别该请求类的签名算法指定方式。<br/>
     * 如果不为null，则此属性会参与签名计算，并传给服务端。
     */
    protected SignatureMethodEnum signatureMethod;
    protected boolean gzipCompress = false;

    protected PostFormRequest() {
        method = HttpMethodEnum.POST;
    }

    public String getVersion() {
        return version;
    }

    public String version() {
        return version;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long timestamp() {
        return timestamp;
    }

    public PostFormRequest<T> timestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String nonce() {
        return nonce;
    }

    public PostFormRequest<T> nonce(String nonce) {
        this.nonce = nonce;
        return this;
    }

    public SignatureMethodEnum getSignatureMethod() {
        return signatureMethod;
    }

    public void setSignatureMethod(SignatureMethodEnum signatureMethod) {
        this.signatureMethod = signatureMethod;
    }

    public SignatureMethodEnum signatureMethod() {
        return signatureMethod;
    }

    public PostFormRequest<T> signatureMethod(SignatureMethodEnum signatureMethod) {
        this.signatureMethod = signatureMethod;
        return this;
    }

    public boolean isGzipCompress() {
        return gzipCompress;
    }

    public void setGzipCompress(boolean gzipCompress) {
        this.gzipCompress = gzipCompress;
    }

    public boolean gzipCompress() {
        return gzipCompress;
    }

    public PostFormRequest<T> gzipCompress(boolean gzipCompress) {
        this.gzipCompress = gzipCompress;
        return this;
    }

    /**
     * 获取待签名参数列表，调用子类方法添加个性化参数。<br/>
     * 自动添加公共参数包括 version, timestamp, nonce, signatureMethod（如果不为null）。<br/>
     * 注：secretId 会在计算签名前被自动添加。
     *
     * @return 返回需要参与签名的参数
     */
    protected Map<String, String> getSignParams() {
        Map<String, String> params = getCustomSignParams();
        params.put("version", version);
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
    protected Map<String, String> getCustomSignParams() {
        return new StringHashMap();
    }

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
        headers.put(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=utf-8");
        headers.put(HttpHeaders.SDK_VERSION, HttpHeaders.DEFAULT_SDK_VERSION);

        if (gzipCompress) {
            headers.put(HttpHeaders.CONTENT_ENCODING, "gzip");
        }

        return headers;
    }

    /**
     * 构建body，将参数以form表单格式组装放入body中
     *
     * @param signer
     * @param credentials
     * @return
     */
    private byte[] getBodyWithSign(Signer signer, Credentials credentials) {
        Map<String, String> params = getSignParams();
        SignResult signResult = signer.genSignature(credentials, params);
        params.put("secretId", signResult.getSecretId());
        params.put("signature", signResult.getSignature());
        params.putAll(getNonSignParams());

        byte[] body = UrlUtils.encode(params)
                .getBytes(StandardCharsets.UTF_8);

        if (gzipCompress) {
            body = toGzipBytes(body);
        }

        return body;
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
                .queryParameters(getQueryParameters())
                .body(getBodyWithSign(signer, credentials));
    }

    @Override
    public String toString() {
        String str = "PostFormRequest("
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

    private static byte[] toGzipBytes(byte[] rawBytes) {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        try {
            try (GZIPOutputStream gzipStream = new GZIPOutputStream(outStream)) {
                gzipStream.write(rawBytes);
            }
        } catch (IOException e) {
            throw new YidunSdkException("Fail to gzip request body.", e);
        }

        return outStream.toByteArray();
    }
}
