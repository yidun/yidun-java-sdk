package com.netease.yidun.sdk.antispam.text.v1.similar;

import java.util.List;

import com.netease.yidun.sdk.core.response.CommonResponse;

/**
 * 相似文本添加响应
 */
public class SimilarTextSubmitResponse extends CommonResponse {

    private List<SimilarTextSubmitResult> result;

    public List<SimilarTextSubmitResult> getResult() {
        return result;
    }

    public void setResult(List<SimilarTextSubmitResult> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "SimilarTextSubmitResponse("
                + "super=" + super.toString()
                + ", result=" + result
                + ")";
    }

    public static class SimilarTextSubmitResult {

        /**
         * 提交的数据ID
         */
        private String dataId;

        public String getDataId() {
            return dataId;
        }

        public void setDataId(String dataId) {
            this.dataId = dataId;
        }

        @Override
        public String toString() {
            return "SimilarTextSubmitResult("
                    + "dataId=" + dataId
                    + ")";
        }
    }
}