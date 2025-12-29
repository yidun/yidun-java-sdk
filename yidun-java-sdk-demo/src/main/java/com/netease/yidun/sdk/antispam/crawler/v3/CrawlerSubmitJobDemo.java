package com.netease.yidun.sdk.antispam.crawler.v3;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.crawler.CrawlerClient;
import com.netease.yidun.sdk.antispam.crawler.v1.submit.request.CrawlerJobSubmitV1Request;
import com.netease.yidun.sdk.antispam.crawler.v1.submit.response.CrawlerJobSubmitV1Response;

import java.util.Arrays;
import java.util.HashSet;
import com.netease.yidun.sdk.core.http.ProtocolEnum;

/**
 * 网站检测提交Demo 主站检测任务提交接口 具体出入参的说明，请参考官方接口文档中字段说明
 * https://support.dun.163.com/documents/606191408732381184?docId=611046863444135936
 */
public class CrawlerSubmitJobDemo extends AbstractDemo {

    public static void main(String[] args) {

        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        CrawlerClient crawlerClient = CrawlerClient.getInstance(antispamRequester);

        // 实例化请求对象
        // 入参说明请看官网:https://support.dun.163.com/documents/606191408732381184?docId=611046863444135936
        CrawlerJobSubmitV1Request request = new CrawlerJobSubmitV1Request();
        request.setProtocol(ProtocolEnum.HTTP);
        request.setFrequency(86400000L);
        request.setLevel(-1);
        request.setMaxResourceAmount(10);
        request.setSiteUrl("https://news.163.com");
        request.setType(0);
        request.setSliceStartTime(1672202035000L);
        request.setSliceEndTime(1672288435000L);
        request.setCheckStrategy(2);
        request.setCheckFlags(new HashSet<>(Arrays.asList(1, 2)));
        request.setAccount("Account_111223");
        // 请求对象中的其他参数如果有需要，请参考官方接口文档中字段说明，按需添加
        CrawlerJobSubmitV1Response response = null;
        try {
            // 发起同步检测的请求
            response = crawlerClient.submitJob(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (response != null && response.getCode() == 200) {
            CrawlerJobSubmitV1Response.CrawlerJobSubmitResult result = response.getResult();
            if (result != null) {
                // doSomething
            }
        }

    }

}
