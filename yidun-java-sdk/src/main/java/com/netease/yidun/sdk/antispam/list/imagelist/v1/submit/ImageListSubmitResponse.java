package com.netease.yidun.sdk.antispam.list.imagelist.v1.submit;

import com.netease.yidun.sdk.core.response.CommonResponse;
import lombok.Data;

/**
 * 图片名单添加响应
 */
@Data
public class ImageListSubmitResponse extends CommonResponse {
    private ImageListSubmitResp result;
}
