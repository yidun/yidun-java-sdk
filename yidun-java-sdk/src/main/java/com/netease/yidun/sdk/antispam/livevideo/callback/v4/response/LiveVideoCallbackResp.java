package com.netease.yidun.sdk.antispam.livevideo.callback.v4.response;

import java.util.List;

import com.netease.yidun.sdk.core.response.CommonResponse;

import lombok.Data;

/**
 * 视频直播回调响应
 */
@Data
public class LiveVideoCallbackResp extends CommonResponse {

    private List<LiveCallbackUnitV4> result;


}
