package com.netease.yidun.sdk.antispam.image.v5.check.sync.response;

import com.netease.yidun.sdk.core.response.CommonResponse;

import java.util.List;

public class ImageV5CheckResponse extends CommonResponse {

    private static final long serialVersionUID = 1802225147048678782L;

    private List<ImageV5Result> result;

    public List<ImageV5Result> getResult() {
        return result;
    }

    public void setResult(List<ImageV5Result> result) {
        this.result = result;
    }
}
