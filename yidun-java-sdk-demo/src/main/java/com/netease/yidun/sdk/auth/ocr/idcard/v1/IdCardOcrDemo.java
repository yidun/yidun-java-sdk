package com.netease.yidun.sdk.auth.ocr.idcard.v1;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.auth.constant.PicType;
import com.netease.yidun.sdk.auth.ocr.OcrClient;
import com.netease.yidun.sdk.core.http.ProtocolEnum;

/**
 * 身份证OCR
 */
public class IdCardOcrDemo extends AbstractDemo {
    public static void main(String[] args) {
        OcrClient ocrClient = new OcrClient("secretId", "secretKey");
        // 如需自定义请求器参数，可使用参考如下方式创建ClientProfile，然后创建client
//        ClientProfile profile = createProfile("secretId", "secretKey");
//        OcrClient client = new OcrClient(profile);
        IdCardOcrRequest request = new IdCardOcrRequest("businessId");
        request.setPicType(PicType.URL);
        request.setFrontPicture("http://test1.com");
        request.setBackPicture("http://test2.com");
        request.setDataId("123456");
        request.setNonce("3e4235a28d4c4129953ff7751abb664e");
        //协议类型http
        request.setProtocol(ProtocolEnum.HTTP);

        IdCardOcrResponse ocrResponse = null;
        try {
            ocrResponse = ocrClient.checkIdCard(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (ocrResponse != null && ocrResponse.getCode() == 200) {
            IdCardOcrResult result = ocrResponse.getResult();
            // data 数据即为所需的check结果
        }
    }
}
