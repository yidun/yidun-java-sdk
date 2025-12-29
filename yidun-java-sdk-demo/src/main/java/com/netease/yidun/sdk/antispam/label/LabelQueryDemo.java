/*
 * @(#) LabelQueryDemo.java 2023-03-14
 *
 * Copyright 2023 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.label;

import com.netease.yidun.sdk.AbstractDemo;
import com.netease.yidun.sdk.antispam.AntispamRequester;
import com.netease.yidun.sdk.antispam.enums.LabelBusinessTypeEnum;
import com.netease.yidun.sdk.antispam.label.query.request.LabelQueryRequest;
import com.netease.yidun.sdk.antispam.label.query.response.LabelQueryInfo;
import com.netease.yidun.sdk.antispam.label.query.response.LabelQueryResponse;

import java.util.ArrayList;
import java.util.List;
import com.netease.yidun.sdk.core.http.ProtocolEnum;


/**
 * @author zhuliyang02
 * @version 2023-03-14
 */
public class LabelQueryDemo extends AbstractDemo {

    public static void  main(String[] args) {
        AntispamRequester antispamRequester = createAntispamRequester("SecretId", "SecretKey");

        LabelClient labelClient = LabelClient.getInstance(antispamRequester);

        LabelQueryRequest labelQueryRequest = new LabelQueryRequest();
        labelQueryRequest.setProtocol(ProtocolEnum.HTTP);
        labelQueryRequest.setBusinessId("businessId");
        labelQueryRequest.setClientId("clientId");
        labelQueryRequest.setMaxDepth(3);

        List<String> businessTypes = new ArrayList<>();
        businessTypes.add(LabelBusinessTypeEnum.TEXT.getCode());

        labelQueryRequest.setBusinessTypes(businessTypes);
        try {
            LabelQueryResponse labelQueryResponse = labelClient.queryLabel(labelQueryRequest);
            if (labelQueryResponse.getCode() == 200 && labelQueryResponse.getData() != null) {
                List<LabelQueryInfo> labelQueryInfos = labelQueryResponse.getData();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
