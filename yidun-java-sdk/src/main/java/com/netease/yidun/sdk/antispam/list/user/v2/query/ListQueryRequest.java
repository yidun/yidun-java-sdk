package com.netease.yidun.sdk.antispam.list.user.v2.query;


import com.netease.yidun.sdk.core.request.PostFormRequest;
import lombok.Data;

import com.netease.yidun.sdk.core.validation.limitation.NotNull;
import java.util.Map;

/**
 * 图片名单查询请求
 */
@Data
public class ListQueryRequest extends PostFormRequest<ListQueryResponse> {
    /**
     * 名单分类，1: 白名单，2: 黑名单
     */
    private Integer listType;
    /**
     * 名单类型，1: 用户名单，2: IP名单，3: 设备名单
     */
    @NotNull(message = "entityType不能为空")
    private Integer entityType;
    /**
     * 页数
     */
    @NotNull(message = "pageNum不能为空")
    private Integer pageNum;
    /**
     * 每页大小
     */
    @NotNull(message = "pageSize不能为空")
    private Integer pageSize;
    /**
     * 查询开始时间
     */
    @NotNull(message = "startTime不能为空")
    private Long startTime;
    /**
     * 查询结束时间
     */
    @NotNull(message = "endTime不能为空")
    private Long endTime;

    /**
     * 名单添加来源 0-后台添加 1-用户名单配置 2-用户审核添加 3-内容审核添加
     */
    private Integer source;
    /**
     * 添加时传入的名单值
     */
    private String entity;
    /**
     * 名单状态：0：失效，1： 生效
     */
    private Integer status;
    /**
     * 排序类型 0-插入时间降序 1-插入时间升序 2-命中数量升序 3-命中数量降序
     */
    private Integer orderType;
    /**
     * 名单唯一标识，通常为32位长度由数字或者字母组成，用来删除修改和查询
     */
    private String uuid;
    /**
     * 垃圾类型：0-正常，100-色情，200-广告，300-暴恐，400-违禁，500-涉政, 900-其他，1100-涉价值观
     */
    private Integer spamType;
    /**
     * 业务id
     */
    protected String businessId;

    public ListQueryRequest() {
        productCode = "list";
        version = "v2";
        uriPattern = "/v2/list/pageQuery";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("listType", listType != null ? String.valueOf(listType) : null);
        params.put("entityType", entityType != null ? String.valueOf(entityType) : null);
        params.put("pageNum", pageNum != null ? String.valueOf(pageNum) : null);
        params.put("pageSize", pageSize != null ? String.valueOf(pageSize) : null);
        params.put("startTime", startTime != null ? String.valueOf(startTime) : null);
        params.put("endTime", endTime != null ? String.valueOf(endTime) : null);
        params.put("source", source != null ? String.valueOf(source) : null);
        params.put("entity", entity);
        params.put("status", status != null ? String.valueOf(status) : null);
        params.put("orderType", orderType != null ? String.valueOf(orderType) : null);
        params.put("uuid", uuid);
        params.put("spamType", spamType != null ? String.valueOf(spamType) : null);
        params.put("businessId", businessId);
        return params;
    }

    @Override
    public Class<ListQueryResponse> getResponseClass() {
        return ListQueryResponse.class;
    }

}
