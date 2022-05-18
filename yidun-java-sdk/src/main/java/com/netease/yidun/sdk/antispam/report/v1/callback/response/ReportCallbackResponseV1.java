
package com.netease.yidun.sdk.antispam.report.v1.callback.response;

import java.util.List;

import com.netease.yidun.sdk.antispam.media.v2.common.response.MediaAntispamResponse;
import com.netease.yidun.sdk.antispam.media.v2.common.response.MediaCensorResponse;
import com.netease.yidun.sdk.core.response.CommonResponse;

/**
 * 投诉举报v1版本回调结果
 */
public class ReportCallbackResponseV1 extends CommonResponse {

    private List<ReportCheckResult> result;

    public List<ReportCheckResult> getResult() {
        return result;
    }

    public void setResult(List<ReportCheckResult> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ReportCallbackResponseV1{" +
                "result=" + result +
                '}';
    }

    public static class ReportCheckResult {
        /**
         * 反垃圾结果
         */
        private MediaAntispamResponse antispam;

        /**
         * 审核嘻嘻
         */
        private MediaCensorResponse censor;

        public MediaAntispamResponse getAntispam() {
            return antispam;
        }

        public void setAntispam(MediaAntispamResponse antispam) {
            this.antispam = antispam;
        }

        public MediaCensorResponse getCensor() {
            return censor;
        }

        public void setCensor(MediaCensorResponse censor) {
            this.censor = censor;
        }

        @Override
        public String toString() {
            return "MediaCheckResult{" +
                    "antispam=" + antispam +
                    ", censor=" + censor +
                    '}';
        }
    }
}
