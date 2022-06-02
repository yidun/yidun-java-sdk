
package com.netease.yidun.sdk.antispam.video.submit.v4.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 高级截帧设置
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdvancedFrequencyRequest {

    /**
     * 时长分隔点（单位是秒）
     */
    private List<Long> durationPoints;

    /**
     * 分隔点截图频率
     */
    private List<Float> frequencies;
}
