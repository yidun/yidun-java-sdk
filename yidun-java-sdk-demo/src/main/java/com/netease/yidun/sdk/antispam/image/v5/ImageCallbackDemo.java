package com.netease.yidun.sdk.antispam.image.v5;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.image.v5.callback.request.ImageV5CallbackRequest;
import com.netease.yidun.sdk.antispam.image.v5.check.sync.response.CensorExtension;
import com.netease.yidun.sdk.antispam.image.v5.check.sync.response.ImageV5AntispamResp;
import com.netease.yidun.sdk.antispam.image.v5.check.sync.response.ImageV5CheckResponse;
import com.netease.yidun.sdk.antispam.image.v5.check.sync.response.ImageV5Result;
import com.netease.yidun.sdk.core.http.ProtocolEnum;

/**
 * 获取图片检测结果demo
 */
public class ImageCallbackDemo extends AbstractDemo {

    public static void main(String[] args) {

        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("49a4d443b92237beafba08b0f21d116f", "801e008c1364c54217e21da7a6222239");

        // 实例化发起请求的client对象
        ImageClient imageClient = ImageClient.getInstance(antispamRequester);
        // 实例化请求对象
        ImageV5CallbackRequest callbackRequest = new ImageV5CallbackRequest();
        callbackRequest.setProtocol(ProtocolEnum.HTTP);
        callbackRequest.setDomain("as.test.dun.163.com");
        // 设置易盾内容安全分配的businessId
        callbackRequest.setBusinessId("4a568cc95ae0258183541d4d6b4e4ac1");

        ImageV5CheckResponse checkResponse = null;
        try {
            // 发起获取回调的请求
            checkResponse = imageClient.callback(callbackRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (checkResponse != null && checkResponse.getCode() == 200) {
            for (ImageV5Result imageV5Result : checkResponse.getResult()) {
                // 根据需要获取每张图片的检测结果，具体返回字段的说明，请参考官方接口文档中字段说明
                ImageV5AntispamResp antispam = imageV5Result.getAntispam();
                if (antispam != null) {
                    System.out.println("taskId: " + antispam.getTaskId());
                    System.out.println("suggestion: " + antispam.getSuggestion());

                    // 获取审核扩展信息
                    CensorExtension censorExtension = antispam.getCensorExtension();
                    if (censorExtension != null) {
                        System.out.println("质检任务ID: " + censorExtension.getQualityInspectionTaskId());
                        System.out.println("质检任务创建时间: " + censorExtension.getInspTaskCreateTime());
                    }
                }
            }
        }

    }
}
