package com.netease.yidun.sdk.antispam.image.v5.callback.request;

import com.netease.yidun.sdk.antispam.callback.ActiveCallbackRequest;
import com.netease.yidun.sdk.antispam.image.v5.check.sync.response.ImageV5Result;

/**
 * 图片主动回调实体
 */
public class ImageV5ActiveCallbackRequest extends ActiveCallbackRequest {

    private static final long serialVersionUID = -2354090338754448434L;

    public ImageV5Result parseImageCallbackData() {
        return parseCallbackData(ImageV5Result.class);
    }

}
