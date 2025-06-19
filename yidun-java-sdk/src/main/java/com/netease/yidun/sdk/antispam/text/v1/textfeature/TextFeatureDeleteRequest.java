package com.netease.yidun.sdk.antispam.text.v1.textfeature;

import com.netease.yidun.sdk.core.request.BizPostFormRequest;

/**
 * 文本特征删除请求
 */
public class TextFeatureDeleteRequest extends BizPostFormRequest<TextFeatureDeleteResponse> {
    private String version = "v1";
    private String uuids;

    public TextFeatureDeleteRequest() {
        productCode = "text-api";
        uriPattern = "/v1/text-feature/delete";
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

    @Override
    public Class<TextFeatureDeleteResponse> getResponseClass() {
        return TextFeatureDeleteResponse.class;
    }

    @Override
    protected java.util.Map<String, String> getCustomSignParams() {
        java.util.Map<String, String> params = super.getCustomSignParams();
        params.put("version", version);
        if (uuids != null) params.put("uuids", uuids);
        return params;
    }

    @Override
    public String toString() {
        return "TextFeatureDeleteRequest(" +
                "version=" + version +
                ", uuids=" + uuids +
                ")";
    }
}
