package com.netease.yidun.sdk.auth.face.compare.v1;

/**
 * 人脸比对结果
 */
public class FaceCompareResult {
    /**
     * 是否匹配到
     */
    private Integer matched;

    /**
     * 得分
     */
    private Double score;

    /**
     * 请求唯一标识
     */
    private String requestId;

    /**
     * 本次请求是否收费标识，1代表收费，0代表不收费
     */
    private Integer isPayed;

    public Integer getMatched() {
        return matched;
    }

    public void setMatched(Integer matched) {
        this.matched = matched;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
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

    @Override
    public String toString() {
        return "FaceCompareResult(" +
                "matched=" + matched +
                ", score=" + score +
                ", requestId=" + requestId +
                ", isPayed=" + isPayed +
                ")";
    }
}
