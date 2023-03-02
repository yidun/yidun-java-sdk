package com.netease.yidun.sdk.profile.v1.check;


public class ProfileCheckResult {

    /**
     * 数据上传成功的唯一标识
     */
    private String token;

    /**
     * 数据是否上传成功
     */
    private Boolean success;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "ProfileCheckResult(" +
                "token=" + token +
                ", success=" + success +
                ")";
    }
}