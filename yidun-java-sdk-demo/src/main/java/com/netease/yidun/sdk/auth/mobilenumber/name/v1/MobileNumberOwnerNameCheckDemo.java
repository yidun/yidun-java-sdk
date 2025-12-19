package com.netease.yidun.sdk.auth.mobilenumber.name.v1;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.auth.mobilenumber.MobileNumberOwnerCheckClient;
import com.netease.yidun.sdk.core.http.ProtocolEnum;

/**
 * 手机号二要素
 */
public class MobileNumberOwnerNameCheckDemo extends AbstractDemo {

    public static void main(String[] args) {
        MobileNumberOwnerCheckClient client = new MobileNumberOwnerCheckClient("secretId", "secretKey");
        // 如需自定义请求器参数，可使用参考如下方式创建ClientProfile，然后创建client
//        ClientProfile profile = createProfile("secretId", "secretKey");
//        MobileNumberOwnerCheckClient client = new MobileNumberOwnerCheckClient(profile);
        MobileNumberOwnerNameCheckRequest request = new MobileNumberOwnerNameCheckRequest("businessId");
        request.setName("张三");
        request.setPhone("123456");
        request.setNonce("3e4235a28d4c4129953ff7751abb664e");
        //协议类型http
        request.setProtocol(ProtocolEnum.HTTP);

        MobileNumberOwnerNameCheckResponse response = null;
        try {
            response = client.checkMobileNumberOwnerName(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (response != null && response.getCode() == 200) {
            MobileNumberOwnerNameCheckResult result = response.getResult();
            // data 数据即为所需的check结果
        }
    }
}
