package com.netease.yidun.sdk.antispam.meida.v2;

import com.netease.yidun.sdk.antispam.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.media.v2.MediaClient;
import com.netease.yidun.sdk.antispam.media.v2.callback.response.MediaCallbackResponseV2;
import com.netease.yidun.sdk.antispam.media.v2.query.request.MediaQueryRequestV2;

/**
 * 融媒体解决方案Demo
 * 回调查询接口
 * 具体返回字段的说明，请参考官方接口文档中字段说明
 * https://support.dun.163.com/documents/599750646047514624?docId=599765653434998784
 */
public class MediaQueryDemo extends AbstractDemo {

    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        MediaClient mediaClient = new MediaClient(antispamRequester);

        // 实例化请求对象
        MediaQueryRequestV2 request = new MediaQueryRequestV2();

        // 请求对象中的其他参数如果有需要，请参考官方接口文档中字段说明，按需添加
        MediaCallbackResponseV2 response = null;
        try {
            // 发起同步查询的请求
            response = mediaClient.query(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (response != null && response.getCode() == 200) {
            for (MediaCallbackResponseV2.MediaCheckResult result : response.getResult()) {
                // doSomething
            }
        }

    }
}
