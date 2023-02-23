package com.netease.yidun.sdk.auth.face.recognize.v1;

import java.util.List;

/**
 * 人脸检索结果
 */
public class FaceRecognizeResult {

    /**
     * 请求唯一标识
     */
    private String requestId;

    /**
     * 检测状态
     */
    private Integer status;

    /**
     * 是否匹配到
     */
    private Boolean matched;

    /**
     * 本次请求是否收费标识，1代表收费，0代表不收费
     */
    private Integer isPayed;

    /**
     * 命中的人脸详情，按匹配程度排序
     */
    private List<FaceMatchInfo> matchedFaces;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getMatched() {
        return matched;
    }

    public void setMatched(Boolean matched) {
        this.matched = matched;
    }

    public List<FaceMatchInfo> getMatchedFaces() {
        return matchedFaces;
    }

    public void setMatchedFaces(List<FaceMatchInfo> matchedFaces) {
        this.matchedFaces = matchedFaces;
    }

    public Integer getIsPayed() {
        return isPayed;
    }

    public void setIsPayed(Integer isPayed) {
        this.isPayed = isPayed;
    }

    @Override
    public String toString() {
        return "FaceRecognizeResult(" +
                "requestId=" + requestId +
                ", status=" + status +
                ", matched=" + matched +
                ", matchedFaces=" + matchedFaces +
                ", isPayed=" + isPayed +
                ")";
    }

    public static class FaceMatchInfo {

        /**
         * 得分
         */
        private Double score;

        /**
         * 人脸ID
         */
        private String faceId;

        /**
         * 对应的姓名
         */
        private String name;

        /**
         * 匹配的人脸url
         */
        private String faceUrl;

        public Double getScore() {
            return score;
        }

        public void setScore(Double score) {
            this.score = score;
        }

        public String getFaceId() {
            return faceId;
        }

        public void setFaceId(String faceId) {
            this.faceId = faceId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFaceUrl() {
            return faceUrl;
        }

        public void setFaceUrl(String faceUrl) {
            this.faceUrl = faceUrl;
        }

        @Override
        public String toString() {
            return "FaceMatchInfo(" +
                    "score=" + score +
                    ", faceId=" + faceId +
                    ", name=" + name +
                    ", faceUrl=" + faceUrl +
                    ")";
        }
    }
}
