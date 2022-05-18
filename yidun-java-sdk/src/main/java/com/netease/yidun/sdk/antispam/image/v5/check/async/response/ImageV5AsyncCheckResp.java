package com.netease.yidun.sdk.antispam.image.v5.check.async.response;

import com.netease.yidun.sdk.core.response.CommonResponse;

import java.io.Serializable;
import java.util.List;

public class ImageV5AsyncCheckResp extends CommonResponse {
    private static final long serialVersionUID = -1695935042456581702L;

    private ImageV5AsyncCheckResult result;

    public ImageV5AsyncCheckResult getResult() {
        return result;
    }

    public void setResult(ImageV5AsyncCheckResult result) {
        this.result = result;
    }

    public static class ImageV5AsyncCheckResult implements Serializable {
        /**
         * 检测数据标识
         */
        private List<ImageRespDetail> checkImages;
        /**
         * 缓冲池中待处理数据dealingCount
         */
        private Long dealingCount;

        public List<ImageRespDetail> getCheckImages() {
            return checkImages;
        }

        public void setCheckImages(List<ImageRespDetail> checkImages) {
            this.checkImages = checkImages;
        }

        public Long getDealingCount() {
            return dealingCount;
        }

        public void setDealingCount(Long dealingCount) {
            this.dealingCount = dealingCount;
        }
    }

    public static class ImageRespDetail implements Serializable {
        private static final long serialVersionUID = 4985375240948496401L;
        /**
         * 图片唯一标识
         */
        private String name;
        /**
         * taskId
         */
        private String taskId;
        /**
         * 客户图片唯一标识
         */
        private String dataId;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }

        public String getDataId() {
            return dataId;
        }

        public void setDataId(String dataId) {
            this.dataId = dataId;
        }
    }
}
