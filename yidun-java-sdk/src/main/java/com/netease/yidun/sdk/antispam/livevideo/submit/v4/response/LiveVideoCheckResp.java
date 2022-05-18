package com.netease.yidun.sdk.antispam.livevideo.submit.v4.response;

import com.netease.yidun.sdk.core.response.CommonResponse;

import lombok.Data;

/**
 * 直播检测响应
 */
@Data
public class LiveVideoCheckResp extends CommonResponse {

    private LiveVideoCheckResult result;

    @Data
    public static class LiveVideoCheckResult {
        public static final int SUBMIT_SUCCESS = 0;
        public static final int SUBMIT_FAIL = 1;
        private String taskId;
        /**
         * 0-成功，1-失败
         */
        private int status;
    }
}
