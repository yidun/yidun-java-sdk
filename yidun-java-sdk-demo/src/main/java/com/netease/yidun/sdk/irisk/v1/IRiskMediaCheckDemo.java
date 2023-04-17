package com.netease.yidun.sdk.irisk.v1;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.irisk.v1.mediacheck.IRiskMediaCheckRequest;
import com.netease.yidun.sdk.irisk.v1.mediacheck.IRiskMediaCheckResponse;
import com.netease.yidun.sdk.irisk.v1.mediacheck.IRiskMediaCheckResult;

/**
 * 【智能风控】图片外挂识别接口demo
 */
public class IRiskMediaCheckDemo extends AbstractDemo {

    public static void main(String[] args) {

        // 实例化发起请求的client对象
        IRiskClient iRiskClient = new IRiskClient("SecretId", "SecretKey");
        // 如需自定义请求器参数，可使用参考如下方式创建ClientProfile，然后创建client
//        ClientProfile profile = createProfile("secretId", "secretKey");
//        IRiskClient client = new IRiskClient(profile);
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
        request.setMediaData("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");
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
