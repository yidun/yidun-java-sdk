package com.netease.yidun.sdk.antispam.digitalbook.v2.query.request;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.google.gson.Gson;
import com.netease.yidun.sdk.antispam.digitalbook.v2.callback.response.DigitalBookCallbackResponseV2;
import com.netease.yidun.sdk.core.request.PostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;

/**
 * 数字阅读结果查询
 */
public class DigitalBookQueryRequestV2 extends PostFormRequest<DigitalBookCallbackResponseV2> {

    private static final Gson GSON = new Gson();

    @NotNull(message = "taskId不能为空")
    @Size(min = 1, message = "taskId不能为空")
    private List<String> taskIds;

    @Override
    protected Map<String, String> getCustomSignParams() {
        StringHashMap params = new StringHashMap();
        params.put("taskIds", GSON.toJson(taskIds));
        return params;
    }

    public DigitalBookQueryRequestV2() {
        productCode = "digitalBook";
        uriPattern = "/v2/digital/callback/query";
        version = "v2";
    }

    @Override
    public Class<DigitalBookCallbackResponseV2> getResponseClass() {
        return DigitalBookCallbackResponseV2.class;
    }

    public List<String> getTaskIds() {
        return taskIds;
    }

    public void setTaskIds(List<String> taskIds) {
        this.taskIds = taskIds;
    }

    @Override
    public String toString() {
        return "DigitalBookQueryRequestV2{" +
                "taskIds=" + taskIds +
                '}';
    }
}
