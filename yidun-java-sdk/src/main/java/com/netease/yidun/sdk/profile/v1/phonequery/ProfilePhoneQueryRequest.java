package com.netease.yidun.sdk.profile.v1.phonequery;

import com.google.gson.Gson;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Map;

public class ProfilePhoneQueryRequest extends BizPostFormRequest<ProfilePhoneQueryResponse> {

    private static final Gson GSON = new Gson();

    /**
     * 查询手机号，每次最多查询100个手机号
     */
    @Size(max = 100, message = "单次支持最多查询100个手机号")
    @NotNull(message = "手机号不能为空")
    private List<String> phones;

    public ProfilePhoneQueryRequest(String businessId) {
        productCode = "profile";
        version = "v1";
        uriPattern = "/v1/profile/phone/multiple/query";
        this.businessId = businessId;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> customSignParams = super.getCustomSignParams();
        customSignParams.put("phones", GSON.toJson(phones));
        return customSignParams;
    }

    @Override
    public Class<ProfilePhoneQueryResponse> getResponseClass() {
        return ProfilePhoneQueryResponse.class;
    }

    @Override
    public String toString() {
        return "ProfilePhoneQueryRequest(" +
                "super=" + super.toString() +
                ", phones=" + phones +
                ")";
    }
}
