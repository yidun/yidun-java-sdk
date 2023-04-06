package com.netease.yidun.sdk.antispam.video.callback.v4.response;

import lombok.Data;

@Data
public class VideoCallbackV4Result {
    private VideoCallbackUnitV4Response antispam;
    private VideoCallbackOcrV4Response ocr;
    private VideoCallbackDiscernV4Response discern;
    private VideoCallbackLogoV4Response logo;
    /**
     * 视频质量
     */
    private VideoCallbackQualityV4Response quality;
    /**
     * 视频人脸检测结果
     */
    private VideoCallbackFaceV4Response face;
}
