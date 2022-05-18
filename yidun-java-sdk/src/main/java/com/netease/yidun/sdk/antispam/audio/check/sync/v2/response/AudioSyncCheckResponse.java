package com.netease.yidun.sdk.antispam.audio.check.sync.v2.response;

import com.netease.yidun.sdk.antispam.audio.callback.v4.response.AudioAntispamCallbackV4Response;
import com.netease.yidun.sdk.antispam.audio.callback.v4.response.AudioAsrCallbackV4Response;
import com.netease.yidun.sdk.antispam.audio.callback.v4.response.AudioLanguageCallbackV4Response;
import com.netease.yidun.sdk.antispam.audio.callback.v4.response.AudioVoiceCallbackV4Response;
import com.netease.yidun.sdk.core.response.BaseResponse;
import com.netease.yidun.sdk.core.response.CommonResponse;

import lombok.Data;

@Data
public class AudioSyncCheckResponse extends CommonResponse {
    private AudioCheckV2Result result;

    @Data
    public static class AudioCheckV2Result implements BaseResponse {
        /**
         * 反垃圾结果
         */
        private AudioAntispamCallbackV4Response antispam;
        /**
         * 语种检测结果
         */
        private AudioLanguageCallbackV4Response language;
        /**
         * 性别检测结果
         */
        private AudioVoiceCallbackV4Response voice;
        /**
         * 语音识别检测结果
         */
        private AudioAsrCallbackV4Response asr;
    }
}
