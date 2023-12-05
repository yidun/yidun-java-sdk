/*
 * @(#) V600PureRequest.java 2023-12-06
 *
 * Copyright 2023 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.irisk.v6.check.v601;

import java.util.Map;

import com.netease.yidun.sdk.core.response.BaseResponse;
import com.netease.yidun.sdk.irisk.v6.check.v600.IRiskCheckV600PureRequest;

/**
 * @author guantihua
 * @version 2023-12-06
 */
public abstract class IRiskCheckV601PureRequest<T extends BaseResponse> extends IRiskCheckV600PureRequest<T> {
    /**
     * 当前用户身份，有助于对不同身份用户设置分层策略，方便业务进行精细化安全运营。 注意：仅接收以下内容，如传入，系统将会强制校验传入值合法性。 vistor：游客 commonUser：普通用户
     * seniorUser：高级用户（如vip、主播） other：其他身份
     *
     */
    private String identity;

    /**
     * 当前用户是否付费用户，有助于对用户设置分层策略。 注意：仅接收布尔值，如传入，系统将会强制校验传入值合法性。 true：付费用户 false：非付费用户
     */
    private Boolean payUser;

    /**
     * 当前用户是否认证用户（实名/真人认证），有助于对不同安全等级用户设置分层策略。 注意：仅接收布尔值，如传入，系统将会强制校验传入值合法性。 true：认证用户 false：非认证用户
     */
    private Boolean verified;

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> customSignParams = super.getCustomSignParams();
        customSignParams.put("identity", identity);
        if (null != payUser) {
            customSignParams.put("payUser", String.valueOf(payUser));
        }
        if (null != verified) {
            customSignParams.put("verified", String.valueOf(verified));
        }

        return customSignParams;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public Boolean getPayUser() {
        return payUser;
    }

    public void setPayUser(Boolean payUser) {
        this.payUser = payUser;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    @Override
    public String toString() {
        return "IRiskCheckV601PureRequest{" +
                "super=" + super.toString() +
                "identity='" + identity + '\'' +
                ", payUser=" + payUser +
                ", verified=" + verified +
                '}';
    }
}
