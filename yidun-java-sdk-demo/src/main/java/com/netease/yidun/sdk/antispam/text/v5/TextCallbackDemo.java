package com.netease.yidun.sdk.antispam.text.v5;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.text.TextClient;
import com.netease.yidun.sdk.antispam.text.v5.callback.request.TextCallBackRequest;
import com.netease.yidun.sdk.antispam.text.v5.callback.response.TextCallBackResponse;
import com.netease.yidun.sdk.antispam.text.v5.check.sync.single.TextCheckResult;
import com.netease.yidun.sdk.core.http.ProtocolEnum;

/**
 * 获取文本检测结果demo
 */
public class TextCallbackDemo extends AbstractDemo {

    public static void main(String[] args) {

        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        TextClient textClient = TextClient.getInstance(antispamRequester);
        // 实例化请求对象
        TextCallBackRequest callbackRequest = new TextCallBackRequest();
        callbackRequest.setProtocol(ProtocolEnum.HTTP);
        // 设置易盾内容安全分配的businessId
        callbackRequest.setBusinessId("BusinessId");

        TextCallBackResponse callbackResponse = null;
        try {
            // 发起获取回调的请求
            callbackResponse = textClient.callback(callbackRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (callbackResponse != null && callbackResponse.getCode() == 200) {
            for (TextCheckResult textResult : callbackResponse.getResult()) {
                // 根据需要获取每个文本的检测结果，具体返回字段的说明，请参考官方接口文档中字段说明
            }
        }

    }
}
