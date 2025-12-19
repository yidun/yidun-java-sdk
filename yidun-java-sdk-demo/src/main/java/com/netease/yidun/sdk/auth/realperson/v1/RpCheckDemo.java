/*
 * @(#) RpCheckDemo.java 2023-03-01
 *
 * Copyright 2023 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.auth.realperson.v1;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.auth.constant.PicType;
import com.netease.yidun.sdk.core.http.ProtocolEnum;

/**
 * 实人认证demo
 */
public class RpCheckDemo extends AbstractDemo {

    public static void main(String[] args) {

        // 实例化发起请求的client对象
        RpCheckClient rpCheckClient = new RpCheckClient("secretId", "secretKey");
        // 如需自定义请求器参数，可使用参考如下方式创建ClientProfile，然后创建client
//        ClientProfile profile = createProfile("secretId", "secretKey");
//        RpCheckClient client = new RpCheckClient(profile);
        // 填充请求参数
        RpCheckRequest request = new RpCheckRequest("businessId");
        // 用户真实姓名，以身份证上姓名为准 (必填参数)
        request.setName("张三");
        // 用户身份证号码，号码必须为18位或15位，末尾为x的需要大写为X(必填参数)
        request.setCardNo("342323232325678");
        // 图片类型: URL 或 BASE-64
        request.setPicType(PicType.URL);
        // 用户头像（必填参数）
        request.setAvatar("http://test1.com");
        // 数据标识，可传入用户标识等数据，便于数据查询(非必填)
        request.setDataId("dataId");
        //协议类型http
        request.setProtocol(ProtocolEnum.HTTP);

        RpCheckResponse rpCheckResponse = null;
        try {
            rpCheckResponse = rpCheckClient.check(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (rpCheckResponse != null && rpCheckResponse.getCode() == 200) {
            RpCheckResult result = rpCheckResponse.getResult();
            // result 为校验结果数据
        }
    }
}
