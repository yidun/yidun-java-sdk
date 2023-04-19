package com.netease.yidun.sdk.sms.v2;

public class ResultInfo {

    /**
     * 接口调用状态。200：正常；其他值：调用出错。详见易盾官网开发文档。
     */
    private int result;
    /**
     * 本次请求的唯一标识符
     */
    private String requestId;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    @Override
    public String toString() {
        return "ResultInfo("
                + "result=" + result
                + ", requestId=" + requestId
                + ")";
    }
}
