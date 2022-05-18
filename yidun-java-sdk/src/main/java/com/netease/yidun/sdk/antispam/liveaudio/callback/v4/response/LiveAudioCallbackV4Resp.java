package com.netease.yidun.sdk.antispam.liveaudio.callback.v4.response;

import java.util.List;

import com.netease.yidun.sdk.core.response.CommonResponse;

import lombok.Data;

@Data
public class LiveAudioCallbackV4Resp extends CommonResponse {

    private List<LiveAudioCallbackV4Result> result;

}
