/*
 * @(#) ImageQueryV2Response.java 2024-10-22
 *
 * Copyright 2024 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.image.query.response;

import com.netease.yidun.sdk.antispam.image.v5.check.sync.response.ImageV5Result;
import com.netease.yidun.sdk.core.response.CommonResponse;

import java.util.List;

/**
 * @author xietieli
 * @version 2024-10-22
 */
public class ImageQueryV2Response extends CommonResponse {
    private static final long serialVersionUID = -1776836042247761772L;

    /**
     * 图片查询结果
     */
    private List<ImageV5Result> result;

    /**
     * 获取图片查询结果
     * @return
     */
    public List<ImageV5Result> getResult() {
        return result;
    }

    /**
     * 设置图片查询结果
     * @param result
     */
    public void setResult(List<ImageV5Result> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ImageQueryV2Response{" +
                "result=" + result +
                '}';
    }
}
