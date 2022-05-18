package com.netease.yidun.sdk.antispam.audio.callback.v4.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AudioVoiceCallbackV4Response {
    /**
     * 检测任务 id
     */
    private String taskId;
    /**
     * 提交时传递的 dataId
     */
    private String dataId;
    /**
     * 提交时传递的 callback
     */
    private String callback;
    /**
     * 语音检测结果
     */
    private AudioVoiceCallbackDetailBo detail;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AudioVoiceCallbackDetailBo {
        /**
         * 音频性别建议值，male/female
         */
        private String mainGender;
    }
}
