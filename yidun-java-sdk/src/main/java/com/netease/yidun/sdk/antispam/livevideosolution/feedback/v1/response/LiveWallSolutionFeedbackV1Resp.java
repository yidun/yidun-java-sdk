package com.netease.yidun.sdk.antispam.livevideosolution.feedback.v1.response;

import java.util.List;

import com.netease.yidun.sdk.core.response.BaseResponse;
import com.netease.yidun.sdk.core.response.CommonResponse;

import lombok.Data;

@Data
public class LiveWallSolutionFeedbackV1Resp extends CommonResponse {
    private List<LiveVideoSolutionFeedbackV1Result> result;

    @Data
    public static class LiveVideoSolutionFeedbackV1Result implements BaseResponse {
        /**
         * 提交成功
         */
        public static final int SUCCESS = 0;

        /**
         * 服务器异常
         */
        public static final int SERVER_ERROR = 1;

        /**
         * 数据不存在
         */
        public static final int NOT_EXISTS = 2;

        /**
         * 唯一ID
         */
        private String taskId;

        /**
         * 提交状态
         */
        private Integer result;
    }
}
