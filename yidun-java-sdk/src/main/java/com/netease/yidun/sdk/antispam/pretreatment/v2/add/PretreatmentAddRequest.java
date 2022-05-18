package com.netease.yidun.sdk.antispam.pretreatment.v2.add;

import java.util.Map;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.netease.yidun.sdk.core.http.HttpMethodEnum;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;

/**
 * 自定义忽略词添加请求
 */
public class PretreatmentAddRequest extends BizPostFormRequest<PretreatmentAddResponse> {

    /**
     * 添加描述
     */
    @Size(max = 128, message = "description最长128个字符")
    private String description;
    /**
     * 忽略词列表，逗号分隔
     */
    @NotBlank(message = "entitys不能为空")
    private String entitys;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String description() {
        return description;
    }

    public PretreatmentAddRequest description(String description) {
        this.description = description;
        return this;
    }

    public String getEntitys() {
        return entitys;
    }

    public void setEntitys(String entitys) {
        this.entitys = entitys;
    }

    public String entitys() {
        return entitys;
    }

    public PretreatmentAddRequest entitys(String entitys) {
        this.entitys = entitys;
        return this;
    }

    public PretreatmentAddRequest() {
        productCode = "pretreatment";
        version = "v2";
        uriPattern = "/v2/pretreatment/add";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("description", description);
        params.put("entitys", entitys);
        return params;
    }

    @Override
    public Class<PretreatmentAddResponse> getResponseClass() {
        return PretreatmentAddResponse.class;
    }

    @Override
    public String toString() {
        return "PretreatmentAddRequest("
                + "super=" + super.toString()
                + ", description=" + description
                + ", entitys=" + entitys
                + ")";
    }
}
