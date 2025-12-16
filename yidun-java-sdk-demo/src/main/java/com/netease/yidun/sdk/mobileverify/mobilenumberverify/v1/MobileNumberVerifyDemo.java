package com.netease.yidun.sdk.mobileverify.mobilenumberverify.v1;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.core.http.ProtocolEnum;

/**
 * 本机校验接口demo
 */
public class MobileNumberVerifyDemo extends AbstractDemo {

    public static void main(String[] args) {
        // 实例化发起请求的client对象
        MobileNumberVerifyClient client = new MobileNumberVerifyClient("secretId", "secretKey");
        // 如需自定义请求器参数，可使用参考如下方式创建ClientProfile，然后创建client
//        ClientProfile profile = createProfile("secretId", "secretKey");
//        MobileNumberVerifyClient client = new MobileNumberVerifyClient(profile);
        // 填充请求参数
        MobileNumberVerifyRequest request = new MobileNumberVerifyRequest("businessId")
                // 【不可重复使用】易盾token(有效期2分钟)
                .token("ca91e4b9c32f4166a4c7e9b2aa8e8c1a")
                // 【不可重复使用】运营商授权码(有效期2分钟)
                .accessToken("da172264b3964d3c8a8a123a77305e59")
                // 本机手机号
                .phone("18888888888");
        //切换demo内的请求协议为HTTP
        request.setProtocol(ProtocolEnum.HTTP);
        MobileNumberVerifyResponse response = null;
        try {
            response = client.verifyMobileNumber(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (response != null && response.getCode() == 200) {
            MobileNumberVerifyResult data = response.getData();
            int result = data.getResult();
            // result 即为验证结果 1-通过;2-不通过;3-无法确认(结果不为1时建议做二次校验,例如短信验证码检验等)
        }
    }
}
