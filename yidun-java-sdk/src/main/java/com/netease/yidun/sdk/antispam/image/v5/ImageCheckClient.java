package com.netease.yidun.sdk.antispam.image.v5;

import com.netease.yidun.sdk.antispam.AntispamClient;
import com.netease.yidun.sdk.antispam.image.v5.check.async.request.ImageV5AsyncCheckRequest;
import com.netease.yidun.sdk.antispam.image.v5.check.async.response.ImageV5AsyncCheckResp;
import com.netease.yidun.sdk.antispam.image.v5.check.sync.request.ImageV5SyncCheckRequest;
import com.netease.yidun.sdk.antispam.image.v5.check.sync.response.ImageV5CheckResponse;
import com.netease.yidun.sdk.antispam.image.v5.enums.ImageTypeEnum;
import com.netease.yidun.sdk.core.client.ClientProfile;
import com.netease.yidun.sdk.core.utils.CollectionUtils;

import java.util.Optional;

public class ImageCheckClient extends AntispamClient {

    public ImageCheckClient(ClientProfile clientProfile) {
        super(clientProfile);
    }

    @Override
    protected String clientName() {
        return "ImageCheck";
    }

    public ImageV5CheckResponse syncCheckImage(ImageV5SyncCheckRequest request) {
        // 如果有base64图片，调用base64Check接口
        if (!CollectionUtils.isEmpty(request.getImages())) {
            boolean hasBase64 = request.getImages().stream()
                           .anyMatch(imageBeanRequest -> ImageTypeEnum.BASE64.getType() == Optional
                                   .ofNullable(imageBeanRequest.getType())
                                   .orElse(0));
            if (hasBase64) {
                request.setUriPattern("/v5/image/base64Check");
            }
        }

        return client.execute(request);
    }

    public ImageV5AsyncCheckResp asyncCheckImage(ImageV5AsyncCheckRequest request) {
        return client.execute(request);
    }

}
