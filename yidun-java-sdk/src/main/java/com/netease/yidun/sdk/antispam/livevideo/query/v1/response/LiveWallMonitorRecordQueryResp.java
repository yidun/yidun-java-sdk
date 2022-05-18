package com.netease.yidun.sdk.antispam.livevideo.query.v1.response;

import java.util.List;

import com.netease.yidun.sdk.core.response.CommonResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 点播根据id查询请求
 */
@Slf4j
@Data
public class LiveWallMonitorRecordQueryResp extends CommonResponse {

    private LiveWallMonitorRecordQueryResult result;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class LiveWallMonitorRecordQueryResult {

        /**
         * taskId不是30天内数据
         */
        public static final int TASK_ID_EXPIRED = 20;

        /**
         * taskId不存在
         */
        public static final int TASK_ID_NOT_EXISTS = 30;
        /**
         * 查询成功
         */
        public static final int TASK_ID_QUERY_SUCCESS = 0;

        /**
         * 错误状态，0 代表成功
         */
        private Integer status;

        private List<LiveMonitorRecordUnit> records;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class LiveMonitorRecordUnit {

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
