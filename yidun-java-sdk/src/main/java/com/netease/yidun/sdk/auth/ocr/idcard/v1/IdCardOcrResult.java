package com.netease.yidun.sdk.auth.ocr.idcard.v1;

/**
 * 身份证OCR结果
 */
public class IdCardOcrResult {

    private Integer status;
    private String taskId;
    private IdCardInfo ocrResponseDetail;
    private Integer isPayed;

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

    public IdCardInfo getOcrResponseDetail() {
        return ocrResponseDetail;
    }

    public void setOcrResponseDetail(IdCardInfo ocrResponseDetail) {
        this.ocrResponseDetail = ocrResponseDetail;
    }

    public Integer getIsPayed() {
        return isPayed;
    }

    public void setIsPayed(Integer isPayed) {
        this.isPayed = isPayed;
    }

    @Override
    public String toString() {
        return "IdCardOcrResult(" +
                "status=" + status +
                ", taskId='" + taskId +
                ", ocrResponseDetail=" + ocrResponseDetail +
                ", isPayed=" + isPayed +
                ")";
    }
}
