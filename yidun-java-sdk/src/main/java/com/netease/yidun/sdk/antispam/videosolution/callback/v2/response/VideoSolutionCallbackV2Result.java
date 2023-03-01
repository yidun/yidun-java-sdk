package com.netease.yidun.sdk.antispam.videosolution.callback.v2.response;

import com.netease.yidun.sdk.antispam.audio.callback.v4.response.AudioAsrCallbackV4Response;
import com.netease.yidun.sdk.antispam.audio.callback.v4.response.AudioLanguageCallbackV4Response;
import com.netease.yidun.sdk.antispam.audio.callback.v4.response.AudioQualityCallbackV4Response;
import com.netease.yidun.sdk.antispam.audio.callback.v4.response.AudioVoiceCallbackV4Response;
import com.netease.yidun.sdk.antispam.video.callback.v4.response.VideoCallbackDiscernV4Response;
import com.netease.yidun.sdk.antispam.video.callback.v4.response.VideoCallbackLogoV4Response;
import com.netease.yidun.sdk.antispam.video.callback.v4.response.VideoCallbackOcrV4Response;

import com.netease.yidun.sdk.antispam.video.callback.v4.response.VideoCallbackQualityV4Response;

import lombok.Data;

@Data
public class VideoSolutionCallbackV2Result {
    /**
     * 反垃圾检测结果
     */
    private VideoSolutionAntispamCallbackV2Response antispam;
    /**
     * 语种检测结果
     */
    private AudioLanguageCallbackV4Response language;
    /**
     * 性别检测结果
     */
    private AudioVoiceCallbackV4Response voice;
    /**
     * 语音识别结果
     */
    private AudioAsrCallbackV4Response asr;
    /**
     * 视频 ocr 识别结果
     */
    private VideoCallbackOcrV4Response ocr;
    /**
     * 视频 ocr 识别结果
     */
    private VideoCallbackDiscernV4Response discern;
    /**
     * 视频 logo 识别结果
     */
    private VideoCallbackLogoV4Response logo;
    /**
     * 视频质量
     */
    private CallbackQualityV4Response quality;

    @Data
    public static class CallbackQualityV4Response {
        private VideoCallbackQualityV4Response video;
        private AudioQualityCallbackV4Response audio;
    }
}
