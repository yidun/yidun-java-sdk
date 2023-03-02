package com.netease.yidun.sdk.profile.v1.riskquery;

import com.netease.yidun.sdk.core.response.CommonResponse;


public class ProfileRiskQueryResponse extends CommonResponse {

    /**
     * 返回数据
     */
    private ProfileRiskQueryResult data;


    public ProfileRiskQueryResponse(int code, String msg, ProfileRiskQueryResult data) {
        super(code, msg);
        this.data = data;
    }

    public ProfileRiskQueryResult getData() {
        return data;
    }

    public void setData(ProfileRiskQueryResult data) {
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