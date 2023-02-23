package com.netease.yidun.sdk.auth.ocr.businesslicense.v1;

/**
 * 营业执照OCR结果
 */
public class BusinessLicenseOcrResult {

    private Integer status;

    private String taskId;

    /**
     * 本次请求是否收费标识，1代表收费，0代表不收费
     */
    private String isPayed;

    /**
     * OCR识别信息
     */
    private BusinessLicenseInfo ocrResponseDetail;

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

    public BusinessLicenseInfo getOcrResponseDetail() {
        return ocrResponseDetail;
    }

    public void setOcrResponseDetail(BusinessLicenseInfo ocrResponseDetail) {
        this.ocrResponseDetail = ocrResponseDetail;
    }

    public String getIsPayed() {
        return isPayed;
    }

    public void setIsPayed(String isPayed) {
        this.isPayed = isPayed;
    }

    @Override
    public String toString() {
        return "BusinessLicenseOcrResult(" +
                "status=" + status +
                ", taskId=" + taskId +
                ", ocrResponseDetail=" + ocrResponseDetail +
                ", isPayed=" + isPayed +
                ")";
    }
}
