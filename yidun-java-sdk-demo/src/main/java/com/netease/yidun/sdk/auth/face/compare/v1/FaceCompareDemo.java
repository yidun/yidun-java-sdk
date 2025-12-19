package com.netease.yidun.sdk.auth.face.compare.v1;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.auth.constant.PicType;
import com.netease.yidun.sdk.auth.face.FaceClient;
import com.netease.yidun.sdk.core.http.ProtocolEnum;

/**
 * 人脸比对接口demo
 */
public class FaceCompareDemo extends AbstractDemo {

    public static void main(String[] args) {
        // 实例化发起请求的client对象
        FaceClient faceClient = new FaceClient("secretId", "secretKey");
        // 如需自定义请求器参数，可使用参考如下方式创建ClientProfile，然后创建client
//        ClientProfile profile = createProfile("secretId", "secretKey");
//        FaceClient client = new FaceClient(profile);
        FaceCompareRequest request = new FaceCompareRequest("businessId")
                // 人脸识照片1链接
                .avatar1("http://test1.com")
                // 人脸识照片2链接
                .avatar2("http://test2.com")
                // 图片类型
                .picType(PicType.URL);
        //协议类型http
        request.setProtocol(ProtocolEnum.HTTP);
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
