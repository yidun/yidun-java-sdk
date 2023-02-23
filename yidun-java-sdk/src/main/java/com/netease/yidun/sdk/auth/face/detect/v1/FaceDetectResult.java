package com.netease.yidun.sdk.auth.face.detect.v1;

import java.util.List;

/**
 * 人脸检测结果
 */
public class FaceDetectResult {
    /**
     * 请求唯一标识
     */
    private String requestId;

    /**
     * 检测结果
     */
    private Integer status;

    /**
     * 人脸数量
     */
    private Integer faceNumber;

    /**
     * 人脸的位置信息
     */
    private List<FaceLocation> faceLocations;

    /**
     * 本次请求是否收费标识，1代表收费，0代表不收费
     */
    private Integer isPayed;

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

    public Integer getFaceNumber() {
        return faceNumber;
    }

    public void setFaceNumber(Integer faceNumber) {
        this.faceNumber = faceNumber;
    }

    public List<FaceLocation> getFaceLocations() {
        return faceLocations;
    }

    public void setFaceLocations(List<FaceLocation> faceLocations) {
        this.faceLocations = faceLocations;
    }

    public Integer getIsPayed() {
        return isPayed;
    }

    public void setIsPayed(Integer isPayed) {
        this.isPayed = isPayed;
    }

    @Override
    public String toString() {
        return "FaceDetectResult(" +
                "requestId=" + requestId +
                ", status=" + status +
                ", faceNumber=" + faceNumber +
                ", faceLocations=" + faceLocations +
                ", isPayed=" + isPayed +
                ")";
    }

    public static class FaceLocation {

        /**
         * 人脸位置信息，对应人脸矩形左上角横坐标相对坐标
         */
        private String x1;

        /**
         * 人脸位置信息，对应人脸矩形左上角纵坐标相对坐标
         */
        private String y1;

        /**
         * 人脸位置信息，对应人脸矩形右下角横坐标相对坐标
         */
        private String x2;

        /**
         * 人脸位置信息，对应人脸矩形右下角纵坐标相对坐标
         */
        private String y2;
        /**
         * 性别
         */
        private String gender;
        /**
         * 年龄
         */
        private String age;
        /**
         * 人脸占比
         */
        private String sizeRatio;

        /**
         * 人脸类型 包括卡通脸（cartoon）、普通（normal）
         */
        private String type;

        /**
         * 人脸遮挡
         */
        private String maskType;

        /**
         * 人脸带眼镜
         */
        private String glasses;

        /**
         * 人脸颜值分
         */
        private Float beautyScore;

        public String getX1() {
            return x1;
        }

        public void setX1(String x1) {
            this.x1 = x1;
        }

        public String getY1() {
            return y1;
        }

        public void setY1(String y1) {
            this.y1 = y1;
        }

        public String getX2() {
            return x2;
        }

        public void setX2(String x2) {
            this.x2 = x2;
        }

        public String getY2() {
            return y2;
        }

        public void setY2(String y2) {
            this.y2 = y2;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getSizeRatio() {
            return sizeRatio;
        }

        public void setSizeRatio(String sizeRatio) {
            this.sizeRatio = sizeRatio;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getMaskType() {
            return maskType;
        }

        public void setMaskType(String maskType) {
            this.maskType = maskType;
        }

        public String getGlasses() {
            return glasses;
        }

        public void setGlasses(String glasses) {
            this.glasses = glasses;
        }

        public Float getBeautyScore() {
            return beautyScore;
        }

        public void setBeautyScore(Float beautyScore) {
            this.beautyScore = beautyScore;
        }

        @Override
        public String toString() {
            return "FaceLocation(" +
                    "x1=" + x1 +
                    ", y1=" + y1 +
                    ", x2=" + x2 +
                    ", y2=" + y2 +
                    ", gender=" + gender +
                    ", age=" + age +
                    ", sizeRatio=" + sizeRatio +
                    ", maskType=" + maskType +
                    ", glasses=" + glasses +
                    ", beautyScore=" + beautyScore +
                    ")";
        }
    }
}
