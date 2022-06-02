package com.netease.yidun.sdk.antispam.video.query.v1.request;

import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;
import com.netease.yidun.sdk.antispam.video.query.v1.response.VideoTaskIdQueryResp;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;

import lombok.Getter;
import lombok.Setter;

/**
 * 点播根据id查询请求
 */
@Getter
@Setter
public class VideoTaskIdQueryReq extends BizPostFormRequest<VideoTaskIdQueryResp> {
    private static final Gson GSON = new Gson();

    /**
     * json 类型，可包含多个 taskId
     */
    private Set<String> taskIds;

    public VideoTaskIdQueryReq() {
        productCode = "videoCommon";
        uriPattern = "/v1/video/query/task";
        version = "v1";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        StringHashMap params = new StringHashMap();
        params.putAll(super.getCustomSignParams());
        if (taskIds != null) {
            params.put("taskIds", GSON.toJson(getTaskIds()));
        }
        return params;
    }

    /**
     * 查询接口的返回值结构跟回调接口一致
     *
     * @return
     */
    @Override
    public Class<VideoTaskIdQueryResp> getResponseClass() {
        return VideoTaskIdQueryResp.class;
    }
}
