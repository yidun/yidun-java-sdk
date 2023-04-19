package com.netease.yidun.sdk.auth.ocr.licenseplate.v1;

import java.util.List;

/**
 * 车牌OCR结果
 */
public class LicensePlateOcrResult {

    private Integer status;

    private String taskId;

    /**
     * OCR识别信息
     */
    private List<LicensePlateInfo> ocrResponseDetail;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public List<LicensePlateInfo> getOcrResponseDetail() {
        return ocrResponseDetail;
    }

    public void setOcrResponseDetail(List<LicensePlateInfo> ocrResponseDetail) {
        this.ocrResponseDetail = ocrResponseDetail;
    }

    @Override
    public String toString() {
        return "LicensePlateOcrResult(" +
                "status=" + status +
                ", taskId=" + taskId +
                ", ocrResponseDetail=" + ocrResponseDetail +
                ")";
    }
}
