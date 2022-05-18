package com.netease.yidun.sdk.antispam.audio.callback.v4.response;

import java.util.List;

import com.netease.yidun.sdk.core.response.BaseResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AudioAsrCallbackV4Response {
    /**
     * 检测任务 id
     */
    private String taskId;
    /**
     * 提交时传递的 dataId 参数
     */
    private String dataId;
    /**
     * 提交时传递的 callback 参数
     */
    private String callback;
    /**
     * 断句详情
     */
    private List<AsrContentBo> details;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AsrContentBo implements BaseResponse {
        private Integer startTime;
        private Integer endTime;
        /**
         * 语音识别结果
         */
        private String content;
    }
}
