package com.netease.yidun.sdk.irisk;

import com.netease.yidun.sdk.irisk.v1.IRiskClient;
import com.netease.yidun.sdk.irisk.v1.mediacheck.IRiskMediaCheckRequest;
import com.netease.yidun.sdk.irisk.v1.mediacheck.IRiskMediaCheckResponse;
import com.netease.yidun.sdk.irisk.v1.mediacheck.IRiskMediaCheckResult;

/**
 * 【智能风控】图片外挂识别接口demo
 */
public class IRiskMediaCheckDemo {

    public static void main(String[] args) {

        // 实例化发起请求的client对象
        IRiskClient iRiskClient = new IRiskClient("SecretId", "SecretKey");
        // 填充请求参数
        IRiskMediaCheckRequest request = new IRiskMediaCheckRequest("businessId");
        // 用户/玩家的角色 ID
        request.setRoleId("xxxx");
        // 用户/玩家的角色名称
        request.setNickname("yyyyy");
        // 图片的文件名,(需要包含文件的后缀)。
        request.setMediaName("xxx.jpg");
        // 请求ip
        request.setIp("192.168.0.1");
        // 图片数据，图片支持类型为BASE64的数据，无需包含base64协议请求头部分
        request.setMediaData("auMW9NLW5rNaa6vXVpq2jTfy1Kemr2UuWyvu9L7662dvL7Oik3cp5J5PJ/dr35/56UrrvP5ML+X/pJ//9k=");
        // 玩家的服务器名称
        request.setServer("比尔吉沃特");
        IRiskMediaCheckResponse mediaCheckResponse = null;
        try {
            mediaCheckResponse = iRiskClient.mediaCheck(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (mediaCheckResponse != null && mediaCheckResponse.getCode() == 200) {
            IRiskMediaCheckResult data = mediaCheckResponse.getData();
            // 得到检测任务 ID，可自行决定是否存储。若存储可用于记录该次数据请求以及数据核查追踪。
            String taskId = data.getTaskId();
        }

    }
}
