package com.netease.yidun.sdk.antispam.text.v5.check.sync.batch;

import java.util.List;

import com.netease.yidun.sdk.antispam.text.v5.check.sync.single.TextCheckResult;
import com.netease.yidun.sdk.core.response.CommonResponse;

/**
 * 文本批量同步检测响应
 */
public class TextBatchCheckResponse extends CommonResponse {

    private List<TextCheckResult> result;

    public List<TextCheckResult> getResult() {
        return result;
    }

    public void setResult(List<TextCheckResult> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "TextBatchCheckResponse("
                + "super=" + super.toString()
                + ", result=" + result
                + ")";
    }
}
