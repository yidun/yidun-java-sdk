package com.netease.yidun.sdk.antispam.livevideo.feedback.v1.response;

import com.netease.yidun.sdk.core.response.CommonResponse;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 直播实时数据提交返回实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LiveVideoFeedbackResp extends CommonResponse {

    private List<LiveVideoFeedbackResult> result;

    @Data
    public static class LiveVideoFeedbackResult {
        /**
         * 唯一ID
         */
        private String taskId;

        /**
         * 提交状态，成功-0，服务器异常-1，数据不存在-2
         */
        private Integer result;
    }
}
