package com.netease.yidun.sdk.auth.mobilenumber.name.v1;

import com.netease.yidun.sdk.auth.mobilenumber.MobileNumberOwnerCheckClient;
import org.apache.commons.codec.binary.Base64;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 手机号二要素
 */
public class MobileNumberOwnerNameCheckDemo {

    public static void main(String[] args) {
        MobileNumberOwnerCheckClient client = new MobileNumberOwnerCheckClient("secretId", "secretKey");
        MobileNumberOwnerNameCheckRequest request = new MobileNumberOwnerNameCheckRequest("businessId");
        request.setName("张三");
        request.setPhone("123456");
        request.setNonce("3e4235a28d4c4129953ff7751abb664e");

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
