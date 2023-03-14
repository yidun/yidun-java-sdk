/*
 * @(#) LabelQueryResponse.java 2023-03-14
 *
 * Copyright 2023 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.label.query.response;

import com.netease.yidun.sdk.core.response.CommonResponse;

import java.util.List;

/**
 * @author zhuliyang02
 * @version 2023-03-14
 */
public class LabelQueryResponse extends CommonResponse{

    List<LabelQueryInfo> data;

    public List<LabelQueryInfo> getData() {
        return data;
    }

    public void setData(List<LabelQueryInfo> data) {
        this.data = data;
    }
}
