package com.netease.yidun.sdk.antispam.livevideosolution.query.v1.response;

import java.util.List;

import com.netease.yidun.sdk.core.response.BaseResponse;
import com.netease.yidun.sdk.core.response.CommonResponse;

import lombok.Data;

@Data
public class LiveWallSolutionQueryV1Resp extends CommonResponse {

    private List<LiveWallSolutionQueryV1Result> result;

    @Data
    public static class LiveWallSolutionQueryV1Result implements BaseResponse {
        /**
         * taskId不是7天内数据
         */
        public static final int TASK_ID_EXPIRED = 20;

        /**
         * taskId不存在
         */
        public static final int TASK_ID_NOTEXISTS = 30;

        /**
         * 唯一ID
         */
        private String taskId;

        /**
         * 回调标识
         */
        private String callback;

        /**
         * 直播状态
         */
        private int status;

        /**
         * 检测状态
         */
        private Integer callbackStatus;

        /**
         * 过期状态
         */
        private Integer expireStatus;
    }
}
