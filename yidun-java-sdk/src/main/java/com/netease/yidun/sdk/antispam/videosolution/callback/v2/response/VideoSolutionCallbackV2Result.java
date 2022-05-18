package com.netease.yidun.sdk.antispam.videosolution.callback.v2.response;

import com.netease.yidun.sdk.antispam.audio.callback.v4.response.AudioAsrCallbackV4Response;
import com.netease.yidun.sdk.antispam.audio.callback.v4.response.AudioLanguageCallbackV4Response;
import com.netease.yidun.sdk.antispam.audio.callback.v4.response.AudioVoiceCallbackV4Response;

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
}
