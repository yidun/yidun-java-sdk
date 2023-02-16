package com.netease.yidun.sdk.antispam.image.v5.callback.request;

import com.google.gson.reflect.TypeToken;
import com.netease.yidun.sdk.antispam.callback.ActiveCallbackRequest;
import com.netease.yidun.sdk.antispam.image.v5.check.sync.response.ImageV5Result;

import java.util.List;

/**
 * 图片主动回调实体
 */
public class ImageV5ActiveCallbackRequest extends ActiveCallbackRequest {

    private static final long serialVersionUID = -2354090338754448434L;

    public ImageV5Result parseImageCallbackData() {
        return parseCallbackData(ImageV5Result.class);
    }

    /**
     * 回调的数据存在两种，一种是单条数据，一种多条数据
     * 此方法会将单条数据和多条数据的格式统一为列表格式返回
     *
     * @return
     */
    public List<ImageV5Result> parseImageCallbackDataList() {
        return parseCallbackData(ImageV5Result.class, new TypeToken<List<ImageV5Result>>() {
        });
    }
}
