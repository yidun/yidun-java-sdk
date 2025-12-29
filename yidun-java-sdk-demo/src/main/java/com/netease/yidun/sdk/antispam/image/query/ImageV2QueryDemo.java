/*
 * @(#) ImageV2QueryDemo.java 2024-10-22
 *
 * Copyright 2024 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.image.query;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.image.query.request.ImageQueryV2Request;
import com.netease.yidun.sdk.antispam.image.query.response.ImageQueryV2Response;
import com.netease.yidun.sdk.antispam.image.v5.ImageClient;
import com.netease.yidun.sdk.antispam.image.v5.check.sync.response.ImageV5Result;

import java.util.Collections;
import com.netease.yidun.sdk.core.http.ProtocolEnum;

/**
 * @author xietieli
 * @version 2024-10-22
 */
public class ImageV2QueryDemo extends AbstractDemo {
    public static void main(String[] args) {

        // 实例化一个requester，入参需要传入易盾内容安全分配的secretId，SecretKey
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        // 实例化发起请求的client对象
        ImageClient imageClient = ImageClient.getInstance(antispamRequester);
        // 实例化请求对象
        ImageQueryV2Request queryV2Request = new ImageQueryV2Request();
        queryV2Request.setProtocol(ProtocolEnum.HTTP);
        // 设置易盾内容安全分配的businessId
        queryV2Request.setBusinessId("BusinessId");

        // 实例化参数对象
        queryV2Request.setTaskIds(Collections.singletonList("图片检测接口返回的数据唯一标识"));
        ImageQueryV2Response queryV2Response = null;
        try {
            // 发起query请求
            queryV2Response = imageClient.queryV2(queryV2Request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (queryV2Response != null && queryV2Response.getCode() == 200) {
            for (ImageV5Result image : queryV2Response.getResult()) {
                // 根据需要获取每张图片的结果，具体返回字段的说明，请参考官方接口文档中字段说明
                System.out.println(image.toString());
            }
        }

    }
}
