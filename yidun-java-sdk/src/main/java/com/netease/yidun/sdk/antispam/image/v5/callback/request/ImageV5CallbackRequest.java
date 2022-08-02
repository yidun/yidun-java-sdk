package com.netease.yidun.sdk.antispam.image.v5.callback.request;

import com.netease.yidun.sdk.antispam.image.v5.check.sync.response.ImageV5CheckResponse;
import com.netease.yidun.sdk.antispam.image.v5.common.ImageV5Request;
import com.netease.yidun.sdk.core.utils.UUIDUtils;

import java.util.UUID;

public class ImageV5CallbackRequest extends ImageV5Request<ImageV5CheckResponse> {

    public ImageV5CallbackRequest(){
        super();
        productCode = "imageCommon";
    }

    /**
     * 请求的唯一ID
     */
    private String yidunRequestId;

    @Override
    protected String requestUriPath() {
        return "/v5/image/callback/results";
    }

    @Override
    public Class<ImageV5CheckResponse> getResponseClass() {
        return ImageV5CheckResponse.class;
    }

    public String getYidunRequestId() {
        if (yidunRequestId == null) {
            yidunRequestId = UUIDUtils.randomUUID();
        }
        return yidunRequestId;
    }

    public void setYidunRequestId(String yidunRequestId) {
        this.yidunRequestId = yidunRequestId;
    }
}
