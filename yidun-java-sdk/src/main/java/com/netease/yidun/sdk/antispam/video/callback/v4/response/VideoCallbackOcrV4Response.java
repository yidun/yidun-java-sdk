
package com.netease.yidun.sdk.antispam.video.callback.v4.response;

import java.util.List;

import lombok.Data;

@Data
public class VideoCallbackOcrV4Response {
    private String taskId;
    private String dataId;
    private List<VideoDataOcrV4Response> pictures;
}
