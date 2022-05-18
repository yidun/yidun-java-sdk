package com.netease.yidun.sdk.antispam.audio.check.async.v4.response;

import com.netease.yidun.sdk.core.response.BaseResponse;
import com.netease.yidun.sdk.core.response.CommonResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AudioAsyncCheckResponse extends CommonResponse {
    private AudioSubmitV4Result result;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class AudioSubmitV4Result implements BaseResponse {
        /**
         * 提交任务 id
         */
        private String taskId;
        /**
         * 提交状态，0-成功，1失败
         */
        private Integer status;
        /**
         * 缓冲池当前缓冲数量
         */
        private Integer dealingCount;
    }
}
