package com.netease.yidun.sdk.antispam.text.v5.callback.response;

import java.util.List;

import com.netease.yidun.sdk.antispam.text.v5.check.sync.single.TextCheckResult;
import com.netease.yidun.sdk.core.response.CommonResponse;

/**
 * 文本检测结果获取（轮询模式）响应
 */
public class TextCallBackResponse extends CommonResponse {

    private List<TextCheckResult> result;

    public List<TextCheckResult> getResult() {
        return result;
    }

    public void setResult(List<TextCheckResult> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "TextCallBackResponse("
                + "super=" + super.toString()
                + ", result=" + result
                + ")";
    }
}
