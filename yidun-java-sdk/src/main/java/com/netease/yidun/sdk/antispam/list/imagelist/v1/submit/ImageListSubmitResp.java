package com.netease.yidun.sdk.antispam.list.imagelist.v1.submit;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author longfan
 * @version 2022-10-24
 */
@Data
public class ImageListSubmitResp implements Serializable {
    /**
     * 提交成功个数
     */
    private long success;
    /**
     * 提交失败个数
     */
    private long fail;
    /**
     * 添加成功图片唯一标识
     */
    private List<SuccessImage> successImages;

    @Data
    public static class SuccessImage implements Serializable {
        /**
         * 图片地址
         */
        private String image;
        /**
         * 图片唯一标识
         */
        private String uuid;
        /**
         * 图片md5
         */
        private String md5;
    }
}
