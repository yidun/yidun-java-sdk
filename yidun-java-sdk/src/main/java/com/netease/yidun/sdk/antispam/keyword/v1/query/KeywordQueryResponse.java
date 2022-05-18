package com.netease.yidun.sdk.antispam.keyword.v1.query;

import java.util.List;

import com.netease.yidun.sdk.core.response.CommonResponse;

/**
 * 自定义关键词删除响应
 */
public class KeywordQueryResponse extends CommonResponse {

    private KeywordQueryResult result;

    public KeywordQueryResult getResult() {
        return result;
    }

    public void setResult(KeywordQueryResult result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "KeywordQueryResponse("
                + "super=" + super.toString()
                + ", result=" + result
                + ")";
    }

    public static class KeywordQueryResult {

        private Words words;

        public Words getWords() {
            return words;
        }

        public void setWords(Words words) {
            this.words = words;
        }

        @Override
        public String toString() {
            return "KeywordQueryResult("
                    + "words=" + words
                    + ")";
        }
    }

    public static class Words {

        private Long count;
        private List<Row> rows;

        public Long getCount() {
            return count;
        }

        public void setCount(Long count) {
            this.count = count;
        }

        public List<Row> getRows() {
            return rows;
        }

        public void setRows(List<Row> rows) {
            this.rows = rows;
        }

        @Override
        public String toString() {
            return "Words("
                    + "count=" + count
                    + ", rows=" + rows
                    + ")";
        }
    }

    public static class Row {

        private Long id;
        private String word;
        private Integer category;
        private String subLabel;
        private Integer type;
        private Integer status;
        private Integer level;
        private Integer productId;
        private Integer targetId;
        private Long updateTime;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public Integer getCategory() {
            return category;
        }

        public void setCategory(Integer category) {
            this.category = category;
        }

        public String getSubLabel() {
            return subLabel;
        }

        public void setSubLabel(String subLabel) {
            this.subLabel = subLabel;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public Integer getLevel() {
            return level;
        }

        public void setLevel(Integer level) {
            this.level = level;
        }

        public Integer getProductId() {
            return productId;
        }

        public void setProductId(Integer productId) {
            this.productId = productId;
        }

        public Integer getTargetId() {
            return targetId;
        }

        public void setTargetId(Integer targetId) {
            this.targetId = targetId;
        }

        public Long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Long updateTime) {
            this.updateTime = updateTime;
        }

        @Override
        public String toString() {
            return "Row("
                    + "id=" + id
                    + ", word=" + word
                    + ", category=" + category
                    + ", subLabel=" + subLabel
                    + ", type=" + type
                    + ", status=" + status
                    + ", level=" + level
                    + ", productId=" + productId
                    + ", targetId=" + targetId
                    + ", updateTime=" + updateTime
                    + ")";
        }
    }
}
