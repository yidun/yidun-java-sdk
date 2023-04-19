package com.netease.yidun.sdk.auth.face.recognize.register.v1;

/**
 * 人脸注册结果
 */
public class FaceRegisterResult {

    /**
     * 注册结果
     */
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FaceRegisterResult(" +
                "status=" + status +
                ")";
    }
}
