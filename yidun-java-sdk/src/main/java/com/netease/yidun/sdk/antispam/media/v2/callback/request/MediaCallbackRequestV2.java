package com.netease.yidun.sdk.antispam.media.v2.callback.request;

import com.netease.yidun.sdk.antispam.media.v2.callback.response.MediaCallbackResponseV2;
import com.netease.yidun.sdk.core.request.PostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;

import java.util.Map;

/**
 * 融媒体v2回调请求
 */
public class MediaCallbackRequestV2 extends PostFormRequest<MediaCallbackResponseV2> {


    /**
     * 请求的唯一ID
     */
    private String yidunRequestId;

    public MediaCallbackRequestV2() {
        productCode = "media";
        uriPattern = "/v2/mediasolution/callback/results";
        version = "v2";
    }

    /**
     * 获取具体业务中特有的需要参与签名计算的参数
     *
     * @return 返回需要参与签名的参数
     */
    protected Map<String, String> getCustomSignParams() {
        StringHashMap params = new StringHashMap();
        params.put("yidunRequestId", getYidunRequestId());
        return params;
    }

    @Override
    public Class<MediaCallbackResponseV2> getResponseClass() {
        return MediaCallbackResponseV2.class;
    }

    public String getYidunRequestId() {
        return yidunRequestId;
    }

    public void setYidunRequestId(String yidunRequestId) {
        this.yidunRequestId = yidunRequestId;
    }
}
