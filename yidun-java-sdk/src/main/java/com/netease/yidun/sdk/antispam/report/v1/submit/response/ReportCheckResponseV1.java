package com.netease.yidun.sdk.antispam.report.v1.submit.response;

import com.netease.yidun.sdk.antispam.media.v2.common.response.MediaAntispamResponse;
import com.netease.yidun.sdk.core.response.CommonResponse;

/**
 * 举报v1版本提交接口返回结果
 */
public class ReportCheckResponseV1 extends CommonResponse {

    private MediaCheckResult result;

    public MediaCheckResult getResult() {
        return result;
    }

    public void setResult(MediaCheckResult result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ReportCheckResponseV1{" +
                "result=" + result +
                '}';
    }

    public static class MediaCheckResult {
        /**
         * 反垃圾结果
         */
        private MediaAntispamResponse antispam;

        public MediaAntispamResponse getAntispam() {
            return antispam;
        }

        public void setAntispam(MediaAntispamResponse antispam) {
            this.antispam = antispam;
        }

        @Override
        public String toString() {
            return "MediaCheckResult{" +
                    "antispam=" + antispam +
                    '}';
        }
    }
}
