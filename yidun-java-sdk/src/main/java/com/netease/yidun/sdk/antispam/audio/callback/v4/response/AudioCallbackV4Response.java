package com.netease.yidun.sdk.antispam.audio.callback.v4.response;

import java.util.List;

import com.netease.yidun.sdk.core.response.CommonResponse;

public class AudioCallbackV4Response extends CommonResponse {

    private List<AudioCallbackV4Result> result;

    public List<AudioCallbackV4Result> getResult() {
        return result;
    }

    public void setResult(List<AudioCallbackV4Result> result) {
        this.result = result;
    }
}