package com.netease.yidun.sdk.irisk.v1;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.irisk.v1.antigold.IRiskAntiGoldCheckRequest;
import com.netease.yidun.sdk.irisk.v1.antigold.IRiskAntiGoldCheckResponse;

/**
 * @author dongyisheng@corp.netease.com
 * @version 2023/11/7 10:12
 */
public class IRiskAntiGoldCheckDemo extends AbstractDemo {

    public static void main(String[] args) {
        // 实例化发起请求的client对象
        IRiskClient iRiskClient = IRiskClient.getInstance("SecretId", "SecretKey");
        // 如需自定义请求器参数，可使用参考如下方式创建ClientProfile，然后创建client
        // ClientProfile profile = createProfile("secretId", "secretKey");
        // IRiskClient client = new IRiskClient(profile);
        // 填充请求参数
        IRiskAntiGoldCheckRequest request = new IRiskAntiGoldCheckRequest("businessId");
        // 实际记录日志的时间，采用RFC 3339时间格式，例如，"2023-09-08T16:00:43+08:00"（UTC+8）。
        request.setLogTime("2023-09-08T16:00:43+08:00");
        // 用户角色ID，适用于支持同一个账号下创建不同角色的业务（如游戏不同区服的角色）。
        request.setRoleId("roleId");
        // 用户账号标识，建议使用业务方用户的UID，标记用户的唯一身份。
        request.setAccount("account");
        // 用户角色的昵称。
        request.setNickname("nickname");
        // 日志类型，见官网文档
        request.setLogType("logType");
        // 当前游戏角色所在游戏区服的ID（所属服务器ID)
        request.setServerId("serverId");
        // 日志数据，json格式
        request.setLogData("jsonString");
        IRiskAntiGoldCheckResponse antiGoldCheckResponse = null;
        try {
            antiGoldCheckResponse = iRiskClient.antiGoldCheck(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (antiGoldCheckResponse != null && antiGoldCheckResponse.getCode() == 200) {
            // 上报成功
        }
    }
}
