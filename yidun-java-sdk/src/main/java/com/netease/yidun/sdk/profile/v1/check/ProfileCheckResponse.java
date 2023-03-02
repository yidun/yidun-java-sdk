package com.netease.yidun.sdk.profile.v1.check;

import com.netease.yidun.sdk.core.response.CommonResponse;


public class ProfileCheckResponse extends CommonResponse {

    /**
     * 返回数据
     */
    private ProfileCheckResult data;


    public ProfileCheckResponse(int code, String msg, ProfileCheckResult data) {
        super(code, msg);
        this.data = data;
    }

    public ProfileCheckResult getData() {
        return data;
    }

    public void setData(ProfileCheckResult data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "IRiskConfigResponse(" +
                "super=" + super.toString() +
                ", data=" + data +
                ")";
    }
}