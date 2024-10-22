package com.netease.yidun.sdk.antispam.image.v5;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.BaseClient;
import com.netease.yidun.sdk.antispam.CallbackRegistry;
import com.netease.yidun.sdk.antispam.ClientRegistry;
import com.netease.yidun.sdk.antispam.image.query.request.ImageQueryRequest;
import com.netease.yidun.sdk.antispam.image.query.request.ImageQueryV2Request;
import com.netease.yidun.sdk.antispam.image.query.response.ImageQueryResponse;
import com.netease.yidun.sdk.antispam.image.query.response.ImageQueryV2Response;
import com.netease.yidun.sdk.antispam.image.v5.callback.ImageCallback;
import com.netease.yidun.sdk.antispam.image.v5.callback.request.ImageV5CallbackRequest;
import com.netease.yidun.sdk.antispam.image.v5.check.async.request.ImageV5AsyncCheckRequest;
import com.netease.yidun.sdk.antispam.image.v5.check.async.response.ImageV5AsyncCheckResp;
import com.netease.yidun.sdk.antispam.image.v5.check.sync.request.ImageV5SyncCheckRequest;
import com.netease.yidun.sdk.antispam.image.v5.check.sync.response.ImageV5CheckResponse;
import com.netease.yidun.sdk.antispam.image.v5.feedback.request.ImageV5FeedBackRequest;
import com.netease.yidun.sdk.antispam.image.v5.feedback.response.ImageV5FeedBackResponse;

/**
 * 用于发起所有图像相关请求的入口类
 */
public class ImageClient extends BaseClient {

    /**
     * 获取secretId对应的唯一实例
     *
     * @param antispamRequester
     * @return
     */
    public static ImageClient getInstance(AntispamRequester antispamRequester) {
        return ClientRegistry.register(antispamRequester, ImageClient.class);
    }

    /**
     * 获取secretId对应的唯一实例
     *
     * @param imageRequester
     * @param imageCallback
     * @return
     */
    public static ImageClient getInstance(AntispamRequester imageRequester, ImageCallback... imageCallback) {
        CallbackRegistry.register(imageRequester, imageCallback);
        return ClientRegistry.register(imageRequester, ImageClient.class);
    }

    public ImageClient(AntispamRequester imageRequester) {
        super(imageRequester);
    }

    public ImageClient(AntispamRequester imageRequester, ImageCallback imageCallback) {
        super(imageRequester, imageCallback);
    }

    public ImageClient(AntispamRequester imageRequester, ImageCallback... imageCallback) {
        super(imageRequester, imageCallback);
    }

    /**
     * 同步检测图像，建议配合callback来获取更精准的检测效果
     *
     * @param request
     * @return
     */
    public ImageV5CheckResponse syncCheckImage(ImageV5SyncCheckRequest request) {
        return requester.getImageCheckClient().syncCheckImage(request);
    }

    /**
     * 异步检测图像，配合callback获取检测结果
     *
     * @param request
     * @return
     */
    public ImageV5AsyncCheckResp asyncCheckImage(ImageV5AsyncCheckRequest request) {
        return requester.getImageCheckClient().asyncCheckImage(request);
    }

    /**
     * 底层callback接口，建议使用构造函数中的 {@link ImageCallback} ,获取回调结果更简单
     *
     * @param request
     * @return
     */
    public ImageV5CheckResponse callback(ImageV5CallbackRequest request) {
        return requester.getImageCommonClient().callback(request);
    }

    /**
     * 在图像检测结果和预期不一致时，用于反馈图像检测的正确结果，以改进图片下次检测的效果
     *
     * @param request
     * @return
     */
    public ImageV5FeedBackResponse feedback(ImageV5FeedBackRequest request) {
        return requester.getImageCommonClient().feedback(request);
    }

    /**
     * 图片taskIds查询接口
     *
     * @param request
     * @return
     */
    public ImageQueryResponse query(ImageQueryRequest request) {
        return requester.getImageCommonClient().query(request);
    }

    /**
     * 图片taskIds查询接口
     *
     * @param request
     * @return
     */
    public ImageQueryV2Response queryV2(ImageQueryV2Request request) {
        return requester.getImageCommonClient().queryV2(request);
    }

}
