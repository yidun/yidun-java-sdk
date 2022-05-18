package com.netease.yidun.sdk.antispam.video.query.v1.response;

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
public class VideoImageQueryResp extends CommonResponse {

    private VideoImageQueryResult result;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class VideoImageQueryResult {

        /**
         * 错误状态，0 代表成功
         */
        private Integer status = 0;

        private Page<VideoImageQueryUnit> images;

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class VideoImageQueryUnit {
        private String url;
        private Integer label;
        private Integer labelLevel;
        private Long beginTime;
        private Long endTime;
    }
}
