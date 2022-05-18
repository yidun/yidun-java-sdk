package com.netease.yidun.sdk.antispam.livevideo.query.v1.response;

import com.netease.yidun.sdk.core.response.CommonResponse;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 点播根据id查询请求
 */
@Slf4j
@Data
public class LiveVideoTaskIdQueryResp extends CommonResponse {

    private List<LiveVideoTaskIdQueryResult> result;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class LiveVideoTaskIdQueryResult {
        /**
         * 唯一ID
         */
        private String taskId;

        /**
         * 回调标识
         */
        private String callback;

        /**
         * 直播状态
         */
        private int status;

        /**
         * 检测状态
         */
        private Integer callbackStatus;

        /**
         * 过期状态
         */
        private Integer expireStatus;
    }
}
