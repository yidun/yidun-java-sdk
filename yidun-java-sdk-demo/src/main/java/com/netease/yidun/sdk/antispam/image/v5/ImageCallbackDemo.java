package com.netease.yidun.sdk.antispam.image.v5;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.image.v5.callback.request.ImageV5CallbackRequest;
import com.netease.yidun.sdk.antispam.image.v5.check.sync.response.ImageV5CheckResponse;
import com.netease.yidun.sdk.antispam.image.v5.check.sync.response.ImageV5Result;

/**
 * 获取图片检测结果demo
 */
public class ImageCallbackDemo extends AbstractDemo {

    public static void main(String[] args) {

        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        ImageClient imageClient = ImageClient.getInstance(antispamRequester);
        // 实例化请求对象
        ImageV5CallbackRequest callbackRequest = new ImageV5CallbackRequest();
        // 设置易盾内容安全分配的businessId
        callbackRequest.setBusinessId("BusinessId");

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
            }
        }

    }
}
