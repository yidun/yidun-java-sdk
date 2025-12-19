package com.netease.yidun.sdk.auth.ocr.businesslicense.v1;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.auth.ocr.OcrClient;
import com.netease.yidun.sdk.core.http.ProtocolEnum;

/**
 * 营业执照OCR接口demo
 */
public class BusinessLicenseOcrDemo extends AbstractDemo {

    public static void main(String[] args) {
        // 实例化发起请求的client对象
        OcrClient ocrClient = new OcrClient("secretId", "secretKey");
        // 如需自定义请求器参数，可使用参考如下方式创建ClientProfile，然后创建client
//        ClientProfile profile = createProfile("secretId", "secretKey");
//        OcrClient client = new OcrClient(profile);
        // 填充请求参数
        BusinessLicenseOcrRequest request = new BusinessLicenseOcrRequest("businessId")
                // 默认BASE64格式，要求BASE64编码后大小不超过4M，最短边至少15px，最长边最大4096px,支持jpg/jpeg/png/bmp格式.
                // 注：图片的BASE64编码是不包含图片头的，如（data:image/jpg;BASE64）
                .image("图片的base64数据")
                // (非必填) 精确度：normal,high 参数选normal或为空使用快速服务；选择high使用高精度服务，但是时延会根据具体图片有相应的增加
                .accuracy("normal")
                // (非必填) 是否检测图像朝向：可选值true - 检测朝向；false - 不检测朝向。朝向是指输入图像是正常方向、逆时针旋转90/180/270度
                .detectDirection("false");
        //协议类型http
        request.setProtocol(ProtocolEnum.HTTP);
        BusinessLicenseOcrResponse response = null;
        try {
            response = ocrClient.checkBusinessLicense(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (response != null && response.getCode() == 200) {
            BusinessLicenseOcrResult result = response.getResult();
            // result 即为ocr检测结果
        }
    }

}
