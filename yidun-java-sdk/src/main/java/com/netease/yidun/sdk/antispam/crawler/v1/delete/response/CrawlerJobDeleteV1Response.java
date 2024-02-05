package com.netease.yidun.sdk.antispam.crawler.v1.delete.response;

import com.netease.yidun.sdk.core.response.CommonResponse;

import java.io.Serializable;
import java.util.List;

/**
 * 网站任务检测删除接口响应对象v1.0
 */
public class CrawlerJobDeleteV1Response extends CommonResponse {

    private static final long serialVersionUID = 7532586130856503000L;

    private CrawlerJobDeleteV1Result result;

    public CrawlerJobDeleteV1Result getResult() {
        return result;
    }

    public void setResult(CrawlerJobDeleteV1Result result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "CrawlerJobDeleteV1Response{" +
                "result=" + result +
                '}';
    }

    public static class CrawlerJobDeleteV1Result implements Serializable {

        private static final long serialVersionUID = -7504685743042501120L;

        /**
         * 删除成功的任务id列表
         */
        private List<Long> deletedJobIds;

        public List<Long> getDeletedJobIds() {
            return deletedJobIds;
        }

        public void setDeletedJobIds(List<Long> deletedJobIds) {
            this.deletedJobIds = deletedJobIds;
        }

        @Override
        public String toString() {
            return "CrawlerJobDeleteV1Result{" +
                    "deletedJobIds=" + deletedJobIds +
                    '}';
        }
    }

}
