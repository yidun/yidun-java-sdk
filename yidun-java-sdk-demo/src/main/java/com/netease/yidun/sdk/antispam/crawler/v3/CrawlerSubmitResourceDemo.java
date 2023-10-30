package com.netease.yidun.sdk.antispam.crawler.v3;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.crawler.CrawlerClient;
import com.netease.yidun.sdk.antispam.crawler.v3.submit.request.CrawlerResourceSubmitV3Request;
import com.netease.yidun.sdk.antispam.crawler.v3.submit.response.CrawlerResourceSubmitV3Response;

import java.util.Arrays;

/**
 * 网站检测提交Demo
 * 单URL提交接口
 * 具体出入参的说明，请参考官方接口文档中字段说明
 * https://support.dun.163.com/documents/606191408732381184?docId=606195609575301120
 */
public class CrawlerSubmitResourceDemo extends AbstractDemo {

    public static void main(String[] args) {

        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        CrawlerClient crawlerClient = CrawlerClient.getInstance(antispamRequester);

        // 实例化请求对象
        CrawlerResourceSubmitV3Request request = new CrawlerResourceSubmitV3Request();
        String url = "https://news.163.com";
        request.setUrl(url);
        request.setCheckFlags(Arrays.asList(1, 2));
        request.setDataId("dataId_" + url);
        request.setCallback("callback_" + url);
        // 请求对象中的其他参数如果有需要，请参考官方接口文档中字段说明，按需添加
        CrawlerResourceSubmitV3Response response = null;
        try {
            // 发起同步检测的请求
            response = crawlerClient.submitResource(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (response != null && response.getCode() == 200) {
            CrawlerResourceSubmitV3Response.CrawlerResourceSubmitResult result = response.getResult();
            if (result != null){
                //doSomething
            }
        }

    }

}
