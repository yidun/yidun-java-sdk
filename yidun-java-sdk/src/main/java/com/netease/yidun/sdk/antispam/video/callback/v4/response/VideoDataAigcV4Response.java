package com.netease.yidun.sdk.antispam.video.callback.v4.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
public class VideoDataAigcV4Response implements Serializable {
    private Long startTime;
    private Long endTime;
    private List<VideoAigcItemBo> details;
    private String pictureId;
}
