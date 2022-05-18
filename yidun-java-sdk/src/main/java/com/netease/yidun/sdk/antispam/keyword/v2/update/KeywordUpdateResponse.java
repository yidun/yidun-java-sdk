package com.netease.yidun.sdk.antispam.keyword.v2.update;

import com.netease.yidun.sdk.core.response.CommonResponse;

/**
 * 自定义关键词修改响应
 */
public class KeywordUpdateResponse extends CommonResponse {

    private Boolean result;

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "KeywordUpdateResponse("
                + "super=" + super.toString()
                + ", result=" + result
                + ")";
    }
}
