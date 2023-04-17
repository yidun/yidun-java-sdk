package com.netease.yidun.sdk.auth.mobilenumber.idname.v1;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.auth.mobilenumber.MobileNumberOwnerCheckClient;
import org.apache.commons.codec.binary.Base64;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 手机号三要素
 */
public class MobileNumberOwnerIdNameCheckDemo extends AbstractDemo {

    public static void main(String[] args) {
        MobileNumberOwnerCheckClient client = new MobileNumberOwnerCheckClient("secretId", "secretKey");
        // 如需自定义请求器参数，可使用参考如下方式创建ClientProfile，然后创建client
//        ClientProfile profile = createProfile("secretId", "secretKey");
//        MobileNumberOwnerCheckClient client = new MobileNumberOwnerCheckClient(profile);
        MobileNumberOwnerIdNameCheckRequest request = new MobileNumberOwnerIdNameCheckRequest("businessId");
        request.setName("张三");
        request.setCardNo("111234120001011236");
        request.setPhone("123456");
        request.setNonce("3e4235a28d4c4129953ff7751abb664e");

        MobileNumberOwnerIdNameCheckResponse response = null;
        try {
            response = client.checkMobileNumberOwnerIdName(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (response != null && response.getCode() == 200) {
            MobileNumberOwnerIdNameCheckResult result = response.getResult();
            // data 数据即为所需的check结果
        }
    }
}
