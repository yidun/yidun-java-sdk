package com.netease.yidun.sdk.antispam.image.v5.callback.request;

import com.netease.yidun.sdk.antispam.image.v5.check.sync.response.ImageV5CheckResponse;
import com.netease.yidun.sdk.antispam.image.v5.common.ImageV5Request;

public class ImageV5CallbackRequest extends ImageV5Request<ImageV5CheckResponse> {

    public ImageV5CallbackRequest(){
        super();
        productCode = "imageCommon";
    }

    @Override
    protected String requestUriPath() {
        return "/v5/image/callback/results";
    }

    @Override
    public Class<ImageV5CheckResponse> getResponseClass() {
        return ImageV5CheckResponse.class;
    }
}
