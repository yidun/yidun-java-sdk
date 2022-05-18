package com.netease.yidun.sdk.antispam.livevideo.callback.v4.response;

import com.netease.yidun.sdk.core.response.CommonResponse;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 视频直播回调响应
 */
@Data
public class LiveWallCallbackV3Resp extends CommonResponse {

    private List<LiveWallCallbackResult> result;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class LiveWallCallbackResult {
        /**
         * 数据唯一uuid
         */
        private String taskId;

        /**
         * 数据id
         */
        private String dataId;

        /**
         * 回调参数
         */
        private String callback;

        /**
         * 状态
         */
        private Integer status;

        /**
         * 审核来源
         */
        private Integer censorSource;

        /**
         * 人审结果
         */
        private ReviewEvidences reviewEvidences;

        /**
         * 机审结果
         */
        private MachineEvidences evidences;
    }
}
