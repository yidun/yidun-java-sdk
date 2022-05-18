package com.netease.yidun.sdk.antispam.livevideo.query.v1.request;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.netease.yidun.sdk.antispam.livevideo.query.v1.response.LiveVideoImageQueryResp;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;

import lombok.Getter;
import lombok.Setter;

/**
 * 直播截图查询请求
 */
@Getter
@Setter
public class LiveVideoImageQueryReq extends BizPostFormRequest<LiveVideoImageQueryResp> {
    /**
     * taskId
     */
    private String taskId;

    /**
     * 等级数组，@See LabelLevel; json数组格式[1,2,3]
     */
    private List<Integer> levels;

    private Integer pageNum = 1;

    private Integer pageSize = 20;

    /**
     * 回调状态
     */
    private Integer callbackStatus;

    /**
     * 接收开始时间
     */
    private Long startTime;
    /**
     * 接收结束时间
     */
    private Long endTime;

    /**
     * 排序类型
     *
     * @see LiveDataOrderType
     */
    private Integer orderType = LiveDataOrderType.RECEIVETIME_ASC.getCode();

    public LiveVideoImageQueryReq() {
        productCode = "liveVideo";
        uriPattern = "/v1/livevideo/query/image";
        version = "v1";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        StringHashMap params = new StringHashMap();
        params.putAll(super.getCustomSignParams());
        params.put("taskId", getTaskId());
        params.put("levels", new Gson().toJson(getLevels()));
        params.put("callbackStatus", getCallbackStatus());
        params.put("startTime", getStartTime());
        params.put("endTime", getEndTime());
        params.put("pageNum", getPageNum());
        params.put("pageSize", getPageSize());
        params.put("orderType", getOrderType());
        return params;
    }

    /**
     * @return
     */
    @Override
    public Class<LiveVideoImageQueryResp> getResponseClass() {
        return LiveVideoImageQueryResp.class;
    }
}
