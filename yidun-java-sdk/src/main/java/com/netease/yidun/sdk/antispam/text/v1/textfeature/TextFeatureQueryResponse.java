package com.netease.yidun.sdk.antispam.text.v1.textfeature;

import com.netease.yidun.sdk.core.response.CommonResponse;

import java.util.List;

/**
 * 文本特征查询响应
 */
public class TextFeatureQueryResponse extends CommonResponse {
    private Result result;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "TextFeatureQueryResponse(" +
                "super=" + super.toString() +
                ", result=" + result +
                ")";
    }

    public static class Result {
        private Long count;
        private List<TextFeatureInfo> rows;

        public Long getCount() {
            return count;
        }

        public void setCount(Long count) {
            this.count = count;
        }

        public List<TextFeatureInfo> getRows() {
            return rows;
        }

        public void setRows(List<TextFeatureInfo> rows) {
            this.rows = rows;
        }

        @Override
        public String toString() {
            return "Result(total=" + count + ", list=" + rows + ")";
        }
    }

    public static class TextFeatureInfo {
        private String uuid;
        private String content;
        private Integer featureType;
        private Integer level;
        private Integer matchType;
        private Integer spamType;
        private String subLabel;
        private String description;
        private Integer status;
        private Long createTime;
        private Long editTime;
        private Integer scope;

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Integer getFeatureType() {
            return featureType;
        }

        public void setFeatureType(Integer featureType) {
            this.featureType = featureType;
        }

        public Integer getLevel() {
            return level;
        }

        public void setLevel(Integer level) {
            this.level = level;
        }

        public Integer getMatchType() {
            return matchType;
        }

        public void setMatchType(Integer matchType) {
            this.matchType = matchType;
        }

        public Integer getSpamType() {
            return spamType;
        }

        public void setSpamType(Integer spamType) {
            this.spamType = spamType;
        }

        public String getSubLabel() {
            return subLabel;
        }

        public void setSubLabel(String subLabel) {
            this.subLabel = subLabel;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public Long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Long createTime) {
            this.createTime = createTime;
        }

        public Long getEditTime() {
            return editTime;
        }

        public void setEditTime(Long editTime) {
            this.editTime = editTime;
        }

        public Integer getScope() {
            return scope;
        }

        public void setScope(Integer scope) {
            this.scope = scope;
        }

        @Override
        public String toString() {
            return "TextFeatureInfo(uuid=" + uuid +
                    ", content=" + content +
                    ", featureType=" + featureType +
                    ", level=" + level +
                    ", matchType=" + matchType +
                    ", spamType=" + spamType +
                    ", subLabel=" + subLabel +
                    ", description=" + description +
                    ", status=" + status +
                    ", createTime=" + createTime +
                    ", editTime=" + editTime +
                    ", scope=" + scope +
                    ")";
        }
    }
}
