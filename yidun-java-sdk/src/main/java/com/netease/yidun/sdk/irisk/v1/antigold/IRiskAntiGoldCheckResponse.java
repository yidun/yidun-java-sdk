package com.netease.yidun.sdk.irisk.v1.antigold;

import com.netease.yidun.sdk.core.response.CommonResponse;
import com.netease.yidun.sdk.irisk.v1.detail.IRiskDetailResult;

/**
 * @author dongyisheng@corp.netease.com
 * @version 2023/11/6 16:48
 */
public class IRiskAntiGoldCheckResponse extends CommonResponse {

    public IRiskAntiGoldCheckResponse(int code, String msg, IRiskDetailResult data) {
        super(code, msg);
    }

    @Override
    public String toString() {
        return "IRiskAntiGoldCheckResponse(" +
                "super=" + super.toString() +
                ")";
    }

}
