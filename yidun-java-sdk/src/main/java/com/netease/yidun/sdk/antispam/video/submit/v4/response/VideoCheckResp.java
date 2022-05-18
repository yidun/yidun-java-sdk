package com.netease.yidun.sdk.antispam.video.submit.v4.response;

import com.netease.yidun.sdk.core.response.CommonResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 点播检测响应
 */
@Data
public class VideoCheckResp extends CommonResponse {

    private VideoCheckResult result;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class VideoCheckResult {
        private String taskId;
        /**
         * 提交状态 0-成功，1-失败
         */
        private int status;
        /**
         * 缓冲池当前缓冲数量
         */
        private long dealingCount;
    }
}
