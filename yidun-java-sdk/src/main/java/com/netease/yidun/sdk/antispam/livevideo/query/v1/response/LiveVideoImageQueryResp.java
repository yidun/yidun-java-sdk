package com.netease.yidun.sdk.antispam.livevideo.query.v1.response;

import com.netease.yidun.sdk.common.Page;
import com.netease.yidun.sdk.core.response.CommonResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 点播taskId查询结果直播/电视墙截图实体
 */
@Data
public class LiveVideoImageQueryResp extends CommonResponse {

    private LiveVideoImageQueryResult result;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class LiveVideoImageQueryResult {

        /**
         * 错误状态，0 代表成功
         */
        private Integer status;

        private Page<LiveVideoImageQueryUnit> images;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class LiveVideoImageQueryUnit {
        private String url;
        private Integer label;
        private Integer labelLevel;
        private Integer callbackStatus;
        private Long beginTime;
        private Long endTime;
        private String speakerId;
    }
}
