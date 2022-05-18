package com.netease.yidun.sdk.antispam.keyword.v1.delete;

import java.util.Map;

import javax.validation.constraints.NotBlank;

import com.netease.yidun.sdk.core.http.HttpMethodEnum;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;

/**
 * 自定义关键词删除请求
 */
public class KeywordDeleteRequest extends BizPostFormRequest<KeywordDeleteResponse> {

    /**
     * 关键词唯一标识id列表，逗号分隔
     */
    @NotBlank(message = "ids不能为空")
    private String ids;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String ids() {
        return ids;
    }

    public KeywordDeleteRequest ids(String ids) {
        this.ids = ids;
        return this;
    }

    public KeywordDeleteRequest() {
        productCode = "keyword";
        version = "v1";
        uriPattern = "/v1/keyword/delete";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("ids", ids);
        return params;
    }

    @Override
    public Class<KeywordDeleteResponse> getResponseClass() {
        return KeywordDeleteResponse.class;
    }

    @Override
    public String toString() {
        return "KeywordDeleteRequest("
                + "super=" + super.toString()
                + ", ids=" + ids
                + ")";
    }
}
