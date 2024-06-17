package com.netease.yidun.sdk.captcha.v2;

import com.netease.yidun.sdk.core.response.BaseResponse;

/**
 * captcha verify response
 */
public class CaptchaVerifyResponse implements BaseResponse {
    private static final long serialVersionUID = -3993621897594176277L;
    /**
     * 异常代号
     */
    private int error;
    /**
     * 错误描述信息
     */
    private String msg;
    /**
     * 验证码最终判定结果，以此字段为准：true:校验通过，false:校验不通过
     */
    private boolean result;
    /**
     * 仅限于短信上行验证码类型，返回用户发送上行短信成功后的手机号
     */
    private String phone;
    /**
     * 返回业务方在初始化时传入的extraData内容
     */
    private String extraData;
    /**
     * 用于返回验证码类型，需要配置是否返回
     */
    private int captchaType;
    /**
     * 用于返回验证流程token，需要配置是否返回
     */
    private String token;
    /**
     * 用于标识是否走降级策略，需要配置是否返回
     */
    private String sdkReduce;

    /**
     * 客户端IP
     */
    private String clientIp;
    /**
     * 客户端UA
     */
    private String clientUa;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getExtraData() {
        return extraData;
    }

    public void setExtraData(String extraData) {
        this.extraData = extraData;
    }

    public int getCaptchaType() {
        return captchaType;
    }

    public void setCaptchaType(int captchaType) {
        this.captchaType = captchaType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSdkReduce() {
        return sdkReduce;
    }

    public void setSdkReduce(String sdkReduce) {
        this.sdkReduce = sdkReduce;
    }
    
    public String getClientIp() {
        return clientIp;
    }
    
    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }
    
    public String getClientUa() {
        return clientUa;
    }
    
    public void setClientUa(String clientUa) {
        this.clientUa = clientUa;
    }

    @Override
    public String toString() {
        return "CaptchaVerifyResponse("
                + "error=" + error
                + ", msg=" + msg
                + ", result=" + result
                + ", phone=" + phone
                + ", extraData=" + extraData
                + ", captchaType=" + captchaType
                + ", token=" + token
                + ", sdkReduce=" + sdkReduce
                + ", clientIp=" + clientIp
                + ", clientUa=" + clientUa
                + ")";
    }

    public CaptchaVerifyResponse(int error, String msg, boolean result, String phone, String extraData, int captchaType, String token, String sdkReduce, String clientIp, String clientUa) {
        this.error = error;
        this.msg = msg;
        this.result = result;
        this.phone = phone;
        this.extraData = extraData;
        this.captchaType = captchaType;
        this.token = token;
        this.sdkReduce = sdkReduce;
        this.clientIp = clientIp;
        this.clientUa = clientUa;
    }
}
