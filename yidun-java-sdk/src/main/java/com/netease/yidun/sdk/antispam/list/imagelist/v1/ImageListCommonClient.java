package com.netease.yidun.sdk.antispam.list.imagelist.v1;

import com.netease.yidun.sdk.antispam.AntispamClient;
import com.netease.yidun.sdk.antispam.list.imagelist.v1.delete.ImageListDeleteRequest;
import com.netease.yidun.sdk.antispam.list.imagelist.v1.delete.ImageListDeleteResponse;
import com.netease.yidun.sdk.antispam.list.imagelist.v1.query.ImageListQueryRequest;
import com.netease.yidun.sdk.antispam.list.imagelist.v1.query.ImageListQueryResponse;
import com.netease.yidun.sdk.antispam.list.imagelist.v1.submit.ImageListSubmitRequest;
import com.netease.yidun.sdk.antispam.list.imagelist.v1.submit.ImageListSubmitResponse;
import com.netease.yidun.sdk.antispam.list.imagelist.v1.update.ImageListUpdateRequest;
import com.netease.yidun.sdk.antispam.list.imagelist.v1.update.ImageListUpdateResponse;
import com.netease.yidun.sdk.core.client.ClientProfile;

public class ImageListCommonClient extends AntispamClient {

    public ImageListCommonClient(ClientProfile clientProfile) {
        super(clientProfile);
    }

    public ImageListSubmitResponse submit(ImageListSubmitRequest request) {
        return client.execute(request);
    }

    public ImageListUpdateResponse update(ImageListUpdateRequest request) {
        return client.execute(request);
    }

    public ImageListDeleteResponse delete(ImageListDeleteRequest request) {
        return client.execute(request);
    }

    public ImageListQueryResponse query(ImageListQueryRequest request) {
        return client.execute(request);
    }
}
