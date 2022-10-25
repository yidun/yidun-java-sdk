package com.netease.yidun.sdk.antispam.list.user.v2.query;

import com.netease.yidun.sdk.core.response.CommonResponse;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 图片名单查询响应
 */
@Data
public class ListQueryResponse extends CommonResponse {
    private ListQueryResp result;

    @Data
    public static class ListQueryResp implements Serializable {
        private Long count;
        private List<Row> rows;
    }

    @Data
    public static class Row implements Serializable {
        private String uuid;
        private Long productId;
        private Long targetId;
        private Integer entityType;
        private String entity;
        private Integer listType;
        private Long releaseTime;
        private Long insertTime;
        private Long updateTime;
        private String operator;
        private String description;
        private String ext;
        private Integer spamType;
        private Integer source;
        private Long hitCount = 0L;
        private Integer status;
    }
}
