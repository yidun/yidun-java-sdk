package com.netease.yidun.sdk.antispam.videosolution.query.v1.response;

import com.netease.yidun.sdk.common.Page;
import com.netease.yidun.sdk.core.response.BaseResponse;
import com.netease.yidun.sdk.core.response.CommonResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class VideoSolutionQueryImageV1Resp extends CommonResponse {
    private VideoSolutionQueryImageResult result;

    @Data
    public static class VideoSolutionQueryImageResult implements BaseResponse {
        /**
         * taskId不存在
         */
        public static final int TASK_ID_NOT_EXISTS = 30;

        /**
         * 错误状态，0 代表成功
         */
        private Integer status;

        private Page<VideoImageQueryUnit> images;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class VideoImageQueryUnit implements BaseResponse {
        private String url;
        private Integer label;
        private Integer labelLevel;
        private Long beginTime;
        private Long endTime;
    }
}
