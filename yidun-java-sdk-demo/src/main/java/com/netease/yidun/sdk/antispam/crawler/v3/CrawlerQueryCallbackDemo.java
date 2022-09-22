/*
 * @(#) CrawlerQueryCallbackDemo.java 2022-09-22
 *
 * Copyright 2022 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.crawler.v3;



import com.netease.yidun.sdk.antispam.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.crawler.CrawlerClient;
import com.netease.yidun.sdk.antispam.crawler.v3.callback.response.CrawlerResourceCallbackV3Response;
import com.netease.yidun.sdk.antispam.crawler.v3.query.request.CrawlerQueryRequest;

import java.util.ArrayList;
import java.util.List;


/**
 * 网站检测详情查询接口Demo
 * 具体出入参的说明，请参考官方接口文档中字段说明
 *
 */
public class CrawlerQueryCallbackDemo extends AbstractDemo{

    public static void main(String[] args) {
        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        CrawlerClient crawlerClient = new CrawlerClient(antispamRequester);

        // 实例化请求对象
        CrawlerQueryRequest request = new CrawlerQueryRequest();

        //设置taskIdList
        List<String> taskIdArray=new ArrayList<>();
        taskIdArray.add("taskId1");
        taskIdArray.add("taskId2");
        request.setTaskIdList(taskIdArray);
        // 请求对象中的其他参数如果有需要，请参考官方接口文档中字段说明，按需添加

        CrawlerResourceCallbackV3Response response = null;
        try {
            // 发起获取回调的请求
            response = crawlerClient.callback(request);
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
