package com.netease.yidun.sdk.auth.ocr.bankcard.v1;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.auth.ocr.OcrClient;
import org.apache.commons.codec.binary.Base64;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 银行卡OCR
 */
public class BankCardOcrDemo extends AbstractDemo {

    private static String image;

    static {
        try {
            image = getImage(BankCardOcrDemo.class.getResourceAsStream("/bankcard.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        OcrClient ocrClient = new OcrClient("secretId", "secretKey");
        // 如需自定义请求器参数，可使用参考如下方式创建ClientProfile，然后创建client
//        ClientProfile profile = createProfile("secretId", "secretKey");
//        OcrClient client = new OcrClient(profile);
        BankCardOcrRequest request = new BankCardOcrRequest("businessId");
        request.setImage(image);
        request.setDetectDirection("http://test1.com");
        request.setNonce("3e4235a28d4c4129953ff7751abb664e");

        BankCardOcrResponse ocrResponse = null;
        try {
            ocrResponse = ocrClient.checkBankCard(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (ocrResponse != null && ocrResponse.getCode() == 200) {
            BankCardOcrResult result = ocrResponse.getResult();
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
