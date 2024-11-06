package com.netease.yidun.sdk.irisk.v1.mediacheck;

import com.netease.yidun.sdk.core.request.BizPostJsonRequest;
import com.netease.yidun.sdk.core.validation.limitation.NotBlank;

import java.util.Map;


/**
 * @author zhouyutong01
 * 图片检测-结果查询
 */
public class IRiskMediaBatchQueryRequest extends BizPostJsonRequest<IRiskMediaBatchQueryResponse> {

    /**
     * taskIds
     */
    @NotBlank(message = "taskIds不能为空")
    private String taskIds;

    public String getTaskIds() {
        return taskIds;
    }

    public void setTaskIds(String taskIds) {
        this.taskIds = taskIds;
    }

    public IRiskMediaBatchQueryRequest(String businessId) {
        productCode = "irisk";
        version = "500";
        uriPattern = "/v5/risk/mediaBatchQuery";
        this.businessId = businessId;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> customSignParams = super.getCustomSignParams();
        customSignParams.put("taskIds", taskIds);
        return customSignParams;
    }

    @Override
    public Class<IRiskMediaBatchQueryResponse> getResponseClass() {
        return IRiskMediaBatchQueryResponse.class;
    }


    @Override
    public String toString() {
        return "IRiskMediaBatchQueryRequest(" +
                "super=" + super.toString() +
                ", taskIds=" + taskIds +
                ")";
    }
}
