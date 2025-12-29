package com.netease.yidun.sdk.antispam.stream.v1;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.stream.v1.callback.AigcStreamCallbackRequestV1;
import com.netease.yidun.sdk.antispam.stream.v1.callback.AigcStreamCallbackResponseV1;
import com.netease.yidun.sdk.core.http.ProtocolEnum;


/**
 * AIGC流式解决方案Demo
 * 结果获取-轮询模式
 * 具体返回字段的说明，请参考官方接口文档中字段说明
 * https://support.dun.163.com/documents/953823904240750592?docId=953843610446209024
 */
public class AigcStreamCallbackDemo extends AbstractDemo {

    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        AigcStreamClient aigcStreamClient = AigcStreamClient.getInstance(antispamRequester);

        // 实例化请求对象
        AigcStreamCallbackRequestV1 request = new AigcStreamCallbackRequestV1();
        request.setProtocol(ProtocolEnum.HTTP);

        // 请求对象中的其他参数如果有需要，请参考官方接口文档中字段说明，按需添加
        AigcStreamCallbackResponseV1 response = null;
        try {
            // 发起同步回调的请求
            response = aigcStreamClient.callback(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (response != null && response.getCode() == 200) {
            for (AigcStreamCheckResult result : response.getResult()) {
                // doSomething
            }
        }

    }
}
