package com.netease.yidun.sdk.auth.face.recognize.v1;

import com.netease.yidun.sdk.core.response.ResultResponse;

/**
 * 人脸检索响应
 */
public class FaceRecognizeResponse extends ResultResponse<FaceRecognizeResult> {

    public FaceRecognizeResponse(int code, String msg, FaceRecognizeResult result) {
        super(code, msg, result);
    }

    @Override
    public String toString() {
        return "FaceRecognizeResponse(" +
                "super=" + super.toString() +
                ")";
    }
}
