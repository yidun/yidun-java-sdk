package com.netease.yidun.sdk.antispam.crawler.v1.submit.response;

import com.netease.yidun.sdk.core.response.CommonResponse;

import java.util.List;

/**
 * 微博检测提交接口响应对象v1.0
 */
public class WeiboBatchSubmitV1Response extends CommonResponse {

    private static final long serialVersionUID = 1128347123649598960L;
    private List<WeiboBatchSubmitResult> result;

    public List<WeiboBatchSubmitResult> getResult() {
        return result;
    }

    public void setResult(List<WeiboBatchSubmitResult> result) {
        this.result = result;
    }

    public static class WeiboBatchSubmitResult extends WeiboSubmitV1Response.WeiboSubmitResult {
        private String dataId;

        public String getDataId() {
            return dataId;
        }

        public void setDataId(String dataId) {
            this.dataId = dataId;
        }

        @Override
        public String toString() {
            return "WeiboBatchSubmitResult{" +
                    "dataId='" + dataId + '\'' +
                    "} " + super.toString();
        }
    }

    @Override
    public String toString() {
        return "WeiboBatchSubmitV1Response{" +
                "result=" + result +
                '}';
    }
}
