package com.netease.yidun.sdk.antispam.livevideo.callback.v4.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CallbackImageLabel {
    private int label;
    private int level;
    private float rate;
    private List<ImageSubLabelResp> subLabels;
}
