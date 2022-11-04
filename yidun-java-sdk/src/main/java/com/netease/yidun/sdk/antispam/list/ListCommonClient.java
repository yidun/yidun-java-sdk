package com.netease.yidun.sdk.antispam.list;

import com.netease.yidun.sdk.antispam.AntispamClient;
import com.netease.yidun.sdk.antispam.list.imagelist.v1.delete.ImageListDeleteRequest;
import com.netease.yidun.sdk.antispam.list.imagelist.v1.delete.ImageListDeleteResponse;
import com.netease.yidun.sdk.antispam.list.imagelist.v1.query.ImageListQueryRequest;
import com.netease.yidun.sdk.antispam.list.imagelist.v1.query.ImageListQueryResponse;
import com.netease.yidun.sdk.antispam.list.imagelist.v1.submit.ImageListSubmitRequest;
import com.netease.yidun.sdk.antispam.list.imagelist.v1.submit.ImageListSubmitResponse;
import com.netease.yidun.sdk.antispam.list.imagelist.v1.update.ImageListUpdateRequest;
import com.netease.yidun.sdk.antispam.list.imagelist.v1.update.ImageListUpdateResponse;
import com.netease.yidun.sdk.antispam.list.user.v2.delete.ListDeleteRequest;
import com.netease.yidun.sdk.antispam.list.user.v2.delete.ListDeleteResponse;
import com.netease.yidun.sdk.antispam.list.user.v2.query.ListQueryRequest;
import com.netease.yidun.sdk.antispam.list.user.v2.query.ListQueryResponse;
import com.netease.yidun.sdk.antispam.list.user.v2.submit.ListSubmitRequest;
import com.netease.yidun.sdk.antispam.list.user.v2.submit.ListSubmitResponse;
import com.netease.yidun.sdk.antispam.list.user.v2.update.ListUpdateRequest;
import com.netease.yidun.sdk.antispam.list.user.v2.update.ListUpdateResponse;
import com.netease.yidun.sdk.core.client.ClientProfile;

public class ListCommonClient extends AntispamClient {

    public ListCommonClient(ClientProfile clientProfile) {
        super(clientProfile);
    }

    public ListSubmitResponse submitList(ListSubmitRequest request) {
        return client.execute(request);
    }

    public ListUpdateResponse updateList(ListUpdateRequest request) {
        return client.execute(request);
    }

    public ListDeleteResponse deleteList(ListDeleteRequest request) {
        return client.execute(request);
    }

    public ListQueryResponse queryList(ListQueryRequest request) {
        return client.execute(request);
    }

    public ImageListSubmitResponse submitImageList(ImageListSubmitRequest request) {
        return client.execute(request);
    }

    public ImageListUpdateResponse updateImageList(ImageListUpdateRequest request) {
        return client.execute(request);
    }

    public ImageListDeleteResponse deleteImageList(ImageListDeleteRequest request) {
        return client.execute(request);
    }

    public ImageListQueryResponse queryImageList(ImageListQueryRequest request) {
        return client.execute(request);
    }
}
