package com.netease.yidun.sdk.antispam.videosolution.callback.v2.request;

import com.netease.yidun.sdk.antispam.videosolution.callback.v2.response.VideoSolutionCallbackV2Resp;
import com.netease.yidun.sdk.core.request.PostFormRequest;
import lombok.Data;

import java.util.Map;

@Data
public class VideoSolutionCallbackV2Req extends PostFormRequest<VideoSolutionCallbackV2Resp> {

    /**
     * 请求的唯一ID
     */
    private String yidunRequestId;
    /**
     * 任务ID
     */
    private String taskId;

    public VideoSolutionCallbackV2Req() {
        productCode = "videoSolutionCommon";
        uriPattern = "/v2/videosolution/callback/results";
        version = "v2.1";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        if (yidunRequestId != null) {
            params.put("yidunRequestId", getYidunRequestId());
        }
        if (taskId != null) {
            params.put("taskId", getTaskId());
        }
        return params;
    }

    public String getYidunRequestId() {
        return yidunRequestId;
    }

    public void setYidunRequestId(String yidunRequestId) {
        this.yidunRequestId = yidunRequestId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    @Override
    public Class<VideoSolutionCallbackV2Resp> getResponseClass() {
        return VideoSolutionCallbackV2Resp.class;
    }
}
