package com.netease.yidun.sdk.antispam.digitalbook.v2.submit.response;

import com.netease.yidun.sdk.antispam.media.v2.common.response.MediaAntiCheatResponse;
import com.netease.yidun.sdk.antispam.media.v2.common.response.MediaAntispamResponse;
import com.netease.yidun.sdk.antispam.media.v2.common.response.MediaValueAddServiceResponse;
import com.netease.yidun.sdk.core.response.CommonResponse;

/**
 * 数字阅读v2版本提交接口返回结果
 */
public class DigitalBookCheckResponseV2 extends CommonResponse {

    private MediaCheckResult result;

    public MediaCheckResult getResult() {
        return result;
    }

    public void setResult(MediaCheckResult result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "DigitalBookCheckResponseV2{" +
                "result=" + result +
                '}';
    }

    public static class MediaCheckResult {
        /**
         * 反垃圾结果
         */
        private MediaAntispamResponse antispam;
        /**
         * 增值服务结果
         */
        private MediaValueAddServiceResponse valueAddService;

        /**
         * 反作弊信息
         */
        private MediaAntiCheatResponse anticheat;

        public MediaAntispamResponse getAntispam() {
            return antispam;
        }

        public void setAntispam(MediaAntispamResponse antispam) {
            this.antispam = antispam;
        }

        public MediaValueAddServiceResponse getValueAddService() {
            return valueAddService;
        }

        public void setValueAddService(MediaValueAddServiceResponse valueAddService) {
            this.valueAddService = valueAddService;
        }

        public MediaAntiCheatResponse getAnticheat() {
            return anticheat;
        }

        public void setAnticheat(MediaAntiCheatResponse anticheat) {
            this.anticheat = anticheat;
        }

        @Override
        public String toString() {
            return "MediaCheckResult{" +
                    "antispam=" + antispam +
                    ", valueAddService=" + valueAddService +
                    ", anticheat=" + anticheat +
                    '}';
        }
    }
}
