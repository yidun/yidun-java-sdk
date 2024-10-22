package com.netease.yidun.sdk.antispam.image.v5;

import com.netease.yidun.sdk.antispam.AntispamClient;
import com.netease.yidun.sdk.antispam.image.query.request.ImageQueryRequest;
import com.netease.yidun.sdk.antispam.image.query.request.ImageQueryV2Request;
import com.netease.yidun.sdk.antispam.image.query.response.ImageQueryResponse;
import com.netease.yidun.sdk.antispam.image.query.response.ImageQueryV2Response;
import com.netease.yidun.sdk.antispam.image.v5.callback.request.ImageV5CallbackRequest;
import com.netease.yidun.sdk.antispam.image.v5.check.sync.response.ImageV5CheckResponse;
import com.netease.yidun.sdk.antispam.image.v5.feedback.request.ImageV5FeedBackRequest;
import com.netease.yidun.sdk.antispam.image.v5.feedback.response.ImageV5FeedBackResponse;
import com.netease.yidun.sdk.core.client.ClientProfile;

public class ImageCommonClient extends AntispamClient {

    public ImageCommonClient(ClientProfile clientProfile) {
        super(clientProfile);
    }

    public ImageV5CheckResponse callback(ImageV5CallbackRequest request) {
        return client.execute(request);
    }

    public ImageV5FeedBackResponse feedback(ImageV5FeedBackRequest request) {
        return client.execute(request);
    }

    /**
     * 图片查询接口
     * @param request
     * @return
     */
    public ImageQueryResponse query(ImageQueryRequest request) {
        return client.execute(request);
    }

    /**
     * 图片查询接口 V2
     * @param request
     * @return
     */
    public ImageQueryV2Response queryV2(ImageQueryV2Request request) {
        return client.execute(request);
    }
}
