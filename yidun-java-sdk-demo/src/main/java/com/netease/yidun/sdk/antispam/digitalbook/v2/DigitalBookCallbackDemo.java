package com.netease.yidun.sdk.antispam.digitalbook.v2;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.digitalbook.v2.callback.request.DigitalBookCallbackRequestV2;
import com.netease.yidun.sdk.antispam.digitalbook.v2.callback.response.DigitalBookCallbackResponseV2;

/**
 * 数字阅读解决方案Demo
 * 结果获取-轮训模式
 * 具体返回字段的说明，请参考官方接口文档中字段说明
 * https://support.dun.163.com/documents/601492044329328640?docId=601495269115764736
 */
public class DigitalBookCallbackDemo extends AbstractDemo {

    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        DigitalBookClient digitalBookClient = DigitalBookClient.getInstance(antispamRequester);

        // 实例化请求对象
        DigitalBookCallbackRequestV2 request = new DigitalBookCallbackRequestV2();

        // 请求对象中的其他参数如果有需要，请参考官方接口文档中字段说明，按需添加
        DigitalBookCallbackResponseV2 response = null;
        try {
            // 发起同步检测的请求
            response = digitalBookClient.callback(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (response != null && response.getCode() == 200) {
            for (DigitalBookCallbackResponseV2.DigitalBookCheckResult result : response.getResult()) {

            }
        }

    }
}
