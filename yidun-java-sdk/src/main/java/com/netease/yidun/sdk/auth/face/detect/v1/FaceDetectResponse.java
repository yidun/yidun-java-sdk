package com.netease.yidun.sdk.auth.face.detect.v1;

import com.netease.yidun.sdk.core.response.ResultResponse;

/**
 * 人脸检测响应
 */
public class FaceDetectResponse extends ResultResponse<FaceDetectResult> {

    public FaceDetectResponse(int code, String msg, FaceDetectResult result) {
        super(code, msg, result);
    }

    @Override
    public String toString() {
        return "FaceDetectResponse(" +
                "super=" + super.toString() +
                ")";
    }
}
