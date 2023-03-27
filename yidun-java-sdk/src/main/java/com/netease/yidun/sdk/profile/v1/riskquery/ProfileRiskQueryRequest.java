package com.netease.yidun.sdk.profile.v1.riskquery;

import com.google.gson.Gson;
import com.netease.yidun.sdk.core.request.PostFormRequest;
import com.netease.yidun.sdk.profile.v1.common.Portrait;

import com.netease.yidun.sdk.core.validation.limitation.NotNull;
import java.util.Map;


public class ProfileRiskQueryRequest extends PostFormRequest<ProfileRiskQueryResponse> {

    private static final Gson GSON = new Gson();

    /**
     * 查询账号、手机号、IP信息
     */
    @NotNull(message = "查询信息不能为空")
    private Portrait portrait;

    public ProfileRiskQueryRequest() {
        productCode = "profile";
        version = "v1";
        uriPattern = "/v1/profile/risk/multiple/query";
    }

    public Portrait getPortrait() {
        return portrait;
    }

    public void setPortrait(Portrait portrait) {
        this.portrait = portrait;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> customSignParams = super.getCustomSignParams();
        customSignParams.put("portrait", GSON.toJson(portrait));
        return customSignParams;
    }

    @Override
    public Class<ProfileRiskQueryResponse> getResponseClass() {
        return ProfileRiskQueryResponse.class;
    }

    @Override
    public String toString() {
        return "ProfileRiskQueryRequest(" +
                "super=" + super.toString() +
                ", portrait=" + portrait +
                ")";
    }
}
