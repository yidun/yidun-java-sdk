package com.netease.yidun.sdk.antispam.list.user.v2.update;


import com.netease.yidun.sdk.core.request.PostFormRequest;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * 图片名单更新请求
 */
@Data
public class ListUpdateRequest extends PostFormRequest<ListUpdateResponse> {
    /**
     * 名单类型，1: 用户名单，2: IP名单，3: 设备名单 6: 直播账号名单
     */
    @NotNull(message = "entityType不能为空")
    private Integer entityType;
    /**
     * 添加时传入的名单值
     */
    private String entity;
    /**
     * 名单唯一标识，通常为32位长度由数字或者字母组成，用来删除修改和查询
     */
    private String uuid;
    /**
     * 名单分类，1: 白名单，2: 黑名单，106: 封禁名单
     */
    @NotNull(message = "listType不能为空")
    private Integer listType;
    /**
     * 名单状态：0：失效，1： 生效
     */
    @NotNull(message = "status不能为空")
    private Integer status;
    /**
     * 是否不需要回调，默认false，false-需要回调；true：不需要回调
     */
    private Boolean notCallback;
    /**
     * 释放时间，设置此值表示名单到指定时间失效，单位为ms
     */
    private Long releaseTime;
    /**
     * 垃圾类型：0-正常，100-色情，200-广告，300-暴恐，400-违禁，500-涉政, 900-其他，1100-涉价值观
     */
    private Integer spamType;
    /**
     * 业务id
     */
    protected String businessId;

    public ListUpdateRequest() {
        productCode = "list";
        version = "v2";
        uriPattern = "/v2/list/update";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("entityType", entityType != null ? String.valueOf(entityType) : null);
        params.put("entity", entity);
        params.put("uuid", uuid);
        params.put("listType", listType != null ? String.valueOf(listType) : null);
        params.put("status", status != null ? String.valueOf(status) : null);
        params.put("notCallback", notCallback != null ? String.valueOf(notCallback) : null);
        params.put("releaseTime", releaseTime != null ? String.valueOf(releaseTime) : null);
        params.put("spamType", spamType != null ? String.valueOf(spamType) : null);
        params.put("businessId", businessId);
        return params;
    }

    @Override
    public Class<ListUpdateResponse> getResponseClass() {
        return ListUpdateResponse.class;
    }

}
