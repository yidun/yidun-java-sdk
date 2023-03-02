/*
 * @(#) IdCardDemo.java 2023-03-01
 *
 * Copyright 2023 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.auth.idcard.v1;

/**
 * 实证认证demo
 */
public class IdCardCheckDemo {

    public static void main(String[] args) {

        // 实例化发起请求的client对象
        IdCardClient idCardClient = new IdCardClient("secretId", "secretKey");
        // 填充请求参数
        IdCardCheckRequest request = new IdCardCheckRequest("businessId");
        // 用户真实姓名，以身份证上姓名为准 (必填参数)
        request.setName("zhangsan");
        // 用户身份证号码，号码必须为18位或15位，末尾为x的需要大写为X(必填参数)
        request.setCardNo("3429277988923111111");
        // 数据标识，可传入用户标识等数据，便于数据查询(非必填)
        request.setDataId("dataId");

        IdCardCheckResponse idCardCheckResponse = null;
        try {
            idCardCheckResponse = idCardClient.check(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (idCardCheckResponse != null && idCardCheckResponse.getCode() == 200) {
            IdCardCheckResult result = idCardCheckResponse.getResult();
            // result 为校验结果数据
        }

    }
}
