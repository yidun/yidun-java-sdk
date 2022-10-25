package com.netease.yidun.sdk.antispam.list.user.v2.submit;

import com.netease.yidun.sdk.core.response.CommonResponse;
import lombok.Data;

import java.util.List;

/**
 * 图片名单添加响应
 */
@Data
public class ListSubmitResponse extends CommonResponse {
    private List<ListSubmitResp> result;
}
