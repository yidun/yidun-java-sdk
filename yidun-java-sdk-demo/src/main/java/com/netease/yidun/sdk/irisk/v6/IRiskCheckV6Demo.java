package com.netease.yidun.sdk.irisk.v6;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.irisk.v6.check.IRiskCheckV6Request;
import com.netease.yidun.sdk.irisk.v6.check.IRiskCheckV6Response;
import com.netease.yidun.sdk.irisk.v6.check.IRiskCheckV6Result;

/**
 * 【智能风控】在线检测接口V6Demo
 */
public class IRiskCheckV6Demo extends AbstractDemo {

    public static void main(String[] args) {

        // 实例化发起请求的client对象
        IRiskV6Client iRiskClient = new IRiskV6Client("SecretId", "SecretKey");
        // 如需自定义请求器参数，可使用参考如下方式创建ClientProfile，然后创建client
//        ClientProfile profile = createProfile("secretId", "secretKey");
//        IRiskClient client = new IRiskClient(profile);
        // 填充请求参数
        IRiskCheckV6Request request = new IRiskCheckV6Request("businessId");
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

        // 不同场景接入需要提供的场景数据字段如请参照官网文档。
        // 注意：如接入场景未在已罗列支持的场景范围之内，sceneData内容可传入空串
        // 此处示例为注册场景的场景数据
        request.setSceneData("{\"clickId\":\"\",\"gender\":\"male\",\"hashPassword\":\"\",\"inviter\":\"\",\"registerChannel\":\"qq\",\"registerType\":\"userPassword\",\"sceneType\":\"\"}");

        IRiskCheckV6Response checkResponse = null;
        try {
            checkResponse = iRiskClient.check(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (checkResponse != null && checkResponse.getCode() == 200) {
            IRiskCheckV6Result data = checkResponse.getData();
            // data 数据即为所需的check结果
        }
    }
}
