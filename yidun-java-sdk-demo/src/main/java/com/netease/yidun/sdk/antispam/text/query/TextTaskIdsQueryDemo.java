/*
 * @(#) TextTaskIdsQueryDemo.java 2024-04-15
 *
 * Copyright 2024 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.text.query;

import com.google.gson.Gson;
import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.text.TextClient;

import java.util.Arrays;

/**
 * @author zhuliyang02
 * @version 2024-04-15
 */
public class TextTaskIdsQueryDemo extends AbstractDemo {

    public static void main(String[] args) {

        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        TextClient textClient = TextClient.getInstance(antispamRequester);
        // 实例化请求对象
        TextTaskIdsQueryRequest taskIdsQueryRequest = new TextTaskIdsQueryRequest();
        // 设置易盾内容安全分配的businessId
        taskIdsQueryRequest.setBusinessId("BusinessId");
        taskIdsQueryRequest.setTaskIds(Arrays.asList("taskId1", "taskId2"));

        // 请求对象中的其他参数如果有需要，请参考官方接口文档中字段说明，按需添加

        TextTaskIdsQueryResponse taskIdsQueryResponse = null;
        try {
            // 发起feedback的请求
            taskIdsQueryResponse = textClient.queryTaskIds(taskIdsQueryRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (taskIdsQueryResponse != null && taskIdsQueryResponse.getCode() == 200) {
            for (TextTaskIdsQueryResponse.TextTaskIdsQueryResult taskIdResult : taskIdsQueryResponse.getResult()) {
                // 根据需要获取每个文本的taskId查询结果，具体返回字段的说明，请参考官方接口文档中字段说明
                System.out.println(taskIdResult.getTaskId());
            }
        }

    }
}
