package com.netease.yidun.sdk.profile.v1.ipquery;

import com.netease.yidun.sdk.core.response.CommonResponse;


public class ProfileIpQueryResponse extends CommonResponse {

    /**
     * 返回数据
     */
    private ProfileIpQueryResult data;


    public ProfileIpQueryResponse(int code, String msg, ProfileIpQueryResult data) {
        super(code, msg);
        this.data = data;
    }

    public ProfileIpQueryResult getData() {
        return data;
    }

    public void setData(ProfileIpQueryResult data) {
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