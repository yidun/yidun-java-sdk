package com.netease.yidun.sdk.antispam.image.v5;

import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.image.v5.callback.ImageCallback;
import com.netease.yidun.sdk.antispam.image.v5.callback.request.ImageV5CallbackRequest;
import com.netease.yidun.sdk.antispam.image.v5.check.async.request.ImageV5AsyncCheckRequest;
import com.netease.yidun.sdk.antispam.image.v5.check.async.response.ImageV5AsyncCheckResp;
import com.netease.yidun.sdk.antispam.image.v5.check.sync.request.ImageV5SyncCheckRequest;
import com.netease.yidun.sdk.antispam.image.v5.check.sync.response.ImageV5CheckResponse;
import com.netease.yidun.sdk.antispam.image.v5.feedback.request.ImageV5FeedBackRequest;
import com.netease.yidun.sdk.antispam.image.v5.feedback.response.ImageV5FeedBackResponse;
import com.netease.yidun.sdk.core.utils.AssertUtils;

/**
 * 用于发起所有图像相关请求的入口类
 */
public class ImageClient {

    private AntispamRequester imageRequester;

    public ImageClient(AntispamRequester imageRequester) {
        AssertUtils.notNull(imageRequester, "imageRequester can not be null");
        this.imageRequester = imageRequester;
    }

    public ImageClient(AntispamRequester imageRequester, ImageCallback imageCallback) {
        AssertUtils.notNull(imageRequester, "imageRequester can not be null");

        this.imageRequester = imageRequester;
        if (imageCallback != null) {
            if (imageCallback.getAntispamRequester() == null) {
                imageCallback.setAntispamRequester(imageRequester);
            }
            imageCallback.start();
        }
    }

    /**
     * 同步检测图像，建议配合callback来获取更精准的检测效果
     *
     * @param request
     * @return
     */
    public ImageV5CheckResponse syncCheckImage(ImageV5SyncCheckRequest request) {
        return imageRequester.getImageCheckClient().syncCheckImage(request);
    }

    /**
     * 异步检测图像，配合callback获取检测结果
     *
     * @param request
     * @return
     */
    public ImageV5AsyncCheckResp asyncCheckImage(ImageV5AsyncCheckRequest request) {
        return imageRequester.getImageCheckClient().asyncCheckImage(request);
    }

    /**
     * 底层callback接口，建议使用构造函数中的 {@link ImageCallback} ,获取回调结果更简单
     *
     * @param request
     * @return
     */
    public ImageV5CheckResponse callback(ImageV5CallbackRequest request) {
        return imageRequester.getImageCommonClient().callback(request);
    }

    /**
     * 在图像检测结果和预期不一致时，用于反馈图像检测的正确结果，以改进图片下次检测的效果
     *
     * @param request
     * @return
     */
    public ImageV5FeedBackResponse feedback(ImageV5FeedBackRequest request) {
        return imageRequester.getImageCommonClient().feedback(request);
    }

}
