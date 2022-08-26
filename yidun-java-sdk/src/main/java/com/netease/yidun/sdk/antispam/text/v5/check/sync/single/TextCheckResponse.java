package com.netease.yidun.sdk.antispam.text.v5.check.sync.single;

import com.netease.yidun.sdk.core.response.CommonResponse;

/**
 * 文本单次同步检测响应
 */
public class TextCheckResponse extends CommonResponse {

    private TextCheckResult result;

    public TextCheckResult getResult() {
        return result;
    }

    public TextCheckResponse(){}

    public void setResult(TextCheckResult result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "TextCheckResponse("
                + "super=" + super.toString()
                + ", result=" + result
                + ")";

    }
}
