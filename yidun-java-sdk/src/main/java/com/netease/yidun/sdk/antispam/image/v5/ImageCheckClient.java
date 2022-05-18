package com.netease.yidun.sdk.antispam.image.v5;

import com.netease.yidun.sdk.antispam.AntispamClient;
import com.netease.yidun.sdk.antispam.image.v5.check.async.request.ImageV5AsyncCheckRequest;
import com.netease.yidun.sdk.antispam.image.v5.check.async.response.ImageV5AsyncCheckResp;
import com.netease.yidun.sdk.antispam.image.v5.check.sync.request.ImageV5SyncCheckRequest;
import com.netease.yidun.sdk.antispam.image.v5.check.sync.response.ImageV5CheckResponse;
import com.netease.yidun.sdk.core.client.ClientProfile;

public class ImageCheckClient extends AntispamClient {

    public ImageCheckClient(ClientProfile clientProfile) {
        super(clientProfile);
    }

    public ImageV5CheckResponse syncCheckImage(ImageV5SyncCheckRequest request) {
        return client.execute(request);
    }

    public ImageV5AsyncCheckResp asyncCheckImage(ImageV5AsyncCheckRequest request) {
        return client.execute(request);
    }

}
