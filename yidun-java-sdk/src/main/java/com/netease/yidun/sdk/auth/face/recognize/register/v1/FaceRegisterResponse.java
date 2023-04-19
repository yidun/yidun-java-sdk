package com.netease.yidun.sdk.auth.face.recognize.register.v1;

import com.netease.yidun.sdk.core.response.ResultResponse;

/**
 * 人脸注册响应
 */
public class FaceRegisterResponse extends ResultResponse<FaceRegisterResult> {

    public FaceRegisterResponse(int code, String msg, FaceRegisterResult result) {
        super(code, msg, result);
    }

    @Override
    public String toString() {
        return "FaceRegisterResponse(" +
                "super=" + super.toString() +
                ")";
    }
}
