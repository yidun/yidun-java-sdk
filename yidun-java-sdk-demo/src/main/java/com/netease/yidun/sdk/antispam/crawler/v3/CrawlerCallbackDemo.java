package com.netease.yidun.sdk.antispam.crawler.v3;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.crawler.CrawlerClient;
import com.netease.yidun.sdk.antispam.crawler.v3.callback.request.CrawlerResourceCallbackV3Request;
import com.netease.yidun.sdk.antispam.crawler.v3.callback.response.CrawlerResourceCallbackV3Response;
import com.netease.yidun.sdk.core.http.ProtocolEnum;

/**
 * 网站检测回调Demo
 * 结果获取-轮询模式
 * 具体出入参的说明，请参考官方接口文档中字段说明
 * https://support.dun.163.com/documents/606191408732381184?docId=606214799456292864
 */
public class CrawlerCallbackDemo extends AbstractDemo {

    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        CrawlerClient crawlerClient = CrawlerClient.getInstance(antispamRequester);

        // 实例化请求对象
        CrawlerResourceCallbackV3Request request = new CrawlerResourceCallbackV3Request();
        request.setProtocol(ProtocolEnum.HTTP);

        // 请求对象中的其他参数如果有需要，请参考官方接口文档中字段说明，按需添加
        CrawlerResourceCallbackV3Response response = null;
        try {
            // 发起同步检测的请求
            response = crawlerClient.callbackResource(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (response != null && response.getCode() == 200) {
            for (CrawlerResourceCallbackV3Response.CrawlerResourceResult result : response.getResult()) {
                // doSomething
            }
        }

    }
}
