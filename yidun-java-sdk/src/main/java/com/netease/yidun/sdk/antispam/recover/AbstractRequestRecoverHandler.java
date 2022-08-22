package com.netease.yidun.sdk.antispam.recover;

import com.netease.yidun.sdk.core.response.BaseResponse;

public abstract class AbstractRequestRecoverHandler<T extends BaseResponse> {

    public abstract void handle(T response);
}
