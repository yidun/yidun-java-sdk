
package com.netease.yidun.sdk.antispam.report.v1.query.request;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.google.gson.Gson;
import com.netease.yidun.sdk.antispam.report.v1.callback.response.ReportCallbackResponseV1;
import com.netease.yidun.sdk.core.request.PostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;

/**
 * 融媒体结果查询
 */
public class ReportQueryRequestV1 extends PostFormRequest<ReportCallbackResponseV1> {

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

    public ReportQueryRequestV1() {
        productCode = "report";
        uriPattern = "/v1/report/callback/query";
        version = "v1";
    }

    @Override
    public Class<ReportCallbackResponseV1> getResponseClass() {
        return ReportCallbackResponseV1.class;
    }

    public List<String> getTaskIds() {
        return taskIds;
    }

    public void setTaskIds(List<String> taskIds) {
        this.taskIds = taskIds;
    }

    @Override
    public String toString() {
        return "ReportQueryRequestV1{" +
                "taskIds=" + taskIds +
                '}';
    }
}
