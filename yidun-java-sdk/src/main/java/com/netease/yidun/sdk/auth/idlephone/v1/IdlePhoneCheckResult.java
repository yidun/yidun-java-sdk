package com.netease.yidun.sdk.auth.idlephone.v1;

/**
 * 号码状态检测结果
 */
public class IdlePhoneCheckResult {

    /**
     * 检测结果
     */
    private Integer status;

    /**
     * 本次请求数据标识
     */
    private String requestId;

    /**
     * 本次请求是否收费
     */
    private Integer isPayed;

    /**
     * 计费条数
     */
    private Integer chargeCount;

    /**
     * 查询的手机号信息
     */
    private PhoneInfo phoneInfo;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Integer getIsPayed() {
        return isPayed;
    }

    public void setIsPayed(Integer isPayed) {
        this.isPayed = isPayed;
    }

    public Integer getChargeCount() {
        return chargeCount;
    }

    public void setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
    }

    public PhoneInfo getPhoneInfo() {
        return phoneInfo;
    }

    public void setPhoneInfo(PhoneInfo phoneInfo) {
        this.phoneInfo = phoneInfo;
    }

    @Override
    public String toString() {
        return "IdCardCheckResult(" +
                "status=" + status +
                ", requestId=" + requestId +
                ", isPayed=" + isPayed +
                ", chargeCount=" + chargeCount +
                ", phoneInfo=" + phoneInfo +
                ")";
    }
}
