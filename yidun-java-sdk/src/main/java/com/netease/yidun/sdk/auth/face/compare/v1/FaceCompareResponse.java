package com.netease.yidun.sdk.auth.face.compare.v1;

import com.netease.yidun.sdk.core.response.ResultResponse;

/**
 * 人脸比对响应
 */
public class FaceCompareResponse extends ResultResponse<FaceCompareResult> {

    public FaceCompareResponse(int code, String msg, FaceCompareResult result) {
        super(code, msg, result);
    }

    @Override
    public String toString() {
        return "FaceCompareResponse(" +
                "super=" + super.toString() +
                ")";
    }
}
