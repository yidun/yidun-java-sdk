package com.netease.yidun.sdk.antispam.crawler.v1.delete.response;

import com.netease.yidun.sdk.core.response.CommonResponse;

import java.io.Serializable;
import java.util.List;

/**
 * 公众号检测删除接口响应对象v1.0
 */
public class OfficialAccountsDeleteV1Response extends CommonResponse {

    private static final long serialVersionUID = 706776469828555314L;

    private OfficialAccountsDeleteV1Result result;

    public OfficialAccountsDeleteV1Result getResult() {
        return result;
    }

    public void setResult(OfficialAccountsDeleteV1Result result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "OfficialAccountsDeleteV1Response{" +
                "result=" + result +
                '}';
    }

    public static class OfficialAccountsDeleteV1Result implements Serializable {

        private static final long serialVersionUID = 3807710283776710191L;

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
            return "OfficialAccountsDeleteV1Result{" +
                    "deletedJobIds=" + deletedJobIds +
                    '}';
        }
    }

}
