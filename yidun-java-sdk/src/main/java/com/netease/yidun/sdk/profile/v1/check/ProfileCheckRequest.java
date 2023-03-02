package com.netease.yidun.sdk.profile.v1.check;

import com.google.gson.Gson;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;


public class ProfileCheckRequest extends BizPostFormRequest<ProfileCheckResponse> {

    private static final Gson GSON = new Gson();

    /**
     * 文本数据，对象列表
     */
    @NotNull(message = "文本数据不能为空")
    private List<CollectInfo> texts;

    public ProfileCheckRequest(String businessId) {
        productCode = "profile";
        version = "v1";
        uriPattern = "/v1/profile/user/async/check";
        this.businessId = businessId;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> customSignParams = super.getCustomSignParams();
        customSignParams.put("texts", GSON.toJson(texts));
        return customSignParams;
    }

    @Override
    public Class<ProfileCheckResponse> getResponseClass() {
        return ProfileCheckResponse.class;
    }

    public List<CollectInfo> getTexts() {
        return texts;
    }

    public void setTexts(List<CollectInfo> texts) {
        this.texts = texts;
    }

    @Override
    public String toString() {
        return "ProfileCheckRequest(" +
                "super=" + super.toString() +
                ", texts=" + texts +
                ")";
    }
}
