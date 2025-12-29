/*
 * @(#) LabelQueryDemo.java 2023-03-14
 *
 * Copyright 2023 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.label;

import com.netease.yidun.sdk.antispam.enums.LabelBusinessTypeEnum;
import com.netease.yidun.sdk.antispam.label.cache.LabelCache;
import com.netease.yidun.sdk.antispam.label.query.request.LabelQueryRequest;
import com.netease.yidun.sdk.core.client.ClientProfile;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import com.netease.yidun.sdk.core.http.ProtocolEnum;


/**
 * @author zhaojipu
 * @version 2024-09-09
 */
public class LabelCacheDemo {

    public static void main(String[] args) {
        ClientProfile clientProfile = ClientProfile.defaultProfile("SecretId", "SecretKey");
        LabelQueryRequest labelQueryRequest = new LabelQueryRequest();
        labelQueryRequest.setProtocol(ProtocolEnum.HTTP);
        labelQueryRequest.setFetchClientLabel(true);
        labelQueryRequest.setMaxDepth(3);
        List<String> businessTypes = Arrays.stream(LabelBusinessTypeEnum.values())
                .map(LabelBusinessTypeEnum::getCode)
                .collect(Collectors.toList());
        labelQueryRequest.setBusinessTypes(businessTypes);

        // 启动时，加载缓存，并且后台自动刷新缓存（默认间隔60分钟）
        LabelCache.initCache(clientProfile, labelQueryRequest);

//         多个账号或者自定义参数时
//        List<ClientProfile> clientProfiles = new ArrayList<>();
//        clientProfiles.add(clientProfile);
//        CacheProperty cacheProperty = new CacheProperty();
//        cacheProperty.setRefreshIntervalMinute(60);
//        LabelCache.initCache(clientProfiles, labelQueryRequest, cacheProperty);

        // 需要获取名字时
        String labelName = LabelCache.getLabelName("labelCode");
        System.out.println(labelName);
    }
}
