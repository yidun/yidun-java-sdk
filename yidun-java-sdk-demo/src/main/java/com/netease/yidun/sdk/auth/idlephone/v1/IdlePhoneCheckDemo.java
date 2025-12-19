package com.netease.yidun.sdk.auth.idlephone.v1;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.core.http.ProtocolEnum;

/**
 * 号码状态检测接口demo
 */
public class IdlePhoneCheckDemo extends AbstractDemo {

    public static void main(String[] args) {
        // 实例化发起请求的client对象
        IdlePhoneClient idlePhoneClient = new IdlePhoneClient("secretId", "secretKey");
        // 如需自定义请求器参数，可使用参考如下方式创建ClientProfile，然后创建client
//        ClientProfile profile = createProfile("secretId", "secretKey");
//        IdlePhoneClient client = new IdlePhoneClient(profile);
        IdlePhoneCheckRequest checkRequest = new IdlePhoneCheckRequest("businessId");
        // 检测手机号
        checkRequest.setPhoneList("phoneList");
        checkRequest.setEncryptType("type");
        //协议类型http
        checkRequest.setProtocol(ProtocolEnum.HTTP);
        IdlePhoneCheckResponse checkResponse = null;
        try {
            checkResponse = idlePhoneClient.check(checkRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (checkResponse != null && checkResponse.getCode() == 200) {
            IdlePhoneCheckResult result = checkResponse.getResult();
            // result 手机号的检测状态，具体字段详细信息可参考官网文档
        }
    }
}
