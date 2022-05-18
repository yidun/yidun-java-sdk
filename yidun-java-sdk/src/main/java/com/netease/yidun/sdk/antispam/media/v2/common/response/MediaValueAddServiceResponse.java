package com.netease.yidun.sdk.antispam.media.v2.common.response;

import java.util.List;

/**
 * 融媒体增值服务信息
 */
public class MediaValueAddServiceResponse {

    private Ocr ocr;
    private Face face;
    private ImageQuality imageQuality;
    private Logo logo;
    private ImageDiscern imageDiscern;
    private EmotionAnalysis emotionAnalysis;
    private Language language;

    public Ocr getOcr() {
        return ocr;
    }

    public void setOcr(Ocr ocr) {
        this.ocr = ocr;
    }

    public Face getFace() {
        return face;
    }

    public void setFace(Face face) {
        this.face = face;
    }

    public ImageQuality getImageQuality() {
        return imageQuality;
    }

    public void setImageQuality(ImageQuality imageQuality) {
        this.imageQuality = imageQuality;
    }

    public Logo getLogo() {
        return logo;
    }

    public void setLogo(Logo logo) {
        this.logo = logo;
    }

    public ImageDiscern getImageDiscern() {
        return imageDiscern;
    }

    public void setImageDiscern(ImageDiscern imageDiscern) {
        this.imageDiscern = imageDiscern;
    }

    public EmotionAnalysis getEmotionAnalysis() {
        return emotionAnalysis;
    }

    public void setEmotionAnalysis(EmotionAnalysis emotionAnalysis) {
        this.emotionAnalysis = emotionAnalysis;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "MediaValueAddServiceResponse{" +
                "ocr=" + ocr +
                ", face=" + face +
                ", imageQuality=" + imageQuality +
                ", logo=" + logo +
                ", imageDiscern=" + imageDiscern +
                ", emotionAnalysis=" + emotionAnalysis +
                ", language=" + language +
                '}';
    }

    public static class Ocr {
        private String dataId;
        private String field;
        private String taskId;
        private Integer width;
        private Integer height;
        private OcrDetail details;

        public String getDataId() {
            return dataId;
        }

        public void setDataId(String dataId) {
            this.dataId = dataId;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public OcrDetail getDetails() {
            return details;
        }

        public void setDetails(OcrDetail details) {
            this.details = details;
        }

        @Override
        public String toString() {
            return "Ocr{" +
                    "dataId='" + dataId + '\'' +
                    ", field='" + field + '\'' +
                    ", taskId='" + taskId + '\'' +
                    ", width=" + width +
                    ", height=" + height +
                    ", details=" + details +
                    '}';
        }
    }

    public static class Face {
        private List<FaceDetail> images;

        public List<FaceDetail> getImages() {
            return images;
        }

        public void setImages(List<FaceDetail> images) {
            this.images = images;
        }

        @Override
        public String toString() {
            return "Face{" +
                    "images=" + images +
                    '}';
        }
    }

    public static class ImageQuality {
        private List<ImageQualityDetail> images;

        public List<ImageQualityDetail> getImages() {
            return images;
        }

        public void setImages(List<ImageQualityDetail> images) {
            this.images = images;
        }

        @Override
        public String toString() {
            return "ImageQuality{" +
                    "images=" + images +
                    '}';
        }
    }

    public static class Logo {
        private List<LogoDetail> images;

        public List<LogoDetail> getImages() {
            return images;
        }

        public void setImages(List<LogoDetail> images) {
            this.images = images;
        }

        @Override
        public String toString() {
            return "Logo{" +
                    "images=" + images +
                    '}';
        }
    }

    public static class ImageDiscern {
        private List<ImageDiscernDetail> images;

        public List<ImageDiscernDetail> getImages() {
            return images;
        }

        public void setImages(List<ImageDiscernDetail> images) {
            this.images = images;
        }

        @Override
        public String toString() {
            return "ImageDiscern{" +
                    "images=" + images +
                    '}';
        }
    }

    public static class UserRisk {
        private List<UserRiskDetail> texts;
        private List<UserRiskDetail> images;

        public List<UserRiskDetail> getTexts() {
            return texts;
        }

        public void setTexts(List<UserRiskDetail> texts) {
            this.texts = texts;
        }

        @Override
        public String toString() {
            return "UserRisk{" +
                    "texts=" + texts +
                    ", images=" + images +
                    '}';
        }
    }

    public static class EmotionAnalysis {
        private List<EmotionAnalysisDetail> texts;

        public List<EmotionAnalysisDetail> getTexts() {
            return texts;
        }

        public void setTexts(List<EmotionAnalysisDetail> texts) {
            this.texts = texts;
        }

        @Override
        public String toString() {
            return "EmotionAnalysis{" +
                    "texts=" + texts +
                    '}';
        }
    }

    public static class Language {
        private List<LanguageDetail> texts;

        public List<LanguageDetail> getTexts() {
            return texts;
        }

        public void setTexts(List<LanguageDetail> texts) {
            this.texts = texts;
        }

        @Override
        public String toString() {
            return "Language{" +
                    "texts=" + texts +
                    '}';
        }
    }

    private static class OcrDetail {
        /**
         * ocr文本
         */
        private String content;
        /**
         * ocr文本详情
         */
        private List<OcrLineContent> lineContents;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public List<OcrLineContent> getLineContents() {
            return lineContents;
        }

        public void setLineContents(List<OcrLineContent> lineContents) {
            this.lineContents = lineContents;
        }

        @Override
        public String toString() {
            return "OcrDetail{" +
                    "content='" + content + '\'' +
                    ", lineContents=" + lineContents +
                    '}';
        }
    }

    public static class OcrLineContent {
        /**
         * 行ocr文本
         */
        private String lineContent;
        /**
         * 相对坐标
         */
        private Float x1;
        private Float y1;
        private Float x2;
        private Float y2;
        /**
         * 语种信息
         */
        private String lang;

        public String getLineContent() {
            return lineContent;
        }

        public void setLineContent(String lineContent) {
            this.lineContent = lineContent;
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

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }

        @Override
        public String toString() {
            return "OcrLineContent{" +
                    "lineContent='" + lineContent + '\'' +
                    ", x1=" + x1 +
                    ", y1=" + y1 +
                    ", x2=" + x2 +
                    ", y2=" + y2 +
                    ", lang='" + lang + '\'' +
                    '}';
        }
    }

    public static class ValueServiceBaseResponse {
        private String dataId;
        private String field;
        private String taskId;

        public String getDataId() {
            return dataId;
        }

        public void setDataId(String dataId) {
            this.dataId = dataId;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }

        @Override
        public String toString() {
            return "ValueServiceBaseResponse{" +
                    "dataId='" + dataId + '\'' +
                    ", field='" + field + '\'' +
                    ", taskId='" + taskId + '\'' +
                    '}';
        }
    }

    public static class LanguageDetail extends ValueServiceBaseResponse {
        private String type;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public static class EmotionAnalysisDetail extends ValueServiceBaseResponse {
        private Double positiveProb;
        private Double negativeProb;
        private String sentiment;

        public Double getPositiveProb() {
            return positiveProb;
        }

        public void setPositiveProb(Double positiveProb) {
            this.positiveProb = positiveProb;
        }

        public Double getNegativeProb() {
            return negativeProb;
        }

        public void setNegativeProb(Double negativeProb) {
            this.negativeProb = negativeProb;
        }

        public String getSentiment() {
            return sentiment;
        }

        public void setSentiment(String sentiment) {
            this.sentiment = sentiment;
        }
    }

    public static class UserRiskDetail extends ValueServiceBaseResponse {
        private String account;
        private Integer accountLevel;

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public Integer getAccountLevel() {
            return accountLevel;
        }

        public void setAccountLevel(Integer accountLevel) {
            this.accountLevel = accountLevel;
        }
    }

    public static class FaceDetail extends ValueServiceBaseResponse {
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
    }

    public static class LogoDetail extends ValueServiceBaseResponse {
        /**
         * logo信息
         */
        private String logoName;
        private Float x1;
        private Float y1;
        private Float x2;
        private Float y2;

        public String getLogoName() {
            return logoName;
        }

        public void setLogoName(String logoName) {
            this.logoName = logoName;
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
    }

    public static class ImageQualityDetail extends ValueServiceBaseResponse {
        /**
         * 美观度分数
         */
        private Float aestheticsRate;
        /**
         * 清晰度分数
         */
        private Float sharpnessRate;
        /**
         * 图片基本信息
         */
        private MetaInfo metaInfo;
        /**
         * 图片边框信息
         */
        private BoarderInfo boarderInfo;
        /**
         * 背景信息
         */
        private BackgroundInfo backgroundInfo;

        public Float getAestheticsRate() {
            return aestheticsRate;
        }

        public void setAestheticsRate(Float aestheticsRate) {
            this.aestheticsRate = aestheticsRate;
        }

        public Float getSharpnessRate() {
            return sharpnessRate;
        }

        public void setSharpnessRate(Float sharpnessRate) {
            this.sharpnessRate = sharpnessRate;
        }

        public MetaInfo getMetaInfo() {
            return metaInfo;
        }

        public void setMetaInfo(MetaInfo metaInfo) {
            this.metaInfo = metaInfo;
        }

        public BoarderInfo getBoarderInfo() {
            return boarderInfo;
        }

        public void setBoarderInfo(BoarderInfo boarderInfo) {
            this.boarderInfo = boarderInfo;
        }

        public BackgroundInfo getBackgroundInfo() {
            return backgroundInfo;
        }

        public void setBackgroundInfo(BackgroundInfo backgroundInfo) {
            this.backgroundInfo = backgroundInfo;
        }
    }

    public static class ImageDiscernDetail extends ValueServiceBaseResponse {
        /**
         * 识别物体类型 1 场景
         */
        private Integer type;
        /**
         * 识别名称
         */
        private String discernName;
        /**
         * 分数
         */
        private Float rate;

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public String getDiscernName() {
            return discernName;
        }

        public void setDiscernName(String discernName) {
            this.discernName = discernName;
        }

        public Float getRate() {
            return rate;
        }

        public void setRate(Float rate) {
            this.rate = rate;
        }
    }

    public static class FaceLineContent {
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
    }

    public static class BackgroundInfo {
        private boolean pureBackground = false;

        public boolean isPureBackground() {
            return pureBackground;
        }

        public void setPureBackground(boolean pureBackground) {
            this.pureBackground = pureBackground;
        }
    }

    public static class MetaInfo {
        private Long byteSize;
        private Integer height;
        private Integer width;
        private String format;

        public Long getByteSize() {
            return byteSize;
        }

        public void setByteSize(Long byteSize) {
            this.byteSize = byteSize;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public String getFormat() {
            return format;
        }

        public void setFormat(String format) {
            this.format = format;
        }
    }

    public static class BoarderInfo {
        private Boolean hit;
        private Boolean top;
        private Boolean right;
        private Boolean bottom;
        private Boolean left;

        public Boolean getHit() {
            return hit;
        }

        public void setHit(Boolean hit) {
            this.hit = hit;
        }

        public Boolean getTop() {
            return top;
        }

        public void setTop(Boolean top) {
            this.top = top;
        }

        public Boolean getRight() {
            return right;
        }

        public void setRight(Boolean right) {
            this.right = right;
        }

        public Boolean getBottom() {
            return bottom;
        }

        public void setBottom(Boolean bottom) {
            this.bottom = bottom;
        }

        public Boolean getLeft() {
            return left;
        }

        public void setLeft(Boolean left) {
            this.left = left;
        }
    }

}
