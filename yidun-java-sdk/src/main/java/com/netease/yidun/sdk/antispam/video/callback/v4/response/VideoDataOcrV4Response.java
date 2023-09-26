package com.netease.yidun.sdk.antispam.video.callback.v4.response;

import java.util.List;

import lombok.Data;

@Data
public class VideoDataOcrV4Response {
    private String url;
    private Long startTime;
    private Long endTime;
    private Integer height;
    private Integer width;
    private List<VideoDataOcrDetailBo> details;
    private String pictureId;
}
