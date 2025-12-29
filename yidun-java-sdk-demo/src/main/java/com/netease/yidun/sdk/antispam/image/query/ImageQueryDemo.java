/*
 * @(#) ImageQueryDemo.java 2024-04-15
 *
 * Copyright 2024 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.image.query;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.image.query.request.ImageQueryRequest;
import com.netease.yidun.sdk.antispam.image.query.response.ImageQueryResponse;
import com.netease.yidun.sdk.antispam.image.v5.ImageClient;

import java.util.Arrays;
import java.util.Collections;
import com.netease.yidun.sdk.core.http.ProtocolEnum;


/**
 * @author xietieli
 * @version 2024-04-15
 */
public class ImageQueryDemo extends AbstractDemo {
        public static void main(String[] args) {

            // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，secretKey
            AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

            // 实例化发起请求的client对象
            ImageClient imageClient = ImageClient.getInstance(antispamRequester);
            // 实例化请求对象
            ImageQueryRequest queryRequest = new ImageQueryRequest();
            queryRequest.setProtocol(ProtocolEnum.HTTP);
            // 设置易盾内容安全分配的businessId
            queryRequest.setBusinessId("BusinessId");

            // 实例化参数对象
            queryRequest.setTaskIds(Collections.singletonList("图片检测接口返回的数据唯一标识"));
            ImageQueryResponse queryResponse = null;
            try {
                // 发起query请求
                queryResponse = imageClient.query(queryRequest);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (queryResponse != null && queryResponse.getCode() == 200) {
                for (ImageQueryResponse.ImageQueryResp imageQueryResp : queryResponse.getResult()) {
                    // 根据需要获取每张图片的结果，具体返回字段的说明，请参考官方接口文档中字段说明
                    System.out.println(imageQueryResp.toString());
                }
            }

        }

}
