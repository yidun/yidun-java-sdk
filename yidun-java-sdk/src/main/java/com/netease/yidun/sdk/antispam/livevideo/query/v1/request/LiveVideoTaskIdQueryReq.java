package com.netease.yidun.sdk.antispam.livevideo.query.v1.request;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.netease.yidun.sdk.antispam.livevideo.query.v1.response.LiveVideoTaskIdQueryResp;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;

import lombok.Getter;
import lombok.Setter;

/**
 * 点播根据id查询请求
 */
@Getter
@Setter
public class LiveVideoTaskIdQueryReq extends BizPostFormRequest<LiveVideoTaskIdQueryResp> {

    /**
     * taskId列表 格式为数组的json格式"[1,2,3]"
     */
    private List<String> taskIds;

    public LiveVideoTaskIdQueryReq() {
        productCode = "liveVideo";
        uriPattern = "/v1/livevideo/query/task";
        version = "v1";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        StringHashMap params = new StringHashMap();
        params.putAll(super.getCustomSignParams());
        params.put("taskIds", new Gson().toJson(getTaskIds()));
        return params;
    }

    @Override
    public Class<LiveVideoTaskIdQueryResp> getResponseClass() {
        return LiveVideoTaskIdQueryResp.class;
    }
}
