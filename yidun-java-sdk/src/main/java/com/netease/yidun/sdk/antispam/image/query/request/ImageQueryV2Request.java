/*
 * @(#) ImageQueryV2Request.java 2024-10-22
 *
 * Copyright 2024 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.image.query.request;

import com.netease.yidun.sdk.antispam.image.query.response.ImageQueryResponse;
import com.netease.yidun.sdk.antispam.image.query.response.ImageQueryV2Response;
import com.netease.yidun.sdk.antispam.image.v5.common.ImageV5Request;

import java.util.List;

/**
 * @author xietieli
 * @version 2024-10-22
 */
public class ImageQueryV2Request extends ImageV5Request<ImageQueryV2Response> {

    /**
     * 任务id列表
     */
    private List<String> taskIds;

    /**
     * 构造函数
     */
    public ImageQueryV2Request() {
        super();
        productCode = "imageCommon";
        version = "v2";
        uriPattern = "/v2/image/query/task";
    }
    
    @Override
    public Class<ImageQueryV2Response> getResponseClass() {
        return ImageQueryV2Response.class;
    }

    @Override
    protected String requestUriPath() {
        return "/v2/image/query/task";
    }

    /**
     * 获取任务id列表
     * @return
     */
    public List<String> getTaskIds() {
        return taskIds;
    }

    /**
     * 设置任务id列表
     * @param taskIds
     */
    public void setTaskIds(List<String> taskIds) {
        this.taskIds = taskIds;
    }
}
