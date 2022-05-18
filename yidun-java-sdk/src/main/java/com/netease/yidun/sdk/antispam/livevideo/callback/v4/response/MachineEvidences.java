package com.netease.yidun.sdk.antispam.livevideo.callback.v4.response;

import java.util.List;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 电视墙机审回调证据信息
 */
@Data
@Slf4j
public class MachineEvidences {
    private VideoEvidence evidence;
    private List<CallbackImageLabel> labels;
}
