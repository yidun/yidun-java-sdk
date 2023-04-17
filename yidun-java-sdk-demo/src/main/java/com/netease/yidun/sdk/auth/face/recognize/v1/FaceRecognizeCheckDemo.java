package com.netease.yidun.sdk.auth.face.recognize.v1;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.auth.constant.PicType;
import com.netease.yidun.sdk.auth.face.FaceClient;

/**
 * 人脸检索接口demo
 */
public class FaceRecognizeCheckDemo extends AbstractDemo {

    public static void main(String[] args) {
        // 实例化发起请求的client对象
        FaceClient faceClient = new FaceClient("secretId", "secretKey");
        // 如需自定义请求器参数，可使用参考如下方式创建ClientProfile，然后创建client
//        ClientProfile profile = createProfile("secretId", "secretKey");
//        FaceClient client = new FaceClient(profile);
        FaceRecognizeRequest request = new FaceRecognizeRequest("businessId")
                // 待检索的人脸照片地址
                .avatar("http://test.com")
                .picType(PicType.URL);

        FaceRecognizeResponse response = null;
        try {
            response = faceClient.recognizeFace(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (response != null && response.getCode() == 200) {
            FaceRecognizeResult result = response.getResult();
            // result 为检索结果数据，具体字段详细信息可参考官网文档
        }
    }
}
