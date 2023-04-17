package com.netease.yidun.sdk.auth.face.recognize.register.v1;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.auth.constant.PicType;
import com.netease.yidun.sdk.auth.face.FaceClient;

/**
 * 人脸注册接口demo
 */
public class FaceRegisterDemo extends AbstractDemo {

    public static void main(String[] args) {
        // 实例化发起请求的client对象
        FaceClient faceClient = new FaceClient("secretId", "secretKey");
        // 如需自定义请求器参数，可使用参考如下方式创建ClientProfile，然后创建client
//        ClientProfile profile = createProfile("secretId", "secretKey");
//        FaceClient client = new FaceClient(profile);
        FaceRegisterRequest request = new FaceRegisterRequest("businessId")
                // 头像照片地址，URL不可超过1024，BASE64不可超过10M
                .avatar("http://test.com")
                // 人员id，不同人员不可重复
                .faceId("123000")
                // 用户真实姓名，以身份证上姓名为准
                .name("张三")
                .picType(PicType.URL);

        FaceRegisterResponse response = null;
        try {
            response = faceClient.registerFace(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (response != null && response.getCode() == 200) {
            FaceRegisterResult result = response.getResult();
            // result 为注册结果数据，具体字段详细信息可参考官网文档
        }
    }
}
