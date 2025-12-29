package com.netease.yidun.sdk.antispam.text.v1;

import com.google.gson.Gson;
import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.text.TextClient;
import com.netease.yidun.sdk.antispam.text.v1.similar.SimilarTextSubmitRequest;
import com.netease.yidun.sdk.antispam.text.v1.similar.SimilarTextSubmitResponse;
import com.netease.yidun.sdk.core.http.ProtocolEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 相似文本提交demo
 */
public class SimilarTextSubmitDemo extends AbstractDemo {

    public static void main(String[] args) {

        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        TextClient textClient = TextClient.getInstance(antispamRequester);
        // 实例化请求对象
        SimilarTextSubmitRequest submitRequest = new SimilarTextSubmitRequest();
        submitRequest.setProtocol(ProtocolEnum.HTTP);
        // 设置易盾内容安全分配的businessId
        submitRequest.setBusinessId("BusinessId");
        submitRequest.setSimilarText(createSimilarTexts());

        // 请求对象中的其他参数如果有需要，请参考官方接口文档中字段说明，按需添加

        SimilarTextSubmitResponse submitResponse = null;
        try {
            // 发起相似文本提交的请求
            submitResponse = textClient.submitSimilarText(submitRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (submitResponse != null && submitResponse.getCode() == 200) {
            for (SimilarTextSubmitResponse.SimilarTextSubmitResult submitResult : submitResponse.getResult()) {
                // 根据需要获取每个相似文本的提交结果，具体返回字段的说明，请参考官方接口文档中字段说明
                System.out.println("提交的数据ID: " + submitResult.getDataId());
            }
        } else {
            System.out.println("相似文本提交失败，错误码：" + (submitResponse != null ? submitResponse.getCode() : "null"));
        }
    }

    /**
     * 创建相似文本数据
     */
    private static String createSimilarTexts() {
        List<Map<String, Object>> similarTextList = new ArrayList<>();
        Map<String, Object> similarTextMap = new HashMap<>();
        similarTextMap.put("dataId", UUID.randomUUID().toString());
        similarTextMap.put("content", "这是一条测试相似文本");
        // 请求对象中的其他参数如果有需要，请参考官方接口文档中字段说明，按需添加
        similarTextList.add(similarTextMap);

        return new Gson().toJson(similarTextList);
    }
}