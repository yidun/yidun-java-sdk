/*
 * @(#) TextTaskIdsQueryRequest.java 2024-04-15
 *
 * Copyright 2024 NetEase.com, Inc. All rights reserved.
 */

package com.netease.yidun.sdk.antispam.text.query;

import com.google.gson.Gson;
import com.netease.yidun.sdk.core.request.BizPostFormRequest;
import com.netease.yidun.sdk.core.validation.limitation.NotBlank;
import com.netease.yidun.sdk.core.validation.limitation.NotEmpty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author zhuliyang02
 * @version 2024-04-15
 */
@Data
public class TextTaskIdsQueryRequest extends BizPostFormRequest<TextTaskIdsQueryResponse> {

    /**
     * taskId json数组
     */
    @NotEmpty(message = "taskIds不能为空")
    private List<String> taskIds;

    public TextTaskIdsQueryRequest() {
        productCode = "text-api";
        version = "v1";
        uriPattern = "/v1/text/query/task";
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> params = super.getCustomSignParams();
        params.put("taskIds", new Gson().toJson(taskIds));
        return params;
    }


    @Override
    public Class<TextTaskIdsQueryResponse> getResponseClass() {
        return TextTaskIdsQueryResponse.class;
    }

    @Override
    public String toString() {
        return "TextTaskIdsQueryRequest("
                + "super=" + super.toString()
                + ", taskIds=" + taskIds
                + ")";
    }
}
