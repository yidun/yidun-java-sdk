package com.netease.yidun.sdk.profile.v1.userquery;

import com.netease.yidun.sdk.core.response.CommonResponse;


public class ProfileUserQueryResponse extends CommonResponse {

    /**
     * 返回数据
     */
    private ProfileUserQueryResult data;


    public ProfileUserQueryResponse(int code, String msg, ProfileUserQueryResult data) {
        super(code, msg);
        this.data = data;
    }

    public ProfileUserQueryResult getData() {
        return data;
    }

    public void setData(ProfileUserQueryResult data) {
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