package com.netease.yidun.sdk.antispam.crawler.v1.delete.response;

import com.netease.yidun.sdk.core.response.CommonResponse;

import java.io.Serializable;
import java.util.List;

/**
 * 微博检测删除接口响应对象v1.0
 */
public class WeiboDeleteV1Response extends CommonResponse {
    private static final long serialVersionUID = -132348547870015129L;
    private WeiboDeleteV1Result result;

    public WeiboDeleteV1Result getResult() {
        return result;
    }

    public void setResult(WeiboDeleteV1Result result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "OfficialAccountsDeleteV1Response{" +
                "result=" + result +
                '}';
    }

    public static class WeiboDeleteV1Result implements Serializable {

        private static final long serialVersionUID = -4835388608306624471L;
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
            return "WeiboDeleteV1Result{" +
                    "deletedJobIds=" + deletedJobIds +
                    '}';
        }
    }

}
