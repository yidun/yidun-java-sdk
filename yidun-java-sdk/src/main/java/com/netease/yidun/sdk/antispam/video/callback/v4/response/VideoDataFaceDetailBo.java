package com.netease.yidun.sdk.antispam.video.callback.v4.response;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liangtingchen
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoDataFaceDetailBo {
    /**
     * 人脸数量
     */
    private Integer faceNumber;
    /**
     * 是否有伪造人脸 1：有 0：无
     */
    private Integer deepfake;
    /**
     * ocr文本详情
     */
    private List<FaceLineContent> faceContents;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class FaceLineContent implements Serializable {
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
         * 人脸戴眼镜
         */
        private String glasses;
        /**
         * 成长阶段，对应枚举FaceAgeRangeEnum
         */
        private String growthStage;

    }

}
