package com.netease.yidun.sdk.antispam.livevideosolution.submit.v3.response;

import com.netease.yidun.sdk.core.response.BaseResponse;
import com.netease.yidun.sdk.core.response.CommonResponse;

import lombok.Data;

@Data
public class LiveWallSolutionSubmitV3Resp extends CommonResponse {
    private LiveVideoSolutionSubmitV2Result result;

    @Data
    public static class LiveVideoSolutionSubmitV2Result implements BaseResponse {
        private String taskId;
        private boolean status;
    }
}
