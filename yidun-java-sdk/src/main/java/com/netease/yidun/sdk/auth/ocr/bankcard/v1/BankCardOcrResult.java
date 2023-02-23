
package com.netease.yidun.sdk.auth.ocr.bankcard.v1;

/**
 * 银行卡OCR结果
 */
public class BankCardOcrResult {

    private Integer status;
    private String taskId;
    /**
     * OCR识别信息
     */
    private BankCardInfo ocrResponseDetail;
    /**
     * 图片方向
     */
    private Integer direction;

    /**
     * 本次请求是否收费标识，1代表收费，0代表不收费
     */
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

    public BankCardInfo getOcrResponseDetail() {
        return ocrResponseDetail;
    }

    public void setOcrResponseDetail(BankCardInfo ocrResponseDetail) {
        this.ocrResponseDetail = ocrResponseDetail;
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public Integer getIsPayed() {
        return isPayed;
    }

    public void setIsPayed(Integer isPayed) {
        this.isPayed = isPayed;
    }

    @Override
    public String toString() {
        return "BankCardOcrResult(" +
                "status=" + status +
                ", taskId=" + taskId +
                ", ocrResponseDetail=" + ocrResponseDetail +
                ", direction=" + direction +
                ", isPayed=" + isPayed +
                ')';
    }
}
