package com.netease.yidun.sdk.antispam.list;

import com.netease.yidun.sdk.antispam.AntispamRequester;
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
import com.netease.yidun.sdk.core.utils.AssertUtils;

/**
 * 自定义关键词client
 */
public class ListClient {

    private AntispamRequester listRequester;

    public ListClient(AntispamRequester listRequester) {
        AssertUtils.notNull(listRequester, "listRequester can not be null");
        this.listRequester = listRequester;
    }

    public ListSubmitResponse submitList(ListSubmitRequest request) {
        return listRequester.getListCommonClient().submitList(request);
    }

    public ListUpdateResponse updateList(ListUpdateRequest request) {
        return listRequester.getListCommonClient().updateList(request);
    }

    public ListDeleteResponse deleteList(ListDeleteRequest request) {
        return listRequester.getListCommonClient().deleteList(request);
    }

    public ListQueryResponse queryList(ListQueryRequest request) {
        return listRequester.getListCommonClient().queryList(request);
    }

    public ImageListSubmitResponse submitImageList(ImageListSubmitRequest request) {
        return listRequester.getListCommonClient().submitImageList(request);
    }

    public ImageListUpdateResponse updateImageList(ImageListUpdateRequest request) {
        return listRequester.getListCommonClient().updateImageList(request);
    }

    public ImageListDeleteResponse deleteImageList(ImageListDeleteRequest request) {
        return listRequester.getListCommonClient().deleteImageList(request);
    }

    public ImageListQueryResponse queryImageList(ImageListQueryRequest request) {
        return listRequester.getListCommonClient().queryImageList(request);
    }
}
