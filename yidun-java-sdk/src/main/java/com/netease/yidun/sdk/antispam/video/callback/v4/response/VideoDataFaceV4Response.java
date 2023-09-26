package com.netease.yidun.sdk.antispam.video.callback.v4.response;

import java.util.List;

import lombok.Data;

@Data
public class VideoDataFaceV4Response {
    private String url;
    private Long startTime;
    private Long endTime;
    /**
     * face检测结果
     */
    private List<VideoDataFaceDetailBo> details;
    private String pictureId;
}
