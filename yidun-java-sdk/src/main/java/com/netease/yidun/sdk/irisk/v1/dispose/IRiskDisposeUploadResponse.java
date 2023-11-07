package com.netease.yidun.sdk.irisk.v1.dispose;

import com.netease.yidun.sdk.core.response.CommonResponse;
import com.netease.yidun.sdk.irisk.v1.detail.IRiskDetailResult;

/**
 * @author dongyisheng@corp.netease.com
 * @version 2023/11/6 15:33
 */
public class IRiskDisposeUploadResponse extends CommonResponse {

    public IRiskDisposeUploadResponse(int code, String msg, IRiskDetailResult data) {
        super(code, msg);
    }

    @Override
    public String toString() {
        return "IRiskDisposeUploadResponse(" +
                "super=" + super.toString() +
                ")";
    }
}
