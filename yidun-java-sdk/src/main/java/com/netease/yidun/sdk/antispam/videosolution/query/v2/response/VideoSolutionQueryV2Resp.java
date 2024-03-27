package com.netease.yidun.sdk.antispam.videosolution.query.v2.response;

import java.util.List;

import com.netease.yidun.sdk.antispam.audio.callback.v4.response.AudioAsrCallbackV4Response;
import com.netease.yidun.sdk.antispam.audio.callback.v4.response.AudioLanguageCallbackV4Response;
import com.netease.yidun.sdk.antispam.audio.callback.v4.response.AudioVoiceCallbackV4Response;
import com.netease.yidun.sdk.antispam.video.callback.v4.response.VideoCallbackOcrV4Response;
import com.netease.yidun.sdk.antispam.videosolution.callback.v2.response.VideoSolutionAntispamCallbackV2Response;
import com.netease.yidun.sdk.core.response.CommonResponse;

import lombok.Data;

@Data
public class VideoSolutionQueryV2Resp extends CommonResponse {
    private List<VideoSolutionQueryV2Result> result;

    @Data
    public static class VideoSolutionQueryV2Result {
        private String taskId;
        private String dataId;
        /**
         * 数据状态
         */
        private int status;
        /**
         * 音频地址
         */
        private String audioUrl;
        /**
         * 视频地址
         */
        private String videoUrl;
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
    }

}
