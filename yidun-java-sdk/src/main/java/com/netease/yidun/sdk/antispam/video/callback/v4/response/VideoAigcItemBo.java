package com.netease.yidun.sdk.antispam.video.callback.v4.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VideoAigcItemBo implements Serializable {
    /**
     * 是否ai生成
     */
    private Boolean isAigc;
    /**
     * 2:确定 1:嫌疑 0:正常
     */
    private Integer aigcLevel;
    /**
     * aigc分数
     */
    private Float aigcRate;
    /**
     * 人工智能生成标识信息
     */
    private AigcV5SignageResp signage;
}
