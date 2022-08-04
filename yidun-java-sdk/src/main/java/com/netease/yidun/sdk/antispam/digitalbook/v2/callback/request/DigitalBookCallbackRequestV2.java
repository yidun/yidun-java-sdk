package com.netease.yidun.sdk.antispam.digitalbook.v2.callback.request;

import com.netease.yidun.sdk.antispam.digitalbook.v2.callback.response.DigitalBookCallbackResponseV2;
import com.netease.yidun.sdk.core.request.PostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;

import java.util.Map;

/**
 * 融媒体v2回调请求
 */
public class DigitalBookCallbackRequestV2 extends PostFormRequest<DigitalBookCallbackResponseV2> {

    /**
     * 请求的唯一ID
     */
    private String yidunRequestId;

    public DigitalBookCallbackRequestV2() {
        productCode = "digitalBook";
        uriPattern = "/v2/digital/callback/results";
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
    public Class<DigitalBookCallbackResponseV2> getResponseClass() {
        return DigitalBookCallbackResponseV2.class;
    }

    public String getYidunRequestId() {
        return yidunRequestId;
    }

    public void setYidunRequestId(String yidunRequestId) {
        this.yidunRequestId = yidunRequestId;
    }
}
