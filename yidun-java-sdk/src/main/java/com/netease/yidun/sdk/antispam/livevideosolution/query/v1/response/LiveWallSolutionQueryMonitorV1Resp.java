package com.netease.yidun.sdk.antispam.livevideosolution.query.v1.response;

import java.util.List;

import com.netease.yidun.sdk.core.response.BaseResponse;
import com.netease.yidun.sdk.core.response.CommonResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class LiveWallSolutionQueryMonitorV1Resp extends CommonResponse {

    private LiveWallSolutionQueryMonitorV1Result result;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class LiveWallSolutionQueryMonitorV1Result implements BaseResponse {

        /**
         * taskId不是30天内数据
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

        private List<LiveMonitorRecordUnitResult> records;
    }

    @Data
    public static class LiveMonitorRecordUnitResult implements BaseResponse {

        /**
         * 操作
         */
        private int action;

        /**
         * 操作时间点
         */
        private long actionTime;

        /**
         * 违规类型
         */
        private int label;

        /**
         * 违规详情
         */
        private String detail;
    }
}
