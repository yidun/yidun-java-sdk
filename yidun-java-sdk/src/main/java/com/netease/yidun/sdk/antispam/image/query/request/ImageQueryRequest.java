/*
 * @(#) ImageQueryRequest.java 2024-04-15
 *
 * Copyright 2024 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.image.query.request;

import com.netease.yidun.sdk.antispam.image.query.response.ImageQueryResponse;
import com.netease.yidun.sdk.antispam.image.v5.common.ImageV5Request;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;
import com.netease.yidun.sdk.core.response.BaseResponse;

import java.util.List;

/**
 * @author xietieli
 * @version 2024-04-15
 */
public class ImageQueryRequest extends ImageV5Request<ImageQueryResponse> {
    /**
     * 任务id列表
     */
    private List<String> taskIds;

    public ImageQueryRequest() {
        super();
        productCode = "imageCommon";
        version = "v1";
        uriPattern = "/v1/image/query/task";
    }

    @Override
    protected String requestUriPath() {
        return "/v1/image/query/task";
    }

    @Override
    public Class<ImageQueryResponse> getResponseClass() {
        return ImageQueryResponse.class;
    }

    public List<String> getTaskIds() {
        return taskIds;
    }

    public void setTaskIds(List<String> taskIds) {
        this.taskIds = taskIds;
    }
}
