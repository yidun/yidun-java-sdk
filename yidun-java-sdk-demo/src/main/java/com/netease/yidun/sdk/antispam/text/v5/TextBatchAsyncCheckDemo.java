package com.netease.yidun.sdk.antispam.text.v5;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.text.TextClient;
import com.netease.yidun.sdk.antispam.text.v5.check.async.batch.TextAsyncBatchCheckRequest;
import com.netease.yidun.sdk.antispam.text.v5.check.async.batch.TextAsyncBatchCheckResponse;
import com.netease.yidun.sdk.antispam.text.v5.check.async.single.TextAsyncCheckResult;
import com.netease.yidun.sdk.antispam.text.v5.check.sync.single.TextCheckSceneRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * 文本批量异步检测demo
 */
public class TextBatchAsyncCheckDemo extends AbstractDemo {

    public static void main(String[] args) {

        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        TextClient textClient = TextClient.getInstance(antispamRequester);

        // 文本异步检测结果建议通过轮询回调或者主动回调（2选1）的方式来获取最新的检测结果，并根据业务场景自行处理
        // 轮询回调初始化如下，如果需要启用轮询回调，请参考如下注释内容：
//        CallbackProfile callbackProfile = new CallbackProfile("BusinessId");
//        // 调整轮询回调的最大线程数，不设置则默认值为3
//        callbackProfile.setConcurrency(2);
//        TextCallback textCallback = new TextCallback(callbackProfile) {
//            @Override
//            public void handle(List<TextCheckResult> callbackData) {
//                // 处理轮询回调的结果，需保证幂等性
//                // 注意需保证这里是不抛出异常的，建议做好try catch处理，否则会一直获取当前处理失败的回调数据
//            }
//        };
// // 为了保证服务进程关闭时，回调数据能够被有效处理，不会因为进程关闭而丢失，建议在进程关闭的hook（例如：spring中的@PreDestroy）中调用 textCallback.close()
//        TextClient textClient = TextClient.getInstance(antispamRequester, textCallback);

        // 实例化请求对象
        TextAsyncBatchCheckRequest checkRequest = new TextAsyncBatchCheckRequest();
        // 设置易盾内容安全分配的businessId
        checkRequest.setBusinessId("BusinessId");

        // 根据需要设置请求的检测节点，默认杭州，现阶段只支持检测接口
        checkRequest.setRegionCode("cn-hangzhou");

        // 设置检测内容
        checkRequest.setTexts(createTexts());

        // 请求对象中的其他参数如果有需要，请参考官方接口文档中字段说明，按需添加

        TextAsyncBatchCheckResponse checkResponse = null;
        try {
            // 发起批量异步检测的请求
            checkResponse = textClient.asyncBatchCheckText(checkRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (checkResponse != null && checkResponse.getCode() == 200) {
            if (checkResponse.getResult() != null && checkResponse.getResult().getCheckTexts() != null) {
                for (TextAsyncCheckResult.CheckText textResult : checkResponse.getResult().getCheckTexts()) {
                    // 根据需要获取每个文本的检测结果，具体返回字段的说明，请参考官方接口文档中字段说明
                }
            }
        }

    }

    /**
     * 创建批量文本数据
     */
    private static List<TextCheckSceneRequest> createTexts() {
        int contentCount = 5;
        List<TextCheckSceneRequest> textObj = new ArrayList<>(contentCount);
        TextCheckSceneRequest request = null;
        for (int i = 0; i < contentCount; i++) {
            request = new TextCheckSceneRequest();
            request.setDataId("数据唯一标识");
            request.setContent("待检测内容");
            // 请求对象中的其他参数如果有需要，请参考官方接口文档中字段说明，按需添加
            textObj.add(request);
        }
        return textObj;
    }
}
