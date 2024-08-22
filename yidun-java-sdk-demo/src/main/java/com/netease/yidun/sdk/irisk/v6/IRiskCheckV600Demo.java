/*
 * @(#) IRiskCheckV600Demo.java 2023-12-05
 *
 * Copyright 2023 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.irisk.v6;

import com.netease.yidun.sdk.core.response.DataResponse;
import com.netease.yidun.sdk.irisk.v6.check.v600.hitinfo.HitInfo;
import com.netease.yidun.sdk.irisk.v6.check.v600.IRiskCheckV600Request;
import com.netease.yidun.sdk.irisk.v6.check.v600.IRiskCheckV600Result;

/**
 * @author guantihua
 * @version 2023-12-05
 */
public class IRiskCheckV600Demo {

    public static void main(String[] args) {

        // 实例化发起请求的client对象
        IRiskV6Client iRiskClient = new IRiskV6Client("SecretId", "SecretKey");

        // 填充请求参数
        IRiskCheckV600Request request = new IRiskCheckV600Request("businessId");
        request.setTimestamp(System.currentTimeMillis());
        request.setNonce("fadsfasdfadsfasdfadsfasdfadsfasd");

        request.setToken("nRoN3S/jk1tFJlQAQUaAgCFM8e3ETfKa");

        request.setIp("192.168.1.1");
        request.setRoleId("001");
        request.setAccount("001");
        request.setNickname("");
        request.setServer("");
        request.setLevel("");
        request.setGameVersion("");
        request.setAssetVersion("");
        request.setPhone("");
        request.setActivityId("");
        request.setTarget("");
        request.setEmail("");
        request.setRegisterTime(System.currentTimeMillis());
        request.setRegisterIp("");
        request.setDeviceId("");
        request.setExtData("");
        request.setClientCode(1);
        // 不同场景接入需要提供的场景数据字段如请参照官网文档。
        // 注意：如接入场景未在已罗列支持的场景范围之内，sceneData内容可传入空串
        // 此处示例为注册场景的场景数据
        request.setSceneData(
                "{\"clickId\":\"\",\"gender\":\"male\",\"hashPassword\":\"\",\"inviter\":\"\",\"registerChannel\":\"qq\",\"registerType\":\"userPassword\",\"sceneType\":\"\"}");

        DataResponse<IRiskCheckV600Result<HitInfo>> checkResponse = null;
        try {
            checkResponse = iRiskClient.check(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (checkResponse != null && checkResponse.getCode() == 200) {
            IRiskCheckV600Result<HitInfo> data = checkResponse.getData();
            // data 数据即为所需的check结果
        }
    }

}
