package com.netease.yidun.sdk.antispam.media.v2.query.request;

import com.google.gson.Gson;
import com.netease.yidun.sdk.antispam.media.v2.callback.response.MediaCallbackResponseV2;
import com.netease.yidun.sdk.core.request.PostFormRequest;
import com.netease.yidun.sdk.core.utils.StringHashMap;
import com.netease.yidun.sdk.core.validation.limitation.NotNull;
import com.netease.yidun.sdk.core.validation.limitation.Size;

import java.util.List;
import java.util.Map;

/**
 * 融媒体结果查询
 */
public class MediaQueryRequestV2 extends PostFormRequest<MediaCallbackResponseV2> {

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

    public MediaQueryRequestV2() {
        productCode = "media";
        uriPattern = "/v2/mediasolution/callback/query";
        version = "v2.1";
    }

    @Override
    public Class<MediaCallbackResponseV2> getResponseClass() {
        return MediaCallbackResponseV2.class;
    }

    public List<String> getTaskIds() {
        return taskIds;
    }

    public void setTaskIds(List<String> taskIds) {
        this.taskIds = taskIds;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "MediaQueryRequestV2{" +
                "taskIds=" + taskIds +
                '}';
    }
}
