package com.netease.yidun.sdk.antispam.video.callback.v4.response;

import java.util.List;

import com.netease.yidun.sdk.core.response.CommonResponse;

import lombok.Data;

/**
 * 点播检测响应
 */
@Data
public class VideoCallbackV4Resp extends CommonResponse {

    private List<VideoCallbackV4Result> result;


}
