package com.netease.yidun.sdk.antispam.liveaudio.callback.v4.response;

import java.util.List;

import com.netease.yidun.sdk.antispam.audio.callback.v4.response.AudioAntispamCallbackV4Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 直播音频监控回调数据
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LiveAudioMonitorCallbackUnitRespV4 {
    /**
     * 操作
     */
    private Integer action;
    /**
     * 判断时间点
     */
    private Long actionTime;
    /**
     * 违规类型
     */
    private Integer spamType;
    /**
     * 违规详情
     */
    private String spamDetail;
    /**
     * 警告次数
     */
    private Integer warnCount;
    /**
     * 提示次数
     */
    private Integer promptCount;
    /**
     * 截图证据
     */
    private List<Evidence> segments;
    /**
     * speakerId
     */
    private String speakerId;
    /**
     * 审核标签
     */
    private List<AudioAntispamCallbackV4Response.CensorLabelInfo> censorLabels;
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Evidence {
        private Long startTime;
        private Long endTime;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CensorLabelInfo {
        private String code;
        private String desc;
        private String customCode;
        private String name;
    }
}
