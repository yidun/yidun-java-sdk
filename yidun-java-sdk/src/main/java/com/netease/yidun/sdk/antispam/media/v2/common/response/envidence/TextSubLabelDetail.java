package com.netease.yidun.sdk.antispam.media.v2.common.response.envidence;

import java.util.List;

/**
 * 文本标签详细信息
 */
public class TextSubLabelDetail {
    private List<Keyword> keywords;
    private List<LibInfo> libInfos;
    private List<HintInfo> hitInfos;
    private List<RuleInfo> rules;

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

    public List<RuleInfo> getRules() {
        return rules;
    }

    public void setRules(List<RuleInfo> rules) {
        this.rules = rules;
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
    }

    public static class Keyword {
        private String word;

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }
    }

    public static class RuleInfo {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
