package com.netease.yidun.sdk.auth.face.compare.v1;

import com.netease.yidun.sdk.auth.constant.PicType;
import com.netease.yidun.sdk.auth.face.FaceClient;

/**
 * 人脸比对接口demo
 */
public class FaceCompareDemo {

    public static void main(String[] args) {
        // 实例化发起请求的client对象
        FaceClient faceClient = new FaceClient("secretId", "secretKey");
        FaceCompareRequest request = new FaceCompareRequest("businessId")
                // 人脸识照片1链接
                .avatar1("http://test1.com")
                // 人脸识照片2链接
                .avatar2("http://test2.com")
                // 图片类型
                .picType(PicType.URL);
        FaceCompareResponse response = null;

        try {
            response = faceClient.compareFace(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (response != null && response.getCode() == 200) {
            FaceCompareResult result = response.getResult();
            // result 为比对结果数据，具体字段详细信息可参考官网文档
        }
    }
}
