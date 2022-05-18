package com.netease.yidun.sdk.antispam.liveaudio.query.v1.response;

import com.netease.yidun.sdk.core.response.BaseResponse;
import com.netease.yidun.sdk.core.response.CommonResponse;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class LiveAudioQueryMonitorV1Resp extends CommonResponse {
    private LiveAudioQueryMonitorV1Result result;

    @Data
    public static class LiveAudioQueryMonitorV1Result implements BaseResponse {
        /**
         * 数据状态
         */
        private int status;
        /**
         * 人审操作记录
         */
        private List<LiveAudioQueryMonitorUnitDetailResp> monitors;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LiveAudioQueryMonitorUnitDetailResp implements BaseResponse {
        /**
         * 操作
         */
        private Integer action;
        /**
         * 判断时间点
         */
        private Long actionTime;
        /**
         * 违规类型
         */
        private Integer spamType;
        /**
         * 违规详情
         */
        private String spamDetail;
    }
}
