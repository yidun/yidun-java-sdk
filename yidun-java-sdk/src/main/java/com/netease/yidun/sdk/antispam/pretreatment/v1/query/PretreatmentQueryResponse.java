package com.netease.yidun.sdk.antispam.pretreatment.v1.query;

import java.util.List;

import com.netease.yidun.sdk.core.response.CommonResponse;

/**
 * 自定义忽略词查询响应
 */
public class PretreatmentQueryResponse extends CommonResponse {

    private PretreatmentQueryResult result;

    public PretreatmentQueryResult getResult() {
        return result;
    }

    public void setResult(PretreatmentQueryResult result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "PretreatmentQueryResponse("
                + "super=" + super.toString()
                + ", result=" + result
                + ")";
    }

    public static class PretreatmentQueryResult {

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
            return "PretreatmentQueryResult("
                    + "count=" + count
                    + ", rows=" + rows
                    + ")";
        }
    }

    public static class Row {

        private Long id;
        private String entity;
        private Integer entityType;
        private Integer source;
        private String creator;
        private Long productId;
        private Long targetId;
        private Long insertTime;
        private Long lastModifyTime;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getEntity() {
            return entity;
        }

        public void setEntity(String entity) {
            this.entity = entity;
        }

        public Integer getEntityType() {
            return entityType;
        }

        public void setEntityType(Integer entityType) {
            this.entityType = entityType;
        }

        public Integer getSource() {
            return source;
        }

        public void setSource(Integer source) {
            this.source = source;
        }

        public String getCreator() {
            return creator;
        }

        public void setCreator(String creator) {
            this.creator = creator;
        }

        public Long getProductId() {
            return productId;
        }

        public void setProductId(Long productId) {
            this.productId = productId;
        }

        public Long getTargetId() {
            return targetId;
        }

        public void setTargetId(Long targetId) {
            this.targetId = targetId;
        }

        public Long getInsertTime() {
            return insertTime;
        }

        public void setInsertTime(Long insertTime) {
            this.insertTime = insertTime;
        }

        public Long getLastModifyTime() {
            return lastModifyTime;
        }

        public void setLastModifyTime(Long lastModifyTime) {
            this.lastModifyTime = lastModifyTime;
        }

        @Override
        public String toString() {
            return "Row("
                    + "id=" + id
                    + ", entity=" + entity
                    + ", entityType=" + entityType
                    + ", source=" + source
                    + ", creator=" + creator
                    + ", productId=" + productId
                    + ", targetId=" + targetId
                    + ", insertTime=" + insertTime
                    + ", lastModifyTime=" + lastModifyTime
                    + ")";
        }
    }
}
