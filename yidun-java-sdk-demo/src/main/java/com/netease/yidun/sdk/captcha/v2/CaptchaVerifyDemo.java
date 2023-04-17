/*
 * @(#) CaptchaVerifyDemo.java 2023-03-01
 *
 * Copyright 2023 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.captcha.v2;

import com.netease.yidun.sdk.AbstractDemo;

/**
 * 验证码二次校验demo
 */
public class CaptchaVerifyDemo extends AbstractDemo {

    public static void main(String[] args) {

        // 实例化发起请求的client对象
        CaptchaClient captchaClient = new CaptchaClient("secretId", "secretKey");
        // 如需自定义请求器参数，可使用参考如下方式创建ClientProfile，然后创建client
//        ClientProfile profile = createProfile("secretId", "secretKey");
//        CaptchaClient client = new CaptchaClient(profile);
        // 填充请求参数
        CaptchaVerifyRequest request = new CaptchaVerifyRequest();
        // 验证码id (必填参数)
        request.setCaptchaId("captchaId");
        // 提交二次校验的验证数据，即NECaptchaValidate值(必填参数)
        request.setValidate("validate");
        // 用户信息(必填参数, 值可为空)
        request.setUser("用户A");

        CaptchaVerifyResponse verifyResponse = null;
        try {
            verifyResponse = captchaClient.verify(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (verifyResponse != null && verifyResponse.isResult()) {
            // 校验通过
        } else {
            // 校验不通过
        }
    }
}
