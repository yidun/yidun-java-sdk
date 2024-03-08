package com.netease.yidun.sdk.antispam.image.v5.check.sync.request;

import com.netease.yidun.sdk.antispam.image.v5.check.ImageV5CheckRequest;
import com.netease.yidun.sdk.antispam.image.v5.check.sync.response.ImageV5CheckResponse;
import com.netease.yidun.sdk.antispam.image.v5.enums.ImageTypeEnum;
import com.netease.yidun.sdk.core.utils.CollectionUtils;

import java.util.Optional;

public class ImageV5SyncCheckRequest extends ImageV5CheckRequest<ImageV5CheckResponse> {

    @Override
    protected String requestUriPath() {
        return "/v5/image/check";
    }

    @Override
    public String uriPattern() {
        // 如果有base64图片，调用base64Check接口
        if (!CollectionUtils.isEmpty(this.getImages())) {
            boolean hasBase64 = this.getImages().stream()
                                       .anyMatch(imageBeanRequest -> ImageTypeEnum.BASE64.getType() == Optional
                                               .ofNullable(imageBeanRequest.getType())
                                               .orElse(0));
            if (hasBase64) {
                return "/v5/image/base64Check";
            }
        }
        return "/v5/image/check";
    }

    @Override
    public Class<ImageV5CheckResponse> getResponseClass() {
        return ImageV5CheckResponse.class;
    }
}
