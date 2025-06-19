package com.netease.yidun.sdk.antispam.text.v1.textfeature;

import com.netease.yidun.sdk.core.request.BizPostFormRequest;

/**
 * 文本特征状态修改请求
 */
public class TextFeatureEditStatusRequest extends BizPostFormRequest<TextFeatureEditStatusResponse> {
    private String version = "v1";
    private String uuids;
    private Integer status;

    public TextFeatureEditStatusRequest() {
        productCode = "text-api";
        uriPattern = "/v1/text-feature/edit-status";
    }

    @Override
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUuids() {
        return uuids;
    }

    public void setUuids(String uuids) {
        this.uuids = uuids;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public Class<TextFeatureEditStatusResponse> getResponseClass() {
        return TextFeatureEditStatusResponse.class;
    }

    @Override
    protected java.util.Map<String, String> getCustomSignParams() {
        java.util.Map<String, String> params = super.getCustomSignParams();
        params.put("version", version);
        if (uuids != null) params.put("uuids", uuids);
        if (status != null) params.put("status", String.valueOf(status));
        return params;
    }

    @Override
    public String toString() {
        return "TextFeatureEditStatusRequest(" + "version=" + version + ", uuids=" + uuids + ", status=" + status + ")";
    }
}
