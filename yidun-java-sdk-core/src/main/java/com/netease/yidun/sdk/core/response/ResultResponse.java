
package com.netease.yidun.sdk.core.response;

public class ResultResponse<T> extends CommonResponse {

    private T result;

    public ResultResponse(int code, String msg, T result) {
        super(code, msg);
        this.result = result;
    }

    public ResultResponse() {}


    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResultResponse("
                + "super=" + super.toString()
                + ", result=" + result
                + ")";
    }
}
