package com.netease.yidun.sdk.antispam.liveaudio.query.v1.response;

import com.netease.yidun.sdk.core.response.BaseResponse;
import com.netease.yidun.sdk.core.response.CommonResponse;
import java.util.List;
import lombok.Data;

@Data
public class LiveAudioQueryTaskIdV1Resp extends CommonResponse {
    private List<LiveAudioQueryV1Result> result;

    @Data
    public static class LiveAudioQueryV1Result implements BaseResponse {
        /**
         * uuid
         */
        private String taskId;
        /**
         * 本次回调片段中最高优先级的level
         */
        private Integer action;
        /**
         * 语音翻译状态
         */
        private int asrStatus;
        /**
         * 语音翻译失败错误码
         */
        private Integer asrResult;
        /**
         * 回调数据
         */
        private String callback;

        private Long startTime;

        private Long endTime;
        /**
         * 片段信息
         */
        private List<SegmentsInfo> segments;
        private Integer censorSource;

        /**
         * 断句关联用户id
         */
        private String speakerId;
        private String segmentId;
    }

    @Data
    public static class SegmentsInfo implements BaseResponse {
        private int label;
        private int level;
        private String evidence;
    }
}
