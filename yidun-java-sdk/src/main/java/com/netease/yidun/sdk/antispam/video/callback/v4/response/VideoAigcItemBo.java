package com.netease.yidun.sdk.antispam.video.callback.v4.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VideoAigcItemBo implements Serializable {
    /**
     * 是否ai生成
     */
    private Boolean isAigc;
}
