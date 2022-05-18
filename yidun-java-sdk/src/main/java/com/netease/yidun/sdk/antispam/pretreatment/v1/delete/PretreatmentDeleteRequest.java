package com.netease.yidun.sdk.antispam.pretreatment.v1.delete;

import java.util.Map;

import javax.validation.constraints.NotBlank;

import com.netease.yidun.sdk.core.http.HttpMethodEnum;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;

/**
 * 自定义忽略词删除请求
 */
public class PretreatmentDeleteRequest extends BizPostFormRequest<PretreatmentDeleteResponse> {

    /**
     * 忽略词id列表，逗号分隔
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

    public PretreatmentDeleteRequest ids(String ids) {
        this.ids = ids;
        return this;
    }

    public PretreatmentDeleteRequest() {
        productCode = "pretreatment";
        version = "v1";
        uriPattern = "/v1/pretreatment/batchDelete";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("ids", ids);
        return params;
    }

    @Override
    public Class<PretreatmentDeleteResponse> getResponseClass() {
        return PretreatmentDeleteResponse.class;
    }

    @Override
    public String toString() {
        return "PretreatmentDeleteRequest("
                + "super=" + super.toString()
                + ", ids=" + ids
                + ")";
    }
}
