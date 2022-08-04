package com.netease.yidun.sdk.antispam.file.v2.callback.request;

import com.netease.yidun.sdk.antispam.file.v2.callback.response.FileCallbackV2Response;
import com.netease.yidun.sdk.core.http.HttpMethodEnum;
import com.netease.yidun.sdk.core.request.PostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;

import java.util.Map;

/**
 * 文档检测结果回调v1.1接口
 */
public class FileCallbackV2Request extends PostFormRequest<FileCallbackV2Response> {

    /**
     * 请求的唯一ID
     */
    private String yidunRequestId;

    public FileCallbackV2Request() {
        productCode = "file";
        uriPattern = "/v2/file/callback/results";
        method = HttpMethodEnum.POST;
        version = "v2.0";
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
    public Class<FileCallbackV2Response> getResponseClass() {
        return FileCallbackV2Response.class;
    }

    public String getYidunRequestId() {
        return yidunRequestId;
    }

    public void setYidunRequestId(String yidunRequestId) {
        this.yidunRequestId = yidunRequestId;
    }
}
