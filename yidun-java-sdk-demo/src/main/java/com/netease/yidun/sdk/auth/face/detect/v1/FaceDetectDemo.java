package com.netease.yidun.sdk.auth.face.detect.v1;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.auth.constant.PicType;
import com.netease.yidun.sdk.auth.face.FaceClient;
import com.netease.yidun.sdk.core.http.ProtocolEnum;

/**
 * 人脸检测接口demo
 */
public class FaceDetectDemo extends AbstractDemo {

    public static void main(String[] args) {
        // 实例化发起请求的client对象
        FaceClient faceClient = new FaceClient("secretId", "secretKey");
        // 如需自定义请求器参数，可使用参考如下方式创建ClientProfile，然后创建client
//        ClientProfile profile = createProfile("secretId", "secretKey");
//        FaceClient client = new FaceClient(profile);
        FaceDetectRequest request = new FaceDetectRequest("businessId")
                // 待检测图片地址
                .picImage("http://test.com")
                .picType(PicType.URL);
        //协议类型http
        request.setProtocol(ProtocolEnum.HTTP);

        FaceDetectResponse response = null;
        try {
            response = faceClient.detectFace(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (response != null && response.getCode() == 200) {
            FaceDetectResult result = response.getResult();
            // result 为检测结果数据，具体字段详细信息可参考官网文档
        }
    }
}
