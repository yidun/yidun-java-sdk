package com.netease.yidun.sdk.antispam.pretreatment.v1.update;

import java.util.Map;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.netease.yidun.sdk.core.http.HttpMethodEnum;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;

/**
 * 自定义忽略词修改请求
 */
public class PretreatmentUpdateRequest extends BizPostFormRequest<PretreatmentUpdateResponse> {

    /**
     * 添加描述
     */
    @Size(max = 128, message = "description最长128个字符")
    private String description;
    /**
     * 忽略词id
     */
    @NotNull(message = "id不能为空")
    private Long id;
    /**
     * 忽略词内容
     */
    @NotBlank(message = "entitys不能为空")
    @Size(max = 128, message = "entity最长128个字符")
    private String entity;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String description() {
        return description;
    }

    public PretreatmentUpdateRequest description(String description) {
        this.description = description;
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long id() {
        return id;
    }

    public PretreatmentUpdateRequest id(Long id) {
        this.id = id;
        return this;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String entity() {
        return entity;
    }

    public PretreatmentUpdateRequest entity(String entity) {
        this.entity = entity;
        return this;
    }

    public PretreatmentUpdateRequest() {
        productCode = "pretreatment";
        version = "v1";
        uriPattern = "/v1/pretreatment/update";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("description", description);
        params.put("id", id != null ? String.valueOf(id) : null);
        params.put("entity", entity);
        return params;
    }

    @Override
    public Class<PretreatmentUpdateResponse> getResponseClass() {
        return PretreatmentUpdateResponse.class;
    }

    @Override
    public String toString() {
        return "PretreatmentUpdateRequest("
                + "super=" + super.toString()
                + ", description=" + description
                + ", id=" + id
                + ", entity=" + entity
                + ")";
    }
}
