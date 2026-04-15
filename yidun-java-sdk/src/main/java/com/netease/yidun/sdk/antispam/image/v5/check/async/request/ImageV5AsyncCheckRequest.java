package com.netease.yidun.sdk.antispam.image.v5.check.async.request;

import com.netease.yidun.sdk.antispam.image.v5.check.ImageV5CheckRequest;
import com.netease.yidun.sdk.antispam.image.v5.check.async.response.ImageV5AsyncCheckResp;
import com.netease.yidun.sdk.antispam.image.v5.enums.ImageTypeEnum;
import com.netease.yidun.sdk.core.utils.CollectionUtils;

import java.util.Optional;

public class ImageV5AsyncCheckRequest extends ImageV5CheckRequest<ImageV5AsyncCheckResp> {

    private String yidunRequestId;

    @Override
    protected String requestUriPath() {
        return "/v5/image/asyncCheck";
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
                return "/v5/image/asyncBase64Check";
            }
        }
        return "/v5/image/asyncCheck";
    }

    @Override
    public Class<ImageV5AsyncCheckResp> getResponseClass() {
        return ImageV5AsyncCheckResp.class;
    }

    public String getYidunRequestId() {
        return yidunRequestId;
    }

    public void setYidunRequestId(String yidunRequestId) {
        this.yidunRequestId = yidunRequestId;
    }
}
