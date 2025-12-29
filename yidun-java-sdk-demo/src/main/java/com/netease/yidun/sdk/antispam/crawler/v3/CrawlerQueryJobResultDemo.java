/*
 * @(#) CrawlerQueryJobResult.java 2023-12-05
 *
 * Copyright 2023 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.crawler.v3;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.crawler.CrawlerClient;
import com.netease.yidun.sdk.antispam.crawler.v1.query.request.JobCallbackQueryRequest;
import com.netease.yidun.sdk.antispam.crawler.v1.query.response.JobCallbackQueryResponse;
import com.netease.yidun.sdk.antispam.media.v2.callback.response.MediaCallbackResponseV2;
import com.netease.yidun.sdk.core.utils.CollectionUtils;
import com.netease.yidun.sdk.core.http.ProtocolEnum;

/**
 * @author xietieli
 * @version 2023-12-05
 */
public class CrawlerQueryJobResultDemo extends AbstractDemo {

    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        CrawlerClient crawlerClient = CrawlerClient.getInstance(antispamRequester);

        // 实例化请求对象
        JobCallbackQueryRequest request = new JobCallbackQueryRequest();
        request.setProtocol(ProtocolEnum.HTTP);

        //设置任务Id
        request.setJobId(1504477469116473L);
        request.setPageNum(0);
        request.setPageSize(20);
        // 请求对象中的其他参数如果有需要，请参考官方接口文档中字段说明，按需添加

        JobCallbackQueryResponse response = null;
        try {
            // 发起获取回调的请求
            response = crawlerClient.jobResultQuery(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (response != null && response.getCode() == 200) {
            if (response.getResult() != null && !CollectionUtils.isEmpty(response.getResult().getRows())) {
                for (MediaCallbackResponseV2.MediaCheckResult mediaCheckResult : response.getResult().getRows()) {
                    // doSomething
                }
            }
        }
    }
}
