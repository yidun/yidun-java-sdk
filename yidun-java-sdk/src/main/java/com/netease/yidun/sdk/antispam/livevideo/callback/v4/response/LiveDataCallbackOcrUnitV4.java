
package com.netease.yidun.sdk.antispam.livevideo.callback.v4.response;

import java.util.List;

import com.netease.yidun.sdk.antispam.video.callback.v4.response.VideoDataOcrDetailBo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LiveDataCallbackOcrUnitV4 {
    private String taskId;
    private String dataId;
    private String speakerId;
    private Long beginTime;
    private Long endTime;
    private Integer height;
    private Integer width;
    private String url;
    private List<VideoDataOcrDetailBo> details;
}
