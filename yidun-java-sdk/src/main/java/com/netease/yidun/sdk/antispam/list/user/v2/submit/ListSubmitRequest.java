package com.netease.yidun.sdk.antispam.list.user.v2.submit;


import com.netease.yidun.sdk.core.request.PostFormRequest;
import lombok.Data;

import com.netease.yidun.sdk.core.validation.limitation.NotBlank;
import com.netease.yidun.sdk.core.validation.limitation.NotNull;
import java.util.Map;

/**
 * 图片名单添加请求
 */
@Data
public class ListSubmitRequest extends PostFormRequest<ListSubmitResponse> {
    /**
     * 名单分类，1: 白名单，2: 黑名单 106: 封禁名单
     */
    @NotNull(message = "listType不能为空")
    private Integer listType;
    /**
     * 名单类型，1: 用户名单，2: IP名单，3: 设备名单 6: 直播账号名单
     */
    @NotNull(message = "entityType不能为空")
    private Integer entityType;

    /**
     * 名单列表，json字符串
     */
    @NotBlank(message = "entities不能为空")
    private String entities;
    /**
     * 添加原因
     */
    private String description;
    /**
     * 释放时间，设置此值表示名单到指定时间失效，单位为ms
     */
    private Long releaseTime;
    /**
     * 是否需要确认，默认false，false-不需要确认，直接覆盖；true：需要确认，当黑名单已存在时，添加白名单会给提示
     */
    private Boolean needConfirm;
    /**
     * 是否不需要回调，默认false，false-需要回调；true：不需要回调
     */
    private Boolean notCallback;
    /**
     * 垃圾类型：0-正常，100-色情，200-广告，300-暴恐，400-违禁，500-涉政, 900-其他，1100-涉价值观
     */
    private Integer spamType;
    /**
     * 业务id
     */
    protected String businessId;

    public ListSubmitRequest() {
        productCode = "list";
        version = "v2";
        uriPattern = "/v2/list/submit";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("listType", listType != null ? String.valueOf(listType) : null);
        params.put("entityType", entityType != null ? String.valueOf(entityType) : null);
        params.put("entities", entities);
        params.put("description", description);
        params.put("releaseTime", releaseTime != null ? String.valueOf(releaseTime) : null);
        params.put("needConfirm", needConfirm != null ? String.valueOf(needConfirm) : null);
        params.put("notCallback", notCallback != null ? String.valueOf(notCallback) : null);
        params.put("spamType", spamType != null ? String.valueOf(spamType) : null);
        params.put("businessId", businessId);
        return params;
    }

    @Override
    public Class<ListSubmitResponse> getResponseClass() {
        return ListSubmitResponse.class;
    }

}
