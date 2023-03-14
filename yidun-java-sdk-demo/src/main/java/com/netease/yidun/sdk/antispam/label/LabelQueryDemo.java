/*
 * @(#) LabelQueryDemo.java 2023-03-14
 *
 * Copyright 2023 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.label;

import com.netease.yidun.sdk.antispam.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.enums.LabelBusinessTypeEnum;
import com.netease.yidun.sdk.antispam.label.query.request.LabelQueryRequest;
import com.netease.yidun.sdk.antispam.label.query.response.LabelQueryResponse;

import java.util.ArrayList;
import java.util.List;


/**
 * @author zhuliyang02
 * @version 2023-03-14
 */
public class LabelQueryDemo extends AbstractDemo {

    public static void  main(String[] args) {
//        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");
        AntispamRequester antispamRequester = createAntispamRequester("YvdOsdj21k5Iod_jkmLimi_D0gA", "iiDzJiIaOkuG0yrU_uejZ-TXUno");

        LabelClient labelClient = new LabelClient(antispamRequester);

        LabelQueryRequest labelQueryRequest = new LabelQueryRequest();
//        labelQueryRequest.setBusinessId("0a9753a437545cc599f7b5ea785c224d");
//        labelQueryRequest.setClientId("9abfd9256dfb4691bfb86892828b2d2c4592072246258548904");
        labelQueryRequest.setMaxDepth(3);

        List<String> businessTypes = new ArrayList<>();
        businessTypes.add(LabelBusinessTypeEnum.TEXT.getCode());

        labelQueryRequest.setBusinessTypes(businessTypes);

        LabelQueryResponse labelQueryResponse = labelClient.queryLabel(labelQueryRequest);
        System.out.println();
    }
}
