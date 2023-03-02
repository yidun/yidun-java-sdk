package com.netease.yidun.sdk.auth.face.detect.v1;

import com.netease.yidun.sdk.auth.constant.PicType;
import com.netease.yidun.sdk.auth.face.FaceClient;

/**
 * 人脸检测接口demo
 */
public class FaceDetectDemo {

    public static void main(String[] args) {
        // 实例化发起请求的client对象
        FaceClient faceClient = new FaceClient("secretId", "secretKey");
        FaceDetectRequest request = new FaceDetectRequest("businessId")
                // 待检测图片地址
                .picImage("http://test.com")
                .picType(PicType.URL);

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
