/*
 * @(#) VideoSolutionSubmitV1Resp.java 2021-01-18
 *
 * Copyright 2021 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.videosolution.submit.v2.response;

import com.netease.yidun.sdk.core.response.BaseResponse;
import com.netease.yidun.sdk.core.response.CommonResponse;

import lombok.Data;

@Data
public class VideoSolutionSubmitV2Resp extends CommonResponse {
    private VideoSolutionSubmitV1Result result;

    @Data
    public static class VideoSolutionSubmitV1Result implements BaseResponse {
        private String taskId;
        private String dataId;
        /**
         * 缓冲池排队待处理数据量
         */
        private Long dealingCount;
    }
}
