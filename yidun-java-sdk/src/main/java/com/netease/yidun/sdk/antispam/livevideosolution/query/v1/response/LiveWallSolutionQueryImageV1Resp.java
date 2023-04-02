package com.netease.yidun.sdk.antispam.livevideosolution.query.v1.response;

import com.netease.yidun.sdk.common.Page;
import com.netease.yidun.sdk.core.response.BaseResponse;
import com.netease.yidun.sdk.core.response.CommonResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class LiveWallSolutionQueryImageV1Resp extends CommonResponse {

    private LiveWallSolutionQueryImageV1Result result;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class LiveWallSolutionQueryImageV1Result implements BaseResponse {
        /**
         * 成功
         */
        public static final int OK = 0;
        /**
         * taskId不是7天内数据
         */
        public static final int TASK_ID_EXPIRED = 20;

        /**
         * taskId不存在
         */
        public static final int TASK_ID_NOT_EXISTS = 30;

        /**
         * 错误状态，0 代表成功
         */
        private Integer status;

        private Page<LiveWallSolutionQueryImageV1Unit> images = Page.empty();
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class LiveWallSolutionQueryImageV1Unit implements BaseResponse {
        private String url;
        private Integer label;
        private Integer labelLevel;
        private Integer callbackStatus;
        private Long beginTime;
        private Long endTime;
        private String speakerId;
    }

}
