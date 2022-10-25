package com.netease.yidun.sdk.antispam.list.imagelist.v1;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.list.imagelist.v1.delete.ImageListDeleteRequest;
import com.netease.yidun.sdk.antispam.list.imagelist.v1.delete.ImageListDeleteResponse;
import com.netease.yidun.sdk.antispam.list.imagelist.v1.query.ImageListQueryRequest;
import com.netease.yidun.sdk.antispam.list.imagelist.v1.query.ImageListQueryResponse;
import com.netease.yidun.sdk.antispam.list.imagelist.v1.submit.ImageListSubmitRequest;
import com.netease.yidun.sdk.antispam.list.imagelist.v1.submit.ImageListSubmitResponse;
import com.netease.yidun.sdk.antispam.list.imagelist.v1.update.ImageListUpdateRequest;
import com.netease.yidun.sdk.antispam.list.imagelist.v1.update.ImageListUpdateResponse;
import com.netease.yidun.sdk.core.utils.AssertUtils;

/**
 * 自定义关键词client
 */
public class ImageListClient {

    private AntispamRequester imageListRequester;

    public ImageListClient(AntispamRequester imageListRequester) {
        AssertUtils.notNull(imageListRequester, "imageListRequester can not be null");
        this.imageListRequester = imageListRequester;
    }

    public ImageListSubmitResponse submit(ImageListSubmitRequest request) {
        return imageListRequester.getImageListCommonClient().submit(request);
    }

    public ImageListUpdateResponse update(ImageListUpdateRequest request) {
        return imageListRequester.getImageListCommonClient().update(request);
    }

    public ImageListDeleteResponse delete(ImageListDeleteRequest request) {
        return imageListRequester.getImageListCommonClient().delete(request);
    }

    public ImageListQueryResponse query(ImageListQueryRequest request) {
        return imageListRequester.getImageListCommonClient().query(request);
    }
}
