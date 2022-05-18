package com.netease.yidun.sdk.antispam.keyword.v1.delete;

import com.netease.yidun.sdk.core.response.CommonResponse;

/**
 * 自定义关键词删除响应
 */
public class KeywordDeleteResponse extends CommonResponse {

    private Boolean result;

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "KeywordDeleteResponse("
                + "super=" + super.toString()
                + ", result=" + result
                + ")";
    }
}
