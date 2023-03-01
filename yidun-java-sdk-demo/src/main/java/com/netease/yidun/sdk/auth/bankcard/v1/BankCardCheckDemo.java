package com.netease.yidun.sdk.auth.bankcard.v1;

import org.apache.commons.codec.binary.Base64;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 银行卡三四要素
 */
public class BankCardCheckDemo {

    public static void main(String[] args) {
        BankCardClient client = new BankCardClient("secretId", "secretKey");
        BankCardCheckRequest request = new BankCardCheckRequest("businessId");
        request.setBankCardNo("123456");
        request.setName("张三");
        request.setIdCardNo("111234120001011236");
        request.setPhone("123456");
        request.setNonce("3e4235a28d4c4129953ff7751abb664e");

        BankCardResponse response = null;
        try {
            response = client.check(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (response != null && response.getCode() == 200) {
            BankCardResult result = response.getResult();
            // data 数据即为所需的check结果
        }
    }

    public static String getImage(InputStream fis) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream(1024);
        byte[] b = new byte[1024];
        int n;
        while ((n = fis.read(b)) != -1) {
            bos.write(b, 0, n);
        }
        fis.close();
        byte[] data = bos.toByteArray();
        bos.close();
        String s = Base64.encodeBase64String(data);
        System.out.println("pic size:" + s.length());
        return s;
    }
}
