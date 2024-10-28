package com.netease.yidun.sdk.antispam.file.v2.callback.response;

import java.util.List;

/**
 * 文本标签详细信息
 */
@Deprecated
public class TextSubLabelDetail {
    private List<Keyword> keywords;
    private List<LibInfo> libInfos;
    private List<HintInfo> hitInfos;

    public List<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }

    public List<LibInfo> getLibInfos() {
        return libInfos;
    }

    public void setLibInfos(List<LibInfo> libInfos) {
        this.libInfos = libInfos;
    }

    public List<HintInfo> getHitInfos() {
        return hitInfos;
    }

    public void setHitInfos(List<HintInfo> hitInfos) {
        this.hitInfos = hitInfos;
    }

    @Override
    public String toString() {
        return "TextSubLabelDetail{" +
                "keywords=" + keywords +
                ", libInfos=" + libInfos +
                ", hitInfos=" + hitInfos +
                '}';
    }

    public static class HintInfo {
        private String value;
        private List<HintInfoPosition> positions;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public List<HintInfoPosition> getPositions() {
            return positions;
        }

        public void setPositions(List<HintInfoPosition> positions) {
            this.positions = positions;
        }

        @Override
        public String toString() {
            return "HintInfo{" +
                    "value='" + value + '\'' +
                    ", positions=" + positions +
                    '}';
        }
    }

    public static class HintInfoPosition {
        private String fieldName;
        private Integer startPos;
        private Integer endPos;

        public String getFieldName() {
            return fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public Integer getStartPos() {
            return startPos;
        }

        public void setStartPos(Integer startPos) {
            this.startPos = startPos;
        }

        public Integer getEndPos() {
            return endPos;
        }

        public void setEndPos(Integer endPos) {
            this.endPos = endPos;
        }

        @Override
        public String toString() {
            return "HintInfoPosition{" +
                    "fieldName='" + fieldName + '\'' +
                    ", startPos=" + startPos +
                    ", endPos=" + endPos +
                    '}';
        }
    }

    public static class LibInfo {
        private Integer type;
        private String entity;

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public String getEntity() {
            return entity;
        }

        public void setEntity(String entity) {
            this.entity = entity;
        }

        @Override
        public String toString() {
            return "LibInfo{" +
                    "type=" + type +
                    ", entity='" + entity + '\'' +
                    '}';
        }
    }

    public static class Keyword {
        private String word;

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        @Override
        public String toString() {
            return "Keyword{" +
                    "word='" + word + '\'' +
                    '}';
        }
    }
}
