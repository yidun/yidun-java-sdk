package com.netease.yidun.sdk.antispam.list.imagelist.v1.query;

import com.netease.yidun.sdk.core.response.CommonResponse;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 图片名单查询响应
 */
@Data
public class ImageListQueryResponse extends CommonResponse {
    private ImageListQueryResp result;

    @Data
    public static class ImageListQueryResp implements Serializable {
        private Long count;
        private List<Row> rows;
    }

    @Data
    public static class Row implements Serializable {
        /**
         * 业务ID
         */
        private long businessId;
        /**
         * 业务名称
         */
        private String businessName;
        /**
         * 产品名称
         */
        private String productName;
        /**
         * 图片名单的UUID
         */
        private String uuid;
        /**
         * 图片名单的Url
         */
        private String url;
        /**
         * 命中次数
         */
        private int hitCount;
        /**
         * 命中的分类标签
         */
        private int imageLabel;
        /**
         * 当前图片的状态
         */
        private int status;
        /**
         * 更新时间
         */
        private long updateTime;
        /**
         * 当前配置项是否勾选
         */
        private boolean imageLabelValid;
        /**
         * 描述信息
         */
        private String description;
        /**
         * 业务对应的产品ID
         */
        private long productId;
        /**
         * 名单类型
         */
        private int listType;
        /**
         * nosPath名单标识
         */
        private String nosPath;
        /**
         * 名单库（黑白或者md5）ImageStorageSwitchEnum
         */
        private Integer type;
    }
}
