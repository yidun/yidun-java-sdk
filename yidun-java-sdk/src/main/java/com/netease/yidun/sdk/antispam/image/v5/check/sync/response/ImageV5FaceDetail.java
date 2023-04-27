package com.netease.yidun.sdk.antispam.image.v5.check.sync.response;

import java.io.Serializable;
import java.util.List;

public class ImageV5FaceDetail implements Serializable {
    private static final long serialVersionUID = -8600256146020068873L;
    /**
     * 人脸数量
     */
    private Integer faceNumber;
    /**
     * ocr文本详情
     */
    private List<FaceLineContent> faceContents;

    public Integer getFaceNumber() {
        return faceNumber;
    }

    public void setFaceNumber(Integer faceNumber) {
        this.faceNumber = faceNumber;
    }

    public List<FaceLineContent> getFaceContents() {
        return faceContents;
    }

    public void setFaceContents(List<FaceLineContent> faceContents) {
        this.faceContents = faceContents;
    }

    public static class FaceLineContent implements Serializable {
        private static final long serialVersionUID = 4783217993018579962L;
        /**
         * 人名
         */
        private String name;
        /**
         * 坐标左上一个 右下一个
         */
        private Float x1;
        private Float y1;
        private Float x2;
        private Float y2;
        /**
         * cartoon（动漫脸）、normal（真人脸）
         */
        private String type;
        /**
         * star（明星）、normal（非明星）
         */
        private String category;
        /**
         * 性别
         */
        private String gender;
        /**
         * 年龄
         */
        private Integer age;
        /**
         * 人脸大小占比
         */
        private String sizeRatio;
        /**
         * 人脸颜值分类
         */
        private Float beautyScore;
        /**
         * 人脸情绪
         */
        private String expression;
        /**
         * 人脸遮挡
         */
        private String maskType;
        /**
         * 遮挡分数
         */
        private Float maskScore;
        /**
         * 成长阶段
         */
        private String growthStage;

        public String getGrowthStage() {
            return growthStage;
        }

        public void setGrowthStage(String growthStage) {
            this.growthStage = growthStage;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Float getX1() {
            return x1;
        }

        public void setX1(Float x1) {
            this.x1 = x1;
        }

        public Float getY1() {
            return y1;
        }

        public void setY1(Float y1) {
            this.y1 = y1;
        }

        public Float getX2() {
            return x2;
        }

        public void setX2(Float x2) {
            this.x2 = x2;
        }

        public Float getY2() {
            return y2;
        }

        public void setY2(Float y2) {
            this.y2 = y2;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getSizeRatio() {
            return sizeRatio;
        }

        public void setSizeRatio(String sizeRatio) {
            this.sizeRatio = sizeRatio;
        }

        public Float getBeautyScore() {
            return beautyScore;
        }

        public void setBeautyScore(Float beautyScore) {
            this.beautyScore = beautyScore;
        }

        public String getExpression() {
            return expression;
        }

        public void setExpression(String expression) {
            this.expression = expression;
        }

        public String getMaskType() {
            return maskType;
        }

        public void setMaskType(String maskType) {
            this.maskType = maskType;
        }

        public Float getMaskScore() {
            return maskScore;
        }

        public void setMaskScore(Float maskScore) {
            this.maskScore = maskScore;
        }
    }
}
