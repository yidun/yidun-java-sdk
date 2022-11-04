package com.netease.yidun.sdk.antispam.list.imagelist.v1.delete;


import com.netease.yidun.sdk.core.request.PostFormRequest;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * 图片名单删除请求
 */
@Data
public class ImageListDeleteRequest extends PostFormRequest<ImageListDeleteResponse> {
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

    public ImageListDeleteRequest() {
        productCode = "list";
        version = "v1";
        uriPattern = "/v1/image/list/delete";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("uuid", uuid);
        params.put("type", type != null ? String.valueOf(type) : null);
        params.put("md5", md5);
        params.put("url", url);
        params.put("businessId", businessId);
        return params;
    }

    @Override
    public Class<ImageListDeleteResponse> getResponseClass() {
        return ImageListDeleteResponse.class;
    }

}
