/*
 * @(#) EntryExitPermitCheckDemo.java 2023-03-01
 *
 * Copyright 2023 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.auth.entryexitpermit.v1;

/**
 * 出入境信息核验demo
 */
public class EntryExitPermitCheckDemo {

    public static void main(String[] args) {

        // 实例化发起请求的client对象
        EntryExitPermitClient entryExitPermitClient = new EntryExitPermitClient("secretId", "secretKey");
        // 填充请求参数
        EntryExitPermitCheckRequest request = new EntryExitPermitCheckRequest("businessId");
        // 用户真实姓名，以身份证上姓名为准 (必填参数)
        request.setName("张三");
        // 用户身份证号码，号码必须为18位或15位，末尾为x的需要大写为X(必填参数)
        request.setCardNo("M35662009");
        // 证件类型(必填参数)
        request.setVerifyType(1);
        // 国家或地区三位大写英文字母缩写(必填参数)
        request.setNation("CHN");
        // 数据标识，可传入用户标识等数据，便于数据查询(非必填)
        request.setDataId("dataId");

        EntryExitPermitCheckResponse response = null;
        try {
            response = entryExitPermitClient.check(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (response != null && response.getCode() == 200) {
            EntryExitPermitCheckResult result = response.getResult();
            // result 为校验结果数据
        }
    }
}
