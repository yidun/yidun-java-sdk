package com.netease.yidun.sdk.antispam.list.imagelist.v1.update;


import com.netease.yidun.sdk.core.request.PostFormRequest;
import lombok.Data;

import com.netease.yidun.sdk.core.validation.limitation.NotNull;
import java.util.Map;

/**
 * 图片名单更新请求
 */
@Data
public class ImageListUpdateRequest extends PostFormRequest<ImageListUpdateResponse> {
    /**
     * 图片名单唯一标识
     */
    private String uuid;
    /**
     * 名单库（黑白或者md5）ImageStorageSwitchEnum
     */
    @NotNull(message = "type不能为空")
    private Integer type;
    /**
     * 图片名单状态,ImageListStatus
     */
    @NotNull(message = "status不能为空")
    private Integer status;
    /**
     * 图片md5，uuid，url和md5必须传一个,且如果只传了md5或者url必须传businessId
     */
    private String md5;
    /**
     * 图片url，uuid，url和md5必须传一个,且如果只传了md5或者url必须传businessId
     */
    private String url;
    /**
     * 业务id
     */
    protected String businessId;

    public ImageListUpdateRequest() {
        productCode = "list";
        version = "v1";
        uriPattern = "/v1/image/list/update";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("uuid", uuid);
        params.put("type", type != null ? String.valueOf(type) : null);
        params.put("status", status != null ? String.valueOf(status) : null);
        params.put("md5", md5);
        params.put("url", url);
        params.put("businessId", businessId);
        return params;
    }

    @Override
    public Class<ImageListUpdateResponse> getResponseClass() {
        return ImageListUpdateResponse.class;
    }

}
