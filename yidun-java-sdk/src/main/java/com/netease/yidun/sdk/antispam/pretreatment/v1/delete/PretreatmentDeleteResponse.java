package com.netease.yidun.sdk.antispam.pretreatment.v1.delete;

import com.netease.yidun.sdk.core.response.CommonResponse;

/**
 * 自定义忽略词删除响应
 */
public class PretreatmentDeleteResponse extends CommonResponse {

    private Boolean result;

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "PretreatmentDeleteResponse("
                + "super=" + super.toString()
                + ", result=" + result
                + ")";
    }
}
