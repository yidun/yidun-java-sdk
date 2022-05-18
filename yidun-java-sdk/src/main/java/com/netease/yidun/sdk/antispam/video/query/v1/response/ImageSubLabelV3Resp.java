package com.netease.yidun.sdk.antispam.video.query.v1.response;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageSubLabelV3Resp implements Serializable {
    private static final long serialVersionUID = 5633857106221598752L;
    /**
     * 对外的图片label
     */
    private int subLabel;
    /**
     * 判断结果，0-正常，1-不确定，2-确定
     */
    private float rate;
    /**
     * 得分，范围为0到1
     */
    private SubLabelDetails details;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SubLabelDetails implements Serializable {
        /**
         * 命中信息，包含规则，敏感词，图片模型结果
         */
        private Set<String> hitInfos;
        /**
         * 反作弊结果
         */
        private AnticheatInfo anticheatInfo;
        /**
         * 图片命中标签信息
         */
        private List<ImageTagInfo> imageTagInfos;
        /**
         * 命中用户添加图片名单信息
         */
        private List<ImageListInfo> imageListInfos;
        /**
         * 命中内容证据信息
         */
        private List<HitLocationInfo> hitLocationInfos;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AnticheatInfo implements Serializable {
        private Integer hitType;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ImageTagInfo implements Serializable {
        private String tagName;
        private String tagGroup;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ImageListInfo implements Serializable {
        public static final Integer IMAGE_URL_LIST = 1;
        public static final Integer KEYWORD = 2;
        /**
         * 1为自定义图片名单，2为自定义敏感词
         */
        private Integer type;
        private String url;
        private Integer hitCount;
        private String word;
        private String tagName;
        private String tagGroup;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class HitLocationInfo implements Serializable {
        /**
         * 命中信息
         */
        private String hitInfo;
        /**
         * 坐标左上一个 右下一个
         */
        private Float x1;
        private Float y1;
        private Float x2;
        private Float y2;
    }
}
