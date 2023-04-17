/*
 * @(#) DeviceQueryDemo.java 2023-03-03
 *
 * Copyright 2023 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.fingerprint;


import com.netease.yidun.sdk.AbstractDemo;

/**
 * 设备指纹查询demo
 */
public class DeviceQueryDemo extends AbstractDemo {

    public static void main(String[] args) {
        // 实例化发起请求的client对象
        DeviceClient deviceClient = new DeviceClient("secretId", "secretKey");
        // 如需自定义请求器参数，可使用参考如下方式创建ClientProfile，然后创建client
//        ClientProfile profile = createProfile("secretId", "secretKey");
//        DeviceClient client = new DeviceClient(profile);
        DeviceQueryRequest deviceQueryRequest = new DeviceQueryRequest("businessId");
        // 上传设备数据时，设备指纹SDK返回的token
        deviceQueryRequest.setToken("token");
        DeviceQueryResponse response = null;
        try {
            response = deviceClient.query(deviceQueryRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (response != null && response.getCode() == 200) {
            DeviceQueryResult data = response.getData();
            // data 为设备指纹和风险项数据，具体字段详细信息可参考官网文档
        }
    }
}
