package com.netease.yidun.sdk.profile.v1.phonequery;

import com.netease.yidun.sdk.core.response.CommonResponse;


public class ProfilePhoneQueryResponse extends CommonResponse {

    /**
     * 返回数据
     */
    private ProfilePhoneQueryResult data;


    public ProfilePhoneQueryResponse(int code, String msg, ProfilePhoneQueryResult data) {
        super(code, msg);
        this.data = data;
    }

    public ProfilePhoneQueryResult getData() {
        return data;
    }

    public void setData(ProfilePhoneQueryResult data) {
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