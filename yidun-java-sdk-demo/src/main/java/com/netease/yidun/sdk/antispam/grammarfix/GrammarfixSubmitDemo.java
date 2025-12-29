package com.netease.yidun.sdk.antispam.grammarfix;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.grammarfix.v1.submit.GrammarfixSubmitRequest;
import com.netease.yidun.sdk.antispam.grammarfix.v1.submit.GrammarfixSubmitResponse;
import com.netease.yidun.sdk.core.http.ProtocolEnum;

/**
 * 文本纠错检测demo
 */
public class GrammarfixSubmitDemo extends AbstractDemo {

    public static void main(String[] args) {

        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        GrammarfixClient grammarfixClient = GrammarfixClient.getInstance(antispamRequester);

        // 实例化请求对象
        GrammarfixSubmitRequest submitRequest = new GrammarfixSubmitRequest();
        submitRequest.setProtocol(ProtocolEnum.HTTP);
        // 设置易盾内容安全分配的businessId
        submitRequest.setBusinessId("BusinessId");

        // 设置纠错检测内容
        submitRequest.setDataId("数据唯一标识");
        submitRequest.setContent("待纠错内容");

        // 请求对象中的其他参数如果有需要，请参考官方接口文档中字段说明，按需添加

        GrammarfixSubmitResponse submitResponse = null;
        try {
            // 发起纠错检测检测的请求
            submitResponse = grammarfixClient.submit(submitRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (submitResponse != null && submitResponse.getCode() == 200) {
            GrammarfixSubmitResponse.GrammarfixSubmitResult grammarfixResult = submitResponse.getResult();
            // 获取文本纠错结果，具体返回字段的说明，请参考官方接口文档中字段说明
        }

    }
}
