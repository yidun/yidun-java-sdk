package com.netease.yidun.sdk.antispam.video.query.v1.request;

import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;
import com.netease.yidun.sdk.antispam.video.query.v1.response.VideoImageQueryResp;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;

import lombok.Getter;
import lombok.Setter;

/**
 * 视频截图查询请求
 */
@Getter
@Setter
public class VideoImageQueryReq extends BizPostFormRequest<VideoImageQueryResp> {
    private static final Gson GSON = new Gson();

    /**
     * taskId
     */
    private String taskId;

    /**
     * 0, 正常, 1, 嫌疑, 2, 确定;
     */
    private Set<Integer> levels;

    private Integer pageNum = 1;

    private Integer pageSize = 20;

    /**
     * 排序类型
     *
     * @see VideoDataOrderType
     */
    private Integer orderType = VideoDataOrderType.RECEIVE_TIME_ASC.getCode();

    public VideoImageQueryReq() {
        productCode = "videoCommon";
        uriPattern = "/v1/video/query/image";
        version = "v1";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        StringHashMap params = new StringHashMap();
        params.putAll(super.getCustomSignParams());
        params.put("taskId", getTaskId());
        if (levels != null) {
            params.put("levels", GSON.toJson(getLevels()));
        }
        params.put("pageNum", getPageNum());
        params.put("pageSize", getPageSize());
        params.put("orderType", getOrderType());
        return params;
    }

    /**
     * @return
     */
    @Override
    public Class<VideoImageQueryResp> getResponseClass() {
        return VideoImageQueryResp.class;
    }
}
