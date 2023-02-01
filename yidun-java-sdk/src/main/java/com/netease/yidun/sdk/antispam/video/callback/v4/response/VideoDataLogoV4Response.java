
package com.netease.yidun.sdk.antispam.video.callback.v4.response;

import java.util.List;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class VideoDataLogoV4Response {
    private Long startTime;
    private Long endTime;
    private List<VideoLogoItemBo> details;
}
