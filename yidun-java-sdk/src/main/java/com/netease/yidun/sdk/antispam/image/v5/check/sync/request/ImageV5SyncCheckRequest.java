package com.netease.yidun.sdk.antispam.image.v5.check.sync.request;

import com.netease.yidun.sdk.antispam.image.v5.check.ImageV5CheckRequest;
import com.netease.yidun.sdk.antispam.image.v5.check.sync.response.ImageV5CheckResponse;

public class ImageV5SyncCheckRequest extends ImageV5CheckRequest<ImageV5CheckResponse> {

    @Override
    protected String requestUriPath() {
        return "/v5/image/check";
    }

    @Override
    public Class<ImageV5CheckResponse> getResponseClass() {
        return ImageV5CheckResponse.class;
    }
}
