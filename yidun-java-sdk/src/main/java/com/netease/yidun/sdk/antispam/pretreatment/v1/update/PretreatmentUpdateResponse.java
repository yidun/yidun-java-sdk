package com.netease.yidun.sdk.antispam.pretreatment.v1.update;

import com.netease.yidun.sdk.core.response.CommonResponse;

/**
 * 自定义忽略词修改响应
 */
public class PretreatmentUpdateResponse extends CommonResponse {

    private Boolean result;

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "PretreatmentUpdateResponse("
                + "super=" + super.toString()
                + ", result=" + result
                + ")";
    }
}
