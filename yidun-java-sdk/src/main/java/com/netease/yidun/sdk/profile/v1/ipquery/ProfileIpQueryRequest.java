package com.netease.yidun.sdk.profile.v1.ipquery;

import com.google.gson.Gson;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;

import com.netease.yidun.sdk.core.validation.limitation.NotNull;
import com.netease.yidun.sdk.core.validation.limitation.Size;
import java.util.List;
import java.util.Map;


public class ProfileIpQueryRequest extends BizPostFormRequest<ProfileIpQueryResponse> {

    private static final Gson GSON = new Gson();

    /**
     * 查询IP，每次最多查询100个IP
     */
    @Size(max = 100, message = "单词支持最多查询100个ip")
    @NotNull(message = "ip不能为空")
    private List<String> ips;

    public ProfileIpQueryRequest(String businessId) {
        productCode = "profile";
        version = "v1";
        uriPattern = "/v1/profile/ip/multiple/query";
        this.businessId = businessId;
    }

    public List<String> getIps() {
        return ips;
    }

    public void setIps(List<String> ips) {
        this.ips = ips;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> customSignParams = super.getCustomSignParams();
        customSignParams.put("ips", GSON.toJson(ips));
        return customSignParams;
    }

    @Override
    public Class<ProfileIpQueryResponse> getResponseClass() {
        return ProfileIpQueryResponse.class;
    }

    @Override
    public String toString() {
        return "ProfileIpQueryRequest(" +
                "super=" + super.toString() +
                ", ips=" + ips +
                ")";
    }
}
