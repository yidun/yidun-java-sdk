package com.netease.yidun.sdk.antispam.liveaudio.query.v1.response;

import com.netease.yidun.sdk.core.response.BaseResponse;
import com.netease.yidun.sdk.core.response.CommonResponse;
import java.util.List;
import lombok.Data;

@Data
public class LiveAudioQuerySegmentV1Resp extends CommonResponse {
    private List<LiveAudioQuerySegmentV1Result> result;

    @Data
    public static class LiveAudioQuerySegmentV1Result implements BaseResponse {
        /**
         * '开始时间'
         */
        private Long beginTime;
        /**
         * '结束时间'
         */
        private Long endTime;
        /**
         * url
         */
        private String url;
        /**
         * speakerId
         */
        private String speakerId;
    }
}
