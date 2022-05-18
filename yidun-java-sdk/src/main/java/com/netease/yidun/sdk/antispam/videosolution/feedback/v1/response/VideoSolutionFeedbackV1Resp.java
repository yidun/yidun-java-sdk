package com.netease.yidun.sdk.antispam.videosolution.feedback.v1.response;

import java.util.List;

import com.netease.yidun.sdk.core.response.BaseResponse;
import com.netease.yidun.sdk.core.response.CommonResponse;

import lombok.Data;

@Data
public class VideoSolutionFeedbackV1Resp extends CommonResponse {
    private List<VideoSolutionFeedbackV1Result> result;

    @Data
    public static class VideoSolutionFeedbackV1Result implements BaseResponse {

        /**
         * 唯一ID
         */
        private String taskId;

        /**
         * 提交状态 0成功，1失败，2数据不存在
         */
        private Integer result;
    }
}
