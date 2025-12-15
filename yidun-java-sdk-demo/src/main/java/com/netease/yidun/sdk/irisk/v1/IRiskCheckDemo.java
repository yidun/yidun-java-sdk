package com.netease.yidun.sdk.irisk.v1;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.core.http.ProtocolEnum;
import com.netease.yidun.sdk.irisk.v1.check.IRiskCheckRequest;
import com.netease.yidun.sdk.irisk.v1.check.IRiskCheckResponse;
import com.netease.yidun.sdk.irisk.v1.check.IRiskCheckResult;

/**
 * 【智能风控】在线检测接口demo
 */
public class IRiskCheckDemo extends AbstractDemo {

    public static void main(String[] args) {

        // 实例化发起请求的client对象
        IRiskClient iRiskClient = IRiskClient.getInstance("SecretId", "SecretKey");
        // 如需自定义请求器参数，可使用参考如下方式创建ClientProfile，然后创建client
//        ClientProfile profile = createProfile("secretId", "secretKey");
//        IRiskClient client = new IRiskClient(profile);
        // 填充请求参数
        IRiskCheckRequest request = new IRiskCheckRequest("businessId");
        // 协议类型，HTTP/HTTPS
        request.setProtocol(ProtocolEnum.HTTP);
        // 风控SDK上报的数据后回参获取到的 token (必填参数)
        request.setToken("9Qq5O9Q1tpNFAhAAEULVbNYvMC/8Mz8X");
        // ip地址 (必填参数)
        request.setIp("131.131.131.131");
        request.setRoleId("QA5roleId");
        request.setNickname("QA5roleName");
        request.setServer("QA5roleServer");
        request.setAccount("QA5account");
        request.setPhone("18633221111");
        request.setActivityId("QAactivityId");
        request.setTarget("QAtarget");
        request.setEmail("QAtte@163.com");
        // 用户的注册时间，注意这里单位是毫秒。
        request.setRegisterTime(1677575659516L);
        request.setRegisterIp("10.20.30.50");
        request.setLevel("150");
        request.setGameVersion("5.0.2");
        request.setAssetVersion("5.2.1");
        request.setExtData("{\"Testjson\":\"QATestv5\"}");

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
