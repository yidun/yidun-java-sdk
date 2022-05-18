package com.netease.yidun.sdk.antispam.livevideosolution.query.v1.request;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.netease.yidun.sdk.antispam.livevideosolution.query.v1.response.LiveWallSolutionQueryImageV1Resp;
import com.netease.yidun.sdk.core.request.PostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;

import lombok.Data;

@Data
public class LiveWallSolutionQueryImageV1Req extends PostFormRequest<LiveWallSolutionQueryImageV1Resp> {
    private static final Gson GSON = new Gson();
    /**
     * taskId
     */
    private String taskId;

    /**
     * 等级数组，@See LabelLevel; json数组格式[1,2,3]
     */
    private List<String> levels;

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
     * 排序类型 @See LiveVideoOrderType;
     */
    private Integer orderType;

    public LiveWallSolutionQueryImageV1Req() {
        productCode = "liveVideoSolutionCommon";
        uriPattern = "/v1/livewallsolution/query/image";
        version = "v1";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        StringHashMap params = new StringHashMap();
        params.putAll(super.getCustomSignParams());
        params.put("taskId", getTaskId());
        params.put("levels", GSON.toJson(getLevels()));
        params.put("callbackStatus", getCallbackStatus());
        params.put("startTime", getStartTime());
        params.put("endTime", getEndTime());
        params.put("pageNum", getPageNum());
        params.put("pageSize", getPageSize());
        params.put("orderType", getOrderType());
        return params;
    }

    @Override
    public Class<LiveWallSolutionQueryImageV1Resp> getResponseClass() {
        return LiveWallSolutionQueryImageV1Resp.class;
    }
}
