
package com.netease.yidun.sdk.antispam.livevideo.callback.v4.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LiveDataCallbackLogoUnitV4 {
    private String taskId;
    private String dataId;
    private String speakerId;
    private Long beginTime;
    private Long endTime;
    private List<LiveVideoLogoItemBo> details;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LiveVideoLogoItemBo {
        /**
         * logo信息
         */
        private String logoName;
        private Float x1;
        private Float y1;
        private Float x2;
        private Float y2;
        /**
         * 子标签分数
         */
        private Float rate;
        /**
         * logo大小占比
         */
        private String sizeRatio;

    }

}
