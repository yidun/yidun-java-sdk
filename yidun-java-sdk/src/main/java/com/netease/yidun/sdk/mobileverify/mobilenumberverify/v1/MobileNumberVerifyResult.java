package com.netease.yidun.sdk.mobileverify.mobilenumberverify.v1;

public class MobileNumberVerifyResult {

    /**
     * 返回结果
     */
    private int result;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public MobileNumberVerifyResult result(int result) {
        this.result = result;
        return this;
    }

    @Override
    public String toString() {
        return "MobileNumberVerifyResult("
                + "result=" + result
                + ")";
    }
}
