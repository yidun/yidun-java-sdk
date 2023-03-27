package com.netease.yidun.sdk.antispam.list.user.v2.delete;


import com.netease.yidun.sdk.core.request.PostFormRequest;
import lombok.Data;

import com.netease.yidun.sdk.core.validation.limitation.NotNull;
import java.util.Map;

/**
 * 图片名单删除请求
 */
@Data
public class ListDeleteRequest extends PostFormRequest<ListDeleteResponse> {
    /**
     * uuids和entities传一个即可，名单唯一标识id列表数组,json字符串
     */
    private String uuids;
    /**
     * 名单类型，1: 用户名单，2: IP名单，3: 设备名单
     */
    @NotNull(message = "entityType不能为空")
    private Integer entityType;
    /**
     * 名单分类，1: 白名单，2: 黑名单
     */
    private Integer listType;
    /**
     * 添加时传入的名单值
     */
    private String entities;
    /**
     * 业务id
     */
    protected String businessId;

    public ListDeleteRequest() {
        productCode = "list";
        version = "v2";
        uriPattern = "/v2/list/batchDelete";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("uuids", uuids);
        params.put("entityType", entityType != null ? String.valueOf(entityType) : null);
        params.put("listType", listType != null ? String.valueOf(listType) : null);
        params.put("entities", entities);
        params.put("businessId", businessId);
        return params;
    }

    @Override
    public Class<ListDeleteResponse> getResponseClass() {
        return ListDeleteResponse.class;
    }

}
