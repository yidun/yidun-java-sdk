package com.netease.yidun.sdk.antispam.livevideo.feedback.v1.request;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.netease.yidun.sdk.antispam.livevideo.feedback.v1.response.LiveVideoFeedbackResp;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;

import lombok.Getter;
import lombok.Setter;

/**
 * 直播实时数据提交请求
 */
@Getter
@Setter
public class LiveVideoFeedbackReq extends BizPostFormRequest<LiveVideoFeedbackResp> {

    /**
     * 直播实时信息列表JSON
     */
    private List<LiveRealTimeInfo> realTimeInfoList;

    public LiveVideoFeedbackReq() {
        productCode = "liveVideo";
        uriPattern = "/v1/livevideo/feedback";
        version = "v1";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        StringHashMap params = new StringHashMap();
        params.putAll(super.getCustomSignParams());
        params.put("realTimeInfoList", new Gson().toJson(getRealTimeInfoList()));
        return params;
    }

    @Override
    public Class<LiveVideoFeedbackResp> getResponseClass() {
        return LiveVideoFeedbackResp.class;
    }
}
