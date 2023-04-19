package com.netease.yidun.sdk.mobileverify.oneclicklogin.v1;

public class MobileNumberResult {
    /**
     * 运营商返回的电话号码
     */
    private String phone;

    /**
     * 运营商返回的错误码
     */
    private String resultCode;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String phone() {
        return phone;
    }

    public MobileNumberResult phone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String resultCode() {
        return resultCode;
    }

    public MobileNumberResult resultCode(String resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    @Override
    public String toString() {
        return "MobileNumberResult("
                + "phone=" + phone
                + ", resultCode=" + resultCode
                + ")";
    }
}
