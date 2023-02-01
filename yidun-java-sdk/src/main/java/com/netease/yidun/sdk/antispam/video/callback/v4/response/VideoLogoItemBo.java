
package com.netease.yidun.sdk.antispam.video.callback.v4.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VideoLogoItemBo implements Serializable {
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
