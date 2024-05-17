package com.netease.yidun.sdk.irisk.v1.mediacheck;

import com.netease.yidun.sdk.core.request.BizPostJsonRequest;
import com.netease.yidun.sdk.core.validation.limitation.Length;
import com.netease.yidun.sdk.core.validation.limitation.NotEmpty;

import java.util.Map;


/**
 * @author zhouyutong01
 * 图片检测-结果查询
 */
public class IRiskMediaQueryRequest extends BizPostJsonRequest<IRiskMediaQueryResponse> {

    /**
     * taskId
     */
    @NotEmpty(message = "taskId不能为空")
    @Length(max = 64, message = "taskId长度最大为64")
    private String taskId;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public IRiskMediaQueryRequest(String businessId) {
        productCode = "irisk";
        version = "500";
        uriPattern = "/v5/risk/mediaQuery";
        this.businessId = businessId;
    }

    @Override
    protected Map<String, String> getCustomSignParams() {
        Map<String, String> customSignParams = super.getCustomSignParams();
        customSignParams.put("taskId", taskId);
        return customSignParams;
    }

    @Override
    public Class<IRiskMediaQueryResponse> getResponseClass() {
        return IRiskMediaQueryResponse.class;
    }


    @Override
    public String toString() {
        return "IRiskMediaQueryRequest(" +
                "super=" + super.toString() +
                ", taskId=" + taskId +
                ")";
    }
}
