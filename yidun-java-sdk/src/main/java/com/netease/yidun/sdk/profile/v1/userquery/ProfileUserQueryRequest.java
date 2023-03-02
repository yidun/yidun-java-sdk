package com.netease.yidun.sdk.profile.v1.userquery;

import com.google.gson.Gson;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Map;


public class ProfileUserQueryRequest extends BizPostFormRequest<ProfileUserQueryResponse> {

    private static final Gson GSON = new Gson();

    /**
     * 查询账号，每次最多查询100个账号
     */
    @Size(max = 100, message = "单次支持最多查询100个账号")
    @NotNull(message = "账号不能为空")
    private List<String> accounts;

    public ProfileUserQueryRequest(String businessId) {
        productCode = "profile";
        version = "v1";
        uriPattern = "/v1/profile/user/multiple/query";
        this.businessId = businessId;
    }

    public List<String> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<String> accounts) {
        this.accounts = accounts;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> stringHashMap = super.getCustomSignParams();
        stringHashMap.put("accounts", GSON.toJson(accounts));
        return stringHashMap;
    }

    @Override
    public Class<ProfileUserQueryResponse> getResponseClass() {
        return ProfileUserQueryResponse.class;
    }

    @Override
    public String toString() {
        return "ProfileUserQueryRequest(" +
                "super=" + super.toString() +
                ", accounts=" + accounts +
                ")";
    }
}
