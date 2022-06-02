package com.netease.yidun.sdk.antispam.videosolution.query.v1.request;

import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;
import com.netease.yidun.sdk.antispam.video.query.v1.request.VideoDataOrderType;
import com.netease.yidun.sdk.antispam.videosolution.query.v1.response.VideoSolutionQueryImageV1Resp;
import com.netease.yidun.sdk.core.request.PostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;

import lombok.Data;

@Data
public class VideoSolutionQueryImageV1Req extends PostFormRequest<VideoSolutionQueryImageV1Resp> {
    private static final Gson GSON = new Gson();

    /**
     * taskId
     */
    private String taskId;

    /**
     * 等级数组; json数组格式[1,2,3]
     *
     * @see com.netease.yidun.sdk.image.callback.response.LabelLevel
     */
    private Set<Integer> levels;

    private Integer pageNum = 1;

    private Integer pageSize = 20;

    /**
     * 排序类型
     *
     * @see VideoDataOrderType;
     */
    private Integer orderType = VideoDataOrderType.RECEIVE_TIME_ASC.getCode();

    public VideoSolutionQueryImageV1Req() {
        productCode = "videoSolutionCommon";
        uriPattern = "/v1/videosolution/query/image";
        version = "v1.1";
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

    @Override
    public Class<VideoSolutionQueryImageV1Resp> getResponseClass() {
        return VideoSolutionQueryImageV1Resp.class;
    }
}
