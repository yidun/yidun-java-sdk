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
     * 是否有伪造人脸，0：无，1：有
     */
    private Integer deepfake;
    /**
     * 人脸详情
     */
    private List<FaceLineContent> faceContents;

    public Integer getFaceNumber() {
        return faceNumber;
    }

    public void setFaceNumber(Integer faceNumber) {
        this.faceNumber = faceNumber;
    }

    public Integer getDeepfake() {
        return deepfake;
    }

    public void setDeepfake(Integer deepfake) {
        this.deepfake = deepfake;
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
        /**
         * 人脸角度list
         */
        private List<FacePoseInfo> poseInfoList;
        /**
         * 人脸完整性
         * 0：不完整，1：完整，2: 未知
         */
        private Integer completeness;
        /**
         * 人脸是否旋转
         */
        private Boolean rotation;
        /**
         * 人脸旋转角度
         */
        private Double rotationAngle;
        /**
         * 是否未成年人
         */
        private Integer underage;

        public Integer getUnderage() {
            return underage;
        }

        public void setUnderage(Integer underage) {
            this.underage = underage;
        }

        public Boolean getRotation() {
            return rotation;
        }

        public void setRotation(Boolean rotation) {
            this.rotation = rotation;
        }

        public Double getRotationAngle() {
            return rotationAngle;
        }

        public void setRotationAngle(Double rotationAngle) {
            this.rotationAngle = rotationAngle;
        }

        public Integer getCompleteness() {
            return completeness;
        }

        public void setCompleteness(Integer completeness) {
            this.completeness = completeness;
        }
        
        public static class FacePoseInfo implements Serializable {
            private static final long serialVersionUID = -5971991704526674256L;
            /**
             * 人脸角度标签
             */
            private String label;
            /**
             * 人脸角度值
             */
            private Double angle;

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public Double getAngle() {
                return angle;
            }

            public void setAngle(Double angle) {
                this.angle = angle;
            }
        }

        public List<FacePoseInfo> getPoseInfoList() {
            return poseInfoList;
        }

        public void setPoseInfoList(List<FacePoseInfo> poseInfoList) {
            this.poseInfoList = poseInfoList;
        }

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
