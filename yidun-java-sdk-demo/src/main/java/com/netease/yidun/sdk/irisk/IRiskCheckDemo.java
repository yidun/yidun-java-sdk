package com.netease.yidun.sdk.irisk;

import com.netease.yidun.sdk.irisk.v1.IRiskClient;
import com.netease.yidun.sdk.irisk.v1.check.IRiskCheckRequest;
import com.netease.yidun.sdk.irisk.v1.check.IRiskCheckResponse;
import com.netease.yidun.sdk.irisk.v1.check.IRiskCheckResult;

/**
 * 【智能风控】在线检测接口demo
 */
public class IRiskCheckDemo {

    public static void main(String[] args) {

        // 实例化发起请求的client对象
        IRiskClient iRiskClient = new IRiskClient("SecretId", "SecretKey");
        // 填充请求参数
        IRiskCheckRequest request = new IRiskCheckRequest("businessId");

        // 风控SDK上报的数据后回参获取到的 token (必填参数)
        request.setToken("testToken");
        // ip地址 (必填参数)
        request.setIp("192.168.0.1");
        request.setRoleId("用户A");
        request.setNickname("角色昵称");
        request.setServer("服务器名称");
        request.setAccount("账号");
        request.setPhone("手机号");
        request.setActivityId("活动ID");
        request.setTarget("用户B");
        request.setEmail("邮箱地址");
        // 用户的注册时间，注意这里单位是毫秒。
        request.setRegisterTime(1677135118000L);
        request.setRegisterIp("用户注册的Ip");
        request.setLevel("129");
        request.setGameVersion("1.0.0");
        request.setAssetVersion("1.0.0");
        request.setExtData("额外信息的json字符串");

        IRiskCheckResponse checkResponse = null;
        try {
            checkResponse = iRiskClient.check(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (checkResponse != null && checkResponse.getCode() == 200) {
            IRiskCheckResult data = checkResponse.getData();
            // data 数据即为所需的check结果
        }
    }
}
